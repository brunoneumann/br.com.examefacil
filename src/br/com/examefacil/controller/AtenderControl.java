/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.examefacil.controller;

import br.com.examefacil.bean.Atender;
import br.com.examefacil.bean.Atendimento;
import br.com.examefacil.bean.TipoExame;
import br.com.examefacil.dao.AtenderDAO;
import br.com.examefacil.dao.AtendimentoDAO;
import br.com.examefacil.dao.TipoExameDAO;
import br.com.examefacil.view.AtenderView;
import br.com.examefacil.view.TelaPrincipalView;
import com.towel.el.FieldResolver;
import com.towel.el.factory.FieldResolverFactory;
import com.towel.swing.table.ObjectTableModel;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Henrique
 */
public class AtenderControl {
    
    public AtenderControl() {
        
    }

    public void init(AtenderView view) {
        view.jLIDExame().setVisible(false);
        view.jLIDAtendimento().setVisible(false);
        //atualizaTabelaAtender(view);
        //carregaPermissaoIncluir(view);
    }

    public void carregaPermissaoIncluir(AtenderView view) {

    }

    public void carregaPermissaoAlterarExcluir(AtenderView view) {

    }

    public boolean atualizaTabelaAtender(AtenderView view) {
        
        if (view.jTSolicitarExame().getText().equals("")) {
            return false;
        } else {
            view.jTSolicitados().setModel(tableModelAtender(view));
            view.jTSolicitados().setColumnModel(tableColumnAtender(view));
            view.jTSolicitarExame().setText("");
            view.jLIDExame().setText("");
            return true;
        }

    }

    public boolean salvar(AtenderView view) {
        boolean result = false;
        for (int i=0;i < view.jTSolicitados().getRowCount();i++){
                Atender a = new Atender ();
                int id = Integer.parseInt (view.jTSolicitados().getValueAt(i, 0)+"");
                a.setIdtipoexame(id);
                a.setIdatendimento(1); 
                result = new AtenderDAO().save(a);
        }
      
        if (result) {
            limparTextos(view);
            desabilitaBotoesEditar(view);
            atualizaTabelaAtender(view);
            //}
            return result;
        } else {
            return false;
        }
    }

    public Atender get(int id) {
        return new AtenderDAO().get(id);
    }

    public List<Atender> listar() throws Exception {
        return new AtenderDAO().list();
    }

    public List<Atender> listar(String parametro) {
        return new AtenderDAO().list(parametro);
    }

    public List<TipoExame> listar2(String parametro, String nome, AtenderView view) {
        if(view.jTSolicitados().getRowCount()==4){
            List<TipoExame> lista = new ArrayList();
            TipoExame a = new TipoExame();
            a.setIdtipoexame(Integer.parseInt(parametro));
            a.setNome(nome);
            lista.add(a);
            return lista;
        }
        else{
            List<TipoExame> lista = new ArrayList();
            for (int i=0;i < view.jTSolicitados().getRowCount();i++){
                TipoExame a = new TipoExame ();
                int id = Integer.parseInt (view.jTSolicitados().getValueAt(i, 0)+"");
                a.setIdtipoexame(id);
                String exame = String.valueOf(view.jTSolicitados().getValueAt(i, 1));
                a.setNome(exame);
                lista.add(a);         
            } 
            TipoExame b = new TipoExame();
            b.setIdtipoexame(Integer.parseInt(parametro));
            b.setNome(nome);
            lista.add(b);

            return lista;
        }
    }

    public Atender atendimentoSelecionado(TelaPrincipalView view) {
        int selected = view.tblAtendimentos().getSelectedRow();
        return get((int)view.tblAtendimentos().getModel().getValueAt(selected, 0));
    }

    public void carregarDados(TelaPrincipalView view) {
        Atender a = atendimentoSelecionado(view);
        
        if(a!=null){
            
            /*//habilitaBotoesEditar(view);
            view.jLIDAtendimento().setText(b.getIdatendimento()+"");
            view.jLPaciente().setText(b.getNome_paciente());
            view.jLIDAtendimento().setText(b.getDataString());
            view.jLHora().setText(b.getHoraEntrada());*/
        }
    }

    public TableModel tableModelAtender(AtenderView view) {
        FieldResolverFactory frf = new FieldResolverFactory(TipoExame.class);
        FieldResolver frID = frf.createResolver("idtipoexame", "ID");
        FieldResolver frNome = frf.createResolver("nome", "Descrição");

        ObjectTableModel<TipoExame> model
                = new ObjectTableModel<TipoExame>(
                        new FieldResolver[]{frID, frNome});

        
        model.setEditableDefault(false);
        model.setData(this.listar2(view.jLIDExame().getText(), view.jTSolicitarExame().getText(), view));
        return model;

    }

    public TableColumnModel tableColumnAtender(AtenderView view) {
        TableColumnModel coluna = view.jTSolicitados().getColumnModel();
        coluna.getColumn(0).setPreferredWidth(5);
        coluna.getColumn(1).setPreferredWidth(20);
        return coluna;
    }

    public void novoAtender(AtenderView view) {

    }

    public void alteraEstadoEditarExcluir(AtenderView view, boolean action) {

    }

    public void limparTextos(AtenderView view) {
        view.jLPaciente().setText("");
        view.jLData().setText("");
        view.jLHora().setText("");
        view.jTSolicitarExame().setText("");
        view.jLIDExame().setText("");
        view.jTSolicitados().removeAll();

    }

    public void habilitaBotoesEditar(AtenderView view) {

    }

    public void desabilitaBotoesEditar(AtenderView view) {

    }

}
