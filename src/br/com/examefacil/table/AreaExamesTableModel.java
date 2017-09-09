/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package br.com.examefacil.table;

import br.com.examefacil.bean.AreaExame;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author bruno
 */
public class AreaExamesTableModel extends AbstractTableModel {
    
    private static final int COL_ID = 0;
    private static final int COL_NOME = 1;
    
    private static List<AreaExame> area;
    
    public AreaExamesTableModel(List<AreaExame> area) {
        this.area = new ArrayList<AreaExame>();
    }
    
    public int getRowCount() {
        return area.size();
    }
    
    public int getColumnCount() {
        return 2;
    }
    
    @Override
    public String getColumnName(int column) {
        if(column == COL_ID) return "ID";
        else if(column == COL_NOME) return "Nome";
        return "";
    }
    
    public Object getValueAt(int row, int column) {
        AreaExame a = area.get(row);
        if (column == COL_ID) return a.getIdareaexame();
        else if (column == COL_NOME) return a.getNome();
        return "";
    }
    
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        AreaExame a = area.get(rowIndex);
        if(columnIndex == COL_ID) a.setIdareaexame(Integer.parseInt(aValue+""));
        else if(columnIndex == COL_NOME) a.setNome(aValue.toString());
    }
    
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
    
    public static AreaExame get(int row) {
        return area.get(row);
    }
    
    
}
