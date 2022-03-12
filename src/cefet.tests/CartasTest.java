package cefet.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cefet.cartas.HabeasCorpus;
import cefet.cartas.Pague;
import cefet.cartas.Presente;
import cefet.cartas.Receba;
import cefet.cartas.SorteOuReves;
import cefet.cartas.VaPrisao;
import cefet.jogo.Jogador;
import cefet.jogo.JogoFacade;

public class CartasTest {
	/* atributos para usar na carta de teste */
	private SorteOuReves carta;
	private Jogador jogador;
	private JogoFacade jogo;

	/* metodo que iniciliza os atributos para serem testados nas cartas */
	@Before
	public void setUp() {
		this.jogo = JogoFacade.getInstance();
		this.jogador = new Jogador("Joana", "azul");
		this.jogo.addJogador(new Jogador("Clebson","rosa"));
	}
	
	/* metodo que reseta o jogo para ser testado devido ao padrao unico */
	@After
	public void setDown() {
		this.jogo.reset();
	}
	
	/* metodo testando a acao da carta habeas corpus */
	@Test
	public void testHabeasCorpus() {
		this.carta = new HabeasCorpus("Descricao", "2");
		carta.acao(jogador);
		assertTrue("Testando", jogador.temCarta());
	}
	
	/* metodo que testa a acao da carta pague */
	@Test
	public void testPague() {
		this.carta = new Pague("Descricao", "100");
		carta.acao(jogador);
		assertEquals("Testando Pague", 1400, jogador.getSaldo());
	}

	/* metodo que testa a acao da carta presente */
	@Test
	public void testPresente() {
		this.carta = new Presente("Descricao", "50");
		carta.acao(jogador);
		assertEquals("Testando Presente com 2 jogadores na partida",1550,jogador.getSaldo());
	}
	
	/* metodo que testa a acao da carta receba */
	@Test
	public void testReceba() {
		this.carta = new Receba("Descricao","50");
		carta.acao(jogador);
		assertEquals("Testando Recebendo de 1 jogador",1550,jogador.getSaldo());
	}
	
	/* metodo que testa a acao da carta va prisao*/
	@Test
	public void testVaPrisao() {
		this.carta = new VaPrisao("Descricao","0");
		carta.acao(jogador);
		assertTrue(jogo.verificarSeTaNaPrisao(jogador));

	}
	
	

}
