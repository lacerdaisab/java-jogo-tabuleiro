/* subclasse de SorteOuReves
herda os atributos de de descricao e posicao
eh necessario implementar o metodo acao, pois seu comportamento 
tambem eh herdado */
package cartas;

import jogo.Jogador;

/* metodo construtor da classe HabeasCorpus */
public class HabeasCorpus extends SorteOuReves {
	public HabeasCorpus(String descricao, String valor) {
		super(descricao, valor);
	}
	@Override
	/* implementa o metodo acao, ou seja, realiza uma acao 
	com base no tipo e descricao  */
	public void acao(Jogador j) {
		/* adiciona um atributo a classe Jogador e mostra a descricao da carta */
		j.addCarta();
		System.out.println(this.descricao);
	}
}
