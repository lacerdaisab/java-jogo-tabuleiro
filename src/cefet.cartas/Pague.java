package cefet.cartas;

import cefet.jogo.Jogador;


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
public class Pague extends SorteOuReves {

	/**
	 * <p>
	 * Constructor method of class Pague.
	 * </p>
	 * 
	 * @param description - A String with representing the description of the action
	 *                    taken by the lucky card or setback - type String
	 * @param posision    - A String with representing the position in the luck or
	 *                    setback queue.
	 */
	public Pague(String descricao, String valor) {
		super(descricao, valor);
	}

	/**
	 * <p>
	 * This method implement the method acao, therefore it must realize a action
	 * with base in your type and description.
	 * </p>
	 * <p>
	 * An amount described in the lucky or setback card will be deducted from the
	 * player's account.
	 * </p>
	 * 
	 * @param jogo - JogoFacade
	 */
	@Override
	public void acao(Jogador j) {
		j.pagar(valor);
		System.out.println(this.descricao + "\n" + "Voc� pagou " + this.valor);
	}

}