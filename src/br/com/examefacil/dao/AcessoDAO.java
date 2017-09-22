/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package br.com.examefacil.dao;

import br.com.examefacil.bean.Acesso;

/**
 *
 * @author bruno
 */
public class AcessoDAO {
    
    public boolean save(Acesso obj) {
        return new CustomDAO<Acesso>().save(obj);
    }
    
    public boolean excluirPermissoes(int idusuario){
        return new CustomDAO<Acesso>().execute(Acesso.class, "DELETE FROM acesso WHERE idusuario="+idusuario);
    }
}
