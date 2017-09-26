/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package br.com.examefacil.controller;

import br.com.examefacil.bean.Acesso;
import br.com.examefacil.bean.TipoExame;
import br.com.examefacil.dao.TipoExameDAO;
import br.com.examefacil.swing.TelaPrincipal;
import br.com.examefacil.view.TipoExameView;

import com.towel.el.FieldResolver;
import com.towel.el.factory.FieldResolverFactory;
import com.towel.swing.table.ObjectTableModel;
import java.util.List;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import br.com.examefacil.tools.Util;

/**
 *
 * @author Henrique
 */
public class TipoExameControl {
    public TipoExameControl(){}
    
    public void init(TipoExameView view){
        atualizaTabelaTipoExame(view);
        
        /* Desabilita aba editar */
        view.jTabTipoExame().setEnabledAt(1, false);
        view.jLIDTipoExame().setVisible(false);
        
        carregaPermissaoIncluir(view);
    }
    
    public void atualizaTabelaTipoExame(TipoExameView view){
        view.jTABTipoExame().setModel(tableModelTipoExame(view));
        view.jTABTipoExame().setColumnModel(tableColumnTipoExame(view));
    }
    
    public void carregaPermissaoIncluir(TipoExameView view) {
        List<Acesso> permissoes = new AcessoControl().listaAcessosUsuario(TelaPrincipal.usuarioLogado.getIdusuario());
        for (Acesso a : permissoes) {
            if (a.getPagina().equals("tipoexame")) {
                view.jBIncluir().setEnabled(a.isIncluir());
                break;
            }
        }
    }

    public void carregaPermissaoAlterarExcluir(TipoExameView view) {
        List<Acesso> permissoes = new AcessoControl().listaAcessosUsuario(TelaPrincipal.usuarioLogado.getIdusuario());
        for (Acesso a : permissoes) {
            if (a.getPagina().equals("tipoexame")) {
                view.jBEditar().setEnabled(a.isAlterar());
                view.jBExcluir().setEnabled(a.isExcluir());
                break;
            }
        }
    }
    
    public boolean salvar(TipoExameView view){
        
        TipoExame tipo = new TipoExame();
        if(view.jLIDTipoExame().getText()!=null){
            tipo.setIdtipoexame(Integer.parseInt(view.jLIDTipoExame().getText()));
        }
        tipo.setNome(view.getNome());
        
        boolean result = new TipoExameDAO().save(tipo);
        if(result){
            limparTextos(view);
            desabilitaBotoesEditar(view);
            atualizaTabelaTipoExame(view);
        }
        return result;
    }
    
    public boolean excluir(TipoExameView view){
        if (Util.Confirma("Deseja excluir realmente este tipo de exame?\n"
                + "Nome: " + view.jTABTipoExame().getModel().getValueAt(view.jTABTipoExame().getSelectedRow(), 1))) {
            
            boolean result = new TipoExameDAO().delete(tipoExameSelecionado(view));
            if(result){
                atualizaTabelaTipoExame(view);
            }
        }
        alteraEstadoEditarExcluir(view, false);
        return false;
    }
    
    public TipoExame get(int id){
        return new TipoExameDAO().get(id);
    }
    
    public List<TipoExame> listar() throws Exception{
        return new TipoExameDAO().list();
    }
    
    public List<TipoExame> listar(String parametro){
        
        return new TipoExameDAO().list(parametro);
    }
    public TipoExame tipoExameSelecionado(TipoExameView view){
        int selected = view.jTABTipoExame().getSelectedRow();
        return get((int)view.jTABTipoExame().getModel().getValueAt(selected, 0));
    }
    
    public void carregarDados(TipoExameView view){
        TipoExame a = tipoExameSelecionado(view);
        if(a!=null){
            habilitaBotoesEditar(view);
            view.jLIDTipoExame().setText(a.getIdtipoexame()+"");
            view.jTTipoExame().setText(a.getNome());
        }
    }
    public TableModel tableModelTipoExame(TipoExameView view){
        FieldResolverFactory frf = new FieldResolverFactory(TipoExame.class);
        FieldResolver frID = frf.createResolver("idtipoexame", "ID");
        FieldResolver frNome = frf.createResolver("nome", "Nome");
        
        ObjectTableModel<TipoExame> model =
                new ObjectTableModel<TipoExame>(
                        new FieldResolver[]{frID,frNome});
        
        model.setEditableDefault(false);
        model.setData(this.listar(view.jTPesquisar().getText()));
        return model;
    }
    public TableColumnModel tableColumnTipoExame(TipoExameView view){
        TableColumnModel coluna = view.jTABTipoExame().getColumnModel();
        coluna.getColumn(0).setPreferredWidth(5);
        coluna.getColumn(1).setPreferredWidth(150);
        return coluna;
    }
    
    public void novoTipoExame(TipoExameView view){
        habilitaBotoesEditar(view);
        view.jLIDTipoExame().setText(null);
    }
    
    public void alteraEstadoEditarExcluir(TipoExameView view, boolean action){
        view.jBExcluir().setEnabled(action);
        view.jBEditar().setEnabled(action);
        
        carregaPermissaoAlterarExcluir(view);
    }
    
    public void limparTextos(TipoExameView view){
        view.jTTipoExame().setText("");
        
    }
    
    public void habilitaBotoesEditar(TipoExameView view){
        view.jBIncluir().setEnabled(false);
        view.jBExcluir().setEnabled(false);
        view.jBPesquisar().setEnabled(false);
        view.jBEditar().setEnabled(false);
        view.jBGravar().setEnabled(true);
        view.jBCancelar().setEnabled(true);
        view.jTPesquisar().setEnabled(false);
        view.jTabTipoExame().setSelectedIndex(1);
        view.jCInclusaoAutomatica().setSelected(false);
        view.jTabTipoExame().setEnabledAt(0, false);
        view.jTabTipoExame().setEnabledAt(1, true);
    }
    public void desabilitaBotoesEditar(TipoExameView view){
        if(!view.jCInclusaoAutomatica().isSelected()){
            view.jBIncluir().setEnabled(true);
            view.jBExcluir().setEnabled(false);
            view.jBPesquisar().setEnabled(true);
            view.jBEditar().setEnabled(false);
            view.jTPesquisar().setEnabled(true);
            view.jBGravar().setEnabled(false);
            view.jBCancelar().setEnabled(false);
            view.jTabTipoExame().setSelectedIndex(0);
            view.jTabTipoExame().setEnabledAt(0, true);
            view.jTabTipoExame().setEnabledAt(1, false);
        }
    }
}
