package cefet.jogo;

import cefet.exceptions.LimiteExcedidoException;
import cefet.exceptions.ValorInvalidoException;

/* classe conta corrente */
public class Conta {
	/* atributo saldo */
	private int saldo;
	/* metodo contrutor da classe Conta */
	/* inicia a conta com saldo de 1500 */
	public Conta() {
		this.saldo = 1500;
	}

	/* metodo deposito */
	/* adiciona valor ao saldo e passa-o como parametro */
	public void deposita(double valor) throws ValorInvalidoException {
		/* nao permite valores de zero ou menor que zero */
		if (valor <= 0) {
			throw new ValorInvalidoException("Valor inválido");
		}
		this.saldo += valor;

	}

	/* metodo debito */
	/* debita valor do saldo e passa-o como parametro */
	public void debita(double valor) throws ValorInvalidoException, LimiteExcedidoException {
		/* nao permite valores de zero ou menor que zero */
		if (valor <= 0) {
			throw new ValorInvalidoException("Valor Inválido!");
			
			/* nao permite debitar um valor maior do que ja tem em conta */
		} else if (valor > this.saldo) {
			throw new LimiteExcedidoException("Saldo Insuficiente!");
		}
		this.saldo -= valor;
	}
	/* consulta o saldo da conta */
	public int getSaldo() {
		return this.saldo;
	}
	@Override
	public String toString() {
		return "Possui: " + this.saldo;
	}
}
