/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.examefacil.bean;

/**
 *
 * @author bruno
 */
public class Exame extends CustomGeneric<Exame>{
    
    private int idexame;
    protected Usuario usuario;
    protected Paciente paciente;
    protected AreaExame areaexame;
    protected String status;
    protected String data;
    protected String resumo;

    public int getIdexame() {
        return idexame;
    }

    public void setIdexame(int idexame) {
        this.idexame = idexame;
    }

    protected Usuario getUsuario() {
        return usuario;
    }

    protected void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    protected Paciente getPaciente() {
        return paciente;
    }

    protected void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public AreaExame getAreaexame() {
        return areaexame;
    }

    public void setAreaexame(AreaExame areaexame) {
        this.areaexame = areaexame;
    }

    protected String getStatus() {
        return status;
    }

    protected void setStatus(String status) {
        this.status = status;
    }

    protected String getData() {
        return data;
    }

    protected void setData(String data) {
        this.data = data;
    }

    protected String getResumo() {
        return resumo;
    }

    protected void setResumo(String resumo) {
        this.resumo = resumo;
    }
    
    
    
    
}
