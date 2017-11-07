/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.examefacil.view;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Henrique
 */
public interface ExameView {
    
    public JButton jBIncluir();
    public JButton jBEditar();
    public JButton jBCancelar();
    public JButton jBGravar();
    public JButton jBExcluir();
    public JButton jBFechar();
    
    public String getPaciente();
    public String getData();
    public String getHoraAtendimeto();
    public String getHoraSaida();
    public JLabel jLIDExame();
    public JLabel JLIDPaciente();
    
    public JTextField jTPaciente();
    public JTextField jTDataAtendimento();
    public JTextField jTHoraEntrada();
    public JTextField jTHoraSaida();

    
}
