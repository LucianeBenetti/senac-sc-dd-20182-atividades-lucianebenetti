package br.sc.senac.dd.aula05.exercicio2;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class MenuFuncionario{
	
	Scanner teclado = new Scanner(System.in);

	public void apresentaMenuFuncionario() {
	
		int opcao = -1;
		
		try {
			opcao = Integer.parseInt(JOptionPane.showInputDialog(criarMenuFuncionario()));
		}catch(NumberFormatException ex){
			JOptionPane.showMessageDialog(null, "O número digitado deve ser um inteiro entre 1 e 5;");
		}
		
		while (opcao !=5) {
			switch(opcao) {
			case 1:{
				this.cadastrarFuncionario();
				break;
			}
			case 2:{
				this.excluirFuncionario();
				break;
			}
			case 3:{
				this.atualizarFuncionario();
				break;
			}
			case 4:{
				this.consultarFuncionario();
				break;
			}
			default:{
				JOptionPane.showMessageDialog(null, "Opção Inválida!");
			}
			}
		}
		int resposta = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair do sistema?");
			if (resposta == 0) {
				JOptionPane.showMessageDialog(null, "Você foi desconectado do sistema.");
			}else if (resposta == 1) {
				JOptionPane.showInputDialog(criarMenuFuncionario());
			}
	}
	
		private Object criarMenuFuncionario() {
			String mensagem = "Menu Funcionário";
			mensagem += "\n Opções:";
			mensagem += "\n 1 - Cadastrar Funcionário.";
			mensagem += "\n 2 - Excluir Funcionário.";
			mensagem += "\n 3 - Alterar Cadastro de Funcionário.";
			mensagem += "\n 4 - Exibir Cadastro de Funcionário.";
			mensagem += "\n 5 - Sair.";
			mensagem +="\n Digite a Opção: ";
			
			return mensagem;
		}	
	

	private void consultarFuncionario() {
		// TODO Auto-generated method stub
		
	}

	private void atualizarFuncionario() {
		// TODO Auto-generated method stub
		
	}

	private void excluirFuncionario() {
		// TODO Auto-generated method stub
		
	}

	private void cadastrarFuncionario() {
		// TODO Auto-generated method stub
		
	}


}
