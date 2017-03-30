/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thesuperstudentplanner;

/**
 *
 * @author Dania Wareh
 * @author Francisco Fierro
 */
public class Appointment {
    
    private String dayOfWeek; //day of the week "Monday, Tuesday, etc.." 
    private String username; //student id
    private int day; //day of month as int
    private int month; //month as int
    private int year;
    private int sHour; //start hour of the appointment
    private int sMinute; //start minute of the appointment
    private int eHour;
    private int eMinute;
    private String title;
    
    public Appointment(){}
    
    public Appointment(String id, String t, int d, int m, int y, int sh,
            int sm, int eh, int em){
        
        username = id;
        title = t;
        day = d;
        month = m;
        year = y;
        sHour = sh;
        sMinute = sm;
        eHour = eh;
        eMinute = em;   
    }
    
    public Appointment(String id, String t, String dt, String st, String et){
        username = id;
        title = t;
        
        String dateArr[] = dt.split("-");
        System.out.println(dateArr[0]);
        year = Integer.parseInt(dateArr[0]);
        System.out.println(dateArr[1]);
        month = Integer.parseInt(dateArr[1]);
        System.out.println(getMonth());
        System.out.println(dateArr[2]);
        day = Integer.parseInt(dateArr[2]);
        String sTimeArr[] = st.split(":");
        sHour = Integer.parseInt(sTimeArr[0]);
        sMinute = Integer.parseInt(sTimeArr[1]);
        String eTimeArr[] = et.split(":");
        eHour = Integer.parseInt(eTimeArr[0]);
        eMinute = Integer.parseInt(eTimeArr[1]);
    }
   
    public int getYear(){
        return year;
    }
    
    public int getMonth(){
        return month;
    }
    
    public int getDay(){
        return day;
    }
    
    public String getUsername(){
        return username;
    }
    public String getDayofWeek(){
        return dayOfWeek;
    }
    
    public String getDate(){
        return String.format("%04d-%02d-%02d", year, month, day);
    }
    
    public int getSHour(){
        return sHour;
    }
    
    public int getSMinute(){
        return sMinute;
    }
    
    public String getStartTime(){
        return String.format("%d:%02d", sHour, sMinute);
    }
    
    public String getEndTime(){
        return String.format("%d:%02d", eHour, eMinute);
    }
    
    public int getEHour(){
        return eHour;
    }
    
    public int getEMinute(){
        return eMinute;
    }
    
    public String getTitle(){
        return title;
    }
    
      public void setDay(String dw){
        dayOfWeek = dw;
    }
    
    public void setDay(int d){
        day= d;
    }
    public void setMonth(int m){
        month = m;
    }
    
    public void setYear(int y){
        year = y;
    }
    public void setSHour(int h){
        sHour = h;
    }
    
    public void setSMinute(int m){
        sMinute = m;
    }
    
    public void setEHour(int h){
        eHour = h;
    }
    
    public void setEMinute(int m){
        eMinute = m;
    }
    
    public void setTitle(String t){
        title = t;
    }
    
    public void setUsername(String id){
        username = id;
    }
    @Override
    public String toString(){
        
        return title;
    }

    
}
