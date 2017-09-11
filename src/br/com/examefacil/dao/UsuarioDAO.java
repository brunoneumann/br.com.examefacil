/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package br.com.examefacil.dao;

import br.com.examefacil.bean.Usuario;
import java.util.List;

/**
 *
 * @author Henrique
 */
public class UsuarioDAO {
    
    public boolean save(Usuario obj) {
        return new CustomDAO<Usuario>().save(obj);
    }
    
    public boolean delete(Usuario obj) {
        return new CustomDAO<Usuario>().delete(obj);
    }
    
    public Usuario get(int id) {
        return new CustomDAO<Usuario>().get(Usuario.class, id);
    }
    
    public List<Usuario> list() {
        return new CustomDAO<Usuario>().list(Usuario.class);
    }
    
    public List<Usuario> list(String parametro){
        return new CustomDAO<Usuario>().list(Usuario.class, "SELECT * FROM usuario WHERE nome LIKE '%' :nome '%' ORDER BY idusuario DESC", "nome", parametro);
    }
    
    public boolean alterarSenha(int idusuario, String senha){
        return new CustomDAO<Usuario>().execute(Usuario.class, "UPDATE usuario SET senha='"+senha+"' WHERE idusuario="+idusuario);
    }
}
