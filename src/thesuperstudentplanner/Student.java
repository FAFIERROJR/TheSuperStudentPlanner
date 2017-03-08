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
    public boolean makeAppt(Connection conn, String title, String desc, String date, String startTime, String endTime){
        try {
            Statement stmt = conn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }
        String cmd = "INSERT INTO appointments"
                + "VALUES ("
                + getID() + ", "
                + title + ", "
                + desc + ", "
                + date + ", "
                + startTime + ", "
                + endTime + ");";
        
        return true;
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
    public boolean changeAppt(Connection conn, String title, String desc, String date, String startTime, String endTime){
        try {
            Statement stmt = conn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }
        String cmd = "INSERT INTO appointments"
                + "VALUES ("
                + getID() + ", "
                + title + ", "
                + desc + ", "
                + date + ", "
                + startTime + ", "
                + endTime + ");";
        
        return true;
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
    public  boolean getCalendarRange(Connection conn, String startDate, String endDate, String className){
        try {
            Statement stmt = conn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }
        String cmd = "INSERT INTO appointments"
                + "VALUES ("
                + getID() + ", "
                + startDate + ", "
                + endDate+ ", "
                + className + ", ";
        
        return true;
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
        } catch (SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }
        String cmd = "INSERT INTO appointments"
                + "VALUES ("
                + getID() + ", "
                + oldPassword + ", "
                + newPassword + ", ";
        
        return true;
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
    public  boolean createAccount(Connection conn, String name, String ID, ArrayList<String> newClasses){
        System.out.println("No!...Stop it!");
        return false;
    }
    
}
