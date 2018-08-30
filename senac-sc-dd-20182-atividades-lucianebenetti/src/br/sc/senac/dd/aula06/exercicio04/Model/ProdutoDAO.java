package br.sc.senac.dd.aula06.exercicio04.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ProdutoDAO {
	public int inserirProduto(ProdutoVO produtoVO) {
		int novoId = -1;

		String query = "INSERT INTO produto (nome, secao, valor)" + " VALUES (?,?,?)";

		Connection conn = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conn, query, Statement.RETURN_GENERATED_KEYS);

		try {
			prepStmt.setString(1,  produtoVO.getNome());
			prepStmt.setString(2,  produtoVO.getSecao());
			prepStmt.setDouble(3,  produtoVO.getValor());

			prepStmt.executeUpdate();

			ResultSet generatedKeys = prepStmt.getGeneratedKeys();
			if (generatedKeys.next()) {
				novoId = generatedKeys.getInt(1);
			}
		}catch (SQLException e) {
			System.out.println("Erro ao executar Query de Cadastro de Produto! Causa: \n: " + e.getMessage());

		}finally {
			Banco.closePreparedStatement(prepStmt);
			Banco.closeConnection(conn);
		}
		return novoId;
	}

	public boolean delete(int idProduto) {
		boolean sucesso = false;

		String query = "DELETE FROM produto WHERE idProduto = ? ";

		Connection conn = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conn, query);

		try {
			prepStmt.setInt(1,  idProduto);
			int codigoRetorno = prepStmt.executeUpdate();
			if(codigoRetorno == 1){
				sucesso = true;
			}
		}catch (SQLException e) {
			System.out.println("Erro ao executar Query de Exclusão do Produto! Causa: \n: " + e.getMessage());
		}finally {
			Banco.closePreparedStatement(prepStmt);
			Banco.closeConnection(conn);
		}
		return sucesso;
	}

	public boolean atualizar(ProdutoVO produtoVO) {

		boolean sucesso = false;

		String query = "UPDATE PRODUTO P SET NOME=?, SECAO=?, VALOR=?" + "WHERE P.IDproduto = ?";

		Connection conn = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conn, query);

		try {
			prepStmt.setString(1,  produtoVO.getNome());
			prepStmt.setString(2,  produtoVO.getSecao());
			prepStmt.setDouble(3,  produtoVO.getValor());
			prepStmt.setInt(4, produtoVO.getIdProduto());

			int codigoRetorno = prepStmt.executeUpdate();

			if(codigoRetorno == 1){
				sucesso = true;
			}
		}catch (SQLException e) {
			System.out.println("Erro ao executar Query de Atualização do Produto!Causa: \n: " + e.getMessage());
		}finally {
			Banco.closePreparedStatement(prepStmt);
			Banco.closeConnection(conn);
		}
		return sucesso;

	}

	public ArrayList<ProdutoVO> listarTodos() {

		String query = "select * from produto";

		Connection conn = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conn, query);
		ArrayList<ProdutoVO> produtos = new ArrayList<ProdutoVO>();
		try {
			ResultSet result = prepStmt.executeQuery(query);

			while (result.next()) {
				ProdutoVO produto = new ProdutoVO();
				produto.setIdProduto(result.getInt("idproduto"));
				produto.setNome(result.getString("nome"));
				produto.setSecao(result.getString("secao"));
				produto.setValor(result.getDouble(4));//outra forma de fazer.

				produtos.add(produto);
			}	
			
		}catch(SQLException e) {
			e.printStackTrace();
		}

		return produtos;
	}

	public ProdutoVO consultarPorId(int id) {

		String query = "SELECT *FROM produto" + " WHERE idproduto = ?";

		Connection conn = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conn, query);
		ProdutoVO produto = null;
		ArrayList<ProdutoVO> produtos = new ArrayList<ProdutoVO>();		

		try {
			prepStmt.setInt(1, id);
			ResultSet result= prepStmt.executeQuery();

			while (result.next()){
				produto = new ProdutoVO();
				produto.setIdProduto(result.getInt("idproduto"));
				produto.setNome(result.getString("nome"));
				produto.setSecao(result.getString("secao"));
				produto.setValor(result.getDouble(4));

			produtos.add(produto);
			}
		} catch(SQLException e) {
			System.out.println("Erro ao executar a Query de Consulta de produtos!Causa: \n: " + e.getMessage());
		} finally {
			Banco.closeStatement(prepStmt);
			Banco.closeConnection(conn);
		}
		return produto;
	}
	
	public boolean existeRegistroPorIdProduto(int idProduto) {
			Connection conn = Banco.getConnection();
			Statement stmt = Banco.getStatement(conn);
			ResultSet resultado = null;
			String query = "SELECT * FROM produto WHERE idProduto like '" + idProduto + "'";
			try {
				resultado = stmt.executeQuery(query);
				if (resultado.next()) {
					return true;
				}
			}catch (SQLException e) {
				System.out.println("Erro ao executar Query que verifica a existência de Produto pelo IdProduto. Cause: \n" + e.getMessage());
				return false;
			}finally {
				Banco.closeResultSet(resultado);
				Banco.closeStatement(stmt);
				Banco.closeConnection(conn);
			}
			return false;
		}

	}

