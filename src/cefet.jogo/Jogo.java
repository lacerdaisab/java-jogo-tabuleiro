package cefet.jogo;

import cefet.exceptions.CorValidaException;
import cefet.exceptions.ExisteJogadorComEstaCorException;
import cefet.exceptions.ValorInvalidoException;

/**
 * <p>
 * Representing the game. In this class, the game will starts, define the
 * numbers of players, choose the players' name and the pawn color, show the
 * options available for each player, and finally starts the match.
 * </p>
 */
public class Jogo {

	protected JogoFacade jogo;
	private int idJogador = 1;
	private int numeroDeJogadores;
	private boolean inicioDaPartida = true;
	private String[] listaDeCoresDisponiveis = { "preto", "branco", "vermelho", "verde", "azul", "amarelo", "laranja",
	"rosa" };

	
	/**
	 * <p>
	 * Class that has the methods to starts and ends and other objects that make up
	 * the game.
	 * </p>
	 * .
	 * 
	 */
	public Jogo() {
		this.jogo = JogoFacade.getInstance();
	}

	/**
	 * <p>
	 * Starts the game.
	 * </p>
	 * 
	 */
	public void iniciarJogo() {
		nJogadores();
		criarJogadores();
		System.out.println("O Banco Imobiliario vai comecar. Aproveite!");
		partida();

	}

	/**
	 * <p>
	 * Defines the number of players.
	 * </p>
	 * 
	 */
	private void nJogadores() {
		System.out.print("Digite o n�mero de jogadores [2 - 8]: ");
		int numero = 0;
		try {
			numero = jogo.inputInt();
			this.jogo.verificaNumeroJogadores(numero);
			this.numeroDeJogadores = numero;
		} catch (NumberFormatException e) {
			System.err.print("O valor deve ser um inteiro!\n");
			nJogadores();
		} catch (ValorInvalidoException e) {
			System.err.print("N�mero de jogadores inv�lidos!");
			nJogadores();
		}

	}

	/**
	 * <p>
	 * </p>
	 * method to choose the player's name.
	 * 
	 * @return nome
	 */
	private String escolheNomeJogador() {
		System.out.print("Digite o nome do jogador " + (this.idJogador) + ": ");
		String nome = jogo.input();
		if (!nome.matches("[\\s]*[a-z\\s*A-Z0-9]+")) {
			System.err.println("Digite apenas letras e n�meros.\nTente novamente");
			escolheNomeJogador();
		}
		return nome;

	}

	/**
	 * <p>
	 * Method to choose the player's pawn color
	 * </p>
	 * 
	 * @return cor
	 */
	private String escolheCorPeao() {
		System.out.print("Escolha a cor do pe�o do jogador " + (this.idJogador) + " entre as op��es seguintes:\n");
		for (int k = 0; k < this.listaDeCoresDisponiveis.length; k++) {
			if (this.listaDeCoresDisponiveis[k] != "") {
				System.out.print("[" + this.listaDeCoresDisponiveis[k] + "]");
			}
		}
		System.out.print("\n: ");
		String cor = jogo.input();
		return cor;
	}
	
	/**
	 * <p>
	 * Removes the color chosen by the player from the list of available colors.
	 * </p>
	 * 
	 * @param cor - A String representing the color that will be removed from the
	 *            list of available colors.
	 */
	private void eliminaCorEscolhidaDaLista(String cor) {
		for (int k = 0; k < this.listaDeCoresDisponiveis.length; k++) {
			if (this.listaDeCoresDisponiveis[k].equals(cor)) {
				this.listaDeCoresDisponiveis[k] = "";
			}
		}
	}


	/**
	 * <p>
	 * Method that creates the player(name and color pawn/)
	 * </p>
	 * 
	 */
	public void criarJogadores() {
		for (int i = 0; i < this.numeroDeJogadores; i++) {
			String nome = escolheNomeJogador();
			boolean parar = false;
			while (parar != true) {
				String cor = escolheCorPeao();
				try {
					jogo.verificaSeAhCorEhValida(cor);
					jogo.verificaSeExisteJogadorComEstaCor(cor);
					jogo.addJogador(new Jogador(nome, cor));
					eliminaCorEscolhidaDaLista(cor);
					this.idJogador++;
					parar = true;
				} catch (ExisteJogadorComEstaCorException e) {
					System.err.println("J� existe jogador com a cor escolhida, tente novamente!");
				} catch (CorValidaException e) {
					System.err.println("Cor Inv�lida, tente novamente!");
				}
			}
		}
	}

	/**
	 * <p>
	 * Method that shows the options available to the player.
	 * </p>
	 * 
	 * @param j Jogador
	 */
	private void opcoes(Jogador j) {
		if (jogo.verificarSeTaNaPrisao(j)) {
			opcoesPrisao();
		} else if(jogo.podeConstruir() == true && this.inicioDaPartida == true) {
			opcoesConstruir();
		} else if(jogo.podeVender()) {
			opcoesVender();
			
		}
		else {
			opcoesNormal();
		}
		String opcao = jogo.input();
		boolean deuCerto = jogo.getFabrica().escolheOpcao(opcao, this.jogo);
		boolean jogar = false;
		if (deuCerto) {
			jogar = jogo.getFabrica().executarOpcao(this.jogo);
			this.inicioDaPartida = false;

		}
		if ((jogar == false) || (!(opcao.equals("jogar") | opcao.equals("carta") | opcao.equals("pagar")))) {
			opcoes(j);
		}
	}

	private void opcoesConstruir() {
		System.out.print("Comandos dispon�veis:[construir][vender][jogar][status][sair]\nEntre com um comando: ");
		
	}

	/**
	 * <p>
	 * Shows the options available for each player.
	 * </p>
	 * 
	 */
	private void opcoesNormal() {
		System.out.print("Comandos dispon�veis:[jogar][status][sair]\nEntre com um comando: ");
	}

	/**
	 * <p>
	 * Shows the options available for the player who is in the prison.
	 * </p>
	 * 
	 */
	private void opcoesPrisao() {
		System.out.print("Comandos dispon�veis:[pagar][carta][jogar][status][sair]\nEntre com um comando: ");
	}
	
	private void opcoesVender() {
		System.out.println("Comandos dispon�veis:[Vender][jogar][status][sair]\nEntre com um comando: ");
	}

	/**
	 * <p>
	 * Starts the match.
	 * </p>
	 * 
	 */
	private void partida() {
		if (jogo.verificarSeTaNaPrisao(jogo.JogadorAtual())) {
			jogo.setPrisao();
		} else if(jogo.podeConstruir() == true) {
			jogo.setConstruir();
		} else if(jogo.podeVender() == true) {
			jogo.setVender();
		}
		else {
			jogo.setFabrica();
		}
		System.out.println("A jogada de " + jogo.JogadorAtual().toString() + "come�ou:");
		opcoes(jogo.JogadorAtual());
		
		this.jogo.pollJogador();
		this.inicioDaPartida = true;
		partida();
	}

}
