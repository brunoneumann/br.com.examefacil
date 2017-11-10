/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.examefacil.dao;

import br.com.examefacil.bean.Atendimento;
import java.util.List;

/**
 *
 * @author Henrique
 */
public class AtendimentoDAO {
    
    
    public boolean save(Atendimento obj) {
        return new CustomDAO<Atendimento>().save(obj);
    }
    
    public boolean delete(Atendimento obj) {
        return new CustomDAO<Atendimento>().delete(obj);
    }
    
    public Atendimento get(int id) {
        return new CustomDAO<Atendimento>().get(Atendimento.class, id);
    }
    
    public List<Atendimento> list() {
        return new CustomDAO<Atendimento>().list(Atendimento.class);
    }
    
    public List<Atendimento> list(String parametro){
        return new CustomDAO<Atendimento>().list(Atendimento.class, "SELECT * FROM exame WHERE idpaciente LIKE '%' :idpaciente '%' ORDER BY data DESC", "idpaciente", parametro);
    }
    
}
