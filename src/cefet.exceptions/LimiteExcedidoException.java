package cefet.exceptions;

/**
 * <p>
 * The LimiteExcedidoEdexception class is a subclass of Exception that indicates
 * that it is not possible to make a purchase with the available balance in an
 * account.
 * </p>
 */
public class LimiteExcedidoException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * <p>
	 * Constructor method of class LimiteExcedidoException.
	 * </p>
	 * 
	 * @param msg - A String
	 */
	public LimiteExcedidoException(String msg) {
		super(msg);
	}
}