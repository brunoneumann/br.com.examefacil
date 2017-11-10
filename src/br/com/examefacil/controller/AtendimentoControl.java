/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.examefacil.controller;

import br.com.examefacil.bean.Acesso;
import br.com.examefacil.bean.Atendimento;
import br.com.examefacil.dao.AtendimentoDAO;
import br.com.examefacil.swing.TelaPrincipal;
import br.com.examefacil.tools.Util;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import br.com.examefacil.view.AtendimentoView;

/**
 *
 * @author Henrique
 */
public class AtendimentoControl {
    public AtendimentoControl (){}
    
    public void init(AtendimentoView view){
        
    }
    
    
        public void carregaPermissaoIncluir(AtendimentoView view) {
        List<Acesso> permissoes = new AcessoControl().listaAcessosUsuario(TelaPrincipal.usuarioLogado.getIdusuario());
        for (Acesso a : permissoes) {
            if (a.getPagina().equals("exame")) {
                view.jBIncluir().setEnabled(a.isIncluir());
                break;
            }
        }
    }
    
    public void carregaPermissaoAlterarExcluir(AtendimentoView view) {
        List<Acesso> permissoes = new AcessoControl().listaAcessosUsuario(TelaPrincipal.usuarioLogado.getIdusuario());
        for (Acesso a : permissoes) {
            if (a.getPagina().equals("exame")) {
                view.jBEditar().setEnabled(a.isAlterar());
                view.jBExcluir().setEnabled(a.isExcluir());
                break;
            }
        }
    }
    public void atualizaTabelaExame(AtendimentoView view){
        
    }
    public boolean salvar(AtendimentoView view){
        ArrayList<String> campos = new ArrayList<>();
        ArrayList<String> nomes = new ArrayList<>();
        campos.add(view.jTPaciente().getText());
        campos.add (view.jTDataAtendimento().getText());
        campos.add (view.jTHoraEntrada().getText());
        nomes.add (view.jTPaciente().getName());
        nomes.add (view.jTDataAtendimento().getName());
        nomes.add (view.jTHoraEntrada().getName());
       if (Util.validaCampos(campos, nomes)) {
        Atendimento exame = new Atendimento();
        if(!(view.jLIDExame().getText().equals(""))){
            exame.setIdatendimento(Integer.parseInt(view.jLIDExame().getText()));
        }
        
        exame.setIdpaciente(Integer.parseInt(view.JLIDPaciente().getText()));
        exame.setIdusuario(TelaPrincipal.usuarioLogado.getIdusuario()); //setar o código do Usuario
        exame.setStatus("2");
        exame.setResumo("teste"); //Não entendi para que serve este resumo
        exame.setData(new Util().formataData(view.getData()));
        exame.setHoraEntrada(view.getHoraAtendimeto());
        exame.setHoraSaida(view.getHoraSaida());
        exame.setObservacoes(view.getObservacoes());
        
                
        boolean result = new AtendimentoDAO().save(exame);
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
    public boolean excluir(AtendimentoView view){
        
        return false;
    }
    
    public Atendimento get(int id){
        return new AtendimentoDAO().get(id);
    }
    
    public List<Atendimento> listar() throws Exception{
        return new AtendimentoDAO().list();
    }
    
    public List<Atendimento> listar(String parametro){
        
        return new AtendimentoDAO().list(parametro);
    }
    public Atendimento exameSelecionado(AtendimentoView view){
        return null;
    }
    public void carregarDados(AtendimentoView view){
        Atendimento a = exameSelecionado(view);
        if(a!=null){
            habilitaBotoesEditar(view);
            view.jLIDExame().setText(a.getIdatendimento()+"");
            view.jTPaciente().setText(a.getIdpaciente()+"");
            view.jTDataAtendimento().setText(a.getData().toString());
            view.jTHoraEntrada().setText(a.getHoraEntrada());
            view.jTHoraSaida().setText(a.getHoraSaida());
        }
    }
    public TableModel tableModelExame(AtendimentoView view){
        return null;
    }
    public TableColumnModel tableColumnExame(AtendimentoView view){
        
        return null;
    }
    
    public void novoExame(AtendimentoView view){
        habilitaBotoesEditar(view);
        view.jLIDExame().setText(null);
    }
    
    public void alteraEstadoEditarExcluir(AtendimentoView view, boolean action){
        view.jBExcluir().setEnabled(action);
        view.jBEditar().setEnabled(action);
        
        carregaPermissaoAlterarExcluir(view);
    }
    
    public void limparTextos(AtendimentoView view){
        view.jTPaciente().setText("");
        view.jTDataAtendimento().setText("");
        view.jTHoraEntrada().setText("");
        view.jTHoraSaida().setText("");
        view.jTObservacoes().setText("");
        
    }
    
    
    public void habilitaBotoesEditar(AtendimentoView view){
        view.jBIncluir().setEnabled(false);
        view.jBExcluir().setEnabled(false);
        view.jBEditar().setEnabled(false);
        view.jBGravar().setEnabled(true);
        view.jBCancelar().setEnabled(true);

    }
    public void desabilitaBotoesEditar(AtendimentoView view){
            view.jBIncluir().setEnabled(true);
            view.jBExcluir().setEnabled(false);
            view.jBEditar().setEnabled(false);
            view.jBGravar().setEnabled(false);
            view.jBCancelar().setEnabled(false);
  
    }
}
