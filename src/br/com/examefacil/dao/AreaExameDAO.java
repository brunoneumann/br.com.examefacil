/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package br.com.examefacil.dao;

import br.com.examefacil.bean.AreaExame;
import br.com.examefacil.conn.ConnDB;
import java.util.List;
import javax.persistence.EntityManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 *
 * @author bruno
 */
public class AreaExameDAO implements InterfaceDAO<AreaExame>{
    
    static final Logger log = LogManager.getLogger(AreaExameDAO.class.getName());
    
    @Override
    public boolean insert(AreaExame obj) {
        try {
            ConnDB connection = new ConnDB();
            EntityManager manager = connection.entityManager();
            manager.getTransaction().begin();
            manager.persist(obj);
            manager.getTransaction().commit();
            manager.close();
            connection.closeConnection();
            return true;
        } catch(Exception ex){
            log.error(ex);
            ex.printStackTrace();
        }
        return false;
    }
    
    @Override
    public boolean delete(AreaExame obj) {
        try {
            ConnDB connection = new ConnDB();
            EntityManager manager = connection.entityManager();
            manager.getTransaction().begin();
            AreaExame areaExame = manager.merge(obj);
            manager.remove(areaExame);
            manager.getTransaction().commit();
            manager.close();
            connection.closeConnection();
            return true;
        } catch(Exception ex){
            log.error(ex);
            ex.printStackTrace();
        }
        return false;
    }
    
    @Override
    public boolean update(AreaExame obj) {
        try {
            ConnDB connection = new ConnDB();
            EntityManager manager = connection.entityManager();
            manager.getTransaction().begin();
            manager.merge(obj);
            manager.getTransaction().commit();
            manager.close();
            connection.closeConnection();
            return true;
        } catch(Exception ex){
            log.error(ex);
            ex.printStackTrace();
        }
        return false;
    }
    
    @Override
    public AreaExame get(AreaExame obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public List<AreaExame> list() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }    
    
}
