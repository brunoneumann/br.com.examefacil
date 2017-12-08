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
import br.com.examefacil.dao.AtendimentoDAO;
import br.com.examefacil.dao.AudioDAO;
import br.com.examefacil.dao.ImagemDAO;
import br.com.examefacil.dao.InterpretacaoDAO;
import br.com.examefacil.dao.ParametrosDAO;
import br.com.examefacil.renderer.ExamesComboModel;
import br.com.examefacil.socket.ServerSocketAtendimento;
import br.com.examefacil.swing.TelaPrincipal;
import br.com.examefacil.tools.Util;
import br.com.examefacil.view.InterpretacaoView;
import br.com.examefacil.view.TelaPrincipalView;
import com.towel.el.FieldResolver;
import com.towel.el.factory.FieldResolverFactory;
import com.towel.swing.table.ObjectTableModel;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import org.apache.logging.log4j.LogManager;

/**
 *
 * @author Henrique
 */
public class InterpretacaoControl {

    InterpretacaoView view;
    TelaPrincipalView viewPrincipal;
    final org.apache.logging.log4j.Logger log = LogManager.getLogger(AtendimentoControl.class.getName());

    public InterpretacaoControl(InterpretacaoView view, TelaPrincipalView view2) {
        this.view = view;
        this.viewPrincipal = view2;
    }

    public void init(TelaPrincipalView view2) {

        carregarDados(view2);
        view.jLIDTextoPadrao().setVisible(false);
        view.jLIDTextoPadraoExame().setVisible(false);
        view.jLIDAtendimento().setVisible(false);
        view.jLAudio().setVisible(false);
        view.jLIDTextoPadrao().setEnabled(false);
        //carregaPermissaoIncluir(view);

    }

    public void carregaPermissaoIncluir(InterpretacaoView view) {

    }

    public void carregaPermissaoAlterarExcluir(InterpretacaoView view) {

    }

    public void atualizarItensTabela(InterpretacaoView view) {
        atualizaTabelaImagens(view);
    }

    public void atualizaTabelaImagens(InterpretacaoView view) {
        view.jTImagens().setModel(tableModelInterpretacao(view));
        view.jTImagens().setColumnModel(tableColumnInterpretacao(view));
    }

    public boolean textoPadrao(InterpretacaoView view) {
        boolean status = false;
        view.jLIDTextoPadraoExame().setText(view.jLIDTextoPadrao().getText());
        if (view.jLIDTextoPadraoExame().getText().equals("")) {
            Util.Error("Selecione um texto padrão");
            return false;
        } else {
            try {
                status = salvar(view);
            } catch (IOException ex) {
                Logger.getLogger(InterpretacaoControl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(status){
            return true;
        }else{
            return false;
        }
    }

    public void alteraStatus(InterpretacaoView view) {
        boolean audio = false;
        String caminhoAtual = "";
        String novoCaminho = "";

        caminhoAtual = view.jLAudio().getText();
        if (!(view.jLAudio().getText().equals(""))) {
            novoCaminho = novoAudio(view, caminhoAtual);
            Audio b = new Audio();
            b.setNomeArquivo(novoCaminho);
            b.setIdatendimento(((Atender) view.jCImagens().getModel().getSelectedItem()).getIdatendimento());
            b.setDetalhes(view.jLAudio().getText());
            audio = new AudioDAO().save(b);
        }

        Atendimento a = new AtendimentoDAO().get(Integer.parseInt(view.jLIDAtendimento().getText()));
        boolean result = false;
        a.setStatus("4");
        result = new AtendimentoDAO().save(a);

        // Envia atualização da lista para o socket
        try {
            new ServerSocketAtendimento().atualizar(viewPrincipal);
        } catch (Exception ex) {
            log.error(ex);
        }

    }

    public void refazerExames(InterpretacaoView view) {
        Atendimento a = new AtendimentoDAO().get(Integer.parseInt(view.jLIDAtendimento().getText()));
        boolean result = false;
        a.setStatus("2");
        result = new AtendimentoDAO().save(a);

        // Envia atualização da lista para o socket
        try {
            new ServerSocketAtendimento().atualizar(viewPrincipal);
        } catch (Exception ex) {
            log.error(ex);
        }

    }

    public boolean salvar(InterpretacaoView view) throws IOException {
        boolean result = false;
        
        Interpretacao a = new Interpretacao();

        a.setIdatendimento(((Atender) view.jCImagens().getModel().getSelectedItem()).getIdatendimento());
        a.setIdtextopadrao(Integer.parseInt(view.jLIDTextoPadraoExame().getText()));
        a.setIdtipoexame(((Atender) view.jCImagens().getModel().getSelectedItem()).getIdtipoexame());
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

    public Atendimento getAtendimento(int id) {
        return new AtendimentoDAO().get(id);
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

    public Atendimento atendimentoSelecionado(TelaPrincipalView view) {
        int selected = view.tblAtendimentos().getSelectedRow();
        return getAtendimento((int) view.tblAtendimentos().getModel().getValueAt(selected, 0));
    }

    public void carregarDados(TelaPrincipalView view2) {
        Atendimento a = atendimentoSelecionado(view2);
        view.jCImagens().setModel(new ExamesComboModel(a.getIdatendimento()));
        view.jLIDAtendimento().setText(a.getIdatendimento() + "");
    }

    public List visualizarArquivos(int id, int exame) {
        return new ImagemDAO().list(String.valueOf(id), String.valueOf(exame));
    }

    public TableModel tableModelInterpretacao(InterpretacaoView view) {
        FieldResolverFactory frf = new FieldResolverFactory(Imagem.class);
        FieldResolver frNome = frf.createResolver("nomeArquivo", "Caminho");

        ObjectTableModel<Imagem> model
                = new ObjectTableModel<Imagem>(
                        new FieldResolver[]{frNome});

        model.setEditableDefault(false);
        model.setData(this.visualizarArquivos(Integer.parseInt(String.valueOf(view.jLIDAtendimento().getText())),
                (((Atender) view.jCImagens().getModel().getSelectedItem()).getIdtipoexame())));
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

    public void abrirImagem(InterpretacaoView view) {

        Parametros p = new ParametrosDAO().get();
        String caminho = String.valueOf(view.jTImagens().getValueAt(view.jTImagens().getSelectedRow(), 0));

        ImageIcon img = new ImageIcon(caminho);
        img.setImage(img.getImage().getScaledInstance(520, 320, 100));

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

    public void initChooserAudio() {

        view.chooserAudio().setCurrentDirectory(new java.io.File("."));
        view.chooserAudio().setDialogTitle("Selecione um áudio");
        view.chooserAudio().setFileSelectionMode(JFileChooser.FILES_ONLY);
        view.chooserAudio().setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("WAV", "wav", "wav");
        view.chooserAudio().setFileFilter(filter);
        if (view.chooserAudio().showOpenDialog(view.chooserAudio()) == JFileChooser.APPROVE_OPTION) {
            view.jLAudio().setText(view.chooserAudio().getSelectedFile().toString());

        }
    }
    public void excluirAudio(InterpretacaoView view){
        view.jLAudio().setText("");
        view.jBExcluir().setEnabled(false);
    }

    public String novoAudio(InterpretacaoView view, String caminho) {
        File audio = new File(caminho);
        Parametros p = new ParametrosDAO().get();
        int i = 1;
        String salvar;
        salvar = p.getPastaAudios() + "\\" + view.jLIDAtendimento().getText() + "-0.wav";
        while (new File(salvar).exists()) {
            salvar = p.getPastaAudios() + "\\" + view.jLIDAtendimento().getText() + "-" + i + ".wav";
            i++;
        }
        audio.renameTo(new File(salvar));
        return salvar;
    }
}
