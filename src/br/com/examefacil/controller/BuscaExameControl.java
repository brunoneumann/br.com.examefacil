/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.examefacil.controller;

import br.com.examefacil.bean.Paciente;
import br.com.examefacil.bean.TipoExame;
import br.com.examefacil.dao.PacienteDAO;
import br.com.examefacil.dao.TipoExameDAO;
import br.com.examefacil.view.AtenderView;
import br.com.examefacil.view.BuscaExameView;
import com.towel.el.FieldResolver;
import com.towel.el.factory.FieldResolverFactory;
import com.towel.swing.table.ObjectTableModel;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import br.com.examefacil.view.AtendimentoView;

/**
 *
 * @author Henrique
 */
public class BuscaExameControl {
    
    
    public void atualizaTabelaExames(BuscaExameView view) {
        view.JTABExames().setModel(tableModelExames(view));
        view.JTABExames().setColumnModel(tableColumnExames(view));
    }
    
    public TableModel tableModelExames(BuscaExameView view) {
        FieldResolverFactory frf = new FieldResolverFactory(TipoExame.class);
        FieldResolver frID = frf.createResolver("idtipoexame", "ID");
        FieldResolver frNome = frf.createResolver("nome", "Descrição");
        
        ObjectTableModel<TipoExame> model
                = new ObjectTableModel<TipoExame>(
                        new FieldResolver[]{frID, frNome});
        
        model.setEditableDefault(false);
        model.setData(this.listar(view.jTPesquisar().getText()));
        return model;
    }
    
    public TableColumnModel tableColumnExames(BuscaExameView view) {
        TableColumnModel coluna = view.JTABExames().getColumnModel();
        coluna.getColumn(0).setPreferredWidth(5);
        coluna.getColumn(1).setPreferredWidth(150);
        return coluna;
    }
    
    public TipoExame get(int id) {
        return new TipoExameDAO().get(id);
    }
    
    public List<TipoExame> listar() {
        return new TipoExameDAO().list();
    }
    
    public List<TipoExame> listar(String parametro) {
        return new TipoExameDAO().list(parametro);
    }
    
    public TipoExame tipoExameSelecionado(BuscaExameView view) {
        int selected = view.JTABExames().getSelectedRow();
        return get((int) view.JTABExames().getModel().getValueAt(selected, 0));
    }
    
    public void selecionarExame(int row, JTable table, AtenderView view, BuscaExameView view2){
       String nome = table.getModel().getValueAt(row, 1).toString();
       String id = table.getModel().getValueAt(row, 0).toString();
       
       view.jTSolicitarExame().setText(nome);
       view.jLIDExame().setText(id+"");
       
        
        
    }
    
}
