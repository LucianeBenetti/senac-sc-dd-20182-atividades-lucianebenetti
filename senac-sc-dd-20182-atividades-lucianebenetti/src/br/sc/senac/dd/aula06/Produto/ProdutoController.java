package br.sc.senac.dd.aula06.Produto;

import java.util.List;


public class ProdutoController {
	
	private ProdutoBO bo = new ProdutoBO();

	public List<ProdutoVO> listarTodosProdutos(){
		return bo.listarProdutos();
	}
	
	public List<ProdutoVO> listarProdutosPorNome(String nome){
		return bo.listarProdutosPorNome(nome);
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
}
