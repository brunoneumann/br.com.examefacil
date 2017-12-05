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
@Table(name="audios")
public class Audio {
    
    @Id
    @GeneratedValue
    @Column(name = "idaudio")
    private int idaudio;
    private int idatendimento;
    @Column(name="nome_arquivo")
    private String nomeArquivo;
    @Column(columnDefinition = "TEXT")
    private String detalhes;

    public int getIdaudio() {
        return idaudio;
    }

    public void setIdaudio(int idaudio) {
        this.idaudio = idaudio;
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

    public int getIdatendimento() {
        return idatendimento;
    }

    public void setIdatendimento(int idatendimento) {
        this.idatendimento = idatendimento;
    }


    
    
}
