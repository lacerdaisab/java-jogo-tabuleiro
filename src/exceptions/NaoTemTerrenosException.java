package exceptions;

public class NaoTemTerrenosException extends Exception {	
	/* excecao para jogadores sem propriedade */
	private static final long serialVersionUID = 1L;
/* metodo construtor da classe CorValidaException */
	public NaoTemTerrenosException(String msg) {
		super(msg);
	}
}