package cefet.jogo;

import java.util.Random;

/* representa um dado e gera numeros */
public class Dado {
	/* representa o valor sorteado quando o dado eh utilizado */
	public int lancaDado() {
		/* sorteia um numero entre 1 e 6 */
		Random aleatorio = new Random();
		int valor = aleatorio.nextInt(6) + 1;
		/* retorna um valor inteiro entre 1 e 6 */
		return valor;
	}
}