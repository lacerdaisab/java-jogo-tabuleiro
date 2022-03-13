package exceptions;

/* subclasse de Exception */
/* indica que nao eh possivel fazer compra com o valor com o saldo disponivel em conta */
public class LimiteExcedidoException extends Exception {
	private static final long serialVersionUID = 1L;
	/* metodo construtor da classe LimiteExcedidoException */
	public LimiteExcedidoException(String msg) {
		super(msg);
	}
}