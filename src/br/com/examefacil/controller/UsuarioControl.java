/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.examefacil.controller;

import br.com.examefacil.bean.Usuario;
import br.com.examefacil.dao.UsuarioDAO;

/**
 *
 * @author Henrique
 */
public class UsuarioControl {
        public UsuarioControl(){}
    
    public boolean salvar(Usuario areaExame){
        return new UsuarioDAO().save(areaExame);
    }

    public boolean excluir(Usuario areaExame){
        return new UsuarioDAO().delete(areaExame);
    }
    
    public Usuario get(int id){
        return new UsuarioDAO().get(id);
    }
}
