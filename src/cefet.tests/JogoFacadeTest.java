package cefet.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import cefet.exceptions.CorValidaException;
import cefet.jogo.Jogador;
import cefet.jogo.JogoFacade;

public class JogoFacadeTest {
	/* atributos usados no teste */
	private JogoFacade jogo;

	@Mock
	Mock jogoT;

	/* metodo que inicializa os atributos usados no teste do jogo */
	@Before
	public void setUp() {
		this.jogo = new JogoFacade();
		for (int i = 0; i < 8; i++) {
			jogo.addJogador(new Jogador("Joana", "Preto"));
		}
	}

	/* metodo que testa quando o jogador eh removido */
	@Test
	public void testRemoveJogador() {
		jogo.removeJogador();
		assertEquals("Removendo 1 jogador", 7, this.jogo.getNumeroDeJogadores());
		jogo.removeJogador();
		assertEquals("Removendo 2 jogadores",6, this.jogo.getNumeroDeJogadores());
		jogo.removeJogador();
		assertEquals("Removendo 3 jogadores",5, this.jogo.getNumeroDeJogadores() );
		jogo.removeJogador();
		assertEquals("Removendo 4 jogadores",4, this.jogo.getNumeroDeJogadores());
		jogo.removeJogador();
		assertEquals("Removendo 5 jogadores", 3, this.jogo.getNumeroDeJogadores() );
		jogo.removeJogador();
		assertEquals("Removendo 6 jogadores",2, this.jogo.getNumeroDeJogadores() );
		jogo.removeJogador();
		assertEquals("Removendo 7 jogadores",1, this.jogo.getNumeroDeJogadores() );
		jogo.removeJogador();
		assertEquals("Removendo 8 jogadores",0, this.jogo.getNumeroDeJogadores() );

	}

	/* metodo teste para adicionar jogadores */
	@Test
	public void testAddJogador() {
		jogo.addJogador(new Jogador("Joana", "Azul"));
		assertEquals("Adicionando um jogador", 9, this.jogo.getNumeroDeJogadores() );

	}

	/* metodo que verifica que o jogador esta em prisao */
	@Test
	public void testVerificaSeTaNaPrisao() {
		this.jogo.JogadorAtual().jogada(10, 0, jogo);
		assertTrue( "Verifica se esta na prisao",this.jogo.verificarSeTaNaPrisao(jogo.JogadorAtual()));
	}
	
	/* metodo teste cor do jogador */
	@Test
	public void testVerificaSeExisteJogadorComEstaCor() {
		try {
			assertTrue(this.jogo.verificaSeAhCorEhValida("branco"));
			assertTrue(this.jogo.verificaSeAhCorEhValida("preto"));
			assertTrue(this.jogo.verificaSeAhCorEhValida("azul"));
			assertTrue(this.jogo.verificaSeAhCorEhValida("rosa"));
			assertTrue(this.jogo.verificaSeAhCorEhValida("amarelo"));
			assertTrue(this.jogo.verificaSeAhCorEhValida("laranja"));
			assertTrue(this.jogo.verificaSeAhCorEhValida("vermelho"));
			assertTrue(this.jogo.verificaSeAhCorEhValida("verde"));
		} catch (CorValidaException e) {
			fail("Falhou");

		}
	}
}
