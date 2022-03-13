package logradouros;


import jogo.JogoFacade;

/* representa o terreno */
public class Terreno extends TituloStrategy implements Posicao {

	private int aluguel;
	private int aluguelComUmaCasa;
	private int aluguelComDuasCasa;
	private int aluguelComTresCasa;
	private int aluguelComQuatroCasa;
	private int aluguelComHotel;
	private int precoDaCasa;
	private String cor;
	private int numeroDeCasas;

	/* construtor da classe Terreno */
	public Terreno(int numeroDePosicao, String nomeDoTerreno, int precoDaPropriedade, int aluguel,
			int aluguelComUmaCasa, int aluguelComDuasCasas, int aluguelComTresCasas, int aluguelComQuatroCasas,
			int aluguelComHotel, int precoDaCasa, String cor) {
		/* permite a inicializacao do numero da posicao, o nome do terreno, o preco da propriedade, aluguel, 
		aluguel com uma casa, aluguel com duas casas, aluguel com tres casas, aluguel com quatro casas,
		aluguel com um hotel, o dono e o atributo cor */
		this.posicao = numeroDePosicao;
		this.nomeDoTitulo = nomeDoTerreno;
		this.precoDaPropriedade = precoDaPropriedade;
		this.aluguel = aluguel;
		this.aluguelComUmaCasa = aluguelComUmaCasa;
		this.aluguelComDuasCasa = aluguelComDuasCasas;
		this.aluguelComTresCasa = aluguelComTresCasas;
		this.aluguelComQuatroCasa = aluguelComQuatroCasas;
		this.aluguelComHotel = aluguelComHotel;
		this.precoDaCasa = precoDaCasa;
		this.cor = cor;
		this.dono = null;
	}

	/* um jogador paga aluguel a outro jogador */
	@Override
	public void factoryMethod(JogoFacade jogo) {
		jogo.JogadorAtual().pagar(this.dono, this.aluguel);
		System.out.println("Pagou $" + this.aluguel + " ao jogador " + this.dono);
	}

	/* mostra os titulos do jogador */
	@Override
	public String mostrarTitulo() {
		return "[" + this.nomeDoTitulo + "] propriedade " + this.cor + " aluguel " + this.aluguel;
	}

	@Override
	public int getNumeroDePosicao() {
		return this.posicao;
	}

	@Override
	public String toString() {
		return this.posicao + " - " + this.nomeDoTitulo + " " + "(" + this.cor + ")";
	}

	@Override
	public String getTipo() {
		return "Terreno";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Terreno other = (Terreno) obj;
		if (aluguel != other.aluguel)
			return false;
		if (aluguelComDuasCasa != other.aluguelComDuasCasa)
			return false;
		if (aluguelComHotel != other.aluguelComHotel)
			return false;
		if (aluguelComQuatroCasa != other.aluguelComQuatroCasa)
			return false;
		if (aluguelComTresCasa != other.aluguelComTresCasa)
			return false;
		if (aluguelComUmaCasa != other.aluguelComUmaCasa)
			return false;
		if (cor == null) {
			if (other.cor != null)
				return false;
		} else if (!cor.equals(other.cor))
			return false;
		if (precoDaCasa != other.precoDaCasa)
			return false;
		return true;
	}

	@Override
	public boolean hasCor() {
		return true;
	}

	public String getCor() {
		return this.cor;
	}

	@Override
	public boolean hasTerreno() {
		return true;
	}

	/* mostra preco do aluguel */
	public int precoAtualAluguel() {
		if (this.numeroDeCasas == 0) {
			return this.aluguel;
		} else if (this.numeroDeCasas == 1) {
			return this.aluguelComUmaCasa;
		} else if (this.numeroDeCasas == 2) {
			return this.aluguelComDuasCasa;
		} else if (this.numeroDeCasas == 3) {
			return this.aluguelComTresCasa;
		} else if (this.numeroDeCasas == 4) {
			return this.aluguelComQuatroCasa;
		} else {
			return this.aluguelComHotel;
		}
	}

	/* permite construir */
	public void construir() {
		boolean pagou = JogoFacade.getInstance().JogadorAtual().pagar(this.precoDaCasa);
		if (pagou == true && this.numeroDeCasas < 5) {
			this.numeroDeCasas += 1;
			System.out.println("Construcao realizada com sucesso!");
		} else {
			System.out.println("Nao foi possivel realizar a construcao!");
		}
	}

	public int getNumeroDeCasas() {
		return this.numeroDeCasas;
	}

	public int getValorDaConstrucao() {
		return this.precoDaCasa;
	}
	
	/* permite vender casas */
	public void vender() {
		if ( this.numeroDeCasas >= 1) {
			JogoFacade.getInstance().JogadorAtual().pagar(this.precoDaCasa);
			this.numeroDeCasas -= 1;
			System.out.println("Venda realizada com sucesso!");
		} else {
			System.out.println("Nao foi possivel realizar a venda!");
		}
	}
}