package br.com.Erica.interfaces;

import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 *
 * @author Erica
 */
public interface CRUDViewInterface {

    public void preencherTabelaPesquisar(ArrayList<Object> listaItensEncontrados);

    public void preencherCampos(Object model);

    public void limparCampos();

    /**
     *
     * @param CRUDCommand
     */
    public boolean doCRUD(String CRUDCommand);

   
    public Object getModel();

    public Object getSelectedModel();

    public void doMsg(String msg);

    public void setActionListener(ActionListener al);

    public void setPanelComponentState(Boolean state);

}
