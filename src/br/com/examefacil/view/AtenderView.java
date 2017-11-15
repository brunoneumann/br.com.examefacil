/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.examefacil.view;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Henrique
 */
public interface AtenderView {
    
    public JButton jBIncluir();
    public JButton jBCancelar();
    public JButton jBEnviarExame();
    public JTextField jTSolicitarExame();
    public JLabel jLPaciente();
    public JLabel jLData();
    public JLabel jLHora();
    public JLabel jLIDAtendimento();
    public JTable jTSolicitados();

    
    
}
