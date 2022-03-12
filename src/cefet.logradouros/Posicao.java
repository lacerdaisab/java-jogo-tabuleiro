package cefet.logradouros;

import cefet.jogo.JogoFacade;

/**
 * <p>
 * The interface "Position".
 * </p>
 *
 */
public interface Posicao {

	/**
	 * <p>
	 * The method signature for an event.
	 * </p>
	 * @param jogo
	 */
	public void evento(JogoFacade jogo);

	/**
	 * <p>
	 * The method signature to get the number position.
	 * </p> 
	 * @return
	 */
	public int getNumeroDePosicao();

	/**
	 * <p>
	 * The method signature to get "Tipo".
	 * </p>
	 * 
	 * @return
	 */
	public String getTipo();

}