/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.examefacil.view;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JTextField;

/**
 *
 * @author Rafael
 */
public interface ParametrosView {
    
    public JFileChooser chooserEmailPDF();
    public JFileChooser chooserPastaImagens();
    public JFileChooser chooserPastaAudios();
    
    public JButton jBeditar();
    public JButton jBGravar();
    public JButton jBCancelar();
    public JButton jBFechar();
    public JButton jBSelecionarPdf();
    public JButton jBProcurarPastaImagem();
    public JButton jBProcurarPastaAudio();
    
    public JCheckBox jCEnviarEmailPDF();
    public JCheckBox jCAuditar();
    
    public JTextField jTxtEmailPDF();
    public JTextField jTxtPastaAudios();
    public JTextField jTxtPastaImagens();
    
    public JTextField jTxtSMTPServer();
    public JTextField jTxtEmailRemetente();
    public JTextField jTxtUsuarioSMTP();
    public JTextField jPSenhaSMTP();
    public JTextField jTxtPortaSMTP();
    
}
