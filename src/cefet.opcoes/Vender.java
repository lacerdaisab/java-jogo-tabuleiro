package cefet.opcoes;

import cefet.exceptions.NaoTemTerrenosException;
import cefet.jogo.JogoFacade;

/**
 * <p>
 * Represents when the player wants to sell their property
 * </p>
 *
 */
public class Vender implements Opcao{

	/**
	 * <p>
	 * The player sells their property, and will receive the value relative to the selling price.
	 * If the player does not have any property, then the method will throws an exception.
	 * </p>
	 * @return boolean
	 */
	@Override
	public boolean fazerOP() {
		JogoFacade jogo = JogoFacade.getInstance();
		int entrada = -1;
		while(entrada != 0) {
			System.out.println(jogo.JogadorAtual().getNome()+" possui "+jogo.JogadorAtual().getSaldo());
			System.out.println("Escolha onde quer vender:");
			jogo.JogadorAtual().mostrarTerrenos();
			System.out.println("Digite o n�mero da propriedade (0 para sair):");
			try {
				entrada = jogo.inputInt();
			} catch (NumberFormatException e1) {
				System.err.println(e1.getMessage());
			}
			try {
				if(entrada>= 1 && entrada <= jogo.JogadorAtual().getNumeroDeTerrenos()) {
					jogo.JogadorAtual().escolheTerreno(entrada).vender();
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
