/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package br.com.examefacil.dao;

import br.com.examefacil.bean.Atendimento;
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
public class AtendimentoDAO {
    
    final org.apache.logging.log4j.Logger log = LogManager.getLogger(AtendimentoDAO.class.getName());
    private Connection connection;
    
    public AtendimentoDAO(){}
    
    public boolean save(Atendimento obj) {
        return new CustomDAO<Atendimento>().save(obj);
    }
    
    public boolean delete(Atendimento obj) {
        return new CustomDAO<Atendimento>().delete(obj);
    }
    
    public Atendimento get(int id) {

        Parametros parametros = new ParametrosDAO().get();
        this.connection = new ConnectionFactory().getConnection(parametros);
        String sql = "SELECT a.idatendimento, a.idusuario, u.nome nome_usuario, a.idpaciente, p.nome nome_paciente, " +
                "a.status, a.data, a.hora_entrada, a.hora_saida, a.observacoes " +
                "FROM atendimento a " +
                "LEFT JOIN usuario u ON (u.idusuario=a.idusuario) " +
                "LEFT JOIN paciente p ON (p.idpaciente=a.idpaciente) " +
                "WHERE a.idatendimento=?";
        ResultSet rs = null;
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            if(rs.next()){
                Atendimento a = new Atendimento();
                a.setIdatendimento(rs.getInt("idatendimento"));
                a.setIdusuario(rs.getInt("idusuario"));
                a.setNome_usuario(rs.getString("nome_usuario"));
                a.setIdpaciente(rs.getInt("idpaciente"));
                a.setNome_paciente(rs.getString("nome_paciente"));
                a.setStatus(rs.getString("status"));
                a.setData(rs.getDate("data"));
                a.setDataString(Util.formataDataSQL(rs.getDate("data")));
                a.setHoraEntrada(rs.getString("hora_entrada"));
                a.setHoraSaida(rs.getString("hora_saida"));
                a.setObservacoes(rs.getString("observacoes"));
                return a;
            }
            rs.close();
            stmt.close();
            connection.close();
        } catch(Exception ex){
            log.error(ex);
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
        return null;
    }

    public List<Atendimento> listaAtendimentos(String nome_paciente, String dataInicial, String dataFinal, String tipo_acesso) {
        Parametros parametros = new ParametrosDAO().get();
        this.connection = new ConnectionFactory().getConnection(parametros);
        List<Atendimento> atendimentos = new ArrayList<Atendimento>();
        
        String sql = "call atendimentos(?, ?, ?, ?);";
        ResultSet rs = null;
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, "%"+nome_paciente+"%");
            stmt.setString(2, Util.data_to_sql(dataInicial));
            stmt.setString(3, Util.data_to_sql(dataFinal));
            stmt.setString(4, tipo_acesso);
            rs = stmt.executeQuery();
            while(rs.next()){
                Atendimento a = new Atendimento();
                a.setIdatendimento(rs.getInt("idatendimento"));
                a.setNome_usuario(rs.getString("nome_usuario"));
                a.setNome_paciente(rs.getString("nome_paciente"));
                a.setStatus(rs.getString("status"));
                a.setData(rs.getDate("data"));
                a.setDataString(Util.formataDataSQL(rs.getDate("data")));
                a.setHoraEntrada(rs.getString("hora_entrada"));
                a.setHoraSaida(rs.getString("hora_saida"));
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
    
    public List<Atendimento> list() {
        return new CustomDAO<Atendimento>().list(Atendimento.class);
    }
    
    public List<Atendimento> list(String parametro){
        return new CustomDAO<Atendimento>().list(Atendimento.class, "SELECT * FROM exame WHERE idpaciente LIKE '%' :idpaciente '%' ORDER BY data DESC", "idpaciente", parametro);
    }
    
}
