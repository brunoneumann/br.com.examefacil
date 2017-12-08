package br.com.examefacil.conn;

import br.com.examefacil.bean.Parametros;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author bruno
 */
public class ConnectionFactory {
    
    public Connection getConnection(Parametros parametros) {
        try {
            Class.forName( "com.mysql.jdbc.Driver" );
        } catch (ClassNotFoundException c) {
            try {
                throw new Exception("Classe do driver não encontrada", c);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        try {
            return DriverManager.getConnection("jdbc:mysql://"+parametros.getUrlServidor()+":3306/examefacil?autoReconnect=true&useSSL=false", "root", "1pbns11");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}