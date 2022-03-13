package logradouros;

import jogo.JogoFacade;
import logradouros.Posicao;

/* representa a posicao sorte ou reves no tabuleiro */
public class PosicaoSorteOuReves implements Posicao {

	private int posicaoNoTabuleiro;

	/* construtor da classe SorteOuReves */
	public PosicaoSorteOuReves(int posicao) {
		/* permite a inicializacao do atributo posicao no tabuleiro  */
		this.posicaoNoTabuleiro = posicao;
	}

	/* um evento */
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