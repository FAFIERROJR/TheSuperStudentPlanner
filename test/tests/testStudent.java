/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;
import thesuperstudentplanner.Appointment;
import thesuperstudentplanner.Student;

/**
 *
 * @author daniawareh
 */
public class testStudent {
      public static void main(String [] args){
          try
        {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            //Get a connection
            Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/TheSuperStudentPlannerDB"); 
            //run create DB only once
            //createDB(conn);
               
        Student stnt = new Student();
        
        testMakeApp(stnt, conn);
        
        }
        catch (Exception except)
        {
            except.printStackTrace();
        }
          
       
    }
      
      private static void testMakeApp(Student stnt, Connection conn ){
        Appointment app = new Appointment();
        Scanner in = new Scanner(System.in);
        System.out.println("Input SID");
        String sid = in.next();
        System.out.println("Input title of appointment");
        String title = in.next();
        System.out.println("Input start time:");
        String time = in.next();
        System.out.println("Input end time:");
        String endTime = in.next();

        
    }
      
      
      
      
    
    
}
