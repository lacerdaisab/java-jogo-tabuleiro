package cefet.jogo;

import java.util.ArrayList;
import java.util.LinkedList;

import cefet.exceptions.LimiteExcedidoException;
import cefet.exceptions.NaoTemTerrenosException;
import cefet.exceptions.ValorInvalidoException;
import cefet.lougradouros.Terreno;
import cefet.lougradouros.TituloStrategy;

/**
 * <p>
 * Representing a player. </br>
 * In this class, a player is considered to have a name, a pawn color, a
 * position on the board, an account, a list of titles, and if he has a Habeas
 * Corpus card.
 * </p>
 * 
 */
public class Jogador {

	private String nome;
	private String cor;
	private int posicao;
	private Conta conta;
	private LinkedList<TituloStrategy> titulos;
	private boolean carta;

	/**
	 * <p>
	 * Constructor method of class Jogador,enables initialization of name and color
	 * attributes. In addition, the player is started with an empty title list, an
	 * account and no Habeas Corpus card.
	 * </p>
	 * @param String nome - player's name
	 * @param String cor - player's pawn color
	 */
	public Jogador(String nome, String cor) {
		this.nome = nome;
		this.cor = cor;
		this.titulos = new LinkedList<TituloStrategy>();
		this.conta = new Conta();
		this.carta = false;
		this.posicao = 0;
	}
	
	public int lancaDado() {
		return JogoFacade.getInstance().getDado().lancaDado();
	}

	public String getNome() {
		return this.nome;
	}

	public String getCor() {
		return this.cor;
	}

	public int getPosicao() {
		return this.posicao;
	}

	public int getSaldo() {
		return this.conta.getSaldo();
	}

	public LinkedList<TituloStrategy> getTitulos() {
		return titulos;
	}

	@Override
	public String toString() {
		return this.nome + "(" + this.cor + ")";
	}

	/**
	 * <p>
	 * Deposits a value into the player's account.
	 * </p>
	 * 
	 * @param valor - An integer number representing the value that will be received
	 *              for the player.
	 * 
	 */
	public void receber(int valor) {
		try {
			this.conta.deposita(valor);
		} catch (ValorInvalidoException e) {
		}
	}

	/**
	 * <p>
	 * Pays a certain valeu to the other player.
	 * </p>
	 * 
	 * @param jogador - 
	 * @param valor - An integer representing the amount that will be paid to the other player.
	 */
	public void pagar(Jogador jogador, int valor) {
		try {
			this.conta.debita(valor);
			jogador.conta.deposita(valor);
		} catch (ValorInvalidoException e) {

		} catch (LimiteExcedidoException e) {
			if (this.titulos.size() == 0) {
				System.out.println("Falencia");
			} else {
				this.titulos.getLast().venderAoBanco(this);
				pagar(jogador, valor);
			}
		}
	}

	/**
	 * <p>
	 * Pays a certain valeu to the other player.
	 * </p>
	 * 
	 * @param jogo - 
	 * @param valor - An integer representing the amount that will be paid to the other player.
	 */
	public boolean pagar(int valor) {
		try {
			this.conta.debita(valor);
			return true;
		} catch (ValorInvalidoException e) {
			return false;
		} catch (LimiteExcedidoException e) {
			if (this.titulos.size() == 0) {
				System.out.println("Fal�ncia!");
				JogoFacade.getInstance().removeJogador();
				return false;
			} else {
				this.titulos.getLast().venderAoBanco(this);
				pagar(valor);
			}
		}return false;
	}

	/**
	 * <p>
	 * 
	 * </p>
	 * Method for the player buys a land.
	 * 
	 * @param valor
	 * @param t
	 * 
	 */

	public void comprarTitulo(int valor, TituloStrategy t) {
		try {
			this.conta.debita(valor);
			System.out.println("Compra efetuada com sucesso!");
		} catch (ValorInvalidoException e) {
			System.err.println(e.getMessage());
		} catch (LimiteExcedidoException e) {
			System.err.println(e.getMessage() + ", saldo R$ " + this.conta.getSaldo());
		}
		this.titulos.add(t);
	}

	/**
	 * <p>
	 * Method that makes the move.
	 * </p>
	 * 
	 * @param d Dado utilizado no jogo
	 * @param t Tabuleiro utilizado no jogo
	 * 
	 */
	// JOGADOR USA DADO, PORTANTO, DADO � UM PARAMETRO DO METODO JOGADA
	public void jogada(int dado1, int dado2, JogoFacade jogo) {
		avancarCasas(dado1, dado2);
		System.out.println(
				this.toString() + "tirou " + dado1 + "," + dado2 + " e o pe�o avan�ou " + jogo.getPosicaoAtual());
	}

	/**
	 * <p>
	 * Method that advances to the next posicion.
	 * </p>
	 * 
	 * 
	 * @param dado1 int
	 * @param dado2 int
	 */
	public void avancarCasas(int dado1, int dado2) {
		this.posicao += dado1 + dado2;
		if (this.posicao > 39) {
			this.posicao -= 39;
		}
	}

	/**
	 * <p>
	 * Removes the title from the player.
	 * </p>
	 * 
	 * @param tituloFactory
	 */
	public void removeTitulo(TituloStrategy tituloFactory) {
		for (int k = 0; k < this.titulos.size(); k++) {
			if (titulos.get(k).equals(tituloFactory)) {
				System.out.println(titulos.get(k) + " foi vendido.");
				titulos.remove(k);
			}
		}
	}

	/**
	 * <p>
	 * Checks if there is any cards.
	 * </p>
	 * 
	 * @return
	 * 
	 */
	public boolean temCarta() {
		if (this.carta == true) {
			return true;
		}
		return false;
	}

	/**
	 * <p>
	 * Removes the card.
	 * </p>
	 * 
	 */
	public void removeCarta() {
		this.carta = false;
	}

	/**
	 * <p>
	 * adds a card.
	 * </p>
	 * 
	 */
	public void addCarta() {
		this.carta = true;
	}

	/**
	 * <p>
	 * Makes the player go to the prison if he/she is on the posicion 30 on the board.
	 * </p>
	 * 
	 */
	public void vaiParaPrisao() {
		this.posicao = 30;
	}

	public void mostrarTerrenos() {
		String texto = "";
		int cont = 1;
		for(TituloStrategy e: this.titulos) {
			if(e.hasTerreno() ){
				Terreno t = ((Terreno) e);
				texto = Integer.toString(cont) +" - "+ e.getNome()+" tem "+ t.getNumeroDeCasas()+" casa(s) constru�das, casa custa $ "+ t.getValorDaConstrucao();
				cont += 1;
				System.out.println(texto);
			}
		}  
	}
	
	public int getNumeroDeTerrenos() {
		int cont = 0;
		for(TituloStrategy e: this.titulos) {
			if(e.hasTerreno() ){
				cont += 1;
			}
		}  return cont;
	}
	
	public Terreno escolheTerreno(int n) throws NaoTemTerrenosException {
		ArrayList<Terreno> terrenos = new ArrayList<Terreno>();
		for(TituloStrategy e: this.titulos) {
			if(e.hasTerreno()){
				terrenos.add((Terreno) e);
			}
		} if(terrenos.size() > 0) {
			return terrenos.get(n-1);
		} throw new NaoTemTerrenosException("Voc� n�o tem Terrenos.");
	}
	
}