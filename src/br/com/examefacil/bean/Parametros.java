/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.examefacil.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
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
    @GeneratedValue
    @Column(name = "idparametros")
    private int idparametros;
    @Column(name = "pasta_imagens")
    private String pastaImagens;
    @Column(name = "pasta_audios")
    private String pastaAudios;
    private boolean auditar;

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
    
    
}