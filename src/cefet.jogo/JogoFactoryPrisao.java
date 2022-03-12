package cefet.jogo;

import cefet.exceptions.ValorInvalidoException;
import cefet.opcoes.Carta;
import cefet.opcoes.JogarPrisao;
import cefet.opcoes.Pagar;

/**
 * <p>
 * Represents the facade of the game when the player is in prison.
 * </p>
 * 
 *
 */
public class JogoFactoryPrisao extends JogoFactory {

	/**
	 * Shows the options of facade of the game when the player is in prison.
	 * @param opcao
	 * @param jogo
	 * @return boolean
	 */
	public boolean escolheOpcao(String opcao, JogoFacade jogo) {
		opcao = opcao.replaceAll("\\s+", "").toLowerCase();
		switch (opcao) {
		case "jogar":
			setOpcaoJogar();
			break;
		case "pagar":
			setOpcaoPagar();
			break;
		case "carta":
			setOpcaoCarta();
			break;
		case "status":
			setOpcaoStatus();
			break;
		case "sair":
			boolean escolha;
			try {
				escolha = jogo.simOuNao("Voc� realmente quer sair");
				if (escolha) {
					setOpcaoSair();
				}
			} catch (ValorInvalidoException e) {
				System.err.println(e.getMessage());
				escolheOpcao(opcao, jogo);
				return false;
			}
			break;
		default:
			setOpcaoErro();
		}
		return true;
	}

	/**
	 * <p>
	 * Sets the option "Play(Jogar)".
	 * </p>
	 */
	@Override
	public void setOpcaoJogar() {
		this.op = new JogarPrisao();
	}

	/**
	 * <p>
	 * Sets the option "Card(Carta)" for the player try to get out of prison with a card.
	 * </p>
	 */
	private void setOpcaoCarta() {
		this.op = new Carta();

	}

	/**
	 * <p>
	 * Sets the option "Pay(Pagar)" for the player pay to get out of prison.
	 * </p>
	 */
	private void setOpcaoPagar() {
		this.op = new Pagar();
	}

}