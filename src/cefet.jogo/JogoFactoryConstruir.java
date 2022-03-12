package cefet.jogo;

import cefet.exceptions.ValorInvalidoException;

import cefet.opcoes.ConstruirOP;
import cefet.opcoes.JogarPrisao;

import cefet.opcoes.Vender;

/**
 * <p>
 * Represents the option available in the game to the player.
 * </p>
 * 
 *
 */
public class JogoFactoryConstruir extends JogoFactory {

	/**
	 * Shows the options of the game.
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
		case "vender":
			setOpcaoVender();
			break;
		case "construir":
			setOpcaoConstruir();
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
			return false;
		}
		return true;
	}

	/**
	 * <p>
	 * Sets the option "Sell(Vender)".
	 * </p>
	 */
	private void setOpcaoVender() {
		this.op = new Vender();
		
	}

	/**
	 * <p>
	 * Sets the option "Build(Construir)".
	 * </p>
	 */
	private void setOpcaoConstruir() {
		this.op = new ConstruirOP();
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

}