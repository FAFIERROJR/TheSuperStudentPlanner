/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thesuperstudentplanner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import org.joda.time.*;


/**
 *
 * @author daniawareh
 */
public class Calendar {
  
   private DefaultTableModel model;
   private String className;
   private Object table[][];
   private boolean colorCell[][];
   private String[] titles;
   
   public boolean[][] getColorCell(){
        return colorCell;
}
   
   
   public DefaultTableModel createTableModel(User user, String startDate, String endDate){
       try
        {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
             //Get a connection
            Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/TheSuperStudentPlannerDB"); 
            ArrayList <Appointment> apps = user.getCalendarRange(conn, startDate, endDate,className);
           
            int size = 0;
            String startDateArr[] = startDate.split("-");
            int startYear = Integer.parseInt(startDateArr[0]);
            int startMonth = Integer.parseInt(startDateArr[1]);
            int startDay = Integer.parseInt(startDateArr[2]);
        
            String endDateArr[] = endDate.split("-");
            int endYear = Integer.parseInt(endDateArr[0]);
            int endMonth = Integer.parseInt(endDateArr[1]);
            int endDay = Integer.parseInt(endDateArr[2]);
        
            int rowIndex;
            int columnIndex;
            
           
            LocalDate sDate = new LocalDate(startYear,  startMonth, startDay);
            LocalDate eDate= new LocalDate(endYear,  endMonth, endDay);
            int daysBetween = Days.daysBetween(eDate, sDate).getDays();
            size = daysBetween +2;
            colorCell = new boolean [size][size];
            table = new Object[size][size];

           for(Appointment app : apps){
              int endHour = app.getEHour();
              int endMinute = app.getEMinute();
             
              int startHour = app.getSHour();
              int startMinute = app.getSMinute();
              LocalDate appDate = new LocalDate(app.getYear(), app.getMonth(), app.getDay());
              int span = (endHour - startHour)*2;
              int minDifference = endMinute - startMinute;
              
              if(minDifference == 30){//add a box for the half hour
                  span ++;
                  
              }
              else if (minDifference == -30){ //subtract a box for the half hour
                  span --;
              }
          
              
              rowIndex = startHour * 2;
              columnIndex = Days.daysBetween(appDate, sDate).getDays() + 1;
              if (startMinute == 30){
                  rowIndex++;
              }
      
               table [rowIndex][columnIndex]= app.toString(); 
               for (int i = 0 ; i< rowIndex + span; i++){ 
                   colorCell[rowIndex + i][columnIndex]= true; 
                   
               }
          System.out.println(table[rowIndex][columnIndex]);
     
           }//end of (Appointment app : apps)
           
           
           titles = new String[size];
           LocalDate currentDate = sDate;
           
           for( int i = 1; i < size ; i++ ) { //(0,0) cell is null. start at 1
               titles[i] = currentDate.toString("MM/dd/yyyy"); //set the start day
               currentDate = currentDate.plusDays(1); //increment to the next day
           }

        }
        catch (Exception except)
        {
            except.printStackTrace();
        }
       model = new DefaultTableModel(table, titles);
       return model;
   }

}// end of class Calendar
