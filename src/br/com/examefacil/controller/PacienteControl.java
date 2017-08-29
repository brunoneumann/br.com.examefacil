/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.examefacil.controller;

import br.com.examefacil.bean.Paciente;
import br.com.examefacil.dao.PacienteDAO;
import java.util.List;

/**
 *
 * @author bruno
 */
public class PacienteControl {
    
    public PacienteControl(){}
    
    public boolean salvar(Paciente paciente){
        return new PacienteDAO().save(paciente);
    }

    public boolean excluir(Paciente paciente){
        return new PacienteDAO().delete(paciente);
    }
    
    public Paciente get(int id){
        return new PacienteDAO().get(id);
    }
    
    public List<Paciente> listar(){
        return new PacienteDAO().list();
    }
    
    public List<Paciente> listar(String parametro){
        return new PacienteDAO().list(parametro);
    }
    
    
}
