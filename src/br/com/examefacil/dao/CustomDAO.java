/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package br.com.examefacil.dao;

import br.com.examefacil.bean.Parametro;
import br.com.examefacil.conn.HibernateUtil;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author bruno
 */
public class CustomDAO<T> implements InterfaceDAO<T>{
    
    final Logger log = LogManager.getLogger(CustomDAO.class.getName());
    final Session session;
    
    public CustomDAO() {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
    }
    
    @Override
    public boolean save(T obj) {
        try {
            session.beginTransaction();
            session.saveOrUpdate(obj);
            session.getTransaction().commit();
            return true;
        } catch(Exception ex){
            log.error(ex);
        } finally {
            if(session.isConnected()){
                session.close();
            }
        }
        return false;
    }
    
    @Override
    public boolean delete(T obj) {
        try {
            session.beginTransaction();
            session.delete(obj);
            session.getTransaction().commit();
            return true;
        } catch(Exception ex){
            log.error(ex);
        } finally {
            if(session.isConnected()){
                session.close();
            }
        }
        return false;
    }
    
    @Override
    public boolean execute(Class<T> type, String query) {
        try {
            session.beginTransaction();
            Query q = session.createSQLQuery(query).addEntity(type);
            int res = q.executeUpdate();
            session.getTransaction().commit();
            return  res >= 0;
        } catch(Exception ex){
            log.error(ex);
        } finally {
            if(session.isConnected()){
                session.close();
            }
        }
        return false;
    }
    
    @Override
    public boolean execute(Class<T> type, String query, List<Parametro> parametros) {
        try {
            session.beginTransaction();
            Query q = session.createSQLQuery(query).addEntity(type);
            for(Parametro p : parametros){
                q.setParameter(p.getCampo(), p.getParametro());
            }
            int res = q.executeUpdate();
            session.getTransaction().commit();
            return  res >= 0;
        } catch(Exception ex){
            log.error(ex);
        } finally {
            if(session.isConnected()){
                session.close();
            }
        }
        return false;
    }
    
    @Override
    public T get(Class<T> c, int id) {
        try {
            session.beginTransaction();
            T obj = c.cast(session.get(c, id));
            session.getTransaction().commit();
            return obj;
        } catch(Exception ex){
            log.error(ex);
        } finally {
            if(session.isConnected()){
                session.close();
            }
        }
        return null;
    }
    
    @Override
    public List<T> list(Class<T> type) {
        try {
            session.beginTransaction();
            Criteria crit = session.createCriteria(type);
            return crit.list();
        } catch(Exception ex){
            log.error(ex);
        } finally {
            if(session.isConnected()){
                session.close();
            }
        }
        return null;
    }
    
    @Override
    public List<T> list(Class<T> type, String query, String field, String parameter) {
        try {
            session.beginTransaction();
            Query q = session.createSQLQuery(query).addEntity(type);
            q.setParameter(field, parameter);
            return q.list();
        } catch(Exception ex){
            log.error(ex);
        } finally {
            if(session.isConnected()){
                session.close();
            }
        }
        return null;
    }
    
    @Override
    public List<T> list(Class<T> type, String query, List<Parametro> parametros) {
        try {
            session.beginTransaction();
            Query q = session.createSQLQuery(query).addEntity(type);
            for(Parametro p : parametros){
                q.setParameter(p.getCampo(), p.getParametro());
            }
            return q.list();
        } catch(Exception ex){
            log.error(ex);
        } finally {
            if(session.isConnected()){
                session.close();
            }
        }
        return null;
    }
    
}
