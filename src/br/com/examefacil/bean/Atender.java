/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.examefacil.bean;


import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import java.util.Date;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

/**
 *
 * @author Henrique
 */
@Entity
@Table(name="atendimento_tipoexame")
public class Atender {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int idatend_tipo;
    private int idatendimento;
    private int idtipoexame;
    
    /*@Column(updatable = false, insertable = false)
    private String paciente;
    @Column(updatable = false, insertable = false)
    private Date data;
    @Column(updatable = false, insertable = false)
    private String hora;
    public String getPaciente() {
    return paciente;
    }
    public void setPaciente(String paciente) {
    this.paciente = paciente;
    }
    public Date getData() {
    return data;
    }
    public void setData(Date data) {
    this.data = data;
    }
    public String getHora() {
    return hora;
    }
    public void setHora(String hora) {
    this.hora = hora;
    }*/
    
    public int getIdatend_tipo() {
        return idatend_tipo;
    }
    
    public void setIdatend_tipo(int idatend_tipo) {
        this.idatend_tipo = idatend_tipo;
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
    
    
    
}
