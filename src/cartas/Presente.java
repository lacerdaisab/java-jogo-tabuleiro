/* subclasse de SorteOuReves
herda os atributos de de descricao e posicao
eh necessario implementar o metodo acao, pois seu comportamento 
tambem eh herdado */
package cartas;

import jogo.Jogador;
import jogo.JogoFacade;

/* metodo construtor da classe Presente */
public class Presente extends SorteOuReves {
	public Presente(String descricao, String valor) {
		super(descricao, valor);
	}
	@Override
  /* implementa o metodo acao, ou seja, realiza uma acao 
  com base no tipo e descricao  */
  public void acao(Jogador j) {
	  /* desconta da conta de todos os jogadores e coloca na conta de um jogador */
	  System.out.println(this.descricao);
	  /* equacao: */
	  /* valor creditado = (numero de jogadores - 1) * valor  */
		for(Jogador jogador: JogoFacade.getInstance().getJogadores()) {
			if(!jogador.equals(j)) {
				jogador.pagar(j, this.valor);
			}
		}
	}
}