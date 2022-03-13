package opcoes;

import jogo.JogoFacade;

/* representa classe que o jogador joga dados */
public class Jogar implements Opcao {

	protected int dado1;
	protected int dado2;

	/* quando o jogador joga os dados */
	@Override
	public boolean fazerOP() {
		JogoFacade jogo = JogoFacade.getInstance();
		this.dado1 = jogo.JogadorAtual().lancaDado();
		this.dado2 = jogo.JogadorAtual().lancaDado();

		int[] array = new int[2];
		array[0] = dado1;
		array[1] = dado2;
		jogo.setUltimosDados(array);

		sumDados(jogo);
		return true;
	}

	/* adiciona os valores do dado */
	public void sumDados(JogoFacade jogo) {
		jogo.JogadorAtual().jogada(this.dado1, this.dado2, jogo);
		jogo.chamarEvento();
	}
}