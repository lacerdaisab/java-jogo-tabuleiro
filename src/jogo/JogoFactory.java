package jogo;

import exceptions.ValorInvalidoException;
import opcoes.Erro;
import opcoes.Jogar;
import opcoes.Opcao;
import opcoes.Sair;
import opcoes.Status;


public class JogoFactory {
	protected Opcao op;

	/* metodo para o jogador escolher uma opcao */
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
				escolha = jogo.simOuNao("Voce realmente quer sair? ");
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

	/* executa a opcao escolhida */
	public boolean executarOpcao(JogoFacade jogo) {
		return this.op.fazerOP();
	}

	/* define a opcao jogar */
	public void setOpcaoJogar() {
		this.op = new Jogar();
	}

	/* define a opcao status */
	public void setOpcaoStatus() {
		this.op = new Status();
	}

	/* define a opcao sair */
	public void setOpcaoSair() {
		this.op = new Sair();
	}

	/* define a opcao erro */
	protected void setOpcaoErro() {
		this.op = new Erro();
	}
}