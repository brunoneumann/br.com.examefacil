/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.examefacil.view;

import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author bruno
 */
public interface UsuarioView {
    
    public String getNome();
    public String getEmail();
    public String getSenha();

    public JTextField jTNomeUsuario();
    public JTextField jTEmail();
    public JPasswordField jPSenha();
    
}
