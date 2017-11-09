/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package br.com.examefacil.tools;

import br.com.examefacil.bean.Paciente;
import br.com.examefacil.dao.PacienteDAO;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.Reader;
import java.util.List;
import org.apache.logging.log4j.LogManager;

/**
 *
 * @author bruno
 */
public class PacienteUtils {
    
    final org.apache.logging.log4j.Logger log = LogManager.getLogger(PacienteUtils.class.getName());
    
    public PacienteUtils(){}
    
    public boolean gerarXMLPaciente(){
        
        List<Paciente> pacientes = new PacienteDAO().list();
        
        XStream stream = new XStream(new DomDriver());
        stream.alias("paciente", Paciente.class);
        
        try {
            PrintStream out = new PrintStream(new File("pacientes.xml"));
            out.println(stream.toXML(pacientes));
            return true;
        } catch (FileNotFoundException ex) {
            log.error(ex);
            Util.Error("Falha ao gerar o arquivo XML: "+ex.getMessage());
        }
        return false;
    }
    
    public List<Paciente> carregarXML(Reader fonte) {
        try {
            XStream stream = new XStream(new DomDriver());
            stream.alias("paciente", Paciente.class);
            return (List<Paciente>) stream.fromXML(fonte);
        } catch(Exception ex){
            log.error(ex);
            Util.Error("Arquivo XML inválido!");
        }
        return null;
    }
    
}
