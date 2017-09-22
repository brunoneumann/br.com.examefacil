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
public class Parametro {
    
    private int campo;
    private String parametro;
    
    public Parametro(int campo, String parametro){
        this.campo = campo;
        this.parametro = parametro;
    }

    public int getCampo() {
        return campo;
    }

    public void setCampo(int campo) {
        this.campo = campo;
    }

    public String getParametro() {
        return parametro;
    }

    public void setParametro(String parametro) {
        this.parametro = parametro;
    }
    
    
    
    
}
