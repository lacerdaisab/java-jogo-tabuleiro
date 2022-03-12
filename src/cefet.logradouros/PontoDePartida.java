package cefet.logradouros;

import cefet.jogo.JogoFacade;

/**
 * <p>
 * Represents the starting point position on the board.
 * </p>
 *
 */
public class PontoDePartida implements Posicao {

	private int posicao;

	/**
	 * <p>
	 * Constructor from class PontoDePartida, enables initialization of position
	 * attribute.
	 * </p>
	 * 
	 * @param int posicao - the position
	 */
	public PontoDePartida(int posicao) {
		this.posicao = posicao;
	}

	/**
	 * <p>
	 * An event that nothing happens.
	 * </p>
	 */
	@Override
	public void evento(JogoFacade jogo) {
		System.out.println("Nada aconteceu" + jogo.JogadorAtual().getNome());
	}

	@Override
	public int getNumeroDePosicao() {
		return this.posicao;
	}

	public String toString() {
		return this.posicao + " - Ponto de partida";
	}

	@Override
	public String getTipo() {
		return "Ponto de partida ";
	}

}