/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.examefacil;

import br.com.examefacil.bean.AreaExame;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author bruno
 */
public class Examefacil {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        AreaExame a = new AreaExame();
        a.setNome("TESTE2");
        
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("examefacil");
        EntityManager manager = factory.createEntityManager();
        
        manager.getTransaction().begin();
        manager.persist(a);
        manager.getTransaction().commit();
        
        manager.close();
        factory.close();
    }   
    
}
