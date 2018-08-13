package br.sc.senac.dd.aula05.exercicio2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class FuncionarioDAO implements InterfaceDAO {
	
	FuncionarioVO funcionarioVO = new FuncionarioVO();
	
	@Override
	public int insert(Object objeto) {
				
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
		String query = "INSERT INTO funcionario (nome, cpf, telefone, email) VALUES ('" + funcionarioVO.getNome() + "', '" + funcionarioVO.getCpf()
		+ "', '" + funcionarioVO.getTelefone()+"','" + funcionarioVO.getEmail() +"')";
		try {
			resultado = stmt.executeUpdate(query);
			JOptionPane.showMessageDialog(null,"Funcionário cadastrado com sucesso!");
		}catch (SQLException e) {
			System.out.println("Erro ao executar Query de Cadastro de Funcionário!");
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
		String query = "DELETE FROM funcionario WHERE idFuncionario = " + funcionarioVO.getIdFuncionario();
		try {
			resultado = stmt.executeUpdate(query);
			JOptionPane.showMessageDialog(null,"Funcionário excluído com sucesso!");
		}catch (SQLException e) {
			System.out.println("Erro ao executar Query de Exclusão do Funcionario!");
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
		String query = "UPDATE funcionario SET nome = '" 
		+ funcionarioVO.getNome() 
		+ "', cpf = '"+ funcionarioVO.getCpf() 
		+ "', telefone = '" + funcionarioVO.getTelefone()
		+ "', email = '" + funcionarioVO.getEmail()
		+ "' WHERE idfuncionario = " + funcionarioVO.getIdFuncionario();
		try {
			resultado = stmt.executeUpdate(query);
			JOptionPane.showMessageDialog(null,"Funcionário atualizado com sucesso!");
		}catch (SQLException e) {
			System.out.println("Erro ao executar Query de Atualização do Funcionário!");
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
			String query = "SELECT *FROM funcionario WHERE idfuncionario = " + funcionarioVO.getIdFuncionario();
			try {
				resultado = stmt.executeQuery(query);
				while (resultado.next()){
					funcionarioVO.setIdFuncionario(Integer.parseInt(resultado.getString(1)));
					funcionarioVO.setNome(resultado.getString(2));
					funcionarioVO.setCpf(resultado.getString(3));
					funcionarioVO.setTelefone(resultado.getString(4));
					funcionarioVO.setEmail(resultado.getString(5));
				}
			} catch(SQLException e) {
				System.out.println("Erro ao executar a Query de Consulta de Funcionários!");
			} finally {
				Banco.closeResultSet(resultado);
				Banco.closeStatement(stmt);
				Banco.closeConnection(conn);
			}
			
	}

}
