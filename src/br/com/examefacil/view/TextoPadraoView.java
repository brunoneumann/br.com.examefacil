/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.examefacil.view;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Henrique
 */
public interface TextoPadraoView {
    
    public String getNome_codigo();
    public String getDescricao();
    public JTextField jTNome_codigo();
    public JTextArea jTDescricao();
    public JTable jTABTextoPadrao();
    public JTextField jTPesquisar();
    
    public JButton jBIncluir();
    public JButton jBExcluir();
    public JButton jBPesquisar();
    public JButton jBEditar();
    public JButton jBGravar();
    public JButton jBCancelar();
    public JTabbedPane jTabTextoPadrao();
    public JCheckBox jCInclusaoAutomatica();
    
    public JLabel jLIDTextoPadrao();
    
}
