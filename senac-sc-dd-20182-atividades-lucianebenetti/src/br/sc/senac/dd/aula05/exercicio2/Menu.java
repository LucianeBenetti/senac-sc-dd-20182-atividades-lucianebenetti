package br.sc.senac.dd.aula05.exercicio2;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class Menu {
	Scanner teclado = new Scanner (System.in);
	
	public void apresentaMenu() {
		int opcao = -1;
		try {
			opcao = Integer.parseInt(JOptionPane.showInputDialog(criarOpcaoMenu()));
		}catch(NumberFormatException ex){
			JOptionPane.showInputDialog(null, "O n�mero informado deve ser um n�mero inteiro entre 1 e 3.");
		}
		while (opcao!=3) {
			
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
			default:{
				JOptionPane.showMessageDialog(null,"Op��o inv�lida.");
			}
			}
		}
		int resposta = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair?");
		
		if (resposta == 0) {
			JOptionPane.showMessageDialog(null,"Voc� foi desconectado do sistema.");
		}else if (resposta == 1){
			JOptionPane.showInputDialog(null, criarOpcaoMenu());
		}
	}

	public String criarOpcaoMenu() {
		String mensagem = "Sistema de Controle de Supermercado";
		mensagem += "\n Op��es:";
		mensagem += "\n 1 - Menu Funcin�rio.";
		mensagem += "\n 2 - Menu Produto.";
		mensagem += "\n 3 - Sair";
		mensagem +="\n Digite a Op��o: ";
		
		return mensagem;

	}

}
