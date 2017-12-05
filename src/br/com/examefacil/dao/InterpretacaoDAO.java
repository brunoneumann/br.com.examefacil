/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.examefacil.dao;

import br.com.examefacil.bean.Interpretacao;
import java.util.List;

/**
 *
 * @author Henrique
 */
public class InterpretacaoDAO {
    
    public boolean save(Interpretacao obj) {
        return new CustomDAO<Interpretacao>().save(obj);
    }

    public boolean delete(Interpretacao obj) {
        return new CustomDAO<Interpretacao>().delete(obj);
    }
    
    public Interpretacao get(int id) {
        return new CustomDAO<Interpretacao>().get(Interpretacao.class, id);
    }
    
    public List<Interpretacao> list() {
        return new CustomDAO<Interpretacao>().list(Interpretacao.class);
    }
    
    public List<Interpretacao> list(String parametro){
        return new CustomDAO<Interpretacao>().list(Interpretacao.class, "SELECT * FROM laudo WHERE idlaudo LIKE '%' :idlaudo '%' ORDER BY idlaudo DESC", "idlaudo", parametro);
    }
    public List<Interpretacao> list(String parametro, String exame){
        return new CustomDAO<Interpretacao>().list(Interpretacao.class, "SELECT * FROM laudo WHERE idatendimento LIKE '%' :idatendimento '%' AND idtipoexame="+exame+" ORDER BY idatendimento DESC", "idatendimento", parametro);
    }
}
