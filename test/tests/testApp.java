/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

/**
 *
 * @author Francisco
 */

import thesuperstudentplanner.*;

public class testApp {
    public static void main(String [] args){
        Appointment app = new Appointment();
        testSHour(app);
        
    }
    
    private static void testSHour(Appointment app){
        app.setSHour(10);
        app.setSMinute(39);
        System.out.println(app.getStartTime());
    }
}
