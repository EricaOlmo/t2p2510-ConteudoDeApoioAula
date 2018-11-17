package br.com.Erica.controller;

import br.com.Erica.interfaces.CRUDViewInterface;
import br.com.Erica.interfaces.ControllerInterface;
import br.com.Erica.interfaces.DAOInterface;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Erica
 */
public class ControllerCentral implements ActionListener {

    ControllerInterface myController;
    CRUDViewInterface myCrudView;
    DAOInterface myDAO;

    public ControllerCentral(ControllerInterface myController, CRUDViewInterface myCrudView, DAOInterface myDAO) {
        this.myController = myController;
        this.myCrudView = myCrudView;
        this.myDAO = myDAO;
        this.myCrudView.setActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("An further attack: ~>" + e.getActionCommand() + "<~");

        if (e.getActionCommand().toLowerCase().equals("inserir")) {
            inserir();
        } else if (e.getActionCommand().toLowerCase().equals("editar")) {
            editar();
        } else if (e.getActionCommand().toLowerCase().equals("salvar")) {
            salvar();
        } else if (e.getActionCommand().toLowerCase().equals("excluir")) {
            excluir();
        } else if (e.getActionCommand().toLowerCase().equals("cancelar")) {
            cancelar();
        } else if (e.getActionCommand().toLowerCase().equals("pesquisar")) {
            pesquisar();
        } else if (e.getActionCommand().toLowerCase().equals("abrir")) {
            abrir();
        }
    }

    private void inserir() {
        this.myCrudView.doCRUD("inserir");
        this.myCrudView.limparCampos();
        this.myCrudView.setPanelComponentState(true);
    }

    private void salvar() {
        String msg = this.myController.verificarCamposObrigatorios();
        if (msg == null) {
            this.myCrudView.doCRUD("salvar");
            Object myObject = this.myCrudView.getModel();
            myDAO.salvar(myObject);
            this.myCrudView.preencherCampos(myDAO.getLast());
            this.myCrudView.setPanelComponentState(false);
        } else {
            this.myCrudView.doMsg(msg);
        }
    }

    private void editar() {
        this.myCrudView.doCRUD("editar");
        this.myCrudView.setPanelComponentState(true);
    }

    private void cancelar() {
        this.myCrudView.doCRUD("cancelar");
        this.myCrudView.limparCampos();
        this.myCrudView.setPanelComponentState(false);
    }

    private void excluir() {
        if (this.myCrudView.doCRUD("excluir")) {
            this.myDAO.remover(myCrudView.getModel());
            this.myCrudView.limparCampos();
            this.myCrudView.setPanelComponentState(false);
        } else {
            this.myCrudView.doMsg("Falha na exclusão!");
        }
    }

    private void pesquisar() {
        this.myCrudView.preencherTabelaPesquisar(myDAO.getAll());
    }

    private void abrir() {
        Object model = myCrudView.getSelectedModel();
        if (model != null) {
            this.myCrudView.limparCampos();
            this.myCrudView.preencherCampos(myDAO.getByID(model));
        }
    }

}
