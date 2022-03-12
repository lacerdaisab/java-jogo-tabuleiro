package cefet.opcoes;

import cefet.jogo.JogoFacade;
import cefet.lougradouros.TituloStrategy;

/* representa o status do jogador */
public class Status implements Opcao {
	/* mostra para o jogador o staus atual */
	@Override
	public boolean fazerOP() {
		JogoFacade jogo = JogoFacade.getInstance();
		System.out.println("O status de " + jogo.JogadorAtual().getNome() + " - " + jogo.JogadorAtual().getCor()
				+ " eh o seguinte:");
		System.out.println("Situado na posicao " + jogo.getPosicaoAtual());
		System.out.println("Possui $" + jogo.JogadorAtual().getSaldo());
		System.out.println("Titulos:");
		if (jogo.JogadorAtual().getTitulos().size() == 0) {
			System.out.println("O jogador " + jogo.JogadorAtual().getNome() + " nao possui titulos.");
		} else {
			for (TituloStrategy c : jogo.JogadorAtual().getTitulos()) {
				System.out.println(c.mostrarTitulo());
			}
		}
		return false;
	}

}
