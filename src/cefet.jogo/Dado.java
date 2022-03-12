package cefet.jogo;

import java.util.Random;

/**
 * <p>
 * This class represents a given and its only function is to generate random
 * numbers.
 * </p>
 */
public class Dado {

	/**
	 * <p>
	 * A number between one and six is raffled. </br>
	 * This value represents the value sorted when rolling a dice.
	 * </p>
	 * 
	 * @return valor - an integer value from 1 to 6.
	 */
	public int lancaDado() {
		Random aleatorio = new Random();
		int valor = aleatorio.nextInt(6) + 1;
		return valor;
	}

}