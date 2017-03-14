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
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Francisco
 */
public class Panel extends JPanel implements ActionListener {
    
    public Panel() throws SQLException{
        addActionListener(this);
        this.setBackground(Color.BLACK);
        setFocusable(true);
        
        try
        {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            //Get a connection
            Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/TheSuperStudentPlannerDB"); 
            createDB(conn);
        }
        catch (Exception except)
        {
            except.printStackTrace();
        }

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
    
    public void createDB(Connection conn){
        Statement stmt = null;
        String query = "CREATE TABLE students(" 
                + "sname VARCHAR(20) NOT NULL, "
                + "sID VARCHAR(20) NOT NULL,"
                + "PRIMARY KEY (sID)"
                + ")";
        try {
            stmt = conn.createStatement();
            stmt.execute(query);
            System.out.println("Creating students table");
        } catch (SQLException e) {
            System.out.println("Error with creating table");
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Panel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
}
