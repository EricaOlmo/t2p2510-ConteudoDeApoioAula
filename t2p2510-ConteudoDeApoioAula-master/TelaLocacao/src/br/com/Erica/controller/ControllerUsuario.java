
package br.com.Erica.controller;

import br.com.Erica.DAO.DaoUsuario;
import br.com.Erica.model.Usuario;
import br.com.Erica.view.TelaUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Erica
 */
public class ControllerUsuario implements ActionListener{

    
    private TelaUsuario minhaView;

    public ControllerUsuario() {
        minhaView = new TelaUsuario();
        this.minhaView.addControllerActionListener(this);
    }

    public void abrir() {
        minhaView.abrir();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("login.logar")) {
            if (minhaView != null) {
                this.Autenticar();
            }
        }
    }
     private void Autenticar() {
        Usuario user = minhaView.getUsuario();
        DaoUsuario du = new DaoUsuario();
        String isAuth = du.Autenticar(user);
        
        if (isAuth == null) {
            JOptionPane.showMessageDialog(null, "Erro! Usuário ou senha incorretos.");
        } else if (isAuth.equals("0") || isAuth.equals("00")) {
            JOptionPane.showMessageDialog(null, "Usuário inativo!");
        } else {
            JOptionPane.showMessageDialog(null, "LOGADO COM SUCESSO!");
            minhaView.terminate();
            ControllerPrincipal cp = new ControllerPrincipal(user);
        }
    }
    
}
