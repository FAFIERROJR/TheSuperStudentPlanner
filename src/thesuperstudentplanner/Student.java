/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thesuperstudentplanner;

import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dania Wareh
 * @author Francisco Fierro
 */
public class Student extends User{
    
    public Student(){}
    
    
    public Student(String username){
        setUsername(username);
    }
    
    public Student(String username, ArrayList<String> cls){
        setUsername(username);
        setClasses(cls);
    }
    
    /**
     *
     * @param conn          the connection to the database
     * @param title         the title of the appointment
     * @param desc          description of the appointment
     * @param date          date of appointment
     * @param startTime     time appt starts
     * @param endTime       time appt ends
     * @return
     */
 
    @Override
    public boolean makeAppt(Connection conn, Appointment app){
        try {
            Statement stmt = conn.createStatement();
            System.out.println(app.getDate());
            System.out.println(app.getStartTime());
            System.out.println(app.getEndTime());
            
            String cmd = "INSERT INTO appointments "
                + "VALUES ("
                + "'"
                + app.getTitle() + "', '"
                + app.getDate() + "', '"
                + app.getStartTime() + "', '"
                + app.getEndTime() + "',"
                + app.getUsername() + ")";
            
            
           System.out.println("THIS IS THE CMD: " + cmd);
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
                    + "TITLE = '" + newApp.getTitle() + "', "
                    + "DATE = '" + newApp.getDate() + "', "
                    + "STARTTIME = '" + newApp.getStartTime() + "', "
                    + "ENDTIME = '" + newApp.getEndTime() + "', " 
                     + "studentusername = " + newApp.getUsername() + " "
                    + "WHERE "
                    + "STUDENTUSERNAME = " + oldApp.getUsername() + " AND "
                    + "DATE = '" + oldApp.getDate() + "' AND "
                    + "STARTTIME = '" + oldApp.getStartTime() + "' AND "
                    + "ENDTIME = '" + oldApp.getEndTime() + "'";
                    
            System.out.println(cmd);
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
            
            String cmd = "SELECT * "
                + "FROM appointments "
                + "WHERE "
                + "STUDENTUSERNAME = " + getUsername() + " AND "
                + "DATE >= '" + startDate + "' AND "
                    + "DATE <= '" + endDate + "'";
            System.out.println("GET CALENDAR RANGE" + cmd);
            ResultSet rs = stmt.executeQuery(cmd);
            
            ArrayList<Appointment> apps = new ArrayList<Appointment>();
            
            while(rs.next()){
                apps.add(new Appointment(
                    rs.getString("STUDENTUSERNAME"),
                    rs.getString("TITLE"),
                    rs.getString("DATE"),
                    rs.getString("STARTTIME"),
                    rs.getString("ENDTIME")
                ));
            }
            return apps;
        } catch (SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    /**
     *
     * @param conn             connection to database
     * @param oldpassword      user's old password
     * @param newPassword      user's new password
     * @return
     */
    @Override
    public  boolean changePassword(Connection conn, String oldPassword, String newPassword){
        try {
            Statement stmt = conn.createStatement();
            
            String query = "SELECT password "
                    + "FROM STUDENTS "
                    + "WHERE STUDENTUSERNAME = " + getUsername();
            
            ResultSet rs = stmt.executeQuery(query);
            
            if(rs.getString("PASSWORD") == oldPassword){
                query = "UPDATE students "
                        + "SET password = '" + newPassword + "' "
                        + "WHERE STUDENTUSERNAME =" + getUsername() + "";
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
     * @param username          Username of account owner
     * @param newClasses        classes of new account owner
     * @return
     */
    @Override
    public  boolean createAccount(Connection conn, String name, String username, ArrayList<String> newClasses){
        System.out.println("No!...Stop it!");
        return false;
    }
    
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
                    + "AND endtime = ? "
                    + "AND studentusername = ? ";
            
            System.out.println("THIS IS THE CANCEL APPT CMD: " + cmd);
            PreparedStatement pstmt = conn.prepareStatement(cmd);

                pstmt.setString(1, app.getTitle());
                pstmt.setString(2, app.getDate());
                pstmt.setString(3, app.getStartTime());
                pstmt.setString(4, app.getEndTime());
                pstmt.setString(5, app.getUsername());
           
           pstmt.execute();
         
            return true;
       
        } catch (SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
}
