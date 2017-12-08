package br.com.examefacil.dao;

import br.com.examefacil.bean.Parametros;
import br.com.examefacil.dao.CustomDAO;
import br.com.examefacil.tools.Constants;
import br.com.examefacil.tools.Util;
import org.apache.logging.log4j.LogManager;

/**
 *
 * @author bruno
 */
public class ParametrosDAO {
    
    final org.apache.logging.log4j.Logger log = LogManager.getLogger(ParametrosDAO.class.getName());
    
    public boolean save(Parametros obj) {
        return new CustomDAO<Parametros>().save(obj);
    }
    
    public Parametros get() {
        return new CustomDAO<Parametros>().get(Parametros.class, 1);
    }
    
    public void atualizar(boolean atualizar){
        new CustomDAO<Parametros>().execute("UPDATE parametros SET atualizar="+atualizar);
    }
    
    public void initFunctions(Parametros parametros){
        if(parametros!=null){
            if(Util.isServerMachine(parametros.getUrlServidor())){
                if(new CustomDAO<Parametros>().execute(new Constants().SQLDROPFunctionStatusAtendimento)){
                    new CustomDAO<Parametros>().execute(new Constants().SQLADDFunctionStatusAtendimento);
                }
                if(new CustomDAO<Parametros>().execute(new Constants().SQLDROPProcedureAtendimentos)){
                    new CustomDAO<Parametros>().execute(new Constants().SQLADDProcedureAtendimentos);
                }
                
                if(new CustomDAO<Parametros>().execute(new Constants().SQLDROPProcedureAtendimentosPorStatus)){
                    new CustomDAO<Parametros>().execute(new Constants().SQLADDProcedureAtendimentosPorStatus);
                }
                if(new CustomDAO<Parametros>().execute(new Constants().SQLDROPProcedureAtendimentosPorTipoExame)){
                    new CustomDAO<Parametros>().execute(new Constants().SQLADDProcedureAtendimentosPorTipoExame);
                }
                
                if(new CustomDAO<Parametros>().execute(new Constants().SQLDROPFunctionFormataDataSQL)){
                    new CustomDAO<Parametros>().execute(new Constants().SQLADDFunctionFormataDataSQL);
                }
                
                if(new CustomDAO<Parametros>().execute(new Constants().SQLDROPFunctionQtdeAtendimentos)){
                    new CustomDAO<Parametros>().execute(new Constants().SQLADDFunctionQtdeAtendimentos);
                }
                
                if(new CustomDAO<Parametros>().execute(new Constants().SQLDROPFunctionMaiorInterpretador)){
                    new CustomDAO<Parametros>().execute(new Constants().SQLADDFunctionMaiorInterpretador);
                }
                
                if(new CustomDAO<Parametros>().execute(new Constants().SQLDROPFunctionMaiorRecepcionista)){
                    new CustomDAO<Parametros>().execute(new Constants().SQLADDFunctionMaiorRecepcionista);
                }
                
                new CustomDAO<Parametros>().execute(new Constants().SQLViewAtendimentoPorData);
                new CustomDAO<Parametros>().execute(new Constants().SQLViewAtendimentoPorAreaExame);
                
                log.info("Criado funções, procedures e views");
            }
        }
    }
    
    public void auditar(boolean auditar){
        if(auditar){
            for(String query : new Constants().SQLdropTriggersAuditoria){
                new CustomDAO<Parametros>().execute(query);
            }
            for(String query : new Constants().SQLcreateTriggersAuditoria){
                new CustomDAO<Parametros>().execute(query);
            }
        } else {
            for(String query : new Constants().SQLdropTriggersAuditoria){
                new CustomDAO<Parametros>().execute(query);
            }
        }
    }
    
}