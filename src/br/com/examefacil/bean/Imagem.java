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
    private int idtipoexame;
    private int idatendimento;
    @Column(name = "nome_arquivo")
    private String nomeArquivo;
    @Column(columnDefinition = "TEXT")
    private String detalhes;

    public int getIdtipoexame() {
        return idtipoexame;
    }

    public void setIdtipoexame(int idtipoexame) {
        this.idtipoexame = idtipoexame;
    }

    public int getIdatendimento() {
        return idatendimento;
    }

    public void setIdatendimento(int idatendimento) {
        this.idatendimento = idatendimento;
    }

    public int getIdimagem() {
        return idimagem;
    }

    public void setIdimagem(int idimagem) {
        this.idimagem = idimagem;
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
