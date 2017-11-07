/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.examefacil.view;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Henrique
 */
public interface BuscaPacienteView {
    
    public JButton jBPesquisar();
    public JButton jBFechar();
    public JButton jBSelecionar();
    public JTextField jTPesquisar();
    public JTable JTABPacientes();
    
}
