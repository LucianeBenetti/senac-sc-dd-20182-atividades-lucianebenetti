package br.sc.senac.dd.aula06.exercicio04.Model;

public class ProdutoBO {
	ProdutoDAO dao = new ProdutoDAO();
	
	public boolean inserir(ProdutoVO produtoVO) {
		int idGerado = dao.inserirProduto(produtoVO);
		
		
		return idGerado >0;
	}

}