/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package br.com.examefacil.controller;

import br.com.examefacil.bean.Paciente;
import br.com.examefacil.dao.PacienteDAO;
import br.com.examefacil.view.PacienteView;
import com.towel.el.FieldResolver;
import com.towel.el.factory.FieldResolverFactory;
import com.towel.swing.table.ObjectTableModel;
import java.util.List;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

/**
 *
 * @author bruno
 */
public class PacienteControl {
    
    public PacienteControl(){}
    
    public boolean salvar(PacienteView view){
        Paciente paciente = new Paciente();
        paciente.setNome(view.getNome());
        paciente.setCpf(view.getCPF());
        paciente.setEmail(view.getEmail());
        
        boolean result = new PacienteDAO().save(paciente);
        if(result){
            limparTextos(view);
            desabilitaBotoesEditar(view);
        }
        return result;
    }
    
    public boolean excluir(Paciente paciente){
        return new PacienteDAO().delete(paciente);
    }
    
    public Paciente get(int id){
        return new PacienteDAO().get(id);
    }
    
    public List<Paciente> listar(){
        return new PacienteDAO().list();
    }
    
    public List<Paciente> listar(String parametro){
        return new PacienteDAO().list(parametro);
    }
    
    public TableModel tableModelPacientes(PacienteView view){
        FieldResolverFactory frf = new FieldResolverFactory(Paciente.class);
        FieldResolver frID = frf.createResolver("idpaciente", "ID");
        FieldResolver frNome = frf.createResolver("nome", "Nome");
        FieldResolver frCPF = frf.createResolver("cpf", "CPF");
        FieldResolver frEmail = frf.createResolver("email", "E-mail");

        ObjectTableModel<Paciente> model = 
                new ObjectTableModel<Paciente>(
                new FieldResolver[]{frID,frNome,frCPF,frEmail});

        model.setEditableDefault(false);
        model.setData(this.listar(view.jTPesquisarPaciente().getText()));
        return model;
    }
    public TableColumnModel tableColumnPacientes(PacienteView view){
        TableColumnModel coluna = view.JTABPacientes().getColumnModel();
        coluna.getColumn(0).setPreferredWidth(5);
        coluna.getColumn(1).setPreferredWidth(150);
        coluna.getColumn(2).setPreferredWidth(50);
        coluna.getColumn(3).setPreferredWidth(50);
        return coluna;
    }
    
    public void limparTextos(PacienteView view){
        view.jTNomePaciente().setText("");
        view.jTCPF().setText("");
        view.JTEmail().setText("");
    }
    public void habilitaBotoesEditar(PacienteView view){
        view.jBIncluir().setEnabled(false);
        view.jBExcluir().setEnabled(false);
        view.jBPesquisar().setEnabled(false);
        view.jBeditar().setEnabled(false);
        view.jBGravar().setEnabled(true);
        view.jBCancelar().setEnabled(true);
        view.jTPesquisarPaciente().setEnabled(false);
        view.jTabPaciente().setSelectedIndex(1);
        view.jCInclusaoAutomatica().setSelected(false);
        view.jTabPaciente().setEnabledAt(0, false);
        view.jTabPaciente().setEnabledAt(1, true);
    }
    public void desabilitaBotoesEditar(PacienteView view){
        if(!view.jCInclusaoAutomatica().isSelected()){
            view.jBIncluir().setEnabled(true);
            view.jBExcluir().setEnabled(false);
            view.jBPesquisar().setEnabled(true);
            view.jBeditar().setEnabled(false);
            view.jTPesquisarPaciente().setEnabled(true);
            view.jBGravar().setEnabled(false);
            view.jBCancelar().setEnabled(false);
            view.jTabPaciente().setSelectedIndex(0);
            view.jTabPaciente().setEnabledAt(0, true);
            view.jTabPaciente().setEnabledAt(1, false);
        }
    }
}
