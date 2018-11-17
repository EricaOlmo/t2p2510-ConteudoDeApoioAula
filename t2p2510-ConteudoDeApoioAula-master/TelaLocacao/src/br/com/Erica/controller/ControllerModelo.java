package br.com.Erica.controller;

import br.com.Erica.DAO.DaoModelo;
import br.com.Erica.interfaces.ControllerInterface;
import br.com.Erica.model.Modelo;
import br.com.Erica.view.TelaModelo;

/**
 *
 * @author Erica
 */
public class ControllerModelo implements ControllerInterface {

    private TelaModelo telaModelo;
    private DaoModelo daoModelo;

    public TelaModelo getTelaModelo() {
        return telaModelo;
    }

    public ControllerModelo() {
        daoModelo = new DaoModelo();
        telaModelo = new TelaModelo();
        ControllerCentral CM = new ControllerCentral(this, telaModelo, daoModelo);

    }

    @Override
    public String verificarCamposObrigatorios() {
        Modelo modelo = (Modelo) telaModelo.getModel();
        String msg = null;
        if (modelo.getTitulo().trim().equals("")) {
            msg = "Campo título vazio!";
        } else if (modelo.getMarca() == null) {
            msg = "Campo marca vazio!";
        }
        return msg;
    }

}