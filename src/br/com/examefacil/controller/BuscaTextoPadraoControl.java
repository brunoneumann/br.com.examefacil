/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.examefacil.controller;

import br.com.examefacil.bean.Paciente;
import br.com.examefacil.bean.TextoPadrao;
import br.com.examefacil.dao.PacienteDAO;
import br.com.examefacil.dao.TextoPadraoDAO;
import br.com.examefacil.view.BuscaPacienteView;
import br.com.examefacil.view.BuscaTextoPadraoView;
import br.com.examefacil.view.InterpretacaoView;
import br.com.examefacil.view.TextoPadraoView;
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
public class BuscaTextoPadraoControl {
    
    
    public void atualizaTabelaTextoPadrao(BuscaTextoPadraoView view) {
        view.JTABTextoPadrao().setModel(tableModelTextoPadrao(view));
        view.JTABTextoPadrao().setColumnModel(tableColumnTextoPadrao(view));
    }
    
    public TableModel tableModelTextoPadrao(BuscaTextoPadraoView view) {
        FieldResolverFactory frf = new FieldResolverFactory(TextoPadrao.class);
        FieldResolver frID = frf.createResolver("idtextopadrao", "ID");
        FieldResolver frNome = frf.createResolver("nome_codigo", "Nome");
        FieldResolver frTexto = frf.createResolver("texto", "Texto");
        
        ObjectTableModel<TextoPadrao> model =
                new ObjectTableModel<TextoPadrao>(
                        new FieldResolver[]{frID,frNome,frTexto});
        
        model.setEditableDefault(false);
        model.setData(this.listar(view.jTPesquisar().getText()));
        return model;
    }
    
    public TableColumnModel tableColumnTextoPadrao(BuscaTextoPadraoView view) {
        TableColumnModel coluna = view.JTABTextoPadrao().getColumnModel();
        coluna.getColumn(0).setPreferredWidth(5);
        coluna.getColumn(1).setPreferredWidth(150);
        coluna.getColumn(2).setPreferredWidth(100);
        return coluna;
    }
    
    public TextoPadrao get(int id) {
        return new TextoPadraoDAO().get(id);
    }
    
    public List<TextoPadrao> listar() {
        return new TextoPadraoDAO().list();
    }
    
    public List<TextoPadrao> listar(String parametro) {
        return new TextoPadraoDAO().list(parametro);
    }
    
    public TextoPadrao textoPadraoSelecionado(BuscaTextoPadraoView view) {
        int selected = view.JTABTextoPadrao().getSelectedRow();
        return get((int) view.JTABTextoPadrao().getModel().getValueAt(selected, 0));
    }
    
    public void selecionarTextoPadrao(int row, JTable table, InterpretacaoView view){
       String descricao = table.getModel().getValueAt(row, 2).toString();
        String id = table.getModel().getValueAt(row, 0).toString();
        view.jLIDTextoPadrao().setText(id);
        view.jTLaudo().setText(descricao);
        
        
    }
    
}
