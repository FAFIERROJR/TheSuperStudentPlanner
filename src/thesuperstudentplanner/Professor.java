/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thesuperstudentplanner;

import java.sql.Connection;
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
    
    public Professor(String id){
        setID(id);
    }
    
    public Professor(String id, ArrayList<String> cls){
        setID(id);
        setClasses(cls);
        
    }
    
    
    @Override
    public boolean makeAppt(Connection conn, Appointment app){
        try {
            Statement stmt = conn.createStatement();
            
            String cmd = "INSERT INTO appointments "
                + "VALUES ("
                + app.getID() + ", '"
                + app.getTitle() + "', '"
                + app.getDay() + "', '"
                + app.getDate() + "', '"
                + app.getStartTime() + "', '"
                + app.getEndTime() + "');";
        
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
                    + "SID = '" + newApp.getID() + "', "
                    + "TITLE = '" + newApp.getTitle() + "', "
                    + "DAY = '" + newApp.getDay() + "', "
                    + "DATE = '" + newApp.getDate() + "', "
                    + "STARTTIME = '" + newApp.getStartTime() + "', "
                    + "ENDTIME = '" + newApp.getEndTime() + "') "
                    + "WHERE "
                    + "SID = '" + oldApp.getID() + "', "
                    + "DATE = '" + oldApp.getDate() + "', "
                    + "STARTTIME = '" + oldApp.getStartTime() + "', "
                    + "ENDTIME = '" + oldApp.getEndTime() + "';";
            
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
                + "ENDDATE <= '" + endDate + "' AND"
                + "title = '" + className + "' ";
        
            ResultSet rs = stmt.executeQuery(cmd);
            
            ArrayList<Appointment> apps = new ArrayList<Appointment>();
            
            do{
                apps.add(new Appointment(
                    null,
                    rs.getString("TITLE"),
                    rs.getString("DAY"),
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
                    + "WHERE SID = " + getID();
            
            ResultSet rs = stmt.executeQuery(query);
            
            if(rs.getString("PASSWORD") == oldPassword){
                query = "UPDATE students "
                        + "SET password = '" + newPassword + "' "
                        + "WHERE SID =" + getID() + "";
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
     * @param ID                school ID of account owner
     * @param newClasses        classes of new account owner
     * @return
     */
    @Override
    public  boolean createAccount(Connection conn, String name, String id, ArrayList<String> newClasses){
        try {
            Statement stmt = conn.createStatement();
            
            String query = "INSERT INTO students "
                    + "values ('"
                    + id + "', '"
                    + name +  "';";
            
            stmt.execute(query);
            
            
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
}
