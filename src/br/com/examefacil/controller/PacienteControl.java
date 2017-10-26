/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package br.com.examefacil.controller;

import br.com.examefacil.bean.Acesso;
import br.com.examefacil.bean.Paciente;
import br.com.examefacil.dao.PacienteDAO;
import br.com.examefacil.renderer.PacientesCellRenderer;
import br.com.examefacil.renderer.UsuariosFBCellRenderer;
import br.com.examefacil.swing.TelaPrincipal;
import br.com.examefacil.tools.Constants;
import br.com.examefacil.tools.Util;
import br.com.examefacil.view.PacienteView;
import com.restfb.Connection;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.Version;
import com.restfb.types.User;
import com.towel.el.FieldResolver;
import com.towel.el.factory.FieldResolverFactory;
import com.towel.swing.table.ObjectTableModel;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author bruno
 */
public class PacienteControl {
    
    final Logger log = LogManager.getLogger(PacienteControl.class.getName());
    
    public PacienteControl() {
    }
    
    public void init(PacienteView view) {
        atualizaTabelaPacientes(view);
        
        /* Desabilita aba editar */
        view.jTabPaciente().setEnabledAt(1, false);
        view.jLIDPaciente().setVisible(false);
        
        carregaPermissaoIncluir(view);
    }
    
    public void carregaPermissaoIncluir(PacienteView view) {
        List<Acesso> permissoes = new AcessoControl().listaAcessosUsuario(TelaPrincipal.usuarioLogado.getIdusuario());
        for (Acesso a : permissoes) {
            if (a.getPagina().equals("paciente")) {
                view.jBIncluir().setEnabled(a.isIncluir());
                break;
            }
        }
    }
    
    public void carregaPermissaoAlterarExcluir(PacienteView view) {
        List<Acesso> permissoes = new AcessoControl().listaAcessosUsuario(TelaPrincipal.usuarioLogado.getIdusuario());
        for (Acesso a : permissoes) {
            if (a.getPagina().equals("paciente")) {
                view.jBeditar().setEnabled(a.isAlterar());
                view.jBExcluir().setEnabled(a.isExcluir());
                break;
            }
        }
    }
    
    public void atualizaTabelaPacientes(PacienteView view) {
        view.JTABPacientes().setModel(tableModelPacientes(view));
        view.JTABPacientes().setColumnModel(tableColumnPacientes(view));
        view.JTABPacientes().setDefaultRenderer(Object.class, new PacientesCellRenderer());
    }
    
    public boolean salvar(PacienteView view) {
        
        ArrayList<String> campos = new ArrayList<>();
        ArrayList<String> nomes = new ArrayList<>();
        campos.add(view.jTNomePaciente().getText());
        campos.add (view.jTCPF().getText());
        campos.add (view.JTEmail().getText());
        nomes.add(view.jTNomePaciente().getName());
        nomes.add (view.jTCPF().getName());
        nomes.add (view.JTEmail().getName());
        
        if (Util.validaCampos(campos, nomes) && Util.validaCPF(view.jTCPF().getText()) && Util.validarEmail(view.JTEmail().getText())) {
            Paciente paciente = new Paciente();
            if (view.jLIDPaciente().getText() != null) {
                paciente.setIdpaciente(Integer.parseInt(view.jLIDPaciente().getText()));
            }
            paciente.setNome(view.getNome());
            paciente.setCpf(Util.removeMascara(view.getCPF()));
            paciente.setEmail(view.getEmail());
            
            if(view.jPnlPerfilFB().isVisible()){
                String txt = view.jLblUriFB().getText();
                paciente.setIdfacebook(txt.replaceAll("https://fb.com/", ""));
            } else {
                paciente.setIdfacebook(null);
            }
            
            boolean result = new PacienteDAO().save(paciente);
            if (result) {
                limparTextos(view);
                desabilitaBotoesEditar(view);
                atualizaTabelaPacientes(view);
            }
            return result;
        } else {
            return false;
        }
    }
    
    public boolean excluir(PacienteView view) {
        if (Util.Confirma("Deseja realmente excluir este paciente?\n"
                + "Nome: " + view.JTABPacientes().getModel().getValueAt(view.JTABPacientes().getSelectedRow(), 1))) {
            
            boolean result = new PacienteDAO().delete(pacienteSelecionado(view));
            if (result) {
                atualizaTabelaPacientes(view);
            }
        }
        alteraEstadoEditarExcluir(view, false);
        return false;
    }
    
    public Paciente get(int id) {
        return new PacienteDAO().get(id);
    }
    
    public List<Paciente> listar() {
        return new PacienteDAO().list();
    }
    
    public List<Paciente> listar(String parametro) {
        return new PacienteDAO().list(parametro);
    }
    
    public Paciente pacienteSelecionado(PacienteView view) {
        int selected = view.JTABPacientes().getSelectedRow();
        return get((int) view.JTABPacientes().getModel().getValueAt(selected, 0));
    }
    
    public void carregarDados(PacienteView view) {
        Paciente p = pacienteSelecionado(view);
        if (p != null) {
            habilitaBotoesEditar(view);
            view.jLIDPaciente().setText(p.getIdpaciente() + "");
            view.jTNomePaciente().setText(p.getNome());
            view.jTCPF().setText(p.getCpf());
            view.JTEmail().setText(p.getEmail());
            if(p.getIdfacebook()!=null){
                view.jPnlPerfilFB().setVisible(true);
                FacebookClient fbClient = new DefaultFacebookClient(new Constants().accessToken, Version.LATEST);
                User u = fbClient.fetchObject(p.getIdfacebook(), User.class, Parameter.with("fields", "id,name,picture"));
                String url = u.getPicture().getUrl();
                ImageIcon foto = new Util().getImageURL(url);
                view.jLblFotoFB().setIcon(foto);
                view.jLblNomeUsuarioFB().setText(u.getName());
                view.jLblUriFB().setText("https://fb.com/"+p.getIdfacebook());
            } else {
                view.jPnlPerfilFB().setVisible(false);
            }
        }
    }
    
    public TableModel tableModelPacientes(PacienteView view) {
        FieldResolverFactory frf = new FieldResolverFactory(Paciente.class);
        FieldResolver frID = frf.createResolver("idpaciente", "ID");
        FieldResolver frNome = frf.createResolver("nome", "Nome");
        FieldResolver frCPF = frf.createResolver("cpf", "CPF");
        FieldResolver frEmail = frf.createResolver("email", "E-mail");
        FieldResolver frFB = frf.createResolver("idfacebook", "Perfil Facebook");
        
        ObjectTableModel<Paciente> model
                = new ObjectTableModel<Paciente>(
                        new FieldResolver[]{frID, frNome, frCPF, frEmail, frFB});
        
        model.setEditableDefault(false);
        model.setData(this.listar(view.jTPesquisarPaciente().getText()));
        return model;
    }
    
    public TableColumnModel tableColumnPacientes(PacienteView view) {
        TableColumnModel coluna = view.JTABPacientes().getColumnModel();
        coluna.getColumn(0).setPreferredWidth(5);
        coluna.getColumn(1).setPreferredWidth(150);
        coluna.getColumn(2).setPreferredWidth(50);
        coluna.getColumn(3).setPreferredWidth(50);
        coluna.getColumn(3).setPreferredWidth(100);
        return coluna;
    }
    
    public void novoPaciente(PacienteView view) {
        habilitaBotoesEditar(view);
        view.jLIDPaciente().setText(null);
        view.jPnlPerfilFB().setVisible(false);
    }
    
    public void alteraEstadoEditarExcluir(PacienteView view, boolean action) {
        view.jBExcluir().setEnabled(action);
        view.jBeditar().setEnabled(action);
        
        carregaPermissaoAlterarExcluir(view);
    }
    
    public void limparTextos(PacienteView view) {
        view.jTNomePaciente().setText("");
        view.jTCPF().setText("");
        view.JTEmail().setText("");
    }
    
    public void habilitaBotoesEditar(PacienteView view) {
        view.jBIncluir().setEnabled(false);
        view.jBExcluir().setEnabled(false);
        view.jBPesquisar().setEnabled(false);
        view.jBeditar().setEnabled(false);
        view.jBGravar().setEnabled(true);
        view.jBCancelar().setEnabled(true);
        view.jTPesquisarPaciente().setEnabled(false);
        view.jTabPaciente().setSelectedIndex(1);
        view.jCInclusaoAutomatica().setSelected(false);
        view.jTabPaciente().setEnabledAt(0, false);
        view.jTabPaciente().setEnabledAt(1, true);
    }
    
    public void desabilitaBotoesEditar(PacienteView view) {
        if (!view.jCInclusaoAutomatica().isSelected()) {
            view.jBIncluir().setEnabled(true);
            view.jBExcluir().setEnabled(false);
            view.jBPesquisar().setEnabled(true);
            view.jBeditar().setEnabled(false);
            view.jTPesquisarPaciente().setEnabled(true);
            view.jBGravar().setEnabled(false);
            view.jBCancelar().setEnabled(false);
            view.jTabPaciente().setSelectedIndex(0);
            view.jTabPaciente().setEnabledAt(0, true);
            view.jTabPaciente().setEnabledAt(1, false);
        }
    }
    
    public void buscaPacientesFB(String pesquisa, JTable table){
        if(pesquisa!=null && pesquisa.length()>0){
            
            try {
                
                FacebookClient fbClient = new DefaultFacebookClient(new Constants().accessToken, Version.LATEST);
                
                FieldResolverFactory frf = new FieldResolverFactory(User.class);
                FieldResolver frPic = frf.createResolver("picture", "");
                FieldResolver frNome = frf.createResolver("name", "Nome");
                FieldResolver frUrl = frf.createResolver("id", "URL");
                
                ObjectTableModel<User> model = new ObjectTableModel<User>(new FieldResolver[]{frPic,frNome,frUrl});
                
                model.setEditableDefault(false);
                
                Connection<User> results = fbClient.fetchConnection(
                        "search",
                        User.class,
                        Parameter.with("q", pesquisa),
                        Parameter.with("fields", "id,name,picture"),
                        Parameter.with("type", "user")
                );
                
                int cont = 0;
                boolean stop = false;
                
                List<User> users = new ArrayList<>();
                for(List<User> page : results){
                    for(User aUser : page){
                        users.add(aUser);
                        cont++;
                        
                        // Limita em 50 primeiros resultados
                        if(cont==50){
                            stop = true;
                            break;
                        }
                    }
                    if(stop){
                        break;
                    }
                }
                model.setData(users);
                table.setDefaultRenderer(Object.class, new UsuariosFBCellRenderer());
                table.setModel(model);
                
                TableColumnModel coluna = table.getColumnModel();
                coluna.getColumn(0).setPreferredWidth(20);
                coluna.getColumn(1).setPreferredWidth(150);
                coluna.getColumn(2).setPreferredWidth(180);
                
                table.setColumnModel(coluna);
                table.setRowHeight(50);
                
            } catch(Exception ex){
                log.error(ex);
            }
            
        }
    }
    
    public void selecionarPerfil(int row, JTable table, PacienteView view){
        view.jPnlPerfilFB().setVisible(true);
        
        String url = ((User.Picture)table.getModel().getValueAt(row, 0)).getUrl();
        ImageIcon foto = new Util().getImageURL(url);
        view.jLblFotoFB().setIcon(foto);
        
        String nome = table.getModel().getValueAt(row, 1).toString();
        String id = table.getModel().getValueAt(row, 2).toString();
        view.jLblNomeUsuarioFB().setText(nome);
        view.jLblUriFB().setText("https://fb.com/"+id);
        
        
    }
}
