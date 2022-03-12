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
	/* atributo para testar o jogador */
	@Mock
	JogoFacade jogo = null;
	Jogador j;

	/* metodo que inicializa os atributos para serem testados no jogador */
	@Before
	public void inicializa() {
		MockitoAnnotations.initMocks(this);
		j = new Jogador("Joana", "rosa");
	}

	/* metodo de reseta o jogador para ser testado */
	@After
	public void setDown() {
		j = new Jogador("Joana", "rosa");
	}

	/* metodo que testa a posicao quando o jogador rola o dado */
	@Test
	public void testJogadorLancaDado() {
		Mockito.when(jogo.JogadorAtual()).thenReturn(j);
		j.jogada(5, 5, jogo);
		System.out.println(j.getPosicao());
		assertEquals(10, j.getPosicao());
	}
	
	/* metodo que testa a acao do jogador para o metodo estrategia */
	@Test
	public void testJogadorEvento() {
		jogo.addJogador(new Jogador("a", "b"));
		jogo.addJogador(new Jogador("B", "c"));
		Mockito.when(jogo.getPosicaoAtual()).thenReturn(new Prisao(0, null));
		jogo.getPosicaoAtual().evento(jogo);
		System.out.println(jogo.JogadorAtual());
	}
}
