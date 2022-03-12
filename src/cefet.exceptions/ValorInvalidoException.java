package cefet.exceptions;

/**
 * <p>
 * The ValorInvalidoException class is a subclass of Exception that indicates
 * that a value is not valid for a given operation.
 * </p>
 */
public class ValorInvalidoException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * <p>
	 * Constructor method of class ValorInvalidoException.
	 * </p>
	 * 
	 * @param msg - A String
	 */
	public ValorInvalidoException(String msg) {
		super(msg);
	}
}