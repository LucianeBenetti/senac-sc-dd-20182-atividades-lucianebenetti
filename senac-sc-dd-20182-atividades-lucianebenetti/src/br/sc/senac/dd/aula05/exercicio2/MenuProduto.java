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
				}
			}
		}
	}
	
	private void consultarProduto() {
		// TODO Auto-generated method stub
	}

	private void atualizarProduto() {
		ProdutoVO produtoVO = new ProdutoVO();
		produtoVO.setIdProduto(Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o ID do funcionário para atualizar.")));
		produtoVO.setNome(JOptionPane.showInputDialog(null, "Digite o nome do funcionário."));
		produtoVO.setSecao(JOptionPane.showInputDialog(null,"Digite a seção."));
		produtoVO.setValor(Double.parseDouble(JOptionPane.showInputDialog(null,"Digite o valor do produto.")));
 
		ProdutoDAO atualizarProduto = new ProdutoDAO();
		atualizarProduto.atualizar();
	}

	private void excluirProduto() {
		ProdutoVO produtoVO = new ProdutoVO();
		produtoVO.setIdProduto(Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o ID do funcionário para excluir.")));
		
		ProdutoDAO excluirProduto = new ProdutoDAO();
		excluirProduto.deletar();
		
	}

	private void cadastrarProduto() {
		ProdutoVO produtoVO = new ProdutoVO();
		produtoVO.setNome(JOptionPane.showInputDialog(null, "Digite o nome do funcionário."));
		produtoVO.setSecao(JOptionPane.showInputDialog(null,"Digite o CPF."));
		produtoVO.setValor(Double.parseDouble(JOptionPane.showInputDialog(null,"Digite o telefone.")));
		
		ProdutoDAO inserirProduto = new ProdutoDAO();
		inserirProduto.inserir();
		
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
