/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.examefacil.swing;

import br.com.examefacil.controller.UsuarioControl;

/**
 *
 * @author bruno
 */
public class DialogAlteraSenhaUsuario extends javax.swing.JDialog {

    public int idusuario;
    
    public DialogAlteraSenhaUsuario(java.awt.Frame parent, boolean modal, int idusuario) {
        super(parent, modal);
        initComponents();
        this.idusuario = idusuario;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jpwdSenhaUsuario = new javax.swing.JPasswordField();
        btnCancelaAlteraSenha = new javax.swing.JButton();
        btnConfirmaAlterarSenha = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Senha:");

        jpwdSenhaUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jpwdSenhaUsuarioActionPerformed(evt);
            }
        });

        btnCancelaAlteraSenha.setText("Cancelar");
        btnCancelaAlteraSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelaAlteraSenhaActionPerformed(evt);
            }
        });

        btnConfirmaAlterarSenha.setText("Salvar");
        btnConfirmaAlterarSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmaAlterarSenhaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpwdSenhaUsuario)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 110, Short.MAX_VALUE)
                        .addComponent(btnCancelaAlteraSenha)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnConfirmaAlterarSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpwdSenhaUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConfirmaAlterarSenha)
                    .addComponent(btnCancelaAlteraSenha))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelaAlteraSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelaAlteraSenhaActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnCancelaAlteraSenhaActionPerformed

    private void btnConfirmaAlterarSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmaAlterarSenhaActionPerformed
        if(new UsuarioControl().alterarSenha(idusuario, jpwdSenhaUsuario.getText())){
            this.setVisible(false);
        }
    }//GEN-LAST:event_btnConfirmaAlterarSenhaActionPerformed

    private void jpwdSenhaUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jpwdSenhaUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jpwdSenhaUsuarioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelaAlteraSenha;
    private javax.swing.JButton btnConfirmaAlterarSenha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPasswordField jpwdSenhaUsuario;
    // End of variables declaration//GEN-END:variables
}
