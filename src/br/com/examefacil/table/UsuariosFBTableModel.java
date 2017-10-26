/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.examefacil.table;

import br.com.examefacil.bean.Usuario;
import com.restfb.types.User;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author bruno
 */
public class UsuariosFBTableModel extends AbstractTableModel {
    
    private static final int COL_PIC = 0;
    private static final int COL_NOME  = 1;
    private static final int COL_URL = 2;
    
    private static List<User> users;
    
    public UsuariosFBTableModel(List<User> users) {
        this.users = new ArrayList<>();
    }
    
    public int getRowCount() {
        return users.size();
    }
    
    public int getColumnCount() {
        return 3;
    }
    
    @Override
    public String getColumnName(int column) {
        if(column == COL_PIC) return "";
        else if(column == COL_NOME) return "Nome";
        else if(column == COL_URL) return "URL";
        return "";
    }
    
    public Object getValueAt(int row, int column) {
        User u = users.get(row);
        if (column == COL_PIC) return u.getPicture();
        else if(column == COL_NOME) return u.getName();
        else if(column == COL_URL) return u.getId();
        return "";
    }
    
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        User u = users.get(rowIndex);
        if(columnIndex == COL_NOME) u.setName(aValue.toString());
        else if(columnIndex == COL_URL) u.setId(aValue.toString());
    }
    
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
    
    public static User get(int row) {
        return users.get(row);
    }

}
