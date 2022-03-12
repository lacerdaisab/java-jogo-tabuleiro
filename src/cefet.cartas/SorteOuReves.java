package cefet.cartas;

import cefet.jogo.Jogador;


/**
 * This class is responsible for creating lucky or setbacks cards. </br>
 * Because it is abstract it cannot be instantiated, so to use it you will have
 * to establish an inheritance relationship with it. </br>
 * The class has as attributes the card description and position in the Lucky or
 * Setback queue. </br>
 * This class has two methods, a constructor and an abstract action method
 * (JogoFacade jogo).
 * 
 */
public abstract class SorteOuReves {

	protected String descricao;
	protected int valor;
	
	/**
	 * Constructor method of abstract class SorteOuReves
	 * 
	 * @param description - A String with representing the description of the action
	 *                    taken by the lucky card or setback - type String
	 * @param posision    - A String with representing the position in the luck or
	 *                    setback queue.
	 * 
	 */
	public SorteOuReves(String descricao, String valor) {
		this.descricao = descricao;
		this.valor = Integer.parseInt(valor);
	}

	/**
	 * This method is abstract. The class that will implement it must realize a
	 * action with base in your type and description. Example: the Pay type class
	 * must pay an amount defined by its description.
	 * 
	 * @param jogo - type JogoFacade
	 */
	public abstract void acao(Jogador j);
}