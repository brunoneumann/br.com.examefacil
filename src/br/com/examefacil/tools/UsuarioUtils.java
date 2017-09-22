/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package br.com.examefacil.tools;

import br.com.examefacil.bean.Acesso;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JCheckBox;

/**
 *
 * @author bruno
 */
public class UsuarioUtils {
    
    /**
     * Recepcionista = 0
     * Atend. exame = 1
     * Médico requis. = 2
     * Médico interpr. = 3
     * Administrador = 4
     * visualizar, incluir, alterar, excluir
     * @param view
     */
    
    public UsuarioUtils(){}
    
    public List<Acesso> listaPadroesAcesso(int tipoacesso){
        switch(tipoacesso){
            case 1: return listaPadroesAcessoRecepcionista();
            case 2: return listaPadroesAcessoAtendenteExame();
            case 3: return listaPadroesAcessoMedicoRequisitante();
            case 4: return listaPadroesAcessoMedicoInterpretador();
            case 5: return listaPadroesAcessoAdministrador();
            default: return null;
        }
    }
    
    public List<Acesso> listaPadroesAcessoRecepcionista(){
        List<Acesso> lista = new ArrayList<>();
        lista.add(new Acesso(1,"usuario",false,false,false,false));
        lista.add(new Acesso(1,"atendimento",true,true,true,true));
        lista.add(new Acesso(1,"at-laudo",true,false,false,false));
        lista.add(new Acesso(1,"at-imagem",false,false,false,false));
        lista.add(new Acesso(1,"at-edit-imagem",false,false,false,false));
        lista.add(new Acesso(1,"at-audio",true,false,false,false));
        lista.add(new Acesso(1,"paciente",true,true,true,true));
        lista.add(new Acesso(1,"textopadrao",true,true,true,true));
        lista.add(new Acesso(1,"areaexame",true,true,true,true));
        lista.add(new Acesso(1,"tipoexame",true,true,true,true));
        return lista;
    }
    public List<Acesso> listaPadroesAcessoAtendenteExame(){
        List<Acesso> lista = new ArrayList<>();
        lista.add(new Acesso(2,"usuario",false,false,false,false));
        lista.add(new Acesso(2,"atendimento",true,false,false,false));
        lista.add(new Acesso(2,"at-laudo",false,false,false,false));
        lista.add(new Acesso(2,"at-imagem",true,true,true,true));
        lista.add(new Acesso(2,"at-edit-imagem",false,false,false,false));
        lista.add(new Acesso(2,"at-audio",false,false,false,false));
        lista.add(new Acesso(2,"paciente",false,false,false,false));
        lista.add(new Acesso(2,"textopadrao",false,false,false,false));
        lista.add(new Acesso(2,"areaexame",false,false,false,false));
        lista.add(new Acesso(2,"tipoexame",false,false,false,false));
        return lista;
    }
    public List<Acesso> listaPadroesAcessoMedicoRequisitante(){
        List<Acesso> lista = new ArrayList<>();
        lista.add(new Acesso(3,"usuario",false,false,false,false));
        lista.add(new Acesso(3,"atendimento",true,true,true,false));
        lista.add(new Acesso(3,"at-laudo",true,false,false,false));
        lista.add(new Acesso(3,"at-imagem",true,false,false,false));
        lista.add(new Acesso(3,"at-edit-imagem",true,false,false,false));
        lista.add(new Acesso(3,"at-audio",true,false,false,false));
        lista.add(new Acesso(3,"paciente",true,false,false,false));
        lista.add(new Acesso(3,"textopadrao",false,false,false,false));
        lista.add(new Acesso(3,"areaexame",false,false,false,false));
        lista.add(new Acesso(3,"tipoexame",false,false,false,false));
        return lista;
    }
    public List<Acesso> listaPadroesAcessoMedicoInterpretador(){
        List<Acesso> lista = new ArrayList<>();
        lista.add(new Acesso(4,"usuario",false,false,false,false));
        lista.add(new Acesso(4,"atendimento",true,false,false,false));
        lista.add(new Acesso(4,"at-laudo",true,true,true,true));
        lista.add(new Acesso(4,"at-imagem",true,true,true,true));
        lista.add(new Acesso(4,"at-edit-imagem",true,true,true,true));
        lista.add(new Acesso(4,"at-audio",true,true,true,true));
        lista.add(new Acesso(4,"paciente",true,false,false,false));
        lista.add(new Acesso(4,"textopadrao",true,true,true,true));
        lista.add(new Acesso(4,"areaexame",false,false,false,false));
        lista.add(new Acesso(4,"tipoexame",false,false,false,false));
        return lista;
    }
    public List<Acesso> listaPadroesAcessoAdministrador(){
        List<Acesso> lista = new ArrayList<>();
        lista.add(new Acesso(5,"usuario",true,true,true,true));
        lista.add(new Acesso(5,"atendimento",true,true,true,true));
        lista.add(new Acesso(5,"at-laudo",true,true,true,true));
        lista.add(new Acesso(5,"at-imagem",true,true,true,true));
        lista.add(new Acesso(5,"at-edit-imagem",true,true,true,true));
        lista.add(new Acesso(5,"at-audio",true,true,true,true));
        lista.add(new Acesso(5,"paciente",true,true,true,true));
        lista.add(new Acesso(5,"textopadrao",true,true,true,true));
        lista.add(new Acesso(5,"areaexame",true,true,true,true));
        lista.add(new Acesso(5,"tipoexame",true,true,true,true));
        return lista;
    }
    
    public Acesso carregaAcessoSelecionado(int idusuario, String pagina, List<JCheckBox> lista){
        Acesso a = new Acesso();
        a.setIdusuario(idusuario);
        a.setPagina(pagina);
        a.setVisualizar(lista.get(0).isSelected());
        a.setIncluir(lista.get(1).isSelected());
        a.setAlterar(lista.get(2).isSelected());
        a.setExcluir(lista.get(3).isSelected());
        return a;
    }
    
}
