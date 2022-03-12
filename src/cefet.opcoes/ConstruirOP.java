package cefet.opcoes;

import cefet.exceptions.NaoTemTerrenosException;
import cefet.jogo.JogoFacade;

/* representa quando o jogador esta ou nao capaz de construir uma casa em sua propriedade */
public class ConstruirOP implements Opcao {
	/* metodo que o jogador sera capaz de construir casas em suas propriedade */
	@Override
	public boolean fazerOP() {
		JogoFacade jogo = JogoFacade.getInstance();
		int entrada = -1;
		while(entrada != 0) {
			System.out.println(jogo.JogadorAtual().getNome()+" possui "+jogo.JogadorAtual().getSaldo());
			System.out.println("Escolha onde quer construir:");
			jogo.JogadorAtual().mostrarTerrenos();
			System.out.println("Digite o numero da propriedade (0 para sair):");
			try {
				entrada = jogo.inputInt();
			} catch (NumberFormatException e1) {
				System.err.println(e1.getMessage());
			}
			try {
				if(entrada>= 1 && entrada <= jogo.JogadorAtual().getNumeroDeTerrenos()) {
					jogo.JogadorAtual().escolheTerreno(entrada).construir();
				}else if(entrada != 0){
					System.err.print("Opcao invalida!\n");
				} 
			}catch (NaoTemTerrenosException e) {
				System.err.print(e.getMessage()+"\n");
			}
			
		}
		return true;
	}

}