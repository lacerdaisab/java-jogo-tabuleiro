package cefet.logradouros;

import cefet.jogo.JogoFacade;

/* posicao da interface */
public interface Posicao {

	/* metodo assinatura para um evento*/
	public void evento(JogoFacade jogo);

	/* metodo assinatura que pega o numero da poscao */
	public int getNumeroDePosicao();

	/* metodo assinatura que pega o tipo*/
	public String getTipo();

}