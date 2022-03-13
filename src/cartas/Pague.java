/* subclasse de SorteOuReves
herda os atributos de de descricao e posicao
eh necessario implementar o metodo acao, pois seu comportamento 
tambem eh herdado */
package cartas;

import jogo.Jogador;

/* metodo construtor da classe Pague */
public class Pague extends SorteOuReves {
	public Pague(String descricao, String valor) {
		super(descricao, valor);
	}
	@Override
	/* implementa o metodo acao, ou seja, realiza uma acao 
	com base no tipo e descricao  */
	public void acao(Jogador j) {
		/* descreve quanto o jogador vai ganhar ou perder com base nas cartas sorte ou reves */
		j.pagar(valor);
		System.out.println(this.descricao + "\n" + "Voce pagou " + this.valor);
	}
}