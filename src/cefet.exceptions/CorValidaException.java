package cefet.exceptions;

/**
 * <p>
 * The CorValidaException class is a subclass of Exception that indicates that
 * it is a valid color exception. This occurs when, at the beginning of the
 * game, a player attempts to register a color that does not exist.
 * </p>
 */
public class CorValidaException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * <p>
	 * Constructor method of class CorValidaException.
	 * </p>
	 * 
	 * @param msg - A String
	 */
	public CorValidaException(String msg) {
		super(msg);
	}
}