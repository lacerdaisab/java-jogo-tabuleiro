package jogo;

import exceptions.CorValidaException;
import exceptions.ExisteJogadorComEstaCorException;
import exceptions.ValorInvalidoException;

/* representa o jogo */
public class Jogo {
	/* comeca o jogo, define o numero de jogadores, escolhe o nome dos jogaadores e a cor dos peoes,
	mostra as opcoes disponiveis para cada jogador e inicia a partida */
	protected JogoFacade jogo;
	private int idJogador = 1;
	private int numeroDeJogadores;
	private boolean inicioDaPartida = true;
	private String[] listaDeCoresDisponiveis = { "preto", "branco", "vermelho", "verde", "azul", "amarelo", "laranja",
	"rosa" };

	/* classe que tem o metodo que inicia, finaliza e outros objetos que fazem o jogo */
	public Jogo() {
		this.jogo = JogoFacade.getInstance();
	}

	/* inicia o jogo */
	public void iniciarJogo() {
		nJogadores();
		criarJogadores();
		System.out.println("O Banco Imobiliario vai comecar. Aproveite!");
		partida();

	}

	/* define o numero de jogadores */
	private void nJogadores() {
		System.out.print("Digite o numero de jogadores [2 - 8]: ");
		int numero = 0;
		try {
			numero = jogo.inputInt();
			this.jogo.verificaNumeroJogadores(numero);
			this.numeroDeJogadores = numero;
		} catch (NumberFormatException e) {
			System.err.print("O valor deve ser um inteiro!\n");
			nJogadores();
		} catch (ValorInvalidoException e) {
			System.err.print("Numero de jogadores invalidos!");
			nJogadores();
		}

	}

	/* metodo que escolhe o nome do jogador */
	private String escolheNomeJogador() {
		System.out.print("Digite o nome do jogador " + (this.idJogador) + ": ");
		String nome = jogo.input();
		if (!nome.matches("[\\s]*[a-z\\s*A-Z0-9]+")) {
			System.err.println("Digite apenas letras e numeros.\nTente novamente");
			escolheNomeJogador();
		}
		return nome;

	}

	/* metodo qe escolhe a cor do peao */
	private String escolheCorPeao() {
		System.out.print("Escolha a cor do peao do jogador " + (this.idJogador) + " entre as opcoes seguintes:\n");
		for (int k = 0; k < this.listaDeCoresDisponiveis.length; k++) {
			if (this.listaDeCoresDisponiveis[k] != "") {
				System.out.print("[" + this.listaDeCoresDisponiveis[k] + "]");
			}
		}
		System.out.print("\n: ");
		String cor = jogo.input();
		return cor;
	}
	
	/* remova a cor escolhida pelo jogador da lista de cores disponiveis */
	private void eliminaCorEscolhidaDaLista(String cor) {
		for (int k = 0; k < this.listaDeCoresDisponiveis.length; k++) {
			if (this.listaDeCoresDisponiveis[k].equals(cor)) {
				this.listaDeCoresDisponiveis[k] = "";
			}
		}
	}

	/* metodo que cria o jogador - nome e cor do peao */
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
					System.err.println("Ja existe jogador com a cor escolhida, tente novamente!");
				} catch (CorValidaException e) {
					System.err.println("Cor Invalida, tente novamente!");
				}
			}
		}
	}

	/* metodo que mostra as opcoes disponiveis para o jogador */
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
		System.out.print("Comandos disponiveis:[construir][vender][jogar][status][sair]\nEntre com um comando: ");
		
	}

	/* mostra as opcoes disponiveis para cada jogador */
	private void opcoesNormal() {
		System.out.print("Comandos disponiveis:[jogar][status][sair]\nEntre com um comando: ");
	}

	/* mostra as opcoes disponiveis para o jogador que esta na prisao */
	private void opcoesPrisao() {
		System.out.print("Comandos disponiveis:[pagar][carta][jogar][status][sair]\nEntre com um comando: ");
	}
	
	private void opcoesVender() {
		System.out.println("Comandos disponiveis:[Vender][jogar][status][sair]\nEntre com um comando: ");
	}

	/* inicia a partida */
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
		System.out.println("A jogada de " + jogo.JogadorAtual().toString() + "comecou:");
		opcoes(jogo.JogadorAtual());
		
		this.jogo.pollJogador();
		this.inicioDaPartida = true;
		partida();
	}
}