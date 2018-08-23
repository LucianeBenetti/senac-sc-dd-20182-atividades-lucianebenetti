package br.sc.senac.dd.aula05.exercicio2;

import javax.swing.JOptionPane;

public class Menu {
	
	public void apresentaMenu() {
		int opcao = -1;
		
		while (opcao!=3) {
		 	
			try {
				String valorDigitado = JOptionPane.showInputDialog(criarOpcaoMenu());
				if(valorDigitado !=null) {
					opcao = Integer.parseInt(valorDigitado);
				}else {
					break;
				}
			}catch(NumberFormatException ex){
				JOptionPane.showMessageDialog(null, "O n�mero informado deve ser um n�mero inteiro entre 1 e 3.");
			}
			
			switch(opcao) {
			
			case 1:{
				MenuFuncionario menuFuncionario = new MenuFuncionario();
				menuFuncionario.apresentaMenuFuncionario();
				break;
			}
			case 2:{
				MenuProduto menuProduto = new MenuProduto();
				menuProduto.apresentaMenuProduto();
				break;
			}
			case 3:{
				int resposta = JOptionPane.showConfirmDialog(null, "Tem certeza?");
				if(resposta == 0) {
					JOptionPane.showMessageDialog(null, "Voc� foi desconectado do sistema!");
				}
				break;
			}
			default: {
				JOptionPane.showMessageDialog(null, "Op��o Inv�lida");
				}
			}
		}
	}

	public String criarOpcaoMenu() {
		String mensagem = "Sistema de Gest�o de Supermercado";
		mensagem += "\n Op��es:";
		mensagem += "\n 1 - Menu Funcion�rio.";
		mensagem += "\n 2 - Menu Produto.";
		mensagem += "\n 3 - Sair";
		mensagem +="\n Digite a Op��o: ";
		
		return mensagem;

	}

}
