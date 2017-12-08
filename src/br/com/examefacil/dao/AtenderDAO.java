/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.examefacil.dao;

import br.com.examefacil.bean.Atender;
import br.com.examefacil.bean.Parametros;
import br.com.examefacil.conn.ConnectionFactory;
import br.com.examefacil.tools.Util;
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
    
    
    public List<Atender> listaQtdeAtendimentosPorTipoExame(String dataInicial, String dataFinal) {
        Parametros parametros = new ParametrosDAO().get();
        this.connection = new ConnectionFactory().getConnection(parametros);
        List<Atender> lista = new ArrayList<Atender>();
        
        String sql = "call pr_dash_atendimentos_tipoexame(?, ?);";
        ResultSet rs = null;
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, Util.data_to_sql(dataInicial));
            stmt.setString(2, Util.data_to_sql(dataFinal));
            rs = stmt.executeQuery();
            while(rs.next()){
                Atender a = new Atender();
                a.setTipoexame(rs.getString("tipoexame"));
                a.setQtdeAtendimentos(rs.getInt("qtde"));
                lista.add(a);
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
        return lista;
    }
    
    public List<Atender> listaQtdeAtendimentosPorAreaExame(String dataInicial, String dataFinal) {
        Parametros parametros = new ParametrosDAO().get();
        this.connection = new ConnectionFactory().getConnection(parametros);
        List<Atender> atendimentos = new ArrayList<Atender>();
        
        String sql = "SELECT "+
                "areaexame, data, COUNT(DISTINCT idatendimento) qtde "
                + "FROM vw_atendimentos_areaexame "
                + "WHERE data_sql BETWEEN ? AND ? "
                + "GROUP BY 1,2 "
                + "ORDER BY 2,1";
        ResultSet rs = null;
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, Util.data_to_sql(dataInicial));
            stmt.setString(2, Util.data_to_sql(dataFinal));
            rs = stmt.executeQuery();
            while(rs.next()){
                Atender a = new Atender();
                a.setAreaexame(rs.getString("areaexame"));
                a.setDataStr(rs.getString("data"));
                a.setQtdeAtendimentos(rs.getInt("qtde"));
                atendimentos.add(a);
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
        return atendimentos;
    }
    
}
