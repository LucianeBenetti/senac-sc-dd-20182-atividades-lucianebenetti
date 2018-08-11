package br.sc.senac.dd.aula05.exercicio2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class FuncionarioDAO {

	public int inserir () {
		FuncionarioVO funcionarioVO = new FuncionarioVO();
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
		String query = "INSERT INTO funcionario (nome, cpf, telefone, email) VALUES ('" + funcionarioVO.getNome() + "', '" + funcionarioVO.getCpf()
		+ "', '" + funcionarioVO.getTelefone()+"','" + funcionarioVO.getEmail() +"')";
		try {
			resultado = stmt.executeUpdate(query);
			JOptionPane.showMessageDialog(null,"Funcion�rio cadastrado com sucesso!");
		}catch (SQLException e) {
			System.out.println("Erro ao executar Query de Cadastro de Funcion�rio!");
		}finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return resultado;
	}

	public int deletar() {
		FuncionarioVO funcionarioVO = new FuncionarioVO();
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
		String query = "DELETE FROM funcionario WHERE idFuncionario = " + funcionarioVO.getIdFuncionario();
		try {
			resultado = stmt.executeUpdate(query);
			JOptionPane.showMessageDialog(null,"Funcion�rio exclu�do com sucesso!");
		}catch (SQLException e) {
			System.out.println("Erro ao executar Query de Exclus�o do Funcionario!");
		}finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return resultado;
	}

	public int atualizar() {
		FuncionarioVO funcionarioVO = new FuncionarioVO();
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
		String query = "UPDATE funcionario SET nome = '" 
		+ funcionarioVO.getNome() 
		+ "', cpf = '"+ funcionarioVO.getCpf() 
		+ "', telefone = '" + funcionarioVO.getTelefone()
		+ "', email = '" + funcionarioVO.getEmail()
		+ "' WHERE idfuncionario = " + funcionarioVO.getIdFuncionario();
		try {
			resultado = stmt.executeUpdate(query);
			JOptionPane.showMessageDialog(null,"Funcion�rio atualizado com sucesso!");
		}catch (SQLException e) {
			System.out.println("Erro ao executar Query de Atualiza��o do Funcion�rio!");
		}finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return resultado;
		
	}

	public FuncionarioVO cosultarfuncionarioDAO(FuncionarioVO funcionarioVO) {
			Connection conn = Banco.getConnection();
			Statement stmt = Banco.getStatement(conn);
			ResultSet resultado = null;
			FuncionarioVO funcionario = new FuncionarioVO();
			String query = "SELECT *FROM funcionario WHERE idfuncionario = " + funcionarioVO.getIdFuncionario();
			try {
				resultado = stmt.executeQuery(query);
				while (resultado.next()){
					funcionario.setIdFuncionario(Integer.parseInt(resultado.getString(1)));
					funcionario.setNome(resultado.getString(2));
					funcionario.setCpf(resultado.getString(3));
					funcionario.setTelefone(resultado.getString(4));
					funcionario.setEmail(resultado.getString(5));
				}
			} catch(SQLException e) {
				System.out.println("Erro ao executar a Query de Consulta de Funcion�rios!");
			} finally {
				Banco.closeResultSet(resultado);
				Banco.closeStatement(stmt);
				Banco.closeConnection(conn);
			}
			return funcionario;
	}

	
}
