/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.examefacil;

import br.com.examefacil.bean.AreaExame;
import br.com.examefacil.controller.AreaExameControl;
import br.com.examefacil.swing.TelaPrincipal;
import br.com.examefacil.swing.TelaTipoExame;

/**
 *
 * @author bruno
 */
public class Examefacil {

    public static void main(String[] args) {
        
        /*AreaExame a = new AreaExame();
        a.setNome("qwerty");
        
        AreaExameControl control = new AreaExameControl();
        control.salvar(a);*/
        
        new TelaPrincipal().setVisible(true);
        
    }
    
}
