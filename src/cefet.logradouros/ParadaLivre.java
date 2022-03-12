package cefet.logradouros;

import cefet.jogo.JogoFacade;

/* representa a posicao no tabuleiro parada livre */
public class ParadaLivre implements Posicao {

	private int posicao;

	/* construtor da classe ParadaLivre */
	public ParadaLivre(int posicao) {
		/* permite a inicializao do atributo posicao */
		this.posicao = posicao;
	}

	/* evento que nada acontece */
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