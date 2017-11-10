/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.examefacil.dao;

import br.com.examefacil.bean.Exame;
import java.util.List;

/**
 *
 * @author Henrique
 */
public class ExameDAO {
    
    
    public boolean save(Exame obj) {
        return new CustomDAO<Exame>().save(obj);
    }
    
    public boolean delete(Exame obj) {
        return new CustomDAO<Exame>().delete(obj);
    }
    
    public Exame get(int id) {
        return new CustomDAO<Exame>().get(Exame.class, id);
    }
    
    public List<Exame> list() {
        return new CustomDAO<Exame>().list(Exame.class);
    }
    
    public List<Exame> list(String parametro){
        return new CustomDAO<Exame>().list(Exame.class, "SELECT * FROM exame WHERE idpaciente LIKE '%' :idpaciente '%' ORDER BY data DESC", "idpaciente", parametro);
    }
    
}
