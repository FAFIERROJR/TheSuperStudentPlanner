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
 * @author Daniah Wareh
 * @author Francisco Fierro
 */
public abstract class User {
    private ArrayList<String> classes;
    private String id;
    
    /**
     *
     */
    public User(){}
     
    public String getID(){
        return id;
    }
   
    public void setID(String id){
        this.id = id;
    }
    
    public void setClasses(ArrayList<String> c){
        classes = null;
        for(String s : c){
            classes.add(s);
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
    public abstract boolean makeAppt(Connection conn, String title, String desc, String date, String startTime, String endTime);
            
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
    public abstract boolean changeAppt(Connection conn, String title, String desc, String date, String startTime, String endTime);
    
    /**
     *
     * @param conn          connection to database
     * @param startDate     begin date of range
     * @param endDate       end date of range
     * @param className     name of class to limit to (optional)
     * @return
     */
    public abstract boolean getCalendarRange(Connection conn, String startDate, String endDate, String className);
    
    /**
     *
     * @param conn             connection to database
     * @param oldpassword      user's old password
     * @param newPassword      user's new password
     * @return
     */
    public abstract boolean changePassword(Connection conn, String oldpassword, String newPassword);
    
    /**
     *
     * @param conn              connection to database
     * @param name              name of account owner
     * @param ID                school ID of account owner
     * @param newClasses        classes of new account owner
     * @return
     */
    public abstract boolean createAccount(Connection conn, String name, String ID, ArrayList<String> newClasses);
    
    
}
