package br.com.Erica.view;

import br.com.Erica.controller.ControllerUsuario;
import br.com.Erica.model.Usuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import static org.omg.CORBA.ORB.init;

/**
 *
 * @author Erica
 */
public class TelaUsuario extends JFrame implements ActionListener {

    private Usuario user;

    private JTextField edLogin;
    private JPasswordField edSenha;
    private JButton btLogin, btSair;

    public TelaUsuario() {
        super("::Login");
        init();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals("login.sair")) {
            System.exit(1);
        }}

    public void addControllerActionListener(ControllerUsuario aThis) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void abrir() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Usuario getUsuario() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void terminate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    }