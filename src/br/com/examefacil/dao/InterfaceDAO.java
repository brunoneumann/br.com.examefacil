/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.examefacil.dao;

import java.util.List;

/**
 *
 * @author bruno
 */
public interface InterfaceDAO<T> {
    
    public boolean save(T obj) throws Exception;
    public boolean delete(T obj) throws Exception;
    public T get(Class<T> c, int id) throws Exception;
    public List<T> list(Class<T> c) throws Exception;
    public List<T> list(Class<T> c, String query, String field, String parameter) throws Exception;
    
}
