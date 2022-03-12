package cefet.logradouros;


import cefet.jogo.JogoFacade;

/* representa a posicao no tabuleiro lucro e dividendo */
public class LucroEDividendo implements Posicao {

	private int posicao;

	/* coonstrutor da classe LucroEDividenvo */
	public LucroEDividendo(int posicao) {
		/* permite a inicializacao do atributo posicao */
		this.posicao = posicao;
	}

	/* evento que o jogador recebe um valor */
	@Override
	public void evento(JogoFacade jogo) {
		System.out.println("Voce ganhou 200");
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