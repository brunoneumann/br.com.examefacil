/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.examefacil.dao;

import br.com.examefacil.bean.Paciente;
import java.util.List;

/**
 *
 * @author bruno
 */
public class PacienteDAO {
    
    public boolean save(Paciente obj) {
        return new CustomDAO<Paciente>().save(obj);
    }

    public boolean delete(Paciente obj) {
        return new CustomDAO<Paciente>().delete(obj);
    }
    
    public Paciente get(int id) {
        return new CustomDAO<Paciente>().get(Paciente.class, id);
    }
    
    public List<Paciente> list() throws Exception {
        return null;
    }
    
}
