/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thesuperstudentplanner;

/**
 *
 * @author Francisco
 */
public class Appointment {
    
    private String dayOfWeek; //day of the week "Monday, Tuesday, etc.." 
    private int day; //day of the month in integer 
    private int hour; //hour of the appointment
    private int minute;
    private String title;
    
    public String getDayOfWeek(){
        return dayOfWeek;
    }
    
    public int getDay(){
        return day;
    }
    
    public int getHour(){
        return hour;
    }
    
    public int getMinute(){
        return minute;
    }
    
    public String getTitle(){
        return title;
    }
    
      public void setDayOfWeek(String dw){
        dayOfWeek = dw;
    }
    
    public void setDay(int d){
        day = d;
    }
    
    public void setHour(int h){
        hour = h;
    }
    
    public void setMinute(int m){
        minute = m;
    }
    
    public void setTitle(String t){
        title = t;
    }

    
}
