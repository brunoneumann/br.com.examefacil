/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package br.com.examefacil.view;

import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Henrique
 */
public interface TelaPrincipalView {
    public String getUsuario();
    public String getSenha();
    public JInternalFrame jILogin();
    public JInternalFrame jIExame();
    public JTextField jTUsuario();
    public JPasswordField jPSenha();
    public JMenuBar jMenuBar1();
    public JMenu jMCadastro();
    public JMenuItem jMPaciente();
    public JMenuItem jMTipoExame();
    public JMenuItem jMAreaExame();
    public JMenuItem jMUsuario();
    public JMenuItem jMTextoPadrao();
    public JMenuItem jMParametros();
    public JFrame telaPrincipal();
    
    public JButton jBIncluir();
    public JButton jBEditar();
    public JButton jBExcluir();
    public JButton jBLaudo();
    public JButton jBInterpretar();
    public JButton jBImagens();
    public JButton jBAtender();
    public JButton jBPesquisar();
    
    public JTextField jTPesquisarAtendimento();
    
    public JTable tblAtendimentos();
    
    public JDateChooser jDteInicial();
    public JDateChooser jDteFinal();
    
    public JButton jBtnDashboard();
}
