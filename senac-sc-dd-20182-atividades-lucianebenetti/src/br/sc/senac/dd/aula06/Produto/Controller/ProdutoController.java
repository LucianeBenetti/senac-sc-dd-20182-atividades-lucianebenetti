package br.sc.senac.dd.aula06.Produto.Controller;

import java.util.List;

import javax.swing.JOptionPane;

import br.sc.senac.dd.aula06.Produto.Model.ProdutoBO;
import br.sc.senac.dd.aula06.Produto.Model.ProdutoVO;


public class ProdutoController {
	
	private ProdutoBO bo = new ProdutoBO();

	public List<ProdutoVO> listarTodosProdutos(){
		return bo.listarProdutos();
	}
	
	public List<ProdutoVO> listarProdutosPorNome(String nome){
		return bo.listarProdutosPorNome(nome);
	}
	
	public List<ProdutoVO> listarProdutosPorValor(String valor) {
		return bo.listarProdutosPorValor(valor);
	}
	 
	public List<ProdutoVO> listarProdutosPorSecao(String secao) {
		
		return bo.listarProdutosPorSecao(secao);
	}
	public String salvar(ProdutoVO produto) {
		String validacao = validarProduto(produto);

		if(validacao == "") {
			if(produto.getIdProduto() > 0) {
				//INSERT
				if(bo.atualizar(produto)) {
					validacao = "Produto atualizado com sucesso!";
				}else {
					validacao = "Erro ao atualizar produto";
				}
			}else {
				//INSERT
				if(bo.inserir(produto)) {
					validacao = "Produto salvo com sucesso!";
				}else {
					validacao = "Erro ao salvar produto";
				}
			}
		}

		return validacao;
	}

	private String validarProduto(ProdutoVO produto) {
		String validacao = "";

		if(produto == null) {
			validacao = "Produto está NULO!";
		}else {
			
			if(produto.getNome().trim().equals("")) {
				validacao += "- Nome é obrigatório \n";
			}
			
		}
		return validacao;
	}

	public void deletar(ProdutoVO produtoVO) {
		bo.deletarProduto(produtoVO);
		
	}

	public void atualizar(ProdutoVO produto) {
        boolean resultado = bo.atualizar(produto);
		
		if(resultado) {
			JOptionPane.showMessageDialog(null,"Produto atualizado com sucesso!");
		}else {
			JOptionPane.showMessageDialog(null,"Produto não foi atualizado!");
		}
		
	}

	

	
}
