/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.examefacil.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Henrique
 */
public interface LoginView {
    
    public String getUsuario();
    public String getSenha();
    public JFrame jILogin();
    public JTextField jTUsuario();
    public JPasswordField jPSenha();
    public JButton jBEntrar();
    
}
