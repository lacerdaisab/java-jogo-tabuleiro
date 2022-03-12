/* subclasse de SorteOuReves
herda os atributos de de descricao e posicao
eh necessario implementar o metodo acao, pois seu comportamento 
tambem eh herdado */
package cefet.cartas;

import cefet.jogo.Jogador;
import cefet.jogo.JogoFacade;

/* metodo construtor da classe CartaLancarDados */
public class CartaLancarDados extends SorteOuReves {
	public CartaLancarDados(String descricao, String valor) {
    super(descricao, valor);
	}
	@Override
  /* implementa o metodo acao, ou seja, realiza uma acao 
  com base no tipo e descricao  */
	public void acao(Jogador j) {
    /* permite o jogador usar o dado novamente */
		j.jogada(j.lancaDado(), j.lancaDado(),JogoFacade.getInstance());
	}
}
