/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package br.com.examefacil.controller;

import br.com.examefacil.bean.Acesso;
import br.com.examefacil.bean.Atendimento;
import br.com.examefacil.dao.AtendimentoDAO;
import br.com.examefacil.dao.ParametrosDAO;
import br.com.examefacil.socket.ServerSocketAtendimento;
import br.com.examefacil.swing.TelaLogin;
import br.com.examefacil.swing.TelaPrincipal;
import static br.com.examefacil.swing.TelaPrincipal.usuarioLogado;
import br.com.examefacil.tools.Util;
import br.com.examefacil.view.TelaPrincipalView;
import com.towel.el.FieldResolver;
import com.towel.el.factory.FieldResolverFactory;
import com.towel.swing.table.ObjectTableModel;
import java.util.Date;
import java.util.List;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import org.apache.logging.log4j.LogManager;
import org.jdesktop.xswingx.PromptSupport;

/**
 *
 * @author Henrique
 */
public class TelaPrincipalControl {
    
    final org.apache.logging.log4j.Logger log = LogManager.getLogger(TelaPrincipalControl.class.getName());
    
    public void init(TelaPrincipalView view) {
        // Inicia as funções do banco
        new ParametrosDAO().initFunctions(new ParametrosDAO().get());
        
        iniciarPeriodoDatas(view);
        carregaPermissaoIncluirAtendimento(view);
        if(visualizar()){
            new ServerSocketAtendimento().start(view);
        }
        
        habilitaMenus(view);
        carregaPermissoes(view, usuarioLogado.getIdusuario());
        
        PromptSupport.setPrompt("Buscar paciente", view.jTPesquisarAtendimento());
    }
    
    public void iniciarPeriodoDatas(TelaPrincipalView view){
        view.jDteInicial().setDate(Util.add_days(-7, new Date()));
        view.jDteFinal().setDate(new Date());
    }
    
    public boolean visualizar(){
        List<Acesso> permissoes = new AcessoControl().listaAcessosUsuario(TelaPrincipal.usuarioLogado.getIdusuario());
        for (Acesso a : permissoes) {
            if (a.getPagina().equals("atendimento")) {
                if(a.isVisualizar()){
                    return true;
                }
                break;
            }
        }
        return false;
    }
    
    public void carregaPermissaoIncluirAtendimento(TelaPrincipalView view) {
        List<Acesso> permissoes = new AcessoControl().listaAcessosUsuario(TelaPrincipal.usuarioLogado.getIdusuario());
        for (Acesso a : permissoes) {
            if (a.getPagina().equals("atendimento")) {
                view.jBIncluir().setEnabled(a.isIncluir());
                break;
            }else if (a.getPagina().equals("at-laudo")){
                view.jBLaudo().setEnabled(a.isIncluir());
                break;
            }else if (a.getPagina().equals("at-imagem")){
                view.jBImagens().setEnabled(a.isIncluir());
                break;
            }
        }
    }
    
    public void carregaPermissaoAlterarExcluirAtendimento(TelaPrincipalView view) {
        List<Acesso> permissoes = new AcessoControl().listaAcessosUsuario(TelaPrincipal.usuarioLogado.getIdusuario());
        for (Acesso a : permissoes) {
            if (a.getPagina().equals("atendimento")) {
                view.jBEditar().setEnabled(a.isAlterar());
                view.jBExcluir().setEnabled(a.isExcluir());
                break;
            }
        }
    }
    
    public void pesquisar(TelaPrincipalView view){
        try {
            List<Atendimento> lista = new TelaPrincipalControl().listar(
                    view.jTPesquisarAtendimento().getText(),
                    Util.formataDataSQL(view.jDteInicial().getDate()),
                    Util.formataDataSQL(view.jDteFinal().getDate()));
            atualizaTabelaAtendimento(view, lista);
            
        } catch(Exception ex){
            log.error(ex);
        }
    }
    
    public List<Atendimento> listar(String nome_paciente, String dataInicial, String dataFinal) {
        try {
            return new AtendimentoDAO().listaAtendimentos(nome_paciente, dataInicial, dataFinal, TelaPrincipal.usuarioLogado.getTipo_acesso());
        } catch(Exception ex){
            log.error(ex);
        }
        return null;
    }
    
    public void atualizaTabelaAtendimento(TelaPrincipalView view, List<Atendimento> lista){
        view.tblAtendimentos().setModel(tableModelAtendimentos(view, lista));
        view.tblAtendimentos().setColumnModel(tableColumnAtendimentos(view));
    }
    public TableColumnModel tableColumnAtendimentos(TelaPrincipalView view) {
        TableColumnModel coluna = view.tblAtendimentos().getColumnModel();
        coluna.getColumn(0).setPreferredWidth(1);
        coluna.getColumn(1).setPreferredWidth(100);
        coluna.getColumn(2).setPreferredWidth(100);
        coluna.getColumn(3).setPreferredWidth(5);
        coluna.getColumn(4).setPreferredWidth(5);
        coluna.getColumn(5).setPreferredWidth(5);
        coluna.getColumn(6).setPreferredWidth(100);
        return coluna;
    }
    public TableModel tableModelAtendimentos(TelaPrincipalView view, List<Atendimento> lista) {
        FieldResolverFactory frf = new FieldResolverFactory(Atendimento.class);
        FieldResolver frID = frf.createResolver("idatendimento", "ID");
        FieldResolver frNomeUsuario = frf.createResolver("nome_usuario", "Usuário");
        FieldResolver frNomePaciente = frf.createResolver("nome_paciente", "Paciente");
        FieldResolver frData = frf.createResolver("dataString", "Data");
        FieldResolver frHoraEntrada = frf.createResolver("horaEntrada", "Hora entrada");
        FieldResolver frHoraSaida = frf.createResolver("horaSaida", "Hora saída");
        FieldResolver frStatus = frf.createResolver("status", "Status");
        
        ObjectTableModel<Atendimento> model = new ObjectTableModel<Atendimento>(
                new FieldResolver[]{frID, frNomeUsuario, frNomePaciente, frData, frHoraEntrada, frHoraSaida, frStatus}
        );
        
        model.setEditableDefault(false);
        model.setData(lista);
        return model;
    }
    
    public void carregaPermissoes(TelaPrincipalView view, int idusuario) {
        List<Acesso> permissoes = new AcessoControl().listaAcessosUsuario(idusuario);
        for (Acesso a : permissoes) {
            if (a.getPagina().equals("paciente")) {
                view.jMPaciente().setEnabled(a.isVisualizar());
            }
            if (a.getPagina().equals("tipoexame")) {
                view.jMTipoExame().setEnabled(a.isVisualizar());
            }
            if (a.getPagina().equals("areaexame")) {
                view.jMAreaExame().setEnabled(a.isVisualizar());
            }
            if (a.getPagina().equals("usuario")) {
                view.jMUsuario().setEnabled(a.isVisualizar());
            }
            if (a.getPagina().equals("textopadrao")) {
                view.jMTextoPadrao().setEnabled(a.isVisualizar());
            }
            if (a.getPagina().equals("parametros")) {
                view.jMParametros().setEnabled(a.isVisualizar());
            }
        }
    }
    
    public Atendimento atendimentoSelecionado(TelaPrincipalView view) {
        int selected = view.tblAtendimentos().getSelectedRow();
        return get((int) view.tblAtendimentos().getModel().getValueAt(selected, 0));
    }
    
    public Atendimento get(int id) {
        return new AtendimentoDAO().get(id);
    }
    
    public boolean excluir(TelaPrincipalView view) {
        if (Util.Confirma("Deseja realmente excluir este atendimento?")) {
            boolean result = new AtendimentoDAO().delete(atendimentoSelecionado(view));
            if (result) {
                // Envia atualização da lista para o socket
                try {
                    new ServerSocketAtendimento().atualizar(view);
                } catch(Exception ex){
                    System.out.println("try aqui");
                }
            }
        }
        carregaPermissaoAlterarExcluirAtendimento(view);
        return true;
    }
    
    public void habilitaMenus(TelaPrincipalView view) {
        view.jMenuBar1().setEnabled(true);
        view.jMCadastro().setEnabled(true);
        //view.jILogin().setVisible(false);
        view.jIExame().setVisible(true);
    }
    
    public void desabilitaMenus(TelaPrincipalView view) {
        view.jMenuBar1().setEnabled(false);
        view.jMCadastro().setEnabled(false);
        //view.jILogin().setVisible(false);
        view.jIExame().setVisible(false);
        view.telaPrincipal().setVisible(false);
        TelaLogin tela = new TelaLogin();
        tela.setVisible(true);
    }
    
    
    
    
    
    
    
}
