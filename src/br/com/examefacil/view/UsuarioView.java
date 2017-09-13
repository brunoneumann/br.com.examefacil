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
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Henrique
 */
public interface UsuarioView {
    
    public String getNome();
    public String getEmail();
    public String getTipoAcesso();
    public JTextField jTNomeUsuario();
    public JTextField jTEmail();
    public JComboBox jCTipoAcesso();
    public JTable JTABUsuarios();
    public JTextField jTPesquisar();
    
    public JButton jBIncluir();
    public JButton jBExcluir();
    public JButton jBPesquisar();
    public JButton jBEditar();
    public JButton jBGravar();
    public JButton jBCancelar();
    public JButton jBPermissoes();
    public JTabbedPane jTabUsuario();
    public JCheckBox jCInclusaoAutomatica();
    public JButton btnAbrirDialogAlteraSenha();
    public JLabel jLIDUsuario();
    
}
