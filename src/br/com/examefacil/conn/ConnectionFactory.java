
package br.com.examefacil.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author bruno
 */
public class ConnectionFactory {

    public Connection getConnection() {
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
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/examefacil?autoReconnect=true&useSSL=false", "root", "1pbns11");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
