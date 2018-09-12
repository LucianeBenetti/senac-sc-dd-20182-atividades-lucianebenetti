package br.sc.senac.dd.aula06.exercicio04.Produto.Model;

import java.util.ArrayList;
import java.util.List;

		
	public class ProdutoBO {
		ProdutoDAO dao = new ProdutoDAO();
		
		public boolean inserir(ProdutoVO produto) {
			int idGerado = dao.inserir(produto);
			return idGerado > 0;
		}
		public ProdutoVO buscarProdutoPorId(String textoId) {
			ProdutoVO produtoBuscado = dao.obterPorId(Integer.parseInt(textoId));
			return produtoBuscado;
		}
		public boolean atualizar(ProdutoVO produto) {
			boolean sucesso = dao.atualizar(produto);
			return sucesso;
		}
		
		public List<ProdutoVO> listarProdutos() {
			ArrayList<ProdutoVO> produtos = dao.listarTodos();
			return produtos;
		}
		
		public List<ProdutoVO> listarProdutosPorNome(String nome) {
			ArrayList<ProdutoVO> produtos = dao.listarPorNome(nome);
			return produtos;
		}
		public List<ProdutoVO> listarProdutosPorValor(String valor) {
			ArrayList<ProdutoVO> produtos = dao.listarPorValor(valor);
			return produtos;
		}
		public List<ProdutoVO> listarProdutosPorSecao(String secao) {
			ArrayList<ProdutoVO> produtos = dao.listarPorSecao(secao);
			
			return produtos;
		}
		
		}