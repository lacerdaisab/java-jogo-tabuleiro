package cefet.opcoes;

import cefet.jogo.JogoFacade;

/**
 * <p>
 * Represents class that the player throws the dices when he/she is in prison.
 * </p>
 *
 */
public class JogarPrisao extends Jogar {

	/**
	 * <p>
	 * Verifies if the dices have the same value, if so, it's the player's turn again.
	 * If not, the player pass his/her turn.
	 * </p>
	 */
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
			System.out.print("Dados n�o s�o iguais!");
		}
	}
}