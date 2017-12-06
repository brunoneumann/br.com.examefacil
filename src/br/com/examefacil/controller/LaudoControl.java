/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.examefacil.controller;

import br.com.examefacil.bean.Atender;
import br.com.examefacil.bean.Atendimento;
import br.com.examefacil.bean.Audio;
import br.com.examefacil.bean.Imagem;
import br.com.examefacil.bean.Interpretacao;
import br.com.examefacil.bean.Parametros;
import br.com.examefacil.bean.TextoPadrao;
import br.com.examefacil.dao.AtenderDAO;
import br.com.examefacil.dao.AtendimentoDAO;
import br.com.examefacil.dao.AudioDAO;
import br.com.examefacil.dao.ImagemDAO;
import br.com.examefacil.dao.InterpretacaoDAO;
import br.com.examefacil.dao.ParametrosDAO;
import br.com.examefacil.dao.TextoPadraoDAO;
import br.com.examefacil.view.LaudoView;
import br.com.examefacil.view.TelaPrincipalView;
import com.towel.el.FieldResolver;
import com.towel.el.factory.FieldResolverFactory;
import com.towel.swing.table.ObjectTableModel;
import java.io.File;
import java.util.List;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Henrique
 */
public class LaudoControl {
    
    TelaPrincipalView principalView;
    LaudoView view;

    public LaudoControl(LaudoView view) {
        this.view = view;
    }

    public void init(TelaPrincipalView view2) {

        
        /* Desabilita aba editar */
        carregarDados(view2); 
        view.jLIDAtendimento().setVisible(false);
        view.jLAudio().setVisible(false);
        view.jLImagem().setVisible(false);
        
        //carregaPermissaoIncluir(view);
    }

    public void atualizaTabelaImagem(LaudoView view) {
        view.jTExames().setModel(tableModelImagem(view));
        view.jTExames().setColumnModel(tableColumnLaudo(view));

    }

    public void carregaPermissaoIncluir(LaudoView view) {

    }

    public void carregaPermissaoAlterarExcluir(LaudoView view) {

    }


    public Atendimento getAtendimento(int id) {
        return new AtendimentoDAO().get(id);
    }
    public TextoPadrao getTexto(int id) {
        return new TextoPadraoDAO().get(id);
    }
    
    public Atender get(int id) {
        return new AtenderDAO().get(id);
    }

    public List<Atender> listar() throws Exception {
        return new AtenderDAO().list();
    }

    public List<Imagem> listar(String parametro) {
        return new ImagemDAO().list(parametro);
    }

    public List<Interpretacao> listar(String atendimento, String exame){
        return new InterpretacaoDAO().list(atendimento, exame);
    }

    public Atendimento atendimentoSelecionado(TelaPrincipalView view2) {
        int selected = view2.tblAtendimentos().getSelectedRow();
        return getAtendimento((int)view2.tblAtendimentos().getModel().getValueAt(selected, 0));
    }

    public void carregarDados(TelaPrincipalView view2) {
        Atendimento a = atendimentoSelecionado(view2);
        view.jLIDAtendimento().setText(a.getIdatendimento()+"");
        atualizaTabelaImagem(view);
        List <Audio> audio = new AudioDAO().list(view.jLIDAtendimento().getText());
        if (audio.isEmpty()){
            view.jBPlay().setEnabled(false);
        }else{
            view.jLAudio().setText(audio.get(0).getNomeArquivo());
        }
        
        
        

    }
    public List visualizarArquivos(int id, int exame) {
        return new ImagemDAO().list(String.valueOf(id), String.valueOf(exame));
    }

    public TableModel tableModelImagem(LaudoView view) {
        FieldResolverFactory frf = new FieldResolverFactory(Imagem.class);
        FieldResolver frIDAtendimento = frf.createResolver("idtipoexame", "ID Exame");
        FieldResolver frCaminho = frf.createResolver("nomeArquivo", "Caminho");

        ObjectTableModel<Imagem> model
                = new ObjectTableModel<Imagem>(
                        new FieldResolver[]{frIDAtendimento, frCaminho});

        model.setEditableDefault(false);
        model.setData(this.listar(view.jLIDAtendimento().getText()));
        return model;
    }

    public TableColumnModel tableColumnLaudo(LaudoView view) {

        TableColumnModel coluna = view.jTExames().getColumnModel();
        coluna.getColumn(0).setPreferredWidth(5);
        coluna.getColumn(1).setPreferredWidth(50);
        return coluna;
    }

    public void alteraEstadoEditarExcluir(LaudoView view, boolean action) {

    }

    public void limparTextos(LaudoView view) {
        view.jTInterpretacao().setText("");
        view.jTExames().removeAll();

    }

    public void habilitaBotoesEditar(LaudoView view) {

    }

    public void desabilitaBotoesEditar(LaudoView view) {

    }
    public void abrirImagem(LaudoView view){
        
        Parametros p = new ParametrosDAO().get();
        String caminho = String.valueOf(view.jTExames().getValueAt(view.jTExames().getSelectedRow(), 1));
        
        ImageIcon img = new ImageIcon(caminho);
        img.setImage(img.getImage().getScaledInstance(520, 320, 100));
        List <Interpretacao> a = listar(view.jLIDAtendimento().getText(), String.valueOf(view.jTExames().getValueAt(view.jTExames().getSelectedRow(), 0)));
        if(a.size()<=0){
            view.jTInterpretacao().setText("Nenhum texto informado");
        }else{
            String id = a.get(0).getIdtextopadrao()+"";
            TextoPadrao t = getTexto(Integer.parseInt(id));
            view.jTInterpretacao().setText(t.getTexto());
        }
        
        
        view.jLImagem().setIcon(img);
        
    }
    public void abrirSom() { // funciona apenas com arquivos .WAV
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(view.jLAudio().getText()).getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception ex) {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();

        }
    }
    
    
    
}
