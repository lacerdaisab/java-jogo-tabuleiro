package cefet.jogo;

import cefet.exceptions.ValorInvalidoException;
import cefet.opcoes.JogarPrisao;
import cefet.opcoes.Vender;

/* representa a opcao disponivel no jogo para o jogador */
public class JogoFactoryVender extends JogoFactory{
	
	/* mostra as opcoes da fachada do jogo para o jogador */
	public boolean escolheOpcao(String opcao, JogoFacade jogo) {
		opcao = opcao.replaceAll("\\s+", "").toLowerCase();
		switch (opcao) {
		case "jogar":
			setOpcaoJogar();
			break;
		case "vender":
			setOpcaoVender();
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

	/* define a opcao vender */
	private void setOpcaoVender() {
		this.op = new Vender();
		
	}

	/* define a opcao jogar */
	@Override
	public void setOpcaoJogar() {
		this.op = new JogarPrisao();
	}
}