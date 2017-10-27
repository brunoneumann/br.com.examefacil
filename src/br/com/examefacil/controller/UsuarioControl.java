/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package br.com.examefacil.controller;

import br.com.examefacil.bean.Acesso;
import br.com.examefacil.bean.Usuario;
import br.com.examefacil.dao.AcessoDAO;
import br.com.examefacil.dao.UsuarioDAO;
import br.com.examefacil.swing.TelaPrincipal;
import br.com.examefacil.tools.UsuarioUtils;
import br.com.examefacil.view.UsuarioView;

import com.towel.el.FieldResolver;
import com.towel.el.factory.FieldResolverFactory;
import com.towel.swing.table.ObjectTableModel;
import java.util.List;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import br.com.examefacil.tools.Util;
import java.util.ArrayList;

/**
 *
 * @author Henrique
 */
public class UsuarioControl {
    
    public UsuarioControl() {
    }
    
    public void init(UsuarioView view) {
        atualizaTabelaUsuarios(view);
        
        /* Desabilita aba editar */
        view.jTabUsuario().setEnabledAt(1, false);
        view.jTabUsuario().setEnabledAt(2, false);
        view.jLIDUsuario().setVisible(false);
        
        carregaPermissaoIncluir(view);
    }
    
    public void carregaPermissaoIncluir(UsuarioView view) {
        List<Acesso> permissoes = new AcessoControl().listaAcessosUsuario(TelaPrincipal.usuarioLogado.getIdusuario());
        for (Acesso a : permissoes) {
            if (a.getPagina().equals("usuario")) {
                view.jBIncluir().setEnabled(a.isIncluir());
                break;
            }
        }
    }
    
    public void carregaPermissaoAlterarExcluir(UsuarioView view) {
        List<Acesso> permissoes = new AcessoControl().listaAcessosUsuario(TelaPrincipal.usuarioLogado.getIdusuario());
        for (Acesso a : permissoes) {
            if (a.getPagina().equals("usuario")) {
                view.jBEditar().setEnabled(a.isAlterar());
                view.jBExcluir().setEnabled(a.isExcluir());
                break;
            }
        }
    }
    
    public void atualizaTabelaUsuarios(UsuarioView view) {
        view.JTABUsuarios().setModel(tableModelUsuarios(view));
        view.JTABUsuarios().setColumnModel(tableColumnUsuarios(view));
    }
    
    public boolean salvar(UsuarioView view) {
        
        if (view.jTabUsuario().getSelectedIndex() == 1) {
            ArrayList<String> campos = new ArrayList<>();
            ArrayList<String> nomes = new ArrayList<>();
            campos.add(view.jTNomeUsuario().getText());
            campos.add(view.jTEmail().getText());
            nomes.add (view.jTNomeUsuario().getName());
            nomes.add (view.jTEmail().getName());
            
            
            if (Util.validaCampos(campos, nomes) && Util.validarEmail(view.jTEmail().getText())) {
                Usuario usuario = new Usuario();
                if (view.jLIDUsuario().getText() != null) {
                    usuario.setIdusuario(Integer.parseInt(view.jLIDUsuario().getText()));
                }
                usuario.setNome(view.getNome());
                usuario.setEmail(view.getEmail());
                
                boolean result = new UsuarioDAO().save(usuario);
                if (result) {
                    limparTextos(view);
                    desabilitaBotoesEditar(view);
                    atualizaTabelaUsuarios(view);
                    new EmailControl().enviarEmail(usuario.getEmail(), usuario.getNome());
                }
                return result;
            } else {
                return false;
            }
        } /* Gravar permissões */ else {
            if (view.jLIDUsuario().getText() != null) {
                int idusuario = Integer.parseInt(view.jLIDUsuario().getText());
                List<Acesso> listAcessos = new ArrayList<>();
                listAcessos.add(new UsuarioUtils().carregaAcessoSelecionado(idusuario, "usuario", view.chksPermissaoUsuario()));
                listAcessos.add(new UsuarioUtils().carregaAcessoSelecionado(idusuario, "atendimento", view.chksPermissaoAtendimento()));
                listAcessos.add(new UsuarioUtils().carregaAcessoSelecionado(idusuario, "at-laudo", view.chksPermissaoAtLaudo()));
                listAcessos.add(new UsuarioUtils().carregaAcessoSelecionado(idusuario, "at-imagem", view.chksPermissaoAtImagem()));
                listAcessos.add(new UsuarioUtils().carregaAcessoSelecionado(idusuario, "at-edit-imagem", view.chksPermissaoAtEditImage()));
                listAcessos.add(new UsuarioUtils().carregaAcessoSelecionado(idusuario, "at-audio", view.chksPermissaoAtAudio()));
                listAcessos.add(new UsuarioUtils().carregaAcessoSelecionado(idusuario, "paciente", view.chksPermissaoPaciente()));
                listAcessos.add(new UsuarioUtils().carregaAcessoSelecionado(idusuario, "textopadrao", view.chksPermissaoTextoPadrao()));
                listAcessos.add(new UsuarioUtils().carregaAcessoSelecionado(idusuario, "areaexame", view.chksPermissaoAreaExame()));
                listAcessos.add(new UsuarioUtils().carregaAcessoSelecionado(idusuario, "tipoexame", view.chksPermissaoTipoExame()));
                
                boolean result = true;
                if (new AcessoDAO().excluirPermissoes(idusuario)) {
                    for (Acesso a : listAcessos) {
                        if (!new AcessoDAO().save(a)) {
                            result = false;
                        }
                    }
                }
                if (result) {
                    Usuario u = new Usuario();
                    u.setIdusuario(idusuario);
                    u.setTipo_acesso(view.getTipoAcesso());
                    new UsuarioDAO().alteraTipoAcesso(u);
                    
                    limparTextos(view);
                    desabilitaBotoesEditar(view);
                    atualizaTabelaUsuarios(view);
                }
                return result;
            }
        }
        
        return false;
    }
    
    public Usuario testaAcesso(String email, String senha) {
        return new UsuarioDAO().testAcesso(email, senha);
    }
    
    public boolean alterarSenha(int idusuario, String senha) {
        return new UsuarioDAO().alterarSenha(idusuario, Util.encriptaSenha(senha));
    }
    
    public boolean excluir(UsuarioView view) {
        if (Util.Confirma("Deseja realmente excluir este usuário?\n"
                + "Nome: " + view.JTABUsuarios().getModel().getValueAt(view.JTABUsuarios().getSelectedRow(), 1))) {
            
            boolean result = new UsuarioDAO().delete(usuarioSelecionado(view));
            if (result) {
                atualizaTabelaUsuarios(view);
            }
        }
        alteraEstadoEditarExcluir(view, false);
        return false;
    }
    
    public Usuario get(int id) {
        return new UsuarioDAO().get(id);
    }
    
    public List<Usuario> listar() throws Exception {
        return new UsuarioDAO().list();
    }
    
    public List<Usuario> listar(String parametro) {
        return new UsuarioDAO().list(parametro);
    }
    
    public Usuario usuarioSelecionado(UsuarioView view) {
        int selected = view.JTABUsuarios().getSelectedRow();
        return get((int) view.JTABUsuarios().getModel().getValueAt(selected, 0));
    }
    
    public void carregarDados(UsuarioView view) {
        Usuario u = usuarioSelecionado(view);
        if (u != null) {
            habilitaBotoesEditar(view);
            view.jLIDUsuario().setText(u.getIdusuario() + "");
            view.jTNomeUsuario().setText(u.getNome());
            view.jTEmail().setText(u.getEmail());
            view.btnAbrirDialogAlteraSenha().setVisible(true);
            view.btnAbrirPermissoes().setVisible(true);
        }
    }
    
    public TableModel tableModelUsuarios(UsuarioView view) {
        FieldResolverFactory frf = new FieldResolverFactory(Usuario.class);
        FieldResolver frID = frf.createResolver("idusuario", "ID");
        FieldResolver frNome = frf.createResolver("nome", "Nome");
        FieldResolver frEmail = frf.createResolver("email", "E-mail");
        
        ObjectTableModel<Usuario> model
                = new ObjectTableModel<Usuario>(
                        new FieldResolver[]{frID, frNome, frEmail});
        
        model.setEditableDefault(false);
        model.setData(this.listar(view.jTPesquisar().getText()));
        return model;
    }
    
    public TableColumnModel tableColumnUsuarios(UsuarioView view) {
        TableColumnModel coluna = view.JTABUsuarios().getColumnModel();
        coluna.getColumn(0).setPreferredWidth(5);
        coluna.getColumn(1).setPreferredWidth(150);
        coluna.getColumn(2).setPreferredWidth(50);
        return coluna;
    }
    
    public void novoUsuario(UsuarioView view) {
        habilitaBotoesEditar(view);
        view.jLIDUsuario().setText(null);
        view.btnAbrirDialogAlteraSenha().setVisible(false);
        view.btnAbrirPermissoes().setVisible(false);
    }
    
    public void alteraEstadoEditarExcluir(UsuarioView view, boolean action) {
        view.jBExcluir().setEnabled(action);
        view.jBEditar().setEnabled(action);
        
        carregaPermissaoAlterarExcluir(view);
    }
    
    public void limparTextos(UsuarioView view) {
        view.jTNomeUsuario().setText("");
        view.jTEmail().setText("");
    }
    
    public void habilitaBotoesEditar(UsuarioView view) {
        view.jBIncluir().setEnabled(false);
        view.jBExcluir().setEnabled(false);
        view.jBPesquisar().setEnabled(false);
        view.jBEditar().setEnabled(false);
        view.jBGravar().setEnabled(true);
        view.jBCancelar().setEnabled(true);
        view.jTPesquisar().setEnabled(false);
        view.jTabUsuario().setSelectedIndex(1);
        view.jCInclusaoAutomatica().setSelected(false);
        view.jTabUsuario().setEnabledAt(0, false);
        view.jTabUsuario().setEnabledAt(1, true);
        view.jTabUsuario().setEnabledAt(2, false);
    }
    
    public void desabilitaBotoesEditar(UsuarioView view) {
        if (!view.jCInclusaoAutomatica().isSelected()) {
            view.jBIncluir().setEnabled(true);
            view.jBExcluir().setEnabled(false);
            view.jBPesquisar().setEnabled(true);
            view.jBEditar().setEnabled(false);
            view.jTPesquisar().setEnabled(true);
            view.jBGravar().setEnabled(false);
            view.jBCancelar().setEnabled(false);
            view.jTabUsuario().setSelectedIndex(0);
            view.jTabUsuario().setEnabledAt(0, true);
            view.jTabUsuario().setEnabledAt(1, false);
            view.jTabUsuario().setEnabledAt(2, false);
        }
    }
    
    public void inserirPermissoes(UsuarioView view) {
        view.jBIncluir().setEnabled(false);
        view.jBExcluir().setEnabled(false);
        view.jBPesquisar().setEnabled(false);
        view.jBEditar().setEnabled(false);
        view.jTPesquisar().setEnabled(false);
        view.jBGravar().setEnabled(true);
        view.jBCancelar().setEnabled(true);
        view.jTabUsuario().setSelectedIndex(2);
        view.jTabUsuario().setEnabledAt(0, false);
        view.jTabUsuario().setEnabledAt(1, false);
        view.jTabUsuario().setEnabledAt(2, true);
        
        carregaPermissoesGravadas(view);
    }
    
    /**
     * Recepcionista = 1 Atend. exame = 2 Médico requis. = 3 Médico interpr. = 4
     * Administrador = 5
     *
     * @param view
     */
    public void carregaRegraPermissao(UsuarioView view) {
        List<Acesso> listaAcessos = new UsuarioUtils().listaPadroesAcesso(view.jCTipoAcesso().getSelectedIndex());
        for (Acesso a : listaAcessos) {
            switch (a.getPagina()) {
                case "usuario":
                    view.chksPermissaoUsuario().get(0).setSelected(a.isVisualizar());
                    view.chksPermissaoUsuario().get(1).setSelected(a.isIncluir());
                    view.chksPermissaoUsuario().get(2).setSelected(a.isAlterar());
                    view.chksPermissaoUsuario().get(3).setSelected(a.isExcluir());
                case "atendimento":
                    view.chksPermissaoAtendimento().get(0).setSelected(a.isVisualizar());
                    view.chksPermissaoAtendimento().get(1).setSelected(a.isIncluir());
                    view.chksPermissaoAtendimento().get(2).setSelected(a.isAlterar());
                    view.chksPermissaoAtendimento().get(3).setSelected(a.isExcluir());
                case "at-laudo":
                    view.chksPermissaoAtLaudo().get(0).setSelected(a.isVisualizar());
                    view.chksPermissaoAtLaudo().get(1).setSelected(a.isIncluir());
                    view.chksPermissaoAtLaudo().get(2).setSelected(a.isAlterar());
                    view.chksPermissaoAtLaudo().get(3).setSelected(a.isExcluir());
                case "at-imagem":
                    view.chksPermissaoAtImagem().get(0).setSelected(a.isVisualizar());
                    view.chksPermissaoAtImagem().get(1).setSelected(a.isIncluir());
                    view.chksPermissaoAtImagem().get(2).setSelected(a.isAlterar());
                    view.chksPermissaoAtImagem().get(3).setSelected(a.isExcluir());
                case "at-edit-imagem":
                    view.chksPermissaoAtEditImage().get(0).setSelected(a.isVisualizar());
                    view.chksPermissaoAtEditImage().get(1).setSelected(a.isIncluir());
                    view.chksPermissaoAtEditImage().get(2).setSelected(a.isAlterar());
                    view.chksPermissaoAtEditImage().get(3).setSelected(a.isExcluir());
                case "at-audio":
                    view.chksPermissaoAtAudio().get(0).setSelected(a.isVisualizar());
                    view.chksPermissaoAtAudio().get(1).setSelected(a.isIncluir());
                    view.chksPermissaoAtAudio().get(2).setSelected(a.isAlterar());
                    view.chksPermissaoAtAudio().get(3).setSelected(a.isExcluir());
                case "paciente":
                    view.chksPermissaoPaciente().get(0).setSelected(a.isVisualizar());
                    view.chksPermissaoPaciente().get(1).setSelected(a.isIncluir());
                    view.chksPermissaoPaciente().get(2).setSelected(a.isAlterar());
                    view.chksPermissaoPaciente().get(3).setSelected(a.isExcluir());
                case "textopadrao":
                    view.chksPermissaoTextoPadrao().get(0).setSelected(a.isVisualizar());
                    view.chksPermissaoTextoPadrao().get(1).setSelected(a.isIncluir());
                    view.chksPermissaoTextoPadrao().get(2).setSelected(a.isAlterar());
                    view.chksPermissaoTextoPadrao().get(3).setSelected(a.isExcluir());
                case "areaexame":
                    view.chksPermissaoAreaExame().get(0).setSelected(a.isVisualizar());
                    view.chksPermissaoAreaExame().get(1).setSelected(a.isIncluir());
                    view.chksPermissaoAreaExame().get(2).setSelected(a.isAlterar());
                    view.chksPermissaoAreaExame().get(3).setSelected(a.isExcluir());
                case "tipoexame":
                    view.chksPermissaoTipoExame().get(0).setSelected(a.isVisualizar());
                    view.chksPermissaoTipoExame().get(1).setSelected(a.isIncluir());
                    view.chksPermissaoTipoExame().get(2).setSelected(a.isAlterar());
                    view.chksPermissaoTipoExame().get(3).setSelected(a.isExcluir());
            }
        }
    }
    
    public void carregaPermissoesGravadas(UsuarioView view) {
        List<Acesso> listaAcessos = new AcessoDAO().listaAcessos(view.jLIDUsuario().getText());
        Usuario u = get(Integer.parseInt(view.jLIDUsuario().getText()));
        if (listaAcessos.size() == 0) {
            listaAcessos = new UsuarioUtils().listaPadroesAcesso(0);
        } else {
            view.jCTipoAcesso().setSelectedIndex(Integer.parseInt(u.getTipo_acesso()));
        }
        for (Acesso a : listaAcessos) {
            switch (a.getPagina()) {
                case "usuario":
                    view.chksPermissaoUsuario().get(0).setSelected(a.isVisualizar());
                    view.chksPermissaoUsuario().get(1).setSelected(a.isIncluir());
                    view.chksPermissaoUsuario().get(2).setSelected(a.isAlterar());
                    view.chksPermissaoUsuario().get(3).setSelected(a.isExcluir());
                case "atendimento":
                    view.chksPermissaoAtendimento().get(0).setSelected(a.isVisualizar());
                    view.chksPermissaoAtendimento().get(1).setSelected(a.isIncluir());
                    view.chksPermissaoAtendimento().get(2).setSelected(a.isAlterar());
                    view.chksPermissaoAtendimento().get(3).setSelected(a.isExcluir());
                case "at-laudo":
                    view.chksPermissaoAtLaudo().get(0).setSelected(a.isVisualizar());
                    view.chksPermissaoAtLaudo().get(1).setSelected(a.isIncluir());
                    view.chksPermissaoAtLaudo().get(2).setSelected(a.isAlterar());
                    view.chksPermissaoAtLaudo().get(3).setSelected(a.isExcluir());
                case "at-imagem":
                    view.chksPermissaoAtImagem().get(0).setSelected(a.isVisualizar());
                    view.chksPermissaoAtImagem().get(1).setSelected(a.isIncluir());
                    view.chksPermissaoAtImagem().get(2).setSelected(a.isAlterar());
                    view.chksPermissaoAtImagem().get(3).setSelected(a.isExcluir());
                case "at-edit-imagem":
                    view.chksPermissaoAtEditImage().get(0).setSelected(a.isVisualizar());
                    view.chksPermissaoAtEditImage().get(1).setSelected(a.isIncluir());
                    view.chksPermissaoAtEditImage().get(2).setSelected(a.isAlterar());
                    view.chksPermissaoAtEditImage().get(3).setSelected(a.isExcluir());
                case "at-audio":
                    view.chksPermissaoAtAudio().get(0).setSelected(a.isVisualizar());
                    view.chksPermissaoAtAudio().get(1).setSelected(a.isIncluir());
                    view.chksPermissaoAtAudio().get(2).setSelected(a.isAlterar());
                    view.chksPermissaoAtAudio().get(3).setSelected(a.isExcluir());
                case "paciente":
                    view.chksPermissaoPaciente().get(0).setSelected(a.isVisualizar());
                    view.chksPermissaoPaciente().get(1).setSelected(a.isIncluir());
                    view.chksPermissaoPaciente().get(2).setSelected(a.isAlterar());
                    view.chksPermissaoPaciente().get(3).setSelected(a.isExcluir());
                case "textopadrao":
                    view.chksPermissaoTextoPadrao().get(0).setSelected(a.isVisualizar());
                    view.chksPermissaoTextoPadrao().get(1).setSelected(a.isIncluir());
                    view.chksPermissaoTextoPadrao().get(2).setSelected(a.isAlterar());
                    view.chksPermissaoTextoPadrao().get(3).setSelected(a.isExcluir());
                case "areaexame":
                    view.chksPermissaoAreaExame().get(0).setSelected(a.isVisualizar());
                    view.chksPermissaoAreaExame().get(1).setSelected(a.isIncluir());
                    view.chksPermissaoAreaExame().get(2).setSelected(a.isAlterar());
                    view.chksPermissaoAreaExame().get(3).setSelected(a.isExcluir());
                case "tipoexame":
                    view.chksPermissaoTipoExame().get(0).setSelected(a.isVisualizar());
                    view.chksPermissaoTipoExame().get(1).setSelected(a.isIncluir());
                    view.chksPermissaoTipoExame().get(2).setSelected(a.isAlterar());
                    view.chksPermissaoTipoExame().get(3).setSelected(a.isExcluir());
            }
        }
    }
    
    
    
}
