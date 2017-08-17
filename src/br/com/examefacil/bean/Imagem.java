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
@Table(name="imagens")
public class Imagem {

    @Id
    @GeneratedValue
    @Column(name = "idimagem")
    private int idimagem;
    private int idexame;
    @Column(name = "nome_arquivo")
    private String nomeArquivo;
    @Column(columnDefinition = "TEXT")
    private String detalhes;

    public int getIdimagem() {
        return idimagem;
    }

    public void setIdimagem(int idimagem) {
        this.idimagem = idimagem;
    }

    public int getIdexame() {
        return idexame;
    }

    public void setIdexame(int idexame) {
        this.idexame = idexame;
    }

    public String getNomeArquivo() {
        return nomeArquivo;
    }

    public void setNomeArquivo(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    public String getDetalhes() {
        return detalhes;
    }

    public void setDetalhes(String detalhes) {
        this.detalhes = detalhes;
    }
    
    

}
