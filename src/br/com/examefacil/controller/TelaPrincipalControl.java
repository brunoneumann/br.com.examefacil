/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.examefacil.controller;

import br.com.examefacil.view.TelaPrincipalView;

/**
 *
 * @author Henrique
 */
public class TelaPrincipalControl {
    
    public void init(TelaPrincipalView view){
        desabilitaMenus(view);
        
    }
        
    public void habilitaMenus (TelaPrincipalView view){
        view.jMenu1().setEnabled(true);
        view.jMenuBar1().setEnabled(true);
        view.jMCadastro().setEnabled(true);
        view.jILogin().setVisible(false);
        view.jIExame().setVisible(true);
    }
    public void desabilitaMenus (TelaPrincipalView view){
        view.jMenu1().setEnabled(false);
        view.jMenuBar1().setEnabled(false);
        view.jMCadastro().setEnabled(false);
        view.jILogin().setVisible(true);
        view.jILogin().setSize(280, 200);
        view.jILogin().setAlignmentX(1);
        view.jILogin().setAlignmentY(1);
        view.jIExame().setVisible(false);
        
    }
    
}
