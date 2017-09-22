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
@Table(name="usuario")
public class Usuario {
    
    @Id
    @GeneratedValue
    @Column(name = "idusuario")
    private int idusuario;
    private String nome;
    private String email;
    @Column(updatable = false, insertable = false)
    private String senha;
    @Column(updatable = false, insertable = false)
    private String tipo_acesso;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public String getTipo_acesso() {
        return tipo_acesso;
    }

    public void setTipo_acesso(String tipo_acesso) {
        this.tipo_acesso = tipo_acesso;
    }
    
    
}
