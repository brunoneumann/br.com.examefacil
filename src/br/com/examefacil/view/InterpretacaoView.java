/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.examefacil.view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;

/**
 *
 * @author Henrique
 */
public interface InterpretacaoView {
    
    public JButton jBGravar();
    public JButton jBCancelar();
    public JButton jBFechar();
    public JButton jBLaudar();
    public JButton jBGravarLaudo();
    public JButton jBCancelarLaudo();
    public JButton jBFecharLaudo();
    public JButton jBTextoPadrao();
    public JTextArea jTLaudo();
    public JLabel jLIDTextoPadrao();
    
    
}
