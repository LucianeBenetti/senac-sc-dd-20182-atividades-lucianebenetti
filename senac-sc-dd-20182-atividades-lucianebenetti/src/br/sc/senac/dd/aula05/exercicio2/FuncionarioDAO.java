package br.sc.senac.dd.aula05.exercicio2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FuncionarioDAO implements InterfaceDAO{

	@Override
	public void inserir () {
		FuncionarioVO funcionarioVO = new FuncionarioVO();
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
		String query = "INSERT INTO funcionario (nome, cpf, telefone, email) VALUES ('" + funcionarioVO.getNome() + "', '" + funcionarioVO.getCpf()
		+ "', '" + funcionarioVO.getTelefone()+"','" + funcionarioVO.getEmail() +"')";
		try {
			resultado = stmt.executeUpdate(query);
		}catch (SQLException e) {
			System.out.println("Erro ao executar Query de Cadastro de Funcionário!");
		}finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		//return resultado;
	}

	@Override
	public void deletar() {
		FuncionarioVO funcionarioVO = new FuncionarioVO();
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
		String query = "DELETE FROM funcionario WHERE idFuncionario = " + funcionarioVO.getIdFuncionario();
		try {
			resultado = stmt.executeUpdate(query);
		}catch (SQLException e) {
			System.out.println("Erro ao executar Query de Exclusão do Funcionario!");
		}finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		//return resultado;
	}

	@Override
	public void atualizar() {
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
		}catch (SQLException e) {
			System.out.println("Erro ao executar Query de Atualização do Funcionário!");
		}finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		//return resultado;
		
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
				System.out.println("Erro ao executar a Query de Consulta de Funcionários!");
			} finally {
				Banco.closeResultSet(resultado);
				Banco.closeStatement(stmt);
				Banco.closeConnection(conn);
			}
			return funcionario;
	}

	
}
