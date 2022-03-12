package cefet.opcoes;

import cefet.jogo.JogoFacade;

/* representa quando o jogador quer sair do jogo */
public class Sair implements Opcao {
	/* se a partida tem 2 jogadores e um jogador sair do jogo, o outro ganha a partida */
	@Override
	public boolean fazerOP() {
		JogoFacade jogo = JogoFacade.getInstance();
		if (jogo.getNumeroDeJogadores() > 2) {
			jogo.removeJogador();
		} else {
			jogo.removeJogador();
			System.out.println(jogo.JogadorAtual() + " eh o vencedor!");
			System.exit(0);
		}
		return false;
	}
}