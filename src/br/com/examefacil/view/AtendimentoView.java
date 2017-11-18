/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.examefacil.view;

import com.toedter.calendar.JDateChooser;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Henrique
 */
public interface AtendimentoView {
    
    public JButton jBGravar();
    public JButton jBFechar();
    
    public String getPaciente();
    public Date getData();
    public String getHoraAtendimeto();
    public String getHoraSaida();
    public String getObservacoes();
    public JLabel jLIDAtendimento();
    public JLabel JLIDPaciente();
    public JLabel jLIDUsuario();
    
    public JTextField jTPaciente();
    public JDateChooser jDtDataAtendimento();
    public JTextField jTHoraEntrada();
    public JTextField jTHoraSaida();
    public JTextArea jTObservacoes();
}
