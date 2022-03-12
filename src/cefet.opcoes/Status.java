package cefet.opcoes;

import cefet.jogo.JogoFacade;
import cefet.lougradouros.TituloStrategy;

/**
 * <p>
 * Represents the players' status.
 * </p>
 *
 */
public class Status implements Opcao {

	/**
	 * <p>
	 * Shows the player's current status.
	 * </p>
	 * Methods
	 * 
	 * @param jogo JogoFacade
	 * @return boolean
	 */
	@Override
	public boolean fazerOP() {
		JogoFacade jogo = JogoFacade.getInstance();
		System.out.println("O status de " + jogo.JogadorAtual().getNome() + " - " + jogo.JogadorAtual().getCor()
				+ " � o seguinte:");
		System.out.println("Situado na posi��o " + jogo.getPosicaoAtual());
		System.out.println("Possui $" + jogo.JogadorAtual().getSaldo());
		System.out.println("Titulos:");
		if (jogo.JogadorAtual().getTitulos().size() == 0) {
			System.out.println("O jogador " + jogo.JogadorAtual().getNome() + " n�o possui t�tulos.");
		} else {
			for (TituloStrategy c : jogo.JogadorAtual().getTitulos()) {
				System.out.println(c.mostrarTitulo());
			}
		}
		return false;
	}

}
