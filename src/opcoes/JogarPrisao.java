package opcoes;

import jogo.JogoFacade;

/* representa a classe que o jogador joga os dados quando esta na prisao */
public class JogarPrisao extends Jogar {

	/**
	 * <p>
	 * Verifies if the dices have the same value, if so, it's the player's turn again.
	 * If not, the player pass his/her turn.
	 * </p>
	 */
	/* verifica se os dados tem o mesmo valor, se tem, o jogador joga de novo. se nao, ele passa a vez */
	public void sumDados() {
		JogoFacade jogo = JogoFacade.getInstance();
		if (this.dado1 == this.dado2) {
			System.out.println("Tirou dados iguais!");
			jogo.setFabrica();
			int novoDado = jogo.JogadorAtual().lancaDado();
			int novoDado2 = jogo.JogadorAtual().lancaDado();
			jogo.JogadorAtual().jogada(novoDado, novoDado2, jogo);
			jogo.getPosicaoAtual().evento(jogo);
		} else {
			System.out.print("Dados nao sao iguais!");
		}
	}
}