/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thesuperstudentplanner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Francisco Fierro
 * @author Dania Wareh
 */
public class TSSP extends JFrame{
    /** our GUIs Panel **/
    Panel panel;
    
    public TSSP(){
        try {
            panel = new Panel();
        } catch (SQLException ex) {
            Logger.getLogger(TSSP.class.getName()).log(Level.SEVERE, null, ex);
        }
        getContentPane().add(panel);
        setExtendedState(Frame.MAXIMIZED_BOTH);
    }

    /**
     * @param args the command line arguments
     */
//    public static void main(String[] args) {
////        TSSP frame = new TSSP();
////        frame.setTitle("The Super Student Planner");
////        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
////        frame.set(true);
//    }
    
}
