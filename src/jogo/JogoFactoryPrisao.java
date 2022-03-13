package jogo;

import exceptions.ValorInvalidoException;
import opcoes.Carta;
import opcoes.JogarPrisao;
import opcoes.Pagar;

/* representa a fachada do jogo com o jogador esta na prisao */
public class JogoFactoryPrisao extends JogoFactory {

	/* mostra as opcoes de fachada do jogo quando o jogador esta na prisao */
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
		}
		return true;
	}

	/* define a opcao jogar */
	@Override
	public void setOpcaoJogar() {
		this.op = new JogarPrisao();
	}

	/* define a opcao carta para o jogador que tenta sair da prisao com uma carta */
	private void setOpcaoCarta() {
		this.op = new Carta();

	}

	/* define a opcao para o jogador que paga para sair da prisao */
	private void setOpcaoPagar() {
		this.op = new Pagar();
	}
}