/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.examefacil.dao;

import br.com.examefacil.bean.Atender;
import java.util.List;

/**
 *
 * @author Henrique
 */
public class AtenderDAO {
    
    public boolean save(Atender obj) {
        Atender a = (Atender)obj;
        System.out.println(a.getIdatendimento()+" "+a.getIdtipoexame());
        
        return new CustomDAO<Atender>().save(obj);
    }
    
    public boolean delete(Atender obj) {
        return new CustomDAO<Atender>().delete(obj);
    }
    
    public Atender get(int id) {
        return new CustomDAO<Atender>().get(Atender.class, id);
    }
    
    public List<Atender> list() {
        return new CustomDAO<Atender>().list(Atender.class);
    }
    
    public List<Atender> list(String parametro){
        return new CustomDAO<Atender>().list(Atender.class, "SELECT * FROM atendimento_tipoexame WHERE idatendimento LIKE '%' :idatendimento '%' DESC", "idatendimento", parametro);
    }
    
}
