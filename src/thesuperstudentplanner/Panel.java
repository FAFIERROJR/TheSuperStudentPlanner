/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thesuperstudentplanner;
import static com.sun.java.accessibility.util.AWTEventMonitor.addActionListener;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

/**
 *
 * @author Francisco
 */
public class Panel extends JPanel implements ActionListener {
    public Panel(){
        addActionListener(this);
        this.setBackground(Color.BLACK);
        setFocusable(true);
        
        Thread thread = new Thread(){
            public void run(){
                try{
                    repaint();
                    Thread.sleep(30);
                }
                catch(InterruptedException e){
                    System.out.println("Interrupted");
                }
            }
        };
        thread.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.drawRect(100, 100, 50, 50);
    }
    
}
