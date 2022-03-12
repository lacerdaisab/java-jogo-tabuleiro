package cefet.logradouros;

import cefet.jogo.JogoFacade;

/**
 * <p>
 * </p>
 *
 */
public class ImpostoDeRenda implements Posicao {

	private int posicao;

	/**
	 * <p>
	 * Constructor from class ImpostoDeRenda, enables initialization of position
	 * attribute.
	 * </p>
	 * 
	 * @param int posicao - the position
	 */
	public ImpostoDeRenda(int posicao) {
		this.posicao = posicao;
	}

	/**
	 * <p>
	 * An event to make the player pays a value.
	 * </p>
	 */
	@Override
	public void evento(JogoFacade jogo) {
		System.out.println("Voc� pagou 200");
		jogo.JogadorAtual().pagar(200);
	}

	@Override
	public int getNumeroDePosicao() {
		return this.posicao;
	}

	@Override
	public String getTipo() {
		return "Imposto de renda";
	}

	public String toString() {
		return this.posicao + " - Imposto de Renda";
	}
}
