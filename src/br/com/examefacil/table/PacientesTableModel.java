/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package br.com.examefacil.table;

import br.com.examefacil.bean.Paciente;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author bruno
 */
public class PacientesTableModel extends AbstractTableModel {
    
    private static final int COL_ID = 0;
    private static final int COL_NOME = 1;
    private static final int COL_CPF = 2;
    private static final int COL_EMAIL = 3;
    
    private static List<Paciente> pacientes;
    
    public PacientesTableModel(List<Paciente> pacientes) {
        this.pacientes = new ArrayList<Paciente>();
    }
    
    public int getRowCount() {
        return pacientes.size();
    }
    
    public int getColumnCount() {
        return 4;
    }
    
    @Override
    public String getColumnName(int column) {
        if(column == COL_ID) return "ID";
        else if(column == COL_NOME) return "Nome";
        else if(column == COL_CPF) return "CPF";
        else if(column == COL_EMAIL) return "E-mail";
        return "";
    }
    
    public Object getValueAt(int row, int column) {
        Paciente p = pacientes.get(row);
        if(column== COL_ID) return p.getIdpaciente();
        else if (column == COL_NOME) return p.getNome();
        else if(column == COL_CPF) return p.getCpf();
        else if(column == COL_EMAIL) return p.getEmail();
        return "";
    }
    
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Paciente p = pacientes.get(rowIndex);
        if(columnIndex == COL_ID) p.setIdpaciente(Integer.parseInt((String) aValue));
        else if(columnIndex == COL_NOME) p.setNome(aValue.toString());
        else if(columnIndex == COL_CPF) p.setCpf(aValue.toString());
        else if(columnIndex == COL_EMAIL) p.setEmail(aValue.toString());
    }
    
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
    
    public static Paciente get(int row) {
        return pacientes.get(row);
    }
    
    
}
