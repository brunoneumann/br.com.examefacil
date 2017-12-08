/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.examefacil.dao;

import br.com.examefacil.bean.TipoExame;
import br.com.examefacil.conn.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;

/**
 *
 * @author Henrique
 */
    


public class TipoExameDAO {
    final org.apache.logging.log4j.Logger log = LogManager.getLogger(TipoExameDAO.class.getName());
    private Connection connection;

    public boolean save(TipoExame obj) {
        return new CustomDAO<TipoExame>().save(obj);
    }

    public boolean delete(TipoExame obj) {
        return new CustomDAO<TipoExame>().delete(obj);
    }
    
    public TipoExame get(int id) {
        return new CustomDAO<TipoExame>().get(TipoExame.class, id);
    }
    
    public List<TipoExame> list() {
        return new CustomDAO<TipoExame>().list(TipoExame.class);
    }
    
    public List<TipoExame> list(String parametro){
        return new CustomDAO<TipoExame>().list(TipoExame.class, "SELECT * FROM tipoexame WHERE idtipoexame LIKE '%' :idtipoexame '%' ORDER BY nome DESC", "idtipoexame", parametro);
    }
    
    public List<TipoExame> listarExames() {
        this.connection = new ConnectionFactory().getConnection(new ParametrosDAO().get());
        List<TipoExame> exames = new ArrayList<TipoExame>();
        String sql = "SELECT idtipoexame, t.idareaexame, t.nome, t.descricao, a.nome AS area "
                + "FROM tipoexame t, areaexame a "
                + "WHERE a.idareaexame = t.idareaexame "
                + "ORDER BY a.nome";
        ResultSet rs = null;
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement(sql);
            rs = stmt.executeQuery();
            while(rs.next()){
                TipoExame a = new TipoExame();
                a.setIdtipoexame(rs.getInt("idtipoexame"));
                a.setIdareaexame(rs.getInt("idareaexame"));
                a.setNome(rs.getString("nome"));
                a.setDescricao(rs.getString("descricao"));
                a.setArea(rs.getString("area"));              

                exames.add(a);
            }
            rs.close();
            stmt.close();
            connection.close();
        } catch(Exception ex){
            ex.printStackTrace();
        } finally {
            try {
                if(rs!=null){
                    rs.close();
                }
                if(stmt!=null){
                    stmt.close();
                }
                connection.close();
            } catch(Exception ex){
                log.error(ex);
            }
        }
        return exames;
    }
    
}
