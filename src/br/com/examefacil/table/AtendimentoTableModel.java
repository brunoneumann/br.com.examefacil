/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.examefacil.table;

import br.com.examefacil.bean.Atendimento;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author bruno
 */
public class AtendimentoTableModel extends AbstractTableModel {

    private static final int COL_ID = 0;
    private static final int COL_NOME_USUARIO = 1;
    private static final int COL_NOME_PACIENTE = 2;
    private static final int COL_DATA = 3;
    private static final int COL_HORA_ENTRADA = 4;
    private static final int COL_HORA_SAIDA = 5;
    private static final int COL_STATUS = 6;
    
    private static List<Atendimento> atendimentos;
    
    public AtendimentoTableModel(List<Atendimento> atendimentos) {
        this.atendimentos = new ArrayList<Atendimento>();
    }
    
    public int getRowCount() {
        return atendimentos.size();
    }
    
    public int getColumnCount() {
        return 7;
    }
    
    @Override
    public String getColumnName(int column) {
        if(column == COL_ID) return "ID";
        else if(column == COL_NOME_USUARIO) return "Usuário";
        else if(column == COL_NOME_PACIENTE) return "Paciente";
        else if(column == COL_DATA) return "Data";
        else if(column == COL_HORA_ENTRADA) return "Hora entrada";
        else if(column == COL_HORA_SAIDA) return "Hora saída";
        else if(column == COL_STATUS) return "Status";
        return "";
    }
    
    public Object getValueAt(int row, int column) {
        Atendimento a = atendimentos.get(row);
        if(column== COL_ID) return a.getIdatendimento();
        else if (column == COL_NOME_USUARIO) return a.getNome_usuario();
        else if(column == COL_NOME_PACIENTE) return a.getNome_paciente();
        else if(column == COL_DATA) return a.getDataString();
        else if(column == COL_HORA_ENTRADA) return a.getHoraEntrada();
        else if(column == COL_HORA_SAIDA) return a.getHoraSaida();
        else if(column == COL_STATUS) return a.getStatus();
        return "";
    }
    
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
    }
    
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
    
    public static Atendimento get(int row) {
        return atendimentos.get(row);
    }

}
