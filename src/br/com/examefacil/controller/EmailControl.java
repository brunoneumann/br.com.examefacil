/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package br.com.examefacil.controller;

import br.com.examefacil.bean.Parametros;
import br.com.examefacil.dao.ParametrosDAO;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.commons.mail.ByteArrayDataSource;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.HtmlEmail;


public class EmailControl {
    
    public boolean enviarEmail(String endereco, String nome) {
        try {
            
            Parametros p = new ParametrosDAO().get();
            
            if(p.isEmailUsuario()){
                HtmlEmail email = new HtmlEmail();
                email.setHostName(p.getServerSMTP());
                email.addTo(endereco, nome);
                email.setFrom(p.getEmailSMTP(), "ExameFácil");
                email.setSubject("Bem vindo ao Exame Fácil");
                email.setSmtpPort(p.getPortaSMTP());
                email.setAuthenticator(new DefaultAuthenticator(p.getUserSMTP(), p.getSenhaSMTP()));
                email.setSSL(true);
                email.setTLS(false);
                
                email.attach(new ByteArrayDataSource(getPDFByteStream(p.getArqPDF()), "application/pdf"), "examefacil.pdf", "documento", EmailAttachment.ATTACHMENT);
                email.setHtmlMsg("<html>MENSAGEM EM FORMATO HTML</html>");
                
                email.send();
            }
            return true;
            
        } catch (Exception ex) {
            System.out.println(ex);
            return false;
        }
        
    }
    
    public byte[] getPDFByteStream(String arq) throws IOException {
        File file = new File(arq);
        
        byte[] b = new byte[(int) file.length()];
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            fileInputStream.read(b);
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não econtrado.");
            e.printStackTrace();
        } catch (IOException e1) {
            System.out.println("Erro na leitura do arquivo, tente novamente.");
            e1.printStackTrace();
        }
        return b;
    }
}
