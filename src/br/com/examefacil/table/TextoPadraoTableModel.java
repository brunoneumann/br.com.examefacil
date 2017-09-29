/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package br.com.examefacil.table;

import br.com.examefacil.bean.TextoPadrao;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author bruno
 */
public class TextoPadraoTableModel extends AbstractTableModel {
    
    private static final int COL_ID = 0;
    private static final int COL_NOME = 1;
    private static final int COL_TEXTO = 2;
    
    private static List<TextoPadrao> tipo;
    
    public TextoPadraoTableModel(List<TextoPadrao> tipo) {
        this.tipo = new ArrayList<TextoPadrao>();
    }
    
    public int getRowCount() {
        return tipo.size();
    }
    
    public int getColumnCount() {
        return 3;
    }
    
    @Override
    public String getColumnName(int column) {
        if(column == COL_ID) return "ID";
        else if(column == COL_NOME) return "Nome";
        else if(column == COL_TEXTO) return "Texto";
        return "";
    }
    
    public Object getValueAt(int row, int column) {
        TextoPadrao a = tipo.get(row);
        if(column== COL_ID) return a.getIdtextopadrao();
        else if (column == COL_NOME) return a.getNome_codigo();
        else if (column == COL_TEXTO) return a.getTexto();
        return "";
    }
    
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        TextoPadrao a = tipo.get(rowIndex);
        if(columnIndex == COL_ID) a.setIdtextopadrao(Integer.parseInt((String) aValue));
        else if(columnIndex == COL_NOME) a.setNome_codigo(aValue.toString());
        else if(columnIndex == COL_TEXTO) a.setTexto(aValue.toString());
    }
    
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
    
    public static TextoPadrao get(int row) {
        return tipo.get(row);
    }
    
    
}
