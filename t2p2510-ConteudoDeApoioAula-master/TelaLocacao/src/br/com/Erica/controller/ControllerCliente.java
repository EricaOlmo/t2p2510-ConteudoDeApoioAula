package br.com.Erica.controller;

import br.com.Erica.DAO.DaoCliente;
import br.com.Erica.interfaces.ControllerInterface;
import br.com.Erica.model.Cliente;
import br.com.Erica.view.TelaCliente;

/**
 *
 * @author Erica
 */
public class ControllerCliente {
    
    public class ControllerCliente implements ControllerInterface{

    private TelaCliente telaCliente;
    private DaoCliente daoCliente;

    public TelaCliente getTelaCliente() {
        return telaCliente;
    }

    public ControllerCliente() {
        daoCliente = new DaoCliente();
        telaCliente = new TelaCliente();
        ControllerCentral CM = new ControllerCentral(this, telaCliente, daoCliente);

    }

    @Override
    public String verificarCamposObrigatorios() {
        Cliente cliente = (Cliente) telaCliente.getModel();
        if (!cliente.getNome().trim().equals("")) {
            return null;
        }
        return "Campo nome vazio!";
    }

}

}
