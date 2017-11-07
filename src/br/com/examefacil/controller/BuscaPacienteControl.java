/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.examefacil.controller;

import br.com.examefacil.bean.Paciente;
import br.com.examefacil.dao.PacienteDAO;
import br.com.examefacil.view.BuscaPacienteView;
import br.com.examefacil.view.ExameView;
import com.towel.el.FieldResolver;
import com.towel.el.factory.FieldResolverFactory;
import com.towel.swing.table.ObjectTableModel;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Henrique
 */
public class BuscaPacienteControl {
    
    
    public void atualizaTabelaPacientes(BuscaPacienteView view) {
        view.JTABPacientes().setModel(tableModelPacientes(view));
        view.JTABPacientes().setColumnModel(tableColumnPacientes(view));
    }
    
    public TableModel tableModelPacientes(BuscaPacienteView view) {
        FieldResolverFactory frf = new FieldResolverFactory(Paciente.class);
        FieldResolver frID = frf.createResolver("idpaciente", "ID");
        FieldResolver frNome = frf.createResolver("nome", "Nome");
        FieldResolver frCPF = frf.createResolver("cpf", "CPF");
        FieldResolver frEmail = frf.createResolver("email", "E-mail");
        
        ObjectTableModel<Paciente> model
                = new ObjectTableModel<Paciente>(
                        new FieldResolver[]{frID, frNome, frCPF, frEmail});
        
        model.setEditableDefault(false);
        model.setData(this.listar(view.jTPesquisar().getText()));
        return model;
    }
    
    public TableColumnModel tableColumnPacientes(BuscaPacienteView view) {
        TableColumnModel coluna = view.JTABPacientes().getColumnModel();
        coluna.getColumn(0).setPreferredWidth(5);
        coluna.getColumn(1).setPreferredWidth(150);
        coluna.getColumn(2).setPreferredWidth(50);
        coluna.getColumn(3).setPreferredWidth(50);
        return coluna;
    }
    
    public Paciente get(int id) {
        return new PacienteDAO().get(id);
    }
    
    public List<Paciente> listar() {
        return new PacienteDAO().list();
    }
    
    public List<Paciente> listar(String parametro) {
        return new PacienteDAO().list(parametro);
    }
    
    public Paciente pacienteSelecionado(BuscaPacienteView view) {
        int selected = view.JTABPacientes().getSelectedRow();
        return get((int) view.JTABPacientes().getModel().getValueAt(selected, 0));
    }
    
    public void selecionarPaciente(int row, JTable table, ExameView view){
       String nome = table.getModel().getValueAt(row, 1).toString();
        String id = table.getModel().getValueAt(row, 0).toString();
        view.jTPaciente().setText(nome);
        view.JLIDPaciente().setText(id);
        
        
    }
    
}
