/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.examefacil.bean;

import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author bruno
 */

@Entity
@Table(name="auditoria_exame")
public class AuditoriaExame {
    
    @Id
    @GeneratedValue
    @Column(name = "idauditoria")
    private int idauditoria;
    private String nome_usuario;
    private int idexame;
    @Temporal(TemporalType.DATE)
    private Calendar data;
    private String campo;
    @Column(name = "data_anterior", columnDefinition = "TEXT")
    private String dadoAnterior;
    @Column(name = "dado_novo", columnDefinition = "TEXT")
    private String dadoNovo;
    private String tipoAlteracao;

    public int getIdauditoria() {
        return idauditoria;
    }

    public void setIdauditoria(int idauditoria) {
        this.idauditoria = idauditoria;
    }

    public String getNome_usuario() {
        return nome_usuario;
    }

    public void setNome_usuario(String nome_usuario) {
        this.nome_usuario = nome_usuario;
    }

    public int getIdexame() {
        return idexame;
    }

    public void setIdexame(int idexame) {
        this.idexame = idexame;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public String getCampo() {
        return campo;
    }

    public void setCampo(String campo) {
        this.campo = campo;
    }

    public String getDadoAnterior() {
        return dadoAnterior;
    }

    public void setDadoAnterior(String dadoAnterior) {
        this.dadoAnterior = dadoAnterior;
    }

    public String getDadoNovo() {
        return dadoNovo;
    }

    public void setDadoNovo(String dadoNovo) {
        this.dadoNovo = dadoNovo;
    }

    public String getTipoAlteracao() {
        return tipoAlteracao;
    }

    public void setTipoAlteracao(String tipoAlteracao) {
        this.tipoAlteracao = tipoAlteracao;
    }
    
    
    
}
