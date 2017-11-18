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
import javax.persistence.Transient;

/**
 *
 * @author Henrique
 */
@Entity
@Table(name="laudo")
public class Interpretacao {
    
    @Id
    @GeneratedValue
    @Column(name = "idlaudo")
    private int idlaudo;
    private int idusuario;
    private int idatendimento;
    private int idtipoexame;
    private int idtextopadrao;
    
    @Transient
    private String caminho;

    public int getIdlaudo() {
        return idlaudo;
    }

    public void setIdlaudo(int idlaudo) {
        this.idlaudo = idlaudo;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public int getIdatendimento() {
        return idatendimento;
    }

    public void setIdatendimento(int idatendimento) {
        this.idatendimento = idatendimento;
    }

    public int getIdtipoexame() {
        return idtipoexame;
    }

    public void setIdtipoexame(int idtipoexame) {
        this.idtipoexame = idtipoexame;
    }

    public int getIdtextopadrao() {
        return idtextopadrao;
    }

    public void setIdtextopadrao(int idtextopadrao) {
        this.idtextopadrao = idtextopadrao;
    }

    public String getCaminho() {
        return caminho;
    }

    public void setCaminho(String caminho) {
        this.caminho = caminho;
    }
    
    
    
}
