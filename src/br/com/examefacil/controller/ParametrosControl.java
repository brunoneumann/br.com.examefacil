/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package br.com.examefacil.controller;

import br.com.examefacil.bean.Acesso;
import br.com.examefacil.bean.Parametros;
import br.com.examefacil.dao.ParametrosDAO;
import br.com.examefacil.swing.TelaPrincipal;
import br.com.examefacil.tools.Util;
import br.com.examefacil.view.ParametrosView;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author bruno
 */
public class ParametrosControl {
    
    ParametrosView view;
    
    public ParametrosControl(ParametrosView view){
        this.view = view;
    }
    
    public void init(){
        carregaPermissoes(view);
        carregarParametrosSalvos(view);
        habilitarTodos(false);
    }
    
    public void carregaPermissoes(ParametrosView view) {
        List<Acesso> permissoes = new AcessoControl().listaAcessosUsuario(TelaPrincipal.usuarioLogado.getIdusuario());
        for (Acesso a : permissoes) {
            if (a.getPagina().equals("parametros")) {
                view.jBeditar().setEnabled(a.isAlterar());
                break;
            }
        }
    }
    
    public void carregarParametrosSalvos(ParametrosView view){
        Parametros p = new ParametrosDAO().get();
        if(p!=null){
            view.jCEnviarEmailPDF().setSelected(p.isEmailUsuario());
            if(p.isEmailUsuario()){
                view.jTxtEmailPDF().setText(p.getArqPDF());
                view.jTxtSMTPServer().setText(p.getServerSMTP());
                view.jTxtEmailRemetente().setText(p.getEmailSMTP());
                view.jTxtUsuarioSMTP().setText(p.getUserSMTP());
                view.jPSenhaSMTP().setText(p.getSenhaSMTP());
                view.jTxtPortaSMTP().setText(p.getPortaSMTP()+"");
            }
            view.jCAuditar().setSelected(p.isAuditar());
            view.jTxtPastaAudios().setText(p.getPastaAudios());
            view.jTxtPastaImagens().setText(p.getPastaImagens());
        }
    }
    
    public boolean salvar(){
        if (validarCampos(view)){
            Parametros parametros = new Parametros();
            parametros.setIdparametros(1);
            parametros.setEmailUsuario(view.jCEnviarEmailPDF().isSelected());
            if(view.jCEnviarEmailPDF().isSelected()){
                parametros.setEmailUsuario(true);
                parametros.setArqPDF(view.jTxtEmailPDF().getText());
                parametros.setServerSMTP(view.jTxtSMTPServer().getText());
                parametros.setEmailSMTP(view.jTxtEmailRemetente().getText());
                parametros.setUserSMTP(view.jTxtUsuarioSMTP().getText());
                parametros.setSenhaSMTP(view.jPSenhaSMTP().getText());
                parametros.setPortaSMTP(Integer.parseInt(view.jTxtPortaSMTP().getText()));
            }
            parametros.setAuditar(view.jCAuditar().isSelected());
            parametros.setPastaAudios(view.jTxtPastaAudios().getText());
            parametros.setPastaImagens(view.jTxtPastaImagens().getText());
            
            boolean result = new ParametrosDAO().save(parametros);
            if(result){
                
                // Ativar/Desativar Triggers
                new ParametrosDAO().auditar(parametros.isAuditar());
                
                habilitarTodos(false);
                Util.Aviso("Configurações salvas com sucesso!");
            }
            return result;
        }
        else {
            return false;
        }
    }
    
    public boolean validarCampos(ParametrosView view){
        ArrayList<String> campos = new ArrayList<>();
        ArrayList<String> nomes = new ArrayList<>();
        if(view.jCEnviarEmailPDF().isSelected()){
            campos.add(view.jTxtEmailPDF().getText());
            campos.add(view.jTxtSMTPServer().getText());
            campos.add(view.jTxtEmailRemetente().getText());
            campos.add(view.jTxtUsuarioSMTP().getText());
            campos.add(view.jPSenhaSMTP().getText());
            campos.add(view.jTxtPortaSMTP().getText());
            nomes.add(view.jTxtEmailPDF().getName());
            nomes.add(view.jTxtSMTPServer().getName());
            nomes.add(view.jTxtEmailRemetente().getName());
            nomes.add(view.jTxtUsuarioSMTP().getName());
            nomes.add(view.jPSenhaSMTP().getName());
            nomes.add(view.jTxtPortaSMTP().getName());
        }
        
        campos.add(view.jTxtPastaAudios().getText());
        campos.add(view.jTxtPastaImagens().getText());
        nomes.add(view.jTxtPastaAudios().getName());
        nomes.add(view.jTxtPastaImagens().getName());
        
        return Util.validaCampos(campos, nomes);
    }
    
    public void habilitarTodos(boolean value){
        view.jBGravar().setEnabled(value);
        view.jCEnviarEmailPDF().setEnabled(value);
        view.jCAuditar().setEnabled(value);
        view.jTxtPastaAudios().setEnabled(value);
        view.jBProcurarPastaAudio().setEnabled(value);
        view.jTxtPastaImagens().setEnabled(value);
        view.jBProcurarPastaImagem().setEnabled(value);
        view.jBSelecionarPdf().setEnabled(value);
        view.jTxtEmailPDF().setEnabled(value);
        view.jTxtSMTPServer().setEnabled(value);
        view.jTxtEmailRemetente().setEnabled(value);
        view.jTxtUsuarioSMTP().setEnabled(value);
        view.jTxtSMTPServer().setEnabled(value);
        view.jPSenhaSMTP().setEnabled(value);
        view.jTxtPortaSMTP().setEnabled(value);
    }
    
    public void ativarEnvioEmailPDF(){
        if(view.jCEnviarEmailPDF().isSelected()){
            view.jTxtEmailPDF().setEnabled(true);
            view.jBSelecionarPdf().setEnabled(true);
            view.jTxtSMTPServer().setEnabled(true);
            view.jTxtEmailRemetente().setEnabled(true);
            view.jTxtUsuarioSMTP().setEnabled(true);
            view.jTxtSMTPServer().setEnabled(true);
            view.jPSenhaSMTP().setEnabled(true);
            view.jTxtPortaSMTP().setEnabled(true);
        } else {
            view.jTxtEmailPDF().setEnabled(false);
            view.jBSelecionarPdf().setEnabled(false);
            view.jTxtSMTPServer().setEnabled(false);
            view.jTxtEmailRemetente().setEnabled(false);
            view.jTxtUsuarioSMTP().setEnabled(false);
            view.jTxtSMTPServer().setEnabled(false);
            view.jPSenhaSMTP().setEnabled(false);
            view.jTxtPortaSMTP().setEnabled(false);
        }
    }
    
    public void initChooserEmailPDF(){
        view.chooserEmailPDF().setCurrentDirectory(new java.io.File("."));
        view.chooserEmailPDF().setDialogTitle("Selecione um arquivo");
        view.chooserEmailPDF().setFileSelectionMode(JFileChooser.FILES_ONLY);
        view.chooserEmailPDF().setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("PDF", "pdf", "pdf");
        view.chooserEmailPDF().setFileFilter(filter);
        
        if (view.chooserEmailPDF().showOpenDialog(view.chooserEmailPDF()) == JFileChooser.APPROVE_OPTION) {
            view.jTxtEmailPDF().setText(view.chooserEmailPDF().getSelectedFile().toString());
        }
    }
    
    public void initChooserProcurarAudios(){
        view.chooserPastaAudios().setCurrentDirectory(new java.io.File("."));
        view.chooserPastaAudios().setDialogTitle("Selecione uma pasta");
        view.chooserPastaAudios().setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        view.chooserPastaAudios().setAcceptAllFileFilterUsed(false);
        
        if (view.chooserPastaAudios().showOpenDialog(view.chooserPastaAudios()) == JFileChooser.APPROVE_OPTION) {
            view.jTxtPastaAudios().setText(view.chooserPastaAudios().getSelectedFile().toString());
        }
    }
    
    public void initChooserProcurarImagens(){
        view.chooserPastaImagens().setCurrentDirectory(new java.io.File("."));
        view.chooserPastaImagens().setDialogTitle("Selecione uma pasta");
        view.chooserPastaImagens().setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        view.chooserPastaImagens().setAcceptAllFileFilterUsed(false);
        
        if (view.chooserPastaImagens().showOpenDialog(view.chooserPastaImagens()) == JFileChooser.APPROVE_OPTION) {
            view.jTxtPastaImagens().setText(view.chooserPastaImagens().getSelectedFile().toString());
        }
    }
    
    
    
}
