package cefet.logradouros;

import cefet.jogo.Jogador;

/* representa a contador que permite o jogador de construir casas */
public class Construtora {
	private int CONT_ROXO = 3;
	private int CONT_CIANO = 3;
	private int CONT_TURQUESA = 2;
	private int CONT_LILAS = 3;
	private int CONT_LARANJA = 2;
	private int CONT_VERMELHO = 2;
	private int CONT_VERDE = 4;
	private int CONT_AMARELO = 3;
	private Jogador jogador;

	public Construtora(Jogador j) {
		this.jogador = j;
	}

	/* conta quantas casas podem ser construidas em cada cor dos terrenos */
	public boolean podeConstruir() {
		for (TituloStrategy x : jogador.getTitulos()) {
			if (x.hasCor()) {
				String cor = ((Terreno) x).getCor();
				switch (cor) {
				case "roxo":
					CONT_ROXO -= 1;
					break;
				case "ciano":
					CONT_CIANO -= 1;
					break;
				case "turquesa":
					CONT_TURQUESA -= 1;
					break;
				case "laranja":
					CONT_LARANJA -= 1;
					break;
				case "vermelho":
					CONT_VERMELHO -= 1;
					break;
				case "amarelo":
					CONT_AMARELO -= 1;
					break;
				case "verde":
					CONT_VERDE -= 1;
					break;
				case "lilas":
					CONT_LILAS -= 1;
					break;

				}
			}

		}
		if (CONT_ROXO == 0 || CONT_VERDE == 0 || CONT_AMARELO == 0 || CONT_VERMELHO == 0 || CONT_LARANJA == 0
				|| CONT_LILAS == 0 || CONT_CIANO == 0 || CONT_TURQUESA == 0) {
			return true;
		}
		return false;
	}

	/* permite o jogador vender as propriedades */
	public boolean podeVender() {
		for (TituloStrategy x : jogador.getTitulos()) {
			if (x.hasTerreno()) {
				Terreno t = ((Terreno) x);
				if (t.getNumeroDeCasas() >= 1) {
					return true;
				}
			}

		}

		return false;
	}
}