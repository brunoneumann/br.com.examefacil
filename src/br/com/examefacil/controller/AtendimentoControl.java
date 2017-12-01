/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package br.com.examefacil.controller;

import br.com.examefacil.bean.Atendimento;
import br.com.examefacil.dao.AtendimentoDAO;
import br.com.examefacil.socket.ServerSocketAtendimento;
import br.com.examefacil.swing.TelaPrincipal;
import br.com.examefacil.tools.Util;
import java.util.ArrayList;
import br.com.examefacil.view.AtendimentoView;
import br.com.examefacil.view.TelaPrincipalView;
import org.apache.logging.log4j.LogManager;
/**
 *
 * @author Henrique
 */
public class AtendimentoControl {
    
    final org.apache.logging.log4j.Logger log = LogManager.getLogger(AtendimentoControl.class.getName());
    public TelaPrincipalView viewPrincipal;
    
    public AtendimentoControl(TelaPrincipalView viewPrincipal){
        this.viewPrincipal = viewPrincipal;
    }
    
    public void init(AtendimentoView view, Atendimento atendimento){
        if(atendimento!=null){
            carregarDados(view, atendimento);
        }
    }
    
    public boolean salvar(AtendimentoView view) {
        ArrayList<String> campos = new ArrayList<>();
        ArrayList<String> nomes = new ArrayList<>();
        campos.add(view.jTPaciente().getText());
        campos.add(view.jDtDataAtendimento().getDateFormatString());
        campos.add(view.jTHoraEntrada().getText());
        nomes.add(view.jTPaciente().getName());
        nomes.add(view.jDtDataAtendimento().getName());
        nomes.add(view.jTHoraEntrada().getName());
        if (Util.validaCampos(campos, nomes)) {
            Atendimento atendimento = new Atendimento();
            if(!(view.jLIDAtendimento().getText().equals(""))){
                atendimento.setIdatendimento(Integer.parseInt(view.jLIDAtendimento().getText()));
            }
            
            atendimento.setIdpaciente(Integer.parseInt(view.JLIDPaciente().getText()));
            if(!view.jLIDUsuario().getText().equals("")){
                atendimento.setIdusuario(Integer.parseInt(view.jLIDUsuario().getText()));
            } else {
                atendimento.setIdusuario(TelaPrincipal.usuarioLogado.getIdusuario());
            }
            atendimento.setStatus("1");
            atendimento.setData(view.getData());
            atendimento.setHoraEntrada(view.getHoraAtendimeto());
            if(view.getHoraSaida().equals("  :  ")){
                atendimento.setHoraSaida("");
            } else {
                atendimento.setHoraSaida(view.getHoraSaida());
            }
            atendimento.setObservacoes(view.getObservacoes());
            
            boolean result = new AtendimentoDAO().save(atendimento);
            if(result){
                limparTextos(view);
                desabilitaBotoesEditar(view);
                
                // Envia atualização da lista para o socket
                try {
                    new ServerSocketAtendimento().atualizar(viewPrincipal);
                } catch(Exception ex){
                    log.error(ex);
                }
            }
            return result;
        }
        else {
            return false;
        }
    }

    
    public void carregarDados(AtendimentoView view, Atendimento a){
        if(a!=null){
            habilitaBotoesEditar(view);
            view.jLIDAtendimento().setText(a.getIdatendimento()+"");
            view.JLIDPaciente().setText(a.getIdpaciente()+"");
            view.jLIDUsuario().setText(a.getIdusuario()+"");
            view.jTPaciente().setText(a.getNome_paciente());
            view.jDtDataAtendimento().setDate(a.getData());
            view.jTHoraEntrada().setText(a.getHoraEntrada());
            view.jTHoraSaida().setText(a.getHoraSaida());
            view.jTObservacoes().setText(a.getObservacoes());
        }
    }
    
    public void novoExame(AtendimentoView view){
        habilitaBotoesEditar(view);
        view.jLIDAtendimento().setText(null);
    }
    
    public void limparTextos(AtendimentoView view){
        view.jTPaciente().setText("");
        view.jDtDataAtendimento().setDateFormatString("");
        view.jTHoraEntrada().setText("");
        view.jTHoraSaida().setText("");
        view.jTObservacoes().setText("");
        
    }
    
    
    public void habilitaBotoesEditar(AtendimentoView view){
        view.jBGravar().setEnabled(true);
        
    }
    public void desabilitaBotoesEditar(AtendimentoView view){
        view.jBGravar().setEnabled(false);
    }
}