/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.examefacil.dao;

import br.com.examefacil.bean.Paciente;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author bruno
 */
public class PacienteDAO implements InterfaceDAO<Paciente> {
    
    public PacienteDAO() throws ClassNotFoundException, SQLException {
        super();
    }

    @Override
    public boolean save(Paciente obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public boolean delete(Paciente obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Paciente get(Paciente obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Paciente> list() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
