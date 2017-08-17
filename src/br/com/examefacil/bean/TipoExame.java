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
@Table(name="tipoexame")
public class TipoExame {
    
    @Id
    @GeneratedValue
    @Column(name = "idtipoexame")
    private int idtipoexame;
    private int idareaexame;
    private String nome;
    @Column(columnDefinition = "TEXT")
    private String descricao;

    public int getIdtipoexame() {
        return idtipoexame;
    }

    public void setIdtipoexame(int idtipoexame) {
        this.idtipoexame = idtipoexame;
    }

    public int getIdareaexame() {
        return idareaexame;
    }

    public void setIdareaexame(int idareaexame) {
        this.idareaexame = idareaexame;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    
}
