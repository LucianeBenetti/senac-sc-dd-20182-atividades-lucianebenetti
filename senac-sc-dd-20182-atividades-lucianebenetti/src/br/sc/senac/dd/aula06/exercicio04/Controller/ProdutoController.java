package br.sc.senac.dd.aula06.exercicio04.Controller;

import br.sc.senac.dd.aula06.exercicio04.Model.ProdutoBO;
import br.sc.senac.dd.aula06.exercicio04.Model.ProdutoVO;

public class ProdutoController {
	
	private ProdutoBO bo = new ProdutoBO();

	public String salvar(ProdutoVO produtoVO) {
		String validacao = validarProduto(produtoVO);
		
		if(validacao =="") {
				
			if(produtoVO.getIdProduto()>0) {
				
			}else {
				if(bo.inserir(produtoVO)) {
					validacao ="Produto salvo com sucesso!";
				}
			}
		}
		return validacao;
	}

	private String validarProduto(ProdutoVO produtoVO) {
		String validacao = "";
		if(produtoVO == null) {
			validacao = "Produto está nulo!";
			
			if(produtoVO.getNome().trim().equals("")) {
				validacao += "- Nome é obriatório. \n";
			}
			if(produtoVO.getValor() == 0) {
			validacao += "- Valor é obrigatório. \n";
			}
			
		}
		
		return null;
	}
}
