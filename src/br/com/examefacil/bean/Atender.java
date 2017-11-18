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
import java.util.Objects;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Transient;

/**
 *
 * @author Henrique
 */
@Entity
@Table(name="atendimento_tipoexame")
public class Atender {
    
    @Id
    @GeneratedValue
    private int idatend_tipo;
    private int idatendimento;
    private int idtipoexame;
    
    @Transient
    private String paciente;
    @Transient
    private Date data;
    @Transient
    private String hora;
    @Transient
    private String tipoexame;
    @Transient
    private String areaexame;
    
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
    }
    
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

    public String getTipoexame() {
        return tipoexame;
    }

    public void setTipoexame(String tipoexame) {
        this.tipoexame = tipoexame;
    }

    public String getAreaexame() {
        return areaexame;
    }

    public void setAreaexame(String areaexame) {
        this.areaexame = areaexame;
    }
    
    @Override
    public String toString() {
        String texto = areaexame+" - "+tipoexame;
        return texto;
    }
    
     @Override
    public boolean equals(Object obj) {
        Atender a = (Atender) obj;
        return Objects.equals(this.idatend_tipo, a.idatend_tipo);
    }
    
    
    
}
