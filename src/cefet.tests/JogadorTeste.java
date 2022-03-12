package cefet.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import cefet.jogo.*;
import cefet.lougradouros.Prisao;

public class JogadorTeste {
	/**
	 * 
	 *attribute to test on Jogador
	 * @author joana
	 */
	@Mock
	JogoFacade jogo = null;
	Jogador j;

	/**
	 * 
	 *method that initializes the attributes to be tested on jogador
	 * @author joana
	 */
	@Before
	public void inicializa() {
		MockitoAnnotations.initMocks(this);
		j = new Jogador("Joana", "rosa");
	}

	/**
	 * 
	 *method that resets the jogador to be tested
	 * @author joana
	 */
	@After
	public void setDown() {
		j = new Jogador("Joana", "rosa");
	}

	
	/**
	 *
	 *method that tests the position when a player rolls the dice
	 * @author joana
	 */
	
	
	@Test
	public void testJogadorLancaDado() {
		Mockito.when(jogo.JogadorAtual()).thenReturn(j);
		j.jogada(5, 5, jogo);
		System.out.println(j.getPosicao());
		assertEquals(10, j.getPosicao());
	}
	
	/**
	 *
	 *method that tests the player's action for the strategy method
	 * @author joana
	 */ 

	@Test
	public void testJogadorEvento() {
		jogo.addJogador(new Jogador("a", "b"));
		jogo.addJogador(new Jogador("B", "c"));
		Mockito.when(jogo.getPosicaoAtual()).thenReturn(new Prisao(0, null));
		jogo.getPosicaoAtual().evento(jogo);
		System.out.println(jogo.JogadorAtual());
	}
}
