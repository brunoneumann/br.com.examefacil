/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.examefacil.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author bruno
 */

@Entity
@Table(name="parametros")
public class Parametros {
    
    @Id
    @Column(name = "idparametros")
    private int idparametros;
    @Column(name = "pasta_imagens")
    private String pastaImagens;
    @Column(name = "pasta_audios")
    private String pastaAudios;
    
    private boolean auditar;
    @Column(name = "email_usuario")
    private boolean emailUsuario;
    @Column(name = "arq_pdf")
    private String arqPDF;
    @Column(name = "server_smtp")
    private String serverSMTP;
    @Column(name = "email_smtp")
    private String emailSMTP;
    @Column(name = "user_smtp")
    private String userSMTP;
    @Column(name = "senha_smtp")
    private String senhaSMTP;
    @Column(name = "porta_smtp")
    private int portaSMTP;

    public int getIdparametros() {
        return idparametros;
    }

    public void setIdparametros(int idparametros) {
        this.idparametros = idparametros;
    }

    public String getPastaImagens() {
        return pastaImagens;
    }

    public void setPastaImagens(String pastaImagens) {
        this.pastaImagens = pastaImagens;
    }

    public String getPastaAudios() {
        return pastaAudios;
    }

    public void setPastaAudios(String pastaAudios) {
        this.pastaAudios = pastaAudios;
    }

    public boolean isAuditar() {
        return auditar;
    }

    public void setAuditar(boolean auditar) {
        this.auditar = auditar;
    }

    public boolean isEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(boolean emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public String getArqPDF() {
        return arqPDF;
    }

    public void setArqPDF(String arqPDF) {
        this.arqPDF = arqPDF;
    }

    public String getServerSMTP() {
        return serverSMTP;
    }

    public void setServerSMTP(String serverSMTP) {
        this.serverSMTP = serverSMTP;
    }

    public String getEmailSMTP() {
        return emailSMTP;
    }

    public void setEmailSMTP(String emailSMTP) {
        this.emailSMTP = emailSMTP;
    }

    public String getUserSMTP() {
        return userSMTP;
    }

    public void setUserSMTP(String userSMTP) {
        this.userSMTP = userSMTP;
    }

    public String getSenhaSMTP() {
        return senhaSMTP;
    }

    public void setSenhaSMTP(String senhaSMTP) {
        this.senhaSMTP = senhaSMTP;
    }

    public int getPortaSMTP() {
        return portaSMTP;
    }

    public void setPortaSMTP(int portaSMTP) {
        this.portaSMTP = portaSMTP;
    }
    
    
    
}
