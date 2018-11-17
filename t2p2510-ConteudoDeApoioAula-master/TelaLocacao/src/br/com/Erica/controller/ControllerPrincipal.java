package br.com.Erica.controller;

import br.com.Erica.model.Usuario;
import br.com.Erica.view.TelaPrincipal;
import br.com.Erica.view.Telinha;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.JLabel;

/**
 *
 * @author Erica
 */
public class ControllerPrincipal implements ActionListener {

    private TelaPrincipal minhaView;
    private Usuario user;

    public ControllerPrincipal(Usuario user) {
        this.user = user;
        minhaView = new TelaPrincipal(this);
        minhaView.abrir();
        this.minhaView.addControllerActionListener(this);
        this.minhaView.getmPainel().add(new JLabel("Usuário: " + this.user.getLogin()));
        this.minhaView.getmPainel().add(new JLabel(new Date().toString()));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
        if (e.getActionCommand().equals("pessoa")) {
            minhaView.getmDesktop().add(new Telinha());
        } else if (e.getActionCommand().equals("marca")) {
            ControllerMarca controllerMarca = new ControllerMarca();
            //minhaView.getmDesktop().add(controllerMarca.getTelaMarca());
        } else if (e.getActionCommand().equals("cliente")) {
            ControllerCliente controllerCliente = new ControllerCliente();
        }
    }
}
