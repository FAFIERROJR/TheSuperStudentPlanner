package thesuperstudentplanner;

import org.joda.time.LocalDate;
import org.joda.time.LocalTime;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author daniawareh
 */
public class AppointmentTester {
    
    Thread t;
	class ThreadTest implements Runnable{
    
	Thread t;
	public void run() {
   	 
   	 
   	while(true) {
      	try {
         	// thread to sleep for 1000 milliseconds
         	LocalTime localTime = new LocalTime();
                LocalDate localDate = new LocalDate();
                
                
                
                
                
         	Thread.sleep(1000);
      	} catch (Exception e) {
         	System.out.println(e);
                         }
                   }
             }
	}

    
    
	AppointmentTester(){
  	Thread t = new Thread(new ThreadTest());
  	// this will call run() function
  	t.start();
	}  
    
    
}
