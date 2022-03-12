package cefet.opcoes;

import cefet.jogo.JogoFacade;

/* representa a classe de cartas */
public class Carta implements Opcao {

	/* metodo para o jogador tentar sair da prisao com a carta Habeas Corpus */
	@Override
	public boolean fazerOP() {
		JogoFacade jogo = JogoFacade.getInstance();
		if (jogo.JogadorAtual().temCarta()) {
			jogo.JogadorAtual().removeCarta();
			System.out.println(jogo.JogadorAtual() + " usou carta para sair da prisao");
			return true;
		}
		System.out.println("Nao tem carta de Habeas corpus");
		return false;
	}

}