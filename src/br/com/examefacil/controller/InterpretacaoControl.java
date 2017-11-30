/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.examefacil.controller;

import br.com.examefacil.bean.Atender;
import br.com.examefacil.bean.Imagem;
import br.com.examefacil.bean.Interpretacao;
import br.com.examefacil.bean.Parametros;
import br.com.examefacil.dao.ImagemDAO;
import br.com.examefacil.dao.InterpretacaoDAO;
import br.com.examefacil.dao.ParametrosDAO;
import br.com.examefacil.renderer.ExamesComboModel;
import br.com.examefacil.swing.TelaPrincipal;
import br.com.examefacil.view.InterpretacaoView;
import com.towel.el.FieldResolver;
import com.towel.el.factory.FieldResolverFactory;
import com.towel.swing.table.ObjectTableModel;
import java.io.File;
import java.io.IOException;
import java.text.Normalizer.Form;
import java.util.ArrayList;
import java.util.List;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.TargetDataLine;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Henrique
 */
public class InterpretacaoControl {

    public void init(InterpretacaoView view) {
        view.jLIDAtendimento().setText("1");
        view.jCImagens().setModel(new ExamesComboModel());
        view.jLIDTextoPadrao().setVisible(false);
        view.jLIDTextoPadraoExame().setVisible(false);
        view.jLIDAtendimento().setVisible(false);
        atualizaTabelaImagens(view);
        //carregaPermissaoIncluir(view);

    }

    public void carregaPermissaoIncluir(InterpretacaoView view) {

    }

    public void carregaPermissaoAlterarExcluir(InterpretacaoView view) {

    }

   public void atualizaTabelaImagens(InterpretacaoView view) {  
            view.jTImagens().setModel(tableModelInterpretacao(view));
            view.jTImagens().setColumnModel(tableColumnInterpretacao(view));
    }

    public void textoPadrao(InterpretacaoView view) {
        view.jLIDTextoPadraoExame().setText(view.jLIDTextoPadrao().getText());
        
    }

    public boolean salvar(InterpretacaoView view) throws IOException {
        boolean result = false;

        Interpretacao a = new Interpretacao();

        a.setIdatendimento(((Atender) view.jCImagens().getModel().getSelectedItem()).getIdatendimento());
        a.setIdtextopadrao(Integer.parseInt(view.jLIDTextoPadraoExame().getText()));
        a.setIdtipoexame(((Atender) view.jCImagens().getModel().getSelectedItem()).getIdtipoexame());;
        a.setIdusuario(TelaPrincipal.usuarioLogado.getIdusuario());

        result = new InterpretacaoDAO().save(a);

        if (result) {
            limparTextos(view);
            desabilitaBotoesEditar(view);
            atualizaTabelaImagens(view);
            return result;
        } else {
            return false;
        }
    }

    public Interpretacao get(int id) {
        return new InterpretacaoDAO().get(id);
    }

    public List<Interpretacao> listar() throws Exception {
        return new InterpretacaoDAO().list();
    }

    public List<Interpretacao> listar(String parametro) {
        return new InterpretacaoDAO().list(parametro);
    }

    public Interpretacao atendimentoSelecionado(InterpretacaoView view) {
        //int selected = view.JTABAtendimentos().getSelectedRow();
        //return get((int)view.JTABAtendimento().getModel().getValueAt(selected, 0));
        Interpretacao a = new Interpretacao();
        a.setIdatendimento(1);
        return a;
    }

    public void carregarDados(InterpretacaoView view) {
        /*TelaPrincipal a = TelaPrincipal(view);
        if(a!=null){
            habilitaBotoesEditar(view);
            view.jLIDAtender().setText(a.getIdareaexame()+"");
            view.jTAtender().setText(a.getNome());
        }*/
    }
    
    public List visualizarArquivos(int id) {
        //APENAS PARA TESTES
        return new ImagemDAO().list(String.valueOf(id));
    }

    public TableModel tableModelInterpretacao(InterpretacaoView view) {
        FieldResolverFactory frf = new FieldResolverFactory(Imagem.class);
        FieldResolver frNome = frf.createResolver("nomeArquivo", "Caminho");

        ObjectTableModel<Imagem> model
                = new ObjectTableModel<Imagem>(
                        new FieldResolver[]{frNome});

        
        model.setEditableDefault(false);
        model.setData(this.visualizarArquivos(Integer.parseInt(String.valueOf(view.jLIDAtendimento().getText()))));
        return model;

    }

    public TableColumnModel tableColumnInterpretacao(InterpretacaoView view) {
        TableColumnModel coluna = view.jTImagens().getColumnModel();
        coluna.getColumn(0).setPreferredWidth(20);
        return coluna;
    }

    public void alteraEstadoEditarExcluir(InterpretacaoView view, boolean action) {

    }

    public void limparTextos(InterpretacaoView view) {
        view.jTLaudo().setText("");
        view.jLIDTextoPadraoExame().setText("");
        view.jLIDTextoPadrao().setText("");
    }

    public void habilitaBotoesEditar(InterpretacaoView view) {

    }

    public void desabilitaBotoesEditar(InterpretacaoView view) {

    }
    
    public void abrirImagem(InterpretacaoView view){
        
        Parametros p = new ParametrosDAO().get();
        String caminho = String.valueOf(view.jTImagens().getValueAt(view.jTImagens().getSelectedRow(), 0));
        
        ImageIcon img = new ImageIcon(caminho);
        img.setImage(img.getImage().getScaledInstance(520, 320, 100));
        
        view.jLImagem().setIcon(img);
        
    }

}
