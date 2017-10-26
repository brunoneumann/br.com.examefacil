/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.examefacil.view;

import javax.swing.JButton;
import javax.swing.JCheckBox;

/**
 *
 * @author Rafael
 */
public interface ParametrosView {
    
    public JButton jBeditar();
    public JButton jBGravar();
    public JButton jBCancelar();
    public JButton jBFechar();
    public JButton jBSelecionarPdf();
    public JButton jBProcurarImagem();
    public JButton jBProcurarAudio();
    
    public JCheckBox enviarEmail();
    public JCheckBox auditar();
    
    public String getPastaPdf();
    public String getPastaAudios();
    public String getPastaImagens();
}
