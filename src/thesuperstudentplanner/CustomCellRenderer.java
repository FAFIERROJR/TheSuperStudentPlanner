/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thesuperstudentplanner;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author daniawareh
 */
public class CustomCellRenderer extends DefaultTableCellRenderer{
    private boolean matrix[][];
    private Color color;
    
    public void setColor(Color color){
        this.color = color;
    }
    
    public CustomCellRenderer (boolean [][] matrix){
        color = Color.blue;
        this.matrix = matrix;
      
    }

       @Override
    public Component getTableCellRendererComponent (JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int col){
           
        Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col);
        if(matrix[row][col] == true ){
            cell.setBackground(color);  
        }
        else{
            cell.setBackground(Color.white);
        }
        
        if(col== 0){
            cell.setForeground(Color.BLACK);
        }
        else{
            cell.setForeground(Color.WHITE);
        }
        return cell;
       }
}
