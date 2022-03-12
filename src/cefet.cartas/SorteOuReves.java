/* classe responsavel por criar cartas de sorte ou reves
	por ser abstrato nao pode ser instanciado, entao deve ser
	usado para ter herancas com ele */
package cefet.cartas;

import cefet.jogo.Jogador;

public abstract class SorteOuReves {
	/* atributo descricao da carta */
	protected String descricao;
	/* atributo posicao da carta em sorte ou reves */
	protected int valor;
	/* metodo construtor */
	public SorteOuReves(String descricao, String valor) {
		this.descricao = descricao;
		this.valor = Integer.parseInt(valor);
	}
	/* metodo de acao abstrato
	realiza uma acao com base no tipo e descricao
	exemplo: a classe tipo pagamento deve pagar um valor definido por sua descricao */
	public abstract void acao(Jogador j);
}