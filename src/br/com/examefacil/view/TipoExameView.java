/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.examefacil.view;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Henrique
 */
public interface TipoExameView {
    
    public String getNome();
    public String getDescricao();
    public int getIdareaexame();
    public JTextField jTTipoExame();
    public JTextArea jTDescricao();
    public JComboBox jCAreaExame();
    public JTable jTABTipoExame();
    public JTextField jTPesquisar();
    
    public JButton jBIncluir();
    public JButton jBExcluir();
    public JButton jBPesquisar();
    public JButton jBEditar();
    public JButton jBGravar();
    public JButton jBCancelar();
    public JTabbedPane jTabTipoExame();
    public JCheckBox jCInclusaoAutomatica();
    
    public JLabel jLIDTipoExame();
    
}
