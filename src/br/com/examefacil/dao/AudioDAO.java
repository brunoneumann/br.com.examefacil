/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package br.com.examefacil.dao;

import br.com.examefacil.bean.Audio;
import java.util.List;


/**
 *
 * @author bruno
 */
public class AudioDAO {
    
    public boolean save(Audio obj) {
        return new CustomDAO<Audio>().save(obj);
    }

    public boolean delete(Audio obj) {
        return new CustomDAO<Audio>().delete(obj);
    }
    
    public Audio get(int id) {
        return new CustomDAO<Audio>().get(Audio.class, id);
    }
    
    public List<Audio> list() {
        return new CustomDAO<Audio>().list(Audio.class);
    }
    
    public List<Audio> list(String parametro){
        return new CustomDAO<Audio>().list(Audio.class, "SELECT * FROM audios WHERE idatendimento LIKE '%' :idatendimento '%' ORDER BY idatendimento DESC", "idatendimento", parametro);
    }
    
    
    
}
