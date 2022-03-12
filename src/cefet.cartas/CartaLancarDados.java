/* subclasse de SorteOuReves
herda os atributos de de descricao e posicao
eh necessario implementar o metodo acao, pois seu comportamento 
tambem eh herdado */
package cefet.cartas;

import cefet.jogo.Jogador;
import cefet.jogo.JogoFacade;

/* metodo construtor da classe CartaLancarDados */
public class CartaLancarDados extends SorteOuReves {
	/* descreve a acao da carta sorte ou reves */
  @param description 
  /* representa a posicao na sorte ou fila de reves */
  @param posision
	 
  /* implementa o metodo acao, ou seja, realiza uma acao 
    com base no tipo e descricao  */
	public CartaLancarDados(String descricao, String valor) {
		super(descricao, valor);
	}
  /* permite o jogador usar o dado novamente */
	@param jogo
	@Override
	public void acao(Jogador j) {
		j.jogada(j.lancaDado(), j.lancaDado(),JogoFacade.getInstance());
	}
}
