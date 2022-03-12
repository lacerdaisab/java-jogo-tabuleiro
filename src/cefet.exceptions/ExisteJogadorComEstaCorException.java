package cefet.exceptions;

/**
 * <p>
 * The ExisteJogadorComEstaCorException class is a subclass of Exception that
 * indicates that it is a valid color exception. This occurs when, at the
 * beginning of the game, a player attempts to register a color has already been
 * chosen by another player.
 * </p>
 *
 */
public class ExisteJogadorComEstaCorException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * <p>
	 * Constructor method of class ExisteJogadorComEstaCorException
	 * </p>
	 * 
	 * @param msg - A String
	 */
	public ExisteJogadorComEstaCorException(String msg) {
		super(msg);
	}

}
