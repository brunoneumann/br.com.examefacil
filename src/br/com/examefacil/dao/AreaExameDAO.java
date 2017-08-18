/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package br.com.examefacil.dao;

import br.com.examefacil.bean.AreaExame;
import br.com.examefacil.conn.HibernateUtil;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;


/**
 *
 * @author bruno
 */
public class AreaExameDAO implements InterfaceDAO<AreaExame>{
    
    final Logger log = LogManager.getLogger(AreaExameDAO.class.getName());
    
    @Override
    public boolean save(AreaExame obj) {
        try {
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            session.saveOrUpdate(obj);
            session.getTransaction().commit();
            return true;
        } catch(Exception ex){
            log.error(ex);
        } finally {
            HibernateUtil.getSessionFactory().close();
        }
        return false;
    }
    
    @Override
    public boolean delete(AreaExame obj) {
        try {
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            session.delete(obj);
            session.getTransaction().commit();
            return true;
        } catch(Exception ex){
            log.error(ex);
        } finally {
            HibernateUtil.getSessionFactory().close();
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
