/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.examefacil.view;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JTable;

/**
 *
 * @author Henrique
 */
public interface ImagemView {
    
    public JButton jBAdicionar();
    public JButton jBExcluir();
    public JButton jBFechar();
    public JButton jBEnviar();
    public JComboBox jCImagens();
    public JLabel jLIDAtendimento();
    public JTable jTImagens();
    public JLabel jLIDImagem();
    
    public JFileChooser chooserImagens();
    
}
