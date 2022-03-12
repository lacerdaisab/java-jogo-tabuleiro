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


/**
 * <p>
 * Represents the facade of the games.
 * </p>
 *
 */
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

	/**
	 * <p>
	 * Shows the facade of the game to the players.
	 * </p>
	 * 
	 * @param
	 */
	public JogoFacade() {
		listaJogadores = new LinkedList<Jogador>();
		ultimosDados = new int[2];
	}

	/**
	 * <p>
	 * Convert to String.
	 * </p>
	 * 
	 */
	public String input() {
		return in.nextLine();
	}

	/**
	 * <p>
	 * Convert to integer.
	 * </p>
	 * 
	 * @throws IOException 
	 */
	public int inputInt() throws NumberFormatException {
		String textorecebido = in.nextLine();
		String outraString = textorecebido.replaceAll("\\s+", "");
		if(outraString.matches("\\D")) {
			throw new NumberFormatException("");
		}
		return Integer.parseInt(outraString);
	}

	/**
	 * <p>
	 * Add a new player.
	 * </p>
	 * 
	 */
	public void addJogador(Jogador e) {
		this.listaJogadores.add(e);
	}

	/**
	 * <p>
	 * Add the player who is at the beginning of the queue to the end.
	 * </p>
	 * 
	 */
	public void pollJogador() {
		this.listaJogadores.add(this.listaJogadores.pollFirst());
	}

	/**
	 * <p>
	 * Removes the player.
	 * </p>
	 * 
	 */
	public void removeJogador() {
		this.listaJogadores.remove(this.JogadorAtual());
	}

	/**
	 * <p>
	 * Throws the dices.
	 * </p>
	 * 
	 */
	public Dado getDado() {
		return this.dado;
	}
	
	public void reset() {
		instance = null;
	}

	/**
	 * <p>
	 * Verifies if the player is in prison.
	 * </p>
	 *
	 */
	public boolean verificarSeTaNaPrisao(Jogador j) {
		return this.tabuleiro.getPosicoeDoTabuleiro(j.getPosicao()).getTipo().equals("Pris�o");
	}

	/**
	 * <p>
	 * This method checks if there is any other player using the color passed as a
	 * parameter.
	 * </p>
	 * 
	 * @param cor
	 * @throws ExisteJogadorComEstaCorException
	 */

	public void verificaSeExisteJogadorComEstaCor(String cor) throws ExisteJogadorComEstaCorException {
		for (Jogador j : this.listaJogadores) {
			if (j.getCor().equals(cor)) {
				throw new ExisteJogadorComEstaCorException(
						"J� existe um jogador utilizando esta cor. Tente novamente!");
			}
		}
	}

	/**
	 * <p>
	 * Verifies if the chosen color is still available.
	 * </p>
	 * 
	 * @param String cor
	 * @throws CorValidaException
	 * @return true if the color passed as a parameter is within expected colors
	 */
	public boolean verificaSeAhCorEhValida(String cor) throws CorValidaException {
		if (cor.equalsIgnoreCase("preto") || cor.equalsIgnoreCase("branco") || cor.equalsIgnoreCase("vermelho")
				|| cor.equals("verde") || cor.equalsIgnoreCase("azul") || cor.equalsIgnoreCase("amarelo")
				|| cor.equalsIgnoreCase("laranja") || cor.equals("rosa")) {
			return true;
		}
		throw new CorValidaException("Esta cor n�o � v�lida. Tente novamente uma cor dispon�vel!");
	}

	/**
	 * <p>
	 * The current player.
	 * </p>
	 * 
	 */
	public Jogador JogadorAtual() {
		return this.listaJogadores.getFirst();
	}

	/**
	 * <p>
	 * Calls an event.
	 * </p>
	 * 
	 */
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
	public void verificaNumeroJogadores(int numero) throws ValorInvalidoException {
		if ((numero > 8 || numero < 2)) {
			throw new ValorInvalidoException("N�mero de jogadores inv�lidos!\n");
		}
	}

	/**
	 * <p>
	 * Pass the turn.
	 * </p>
	 * 
	 */
	public void passarAVez() {
		this.listaJogadores.add(this.listaJogadores.pollFirst());
	}

	/**
	 * <p>
	 * Shows the option "yes or no" in certain situations.
	 * </p>
	 * @param msg
	 * @throws ValorInvalidoException
	 * @return boolean
	 */
	public boolean simOuNao(String msg) throws ValorInvalidoException {
		System.out.print(msg + "\nSim/N�o");
		String escolha = this.input();
		if (escolha.matches("[\\s]*[Ss]+[Ii]*[Mm]*[\\s]*")) {
			return true;
		} else if (!(escolha.matches("[\\s]*[Nn]+[��Aa]*[Oo]*[\\s]*"))) {
			throw new ValorInvalidoException("Op��o n�o permitida");
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
		// TODO Auto-generated method stub
		return this.listaJogadores;
	}

	
	
	
}