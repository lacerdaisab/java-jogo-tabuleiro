package cefet.logradouros;


import cefet.jogo.JogoFacade;

/**
 * <p>
 *  Represents the position on the board "Lucro e Dividendo".
 * </p>
 *
 */
public class LucroEDividendo implements Posicao {

	private int posicao;

	/**
	 * <p>
	 * Constructor from class LucroEDividendo, enables initialization of position
	 * attribute.
	 * </p>
	 * 
	 * @param int posicao - the position
	 */
	public LucroEDividendo(int posicao) {
		this.posicao = posicao;
	}

	/**
	 * <p>
	 * An event that the player recieves a certain value.
	 * </p>
	 */
	@Override
	public void evento(JogoFacade jogo) {
		System.out.println("Voc� ganhou 200");
		jogo.JogadorAtual().receber(200);
	}

	@Override
	public int getNumeroDePosicao() {
		return this.posicao;
	}

	@Override
	public String getTipo() {
		return "Lucro e dividendo";
	}

	public String toString() {
		return this.posicao + " - Lucros ou Dividendos";
	}

}