/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package br.com.examefacil.controller;



import br.com.examefacil.bean.Acesso;
import br.com.examefacil.bean.TextoPadrao;
import br.com.examefacil.dao.TextoPadraoDAO;
import br.com.examefacil.swing.TelaPrincipal;
import com.towel.el.FieldResolver;
import com.towel.el.factory.FieldResolverFactory;
import com.towel.swing.table.ObjectTableModel;
import java.util.List;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import br.com.examefacil.tools.Util;
import br.com.examefacil.view.TextoPadraoView;
import javax.swing.JOptionPane;

/**
 *
 * @author Henrique
 */
public class TextoPadraoControl {
    public TextoPadraoControl(){}
    
    public void init(TextoPadraoView view){
        atualizaTabelaTextoPadrao(view);
        
        /* Desabilita aba editar */
        view.jTabTextoPadrao().setEnabledAt(1, false);
        view.jLIDTextoPadrao().setVisible(false);
        
        carregaPermissaoIncluir(view);
    }
    
    public void carregaPermissaoIncluir(TextoPadraoView view) {
        List<Acesso> permissoes = new AcessoControl().listaAcessosUsuario(TelaPrincipal.usuarioLogado.getIdusuario());
        for (Acesso a : permissoes) {
            if (a.getPagina().equals("textopadrao")) {
                view.jBIncluir().setEnabled(a.isIncluir());
                break;
            }
        }
    }
    
    public void carregaPermissaoAlterarExcluir(TextoPadraoView view) {
        List<Acesso> permissoes = new AcessoControl().listaAcessosUsuario(TelaPrincipal.usuarioLogado.getIdusuario());
        for (Acesso a : permissoes) {
            if (a.getPagina().equals("textopadrao")) {
                view.jBEditar().setEnabled(a.isAlterar());
                view.jBExcluir().setEnabled(a.isExcluir());
                break;
            }
        }
    }
    
    public void atualizaTabelaTextoPadrao(TextoPadraoView view){
        view.jTABTextoPadrao().setModel(tableModelTextoPadrao(view));
        view.jTABTextoPadrao().setColumnModel(tableColumnTextoPadrao(view));
    }
    
    public boolean salvar(TextoPadraoView view){
        
        TextoPadrao area = new TextoPadrao();
        if(view.jLIDTextoPadrao().getText()!=null){
            area.setIdtextopadrao(Integer.parseInt(view.jLIDTextoPadrao().getText()));
        }
        area.setNome_codigo(view.getNome_codigo());
        
        boolean result = new TextoPadraoDAO().save(area);
        if(result){
            limparTextos(view);
            desabilitaBotoesEditar(view);
            atualizaTabelaTextoPadrao(view);
        }
        return result;
    }
    
    public boolean excluir(TextoPadraoView view){
        if (Util.Confirma("Deseja excluir realmente este texto padrão?\n"
                + "Nome: " + view.jTABTextoPadrao().getModel().getValueAt(view.jTABTextoPadrao().getSelectedRow(), 1))) {
            
            boolean result = new TextoPadraoDAO().delete(textoPadraoSelecionado(view));
            if(result){
                atualizaTabelaTextoPadrao(view);
            }
        }
        alteraEstadoEditarExcluir(view, false);
        return false;
    }
    
    public TextoPadrao get(int id){
        return new TextoPadraoDAO().get(id);
    }
    
    public List<TextoPadrao> listar() throws Exception{
        return new TextoPadraoDAO().list();
    }
    
    public List<TextoPadrao> listar(String parametro){
        
        return new TextoPadraoDAO().list(parametro);
    }
    public TextoPadrao textoPadraoSelecionado(TextoPadraoView view){
        int selected = view.jTABTextoPadrao().getSelectedRow();
        return get((int)view.jTABTextoPadrao().getModel().getValueAt(selected, 0));
    }
    
    public void carregarDados(TextoPadraoView view){
        TextoPadrao a = textoPadraoSelecionado(view);
        if(a!=null){
            habilitaBotoesEditar(view);
            view.jLIDTextoPadrao().setText(a.getIdtextopadrao()+"");
            view.jTNome_codigo().setText(a.getNome_codigo());
        }
    }
    public TableModel tableModelTextoPadrao(TextoPadraoView view){
        FieldResolverFactory frf = new FieldResolverFactory(TextoPadrao.class);
        FieldResolver frID = frf.createResolver("idtextopadrao", "ID");
        FieldResolver frNome = frf.createResolver("nome_codigo", "Nome");
        
        ObjectTableModel<TextoPadrao> model =
                new ObjectTableModel<TextoPadrao>(
                        new FieldResolver[]{frID,frNome});
        
        model.setEditableDefault(false);
        model.setData(this.listar(view.jTPesquisar().getText()));
        return model;
    }
    public TableColumnModel tableColumnTextoPadrao(TextoPadraoView view){
        TableColumnModel coluna = view.jTABTextoPadrao().getColumnModel();
        coluna.getColumn(0).setPreferredWidth(5);
        coluna.getColumn(1).setPreferredWidth(150);
        return coluna;
    }
    
    public void novoTextoPadrao(TextoPadraoView view){
        habilitaBotoesEditar(view);
        view.jLIDTextoPadrao().setText(null);
    }
    
    public void alteraEstadoEditarExcluir(TextoPadraoView view, boolean action){
        view.jBExcluir().setEnabled(action);
        view.jBEditar().setEnabled(action);
        
        carregaPermissaoAlterarExcluir(view);
    }
    
    public void limparTextos(TextoPadraoView view){
        view.jTNome_codigo().setText("");
        view.jTDescricao().setText("");
        
    }
    
    public void habilitaBotoesEditar(TextoPadraoView view){
        view.jBIncluir().setEnabled(false);
        view.jBExcluir().setEnabled(false);
        view.jBPesquisar().setEnabled(false);
        view.jBEditar().setEnabled(false);
        view.jBGravar().setEnabled(true);
        view.jBCancelar().setEnabled(true);
        view.jTPesquisar().setEnabled(false);
        view.jTabTextoPadrao().setSelectedIndex(1);
        view.jCInclusaoAutomatica().setSelected(false);
        view.jTabTextoPadrao().setEnabledAt(0, false);
        view.jTabTextoPadrao().setEnabledAt(1, true);
    }
    public void desabilitaBotoesEditar(TextoPadraoView view){
        if(!view.jCInclusaoAutomatica().isSelected()){
            view.jBIncluir().setEnabled(true);
            view.jBExcluir().setEnabled(false);
            view.jBPesquisar().setEnabled(true);
            view.jBEditar().setEnabled(false);
            view.jTPesquisar().setEnabled(true);
            view.jBGravar().setEnabled(false);
            view.jBCancelar().setEnabled(false);
            view.jTabTextoPadrao().setSelectedIndex(0);
            view.jTabTextoPadrao().setEnabledAt(0, true);
            view.jTabTextoPadrao().setEnabledAt(1, false);
        }
    }
    
    public boolean validaCampos(TextoPadraoView view) {

        if (view.jTNome_codigo().getText().equals("")
                || view.jTNome_codigo().getText().equals(" ")) {
            JOptionPane.showMessageDialog(null, "Digite um valor válido no campo: " + view.jTNome_codigo().getName() + "", "Erro de validação", JOptionPane.ERROR_MESSAGE);

            return false;
        } else if (view.jTDescricao().getText().equals("")
                || view.jTDescricao().getText().equals(" ")) {

            JOptionPane.showMessageDialog(null, "Digite um valor válido no campo: " + view.jTDescricao().getName() + "", "Erro de validação", JOptionPane.ERROR_MESSAGE);
            return false;
        } else {
            return true;
        }
    }
}

