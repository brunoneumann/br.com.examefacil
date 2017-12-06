/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.examefacil.view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextArea;

/**
 *
 * @author Henrique
 */
public interface LaudoView {
    
    public JButton jBFechar();
    public JTextArea jTInterpretacao();
    public JTable jTExames();
    public JButton jBPlay();
    public JLabel jLImagem();
    public JLabel jLIDAtendimento();
    public JLabel jLAudio();
    
}
