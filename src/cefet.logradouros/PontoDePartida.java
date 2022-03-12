package cefet.logradouros;

import cefet.jogo.JogoFacade;

/* representa o ponto inicial no tabuleiro */
public class PontoDePartida implements Posicao {

	private int posicao;

	/* construtor da classe PontoDePartida */
	public PontoDePartida(int posicao) {
		/* permite a inicializacao do atributo posicao */
		this.posicao = posicao;
	}

	/* evento que nada acontece */
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