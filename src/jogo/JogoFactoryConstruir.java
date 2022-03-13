package jogo;

import exceptions.ValorInvalidoException;

import opcoes.ConstruirOP;
import opcoes.JogarPrisao;

import opcoes.Vender;

/* representa a opcao disponivel no jogo para o jogador */
public class JogoFactoryConstruir extends JogoFactory {

	/* mostra as opcoes do jogo */
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
				escolha = jogo.simOuNao("Voce realmente quer sair");
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

	/* configura a opcao vender */
	private void setOpcaoVender() {
		this.op = new Vender();
		
	}

	/* define a opcao construir */
	private void setOpcaoConstruir() {
		this.op = new ConstruirOP();
	}

	/* define a opcao jogar */
	@Override
	public void setOpcaoJogar() {
		this.op = new JogarPrisao();
	}
}