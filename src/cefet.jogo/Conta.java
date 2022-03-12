package cefet.jogo;

import cefet.exceptions.LimiteExcedidoException;
import cefet.exceptions.ValorInvalidoException;

/**
 * <p>
 * This class represents a checking account, has only the balance attribute and
 * methods of deposit and debit, it is also possible to check the account
 * balance.
 * </p>
 */
public class Conta {

	private int saldo;

	/**
	 * <p>
	 * Constructor method of class Conta, initially Conta has the balance of $ 1500.
	 * </p>
	 */
	public Conta() {
		this.saldo = 1500;
	}

	/**
	 * <p>
	 * A value is added to the saldo, this value that will be added is the will be
	 * passed as a parameter.
	 * </p>
	 * 
	 * @param valor - A floating point number representing the value that will be
	 *              added
	 * @throws ValorInvalidoException If a value less than zero or zero is passed as
	 *                                a parameter, this method throws an exception
	 *                                of this type.
	 */
	public void deposita(double valor) throws ValorInvalidoException {
		if (valor <= 0) {
			throw new ValorInvalidoException("Valor inválido");
		}
		this.saldo += valor;

	}

	/**
	 * <p>
	 * A value is debited to the saldo, this value that will be added is the will be
	 * passed as a parameter.
	 * </p>
	 * 
	 * @param valor - A floating point number representing the value that will to be
	 *              debited.
	 * @throws ValorInvalidoException  If a value less than zero or zero is passed
	 *                                 as a parameter, this method throws an
	 *                                 exception of this type.
	 * 
	 * @throws LimiteExcedidoException If a value greater than the customer is
	 *                                 passed as a parameter, this method throws an
	 *                                 exception of this type.
	 */
	public void debita(double valor) throws ValorInvalidoException, LimiteExcedidoException {
		if (valor <= 0) {
			throw new ValorInvalidoException("Valor Inválido!");

		} else if (valor > this.saldo) {
			throw new LimiteExcedidoException("Saldo Insuficiente!");
		}
		this.saldo -= valor;

	}

	public int getSaldo() {
		return this.saldo;
	}

	@Override
	public String toString() {
		return "Possui: " + this.saldo;
	}
}
