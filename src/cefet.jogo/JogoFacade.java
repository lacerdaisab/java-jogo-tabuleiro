package cefet.jogo;

import java.io.IOException;

import java.util.LinkedList;
import java.util.Scanner;


import cefet.cartas.SorteOuReves;
import cefet.exceptions.CorValidaException;
import cefet.exceptions.ExisteJogadorComEstaCorException;
import cefet.exceptions.ValorInvalidoException;
import cefet.lougradouros.Construtora;
import cefet.lougradouros.Posicao;

/* representa a fachada dos jogos */
public class JogoFacade {

	protected static final Scanner in = new Scanner(System.in);
	protected LinkedList<Jogador> listaJogadores;
	protected Dado dado = new Dado();
	protected Tabuleiro tabuleiro = new Tabuleiro();
	private JogoFactory fabrica;
	private int[] ultimosDados;
	private static JogoFacade instance = null;

	public static JogoFacade getInstance() {
		if (instance == null) {
			instance = new JogoFacade();
		}
		return instance;
	}

	/* mostra a fachada do jogo para os jogadores */
	public JogoFacade() {
		listaJogadores = new LinkedList<Jogador>();
		ultimosDados = new int[2];
	}

	/* converte para string */
	public String input() {
		return in.nextLine();
	}

	/* converte para inteiro */
	public int inputInt() throws NumberFormatException {
		String textorecebido = in.nextLine();
		String outraString = textorecebido.replaceAll("\\s+", "");
		if(outraString.matches("\\D")) {
			throw new NumberFormatException("");
		}
		return Integer.parseInt(outraString);
	}

	/* adiciona um novo jogador */
	public void addJogador(Jogador e) {
		this.listaJogadores.add(e);
	}

	/* adiciona o jogador que esta no inicio da partida ao final */
	public void pollJogador() {
		this.listaJogadores.add(this.listaJogadores.pollFirst());
	}

	/* remove o jogador */
	public void removeJogador() {
		this.listaJogadores.remove(this.JogadorAtual());
	}

	/* joga os dados */
	public Dado getDado() {
		return this.dado;
	}
	
	public void reset() {
		instance = null;
	}

	/* verifica se o jogador esta na prisao */
	public boolean verificarSeTaNaPrisao(Jogador j) {
		return this.tabuleiro.getPosicoeDoTabuleiro(j.getPosicao()).getTipo().equals("Pris�o");
	}

	/*  checa se tem algum outro jogador usando a cor passada como parametro */
	public void verificaSeExisteJogadorComEstaCor(String cor) throws ExisteJogadorComEstaCorException {
		for (Jogador j : this.listaJogadores) {
			if (j.getCor().equals(cor)) {
				throw new ExisteJogadorComEstaCorException(
						"Ja existe um jogador utilizando esta cor. Tente novamente!");
			}
		}
	}

	/* verifica se a cor escolhida ainda esta disponivel */
	public boolean verificaSeAhCorEhValida(String cor) throws CorValidaException {
		if (cor.equalsIgnoreCase("preto") || cor.equalsIgnoreCase("branco") || cor.equalsIgnoreCase("vermelho")
				|| cor.equals("verde") || cor.equalsIgnoreCase("azul") || cor.equalsIgnoreCase("amarelo")
				|| cor.equalsIgnoreCase("laranja") || cor.equals("rosa")) {
			return true;
		}
		throw new CorValidaException("Esta cor nao eh valida. Tente novamente uma cor disponivel!");
	}

	/* mostra o jogador atual */
	public Jogador JogadorAtual() {
		return this.listaJogadores.getFirst();
	}

	/* chama um evento */
	public void chamarEvento() {
		this.tabuleiro.getPosicoeDoTabuleiro(this.JogadorAtual().getPosicao()).evento(this);

	}

	/**
	 * <p>
	 * Verifies if the number of player in the match is valid. It must be above 2
	 * and up to 8 players.
	 * </p>
	 * 
	 * @param numero
	 * @throws ValorInvalidoException
	 */
	/* verifica se o numero de jogadores na partida eh maior que 2 e menor que 8 */
	public void verificaNumeroJogadores(int numero) throws ValorInvalidoException {
		if ((numero > 8 || numero < 2)) {
			throw new ValorInvalidoException("Numero de jogadores invalidos!\n");
		}
	}

	/* passa a vez */
	public void passarAVez() {
		this.listaJogadores.add(this.listaJogadores.pollFirst());
	}

	/* mostra a opcao sim ou nao em certas situacoes */
	public boolean simOuNao(String msg) throws ValorInvalidoException {
		System.out.print(msg + "\nSim/Nao");
		String escolha = this.input();
		if (escolha.matches("[\\s]*[Ss]+[Ii]*[Mm]*[\\s]*")) {
			return true;
		} else if (!(escolha.matches("[\\s]*[a-z\\s*A-Z0-9]+"))) {
			throw new ValorInvalidoException("Opcao nao permitida");
		}
		return false;
	}

	public SorteOuReves getCarta() {
		return this.tabuleiro.getSorteOuReves();
	}

	public int getNumeroDeJogadores() {
		return this.listaJogadores.size();
	}

	public Posicao getPosicaoAtual() {
		return this.tabuleiro.getPosicoeDoTabuleiro(this.JogadorAtual().getPosicao());
	}

	public void setPrisao() {
		this.fabrica = new JogoFactoryPrisao();
	}

	public void setVender() {
		this.fabrica = new JogoFactoryVender();
	}
	
	
	public JogoFactory getFabrica() {
		return this.fabrica;
	}

	public void setConstruir() {
		this.fabrica = new JogoFactoryConstruir();
	}
	
	public void setFabrica() {
		this.fabrica = new JogoFactory();
	}

	public int[] getUltimosDados() {
		return ultimosDados;
	}

	public void setUltimosDados(int[] ultimosDados) {
		this.ultimosDados = ultimosDados;
	}

	public boolean podeConstruir() {
		Construtora c = new Construtora(this.JogadorAtual());
		return c.podeConstruir();
		
	}
	
	public boolean podeVender() {
		Construtora c = new Construtora(this.JogadorAtual());
		return c.podeVender();
		
	}

	public LinkedList<Jogador> getJogadores() {
		return this.listaJogadores;
	}
}