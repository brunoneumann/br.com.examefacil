/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package br.com.examefacil.swing;

import br.com.examefacil.bean.Atendimento;
import br.com.examefacil.bean.Usuario;
import br.com.examefacil.controller.AtenderControl;
import br.com.examefacil.controller.LaudoControl;
import br.com.examefacil.controller.TelaPrincipalControl;
import br.com.examefacil.tools.Util;
import br.com.examefacil.view.ImagemView;
import br.com.examefacil.view.TelaPrincipalView;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
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
public class TelaPrincipal extends javax.swing.JFrame implements TelaPrincipalView {
    
    /**
     * Creates new form TelaPrincipal
     */
    public ImagemView imagemView;
    public static Usuario usuarioLogado;
    
    public TelaPrincipal(Usuario u) {
        initComponents();
        this.usuarioLogado = u;
        new TelaPrincipalControl().init(this);
        setLocationRelativeTo( null );
    }
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jIExame = new javax.swing.JInternalFrame();
        jPAreaExame = new javax.swing.JPanel();
        jBPesquisar = new javax.swing.JButton();
        jBIncluir = new javax.swing.JButton();
        jBEditar = new javax.swing.JButton();
        jBExcluir = new javax.swing.JButton();
        jTPesquisarAtendimento = new javax.swing.JTextField();
        jBImagens = new javax.swing.JButton();
        jBInterpretar = new javax.swing.JButton();
        jBLaudo = new javax.swing.JButton();
        jBAtender = new javax.swing.JButton();
        jDteInicial = new com.toedter.calendar.JDateChooser();
        jDteFinal = new com.toedter.calendar.JDateChooser();
        jBtnDashboard = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAtendimentos = new javax.swing.JTable();
        jlblTotalAtendimentos = new javax.swing.JLabel();
        jlblMaiorInterpretador = new javax.swing.JLabel();
        jlblMaiorRecepcionista = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMCadastro = new javax.swing.JMenu();
        jMPaciente = new javax.swing.JMenuItem();
        jMTipoExame = new javax.swing.JMenuItem();
        jMAreaExame = new javax.swing.JMenuItem();
        jMUsuario = new javax.swing.JMenuItem();
        jMTextoPadrao = new javax.swing.JMenuItem();
        jMParametros = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMSair = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Exame Fácil");
        setMinimumSize(new java.awt.Dimension(800, 500));

        jIExame.setName("Tela Principal"); // NOI18N
        jIExame.setVisible(true);

        jPAreaExame.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jBPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/pesquisar.png"))); // NOI18N
        jBPesquisar.setText("Pesquisar");
        jBPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBPesquisarActionPerformed(evt);
            }
        });

        jBIncluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/incluir.png"))); // NOI18N
        jBIncluir.setText("Incluir");
        jBIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBIncluirActionPerformed(evt);
            }
        });

        jBEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/editar.png"))); // NOI18N
        jBEditar.setText("Editar");
        jBEditar.setEnabled(false);
        jBEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEditarActionPerformed(evt);
            }
        });

        jBExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/excluir.png"))); // NOI18N
        jBExcluir.setText("Excluir");
        jBExcluir.setEnabled(false);
        jBExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBExcluirActionPerformed(evt);
            }
        });

        jBImagens.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/imagens.png"))); // NOI18N
        jBImagens.setText("Imagens");
        jBImagens.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBImagensActionPerformed(evt);
            }
        });

        jBInterpretar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/interpretar.png"))); // NOI18N
        jBInterpretar.setText("Interpretar");
        jBInterpretar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBInterpretarActionPerformed(evt);
            }
        });

        jBLaudo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/laudo.png"))); // NOI18N
        jBLaudo.setText("Laudo");
        jBLaudo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBLaudoActionPerformed(evt);
            }
        });

        jBAtender.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/atender.png"))); // NOI18N
        jBAtender.setText("Atender");
        jBAtender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAtenderActionPerformed(evt);
            }
        });

        jBtnDashboard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/dashboard.png"))); // NOI18N
        jBtnDashboard.setText("Dashboard");
        jBtnDashboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnDashboardActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPAreaExameLayout = new javax.swing.GroupLayout(jPAreaExame);
        jPAreaExame.setLayout(jPAreaExameLayout);
        jPAreaExameLayout.setHorizontalGroup(
            jPAreaExameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPAreaExameLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPAreaExameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPAreaExameLayout.createSequentialGroup()
                        .addComponent(jBIncluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBAtender)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBImagens)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBInterpretar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBLaudo))
                    .addGroup(jPAreaExameLayout.createSequentialGroup()
                        .addComponent(jTPesquisarAtendimento, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDteInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDteFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBPesquisar)
                        .addGap(0, 0, 0)
                        .addComponent(jBtnDashboard)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPAreaExameLayout.setVerticalGroup(
            jPAreaExameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPAreaExameLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPAreaExameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBIncluir)
                    .addComponent(jBEditar)
                    .addComponent(jBExcluir)
                    .addComponent(jBAtender)
                    .addComponent(jBImagens)
                    .addComponent(jBInterpretar)
                    .addComponent(jBLaudo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(jPAreaExameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTPesquisarAtendimento, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDteInicial, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDteFinal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBPesquisar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnDashboard, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        tblAtendimentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblAtendimentos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAtendimentosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblAtendimentos);

        jlblTotalAtendimentos.setForeground(new java.awt.Color(51, 51, 255));
        jlblTotalAtendimentos.setText("Total de atendimentos: 5. ");

        jlblMaiorInterpretador.setForeground(new java.awt.Color(51, 51, 255));
        jlblMaiorInterpretador.setText("Méd. interpretador com maior número de atendimentos: João do Pulo. ");

        jlblMaiorRecepcionista.setForeground(new java.awt.Color(51, 51, 255));
        jlblMaiorRecepcionista.setText("Recepcionista com maior número de atendimentos: Virgínia de Souza. ");

        javax.swing.GroupLayout jIExameLayout = new javax.swing.GroupLayout(jIExame.getContentPane());
        jIExame.getContentPane().setLayout(jIExameLayout);
        jIExameLayout.setHorizontalGroup(
            jIExameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPAreaExame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
            .addComponent(jlblTotalAtendimentos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jIExameLayout.createSequentialGroup()
                .addComponent(jlblMaiorInterpretador, javax.swing.GroupLayout.PREFERRED_SIZE, 1068, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jlblMaiorRecepcionista, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jIExameLayout.setVerticalGroup(
            jIExameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jIExameLayout.createSequentialGroup()
                .addComponent(jPAreaExame, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlblTotalAtendimentos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlblMaiorInterpretador)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlblMaiorRecepcionista))
        );

        jMCadastro.setText("Cadastros");

        jMPaciente.setText("Pacientes");
        jMPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMPacienteActionPerformed(evt);
            }
        });
        jMCadastro.add(jMPaciente);

        jMTipoExame.setText("Tipos de Exames");
        jMTipoExame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMTipoExameActionPerformed(evt);
            }
        });
        jMCadastro.add(jMTipoExame);

        jMAreaExame.setText("Areas Exames");
        jMAreaExame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMAreaExameActionPerformed(evt);
            }
        });
        jMCadastro.add(jMAreaExame);

        jMUsuario.setText("Usuários");
        jMUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMUsuarioActionPerformed(evt);
            }
        });
        jMCadastro.add(jMUsuario);

        jMTextoPadrao.setText("Textos Padrões");
        jMTextoPadrao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMTextoPadraoActionPerformed(evt);
            }
        });
        jMCadastro.add(jMTextoPadrao);

        jMParametros.setText("Configurações");
        jMParametros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMParametrosActionPerformed(evt);
            }
        });
        jMCadastro.add(jMParametros);
        jMCadastro.add(jSeparator1);

        jMSair.setText("Sair");
        jMSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMSairActionPerformed(evt);
            }
        });
        jMCadastro.add(jMSair);

        jMenuBar1.add(jMCadastro);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jIExame, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jIExame, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        try {
            jIExame.setMaximum(true);
        } catch (java.beans.PropertyVetoException e1) {
            e1.printStackTrace();
        }

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMTipoExameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMTipoExameActionPerformed
        new TelaTipoExame().setVisible(true);
    }//GEN-LAST:event_jMTipoExameActionPerformed

    private void jMAreaExameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMAreaExameActionPerformed
        new TelaAreaExame().setVisible(true);        
    }//GEN-LAST:event_jMAreaExameActionPerformed

    private void jMUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMUsuarioActionPerformed
        new TelaUsuario().setVisible(true);
    }//GEN-LAST:event_jMUsuarioActionPerformed

    private void jMPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMPacienteActionPerformed
        new TelaPaciente().setVisible(true);
    }//GEN-LAST:event_jMPacienteActionPerformed

    private void jMTextoPadraoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMTextoPadraoActionPerformed
        new TelaTextoPadrao().setVisible(true);
    }//GEN-LAST:event_jMTextoPadraoActionPerformed

    private void jMSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMSairActionPerformed
        this.usuarioLogado = null;
        System.exit(0);
    }//GEN-LAST:event_jMSairActionPerformed


    private void jMParametrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMParametrosActionPerformed
        new TelaParametros().setVisible(true);
    }//GEN-LAST:event_jMParametrosActionPerformed

    private void tblAtendimentosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAtendimentosMouseClicked
        new TelaPrincipalControl().carregaPermissaoAlterarExcluirAtendimento(this);
    }//GEN-LAST:event_tblAtendimentosMouseClicked

    private void jBtnDashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnDashboardActionPerformed
        new Dashboard(Util.formataDataSQL(jDteInicial.getDate()), Util.formataDataSQL(jDteFinal.getDate())).setVisible(true);
    }//GEN-LAST:event_jBtnDashboardActionPerformed

    private void jBAtenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAtenderActionPerformed
        TelaAtender dialog = new TelaAtender(this, rootPaneCheckingEnabled, this);
        new AtenderControl(dialog, this).carregarDados(this);
        dialog.setVisible(true);
    }//GEN-LAST:event_jBAtenderActionPerformed

    private void jBLaudoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBLaudoActionPerformed
        TelaLaudo dialog = new TelaLaudo (this, rootPaneCheckingEnabled);
        new LaudoControl(dialog).carregarDados(this);
        dialog.setVisible(true);
    }//GEN-LAST:event_jBLaudoActionPerformed

    private void jBInterpretarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBInterpretarActionPerformed
        TelaInterpretacao dialog = new TelaInterpretacao (this, rootPaneCheckingEnabled, this);
        dialog.setVisible(true);
    }//GEN-LAST:event_jBInterpretarActionPerformed

    private void jBImagensActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBImagensActionPerformed
        //new ImagemControl(imagemView).carregarDados(this);
        new TelaImagens(this).setVisible(true);

    }//GEN-LAST:event_jBImagensActionPerformed

    private void jBExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBExcluirActionPerformed
        new TelaPrincipalControl().excluir(this);
    }//GEN-LAST:event_jBExcluirActionPerformed

    private void jBEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEditarActionPerformed
        Atendimento a = new TelaPrincipalControl().atendimentoSelecionado(this);
        if(a!=null){
            TelaAtendimento dialog = new TelaAtendimento(this, rootPaneCheckingEnabled, a, this);
            dialog.setVisible(true);
        }
    }//GEN-LAST:event_jBEditarActionPerformed

    private void jBIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBIncluirActionPerformed
        TelaAtendimento dialog = new TelaAtendimento(this, rootPaneCheckingEnabled, null, this);
        dialog.setVisible(true);
    }//GEN-LAST:event_jBIncluirActionPerformed

    private void jBPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBPesquisarActionPerformed
        new TelaPrincipalControl().pesquisar(this);
    }//GEN-LAST:event_jBPesquisarActionPerformed
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAtender;
    private javax.swing.JButton jBEditar;
    private javax.swing.JButton jBExcluir;
    private javax.swing.JButton jBImagens;
    private javax.swing.JButton jBIncluir;
    private javax.swing.JButton jBInterpretar;
    private javax.swing.JButton jBLaudo;
    private javax.swing.JButton jBPesquisar;
    private javax.swing.JButton jBtnDashboard;
    private com.toedter.calendar.JDateChooser jDteFinal;
    private com.toedter.calendar.JDateChooser jDteInicial;
    private javax.swing.JInternalFrame jIExame;
    private javax.swing.JMenuItem jMAreaExame;
    private javax.swing.JMenu jMCadastro;
    private javax.swing.JMenuItem jMPaciente;
    private javax.swing.JMenuItem jMParametros;
    private javax.swing.JMenuItem jMSair;
    private javax.swing.JMenuItem jMTextoPadrao;
    private javax.swing.JMenuItem jMTipoExame;
    private javax.swing.JMenuItem jMUsuario;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPAreaExame;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JTextField jTPesquisarAtendimento;
    private javax.swing.JLabel jlblMaiorInterpretador;
    private javax.swing.JLabel jlblMaiorRecepcionista;
    private javax.swing.JLabel jlblTotalAtendimentos;
    private javax.swing.JTable tblAtendimentos;
    // End of variables declaration//GEN-END:variables
    
    @Override
    public String getUsuario() {
        return jTUsuario().getText();
    }
    
    @Override
    public String getSenha() {
        return jPSenha().getText();
    }
    
    @Override
    public JInternalFrame jILogin() {
        return null;
    }
    
    @Override
    public JTextField jTUsuario() {
        return null;
    }
    
    @Override
    public JPasswordField jPSenha() {
        return null;
    }
    
    
    @Override
    public JMenuBar jMenuBar1() {
        return jMenuBar1;
    }
    
    @Override
    public JMenu jMCadastro() {
        return jMCadastro;
    }
    
    @Override
    public JMenuItem jMPaciente() {
        return jMPaciente;
    }
    
    @Override
    public JMenuItem jMTipoExame() {
        return jMTipoExame;
    }
    
    @Override
    public JMenuItem jMAreaExame() {
        return jMAreaExame;
    }
    
    @Override
    public JMenuItem jMUsuario() {
        return jMUsuario;
    }
    
    @Override
    public JMenuItem jMTextoPadrao() {
        return jMTextoPadrao;
    }
    
    @Override
    public JInternalFrame jIExame() {
        return jIExame;
    }

    @Override
    public JFrame telaPrincipal() {
        return telaPrincipal();
    }

   public JButton jBIncluir() {
        return jBIncluir;
    }

    @Override
    public JButton jBEditar() {
        return jBEditar;
    }

    @Override
    public JButton jBExcluir() {
        return jBExcluir;
    }

    @Override
    public JButton jBLaudo() {
        return jBLaudo;
    }

    @Override
    public JButton jBInterpretar() {
        return jBInterpretar;
    }

    @Override
    public JButton jBImagens() {
        return jBImagens;
    }

    @Override
    public JButton jBPesquisar() {
        return jBPesquisar;
    }
        
    @Override
    public JMenuItem jMParametros() {
        return jMParametros;
    }

    @Override
    public JButton jBAtender() {
        return jBAtender;
    }

    @Override
    public JTable tblAtendimentos() {
        return tblAtendimentos;
    }

    @Override
    public JTextField jTPesquisarAtendimento() {
        return jTPesquisarAtendimento;
    }

    @Override
    public JDateChooser jDteInicial() {
        return jDteInicial;
    }

    @Override
    public JDateChooser jDteFinal() {
        return jDteFinal;
    }

    @Override
    public JButton jBtnDashboard() {
        return jBtnDashboard;
    }

    @Override
    public JLabel jlblTotalAtendimentos() {
        return jlblTotalAtendimentos;
    }

    @Override
    public JLabel jlblMaiorInterpretador() {
        return jlblMaiorInterpretador;
    }

    @Override
    public JLabel jlblMaiorRecepcionista() {
        return jlblMaiorRecepcionista;
    }
  
    
}