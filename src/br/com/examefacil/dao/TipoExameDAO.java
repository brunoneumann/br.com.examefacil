/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.examefacil.dao;

import br.com.examefacil.bean.TipoExame;
import java.util.List;

/**
 *
 * @author Henrique
 */
public class TipoExameDAO {

    public boolean save(TipoExame obj) {
        return new CustomDAO<TipoExame>().save(obj);
    }

    public boolean delete(TipoExame obj) {
        return new CustomDAO<TipoExame>().delete(obj);
    }
    
    public TipoExame get(int id) {
        return new CustomDAO<TipoExame>().get(TipoExame.class, id);
    }
    
    public List<TipoExame> list() {
        return new CustomDAO<TipoExame>().list(TipoExame.class);
    }
    
    public List<TipoExame> list(String parametro){
        return new CustomDAO<TipoExame>().list(TipoExame.class, "SELECT idtipoexame, t.idareaexame, t.nome, t.descricao, a.nome AS area FROM tipoexame t, areaexame a WHERE a.idareaexame = t.idareaexame AND idtipoexame LIKE '%' :idtipoexame '%'", "idtipoexame", parametro);
    }
    
}
