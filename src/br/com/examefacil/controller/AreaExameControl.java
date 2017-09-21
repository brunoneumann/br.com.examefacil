/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
package br.com.examefacil.controller;

import br.com.examefacil.bean.AreaExame;
import br.com.examefacil.dao.AreaExameDAO;
import br.com.examefacil.swing.TelaAreaExame;
import br.com.examefacil.view.AreaExameView;

import com.towel.el.FieldResolver;
import com.towel.el.factory.FieldResolverFactory;
import com.towel.swing.table.ObjectTableModel;
import java.util.List;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import br.com.examefacil.tools.Util;
import javax.swing.JOptionPane;

/**
 *
 * @author Henrique
 */
public class AreaExameControl {

    public AreaExameControl() {
    }

    public void init(AreaExameView view) {
        atualizaTabelaAreaExame(view);

        /* Desabilita aba editar */
        view.jTabAreaExame().setEnabledAt(1, false);
        view.jLIDAreaExame().setVisible(false);
    }

    public void atualizaTabelaAreaExame(AreaExameView view) {
        view.JTABAreaExame().setModel(tableModelAreaExame(view));
        view.JTABAreaExame().setColumnModel(tableColumnAreaExame(view));
    }

    public boolean salvar(AreaExameView view) {
        if (validaCampos(view)) {
            AreaExame area = new AreaExame();
            if (view.jLIDAreaExame().getText() != null) {
                area.setIdareaexame(Integer.parseInt(view.jLIDAreaExame().getText()));
            }
            area.setNome(view.getNome());

            boolean result = new AreaExameDAO().save(area);
            if (result) {
                limparTextos(view);
                desabilitaBotoesEditar(view);
                atualizaTabelaAreaExame(view);
            }
            return result;
        } else {
            return false;
        }
    }

    public boolean excluir(AreaExameView view) {
        if (Util.Confirma("Deseja excluir realmente esta area de exame?\n"
                + "Nome: " + view.JTABAreaExame().getModel().getValueAt(view.JTABAreaExame().getSelectedRow(), 1))) {

            boolean result = new AreaExameDAO().delete(areaExameSelecionado(view));
            if (result) {
                atualizaTabelaAreaExame(view);
            }
        }
        alteraEstadoEditarExcluir(view, false);
        return false;
    }

    public AreaExame get(int id) {
        return new AreaExameDAO().get(id);
    }

    public List<AreaExame> listar() throws Exception {
        return new AreaExameDAO().list();
    }

    public List<AreaExame> listar(String parametro) {
        return new AreaExameDAO().list(parametro);
    }

    public AreaExame areaExameSelecionado(AreaExameView view) {
        int selected = view.JTABAreaExame().getSelectedRow();
        return get((int) view.JTABAreaExame().getModel().getValueAt(selected, 0));
    }

    public void carregarDados(AreaExameView view) {
        AreaExame a = areaExameSelecionado(view);
        if (a != null) {
            habilitaBotoesEditar(view);
            view.jLIDAreaExame().setText(a.getIdareaexame() + "");
            view.jTAreaExame().setText(a.getNome());
        }
    }

    public TableModel tableModelAreaExame(AreaExameView view) {
        FieldResolverFactory frf = new FieldResolverFactory(AreaExame.class);
        FieldResolver frID = frf.createResolver("idareaexame", "ID");
        FieldResolver frNome = frf.createResolver("nome", "Nome");

        ObjectTableModel<AreaExame> model
                = new ObjectTableModel<AreaExame>(
                        new FieldResolver[]{frID, frNome});

        model.setEditableDefault(false);
        model.setData(this.listar(view.jTPesquisar().getText()));
        return model;
    }

    public TableColumnModel tableColumnAreaExame(AreaExameView view) {
        TableColumnModel coluna = view.JTABAreaExame().getColumnModel();
        coluna.getColumn(0).setPreferredWidth(5);
        coluna.getColumn(1).setPreferredWidth(300);
        return coluna;
    }

    public void novoAreaExame(AreaExameView view) {
        habilitaBotoesEditar(view);
        view.jLIDAreaExame().setText(null);
    }

    public void alteraEstadoEditarExcluir(AreaExameView view, boolean action) {
        view.jBExcluir().setEnabled(action);
        view.jBEditar().setEnabled(action);
    }

    public void limparTextos(AreaExameView view) {
        view.jTAreaExame().setText("");

    }

    public void habilitaBotoesEditar(AreaExameView view) {
        view.jBIncluir().setEnabled(false);
        view.jBExcluir().setEnabled(false);
        view.jBPesquisar().setEnabled(false);
        view.jBEditar().setEnabled(false);
        view.jBGravar().setEnabled(true);
        view.jBCancelar().setEnabled(true);
        view.jTPesquisar().setEnabled(false);
        view.jTabAreaExame().setSelectedIndex(1);
        view.jCInclusaoAutomatica().setSelected(false);
        view.jTabAreaExame().setEnabledAt(0, false);
        view.jTabAreaExame().setEnabledAt(1, true);
    }

    public void desabilitaBotoesEditar(AreaExameView view) {
        if (!view.jCInclusaoAutomatica().isSelected()) {
            view.jBIncluir().setEnabled(true);
            view.jBExcluir().setEnabled(false);
            view.jBPesquisar().setEnabled(true);
            view.jBEditar().setEnabled(false);
            view.jTPesquisar().setEnabled(true);
            view.jBGravar().setEnabled(false);
            view.jBCancelar().setEnabled(false);
            view.jTabAreaExame().setSelectedIndex(0);
            view.jTabAreaExame().setEnabledAt(0, true);
            view.jTabAreaExame().setEnabledAt(1, false);
        }
    }

    public boolean validaCampos(AreaExameView view) {

        if (view.jTAreaExame().getText().equals("")||view.jTAreaExame().getText().equals(" ")) {
            JOptionPane.showMessageDialog(null, "Digite um valor válido no campo: "+view.jTAreaExame().getName()+"", "Erro de validação", JOptionPane.ERROR_MESSAGE);
            return false;
        } else {
            return true;
        }
    }
}
