/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.examefacil.controller;

import br.com.examefacil.bean.Usuario;
import br.com.examefacil.dao.UsuarioDAO;
import br.com.examefacil.view.UsuarioView;

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
public class UsuarioControl {
        public UsuarioControl(){}
        
        public void init(UsuarioView view){
        atualizaTabelaUsuarios(view);
        
        /* Desabilita aba editar */
        view.jTabUsuario().setEnabledAt(1, false);
        view.jTabUsuario().setEnabledAt(2, false);
        view.jLIDUsuario().setVisible(false);
    }
        
        public void atualizaTabelaUsuarios(UsuarioView view){
        view.JTABUsuarios().setModel(tableModelUsuarios(view));
        view.JTABUsuarios().setColumnModel(tableColumnUsuarios(view));
    }
    
    public boolean salvar(UsuarioView view){
        
        Usuario usuario = new Usuario();
        if(view.jLIDUsuario().getText()!=null){
            usuario.setIdusuario(Integer.parseInt(view.jLIDUsuario().getText()));
        }
        usuario.setNome(view.getNome());
        usuario.setEmail(view.getEmail());
        usuario.setTipo_acesso(view.getTipoAcesso());
        
        boolean result = new UsuarioDAO().save(usuario);
        if(result){
            limparTextos(view);
            desabilitaBotoesEditar(view);
            atualizaTabelaUsuarios(view);
        }
        return result;
    }
    
    public boolean alterarSenha(int idusuario, String senha){
        return new UsuarioDAO().alterarSenha(idusuario, Util.encriptaSenha(senha));
    }

    public boolean excluir(UsuarioView view){
        if (Util.Confirma("Deseja excluir realmente este usuário?\n"
                + "Nome: " + view.JTABUsuarios().getModel().getValueAt(view.JTABUsuarios().getSelectedRow(), 1))) {
            
            boolean result = new UsuarioDAO().delete(usuarioSelecionado(view));
            if(result){
                atualizaTabelaUsuarios(view);
            }
        }
        alteraEstadoEditarExcluir(view, false);
        return false;
    }
    
    public Usuario get(int id){
        return new UsuarioDAO().get(id);
    }
    
    public List<Usuario> listar() throws Exception{
        return new UsuarioDAO().list();
    }
    
    public List<Usuario> listar(String parametro){
        
        return new UsuarioDAO().list(parametro);
    }
    public Usuario usuarioSelecionado(UsuarioView view){
        int selected = view.JTABUsuarios().getSelectedRow();
        return get((int)view.JTABUsuarios().getModel().getValueAt(selected, 0));
    }
    
    public void carregarDados(UsuarioView view){
        Usuario u = usuarioSelecionado(view);
        if(u!=null){
            habilitaBotoesEditar(view);
            view.jLIDUsuario().setText(u.getIdusuario()+"");
            view.jTNomeUsuario().setText(u.getNome());
            view.jTEmail().setText(u.getEmail());
            view.btnAbrirDialogAlteraSenha().setVisible(true);
            //view.jCTipoAcesso().setText(u.getTipo_acesso());
        }
    }
    public TableModel tableModelUsuarios(UsuarioView view){
        FieldResolverFactory frf = new FieldResolverFactory(Usuario.class);
        FieldResolver frID = frf.createResolver("idusuario", "ID");
        FieldResolver frNome = frf.createResolver("nome", "Nome");
        FieldResolver frEmail = frf.createResolver("email", "E-mail");

        ObjectTableModel<Usuario> model = 
                new ObjectTableModel<Usuario>(
                new FieldResolver[]{frID,frNome,frEmail});

        model.setEditableDefault(false);
        model.setData(this.listar(view.jTPesquisar().getText()));
        return model;
    }
    public TableColumnModel tableColumnUsuarios(UsuarioView view){
        TableColumnModel coluna = view.JTABUsuarios().getColumnModel();
        coluna.getColumn(0).setPreferredWidth(5);
        coluna.getColumn(1).setPreferredWidth(150);
        coluna.getColumn(2).setPreferredWidth(50);
         return coluna;
    }
    
     public void novoUsuario(UsuarioView view){
        habilitaBotoesEditar(view);
        view.jLIDUsuario().setText(null);
        view.btnAbrirDialogAlteraSenha().setVisible(false);
    }
    
    public void alteraEstadoEditarExcluir(UsuarioView view, boolean action){
        view.jBExcluir().setEnabled(action);
        view.jBEditar().setEnabled(action);
    }
    
    public void limparTextos(UsuarioView view){
        view.jTNomeUsuario().setText("");
        view.jTEmail().setText("");
    }
    
    public void habilitaBotoesEditar(UsuarioView view){
        view.jBIncluir().setEnabled(false);
        view.jBExcluir().setEnabled(false);
        view.jBPesquisar().setEnabled(false);
        view.jBEditar().setEnabled(false);
        view.jBGravar().setEnabled(true);
        view.jBCancelar().setEnabled(true);
        view.jTPesquisar().setEnabled(false);
        view.jTabUsuario().setSelectedIndex(1);
        view.jCInclusaoAutomatica().setSelected(false);
        view.jTabUsuario().setEnabledAt(0, false);
        view.jTabUsuario().setEnabledAt(1, true);
        view.jTabUsuario().setEnabledAt(2, false);
    }
    public void desabilitaBotoesEditar(UsuarioView view){
        if(!view.jCInclusaoAutomatica().isSelected()){
            view.jBIncluir().setEnabled(true);
            view.jBExcluir().setEnabled(false);
            view.jBPesquisar().setEnabled(true);
            view.jBEditar().setEnabled(false);
            view.jTPesquisar().setEnabled(true);
            view.jBGravar().setEnabled(false);
            view.jBCancelar().setEnabled(false);
            view.jTabUsuario().setSelectedIndex(0);
            view.jTabUsuario().setEnabledAt(0, true);
            view.jTabUsuario().setEnabledAt(1, false);
            view.jTabUsuario().setEnabledAt(2, false);
        }
    }
    public void inserirPermissoes (UsuarioView view){
        view.jBIncluir().setEnabled(false);
            view.jBExcluir().setEnabled(false);
            view.jBPesquisar().setEnabled(false);
            view.jBEditar().setEnabled(false);
            view.jTPesquisar().setEnabled(false);
            view.jBGravar().setEnabled(true);
            view.jBCancelar().setEnabled(true);
            view.jTabUsuario().setSelectedIndex(2);
            view.jTabUsuario().setEnabledAt(0, false);
            view.jTabUsuario().setEnabledAt(1, false);
            view.jTabUsuario().setEnabledAt(2, true);
    }
    
}
