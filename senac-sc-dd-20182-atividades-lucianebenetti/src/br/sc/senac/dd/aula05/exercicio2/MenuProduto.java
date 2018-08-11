package br.sc.senac.dd.aula05.exercicio2;

import javax.swing.JOptionPane;

public class MenuProduto {

	public void apresentaMenuProduto() {
		int opcao = -1;
		
		while (opcao !=5) {
			try {
				opcao = Integer.parseInt(JOptionPane.showInputDialog(criarMenuProduto()));
			}catch(NumberFormatException ex){
				JOptionPane.showMessageDialog(null, "O número digitado deve ser um inteiro entre 1 e 5;");
			}
			switch(opcao) {
			case 1:{
				this.cadastrarProduto();
				break;
			}
			case 2:{
				this.excluirProduto();
				break;
			}
			case 3:{
				this.atualizarProduto();
				break;
			}
			case 4:{
				this.consultarProduto();
				break;
			}
			case 5: {
				int resposta = JOptionPane.showConfirmDialog(null, "Tem certeza?");
				if(resposta == 0) {
					JOptionPane.showMessageDialog(null, "Você foi desconectado do sistema!");
				}
				break;
			}
			default: {
				JOptionPane.showMessageDialog(null, "Opção Inválida");
				break;
				}
			}
		}
	}
	
	private void consultarProduto() {
		// TODO Auto-generated method stub
		
	}

	private void atualizarProduto() {
		// TODO Auto-generated method stub
		
	}

	private void excluirProduto() {
		// TODO Auto-generated method stub
		
	}

	private void cadastrarProduto() {
		// TODO Auto-generated method stub
		
	}

	private String criarMenuProduto() {
		String mensagem = "Menu Produto";
		mensagem += "\n Opções:";
		mensagem += "\n 1 - Cadastrar Produto.";
		mensagem += "\n 2 - Excluir Produto.";
		mensagem += "\n 3 - Alterar Cadastro de Produto.";
		mensagem += "\n 4 - Exibir Cadastro de Produto.";
		mensagem += "\n 5 - Sair.";
		mensagem +="\n Digite a Opção: ";
		
		return mensagem;
	}	

}
