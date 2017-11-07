/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.examefacil.controller;

import br.com.examefacil.bean.Acesso;
import br.com.examefacil.bean.Exame;
import br.com.examefacil.dao.ExameDAO;
import br.com.examefacil.swing.TelaPrincipal;
import br.com.examefacil.tools.Util;
import br.com.examefacil.view.ExameView;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Henrique
 */
public class ExameControl {
    public ExameControl (){}
    
    public void init(ExameView view){
        
    }
    
    
        public void carregaPermissaoIncluir(ExameView view) {
        List<Acesso> permissoes = new AcessoControl().listaAcessosUsuario(TelaPrincipal.usuarioLogado.getIdusuario());
        for (Acesso a : permissoes) {
            if (a.getPagina().equals("exame")) {
                view.jBIncluir().setEnabled(a.isIncluir());
                break;
            }
        }
    }
    
    public void carregaPermissaoAlterarExcluir(ExameView view) {
        List<Acesso> permissoes = new AcessoControl().listaAcessosUsuario(TelaPrincipal.usuarioLogado.getIdusuario());
        for (Acesso a : permissoes) {
            if (a.getPagina().equals("exame")) {
                view.jBEditar().setEnabled(a.isAlterar());
                view.jBExcluir().setEnabled(a.isExcluir());
                break;
            }
        }
    }
    public void atualizaTabelaExame(ExameView view){
        
    }
    public boolean salvar(ExameView view){
        ArrayList<String> campos = new ArrayList<>();
        ArrayList<String> nomes = new ArrayList<>();
        campos.add(view.jTPaciente().getText());
        campos.add (view.jTDataAtendimento().getText());
        campos.add (view.jTHoraEntrada().getText());
        nomes.add (view.jTPaciente().getName());
        nomes.add (view.jTDataAtendimento().getName());
        nomes.add (view.jTHoraEntrada().getName());
       if (Util.validaCampos(campos, nomes)) {
        Exame exame = new Exame();
        if(!(view.jLIDExame().getText().equals(""))){
            exame.setIdexame(Integer.parseInt(view.jLIDExame().getText()));
        }
        
        exame.setIdpaciente(Integer.parseInt(view.JLIDPaciente().getText()));
        exame.setIdusuario(3); //setar o código do Usuario
        exame.setIdareaexame(28); //remover
        exame.setIdtextopadrao(1); //remover
        exame.setStatus("2");
        exame.setResumo("teste"); //Não entendi para que serve este resumo
        exame.setData(new Util().formataData(view.getData()));
        exame.setHoraEntrada(view.getHoraAtendimeto());
        exame.setHoraSaida(view.getHoraSaida());
        
                
        boolean result = new ExameDAO().save(exame);
        if(result){
            limparTextos(view);
            desabilitaBotoesEditar(view);
            //atualizaTabelaTextoPadrao(view);
        }
        return result;
        }
        else {
            return false;
        }
        
    }
    public boolean excluir(ExameView view){
        
        return false;
    }
    
    public Exame get(int id){
        return new ExameDAO().get(id);
    }
    
    public List<Exame> listar() throws Exception{
        return new ExameDAO().list();
    }
    
    public List<Exame> listar(String parametro){
        
        return new ExameDAO().list(parametro);
    }
    public Exame exameSelecionado(ExameView view){
        return null;
    }
    public void carregarDados(ExameView view){
        Exame a = exameSelecionado(view);
        if(a!=null){
            habilitaBotoesEditar(view);
            view.jLIDExame().setText(a.getIdexame()+"");
            view.jTPaciente().setText(a.getIdpaciente()+"");
            view.jTDataAtendimento().setText(a.getData().toString());
            view.jTHoraEntrada().setText(a.getHoraEntrada());
            view.jTHoraSaida().setText(a.getHoraSaida());
        }
    }
    public TableModel tableModelExame(ExameView view){
        return null;
    }
    public TableColumnModel tableColumnExame(ExameView view){
        
        return null;
    }
    
    public void novoExame(ExameView view){
        habilitaBotoesEditar(view);
        view.jLIDExame().setText(null);
    }
    
    public void alteraEstadoEditarExcluir(ExameView view, boolean action){
        view.jBExcluir().setEnabled(action);
        view.jBEditar().setEnabled(action);
        
        carregaPermissaoAlterarExcluir(view);
    }
    
    public void limparTextos(ExameView view){
        view.jTPaciente().setText("");
        view.jTDataAtendimento().setText("");
        view.jTHoraEntrada().setText("");
        view.jTHoraSaida().setText("");
        
    }
    
    
    public void habilitaBotoesEditar(ExameView view){
        view.jBIncluir().setEnabled(false);
        view.jBExcluir().setEnabled(false);
        view.jBEditar().setEnabled(false);
        view.jBGravar().setEnabled(true);
        view.jBCancelar().setEnabled(true);

    }
    public void desabilitaBotoesEditar(ExameView view){
            view.jBIncluir().setEnabled(true);
            view.jBExcluir().setEnabled(false);
            view.jBEditar().setEnabled(false);
            view.jBGravar().setEnabled(false);
            view.jBCancelar().setEnabled(false);
  
    }
}
