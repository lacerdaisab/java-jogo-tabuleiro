package cefet.logradouros;

import cefet.jogo.JogoFacade;
import cefet.lougradouros.Posicao;

/**
 * <p>
 * Represents the position "Sorte ou Rev�s" on the board.
 * </p>
 *
 */
public class PosicaoSorteOuReves implements Posicao {

	private int posicaoNoTabuleiro;

	/**
	 * <p>
	 * Constructor from class SorteOuReves, enables initialization of position on
	 * the board attributes.
	 * </p>
	 * 
	 * @param posicao
	 * @param int     posicaoNoTabuleiro - the player's position on the board
	 */
	public PosicaoSorteOuReves(int posicao) {
		this.posicaoNoTabuleiro = posicao;
	}

	/**
	 * <p>
	 * An event.
	 * </p>
	 */
	@Override
	public void evento(JogoFacade jogo) {
		jogo.getCarta().acao(jogo.JogadorAtual());
	}

	@Override
	public int getNumeroDePosicao() {
		return this.posicaoNoTabuleiro;
	}

	public String toString() {
		return this.posicaoNoTabuleiro + " - Sorte ou Reves";
	}

	@Override
	public String getTipo() {
		return "Sorte ou reves";
	}

}