/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package br.com.examefacil.tools;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.swing.JOptionPane;
import org.apache.commons.codec.binary.Base64;

/**
 *
 * @author bruno
 */
public class Util {
    
    public static void Aviso(String mens){
        JOptionPane.showMessageDialog(null, mens, "Warning", JOptionPane.INFORMATION_MESSAGE);
    }
    public static void Error(String mens){
        JOptionPane.showMessageDialog(null, mens, "Error", JOptionPane.WARNING_MESSAGE);
    }
    public static boolean Confirma(String mens){
        Object[] options = {"Sim", "Cancelar"};
        return JOptionPane.showOptionDialog(null,
                mens,
                "Confirma",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,     
                options,  
                options[0]) == JOptionPane.YES_OPTION;
    }
    
    public static String encriptaSenha(String senha) {
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            digest.update(senha.getBytes());
            Base64 encoder = new Base64();
            return encoder.encodeAsString(digest.digest());
        } catch (NoSuchAlgorithmException ns) {
            ns.printStackTrace();
            return senha;
        }
    }
    
}
