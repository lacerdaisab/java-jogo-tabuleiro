package cefet.logradouros;

import cefet.jogo.JogoFacade;

/**
 * <p>
 * Represents the position on the board "Parada Livre".
 * </p>
 *
 */
public class ParadaLivre implements Posicao {

	private int posicao;

	/**
	 * <p>
	 * Constructor from class ParadaLivre, enables initialization of position
	 * attribute.
	 * </p>
	 * 
	 * @param int posicao - the position
	 **/
	public ParadaLivre(int posicao) {
		this.posicao = posicao;
	}

	/**
	 * <p>
	 * An event that nothing happens.
	 * </p>
	 */
	@Override
	public void evento(JogoFacade jogo) {
		System.out.println("Nada Aconteceu.");
	}

	@Override
	public int getNumeroDePosicao() {
		return this.posicao;
	}

	@Override
	public String toString() {
		return this.posicao + "- Parada Livre";
	}

	@Override
	public String getTipo() {
		return "Parada Livre";
	}

}