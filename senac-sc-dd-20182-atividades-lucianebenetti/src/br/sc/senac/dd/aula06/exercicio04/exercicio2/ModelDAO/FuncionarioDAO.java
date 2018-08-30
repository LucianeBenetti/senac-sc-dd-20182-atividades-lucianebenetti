package br.sc.senac.dd.aula05.exercicio2.ModelDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import br.sc.senac.dd.aula05.dao.Banco;
import br.sc.senac.dd.aula05.dao.BaseDAO;
import br.sc.senac.dd.aula05.exercicio2.ModelVO.FuncionarioVO;

public class FuncionarioDAO extends BaseDAO<FuncionarioVO> {

	@Override
	public String getNomeTabela() {
		return "FUNCIONARIO";
	}

	@Override
	public String getNomeColunaChavePrimaria() {
		return "IDFUNCIONARIO";
	}

	@Override
	public String getNomesColunasInsert() {
		return "NOME,CPF,TELEFONE,EMAIL";
	}

	@Override
	public String getInterrogacoesInsert() {
		return "?,?,?,?";
	}

	@Override
	public void setValoresAtributosInsert(FuncionarioVO entidade, PreparedStatement preparedStmt) {
		try {
			preparedStmt.setString(1, entidade.getNome());
			preparedStmt.setString(2, entidade.getCpf());
			preparedStmt.setString(3, entidade.getTelefone());
			preparedStmt.setString(4, entidade.getEmail());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String getValoresClausulaSetUpdate(FuncionarioVO entidade) {
		// SET NOME=func.getNome(), MATRICULA=func.getNumeroMatricula()...
		String clausulaSet = " NOME = ?, CPF = ?, TELEFONE = ?, EMAIL=?";
		return clausulaSet;
	}

	@Override
	public void setValoresAtributosUpdate(FuncionarioVO entidade, PreparedStatement preparedStmt) {
		// Preenche cada interrogação da cláusula SET
		try {
			preparedStmt.setString(1, entidade.getNome());
			preparedStmt.setString(2, entidade.getCpf());
			preparedStmt.setString(3, entidade.getTelefone());
			preparedStmt.setString(4, entidade.getEmail());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public FuncionarioVO construirObjetoDoResultSet(ResultSet resultado) {
		FuncionarioVO novoFuncionario = null; // retorna null caso o resultado esteja vazio
		try {
			novoFuncionario = new FuncionarioVO();
			novoFuncionario.setIdFuncionario(resultado.getInt("IDFUNCIONARIO"));
			novoFuncionario.setNome(resultado.getString("NOME"));
			novoFuncionario.setCpf(resultado.getString("CPF"));
			novoFuncionario.setTelefone(resultado.getString("TELEFONE"));
			novoFuncionario.setEmail(resultado.getString("EMAIL"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return novoFuncionario;

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
				funcionario.setEmail(result.getString(5));
				
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

public boolean existeRegistroPorCpf(String cpf) {
		
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		String query = "SELECT * FROM funcionario WHERE cpf like '" + cpf + "'";
			try {
				resultado = stmt.executeQuery(query);
				if (resultado.next()) {
					return true;
				}
			}catch (SQLException e) {
				System.out.println("Erro ao executar Query que verifica a existência de Funcionário por CPF. Causa: \n" + e.getMessage());
				return false;
			}finally {
				Banco.closeResultSet(resultado);
				Banco.closeStatement(stmt);
				Banco.closeConnection(conn);
			}
			return false;
		}

		public boolean existeRegistroPorIdFuncionario(int idFuncionario) {
			Connection conn = Banco.getConnection();
			Statement stmt = Banco.getStatement(conn);
			ResultSet resultado = null;
			String query = "SELECT * FROM funcionario WHERE idFuncionario like '" + idFuncionario + "'";
			try {
				resultado = stmt.executeQuery(query);
				if (resultado.next()) {
					return true;
				}
			}catch (SQLException e) {
				System.out.println("Erro ao executar Query que verifica a existência de Funcionário pelo IdFuncionário. Cause: \n" + e.getMessage());
				return false;
			}finally {
				Banco.closeResultSet(resultado);
				Banco.closeStatement(stmt);
				Banco.closeConnection(conn);
			}
			return false;
		}


}