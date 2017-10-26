/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package br.com.examefacil.renderer;

import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author bruno
 */
public class PacientesCellRenderer extends DefaultTableCellRenderer {
    
    @Override
    public Component getTableCellRendererComponent(javax.swing.JTable table,
            Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        
        JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        
        switch(column){
            case 4:
                if(table.getValueAt(row, 4)!=null){
                    String link = "https://fb.com/"+table.getValueAt(row, 4).toString();
                    setText("<html><a href=" + link + ">" + link + "</a></html>");
                }
                break;
        }
        return label;
    }
}