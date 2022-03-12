package cefet.opcoes;

import cefet.exceptions.NaoTemTerrenosException;
import cefet.jogo.JogoFacade;

/* representa quando o jogador quer vender sua propriedade */
public class Vender implements Opcao{
	/* vende a propriedade e recebe o valor relativo ao preco vendido */
	@Override
	public boolean fazerOP() {
		JogoFacade jogo = JogoFacade.getInstance();
		int entrada = -1;
		while(entrada != 0) {
			System.out.println(jogo.JogadorAtual().getNome()+" possui "+jogo.JogadorAtual().getSaldo());
			System.out.println("Escolha onde quer vender:");
			jogo.JogadorAtual().mostrarTerrenos();
			System.out.println("Digite o numero da propriedade (0 para sair):");
			try {
				entrada = jogo.inputInt();
			} catch (NumberFormatException e1) {
				System.err.println(e1.getMessage());
			}
			try {
				if(entrada>= 1 && entrada <= jogo.JogadorAtual().getNumeroDeTerrenos()) {
					jogo.JogadorAtual().escolheTerreno(entrada).vender();
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
