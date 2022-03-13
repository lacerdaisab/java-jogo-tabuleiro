package logradouros;

import jogo.JogoFacade;

/* representa o imposto de renda */
public class ImpostoDeRenda implements Posicao {

	private int posicao;

	/* construtor da classe ImpostoDeRenda */
	public ImpostoDeRenda(int posicao) {
		/* permite a inicializacao do atributo de posicao */
		this.posicao = posicao;
	}

	/* um evento que faz o jogador pagar um valor */
	@Override
	public void evento(JogoFacade jogo) {
		System.out.println("Voce pagou 200");
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
