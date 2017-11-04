/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package br.com.examefacil.table;

import br.com.examefacil.bean.TipoExame;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author bruno
 */
public class TipoExamesTableModel extends AbstractTableModel {
    
    private static final int COL_ID = 0;
    private static final int COL_NOME = 1;
    private static final int COL_DESCRICAO = 2;
    
    private static List<TipoExame> tipo;
    
    public TipoExamesTableModel(List<TipoExame> tipo) {
        this.tipo = new ArrayList<TipoExame>();
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
        return "";
    }
    
    public Object getValueAt(int row, int column) {
        TipoExame a = tipo.get(row);
        if(column== COL_ID) return a.getIdtipoexame();
        else if (column == COL_NOME) return a.getNome();
        else if (column == COL_DESCRICAO) return a.getDescricao();
        return "";
    }
    
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        TipoExame a = tipo.get(rowIndex);
        if(columnIndex == COL_ID) a.setIdtipoexame(Integer.parseInt((String) aValue));
        else if(columnIndex == COL_NOME) a.setNome(aValue.toString());
        else if(columnIndex == COL_DESCRICAO) a.setDescricao(aValue.toString());
    }
    
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
    
    public static TipoExame get(int row) {
        return tipo.get(row);
    }
    
    
}
