package jogo;

import recuperaDados.RecuperaDadosDoTXT;

import java.io.IOException;
import java.util.LinkedList;

import cartas.SorteOuReves;
import logradouros.*;

/* representa o tabuleiro */
public class Tabuleiro {

	private Posicao[] posicoeDoTabuleiro;
	private RecuperaDadosDoTXT recupera = new RecuperaDadosDoTXT();
	private LinkedList<SorteOuReves> baralho;

	private static final String ARQUIVO_POSICOES_ESPECIAIS = "./Arquivos/posicoesEspeciais.txt";
	private static final String ARQUIVO_COMPANHIAS = "./Arquivos/companhias.txt";
	private static final String ARQUIVO_PRISAO = "./Arquivos/prisao.txt";
	private static final String ARQUIVO_TERRENOS = "./Arquivos/terrenos.txt";
	private static final String ARQUIVO_POSICOES_DE_SORTE_OU_REVES = "./Arquivos/posicaoDeSorteOuReves.txt";
	private static final String ARQUIVO_SORTE_OU_REVES = "./Arquivos/cartasDeSorteOuReves.txt";

	/* contrutor da classe tabuleiro, permite a inicializacao da posicao no atributo tabuleiro */
	public Tabuleiro() {
		this.posicoeDoTabuleiro = new Posicao[41];
		recuperaCompanhias();
		recuperaPosicoesEspeciais();
		recuperaPrisao();
		recuperaTerrenos();
		recuperaPosicoesDeSorteOuReves();
		try {
			this.baralho = recupera.recuperaCartas(ARQUIVO_SORTE_OU_REVES);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public Posicao getPosicoeDoTabuleiro(int indice) {
		return this.posicoeDoTabuleiro[indice];
	}

	/* metodo que recupera arquivos das companhias */
	public void recuperaCompanhias() {

		try {
			for (String s : recupera.recuperaTextoDeArquivo(ARQUIVO_COMPANHIAS)) {

				String[] linha = s.split(",");

				int posicao = Integer.parseInt(linha[0]);
				String nome = linha[1];
				int preco = Integer.parseInt(linha[2]);
				int multiplicador = Integer.parseInt(linha[3]);

				Companhia c = new Companhia(posicao, nome, preco, multiplicador);

				this.posicoeDoTabuleiro[posicao] = c;

			}
		} catch (IOException e) {
			System.out.println("Nao foi possivel recuperar o arquivo TXT de companhia");
		}
	}

	/* metodo que recupera o arquivode posicoes especiais */
	public void recuperaPosicoesEspeciais() {
		try {
			for (String s : recupera.recuperaTextoDeArquivo(ARQUIVO_POSICOES_ESPECIAIS)) {

				String[] linha = s.split(",");
				int posicao = Integer.parseInt(linha[0]);
				String nome = linha[1];
				if (nome.equals("Lucros e Dividendos")) {
					Posicao p = new LucroEDividendo(posicao);
					this.posicoeDoTabuleiro[posicao] = p;
				} else if (nome.equals("Parada Livre")) {
					Posicao p = new ParadaLivre(posicao);
					this.posicoeDoTabuleiro[posicao] = p;
				} else if (nome.equals("Imposto de Renda")) {
					Posicao p = new ImpostoDeRenda(posicao);
					this.posicoeDoTabuleiro[posicao] = p;
				} else if (nome.equals("Ponto de partida")) {
					Posicao p = new PontoDePartida(posicao);
					this.posicoeDoTabuleiro[posicao] = p;
				}

			}
		} catch (IOException e) {
			System.out.println("Nao foi possivel recuperar o arquivo TXT posicoes especiais");
		}

	}

	/* metodo que recupera o arquivo de prisao */
	public void recuperaPrisao() {
		try {
			for (String s : recupera.recuperaTextoDeArquivo(ARQUIVO_PRISAO)) {

				String[] linha = s.split(",");
				int posicao = Integer.parseInt(linha[0]);
				String nome = linha[1];
				Prisao p = new Prisao(posicao, nome);
				this.posicoeDoTabuleiro[posicao] = p;

			}
		} catch (IOException e) {
			System.out.println("Nao foi possivel recuperar o arquivo TXT de prisao");
		}

	}

	/* metodo que recupera o arquivo de terrenos */
	public void recuperaTerrenos() {

		try {
			for (String s : recupera.recuperaTextoDeArquivo(ARQUIVO_TERRENOS)) {

				String[] linha = s.split(",");

				int posicao = Integer.parseInt(linha[0]);
				String nome = linha[1];
				int preco = Integer.parseInt(linha[2]);
				int aluguel = Integer.parseInt(linha[3]);
				int aluguelComUmaCasa = Integer.parseInt(linha[4]);
				int aluguelComDuasCasas = Integer.parseInt(linha[5]);
				int aluguelComTresCasas = Integer.parseInt(linha[6]);
				int aluguelComQuatroCasas = Integer.parseInt(linha[7]);
				int aluguelComHotel = Integer.parseInt(linha[8]);
				int dono = Integer.parseInt(linha[9]);
				String cor = linha[10];

				Terreno t = new Terreno(posicao, nome, preco, aluguel, aluguelComUmaCasa, aluguelComDuasCasas,
						aluguelComTresCasas, aluguelComQuatroCasas, aluguelComHotel, dono, cor);

				this.posicoeDoTabuleiro[posicao] = t;

			}
		} catch (IOException e) {
			System.out.println("Nao foi possivel recuperar o arquivo TXT de terrenos");
		}

	}

	/* metodo que recupera as posicoes de sorte ou reves */
	public void recuperaPosicoesDeSorteOuReves() {
		try {
			for (String s : recupera.recuperaTextoDeArquivo(ARQUIVO_POSICOES_DE_SORTE_OU_REVES)) {

				int posicao = Integer.parseInt(s);
				PosicaoSorteOuReves r = new PosicaoSorteOuReves(posicao);
				this.posicoeDoTabuleiro[posicao] = r;

			}
		} catch (IOException e) {
			System.out.println("Nao foi possivel recuperar o arquivo TXT de posicoes de sorte ou reves");
		}

	}

	/* metodo que pega sorte ou reves */
	public SorteOuReves getSorteOuReves() {
		SorteOuReves carta = this.baralho.pollFirst();
		this.baralho.add(carta);
		return carta;
	}
}