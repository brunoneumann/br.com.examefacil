/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.examefacil.controller;

import br.com.examefacil.bean.Acesso;
import br.com.examefacil.dao.AcessoDAO;
import java.util.List;

/**
 *
 * @author bruno
 */
public class AcessoControl {
    
    public List<Acesso> listaAcessosUsuario(int idusuario){
        return new AcessoDAO().listaAcessos(idusuario+"");
    }
}
