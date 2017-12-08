/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.examefacil.controller;

import br.com.examefacil.bean.Atender;
import br.com.examefacil.bean.Atendimento;
import br.com.examefacil.bean.Imagem;
import br.com.examefacil.bean.Parametros;
import br.com.examefacil.dao.AtendimentoDAO;
import br.com.examefacil.dao.ImagemDAO;
import br.com.examefacil.dao.ParametrosDAO;
import br.com.examefacil.renderer.ExamesComboModel;
import br.com.examefacil.socket.ServerSocketAtendimento;
import br.com.examefacil.tools.Util;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import br.com.examefacil.view.ImagemView;
import br.com.examefacil.view.TelaPrincipalView;
import com.towel.el.FieldResolver;
import com.towel.el.factory.FieldResolverFactory;
import com.towel.swing.table.ObjectTableModel;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.logging.log4j.LogManager;

/**
 *
 * @author Henrique
 */
public class ImagemControl {

    ImagemView view;
    TelaPrincipalView principalView;
    final org.apache.logging.log4j.Logger log = LogManager.getLogger(AtendimentoControl.class.getName());

    public ImagemControl(ImagemView view, TelaPrincipalView view2) {
        this.view = view;
        this.principalView = view2;
    }

    public void init(TelaPrincipalView view2) {

        atualizaTabelaImagem(view);
        /* Desabilita aba editar */
        carregarDados(view2);

        view.jLIDAtendimento().setVisible(false);
        view.jLIDImagem().setVisible(false);

        carregaPermissaoIncluir(view);
    }

    public boolean atualizaTabelaImagem(ImagemView view) {

        if (view.jLIDImagem().getText().equals("")) {
            return false;

        } else {
            view.jTImagens().setModel(tableModelImagem(view));
            view.jTImagens().setColumnModel(tableColumnImagem(view));
            view.jLIDImagem().setText("");
            return true;

        }

    }

    public void carregaPermissaoIncluir(ImagemView view) {

    }

    public void carregaPermissaoAlterarExcluir(ImagemView view) {

    }

    public boolean salvar(ImagemView view) {
        if (view.jTImagens().getColumnCount() <= 0) {
            Util.Error("Adicione pelo menos uma imagem");
            return false;
        } else {
            boolean result = false;
            boolean status = false;
            Atendimento b = new Atendimento();
            String caminhoAtual = "";
            String novoCaminho = "";
            for (int i = 0; i < view.jTImagens().getRowCount(); i++) {

                caminhoAtual = String.valueOf(view.jTImagens().getValueAt(i, 0));
                novoCaminho = novaImagem(view, caminhoAtual);

                Imagem a = new Imagem();
                String arquivo = novoCaminho;
                a.setNomeArquivo(arquivo);
                a.setIdatendimento(((Atender) view.jCImagens().getModel().getSelectedItem()).getIdatendimento());
                a.setIdtipoexame(Integer.parseInt(String.valueOf(view.jTImagens().getValueAt(i, 1))));
                result = new ImagemDAO().save(a);

                b = new AtendimentoDAO().get(Integer.parseInt(view.jLIDAtendimento().getText()));
                b.setStatus("3");
                status = new AtendimentoDAO().save(b);

                caminhoAtual = "";
                novoCaminho = "";
            }

            if (result && status) {
                limparTextos(view);
                desabilitaBotoesEditar(view);
                atualizaTabelaImagem(view);

                // Envia atualização da lista para o socket
                try {
                    new ServerSocketAtendimento().atualizar(principalView);
                } catch (Exception ex) {
                    log.error(ex);
                }

                return result;
            } else {
                return false;
            }
        }
        

    }

    public boolean excluir(ImagemView view) {

        List<Imagem> lista = new ArrayList();
        for (int i = 0; i < lista.size(); i++) {
            Imagem a = new Imagem();
            a.setNomeArquivo(String.valueOf(view.jTImagens().getValueAt(i, 0)));
            a.setIdatendimento(Integer.parseInt(String.valueOf(view.jLIDAtendimento().getText())));
        }

        return true;
    }

    public Atendimento getAtendimento(int id) {
        return new AtendimentoDAO().get(id);
    }

    public Imagem get(int id) {
        return new ImagemDAO().get(id);
    }

    public List<Imagem> listar() throws Exception {
        return new ImagemDAO().list();
    }

    public List<Imagem> listar(String parametro) {

        return new ImagemDAO().list(parametro);
    }

    public List<Imagem> listar2(String parametro, ImagemView view) {
        if (view.jTImagens().getRowCount() == 4) {
            List<Imagem> lista = new ArrayList();
            Imagem a = new Imagem();
            a.setNomeArquivo(parametro);
            a.setIdtipoexame(((Atender) view.jCImagens().getModel().getSelectedItem()).getIdtipoexame());
            a.setTipoExame(((Atender) view.jCImagens().getModel().getSelectedItem()).getTipoexame());

            lista.add(a);
            limparTextos(view);
            return lista;

        } else {
            List<Imagem> lista = new ArrayList();
            for (int i = 0; i < view.jTImagens().getRowCount(); i++) {
                Imagem a = new Imagem();
                String nome = view.jTImagens().getValueAt(i, 0) + "";
                a.setNomeArquivo(nome);
                int id = Integer.parseInt(String.valueOf(view.jTImagens().getValueAt(i, 1)));
                a.setIdtipoexame(id);
                lista.add(a);
            }
            Imagem b = new Imagem();
            b.setNomeArquivo(parametro);
            b.setIdtipoexame(((Atender) view.jCImagens().getModel().getSelectedItem()).getIdtipoexame());
            lista.add(b);
            limparTextos(view);

            return lista;
        }
    }

    public Atendimento atendimentoSelecionado(TelaPrincipalView view2) {
        int selected = view2.tblAtendimentos().getSelectedRow();
        return getAtendimento((int) view2.tblAtendimentos().getModel().getValueAt(selected, 0));
    }

    public void carregarDados(TelaPrincipalView view2) {
        Atendimento a = atendimentoSelecionado(view2);
        System.out.println(a.getIdatendimento());
        view.jCImagens().setModel(new ExamesComboModel(a.getIdatendimento()));
        view.jLIDAtendimento().setText(a.getIdatendimento() + "");

    }

    public TableModel tableModelImagem(ImagemView view) {
        FieldResolverFactory frf = new FieldResolverFactory(Imagem.class);
        FieldResolver frImagem = frf.createResolver("nomeArquivo", "Imagem");
        FieldResolver frIDAtendimento = frf.createResolver("idtipoexame", "ID Exame");
        //FieldResolver frNome = frf.createResolver("tipoExame", "Descrição");

        ObjectTableModel<Imagem> model
                = new ObjectTableModel<Imagem>(
                        new FieldResolver[]{frImagem, frIDAtendimento});

        model.setEditableDefault(false);
        model.setData(this.listar2(view.jLIDImagem().getText(), view));
        return model;
    }

    public TableColumnModel tableColumnImagem(ImagemView view) {

        TableColumnModel coluna = view.jTImagens().getColumnModel();
        coluna.getColumn(0).setPreferredWidth(5);
        coluna.getColumn(1).setPreferredWidth(5);
        //coluna.getColumn(2).setPreferredWidth(10);
        return coluna;
    }

    public String novaImagem(ImagemView view, String caminho) {
        File imagem = new File(caminho);
        Parametros p = new ParametrosDAO().get();
        int i = 1;
        String salvar;
        salvar = p.getPastaImagens() + "\\" + view.jLIDAtendimento().getText() + "-0.jpg";
        while (new File(salvar).exists()) {
            salvar = p.getPastaImagens() + "\\" + view.jLIDAtendimento().getText() + "-" + i + ".jpg";
            i++;
        }
        imagem.renameTo(new File(salvar));
        return salvar;
    }

    public void alteraEstadoEditarExcluir(ImagemView view, boolean action) {

    }

    public void limparTextos(ImagemView view) {
        view.jLIDImagem().setText("");
        view.jTImagens().removeAll();

    }

    public void habilitaBotoesEditar(ImagemView view) {

    }

    public void desabilitaBotoesEditar(ImagemView view) {

    }

    public void initChooserImagem() {

        view.chooserImagens().setCurrentDirectory(new java.io.File("."));
        view.chooserImagens().setDialogTitle("Selecione uma imagem");
        view.chooserImagens().setFileSelectionMode(JFileChooser.FILES_ONLY);
        view.chooserImagens().setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG", "jpg", "jpg");
        view.chooserImagens().setFileFilter(filter);
        if (view.chooserImagens().showOpenDialog(view.chooserImagens()) == JFileChooser.APPROVE_OPTION) {
            view.jLIDImagem().setText(view.chooserImagens().getSelectedFile().toString());
            atualizaTabelaImagem(view);
        }
    }
}
