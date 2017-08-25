/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.examefacil.controller;

import br.com.examefacil.bean.Usuario;
import br.com.examefacil.dao.UsuarioDAO;
import br.com.examefacil.view.UsuarioView;

/**
 *
 * @author Henrique
 */
public class UsuarioControl {
        public UsuarioControl(){}
    
    public boolean salvar(UsuarioView view){
        
        Usuario usuario = new Usuario();
        usuario.setNome(view.getNome());
        usuario.setEmail(view.getEmail());
        usuario.setSenha(view.getSenha());
        usuario.setTipo_acesso("A");
        
        boolean result = new UsuarioDAO().save(usuario);
        if(result){
            limparCampos(view);
        }
        return result;
    }

    public boolean excluir(Usuario areaExame){
        return new UsuarioDAO().delete(areaExame);
    }
    
    public Usuario get(int id){
        return new UsuarioDAO().get(id);
    }
    
    public void limparCampos(UsuarioView view){
        view.jTNomeUsuario().setText("");
        view.jTEmail().setText("");
        view.jPSenha().setText("");
    }
}
