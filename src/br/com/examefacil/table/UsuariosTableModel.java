/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package br.com.examefacil.table;

import br.com.examefacil.bean.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author bruno
 */
public class UsuariosTableModel extends AbstractTableModel {
    

    private static final int COL_NOME = 0;
    private static final int COL_EMAIL  = 1;
    private static final int COL_TIPOACESSO = 2;
    
    private static List<Usuario> usuarios;
    
    public UsuariosTableModel(List<Usuario> pacientes) {
        this.usuarios = new ArrayList<Usuario>();
    }
    
    public int getRowCount() {
        return usuarios.size();
    }
    
    public int getColumnCount() {
        return 4;
    }
    
    @Override
    public String getColumnName(int column) {
        if(column == COL_NOME) return "Nome";
        else if(column == COL_EMAIL) return "E-mail";
        else if(column == COL_TIPOACESSO) return "Tipo Acesso";
        return "";
    }
    
    public Object getValueAt(int row, int column) {
        Usuario u = usuarios.get(row);
        if (column == COL_NOME) return u.getNome();
        else if(column == COL_EMAIL) return u.getEmail();
        else if(column == COL_TIPOACESSO) return u.getTipo_acesso();
        return "";
    }
    
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Usuario u = usuarios.get(rowIndex);
        if(columnIndex == COL_NOME) u.setNome(aValue.toString());
        else if(columnIndex == COL_EMAIL) u.setEmail(aValue.toString());
        else if(columnIndex == COL_TIPOACESSO) u.setTipo_acesso(aValue.toString());
    }
    
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
    
    public static Usuario get(int row) {
        return usuarios.get(row);
    }
    
    
}
