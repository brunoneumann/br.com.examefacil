/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package br.com.examefacil.dao;


import br.com.examefacil.bean.TextoPadrao;
import java.util.List;


/**
 *
 * @author bruno
 */
public class TextoPadraoDAO {
    
    public boolean save(TextoPadrao obj) {
        return new CustomDAO<TextoPadrao>().save(obj);
    }

    public boolean delete(TextoPadrao obj) {
        return new CustomDAO<TextoPadrao>().delete(obj);
    }
    
    public TextoPadrao get(int id) {
        return new CustomDAO<TextoPadrao>().get(TextoPadrao.class, id);
    }
    
    public List<TextoPadrao> list() {
        return new CustomDAO<TextoPadrao>().list(TextoPadrao.class);
    }
    
    public List<TextoPadrao> list(String parametro){
        return new CustomDAO<TextoPadrao>().list(TextoPadrao.class, "SELECT * FROM textopadrao WHERE nome_codigo LIKE '%' :nome_codigo '%' ORDER BY idtextopadrao DESC", "nome_codigo", parametro);
    }
    
    
    
}
