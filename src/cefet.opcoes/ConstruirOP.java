package cefet.opcoes;

import cefet.exceptions.NaoTemTerrenosException;
import cefet.jogo.JogoFacade;

/**
 * <p>
 * Represents when the player is, or not, able to build a house on their property.
 * </p>
 */
public class ConstruirOP implements Opcao {

	/**
	 * <p>
	 * In this method, the player will be able to build houses on their property.
	 * </p>
	 * @return boolean
	 */
	@Override
	public boolean fazerOP() {
		JogoFacade jogo = JogoFacade.getInstance();
		int entrada = -1;
		while(entrada != 0) {
			System.out.println(jogo.JogadorAtual().getNome()+" possui "+jogo.JogadorAtual().getSaldo());
			System.out.println("Escolha onde quer construir:");
			jogo.JogadorAtual().mostrarTerrenos();
			System.out.println("Digite o n�mero da propriedade (0 para sair):");
			try {
				entrada = jogo.inputInt();
			} catch (NumberFormatException e1) {
				System.err.println(e1.getMessage());
			}
			try {
				if(entrada>= 1 && entrada <= jogo.JogadorAtual().getNumeroDeTerrenos()) {
					jogo.JogadorAtual().escolheTerreno(entrada).construir();
				}else if(entrada != 0){
					System.err.print("Op��o inv�lida!\n");
				} 
			}catch (NaoTemTerrenosException e) {
				System.err.print(e.getMessage()+"\n");
			}
			
		}
		return true;
	}

}