package cefet.exceptions;

/* subclasse de Exception */
/* indica que uma cor ja foi escolhida por outro jogador*/
public class ExisteJogadorComEstaCorException extends Exception {
	private static final long serialVersionUID = 1L;
	/* metodo construtor da classe ExisteJogadorComEstaCorException */
	public ExisteJogadorComEstaCorException(String msg) {
		super(msg);
	}
}
