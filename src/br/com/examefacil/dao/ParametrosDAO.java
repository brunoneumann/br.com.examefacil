package br.com.examefacil.dao;

import br.com.examefacil.bean.Parametros;
import br.com.examefacil.dao.CustomDAO;
import br.com.examefacil.tools.Constants;

/**
 *
 * @author bruno
 */
public class ParametrosDAO {
    
    public boolean save(Parametros obj) {
        return new CustomDAO<Parametros>().save(obj);
    }
    
    public Parametros get() {
        return new CustomDAO<Parametros>().get(Parametros.class, 1);
    }
    
    public void auditar(boolean auditar){
        if(auditar){
            for(String query : new Constants().SQLdropTriggersAuditoria){
                new CustomDAO<Parametros>().execute(query);
            }
            for(String query : new Constants().SQLcreateTriggersAuditoria){
                new CustomDAO<Parametros>().execute(query);
            }
        } else {
            for(String query : new Constants().SQLdropTriggersAuditoria){
                new CustomDAO<Parametros>().execute(query);
            }
        }
    }
    
}
