/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.examefacil.renderer;

import br.com.examefacil.bean.AreaExame;
import br.com.examefacil.dao.AreaExameDAO;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author bruno
 */
public class AreaExameComboModel extends AbstractListModel<AreaExame> implements ComboBoxModel<AreaExame> {

    private List<AreaExame> lista;

    /* Seleciona um objeto na caixa de seleção */
    private AreaExame selecionado;

    public AreaExameComboModel() {
        /* Popula a lista */
        popular();

        /* Define o objeto selecionado */
        if(lista!=null && lista.size()>0){
            setSelectedItem(lista.get(0));
        }
    }

    /* Captura o tamanho da listagem */
    public int getSize() {
        int totalElementos = lista.size();
        return totalElementos;
    }

    /* Captura um elemento da lista em uma posição informada */
    public AreaExame getElementAt(int indice) {
        AreaExame a = lista.get(indice);
        return a;
    }

    /* Marca um objeto na lista como selecionado */
    public void setSelectedItem(Object item) {
        selecionado = (AreaExame) item;
    }

    /* Captura o objeto selecionado da lista */
    public Object getSelectedItem() {
        return selecionado;
    }

    private void popular() {
        try {
            AreaExameDAO dao = new AreaExameDAO();
            lista = dao.list();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}