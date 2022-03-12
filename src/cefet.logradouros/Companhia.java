package cefet.logradouros;

import cefet.jogo.JogoFacade;

/**
 * <p>
 * Represents the each one of the companies.
 * </p>
 *
 */
public class Companhia extends TituloStrategy implements Posicao {

	private int multiplicador;

	/**
	 * <p>
	 * Constructor from class Companhia, enables initialization of position number,
	 * company name, property price, the owner and multiplier attributes.
	 * </p>
	 * 
	 * @param int     numeroDePosicao - position name
	 * @param String  nomeDaCompanhia - company name
	 * @param int     precoDaPropriedade - property price
	 * @param Jogador dono - company's owner
	 * @param int     multiplicador - the rent multiplier
	 */
	public Companhia(int numeroDePosicao, String nomeDaCompanhia, int precoDaPropriedade, int multiplicadoor) {
		this.posicao = numeroDePosicao;
		this.nomeDoTitulo = nomeDaCompanhia;
		this.precoDaPropriedade = precoDaPropriedade;
		this.dono = null;
		this.multiplicador = multiplicadoor;
	}

	/**
	 * <p>
	 * 
	 * </p>
	 */
	@Override
	public void factoryMethod(JogoFacade jogo) {
		int sumDados = jogo.getUltimosDados()[0] + jogo.getUltimosDados()[1];
		int totalAhPagar = this.multiplicador * sumDados;
		jogo.JogadorAtual().pagar(this.dono, totalAhPagar);
		System.out.println("Pagou $" + totalAhPagar + " ao jogador " + this.dono);
	}

	/**
	 * Shows the player's titles.
	 */
	@Override
	public String mostrarTitulo() {
		return "[" + this.nomeDoTitulo + "] multiplicador de " + this.multiplicador;
	}

	@Override
	public int getNumeroDePosicao() {
		return this.posicao;
	}

	@Override
	public String getTipo() {
		return "Companhia";
	}

	public int getMultiplicador() {
		return this.multiplicador;
	}

	public int getPrecoDaPropriedade() {
		return this.precoDaPropriedade;
	}

	@Override
	public String toString() {
		return this.posicao + " - " + this.nomeDoTitulo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + multiplicador;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Companhia other = (Companhia) obj;
		if (multiplicador != other.multiplicador)
			return false;
		return true;
	}

	@Override
	public boolean hasCor() {
		return false;
	}

	@Override
	public boolean hasTerreno() {
		return false;
	}

}