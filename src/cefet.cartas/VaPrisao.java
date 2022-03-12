/* subclasse de SorteOuReves
herda os atributos de de descricao e posicao
eh necessario implementar o metodo acao, pois seu comportamento 
tambem eh herdado */
package cefet.cartas;

import cefet.jogo.Jogador;

/* metodo construtor da classe VaPrisao */
public class VaPrisao extends SorteOuReves {
	public VaPrisao(String descricao, String valor) {
		super(descricao, valor);
	}
	@Override
  /* implementa o metodo acao, ou seja, realiza uma acao 
  com base no tipo e descricao  */
	public void acao(Jogador j) {
    /* muda a posicao do jogador e o leva para prisao */
		System.out.println(this.descricao);
		j.vaiParaPrisao();
	}
}
