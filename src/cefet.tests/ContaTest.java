package cefet.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import cefet.exceptions.LimiteExcedidoException;
import cefet.exceptions.ValorInvalidoException;
import cefet.jogo.Conta;

public class ContaTest {
	
	/* atributo de conta teste */
	private Conta conta;

	/* metodo que inicializa os atributos que serao testados na conta */
	@Before
	public void setUp() {
		this.conta = new Conta();
	}
	
	/* metodo que testa a conta deposito */
	@Test
	public void testDepositar() {
		assertEquals(1500, this.conta.getSaldo());
		try {
			this.conta.deposita(100);
		} catch (ValorInvalidoException e) {
			fail("Deveria ter dado certo");
		}
		assertEquals("Testando saldo apos depositar", 1600, this.conta.getSaldo());
		try {
			this.conta.deposita(-100);
			fail("Deveria lancar excecao");
		} catch (ValorInvalidoException e) {
		}
		assertEquals("Testando saldo apos excecao",1600, this.conta.getSaldo() );
	}

	/* metodo que testa a conta de debito */
	@Test
	public void testDebitar() {
		assertEquals(1500, this.conta.getSaldo());
		try {
			this.conta.debita(1800);
			fail("Cade a excecao?");
		} catch (ValorInvalidoException e) {
			fail("Excecao errada");
		} catch (LimiteExcedidoException e) {
		}
		assertEquals("Teste depois do thwros",1500, this.conta.getSaldo() );
		try {
			this.conta.debita(100);
		} catch (ValorInvalidoException | LimiteExcedidoException e) {
			fail("Nao era pra lancar excecao");
		}
		assertEquals("Teste depois de debitar 100", 1400, this.conta.getSaldo());
		try {
			this.conta.debita(-100);
			fail("Era pra lancar excecao");

		} catch (ValorInvalidoException e) {
		} catch (LimiteExcedidoException e) {
			fail("Excecao errada");

		}
	}
}