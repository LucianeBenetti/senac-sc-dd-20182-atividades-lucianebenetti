package br.sc.senac.dd.aula06.exercicio04.funcionario.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import br.sc.senac.dd.aula06.exercicio02.Banco;

public class FuncionarioDAO {
	
	
	public int inserirFuncionario(FuncionarioVO funcionarioVO) {
		int novoId = -1;

		String query = "INSERT INTO funcionario (nome, cpf, telefone, celular, email)" + " VALUES (?,?,?,?,?)";

		Connection conn = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conn, query, Statement.RETURN_GENERATED_KEYS);

		try {
			prepStmt.setString(1,  funcionarioVO.getNome());
			prepStmt.setString(2,  funcionarioVO.getCpf());
			prepStmt.setString(3,  funcionarioVO.getTelefone());
			prepStmt.setString(4,  funcionarioVO.getCelular());
			prepStmt.setString(5,  funcionarioVO.getEmail());
			
			prepStmt.executeUpdate();

			ResultSet generatedKeys = prepStmt.getGeneratedKeys();
			if (generatedKeys.next()) {
				novoId = generatedKeys.getInt(1);
			}
		}catch (SQLException e) {
			System.out.println("Erro ao executar Query de Cadastro de Funcionário! Causa: \n: " + e.getMessage());

		}finally {
			Banco.closePreparedStatement(prepStmt);
			Banco.closeConnection(conn);
		}
		return novoId;
	}

	public boolean delete(String cpf) {
		boolean sucesso = false;

		String query = "DELETE FROM funcionario WHERE cpf = ? ";

		Connection conn = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conn, query);

		try {
			prepStmt.setString(1,  cpf);
			int codigoRetorno = prepStmt.executeUpdate();
			if(codigoRetorno == 1){
				sucesso = true;
			}
		}catch (SQLException e) {
			System.out.println("Erro ao executar Query de Exclusão do Funcionario! Causa: \n: " + e.getMessage());
		}finally {
			Banco.closePreparedStatement(prepStmt);
			Banco.closeConnection(conn);
		}
		return sucesso;
	}

	public boolean atualizar(FuncionarioVO funcionarioAlterado, String cpfAnterior) {

		boolean sucesso = false;

		String query = "UPDATE funcionario SET NOME=?, CPF=?, TELEFONE=?, CELULAR=?, EMAIL=?" + "WHERE CPF = ?";

		Connection conn = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conn, query);

		try {
			prepStmt.setString(1,  funcionarioAlterado.getNome());
			prepStmt.setString(2,  funcionarioAlterado.getCpf());
			prepStmt.setString(3,  funcionarioAlterado.getTelefone());
			prepStmt.setString(4,  funcionarioAlterado.getCelular());
			prepStmt.setString(5,  funcionarioAlterado.getEmail());
			prepStmt.setString(6,  cpfAnterior);

			int codigoRetorno = prepStmt.executeUpdate();

			if(codigoRetorno == 1){
				sucesso = true;
			}
		}catch (SQLException e) {
			System.out.println("Erro ao executar Query de Atualização do Funcionário!Causa: \n: " + e.getMessage());
		}finally {
			Banco.closePreparedStatement(prepStmt);
			Banco.closeConnection(conn);
		}
		return sucesso;

	}

	public ArrayList<FuncionarioVO> listarTodos() {

		String query = "select * from funcionario";

		Connection conn = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conn, query);
		ArrayList<FuncionarioVO> funcionarios = new ArrayList<FuncionarioVO>();
		try {
			ResultSet result = prepStmt.executeQuery(query);

			while (result.next()) {
				FuncionarioVO funcionario = new FuncionarioVO();
				funcionario.setIdFuncionario(result.getInt("idfuncionario"));
				funcionario.setNome(result.getString("nome"));
				funcionario.setCpf(result.getString("cpf"));
				funcionario.setTelefone(result.getString("telefone"));
				funcionario.setCelular(result.getString("celular"));
				funcionario.setEmail(result.getString("email"));

				funcionarios.add(funcionario);
			}	
			
		}catch(SQLException e) {
			e.printStackTrace();
		}

		return funcionarios;
	}

	public FuncionarioVO consultarPorCpf(String cpf) {

		String query = "SELECT *FROM funcionario" + " WHERE cpf = ?";

		Connection conn = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conn, query);
		FuncionarioVO funcionario = null;
		ArrayList<FuncionarioVO> funcionarios = new ArrayList<FuncionarioVO>();		

		try {
			prepStmt.setString(1, cpf);
			ResultSet result= prepStmt.executeQuery();

			while (result.next()){
				funcionario = new FuncionarioVO();
				funcionario.setIdFuncionario(result.getInt("idfuncionario"));
				funcionario.setNome(result.getString("nome"));
				funcionario.setCpf(result.getString("cpf"));
				funcionario.setTelefone(result.getString(4));
				funcionario.setCelular(result.getString(5));
				funcionario.setEmail(result.getString(6));
				
				funcionarios.add(funcionario);
			}
		} catch(SQLException e) {
			System.out.println("Erro ao executar a Query de Consulta de produtos!Causa: \n: " + e.getMessage());
		} finally {
			Banco.closeStatement(prepStmt);
			Banco.closeConnection(conn);
		}
		return funcionario;
	}

	public ArrayList<FuncionarioVO> exibirPorCpf(String cpf) {
		String query = "SELECT *FROM funcionario" + " WHERE cpf = ?";

		Connection conn = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conn, query);
		FuncionarioVO funcionario = null;
		ArrayList<FuncionarioVO> funcionarios = new ArrayList<FuncionarioVO>();		

		try {
			prepStmt.setString(1, cpf);
			ResultSet result= prepStmt.executeQuery();

			while (result.next()){
				funcionario = new FuncionarioVO();
				funcionario.setIdFuncionario(result.getInt("idfuncionario"));
				funcionario.setNome(result.getString("nome"));
				funcionario.setCpf(result.getString("cpf"));
				funcionario.setTelefone(result.getString(4));
				funcionario.setCelular(result.getString(5));
				funcionario.setEmail(result.getString(6));
				
				funcionarios.add(funcionario);
			}
		} catch(SQLException e) {
			System.out.println("Erro ao executar a Query de Consulta de produtos!Causa: \n: " + e.getMessage());
		} finally {
			Banco.closeStatement(prepStmt);
			Banco.closeConnection(conn);
		}
		return funcionarios;
	}

	}
