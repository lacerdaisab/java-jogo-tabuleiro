package exceptions;

/* subclasse de Exception */
/* indica que o valor nao eh valido para uma deteminada operacao */
public class ValorInvalidoException extends Exception {
	private static final long serialVersionUID = 1L;
	/* metodo construtor da classe CorValidaException */
	public ValorInvalidoException(String msg) {
		super(msg);
	}
}