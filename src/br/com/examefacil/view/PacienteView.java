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
import javax.swing.JTextField;

/**
 *
 * @author bruno
 */
public interface PacienteView {
    public String getNome();
    public String getCPF();
    public String getEmail();
    public JTextField jTNomePaciente();
    public JTextField jTCPF();
    public JTextField JTEmail();
    public JTable JTABPacientes();
    public JTextField jTPesquisarPaciente();
    
    public JButton jBIncluir();
    public JButton jBExcluir();
    public JButton jBPesquisar();
    public JButton jBeditar();
    public JButton jBGravar();
    public JButton jBCancelar();
    public JTabbedPane jTabPaciente();
    public JCheckBox jCInclusaoAutomatica();
    
    public JLabel jLIDPaciente();
}