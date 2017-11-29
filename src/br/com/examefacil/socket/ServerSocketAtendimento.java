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
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.NetworkInterface;
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
    
    public static boolean isServerMachine(String host) {
        try {
            InetAddress addr = InetAddress.getByName(host);
            if (addr.isAnyLocalAddress() || addr.isLoopbackAddress())
                return true;
            return NetworkInterface.getByInetAddress(addr) != null;
        } catch (Exception e) {
            return false;
        }
    }
    
    public void start(TelaPrincipalView view){
        if(parametros!=null && parametros.getUrlServidor() != null){
            System.out.println(parametros.getUrlServidor());
            if(isServerMachine(parametros.getUrlServidor())){
                startServer(view);
            } else {
                startWatcher(view);
            }
            startSender(view);
        } else {
            Util.Error("Servidor não encontrado! Altere o servidor no menu Configurações.");
        }
    }
    
    public void atualizar(TelaPrincipalView view){
        try {
            
            Socket s = new Socket(parametros.getUrlServidor(), parametros.getPortaServidor());
            ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
            List<Atendimento> lista = new TelaPrincipalControl().listar(
                    view.jTPesquisarAtendimento().getText(),
                    Util.formataDataSQL(view.jDteInicial().getDate()),
                    Util.formataDataSQL(view.jDteFinal().getDate()));
            out.writeObject(lista);
            out.flush();
            if(!isServerMachine(parametros.getUrlServidor())){
                new TelaPrincipalControl().atualizaTabelaAtendimento(view, lista);
            }
            
            /* Atualiza os clientes com o watcher */
            new ParametrosDAO().atualizar(true);
            
        } catch(Exception ex){
            ex.printStackTrace();
            log.error(ex);
        }
    }
    
    public void startSender(TelaPrincipalView view) {
        (new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    Socket s = new Socket(parametros.getUrlServidor(), parametros.getPortaServidor());
                    ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
                    List<Atendimento> lista = new TelaPrincipalControl().listar(
                            view.jTPesquisarAtendimento().getText(),
                            Util.formataDataSQL(view.jDteInicial().getDate()),
                            Util.formataDataSQL(view.jDteFinal().getDate()));
                    out.writeObject(lista);
                    out.flush();
                    if(!isServerMachine(parametros.getUrlServidor())){
                        new TelaPrincipalControl().atualizaTabelaAtendimento(view, lista);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
    public void startWatcher(TelaPrincipalView view) {
        (new Thread() {
            @Override
            public void run() {
                try {
                    while(true){
                        Parametros p = new ParametrosDAO().get();
                        if(p.isAtualizar()){
                            Socket s = new Socket(p.getUrlServidor(), p.getPortaServidor());
                            ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
                            List<Atendimento> lista = new TelaPrincipalControl().listar(
                                    view.jTPesquisarAtendimento().getText(),
                                    Util.formataDataSQL(view.jDteInicial().getDate()),
                                    Util.formataDataSQL(view.jDteFinal().getDate()));
                            out.writeObject(lista);
                            out.flush();
                            new TelaPrincipalControl().atualizaTabelaAtendimento(view, lista);
                            
                            new ParametrosDAO().atualizar(false);
                        }
                        Thread.sleep(800);
                    }
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
                    System.out.println("Startando o servidor");
                    while (true) {
                        Socket s = ss.accept();
                        ObjectInputStream in = new ObjectInputStream(s.getInputStream());
                        List<Atendimento> lista = (ArrayList<Atendimento>) in.readObject();
                        
                        new TelaPrincipalControl().atualizaTabelaAtendimento(view, lista);
                        Thread.sleep(2000);
                    }
                    
                } catch (Exception e) {
                    log.error(e);
                }
            }
        }).start();
    }
}
