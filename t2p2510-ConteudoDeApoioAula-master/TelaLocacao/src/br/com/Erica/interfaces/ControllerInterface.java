package br.com.Erica.interfaces;

/**
 *
 * @author lukas
 */
public interface ControllerInterface {
    /**
     * Método padrão que retornorá uma mensagem em caso de erro, se houver.
     * Caso não haver erros, deve retornar nulo.
     * @return 
     */
    public String verificarCamposObrigatorios();
}
