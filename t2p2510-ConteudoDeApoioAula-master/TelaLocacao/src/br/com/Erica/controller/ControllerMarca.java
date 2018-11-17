package br.com.Erica.controller;

import br.com.Erica.DAO.DaoMarca;
import br.com.Erica.interfaces.ControllerInterface;
import br.com.Erica.view.TelaMarca;

/**
 *
 * @author Erica
 */
public class ControllerMarca implements ControllerInterface {

    private TelaMarca telaMarca;
    private DaoMarca daoMarca;

    public TelaMarca getTelaMarca() {
        return telaMarca;
    }

    public ControllerMarca() {
        daoMarca = new DaoMarca();
        telaMarca = new TelaMarca();
        ControllerCentral CM = new ControllerCentral(this, telaMarca, daoMarca);

    }

    public String verificarCamposObrigatorios() {
        Marca marca = (Marca) telaMarca.getModel();
        if (!marca.getTitulo().trim().equals("")) {
            return null;
        }
        return "Campo título vazio!";
    }

}
