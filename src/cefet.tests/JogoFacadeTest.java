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
	
	/**
	 * attributes used in the test
	 * 
	 * @author joana
	 * 
	 */
	private JogoFacade jogo;

	@Mock
	Mock jogoT;

	/**
	 * method that initializes the attributes used in the game test
	 * 
	 * @author joana
	 * 
	 */
	@Before
	public void setUp() {
		this.jogo = new JogoFacade();
		for (int i = 0; i < 8; i++) {
			jogo.addJogador(new Jogador("Joana", "Preto"));
		}
	}

	/**
	 * method that tests when the player is removed
	 * 
	 * @author joana
	 * 
	 */
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

	/**
	 *testing method add players
	 * 
	 * @author joana
	 * @return nome
	 */
	@Test
	public void testAddJogador() {
		jogo.addJogador(new Jogador("Joana", "Azul"));
		assertEquals("Adicionando um jogador", 9, this.jogo.getNumeroDeJogadores() );

	}

	/**
	 * method that checks to see if you're in prison
	 * 
	 * @author joana
	 * 
	 */
	@Test
	public void testVerificaSeTaNaPrisao() {
		this.jogo.JogadorAtual().jogada(10, 0, jogo);
		assertTrue( "Verifica se est� na pris�o",this.jogo.verificarSeTaNaPrisao(jogo.JogadorAtual()));
	}
	
	/**
	 * 
	 * method testing if the color player
	 * @author joana
	 * 
	 */	

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
