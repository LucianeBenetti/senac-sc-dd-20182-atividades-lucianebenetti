
package br.sc.senac.dd.aula05.exercicio2.View;

import java.util.List;
import javax.swing.JOptionPane;

import br.sc.senac.dd.aula05.exercicio2.ModelDAO.ProdutoDAO;
import br.sc.senac.dd.aula05.exercicio2.ModelVO.ProdutoVO;

public class MenuProduto {
	
	public void apresentaMenuProduto() {
		int opcao = -1;
		
		while (opcao !=6) {
			try {
				String valorDigitado = JOptionPane.showInputDialog(criarMenuProduto());
				if(valorDigitado !=null) {
					opcao = Integer.parseInt(valorDigitado);
				}else {
					break;
				}
			}catch(NumberFormatException ex){
				JOptionPane.showMessageDialog(null, "O n�mero digitado deve ser um inteiro entre 1 e 5;");
			}
			switch(opcao) {
			case 1:
				this.cadastrarProduto();
				break;
			
			case 2:
				this.excluirProduto();
				break;
			
			case 3:
				this.atualizarProduto();
				break;
			
			case 4:
				this.consultarProduto();
				break;
			
			case 5:
				this.consultarTodosProduto();
				break;
			
			case 6: 
				int resposta = JOptionPane.showConfirmDialog(null, "Tem certeza?");
				if(resposta == 0) {
					JOptionPane.showMessageDialog(null, "Voc� foi desconectado do Menu Produto!");
				}
				break;
			
			default: 
				JOptionPane.showMessageDialog(null, "Op��o Inv�lida");
			}
		}
	}
	
	private void cadastrarProduto() {
		ProdutoVO produtoVO = new ProdutoVO();
		ProdutoDAO produtoDAO = new ProdutoDAO();
		
		//C�digo de valida��o opcional, n�o exigido no exerc�cio. Fiz somente para treinar.
		//produtoVO.setIdProduto(Integer.parseInt((JOptionPane.showInputDialog(null,"Digite o ID do Produto."))));
		//if (produtoDAO.existeRegistroPorIdProduto(produtoVO.getIdProduto())){
		//	JOptionPane.showMessageDialog(null, "Produto j� cadastrado! Tente novamente.");
		//}else{
		
		String nomeDigitado =JOptionPane.showInputDialog(null, "Digite o nome do produto.");
			if(nomeDigitado != null) {
				produtoVO.setNome(nomeDigitado);
			}else {
				this.apresentaMenuProduto();
			}
					
		String secaoDigitada = (JOptionPane.showInputDialog(null,"Digite a se��o do produto."));
			if(secaoDigitada != null) {
				produtoVO.setSecao(secaoDigitada);
			}else {
				this.apresentaMenuProduto();
			}
		
		String valorDigitado = JOptionPane.showInputDialog(null,"Digite o valor do produto.");
			if(valorDigitado != null) {
				produtoVO.setValor(Double.parseDouble(valorDigitado));
			}else {
				this.apresentaMenuProduto();
			}	
						 
		int idGerado = produtoDAO.insert(produtoVO);
		
		if(idGerado > 0) {
			JOptionPane.showMessageDialog(null,"Produto cadastrado com sucesso!");
		}else {
			JOptionPane.showMessageDialog(null,"Tente novamente!");
		}
	}
	
	private void excluirProduto() {
		ProdutoVO produtoVO = new ProdutoVO();
		ProdutoDAO produtoDAO = new ProdutoDAO();
		
		produtoVO.setIdProduto(Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o ID do Produto para excluir.")));
		if(produtoDAO.existeRegistroPorIdProduto(produtoVO.getIdProduto())) {
			produtoDAO.delete(produtoVO.getIdProduto());
			JOptionPane.showMessageDialog(null,"Produto deleteado com sucesso!");
		}else {
			JOptionPane.showMessageDialog(null, "ID n�o existe. N�o foi poss�vel excluir o Produto.");
		}
				
	}
	
	private void atualizarProduto() {
		ProdutoVO produtoVO = new ProdutoVO();
		ProdutoDAO produtoDAO = new ProdutoDAO();

		produtoVO.setIdProduto(Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o ID do Produto para atualizar.")));
		if(produtoDAO.existeRegistroPorIdProduto(produtoVO.getIdProduto())) {
		
		produtoVO.setNome(JOptionPane.showInputDialog(null, "Digite o nome do produto."));
		produtoVO.setSecao(JOptionPane.showInputDialog(null,"Digite a se��o."));
		produtoVO.setValor(Double.parseDouble(JOptionPane.showInputDialog(null,"Digite o valor do produto.")));
 
		if(produtoDAO.atualizar(produtoVO)) {
			JOptionPane.showMessageDialog(null, "Produto atualizado com sucesso!");	
		}else {
			JOptionPane.showMessageDialog(null, "Tente novamente!");	
		}
		}
	}
	
	private void consultarTodosProduto() {
		ProdutoDAO consultarProduto = new ProdutoDAO();
		
		List<ProdutoVO> produtos = consultarProduto.listarTodos();
		JOptionPane.showMessageDialog(null, produtos);
	}

	private void consultarProduto() {
		ProdutoDAO consultarProduto = new ProdutoDAO();
		
		int idProduto = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o ID do produto para consultado."));
		ProdutoVO produtoConsultado = consultarProduto.consultarPorId(idProduto);
		
		if(produtoConsultado != null) {
			JOptionPane.showMessageDialog(null, produtoConsultado);
		}else {
			JOptionPane.showMessageDialog(null,"Produto n�o encontrado. Tente novamente!");
			
		}
	}

	private String criarMenuProduto() {
		String mensagem = "Menu Produto";
		mensagem += "\n Op��es:";
		mensagem += "\n 1 - Cadastrar Produto.";
		mensagem += "\n 2 - Excluir Produto.";
		mensagem += "\n 3 - Alterar Cadastro de Produto.";
		mensagem += "\n 4 - Exibir Produto por ID.";
		mensagem += "\n 5 - Exibir todos os Produto.";
		mensagem += "\n 6 - Sair.";
		mensagem +="\n Digite a Op��o: ";
		
		return mensagem;
	}	

}
