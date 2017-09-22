/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.examefacil;


import br.com.examefacil.swing.TelaPrincipal;
import br.com.examefacil.tools.Util;
import com.sun.java.swing.plaf.gtk.GTKLookAndFeel;
import com.sun.java.swing.plaf.motif.MotifLookAndFeel;
import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;


/**
 *
 * @author bruno
 */
public class Examefacil {

    public static void main(String[] args) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {

                try {

                    UIManager.setLookAndFeel(new NimbusLookAndFeel());

                } catch (Exception ex) {
                    Util.Aviso("Look and Feel não suportado: "+ex.getMessage());
                }
                
                new TelaPrincipal().setVisible(true);
            }
        });
        
    }
    
}
