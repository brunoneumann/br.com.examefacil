/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package br.com.examefacil.dao;

import br.com.examefacil.bean.AreaExame;
import java.util.List;


/**
 *
 * @author bruno
 */
public class AreaExameDAO {
    
    public boolean save(AreaExame obj) {
        return new CustomDAO<AreaExame>().save(obj);
    }

    public boolean delete(AreaExame obj) {
        return new CustomDAO<AreaExame>().delete(obj);
    }
    
    public AreaExame get(int id) {
        return new CustomDAO<AreaExame>().get(AreaExame.class, id);
    }
    
    public List<AreaExame> list() throws Exception {
        return null;
    }
    
    
    
}
