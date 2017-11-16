/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.examefacil.controller;

import br.com.examefacil.bean.Atender;
import br.com.examefacil.bean.Imagem;
import br.com.examefacil.dao.ImagemDAO;
import br.com.examefacil.renderer.ExamesComboModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import br.com.examefacil.view.ImagemView;
import com.towel.el.FieldResolver;
import com.towel.el.factory.FieldResolverFactory;
import com.towel.swing.table.ObjectTableModel;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Henrique
 */
public class ImagemControl {
    
    ImagemView view;
    
    public ImagemControl(ImagemView view) {
        this.view = view;
    }
    
    public void init() {
        
        atualizaTabelaImagem(view);
        /* Desabilita aba editar */
        view.jLIDAtendimento().setVisible(false);
        view.jLIDImagem().setVisible(false);
        view.jCImagens().setModel(new ExamesComboModel());
        carregaPermissaoIncluir(view);
    }
    
    public boolean atualizaTabelaImagem(ImagemView view) {
        
        
        if (view.jLIDImagem().getText().equals("")) {
            return false;
            
        } else {
            view.jTImagens().setModel(tableModelImagem(view));
            view.jTImagens().setColumnModel(tableColumnImagem(view));
            view.jLIDAtendimento().setText("");
            return true;
            
        }

    }
    
    public void carregaPermissaoIncluir(ImagemView view) {

    }
    
    public void carregaPermissaoAlterarExcluir(ImagemView view) {

    }
    
    public boolean salvar(ImagemView view) {
        
            boolean result = false;
        for (int i=0;i < view.jTImagens().getRowCount();i++){
                Imagem a = new Imagem ();
                String arquivo = String.valueOf(view.jTImagens().getValueAt(i, 0));
                a.setNomeArquivo(arquivo);
                a.setIdatendimento(((Atender)view.jCImagens().getModel().getSelectedItem()).getIdatendimento()); 
                a.setIdtipoexame(Integer.parseInt(String.valueOf(view.jTImagens().getValueAt(i, 1))));
                result = new ImagemDAO().save(a);
        }
     
        if (result) {
            limparTextos(view);
            desabilitaBotoesEditar(view);
            atualizaTabelaImagem(view);
            //}
            return result;
        } else {
            return false;
        }
        
    }
    
    public boolean excluir(ImagemView view) {
        return false;
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
        if(view.jTImagens().getRowCount()==4){
            List<Imagem> lista = new ArrayList();
            Imagem a = new Imagem();
            a.setNomeArquivo(parametro);
            a.setIdtipoexame(((Atender)view.jCImagens().getModel().getSelectedItem()).getIdtipoexame());
            lista.add(a);
            limparTextos(view);
            return lista;                
            
        }
        else{
            List<Imagem> lista = new ArrayList();
            for (int i=0;i < view.jTImagens().getRowCount();i++){
                Imagem a = new Imagem ();
                String nome = view.jTImagens().getValueAt(i, 0)+"";
                a.setNomeArquivo(nome);
                int id = Integer.parseInt(String.valueOf(view.jTImagens().getValueAt(i, 1)));
                a.setIdtipoexame(id);
                lista.add(a);         
            } 
            Imagem b = new Imagem();
            b.setNomeArquivo(parametro);
            b.setIdtipoexame(((Atender)view.jCImagens().getModel().getSelectedItem()).getIdtipoexame());
            lista.add(b);
            limparTextos(view);
            
            return lista;
        }
    }
    
    public Imagem tipoExameSelecionado(ImagemView view) {
        return null;

    }
    
    public void carregarDados(ImagemView view) {

    }
    
    public TableModel tableModelImagem(ImagemView view) {
    FieldResolverFactory frf = new FieldResolverFactory(Imagem.class);
        FieldResolver frImagem = frf.createResolver("nomeArquivo", "Imagem");
        FieldResolver frIDAtendimento = frf.createResolver("idtipoexame", "ID Atend.");
        //FieldResolver frNome = frf.createResolver("nome", "Descrição");
        
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
        return coluna;
    }
    
    public void novoImagem(ImagemView view) {

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
    
    public void initChooserImagem(){
        
        view.chooserImagens().setCurrentDirectory(new java.io.File("."));
        view.chooserImagens().setDialogTitle("Selecione uma imagem");
        view.chooserImagens().setFileSelectionMode(JFileChooser.FILES_ONLY);
        view.chooserImagens().setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG", "jpg", "jpg");
        view.chooserImagens().setFileFilter(filter);
        if (view.chooserImagens().showOpenDialog(view.chooserImagens()) == JFileChooser.APPROVE_OPTION) {
            view.jLIDImagem().setText(view.chooserImagens().getSelectedFile().toString());
            //File imagem = new File(view.chooserImagens().getSelectedFile().toString());
            //String caminho = "caminho da pasta/"+view.chooserImagens().getName();
            //imagem.renameTo(new File("caminho"));
            
        }
    }
    }
    
