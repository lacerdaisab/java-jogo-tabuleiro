package cefet.opcoes;

import cefet.jogo.JogoFacade;

/**
 * <p>
 * Represents when the player has to pay a certain value.
 * </p>
 *
 */
public class Pagar implements Opcao {

	/**
	 * <p>
	 * The player pays a value and the match continues.
	 * </p>
	 * @return boolean
	 */
	@Override
	public boolean fazerOP() {
		JogoFacade jogo = JogoFacade.getInstance();		
		jogo.JogadorAtual().pagar(50);
		int novoDado = jogo.JogadorAtual().lancaDado();
		int novoDado2 = jogo.JogadorAtual().lancaDado();
		jogo.JogadorAtual().jogada(novoDado, novoDado2, jogo);
		jogo.getPosicaoAtual().evento(jogo);
		return true;
	}

}