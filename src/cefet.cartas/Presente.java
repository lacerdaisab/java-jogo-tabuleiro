package cefet.cartas;

import cefet.jogo.Jogador;
import cefet.jogo.JogoFacade;

/**
 * <p>
 * This class is a subclass of LuckyOrReves and therefore inherits its
 * attributes from the card's description and position in the Lucky or Setback
 * queue.
 * </p>
 * <p>
 * In addition, its behavior is also inherited, therefore is required to
 * implement the acao method.
 * </p>
 */
public class Presente extends SorteOuReves {

	/**
	 * <p>
	 * Constructor method of class Presente.
	 * </p>
	 * 
	 * @param description - A String with representing the description of the action
	 *                    taken by the lucky card or setback - type String
	 * @param posision    - A String with representing the position in the luck or
	 *                    setback queue.
	 */
	public Presente(String descricao, String valor) {
		super(descricao, valor);
	}

	/**
	 * <p>
	 * This method implement the method acao, therefore it must realize a action
	 * with base in your type and description.
	 * </p>
	 * <p>
	 * an amount from all other players' accounts will be credited to the player's
	 * account. </br>
	 * </br>
	 * The account to perform this action is made following the equation: </br>
	 * </br>
	 * &emsp; credited amount = (number of players - 1) * amount
	 * </p>
	 * 
	 * @param jogo - JogoFacade
	 */
	@Override
	public void acao(Jogador j) {
		System.out.println(this.descricao);
		for(Jogador jogador: JogoFacade.getInstance().getJogadores()) {
			if(!jogador.equals(j)) {
				jogador.pagar(j, this.valor);
			}
		}
	}

}