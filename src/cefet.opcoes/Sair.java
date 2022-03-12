package cefet.opcoes;

import cefet.jogo.JogoFacade;

/**
 * <p>
 * REpresents when the player wants to leave the game.
 * </p>
 *
 */
public class Sair implements Opcao {

	/**
	 * <p>
	 * If the match has 2 player and one player leaves the game, the other player wins the game.
	 * </p>
	 * Methods
	 * 
	 * @param jogo JogoFacade
	 * @return boolean
	 */
	@Override
	public boolean fazerOP() {
		JogoFacade jogo = JogoFacade.getInstance();
		if (jogo.getNumeroDeJogadores() > 2) {
			jogo.removeJogador();
		} else {
			jogo.removeJogador();
			System.out.println(jogo.JogadorAtual() + " � o vencedor!");
			System.exit(0);
		}
		return false;
	}

}