/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thesuperstudentplanner;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Francisco
 */
public class Professor extends User{
    public Professor(){}
    
    public Professor(String username){
        setUsername(username);
    }
    
    public Professor(String username, ArrayList<String> cls){
        setUsername(username);
        setClasses(cls);
        
    }
    
    
    @Override
    public boolean makeAppt(Connection conn, Appointment app){
        try {
            Statement stmt = conn.createStatement();
            
            String cmd = "INSERT INTO appointments "
                + "VALUES ("
                + app.getUsername() + ", '"
                + app.getTitle() + "', '"
                + app.getDate() + "', '"
                + app.getStartTime() + "', '"
                + app.getEndTime() + "')";
        
            stmt.execute(cmd);
            return true;
       
        } catch (SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
            
    /**
     *
     * @param conn          the connection to the database
     * @param newApp
     * @param oldApp
     * @param title         the title of the appointment
     * @param desc          description of the appointment
     * @param date          date of appointment
     * @param startTime     time appt starts
     * @param endTime       time appt ends
     * @return
     */
    @Override
    public boolean changeAppt(Connection conn, Appointment newApp, Appointment oldApp){
        try {
            Statement stmt = conn.createStatement();
            
            String cmd = "UPDATE appointments "
                    + "SET "
//                    + "STUDENTUSERNAME = '" + newApp.getUsername() + "', "
                    + "TITLE = '" + newApp.getTitle() + "', "
                    + "DATE = '" + newApp.getDate() + "', "
                    + "STARTTIME = '" + newApp.getStartTime() + "', "
                    + "ENDTIME = '" + newApp.getEndTime() + "') "
                    + "WHERE "
//                    + "STUDENTUSERNAME = '" + oldApp.getUsername() + "', "
                    + "DATE = '" + oldApp.getDate() + "', "
                    + "STARTTIME = '" + oldApp.getStartTime() + "', "
                    + "ENDTIME = '" + oldApp.getEndTime() + "'";
            
            stmt.execute(cmd);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
  
    }
    
    /**
     *
     * @param conn          connection to database
     * @param startDate     begin date of range
     * @param endDate       end date of range
     * @param className     name of class to limit to (optional)
     * @return
     */
    @Override
    public  ArrayList<Appointment> getCalendarRange(Connection conn, String startDate, String endDate, String className){
        try {
            Statement stmt = conn.createStatement();
            
            String cmd = "SELECT DISTINCT title, day, date, starttime, endtime"
                + "FROM appointments "
                + "WHERE "
                + "DATE >= '" + startDate + "' AND "
                + "ENDDATE <= '" + endDate + "'";
//                + "title = '" + className + "' ";
        
            ResultSet rs = stmt.executeQuery(cmd);
            
            ArrayList<Appointment> apps = new ArrayList<Appointment>();
            
            do{
                apps.add(new Appointment(
                    null,
                    rs.getString("TITLE"),
                    rs.getString("DATE"),
                    rs.getString("STARTTIME"),
                    rs.getString("ENDTIME")
                ));
            return apps;
            }while(rs.next());
        } catch (SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    /**
     *
     * @param conn             connection to database
     * @param oldPassword
     * @param newPassword      user's new password
     * @return
     */
    @Override
    public  boolean changePassword(Connection conn, String oldPassword, String newPassword){
        try {
            Statement stmt = conn.createStatement();
            
            String query = "SELECT password "
                    + "FROM STUDENTS "
                    + "WHERE PROFUSERNAME = " + getUsername();
            
            ResultSet rs = stmt.executeQuery(query);
            
            if(rs.getString("PASSWORD") == oldPassword){
                query = "UPDATE professors "
                        + "SET password = '" + newPassword + "' "
                        + "WHERE PROFUSERNAME =" + getUsername() + "";
            }
            
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    /**
     *
     * @param conn              connection to database
     * @param name              name of account owner
     * @param username                school Username of account owner
     * @param newClasses        classes of new account owner
     * @return
     */
    @Override
    public  boolean createAccount(Connection conn, String name, String username, ArrayList<String> newClasses){
        try {
            Statement stmt = conn.createStatement();
            
            String query = "INSERT INTO students "
                    + "values ('"
                    + username + "', '"
                    + name +  "'";
            
            stmt.execute(query);
            
            
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    /**
     *
     * @param conn
     * @param app
     * @return
     */
    @Override
    public boolean cancelAppt(Connection conn, Appointment app){
        try {
            System.out.println(app.getDate());
            System.out.println(app.getStartTime());
            System.out.println(app.getEndTime());
         
            String cmd = "DELETE FROM appointments "
                + "WHERE "
                    + "title = ? "
                    + "AND date = ? "
                    + "AND starttime = ? "
                    + "AND endtime = ? ";
            
            System.out.println("THIS IS THE CANCEL APPT CMD: " + cmd);
            PreparedStatement pstmt = conn.prepareStatement(cmd);

                pstmt.setString(1, app.getTitle());
                pstmt.setString(2, app.getDate());
                pstmt.setString(3, app.getStartTime());
                pstmt.setString(4, app.getEndTime());
                
           System.out.println("THIS IS THE CANCEL APPT CMD: " + cmd);
           pstmt.execute();
         
            return true;
       
        } catch (SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
}
