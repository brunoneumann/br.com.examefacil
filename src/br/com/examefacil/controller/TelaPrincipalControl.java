/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.examefacil.controller;

import br.com.examefacil.bean.Acesso;
import br.com.examefacil.swing.TelaLogin;
import br.com.examefacil.swing.TelaPrincipal;
import br.com.examefacil.tools.Util;
import br.com.examefacil.view.TelaPrincipalView;
import java.util.List;
import javax.swing.JFormattedTextField;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Henrique
 */
public class TelaPrincipalControl {

    public void init(TelaPrincipalView view) {

        habilitaMenus(view);

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
        }
    }

    public void habilitaMenus(TelaPrincipalView view) {
        view.jMenuBar1().setEnabled(true);
        view.jMCadastro().setEnabled(true);
        //view.jILogin().setVisible(false);
        view.jIExame().setVisible(true);
        new TelaPrincipal().setVisible(true);
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

    public boolean validaCampos(TelaPrincipalView view) {
        return false;
    }

}
