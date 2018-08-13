package br.sc.senac.dd.aula05.exercicio2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class ProdutoDAO implements InterfaceDAO {

	ProdutoVO produtoVO = new ProdutoVO();
	
	@Override
	public int insert(Object objeto) {
		
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
		String query = "INSERT INTO produto (nome, secao, valor) VALUES ('" + produtoVO.getNome() + "', '" + produtoVO.getSecao()
				+"','" + produtoVO.getValor() +"')";
		try {
			resultado = stmt.executeUpdate(query);
			JOptionPane.showMessageDialog(null,"Produto cadastrado com sucesso!");
		}catch (SQLException e) {
			System.out.println("Erro ao executar Query de Cadastro de Produto!");
		}finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return resultado;
	}

	@Override
	public int delete() {
		
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
		String query = "DELETE FROM produto WHERE idProduto = " + produtoVO.getIdProduto();
		try {
			resultado = stmt.executeUpdate(query);
			JOptionPane.showMessageDialog(null,"Produto deleteado com sucesso!");
		}catch (SQLException e) {
			System.out.println("Erro ao executar Query de Exclusão do Produto!");
		}finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return resultado;
	}

	@Override
	public int atualizar(Object objeto) {
		
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
		String query = "UPDATE produto SET nome = '" + produtoVO.getNome() + "', secao = '"+ produtoVO.getSecao() 
		+ "', valor = '" + produtoVO.getValor() + "' WHERE idproduto = " + produtoVO.getIdProduto();
		try {
			resultado = stmt.executeUpdate(query);
			JOptionPane.showMessageDialog(null,"Produto atualizado com sucesso!");
		}catch (SQLException e) {
			System.out.println("Erro ao executar Query de Atualização do Produto!");
		}finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return resultado;
		
	}

	@Override
	public void consultar() {
		
			Connection conn = Banco.getConnection();
			Statement stmt = Banco.getStatement(conn);
			ResultSet resultado = null;
			String query = "SELECT *FROM produto WHERE idproduto = " + produtoVO.getIdProduto();
			try {
				resultado = stmt.executeQuery(query);
				while (resultado.next()){
					produtoVO.setIdProduto(Integer.parseInt(resultado.getString(1)));
					produtoVO.setNome(resultado.getString(2));
					produtoVO.setSecao(resultado.getString(3));
					produtoVO.setValor(Double.parseDouble(resultado.getString(4)));
				}
			} catch(SQLException e) {
				System.out.println("Erro ao executar a Query de Consulta de produtos!");
			} finally {
				Banco.closeResultSet(resultado);
				Banco.closeStatement(stmt);
				Banco.closeConnection(conn);
			}
		}

}
