/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.examefacil.bean;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author bruno
 */
@Entity
@Table(name="atendimento")
public class Atendimento implements Serializable {
    
    @Id
    @GeneratedValue
    @Column(name = "idatendimento")
    private int idatendimento;
    private int idusuario;
    private int idpaciente;
    @Column(name = "data")
    private Date data;
    @Column(name = "hora_entrada")
    private String horaEntrada;
    @Column(name = "hora_saida")
    private String horaSaida;
    @Column(columnDefinition = "TEXT")
    private String observacoes;
    @Column(columnDefinition = "TEXT")
    private String status;
    
    @Transient
    private String nome_paciente;
    @Transient
    private String nome_usuario;
    @Transient 
    private String dataString;
    @Transient 
    private int qtdeAtendimentos;
    

    public int getIdatendimento() {
        return idatendimento;
    }

    public void setIdatendimento(int idatendimento) {
        this.idatendimento = idatendimento;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public int getIdpaciente() {
        return idpaciente;
    }

    public void setIdpaciente(int idpaciente) {
        this.idpaciente = idpaciente;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(String horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public String getHoraSaida() {
        return horaSaida;
    }

    public void setHoraSaida(String horaSaida) {
        this.horaSaida = horaSaida;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public String getNome_paciente() {
        return nome_paciente;
    }

    public void setNome_paciente(String nome_paciente) {
        this.nome_paciente = nome_paciente;
    }

    public String getNome_usuario() {
        return nome_usuario;
    }

    public void setNome_usuario(String nome_usuario) {
        this.nome_usuario = nome_usuario;
    }

    public String getDataString() {
        return dataString;
    }

    public void setDataString(String dataString) {
        this.dataString = dataString;
    }

    public int getQtdeAtendimentos() {
        return qtdeAtendimentos;
    }

    public void setQtdeAtendimentos(int qtdeAtendimentos) {
        this.qtdeAtendimentos = qtdeAtendimentos;
    }
    
    
    
    
}