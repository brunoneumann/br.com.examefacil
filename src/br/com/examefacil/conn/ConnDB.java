/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.examefacil.conn;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author bruno
 */
public class ConnDB {
    private EntityManagerFactory factory;
 
    public ConnDB() {
        this.factory = Persistence.createEntityManagerFactory("examefacil");
    }
    
    public EntityManager entityManager(){
        return factory.createEntityManager();
    }
    
    public void closeConnection(){
        this.factory.close();
    }
    
}
