/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.examefacil.dao;

import br.com.examefacil.bean.Atender;
import br.com.examefacil.bean.Parametros;
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
public class AtenderDAO {
    
    final org.apache.logging.log4j.Logger log = LogManager.getLogger(AtenderDAO.class.getName());
    private Connection connection;
    private Parametros parametros;
    
    public boolean save(Atender obj) {
        Atender a = (Atender)obj;
        System.out.println(a.getIdatendimento()+" "+a.getIdtipoexame());
        parametros = new ParametrosDAO().get();
        return new CustomDAO<Atender>().save(obj);
    }
    
    public boolean delete(Atender obj) {
        return new CustomDAO<Atender>().delete(obj);
    }
    
    public Atender get(int id) {
        return new CustomDAO<Atender>().get(Atender.class, id);
    }
    
    public List<Atender> list() {
        return new CustomDAO<Atender>().list(Atender.class);
    }
    
    public List<Atender> list(String parametro){
        return new CustomDAO<Atender>().list(Atender.class, "SELECT * FROM atendimento_tipoexame WHERE idatendimento LIKE '%' :idatendimento '%'", "idatendimento", parametro);
    }
    
    public List<Atender> listarCombo(int idAtendimento) {
        this.connection = new ConnectionFactory().getConnection(new ParametrosDAO().get());
        List<Atender> atender = new ArrayList<Atender>();
        String sql = "SELECT a.idatend_tipo, a.idatendimento, a.idtipoexame, t.nome AS tipoexame, e.nome AS areaexame" +
                " FROM atendimento_tipoexame a, tipoexame t, areaexame e" +
                " WHERE a.idtipoexame = t.idtipoexame" +
                " AND t.idareaexame = e.idareaexame" +
                " AND a.idatendimento = "+String.valueOf(idAtendimento)+"";
        ResultSet rs = null;
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement(sql);
            rs = stmt.executeQuery();
            while(rs.next()){
                Atender a = new Atender();
                a.setIdatend_tipo(rs.getInt("idatend_tipo"));
                a.setIdatendimento(rs.getInt("idatendimento"));
                a.setIdtipoexame(rs.getInt("idtipoexame"));
                a.setTipoexame(rs.getString("tipoexame"));
                a.setAreaexame(rs.getString("areaexame"));

                atender.add(a);
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
        return atender;
    }
    
}
