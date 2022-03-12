package cefet.tests;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;

import cefet.exceptions.LimiteExcedidoException;
import cefet.exceptions.ValorInvalidoException;
import cefet.jogo.Conta;

public class ContaTest {
	
	/**
	 * 
	 *attribute to test on account
	 * @author joana
	 */

	private Conta conta;

	/**
	 * 
	 *method that initializes the attributes to be tested on account
	 * @author joana
	 */
	@Before
	public void setUp() {
		this.conta = new Conta();
	}
	
	/**
	 * 
	 *method to test account deposit
	 * @author joana
	 */

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
			fail("Deveria lan�ar exce��o");
		} catch (ValorInvalidoException e) {
		}
		assertEquals("Testando saldo apos exce��o",1600, this.conta.getSaldo() );
	}

	
	/**
	 * 
	 *method to test account debit
	 * @author joana
	 */
	@Test
	public void testDebitar() {
		assertEquals(1500, this.conta.getSaldo());
		try {
			this.conta.debita(1800);
			fail("Cad� a exce��o?");
		} catch (ValorInvalidoException e) {
			// TODO Auto-generated catch block
			fail("Exce��o errada");
		} catch (LimiteExcedidoException e) {
		}
		assertEquals("Teste depois do thwros",1500, this.conta.getSaldo() );
		try {
			this.conta.debita(100);
		} catch (ValorInvalidoException | LimiteExcedidoException e) {
			// TODO Auto-generated catch block
			fail("N�o era pra lan�ar exce��o");
		}
		assertEquals("Teste depois de debitar 100", 1400, this.conta.getSaldo());
		try {
			this.conta.debita(-100);
			fail("Era pra lan�ar exce��o");

		} catch (ValorInvalidoException e) {
			// TODO Auto-generated catch block
		} catch (LimiteExcedidoException e) {
			fail("Exce��o errada");

		}
	}
}