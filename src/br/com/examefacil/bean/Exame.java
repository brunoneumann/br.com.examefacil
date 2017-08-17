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
@Table(name="exame")
public class Exame {
    
    @Id
    @GeneratedValue
    @Column(name = "idexame")
    private int idexame;
    private int idusuario;
    private int idpaciente;
    private int idareaexame;
    private int idtextopadrao;
    private String status;
    @Temporal(TemporalType.DATE)
    private Calendar data;
    @Column(name = "hora_entrada")
    private String horaEntrada;
    @Column(name = "hora_saida")
    private String horaSaida;
    @Column(columnDefinition = "TEXT")
    private String observacoes;
    @Column(columnDefinition = "TEXT")
    private String resumo;

    public int getIdexame() {
        return idexame;
    }

    public void setIdexame(int idexame) {
        this.idexame = idexame;
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

    public int getIdareaexame() {
        return idareaexame;
    }

    public void setIdareaexame(int idareaexame) {
        this.idareaexame = idareaexame;
    }

    public int getIdtextopadrao() {
        return idtextopadrao;
    }

    public void setIdtextopadrao(int idtextopadrao) {
        this.idtextopadrao = idtextopadrao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
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

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    
    
    
    
}
