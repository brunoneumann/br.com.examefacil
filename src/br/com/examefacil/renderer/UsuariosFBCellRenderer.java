/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package br.com.examefacil.renderer;

import br.com.examefacil.tools.Util;
import com.restfb.types.User;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author bruno
 */
public class UsuariosFBCellRenderer extends DefaultTableCellRenderer {
    
    @Override
    public Component getTableCellRendererComponent(javax.swing.JTable table,
            Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        
        JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        
        switch(column){
            case 0:
                String url = ((User.Picture)table.getValueAt(row, 0)).getUrl();
                setIcon(new Util().getImageURL(url));
                break;
            case 1:
                setIcon(null);
                break;
            case 2:
                setIcon(null);
                String link = "https://fb.com/"+table.getValueAt(row, 2);
                setText("<html><a href=" + link + ">" + link + "</a></html>");
                break;
        }
        return label;
    }
}