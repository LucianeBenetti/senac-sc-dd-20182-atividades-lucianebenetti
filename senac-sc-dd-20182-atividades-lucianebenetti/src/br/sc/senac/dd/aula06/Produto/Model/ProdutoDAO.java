package br.sc.senac.dd.aula06.Produto.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ProdutoDAO {
	
		public int inserir(ProdutoVO p){
			int novoId = -1;

			String sql = " INSERT INTO PRODUTO (NOME, SECAO, VALOR) "
					+ " VALUES (?,?,?) ";

			Connection conexao = Banco.getConnection();
			PreparedStatement prepStmt = Banco.getPreparedStatement(conexao, sql, 
					Statement.RETURN_GENERATED_KEYS);

			try {
				prepStmt.setString(1, p.getNome());
				prepStmt.setString(2, p.getSecao());
				prepStmt.setDouble(3, p.getValor());
				
				prepStmt.execute();

				ResultSet generatedKeys = prepStmt.getGeneratedKeys();
				if (generatedKeys.next()) {
					novoId = generatedKeys.getInt(1);
				}
			} catch (SQLException e) {
				System.out.println("Erro ao inserir produto. Causa: \n: " + e.getMessage());
			} finally{
				Banco.closePreparedStatement(prepStmt);
				Banco.closeConnection(conexao);
			}

			return novoId;
		}

		public boolean atualizar(ProdutoVO p){
			boolean sucessoUpdate = false;

			String sql = " UPDATE PRODUTO P SET NOME=?, SECAO=?, VALOR=? "
					+ " WHERE P.IDPRODUTO = ? ";

			Connection conexao = Banco.getConnection();
			PreparedStatement prepStmt = Banco.getPreparedStatement(conexao, sql);

			try {
				prepStmt.setString(1, p.getNome());
				prepStmt.setString(2, p.getSecao());
				prepStmt.setDouble(3, p.getValor());
				prepStmt.setDouble(5, p.getIdProduto());

				int codigoRetorno = prepStmt.executeUpdate();

				if(codigoRetorno == 1){
					sucessoUpdate = true;
				}

			} catch (SQLException e) {
				System.out.println("Erro ao atualizar produto");
			}finally{
				Banco.closePreparedStatement(prepStmt);
				Banco.closeConnection(conexao);
			}

			return sucessoUpdate;
		}
		
		//DELETE
		public boolean remover(int id){
			boolean sucessoDelete = false;

			String sql = " DELETE FROM PRODUTO "
					+ " WHERE IDPRODUTO = ? ";

			Connection conexao = Banco.getConnection();
			PreparedStatement prepStmt = Banco.getPreparedStatement(conexao, sql);

			try {
				prepStmt.setInt(1, id);

				int codigoRetorno = prepStmt.executeUpdate();

				if(codigoRetorno == 1){
					sucessoDelete = true;
				}

			} catch (SQLException e) {
				System.out.println("Erro ao remover produto. Id = " + id);
			}finally{
				Banco.closePreparedStatement(prepStmt);
				Banco.closeConnection(conexao);
			}
			return sucessoDelete;
		}
		
		public ArrayList<ProdutoVO> listarPorNome(String nome){
			String sql = " SELECT * FROM PRODUTO WHERE NOME like ?";
			
			Connection conexao = Banco.getConnection();
			PreparedStatement prepStmt = Banco.getPreparedStatement(conexao, sql);
			ArrayList<ProdutoVO> produtos = new ArrayList<ProdutoVO>();
			
			try {
				prepStmt.setString(1, '%'+ nome+'%');
				ResultSet result = prepStmt.executeQuery();
				
				while(result.next()){
					ProdutoVO p = new ProdutoVO();
					
					p.setIdProduto(result.getInt(1));
					p.setNome(result.getString(2));
					p.setSecao(result.getString(3));
					p.setValor(result.getDouble(4));
					
					produtos.add(p);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return produtos;
			
		}
		
		
		public ArrayList<ProdutoVO> listarTodos(){
			String sql = " SELECT * FROM PRODUTO ";
			
			Connection conexao = Banco.getConnection();
			PreparedStatement prepStmt = Banco.getPreparedStatement(conexao, sql);
			ArrayList<ProdutoVO> produtos = new ArrayList<ProdutoVO>();
			
			try {
				ResultSet result = prepStmt.executeQuery();
				
				while(result.next()){
					ProdutoVO p = new ProdutoVO();
					
					p.setIdProduto(result.getInt(1));
					p.setNome(result.getString(2));
					p.setSecao(result.getString(3));
					p.setValor(result.getDouble(4));
					produtos.add(p);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return produtos;
		}

		public ProdutoVO obterPorId(int idproduto){
			String sql = " SELECT * FROM PRODUTO "
					+ " WHERE IDproduto=?";
			
			Connection conexao = Banco.getConnection();
			PreparedStatement prepStmt = Banco.getPreparedStatement(conexao, sql);
			ProdutoVO p = null;
			
			try {
				prepStmt.setInt(1, idproduto);
				ResultSet result = prepStmt.executeQuery();
				
				while(result.next()){
					p = new ProdutoVO();
					
					p.setIdProduto(result.getInt(1));
					p.setNome(result.getString(2));
					p.setSecao(result.getString(3));
					p.setValor(result.getDouble(4));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return p;
		}

		public ArrayList<ProdutoVO> listarPorValor(String valor) {
			
			String sql = " SELECT * FROM PRODUTO WHERE valor = ?";
			
			Connection conexao = Banco.getConnection();
			PreparedStatement prepStmt = Banco.getPreparedStatement(conexao, sql);
			ArrayList<ProdutoVO> produtos = new ArrayList<ProdutoVO>();
			
			try {
				prepStmt.setString(1, valor);
				ResultSet result = prepStmt.executeQuery();
				
				while(result.next()){
					ProdutoVO p = new ProdutoVO();
					
					p.setIdProduto(result.getInt(1));
					p.setNome(result.getString(2));
					p.setSecao(result.getString(3));
					p.setValor(result.getDouble(4));
					
					produtos.add(p);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return produtos;
			
		}

		public ArrayList<ProdutoVO> listarPorSecao(String secao) {
			String sql = " SELECT * FROM PRODUTO WHERE secao = ?";
			
			Connection conexao = Banco.getConnection();
			PreparedStatement prepStmt = Banco.getPreparedStatement(conexao, sql);
			ArrayList<ProdutoVO> produtos = new ArrayList<ProdutoVO>();
			
			try {
				prepStmt.setString(1, secao);
				ResultSet result = prepStmt.executeQuery();
				
				while(result.next()){
					ProdutoVO p = new ProdutoVO();
					
					p.setIdProduto(result.getInt(1));
					p.setNome(result.getString(2));
					p.setSecao(result.getString(3));
					p.setValor(result.getDouble(4));
					
					produtos.add(p);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return produtos;
			
		}
	}

