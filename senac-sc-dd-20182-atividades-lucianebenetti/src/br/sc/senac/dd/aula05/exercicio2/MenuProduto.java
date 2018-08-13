package br.sc.senac.dd.aula05.exercicio2;

import javax.swing.JOptionPane;

public class MenuProduto {
	ProdutoVO produtoVO = new ProdutoVO();

	public void apresentaMenuProduto() {
		int opcao = -1;
		
		while (opcao !=5) {
			try {
				opcao = Integer.parseInt(JOptionPane.showInputDialog(criarMenuProduto()));
			}catch(NumberFormatException ex){
				JOptionPane.showMessageDialog(null, "O n�mero digitado deve ser um inteiro entre 1 e 5;");
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
	
	private void consultarProduto() {
		
		produtoVO.setIdProduto(Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o ID do funcion�rio para consultado.")));
		
		ProdutoDAO consultarProduto = new ProdutoDAO();
		consultarProduto.consultar();
	}

	private void atualizarProduto() {

		produtoVO.setIdProduto(Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o ID do funcion�rio para atualizar.")));
		produtoVO.setNome(JOptionPane.showInputDialog(null, "Digite o nome do funcion�rio."));
		produtoVO.setSecao(JOptionPane.showInputDialog(null,"Digite a se��o."));
		produtoVO.setValor(Double.parseDouble(JOptionPane.showInputDialog(null,"Digite o valor do produto.")));
 
		ProdutoDAO atualizarProduto = new ProdutoDAO();
		atualizarProduto.atualizar(produtoVO);
	}

	private void excluirProduto() {
		
		produtoVO.setIdProduto(Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o ID do funcion�rio para excluir.")));
		
		ProdutoDAO excluirProduto = new ProdutoDAO();
		excluirProduto.delete();
		
	}

	private void cadastrarProduto() {
		ProdutoVO produtoVO = new ProdutoVO();
		produtoVO.setNome(JOptionPane.showInputDialog(null, "Digite o nome do funcion�rio."));
		produtoVO.setSecao(JOptionPane.showInputDialog(null,"Digite o CPF."));
		produtoVO.setValor(Double.parseDouble(JOptionPane.showInputDialog(null,"Digite o telefone.")));
		
		ProdutoDAO inserirProduto = new ProdutoDAO();
		inserirProduto.insert(produtoVO);
		
	}

	private String criarMenuProduto() {
		String mensagem = "Menu Produto";
		mensagem += "\n Op��es:";
		mensagem += "\n 1 - Cadastrar Produto.";
		mensagem += "\n 2 - Excluir Produto.";
		mensagem += "\n 3 - Alterar Cadastro de Produto.";
		mensagem += "\n 4 - Exibir Cadastro de Produto.";
		mensagem += "\n 5 - Sair.";
		mensagem +="\n Digite a Op��o: ";
		
		return mensagem;
	}	

}
