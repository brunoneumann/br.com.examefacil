/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package br.com.examefacil.socket;

import br.com.examefacil.bean.Atendimento;
import br.com.examefacil.bean.Parametros;
import br.com.examefacil.controller.TelaPrincipalControl;
import br.com.examefacil.dao.ParametrosDAO;
import br.com.examefacil.tools.Util;
import br.com.examefacil.view.TelaPrincipalView;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;

/**
 *
 * @author bruno
 */
public class ServerSocketAtendimento {
    
    final org.apache.logging.log4j.Logger log = LogManager.getLogger(ServerSocketAtendimento.class.getName());
    private Parametros parametros;
    
    public ServerSocketAtendimento(){
        this.parametros = new ParametrosDAO().get();
    }
    
    public void start(TelaPrincipalView view){
        if(parametros!=null && parametros.getUrlServidor() != null){
            startServer(view);
            startSender();
        } else {
            Util.Error("Servidor não encontrado! Altere o servidor no menu Configurações.");
        }
    }
    
    public void atualizar(Atendimento a){
        try {
            Socket s = new Socket(parametros.getUrlServidor(), parametros.getPortaServidor());
            ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
            List<Atendimento> lista = new TelaPrincipalControl().listar();
            out.writeObject(lista);
            out.flush();
        } catch(Exception ex){
            log.error(ex);
        }
    }
    
    public void startSender() {
        (new Thread() {
            @Override
            public void run() {
                try {
                    Socket s = new Socket(parametros.getUrlServidor(), parametros.getPortaServidor());
                    ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
                    List<Atendimento> lista = new TelaPrincipalControl().listar();
                    out.writeObject(lista);
                    out.flush();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
    
    public void startServer(TelaPrincipalView view) {
        (new Thread() {
            @Override
            public void run() {
                try {
                    ServerSocket ss = new ServerSocket(parametros.getPortaServidor());
                    
                    while (true) {
                        
                        Socket s = ss.accept();
                        ObjectInputStream in = new ObjectInputStream(s.getInputStream());
                        List<Atendimento> lista = (ArrayList<Atendimento>) in.readObject();
                        
                        new TelaPrincipalControl().atualizaTabelaAtendimento(view, lista);
                        
                        Thread.sleep(2000);
                    }
                    
                } catch (IOException e) {
                    log.error(e);
                } catch (ClassNotFoundException ex) {
                    log.error(ex);
                } catch (InterruptedException ex) {
                    log.error(ex);
                }
            }
        }).start();
    }
}
