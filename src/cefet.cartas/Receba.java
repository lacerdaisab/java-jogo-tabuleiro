/* subclasse de SorteOuReves
herda os atributos de de descricao e posicao
eh necessario implementar o metodo acao, pois seu comportamento 
tambem eh herdado */
package cefet.cartas;

import cefet.jogo.Jogador;

/* metodo construtor da classe Receba */
public class Receba extends SorteOuReves {
	public Receba(String descricao, String valor) {
		super(descricao, valor);
	}
	@Override
  /* implementa o metodo acao, ou seja, realiza uma acao 
  com base no tipo e descricao  */
	public void acao(Jogador j) {
    /* imprime que o jogador recebeu uma quantia do banco */
    System.out.println(this.descricao + "\n Voce recebeu " + this.valor + " do banco.");
    /* coloca o dinheiro na conta do jogador */
		j.receber(this.valor);
	}
}