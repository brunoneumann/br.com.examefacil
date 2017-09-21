/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package br.com.examefacil.swing;

import br.com.examefacil.controller.PacienteControl;
import br.com.examefacil.view.PacienteView;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Henrique
 */
public class TelaPaciente extends javax.swing.JFrame implements PacienteView {
    
    /**
     * Creates new form TipoExames
     */
    public TelaPaciente() {
        initComponents();
        new PacienteControl().init(this);
        
        /* EXEMPLO DE LISTA
        List<Paciente> listAll = new PacienteControl().listar();
        for(Paciente p : listAll){
        System.out.println(p.getNome());
        }
        List<Paciente> list = new PacienteControl().listar("o");
        for(Paciente p : list){
        System.out.println(p.getNome());
        }*/
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPPaciente = new javax.swing.JPanel();
        jBCancelar = new javax.swing.JButton();
        jBPesquisar = new javax.swing.JButton();
        jBIncluir = new javax.swing.JButton();
        jBeditar = new javax.swing.JButton();
        jBGravar = new javax.swing.JButton();
        jBExcluir = new javax.swing.JButton();
        jTPesquisarPaciente = new javax.swing.JTextField();
        jBFechar = new javax.swing.JButton();
        jCInclusaoAutomatica = new javax.swing.JCheckBox();
        jTabPaciente = new javax.swing.JTabbedPane();
        jPVisualizar = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTABPacientes = new javax.swing.JTable();
        jEditar = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTNomePaciente = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTCPF = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTEmail = new javax.swing.JTextField();
        jLIDPaciente = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pacientes");

        jPPaciente.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jBCancelar.setText("Cancelar");
        jBCancelar.setEnabled(false);
        jBCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCancelarActionPerformed(evt);
            }
        });

        jBPesquisar.setText("Pesquisar");
        jBPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBPesquisarActionPerformed(evt);
            }
        });

        jBIncluir.setText("Incluir");
        jBIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBIncluirActionPerformed(evt);
            }
        });

        jBeditar.setText("Editar");
        jBeditar.setEnabled(false);
        jBeditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBeditarActionPerformed(evt);
            }
        });

        jBGravar.setText("Gravar");
        jBGravar.setEnabled(false);
        jBGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBGravarActionPerformed(evt);
            }
        });

        jBExcluir.setText("Excluir");
        jBExcluir.setEnabled(false);
        jBExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBExcluirActionPerformed(evt);
            }
        });

        jTPesquisarPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTPesquisarPacienteActionPerformed(evt);
            }
        });

        jBFechar.setText("Fechar");
        jBFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBFecharActionPerformed(evt);
            }
        });

        jCInclusaoAutomatica.setText("Inclusão Automática");
        jCInclusaoAutomatica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCInclusaoAutomaticaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPPacienteLayout = new javax.swing.GroupLayout(jPPaciente);
        jPPaciente.setLayout(jPPacienteLayout);
        jPPacienteLayout.setHorizontalGroup(
            jPPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPPacienteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPPacienteLayout.createSequentialGroup()
                        .addComponent(jBIncluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBeditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBGravar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBFechar)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPPacienteLayout.createSequentialGroup()
                        .addComponent(jTPesquisarPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBPesquisar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCInclusaoAutomatica))))
        );
        jPPacienteLayout.setVerticalGroup(
            jPPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPPacienteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBCancelar)
                    .addComponent(jBIncluir)
                    .addComponent(jBeditar)
                    .addComponent(jBGravar)
                    .addComponent(jBExcluir)
                    .addComponent(jBFechar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBPesquisar)
                    .addComponent(jTPesquisarPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPPacienteLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jCInclusaoAutomatica))
        );

        jTABPacientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTABPacientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTABPacientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTABPacientes);

        javax.swing.GroupLayout jPVisualizarLayout = new javax.swing.GroupLayout(jPVisualizar);
        jPVisualizar.setLayout(jPVisualizarLayout);
        jPVisualizarLayout.setHorizontalGroup(
            jPVisualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 598, Short.MAX_VALUE)
        );
        jPVisualizarLayout.setVerticalGroup(
            jPVisualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
        );

        jTabPaciente.addTab("Visualizar", jPVisualizar);

        jLabel1.setText("Nome do Paciente");

        jTNomePaciente.setName("Nome"); // NOI18N

        jLabel2.setText("CPF");

        jTCPF.setName("CPF"); // NOI18N

        jLabel3.setText("E-mail");

        jTEmail.setName("E-mail"); // NOI18N

        javax.swing.GroupLayout jEditarLayout = new javax.swing.GroupLayout(jEditar);
        jEditar.setLayout(jEditarLayout);
        jEditarLayout.setHorizontalGroup(
            jEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jEditarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTEmail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addComponent(jTNomePaciente, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                    .addComponent(jLabel2)
                    .addComponent(jTCPF)
                    .addComponent(jLabel3)
                    .addComponent(jLIDPaciente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(412, Short.MAX_VALUE))
        );
        jEditarLayout.setVerticalGroup(
            jEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jEditarLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLIDPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTNomePaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(93, Short.MAX_VALUE))
        );

        jTabPaciente.addTab("Editar", jEditar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPPaciente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTabPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBIncluirActionPerformed
        new PacienteControl().novoPaciente(this);
    }//GEN-LAST:event_jBIncluirActionPerformed

    private void jBFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBFecharActionPerformed
        // TODO add your handling code here:
        setVisible(false);
    }//GEN-LAST:event_jBFecharActionPerformed

    private void jBCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCancelarActionPerformed
        jCInclusaoAutomatica.setSelected(false);
        new PacienteControl().desabilitaBotoesEditar(this);
    }//GEN-LAST:event_jBCancelarActionPerformed

    private void jBeditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBeditarActionPerformed
        new PacienteControl().carregarDados(this);
    }//GEN-LAST:event_jBeditarActionPerformed

    private void jCInclusaoAutomaticaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCInclusaoAutomaticaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCInclusaoAutomaticaActionPerformed

    private void jTPesquisarPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTPesquisarPacienteActionPerformed

    }//GEN-LAST:event_jTPesquisarPacienteActionPerformed

    private void jBPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBPesquisarActionPerformed
        new PacienteControl().atualizaTabelaPacientes(this);
    }//GEN-LAST:event_jBPesquisarActionPerformed

    private void jBGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBGravarActionPerformed
        PacienteControl control = new PacienteControl();
        control.salvar(this);
    }//GEN-LAST:event_jBGravarActionPerformed

    private void jTABPacientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTABPacientesMouseClicked
        new PacienteControl().alteraEstadoEditarExcluir(this, true);
    }//GEN-LAST:event_jTABPacientesMouseClicked

    private void jBExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBExcluirActionPerformed
        new PacienteControl().excluir(this);
    }//GEN-LAST:event_jBExcluirActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
        * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
        */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPaciente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBCancelar;
    private javax.swing.JButton jBExcluir;
    private javax.swing.JButton jBFechar;
    private javax.swing.JButton jBGravar;
    private javax.swing.JButton jBIncluir;
    private javax.swing.JButton jBPesquisar;
    private javax.swing.JButton jBeditar;
    private javax.swing.JCheckBox jCInclusaoAutomatica;
    private javax.swing.JPanel jEditar;
    private javax.swing.JLabel jLIDPaciente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPPaciente;
    private javax.swing.JPanel jPVisualizar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTABPacientes;
    private javax.swing.JTextField jTCPF;
    private javax.swing.JTextField jTEmail;
    private javax.swing.JTextField jTNomePaciente;
    private javax.swing.JTextField jTPesquisarPaciente;
    private javax.swing.JTabbedPane jTabPaciente;
    // End of variables declaration//GEN-END:variables
    
    @Override
    public String getNome() {
        return jTNomePaciente().getText();
    }
    
    @Override
    public String getCPF() {
        return jTCPF().getText();
    }
    
    @Override
    public String getEmail() {
        return JTEmail().getText();
    }
    
    @Override
    public JTextField jTNomePaciente() {
        return jTNomePaciente;
    }
    
    @Override
    public JTextField jTCPF() {
        return jTCPF;
    }
    
    @Override
    public JTextField JTEmail() {
        return jTEmail;
    }
    
    @Override
    public JTable JTABPacientes() {
        return jTABPacientes;
    }
    
    @Override
    public JButton jBIncluir() {
        return jBIncluir;
    }
    
    @Override
    public JButton jBExcluir() {
        return jBExcluir;
    }
    
    @Override
    public JButton jBPesquisar() {
        return jBPesquisar;
    }
    
    @Override
    public JButton jBeditar() {
        return jBeditar;
    }
    
    @Override
    public JButton jBGravar() {
        return jBGravar;
    }
    
    @Override
    public JButton jBCancelar() {
        return jBCancelar;
    }
    
    @Override
    public JTabbedPane jTabPaciente() {
        return jTabPaciente;
    }
    
    @Override
    public JCheckBox jCInclusaoAutomatica() {
        return jCInclusaoAutomatica;
    }
    
    @Override
    public JTextField jTPesquisarPaciente() {
        return jTPesquisarPaciente;
    }

    @Override
    public JLabel jLIDPaciente() {
        return jLIDPaciente;
    }
}
