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
        
        add("CREATE TRIGGER tr_audios_insert AFTER INSERT ON audios FOR EACH ROW "
                + "INSERT INTO "
                + "auditoria(usuario,data,dado_anterior,dado_novo,tipo_alteracao,tabela) "
                + "VALUES "
                + "(@user,current_date,null,CONCAT(NEW.idaudio,' | ',NEW.nome_arquivo,' | ',IFNULL(NEW.detalhes,''),' | ',NEW.idlaudo),'I','audios');");
        add("CREATE TRIGGER tr_audios_update AFTER UPDATE ON audios FOR EACH ROW "
                + "INSERT INTO "
                + "auditoria(usuario,data,dado_anterior,dado_novo,tipo_alteracao,tabela) "
                + "VALUES "
                + "(@user,current_date,CONCAT(OLD.nome_arquivo,' | ',IFNULL(OLD.detalhes,''),' | ',OLD.idlaudo),"
                + "CONCAT(NEW.nome_arquivo,' | ',IFNULL(NEW.detalhes,''),' | ',NEW.idlaudo),'U','audios');");
        add("CREATE TRIGGER tr_audios_delete AFTER DELETE ON audios FOR EACH ROW "
                + "INSERT INTO "
                + "auditoria(usuario,data,dado_anterior,dado_novo,tipo_alteracao,tabela) "
                + "VALUES "
                + "(@user,current_date,CONCAT(OLD.idaudio,' | ',OLD.nome_arquivo,' | ',IFNULL(OLD.detalhes,''),' | ',OLD.idlaudo),null,'D','audios');");
        
        add("CREATE TRIGGER tr_imagens_insert AFTER INSERT ON imagens FOR EACH ROW "
                + "INSERT INTO "
                + "auditoria(usuario,data,dado_anterior,dado_novo,tipo_alteracao,tabela) "
                + "VALUES "
                + "(@user,current_date,null,CONCAT(NEW.idimagem,' | ',NEW.nome_arquivo,' | ',IFNULL(NEW.detalhes,''),' | ',NEW.idlaudo),'I','imagens');");
        add("CREATE TRIGGER tr_imagens_update AFTER UPDATE ON imagens FOR EACH ROW "
                + "INSERT INTO "
                + "auditoria(usuario,data,dado_anterior,dado_novo,tipo_alteracao,tabela) "
                + "VALUES "
                + "(@user,current_date,CONCAT(OLD.nome_arquivo,' | ',IFNULL(OLD.detalhes,''),' | ',OLD.idlaudo),"
                + "CONCAT(NEW.nome_arquivo,' | ',IFNULL(NEW.detalhes,''),' | ',NEW.idlaudo),'U','imagens');");
        add("CREATE TRIGGER tr_imagens_delete AFTER DELETE ON imagens FOR EACH ROW "
                + "INSERT INTO "
                + "auditoria(usuario,data,dado_anterior,dado_novo,tipo_alteracao,tabela) "
                + "VALUES "
                + "(@user,current_date,CONCAT(OLD.idimagem,' | ',OLD.nome_arquivo,' | ',IFNULL(OLD.detalhes,''),' | ',OLD.idlaudo),null,'D','imagens');");
        
        add("CREATE TRIGGER tr_laudo_insert AFTER INSERT ON laudo FOR EACH ROW "
                + "INSERT INTO "
                + "auditoria(usuario,data,dado_anterior,dado_novo,tipo_alteracao,tabela) "
                + "VALUES "
                + "(@user,current_date,null,CONCAT(NEW.idlaudo,' | ',NEW.idusuario,' | ',NEW.idexame,' | ',NEW.nome,' | ',IFNULL(NEW.descricao,'')),'I','laudo');");
        add("CREATE TRIGGER tr_laudo_update AFTER UPDATE ON laudo FOR EACH ROW "
                + "INSERT INTO "
                + "auditoria(usuario,data,dado_anterior,dado_novo,tipo_alteracao,tabela) "
                + "VALUES "
                + "(@user,current_date,CONCAT(OLD.idlaudo,' | ',OLD.idusuario,' | ',OLD.idexame,' | ',OLD.nome,' | ',IFNULL(OLD.descricao,'')),"
                + "CONCAT(NEW.idlaudo,' | ',NEW.idusuario,' | ',NEW.idexame,' | ',NEW.nome,' | ',IFNULL(NEW.descricao,'')),'U','laudo');");
        add("CREATE TRIGGER tr_laudo_delete AFTER DELETE ON laudo FOR EACH ROW "
                + "INSERT INTO "
                + "auditoria(usuario,data,dado_anterior,dado_novo,tipo_alteracao,tabela) "
                + "VALUES "
                + "(@user,current_date,CONCAT(OLD.idlaudo,' | ',OLD.idusuario,' | ',OLD.idexame,' | ',OLD.nome,' | ',IFNULL(OLD.descricao,'')),null,'D','laudo');");
        
        add("CREATE TRIGGER tr_exame_insert AFTER INSERT ON exame FOR EACH ROW "
                + "INSERT INTO "
                + "auditoria(usuario,data,dado_anterior,dado_novo,tipo_alteracao,tabela) "
                + "VALUES "
                + "(@user,current_date,null,CONCAT(NEW.idexame,' | ',NEW.idusuario,' | ',NEW.idpaciente,' | ',NEW.idareaexame,' | ',NEW.idtextopadrao,' | ',NEW.status,' | ',NEW.data,' | ',NEW.hora_entrada,' | ',IFNULL(NEW.hora_saida,''),' | ',IFNULL(NEW.observacoes,''),' | ',IFNULL(NEW.resumo,'')),'I','exame');");
        add("CREATE TRIGGER tr_exame_update AFTER UPDATE ON exame FOR EACH ROW "
                + "INSERT INTO "
                + "auditoria(usuario,data,dado_anterior,dado_novo,tipo_alteracao,tabela) "
                + "VALUES "
                + "(@user,current_date,CONCAT(OLD.idexame,' | ',OLD.idusuario,' | ',OLD.idpaciente,' | ',OLD.idareaexame,' | ',OLD.idtextopadrao,' | ',OLD.status,' | ',OLD.data,' | ',OLD.hora_entrada,' | ',IFNULL(OLD.hora_saida,''),' | ',IFNULL(OLD.observacoes,''),' | ',IFNULL(OLD.resumo,'')),CONCAT(NEW.idexame,' | ',NEW.idusuario,' | ',NEW.idpaciente,' | ',NEW.idareaexame,' | ',NEW.idtextopadrao,' | ',NEW.status,' | ',NEW.data,' | ',NEW.hora_entrada,' | ',IFNULL(NEW.hora_saida,''),' | ',IFNULL(NEW.observacoes,''),' | ',IFNULL(NEW.resumo,'')),'U','exame');");
        add("CREATE TRIGGER tr_exame_delete AFTER DELETE ON exame FOR EACH ROW "
                + "INSERT INTO "
                + "auditoria(usuario,data,dado_anterior,dado_novo,tipo_alteracao,tabela) "
                + "VALUES "
                + "(@user,current_date,CONCAT(OLD.idexame,' | ',OLD.idusuario,' | ',OLD.idpaciente,' | ',OLD.idareaexame,' | ',OLD.idtextopadrao,' | ',OLD.status,' | ',OLD.data,' | ',OLD.hora_entrada,' | ',IFNULL(OLD.hora_saida,''),' | ',IFNULL(OLD.observacoes,''),' | ',IFNULL(OLD.resumo,'')),null,'D','exame');");
        
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
        
        add("CREATE TRIGGER tr_parametros_insert AFTER INSERT ON parametros FOR EACH ROW "
                + "INSERT INTO "
                + "auditoria(usuario,data,dado_anterior,dado_novo,tipo_alteracao,tabela) "
                + "VALUES "
                + "(@user,current_date,null,CONCAT(NEW.pasta_imagens,' | ',NEW.pasta_audios,' | ',NEW.auditar,' | ',IFNULL(NEW.email_usuario,''),' | ',IFNULL(NEW.arq_pdf,''),' | ',IFNULL(NEW.server_smtp,''),' | ',IFNULL(NEW.email_smtp,''),' | ',IFNULL(NEW.user_smtp,''),' | ',IFNULL(NEW.senha_smtp,''),' | ',IFNULL(NEW.porta_smtp,'')),'U','parametros');");
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
        add("DROP TRIGGER IF EXISTS  tr_exame_insert");
        add("DROP TRIGGER IF EXISTS  tr_exame_update");
        add("DROP TRIGGER IF EXISTS  tr_exame_delete");
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
    
    
}
