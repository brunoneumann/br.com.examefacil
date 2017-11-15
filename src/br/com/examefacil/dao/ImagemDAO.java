/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.examefacil.dao;

import br.com.examefacil.bean.Imagem;
import java.util.List;

/**
 *
 * @author Henrique
 */
public class ImagemDAO {
    
    public boolean save(Imagem obj) {
        
        return new CustomDAO<Imagem>().save(obj);
    }
    
    public boolean delete(Imagem obj) {
        return new CustomDAO<Imagem>().delete(obj);
    }
    
    public Imagem get(int id) {
        return new CustomDAO<Imagem>().get(Imagem.class, id);
    }
    
    public List<Imagem> list() {
        return new CustomDAO<Imagem>().list(Imagem.class);
    }
    
    public List<Imagem> list(String parametro){
        return new CustomDAO<Imagem>().list(Imagem.class, "SELECT * FROM imagens WHERE idatendimento LIKE '%' :idatendimento '%' DESC", "idatendimento", parametro);
    }
    
}
