/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package br.com.examefacil.tools;

import java.util.ArrayList;

/**
 *
 * @author bruno
 */
public class Constants {
    
    public Constants(){}
    
    public String accessToken = "EAAV4MCWtjiMBALlvWtEnvwWfeLJ3DcosaKFlbDP2i3QmoteGIrGOucnwIz4TMIYt6n6vB8t6MPZCNXMYAT0c9wg4sWEuWaG9LDGDsGzvxkLZBhnUxBSdfZB243EvzwdngCjaggRZAkCMhH8UKlVe4btMn8wmXhJ2EKsQpkJZAtQZDZD";
    
    public ArrayList<String> SQLcreateTriggersAuditoria = new ArrayList<String>() {{
        /* Usuario */
        add("CREATE TRIGGER tr_usuario_insert AFTER INSERT ON usuario FOR EACH ROW "
                + "INSERT INTO "
                + "auditoria(usuario,data,dado_anterior,dado_novo,tipo_alteracao,tabela) "
                + "VALUES "
                + "(@user,current_date,null,CONCAT(NEW.nome,' | ',NEW.email,' | ',IFNULL(NEW.tipo_acesso,'')),'I','usuario');");
        add("CREATE TRIGGER tr_usuario_update AFTER UPDATE ON usuario FOR EACH ROW "
                + "INSERT INTO "
                + "auditoria(usuario,data,dado_anterior,dado_novo,tipo_alteracao,tabela) "
                + "VALUES "
                + "(@user,current_date,CONCAT(OLD.nome,' | ',OLD.email,' | ',OLD.senha,' | ',OLD.tipo_acesso),"
                + "CONCAT(NEW.nome,' | ',NEW.email,' | ',IFNULL(NEW.senha,''),' | ',IFNULL(NEW.tipo_acesso,'')),'U','usuario');");
        add("CREATE TRIGGER tr_usuario_delete AFTER DELETE ON usuario FOR EACH ROW "
                + "INSERT INTO "
                + "auditoria(usuario,data,dado_anterior,dado_novo,tipo_alteracao,tabela) "
                + "VALUES "
                + "(@user,current_date,CONCAT(OLD.nome,' | ',OLD.email,' | ',IFNULL(OLD.tipo_acesso,'')),null,'D','usuario');");
        
        /* Acesso */
        add("CREATE TRIGGER tr_acesso_insert AFTER INSERT ON acesso FOR EACH ROW "
                + "INSERT INTO "
                + "auditoria(usuario,data,dado_anterior,dado_novo,tipo_alteracao,tabela) "
                + "VALUES "
                + "(@user,current_date,null,"
                + "CONCAT('idusuario:',NEW.idusuario,' | acesso:',NEW.pagina,' | visualizar:',NEW.visualizar,' | incluir:',NEW.incluir,' | alterar:',NEW.alterar,' | excluir:',NEW.excluir),'I','acesso');");
        add("CREATE TRIGGER tr_acesso_update AFTER UPDATE ON acesso FOR EACH ROW "
                + "INSERT INTO "
                + "auditoria(usuario,data,dado_anterior,dado_novo,tipo_alteracao,tabela) "
                + "VALUES "
                + "(@user,current_date,CONCAT('idusuario:',OLD.idusuario,' | acesso:',OLD.pagina,' | visualizar:',OLD.visualizar,' | incluir:',OLD.incluir,' | alterar:',OLD.alterar,' | excluir:',OLD.excluir),CONCAT('idusuario:',NEW.idusuario,' | acesso:',NEW.pagina,' | visualizar:',NEW.visualizar,' | incluir:',NEW.incluir,' | alterar:',NEW.alterar,' | excluir:',NEW.excluir),'U','acesso');");
        
        /* Audios */
        add("CREATE TRIGGER tr_audios_insert AFTER INSERT ON audios FOR EACH ROW "
                + "INSERT INTO "
                + "auditoria(usuario,data,dado_anterior,dado_novo,tipo_alteracao,tabela) "
                + "VALUES "
                + "(@user,current_date,null,CONCAT(NEW.idaudio,' | ',NEW.nome_arquivo,' | ',IFNULL(NEW.detalhes,'')),'I','audios');");
        add("CREATE TRIGGER tr_audios_update AFTER UPDATE ON audios FOR EACH ROW "
                + "INSERT INTO "
                + "auditoria(usuario,data,dado_anterior,dado_novo,tipo_alteracao,tabela) "
                + "VALUES "
                + "(@user,current_date,CONCAT(OLD.nome_arquivo,' | ',IFNULL(OLD.detalhes,'')),"
                + "CONCAT(NEW.nome_arquivo,' | ',IFNULL(NEW.detalhes,'')),'U','audios');");
        add("CREATE TRIGGER tr_audios_delete AFTER DELETE ON audios FOR EACH ROW "
                + "INSERT INTO "
                + "auditoria(usuario,data,dado_anterior,dado_novo,tipo_alteracao,tabela) "
                + "VALUES "
                + "(@user,current_date,CONCAT(OLD.idaudio,' | ',OLD.nome_arquivo,' | ',IFNULL(OLD.detalhes,'')),null,'D','audios');");
        
        /* Imagens */
        add("CREATE TRIGGER tr_imagens_insert AFTER INSERT ON imagens FOR EACH ROW "
                + "INSERT INTO "
                + "auditoria(usuario,data,dado_anterior,dado_novo,tipo_alteracao,tabela) "
                + "VALUES "
                + "(@user,current_date,null,CONCAT(NEW.idimagem,' | ',NEW.nome_arquivo,' | ',IFNULL(NEW.detalhes,'')),'I','imagens');");
        add("CREATE TRIGGER tr_imagens_update AFTER UPDATE ON imagens FOR EACH ROW "
                + "INSERT INTO "
                + "auditoria(usuario,data,dado_anterior,dado_novo,tipo_alteracao,tabela) "
                + "VALUES "
                + "(@user,current_date,CONCAT(OLD.nome_arquivo,' | ',IFNULL(OLD.detalhes,'')),"
                + "CONCAT(NEW.nome_arquivo,' | ',IFNULL(NEW.detalhes,'')),'U','imagens');");
        add("CREATE TRIGGER tr_imagens_delete AFTER DELETE ON imagens FOR EACH ROW "
                + "INSERT INTO "
                + "auditoria(usuario,data,dado_anterior,dado_novo,tipo_alteracao,tabela) "
                + "VALUES "
                + "(@user,current_date,CONCAT(OLD.idimagem,' | ',OLD.nome_arquivo,' | ',IFNULL(OLD.detalhes,'')),null,'D','imagens');");
        
        /* Laudo */
        add("CREATE TRIGGER tr_laudo_insert AFTER INSERT ON laudo FOR EACH ROW "
                + "INSERT INTO "
                + "auditoria(usuario,data,dado_anterior,dado_novo,tipo_alteracao,tabela) "
                + "VALUES "
                + "(@user,current_date,null,CONCAT(NEW.idlaudo,' | ',NEW.idusuario,' | ',NEW.idatendimento,' | ',NEW.idtipoexame,' | ',NEW.idtextopadrao),'I','laudo');");
        add("CREATE TRIGGER tr_laudo_update AFTER UPDATE ON laudo FOR EACH ROW "
                + "INSERT INTO "
                + "auditoria(usuario,data,dado_anterior,dado_novo,tipo_alteracao,tabela) "
                + "VALUES "
                + "(@user,current_date,CONCAT(OLD.idlaudo,' | ',OLD.idusuario,' | ',OLD.idatendimento,' | ',OLD.idtipoexame,' | ',OLD.idtextopadrao),"
                + "CONCAT(NEW.idlaudo,' | ',NEW.idusuario,' | ',NEW.idatendimento,' | ',NEW.idtipoexame,' | ',NEW.idtextopadrao),'U','laudo');");
        add("CREATE TRIGGER tr_laudo_delete AFTER DELETE ON laudo FOR EACH ROW "
                + "INSERT INTO "
                + "auditoria(usuario,data,dado_anterior,dado_novo,tipo_alteracao,tabela) "
                + "VALUES "
                + "(@user,current_date,CONCAT(OLD.idlaudo,' | ',OLD.idusuario,' | ',OLD.idatendimento,' | ',OLD.idtipoexame,' | ',OLD.idtextopadrao),null,'D','laudo');");
        
        /* Atendimento */
        add("CREATE TRIGGER tr_atendimento_insert AFTER INSERT ON atendimento FOR EACH ROW "
                + "INSERT INTO "
                + "auditoria(usuario,data,dado_anterior,dado_novo,tipo_alteracao,tabela) "
                + "VALUES "
                + "(@user,current_date,null,CONCAT(NEW.idatendimento,' | ',NEW.idusuario,' | ',NEW.idpaciente,' | ',NEW.status,' | ',NEW.data,' | ',NEW.hora_entrada,' | ',IFNULL(NEW.hora_saida,''),' | ',IFNULL(NEW.observacoes,'')),'I','atendimento');");
        add("CREATE TRIGGER tr_atendimento_update AFTER UPDATE ON atendimento FOR EACH ROW "
                + "INSERT INTO "
                + "auditoria(usuario,data,dado_anterior,dado_novo,tipo_alteracao,tabela) "
                + "VALUES "
                + "(@user,current_date,CONCAT(OLD.idatendimento,' | ',OLD.idusuario,' | ',OLD.idpaciente,' | ',OLD.status,' | ',OLD.data,' | ',OLD.hora_entrada,' | ',IFNULL(OLD.hora_saida,''),' | ',IFNULL(OLD.observacoes,'')),CONCAT(NEW.idatendimento,' | ',NEW.idusuario,' | ',NEW.idpaciente,' | ',NEW.status,' | ',NEW.data,' | ',NEW.hora_entrada,' | ',IFNULL(NEW.hora_saida,''),' | ',IFNULL(NEW.observacoes,'')),'U','atendimento');");
        add("CREATE TRIGGER tr_atendimento_delete AFTER DELETE ON atendimento FOR EACH ROW "
                + "INSERT INTO "
                + "auditoria(usuario,data,dado_anterior,dado_novo,tipo_alteracao,tabela) "
                + "VALUES "
                + "(@user,current_date,CONCAT(OLD.idatendimento,' | ',OLD.idusuario,' | ',OLD.idpaciente,' | ',OLD.status,' | ',OLD.data,' | ',OLD.hora_entrada,' | ',IFNULL(OLD.hora_saida,''),' | ',IFNULL(OLD.observacoes,'')),null,'D','atendimento');");
        
        /* Paciente */
        add("CREATE TRIGGER tr_paciente_insert AFTER INSERT ON paciente FOR EACH ROW "
                + "INSERT INTO "
                + "auditoria(usuario,data,dado_anterior,dado_novo,tipo_alteracao,tabela) "
                + "VALUES "
                + "(@user,current_date,null,CONCAT(NEW.idpaciente,' | ',NEW.nome,' | ',IFNULL(NEW.CPF,''),' | ',IFNULL(NEW.email,''),' | ',IFNULL(NEW.idfacebook,'')),'I','paciente');");
        add("CREATE TRIGGER tr_paciente_update AFTER UPDATE ON paciente FOR EACH ROW "
                + "INSERT INTO "
                + "auditoria(usuario,data,dado_anterior,dado_novo,tipo_alteracao,tabela) "
                + "VALUES "
                + "(@user,current_date,CONCAT(OLD.nome,' | ',IFNULL(OLD.CPF,''),' | ',IFNULL(OLD.email,''),' | ',IFNULL(OLD.idfacebook,'')),CONCAT(NEW.nome,' | ',IFNULL(NEW.CPF,''),' | ',IFNULL(NEW.email,''),' | ',IFNULL(NEW.idfacebook,'')),'U','paciente');");
        add("CREATE TRIGGER tr_paciente_delete AFTER DELETE ON paciente FOR EACH ROW "
                + "INSERT INTO "
                + "auditoria(usuario,data,dado_anterior,dado_novo,tipo_alteracao,tabela) "
                + "VALUES "
                + "(@user,current_date,CONCAT(OLD.idpaciente,' | ',OLD.nome,' | ',IFNULL(OLD.CPF,''),' | ',IFNULL(OLD.email,'')),null,'D','paciente');");
        
        /* Area exame */
        add("CREATE TRIGGER tr_areaexame_insert AFTER INSERT ON areaexame FOR EACH ROW "
                + "INSERT INTO "
                + "auditoria(usuario,data,dado_anterior,dado_novo,tipo_alteracao,tabela) "
                + "VALUES "
                + "(@user,current_date,null,CONCAT(NEW.idareaexame,' | ',NEW.nome),'I','areaexame');");
        add("CREATE TRIGGER tr_areaexame_update AFTER UPDATE ON areaexame FOR EACH ROW "
                + "INSERT INTO "
                + "auditoria(usuario,data,dado_anterior,dado_novo,tipo_alteracao,tabela) "
                + "VALUES "
                + "(@user,current_date,CONCAT(OLD.idareaexame,' | ',OLD.nome),CONCAT(OLD.idareaexame,' | ',NEW.nome),'U','areaexame');");
        add("CREATE TRIGGER tr_areaexame_delete AFTER DELETE ON areaexame FOR EACH ROW "
                + "INSERT INTO "
                + "auditoria(usuario,data,dado_anterior,dado_novo,tipo_alteracao,tabela) "
                + "VALUES "
                + "(@user,current_date,CONCAT(OLD.idareaexame,' | ',OLD.nome),null,'D','areaexame');");
        
        /* Tipo exame */
        add("CREATE TRIGGER tr_tipoexame_insert AFTER INSERT ON tipoexame FOR EACH ROW "
                + "INSERT INTO "
                + "auditoria(usuario,data,dado_anterior,dado_novo,tipo_alteracao,tabela) "
                + "VALUES "
                + "(@user,current_date,null,CONCAT(NEW.idtipoexame,' | ',NEW.idareaexame,' | ',NEW.nome,' | ',IFNULL(NEW.descricao,'')),'I','tipoexame');");
        add("CREATE TRIGGER tr_tipoexame_update AFTER UPDATE ON tipoexame FOR EACH ROW "
                + "INSERT INTO "
                + "auditoria(usuario,data,dado_anterior,dado_novo,tipo_alteracao,tabela) "
                + "VALUES "
                + "(@user,current_date,CONCAT(OLD.idtipoexame,' | ',OLD.idareaexame,' | ',OLD.nome,' | ',IFNULL(OLD.descricao,'')),"
                + "CONCAT(NEW.idtipoexame,' | ',NEW.idareaexame,' | ',NEW.nome,' | ',IFNULL(NEW.descricao,'')),'U','tipoexame');");
        add("CREATE TRIGGER tr_tipoexame_delete AFTER DELETE ON tipoexame FOR EACH ROW "
                + "INSERT INTO "
                + "auditoria(usuario,data,dado_anterior,dado_novo,tipo_alteracao,tabela) "
                + "VALUES "
                + "(@user,current_date,CONCAT(OLD.idtipoexame,' | ',OLD.idareaexame,' | ',OLD.nome,' | ',IFNULL(OLD.descricao,'')),null,'D','tipoexame');");
        
        /* Texto padrão */
        add("CREATE TRIGGER tr_textopadrao_insert AFTER INSERT ON textopadrao FOR EACH ROW "
                + "INSERT INTO "
                + "auditoria(usuario,data,dado_anterior,dado_novo,tipo_alteracao,tabela) "
                + "VALUES "
                + "(@user,current_date,null,CONCAT(NEW.idtextopadrao,' | ',NEW.nome_codigo,' | ',NEW.texto),'I','textopadrao');");
        add("CREATE TRIGGER tr_textopadrao_update AFTER UPDATE ON textopadrao FOR EACH ROW "
                + "INSERT INTO "
                + "auditoria(usuario,data,dado_anterior,dado_novo,tipo_alteracao,tabela) "
                + "VALUES "
                + "(@user,current_date,CONCAT(OLD.idtextopadrao,' | ',OLD.nome_codigo,' | ',OLD.texto),"
                + "CONCAT(NEW.idtextopadrao,' | ',NEW.nome_codigo,' | ',NEW.texto),'U','textopadrao');");
        add("CREATE TRIGGER tr_textopadrao_delete AFTER DELETE ON textopadrao FOR EACH ROW "
                + "INSERT INTO "
                + "auditoria(usuario,data,dado_anterior,dado_novo,tipo_alteracao,tabela) "
                + "VALUES "
                + "(@user,current_date,CONCAT(OLD.idtextopadrao,' | ',OLD.nome_codigo,' | ',OLD.texto),null,'D','textopadrao');");
        
        /* Parametros */
        add("CREATE TRIGGER tr_parametros_insert AFTER INSERT ON parametros FOR EACH ROW "
                + "INSERT INTO "
                + "auditoria(usuario,data,dado_anterior,dado_novo,tipo_alteracao,tabela) "
                + "VALUES "
                + "(@user,current_date,null,CONCAT(NEW.pasta_imagens,' | ',NEW.pasta_audios,' | ',NEW.auditar,' | ',IFNULL(NEW.email_usuario,''),' | ',IFNULL(NEW.arq_pdf,''),' | ',IFNULL(NEW.server_smtp,''),' | ',IFNULL(NEW.email_smtp,''),' | ',IFNULL(NEW.user_smtp,''),' | ',IFNULL(NEW.senha_smtp,''),' | ',IFNULL(NEW.porta_smtp,''),' | ',IFNULL(NEW.url_servidor,''),' | ',IFNULL(NEW.porta_servidor,'')),'U','parametros');");

        
        /* View Auditoria */
        add("CREATE OR REPLACE VIEW vw_auditoria AS "
                + "SELECT a.usuario USUARIO, DATE_FORMAT(a.data, '%d/%m/%Y') 'DATA', "
                + "CASE WHEN a.tipo_alteracao='I' THEN 'INSERIU' "
                + "WHEN a.tipo_alteracao='U' THEN 'ALTEROU' "
                + "WHEN a.tipo_alteracao='D' THEN 'EXCLUIU' END ACAO, "
                + "CASE WHEN a.tabela='usuario' THEN 'Usuários' "
                + "WHEN a.tabela='acesso' THEN 'Permissões de acesso' "
                + "WHEN a.tabela='audios' THEN 'Áudios' "
                + "WHEN a.tabela='imagens' THEN 'Imagens' "
                + "WHEN a.tabela='laudo' THEN 'Laudo de exame' "
                + "WHEN a.tabela='atendimento' THEN 'Atendimentos' "
                + "WHEN a.tabela='paciente' THEN 'Pacientes' "
                + "WHEN a.tabela='areaexame' THEN 'Área de exame' "
                + "WHEN a.tabela='tipoexame' THEN 'Tipos de exame' "
                + "WHEN a.tabela='textopadrao' THEN 'Texto padrão' "
                + "WHEN a.tabela='parametros' THEN 'Parâmetros' "
                + "END ONDE, "
                + "a.dado_anterior ANTERIOR, a.dado_novo AGORA "
                + "FROM auditoria a");
        
    }};
    
    public ArrayList<String> SQLdropTriggersAuditoria = new ArrayList<String>() {{
        add("DROP TRIGGER IF EXISTS  tr_usuario_insert;");
        add("DROP TRIGGER IF EXISTS  tr_usuario_update;");
        add("DROP TRIGGER IF EXISTS  tr_usuario_delete");
        add("DROP TRIGGER IF EXISTS  tr_acesso_insert");
        add("DROP TRIGGER IF EXISTS  tr_acesso_update");
        add("DROP TRIGGER IF EXISTS  tr_acesso_delete");
        add("DROP TRIGGER IF EXISTS  tr_audios_insert");
        add("DROP TRIGGER IF EXISTS  tr_audios_update");
        add("DROP TRIGGER IF EXISTS  tr_audios_delete");
        add("DROP TRIGGER IF EXISTS  tr_imagens_insert");
        add("DROP TRIGGER IF EXISTS  tr_imagens_update");
        add("DROP TRIGGER IF EXISTS  tr_imagens_delete");
        add("DROP TRIGGER IF EXISTS  tr_laudo_insert");
        add("DROP TRIGGER IF EXISTS  tr_laudo_update");
        add("DROP TRIGGER IF EXISTS  tr_laudo_delete");
        add("DROP TRIGGER IF EXISTS  tr_atendimento_insert");
        add("DROP TRIGGER IF EXISTS  tr_atendimento_update");
        add("DROP TRIGGER IF EXISTS  tr_atendimento_delete");
        add("DROP TRIGGER IF EXISTS  tr_paciente_insert");
        add("DROP TRIGGER IF EXISTS  tr_paciente_update");
        add("DROP TRIGGER IF EXISTS  tr_paciente_delete");
        add("DROP TRIGGER IF EXISTS  tr_areaexame_insert");
        add("DROP TRIGGER IF EXISTS  tr_areaexame_update");
        add("DROP TRIGGER IF EXISTS  tr_areaexame_delete");
        add("DROP TRIGGER IF EXISTS  tr_tipoexame_insert");
        add("DROP TRIGGER IF EXISTS  tr_tipoexame_update");
        add("DROP TRIGGER IF EXISTS  tr_tipoexame_delete");
        add("DROP TRIGGER IF EXISTS  tr_textopadrao_insert");
        add("DROP TRIGGER IF EXISTS  tr_textopadrao_update");
        add("DROP TRIGGER IF EXISTS  tr_textopadrao_delete");
        add("DROP TRIGGER IF EXISTS  tr_parametros_insert");
    }};
    
    /* Função status do atendimento */
    public String SQLDROPFunctionStatusAtendimento = "DROP FUNCTION IF EXISTS fn_status_atendimento";
    public String SQLADDFunctionStatusAtendimento = "CREATE FUNCTION fn_status_atendimento (status VARCHAR(1)) "
            + "RETURNS VARCHAR(25) "
            + "DETERMINISTIC "
            + "RETURN CASE WHEN status='1' THEN 'Aguardando consulta' "
            + "WHEN status='2' THEN 'Aguardando exame' "
            + "WHEN status='3' THEN 'Aguardando interpretação' "
            + "WHEN status='4' THEN 'Interpretado' "
            + "WHEN status='5' THEN 'Finalizado' "
            + "END";
    
    /* Função para formatar data do Mysql para dd/MM/yyyy */
    public String SQLDROPFunctionFormataDataSQL = "DROP FUNCTION IF EXISTS fn_formata_data";
    public String SQLADDFunctionFormataDataSQL = "CREATE FUNCTION fn_formata_data(data_sql date) "
            + "RETURNS VARCHAR(10) "
            + "DETERMINISTIC "
            + "RETURN DATE_FORMAT(data_sql,'%d/%m/%Y')";
    
    /* Procedure para filtros de acordo com o tipo de acesso do usuário */
    public String SQLDROPProcedureAtendimentos = "DROP PROCEDURE IF EXISTS atendimentos";
    public String SQLADDProcedureAtendimentos = ""
            + "CREATE PROCEDURE atendimentos(nome_paciente VARCHAR(100), data_inicial VARCHAR(10), data_final VARCHAR(10), tipo_acesso VARCHAR(1)) "
            + "DETERMINISTIC "
            + "BEGIN "
            + "SET @query = CONCAT(\"SELECT a.idatendimento, u.nome nome_usuario, p.nome nome_paciente, " +
                "fn_status_atendimento(a.status) status, a.data, a.hora_entrada, a.hora_saida "+
                "FROM atendimento a "+
                "LEFT JOIN usuario u ON (u.idusuario=a.idusuario) "+
                "LEFT JOIN paciente p ON (p.idpaciente=a.idpaciente) "+
                "WHERE a.data BETWEEN '\", data_inicial, \"' AND '\", data_final, \"' " +
                "AND p.nome LIKE '%\", nome_paciente, \"%'\"); "+
                "IF (tipo_acesso = '1') THEN "+
                "SET @query = CONCAT(@query, ' AND a.status IN ('\"1\"','\"5\"')', ' ORDER BY a.data DESC, a.hora_entrada DESC'); "+
                "END IF; "+
                "IF (tipo_acesso = '2') THEN "+
                "SET @query = CONCAT(@query, ' AND a.status IN ('\"2\"')', ' ORDER BY a.data DESC, a.hora_entrada DESC'); "+
                "END IF; "+
                "IF (tipo_acesso = '3') THEN "+
                "SET @query = CONCAT(@query, ' AND a.status IN ('\"1\"','\"2\"','\"4\"')', ' ORDER BY a.data DESC, a.hora_entrada DESC'); "+
                "END IF; "+
                "IF (tipo_acesso = '4') THEN "+
                "SET @query = CONCAT(@query, ' AND a.status IN ('\"3\"')', ' ORDER BY a.data DESC, a.hora_entrada DESC'); "+
                "END IF; "+
                "IF (tipo_acesso = '5') THEN "+
                "SET @query = CONCAT(@query, ' ORDER BY a.data DESC, a.hora_entrada DESC'); "+
                "END IF; "+
                "PREPARE stmt1 FROM @query; "+
                "EXECUTE stmt1; "+
                "END";
    
    
    /* Procedures para os gráficos do dashboard */
    
    /* Qtde atendimentos por status */
    public String SQLDROPProcedureAtendimentosPorStatus = "DROP PROCEDURE IF EXISTS pr_dash_atendimentos_status";
    public String SQLADDProcedureAtendimentosPorStatus = ""
            + "CREATE PROCEDURE pr_dash_atendimentos_status(data_inicial VARCHAR(10), data_final VARCHAR(10)) "
            + "DETERMINISTIC "
            + "BEGIN "
            + "SET @query = CONCAT(\"SELECT fn_status_atendimento(a.status) status, " +
                "COUNT(a.idatendimento) qtde "+
                "FROM atendimento a "+
                "LEFT JOIN paciente p ON (p.idpaciente=a.idpaciente) "+
                "WHERE a.data BETWEEN '\", data_inicial, \"' AND '\", data_final, \"' " +
                "GROUP BY 1\"); "+
                "PREPARE stmt1 FROM @query; "+
                "EXECUTE stmt1;" +
                "END";
    
    /* Qtde atendimentos por tipo de exame */
    public String SQLDROPProcedureAtendimentosPorTipoExame = "DROP PROCEDURE IF EXISTS pr_dash_atendimentos_tipoexame";
    public String SQLADDProcedureAtendimentosPorTipoExame = ""
            + "CREATE PROCEDURE pr_dash_atendimentos_tipoexame(data_inicial VARCHAR(10), data_final VARCHAR(10)) "
            + "DETERMINISTIC "
            + "BEGIN "
            + "SET @query = CONCAT(\"SELECT t.nome tipoexame, " +
                "COUNT(DISTINCT a.idatendimento) qtde "+
                "FROM atendimento a "+
                "INNER JOIN atendimento_tipoexame p ON (p.idatendimento=a.idatendimento) "+
                "LEFT JOIN tipoexame t ON (t.idtipoexame=p.idtipoexame) "+
                "WHERE a.data BETWEEN '\", data_inicial, \"' AND '\", data_final, \"' " +
                "GROUP BY 1\"); "+
                "PREPARE stmt1 FROM @query; "+
                "EXECUTE stmt1;" +
                "END";
    
    /* View qtde. atendimentos por data */
    public String SQLViewAtendimentoPorData = "CREATE OR REPLACE VIEW vw_atendimentos_data AS "
            + "SELECT fn_formata_data(a.data) data, "
            + "a.data data_sql, "
            + "COUNT(a.idatendimento) qtde "
            + "FROM atendimento a "
            + "GROUP BY 1, 2";
    
    /* View qtde. atendimentos por área de exame */
    public String SQLViewAtendimentoPorAreaExame = "CREATE OR REPLACE VIEW vw_atendimentos_areaexame AS "
            + "SELECT ae.nome areaexame, a.data data_sql, fn_formata_data(a.data) data, a.idatendimento "
            + "FROM atendimento a "
            + "INNER JOIN atendimento_tipoexame ate ON "
            + "(ate.idatendimento=a.idatendimento) "
            + "INNER JOIN tipoexame te ON "
            + "(te.idtipoexame=ate.idtipoexame) "
            + "INNER JOIN areaexame ae ON "
            + "(ae.idareaexame=te.idareaexame)";
}
