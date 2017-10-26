/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.examefacil.controller;

import static com.mchange.v2.log.MLog.log;
import static com.sun.activation.registries.LogSupport.log;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import static java.lang.Math.log;
import static java.lang.StrictMath.log;
import static java.rmi.server.LogStream.log;
import org.apache.commons.mail.ByteArrayDataSource;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.HtmlEmail;
import static sun.security.krb5.Confounder.bytes;

/**
 *
 * @author Rafael
 */
public class EmailControl {

    public boolean enviarEmail(String endereco, String nome) {
        try {

            HtmlEmail email = new HtmlEmail();
            email.setHostName("smtp.gmail.com");
            email.addTo(endereco, nome);
            email.setFrom("ikigroove@gmail.com", "Henrique");
            email.setSubject("Exame Fácil");
            email.setSmtpPort(587);
            email.setAuthenticator(new DefaultAuthenticator("ikigroove@gmail.com", "hs1937bs"));
            email.setSSL(true);
            email.setTLS(false);

            /* Adicionar o anexo */
 /* ATENÇÃO: "bytes" significa tamanho em bytes do PDF */
            //email.attach(new ByteArrayDataSource(bytes(139264), "application/pdf"), "documento.pdf", "documento", EmailAttachment.ATTACHMENT);
            email.attach(new ByteArrayDataSource(getPDFByteStream(), "application/pdf"), "documento.pdf", "documento", EmailAttachment.ATTACHMENT);
            email.setHtmlMsg("<html>MENSAGEM EM FORMATO HTML</html>");

            email.send();
            return true;

        } catch (Exception ex) {
            System.out.println(ex);
            return false;
        }

    }
    
    public byte[] getPDFByteStream() throws IOException {
    File file = new File("C:\\pdf\\documento.pdf");

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
