package cefet.jogo;

import cefet.exceptions.ValorInvalidoException;
import cefet.opcoes.Erro;
import cefet.opcoes.Jogar;
import cefet.opcoes.Opcao;
import cefet.opcoes.Sair;
import cefet.opcoes.Status;


public class JogoFactory {

	protected Opcao op;

	/**
	 * <p>
	 * Method for the player choose an option.
	 * </p>
	 * 
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
		case "status":
			setOpcaoStatus();
			break;
		case "sair":
			boolean escolha;
			try {
				escolha = jogo.simOuNao("Voc� realmente quer sair? ");
				if (escolha) {
					setOpcaoSair();
					return true;
				}
				return false;

			} catch (ValorInvalidoException e) {
				System.err.println(e.getMessage());
				escolheOpcao(opcao, jogo);
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
	 * Execute the chosen option.
	 * </p>
	 * 
	 * @param
	 * @return
	 */
	public boolean executarOpcao(JogoFacade jogo) {
		return this.op.fazerOP();
	}

	/**
	 * <p>
	 * Sets the option "Play(Jogar)".
	 * </p>
	 */
	public void setOpcaoJogar() {
		this.op = new Jogar();
	}

	/**
	 * <p>
	 * Sets the option "Status".
	 * </p>
	 */
	public void setOpcaoStatus() {
		this.op = new Status();
	}

	/**
	 * <p>
	 * Sets the option "Leave(Sair)".
	 * </p>
	 */
	public void setOpcaoSair() {
		this.op = new Sair();
	}

	/**
	 * <p>
	 * Sets the option "Erro".
	 * </p>
	 */
	protected void setOpcaoErro() {
		this.op = new Erro();
	}

}
