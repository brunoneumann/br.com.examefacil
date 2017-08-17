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
@Table(name="textopadrao")
public class TextoPadrao {
    
    @Id
    @GeneratedValue
    @Column(name = "idtextopadrao")
    private int idtextopadrao;
    private String nomeCodigo;
    @Column(columnDefinition = "TEXT")
    private String texto;

    public int getIdtextopadrao() {
        return idtextopadrao;
    }

    public void setIdtextopadrao(int idtextopadrao) {
        this.idtextopadrao = idtextopadrao;
    }

    public String getNomeCodigo() {
        return nomeCodigo;
    }

    public void setNomeCodigo(String nomeCodigo) {
        this.nomeCodigo = nomeCodigo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
    
    
}
