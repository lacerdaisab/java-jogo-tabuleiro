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
public class Receba extends SorteOuReves {

	/**
	 * <p>
	 * Constructor method of class Receba.
	 * </p>
	 * 
	 * @param description - A String with representing the description of the action
	 *                    taken by the lucky card or setback - type String
	 * @param posision    - A String with representing the position in the luck or
	 *                    setback queue.
	 */
	public Receba(String descricao, String valor) {
		super(descricao, valor);
	}

	/**
	 * <p>
	 * This method implement the method acao, therefore it must realize a action
	 * with base in your type and description.
	 * </p>
	 * <p>
	 * It is impressed that the player has received an amount from the bank. </br>
	 * Then amount is fact credited to the player's account.
	 * </p>
	 * 
	 * @param jogo - JogoFacade
	 */
	@Override
	public void acao(Jogador j) {
		System.out.println(this.descricao + "\n Voc� recebeu " + this.valor + " do banco.");
		j.receber(this.valor);
	}

}