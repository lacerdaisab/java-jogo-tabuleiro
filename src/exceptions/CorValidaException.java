package exceptions;

/* subclasse de Exception */
/* indica que eh uma excecao de cor valida
ocorre quando o jogador tenta registrar uma cor que nao existe */
public class CorValidaException extends Exception {
	private static final long serialVersionUID = 1L;
	/* metodo construtor da classe CorValidaException */
	public CorValidaException(String msg) {
		super(msg);
	}
}