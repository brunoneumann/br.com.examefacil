/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.examefacil;

import br.com.examefacil.bean.AreaExame;
import br.com.examefacil.controller.AreaExameControl;

/**
 *
 * @author bruno
 */
public class Examefacil {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        AreaExame a = new AreaExame();
        a.setNome("qwerty");
        
        AreaExameControl control = new AreaExameControl();
        control.salvar(a);
    }
    
}
