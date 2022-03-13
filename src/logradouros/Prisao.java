package logradouros;

import jogo.JogoFacade;

/* representa a posicao da prisao no tabuleiro */
public class Prisao implements Posicao {

	private int posicao;
	private String nome;

	/* construtor da classe Prisao */
	public Prisao(int posicao, String nome) {
		/* permite a inicializacao dos atributos nome e posicao */
		this.nome = nome;
		this.posicao = posicao;
	}

	/* evento que o jogador em prisao passa a vez */
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
		return "Prisao";
	}
}