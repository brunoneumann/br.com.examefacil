/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package br.com.examefacil.controller;

import br.com.examefacil.bean.AreaExame;
import br.com.examefacil.dao.AreaExameDAO;

/**
 *
 * @author bruno
 */
public class AreaExameControl {
    
    public AreaExameControl(){}
    
    public boolean inserir(AreaExame areaExame) {
        return new AreaExameDAO().insert(areaExame);
    }
    public boolean alterar(AreaExame areaExame){
        return new AreaExameDAO().update(areaExame);
    }
    public boolean excluir(AreaExame areaExame){
        return new AreaExameDAO().delete(areaExame);
    }
}
