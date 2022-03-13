package opcoes;

import jogo.JogoFacade;

/* representa quando o jogador tem que pagar algum valor */
public class Pagar implements Opcao {
	/* o jogador paga um valor e a partida continua */
	@Override
	public boolean fazerOP() {
		JogoFacade jogo = JogoFacade.getInstance();		
		jogo.JogadorAtual().pagar(50);
		int novoDado = jogo.JogadorAtual().lancaDado();
		int novoDado2 = jogo.JogadorAtual().lancaDado();
		jogo.JogadorAtual().jogada(novoDado, novoDado2, jogo);
		jogo.getPosicaoAtual().evento(jogo);
		return true;
	}
}