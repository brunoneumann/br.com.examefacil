/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package br.com.examefacil;

import br.com.examefacil.swing.TelaLogin;
import br.com.examefacil.tools.Util;
import com.alee.laf.WebLookAndFeel;
import javax.swing.UIManager;


/**
 *
 * @author bruno
 */
public class Examefacil {
    
    
    public static void main(String[] args) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            
            public void run() {
                
                try {
                    
                    //UIManager.setLookAndFeel(new GTKLookAndFeel());
                    UIManager.setLookAndFeel ( WebLookAndFeel.class.getCanonicalName () );
                    
                    new TelaLogin().setVisible(true);
                    
                } catch (Exception ex) {
                    Util.Aviso("Look and Feel não suportado: "+ex.getMessage());
                }
            }
        });
        
    }
    
    
}  
