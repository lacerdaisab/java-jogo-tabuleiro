package jogo;

import java.util.ArrayList;
import java.util.LinkedList;

import exceptions.LimiteExcedidoException;
import exceptions.NaoTemTerrenosException;
import exceptions.ValorInvalidoException;
import logradouros.Terreno;
import logradouros.TituloStrategy;

/* representa um jogador */
public class Jogador {
	/* atributos nome, cor, posicao no tabuleiro, conta, lista de titulos e se tem uma carta de habeas corpus */
	private String nome;
	private String cor;
	private int posicao;
	private Conta conta;
	private LinkedList<TituloStrategy> titulos;
	private boolean carta;

	/* metodo construtor da classe Jogador */
	public Jogador(String nome, String cor) {
		/* inicializa com os atributos de nome, cor, lista vazia, uma conta e sem carta de Habeas Corpus */
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

	/* deposita valor na conta do jogador */
	public void receber(int valor) {
		try {
			this.conta.deposita(valor);
		} catch (ValorInvalidoException e) {
		}
	}

	/* paga uma certa quantidade para o outro jogador */
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

	/* paga uma certa quantidade para o outro jogador */
	public boolean pagar(int valor) {
		try {
			this.conta.debita(valor);
			return true;
		} catch (ValorInvalidoException e) {
			return false;
		} catch (LimiteExcedidoException e) {
			if (this.titulos.size() == 0) {
				System.out.println("Falencia!");
				JogoFacade.getInstance().removeJogador();
				return false;
			} else {
				this.titulos.getLast().venderAoBanco(this);
				pagar(valor);
			}
		}return false;
	}

	/* metodo para o jogador comprar um terreno */
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

	/* metodo para se movimentar */
	public void jogada(int dado1, int dado2, JogoFacade jogo) {
		avancarCasas(dado1, dado2);
		System.out.println(
				this.toString() + "tirou no primeiro dado o numero " + dado1 + ", tirou no segundo dado o numero " + dado2 + " e o peao esta na posicao " + jogo.getPosicaoAtual());
	}

	/* metodo que avanca para a proxima posicao */
	public void avancarCasas(int dado1, int dado2) {
		this.posicao += dado1 + dado2;
		if (this.posicao > 39) {
			this.posicao -= 39;
		}
	}

	/* metodo que remove o titulo de um jogador */
	public void removeTitulo(TituloStrategy tituloFactory) {
		for (int k = 0; k < this.titulos.size(); k++) {
			if (titulos.get(k).equals(tituloFactory)) {
				System.out.println(titulos.get(k) + " foi vendido.");
				titulos.remove(k);
			}
		}
	}

	/* verifica se tem alguma carta */
	public boolean temCarta() {
		if (this.carta == true) {
			return true;
		}
		return false;
	}

	/* remove a carta */
	public void removeCarta() {
		this.carta = false;
	}

	/* adiciona uma carta */
	public void addCarta() {
		this.carta = true;
	}

	/* faz o jogador ir para a prisao se esta na posicao 30 do tabuleiro */
	public void vaiParaPrisao() {
		this.posicao = 30;
	}

	/* mostra para o jogador quantas terrenos e contrucoes tem */
	public void mostrarTerrenos() {
		String texto = "";
		int cont = 1;
		for(TituloStrategy e: this.titulos) {
			if(e.hasTerreno() ){
				Terreno t = ((Terreno) e);
				texto = Integer.toString(cont) +" - "+ e.getNome()+" tem "+ t.getNumeroDeCasas()+" casa(s) construidas, casa custa $ "+ t.getValorDaConstrucao();
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
		} throw new NaoTemTerrenosException("Voce nao tem Terrenos.");
	}
}