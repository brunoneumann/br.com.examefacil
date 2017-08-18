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
    
    public boolean salvar(AreaExame areaExame){
        return new AreaExameDAO().save(areaExame);
    }

    public boolean excluir(AreaExame areaExame){
        return new AreaExameDAO().delete(areaExame);
    }
}
