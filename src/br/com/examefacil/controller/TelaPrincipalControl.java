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
        desahabilitaMenus(view);
        
    }
        
    public void habilitaMenus (TelaPrincipalView view){
        view.jMenu1().setEnabled(true);
        view.jMenuBar1().setEnabled(true);
        view.jMCadastro().setEnabled(true);
        view.jILogin().setVisible(false);
        view.jIExame().setVisible(true);
    }
    public void desahabilitaMenus (TelaPrincipalView view){
        view.jMenu1().setEnabled(false);
        view.jMenuBar1().setEnabled(false);
        view.jMCadastro().setEnabled(false);
        view.jILogin().setVisible(true);
        view.jIExame().setVisible(false);
        
    }
    
}
