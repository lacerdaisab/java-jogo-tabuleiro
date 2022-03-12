package cefet.logradouros;

import cefet.jogo.JogoFacade;

/**
 * <p>
 * Represents the position of "Prison" on the board.
 * </p>
 *
 */
public class Prisao implements Posicao {

	private int posicao;
	private String nome;

	/**
	 * <p>
	 * Constructor from class Prisao, enables initialization of name and position
	 * attribute.
	 * </p>
	 * 
	 * @author Clebson
	 * @param string nome - the name
	 * @param int    posicao - the position
	 **/
	public Prisao(int posicao, String nome) {
		this.nome = nome;
		this.posicao = posicao;
	}

	/**
	 * <p>
	 * An event that the player in prison pass his/her turn.
	 * </p>
	 */
	@Override
	public void evento(JogoFacade jogo) {
		if (this.posicao == 30) {
			jogo.JogadorAtual().vaiParaPrisao();
		}
		System.out.println("Passou a vez");

	}

	@Override
	public int getNumeroDePosicao() {
		return this.posicao;
	}

	@Override
	public String toString() {
		return this.posicao + " - " + this.nome;
	}

	@Override
	public String getTipo() {
		return "Pris�o";
	}
}