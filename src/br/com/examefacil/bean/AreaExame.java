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
@Table(name="areaexame")
public class AreaExame {
    
    @Id
    @GeneratedValue
    @Column(name = "idareaexame")
    private int idareaexame;
    private String nome;

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

    
}
