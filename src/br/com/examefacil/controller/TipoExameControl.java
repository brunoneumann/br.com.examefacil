/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.examefacil.controller;

import br.com.examefacil.bean.TipoExame;
import br.com.examefacil.dao.TipoExameDAO;

/**
 *
 * @author Henrique
 */
public class TipoExameControl {
    
    public TipoExameControl(){}
    
    public boolean salvar(TipoExame areaExame){
        return new TipoExameDAO().save(areaExame);
    }

    public boolean excluir(TipoExame areaExame){
        return new TipoExameDAO().delete(areaExame);
    }
    
    public TipoExame get(int id){
        return new TipoExameDAO().get(id);
    }
    
}