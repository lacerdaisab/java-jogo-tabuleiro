package cefet.exceptions;

public class NaoTemTerrenosException extends Exception {	
	/**
	 * An exception for when the player does not have any property.
	 */
	private static final long serialVersionUID = 1L;

	public NaoTemTerrenosException(String msg) {
		super(msg);
	}
	
}