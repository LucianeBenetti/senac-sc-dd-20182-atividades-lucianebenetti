package br.sc.senac.dd.aula06.Produto;

public class ProdutoBO {
	ProdutoDAO dao = new ProdutoDAO();
	
	public boolean inserir(ProdutoVO produtoVO) {
		int idGerado = dao.inserirProduto(produtoVO);
		
		
		return idGerado >0;
	}

}