/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package br.com.examefacil.tools;

import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.function.Supplier;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import org.apache.commons.codec.binary.Base64;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author bruno
 */
public class Util {
    
    final Logger log = LogManager.getLogger(Util.class.getName());
    
    public static void Aviso(String mens) {
        JOptionPane.showMessageDialog(null, mens, "Aviso", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static void Error(String mens) {
        JOptionPane.showMessageDialog(null, mens, "Erro", JOptionPane.WARNING_MESSAGE);
    }
    
    public static boolean Confirma(String mens) {
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
    
    public static boolean validaCampos(ArrayList<String> campos, ArrayList<String> nomes) {
        //Monta o ArrayList com os Erros encontrados
        ArrayList<String> erro = new ArrayList<>();
        ArrayList<String> nomeCampo = new ArrayList<>();
        for (int i = 0; i < campos.size(); i++) {
            if (campos.get(i).equals("")) {
                erro.add(campos.get(i));
                nomeCampo.add("\n" + nomes.get(i));
            }
        }
        
        if (!erro.isEmpty()) {
            //Função para deixar o ArrayList pronto para impressão na tela
            StringBuilder sb = new StringBuilder();
            for (String s : nomeCampo) {
                sb.append(",").append(s);
            }
            String retorno = sb.toString().replaceFirst(",", "");
            
            //Função para que o JOptionPane seja Always on Top
            JOptionPane.showMessageDialog(
                    ((Supplier<JDialog>) () -> {
                        final JDialog dialog = new JDialog();
                        dialog.setAlwaysOnTop(true);
                        return dialog;
                    }).get(),
                    "Informe um valor válido para os seguintes campos:\n" + retorno + "");
            
            return false;
        } else {
            return true;
        }
    }
    
    public static boolean validarEmail(String email) {
        
        if (email != null && email.length() > 0) {
            String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
            Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(email);
            if (matcher.matches()) {
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "O e-mail informado não é válido",
                        "Erro de validação", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        return false;
    }
    
    public static boolean validaCPF(String strCpf) {
        try {
            strCpf = strCpf.replaceAll("\\.", "").replaceAll("\\-", "");
            
            int d1, d2;
            int digito1, digito2, resto;
            int digitoCPF;
            String nDigResult;
            d1 = d2 = 0;
            digito1 = digito2 = resto = 0;
            for (int nCount = 1; nCount < strCpf.length() - 1; nCount++) {
                digitoCPF = Integer.valueOf(strCpf.substring(nCount - 1, nCount)).intValue();
                d1 = d1 + (11 - nCount) * digitoCPF;
                d2 = d2 + (12 - nCount) * digitoCPF;
            }
            resto = (d1 % 11);
            if (resto < 2) {
                digito1 = 0;
            } else {
                digito1 = 11 - resto;
            }
            d2 += 2 * digito1;
            resto = (d2 % 11);
            if (resto < 2) {
                digito2 = 0;
            } else {
                digito2 = 11 - resto;
            }
            String nDigVerific = strCpf.substring(strCpf.length() - 2, strCpf.length());
            nDigResult = String.valueOf(digito1) + String.valueOf(digito2);
            if (nDigVerific.equals(nDigResult)) {
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "O CPF informado não é válido",
                        "Erro de validação", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } catch(Exception ex){
            JOptionPane.showMessageDialog(null, "O CPF informado não é válido",
                    "Erro de validação", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    //Método que recebe um JInternalFrame e define sua posição como centralizada
    public static void setPosicao(JInternalFrame pane) {
        Dimension d = pane.getDesktopPane().getSize();
        pane.setLocation((d.width - pane.getSize().width) / 2, (d.height - pane.getSize().height) / 2);
        
    }
    
    public static void dataMask(JTextField campo) {
        try {
            javax.swing.text.MaskFormatter data = new javax.swing.text.MaskFormatter("##/##/####");
            campo = new javax.swing.JFormattedTextField(data);
        } catch (Exception e) {
            
        }
    }
    public static void cpfMask(JTextField campo) {
        try {
            javax.swing.text.MaskFormatter cpf = new javax.swing.text.MaskFormatter("###.###.###-##");
            campo = new javax.swing.JFormattedTextField(cpf);
        } catch (Exception e) {
            
        }
    }
    public static void horaMask(JTextField campo) {
        try {
            javax.swing.text.MaskFormatter hora = new javax.swing.text.MaskFormatter("##:##");
            campo = new javax.swing.JFormattedTextField(hora);
        } catch (Exception e) {
            
        }
    }
    public static String removeMascara(String str){
        return str.replaceAll("\\D", "");
    }
    
    public ImageIcon getImageURL(String URLstr){
        URL url;
        ImageIcon icon = null;
        try {
            url = new URL(URLstr);
            
            BufferedImage img = ImageIO.read(url);
            icon = new ImageIcon(img);
            
        } catch (MalformedURLException ex) {
            log.error(ex);
        } catch (IOException ex) {
            log.error(ex);
        }
        
        return icon;
    }
    
    public void openWebpage(String URIstr) {
        try {
            URI uri = new URI(URIstr);
            Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
            if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
                desktop.browse(uri);
            }
        } catch(Exception ex){
            log.error(ex);
        }
    }
    
}
