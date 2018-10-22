package Clinica_Medica.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Clinica_Medica.VO.ProntuarioVO;

public class ProntuarioDAO {
	
	private static ArrayList<ProntuarioVO> listaprontuarios = new ArrayList<ProntuarioVO>();
	ProntuarioVO prontuario = new ProntuarioVO();

	public int inserir(ProntuarioVO prontuarioVO) {
		int novoId = -1;

		String query = "INSERT INTO prontuario (medicamento, exame, registro)"
				+ " VALUES (?, ?, ?)";

		Connection conn = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conn, query, Statement.RETURN_GENERATED_KEYS);

		try {
			
			prepStmt.setString(1, prontuario.getMedicamento());
			prepStmt.setString(2, prontuario.getExame());
			prepStmt.setString(3, prontuario.getRegistro());
		
			prepStmt.executeUpdate();

			ResultSet generatedKeys = prepStmt.getGeneratedKeys();
			if (generatedKeys.next()) {
				novoId = generatedKeys.getInt(1);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar Query de Cadastro de Prontuário! Causa: \n: " + e.getMessage());
		} finally {
			Banco.closePreparedStatement(prepStmt);
			Banco.closeConnection(conn);
		}
		return novoId;
	}

	public boolean delete(String pronCod) {
		boolean sucessoDelete = false;

		String query = "DELETE from prontuario where pronCod = ? ";

		Connection conn = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conn, query);

		try {
			prepStmt.setString(1, pronCod);
			int codigoRetorno = prepStmt.executeUpdate();
			if (codigoRetorno == 1) {
				sucessoDelete = true;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar Query de Exclusão do Prontuário! Causa: \n: " + e.getMessage());
		} finally {
			Banco.closePreparedStatement(prepStmt);
			Banco.closeConnection(conn);
		}
		return sucessoDelete;
	}

	public String consultarProntuarioPorId(String pronCod) {

		String query = "SELECT *from prontuario " + " where pronCod = ?";

		Connection conn = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conn, query);
		try {
			prepStmt.setString(1, pronCod);
			ResultSet result = prepStmt.executeQuery();

			while (result.next()) {
				
				prontuario.setPronCod(result.getInt(1));
				prontuario.setMedicamento(result.getString(2));
				prontuario.setExame(result.getString(3));
				prontuario.setRegistro(result.getString(4));
				
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			Banco.closeStatement(prepStmt);
			Banco.closeConnection(conn);
		}
		return prontuario.toString();
	}

	public boolean atualizar(ProntuarioVO prontuarioVOAlterado, String IDAnterior) {
		boolean sucessoAtualizar = false;

		String query = "UPDATE prontuario SET medicamento=?, exame=?, registro=?"
				+ " where pronCod = ?";

		Connection conn = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conn, query);

		try {
			
			prepStmt.setString(1, prontuario.getMedicamento());
			prepStmt.setString(2, prontuario.getExame());
			prepStmt.setString(3, prontuario.getRegistro());
			prepStmt.setInt(4, prontuario.getPronCod());	
			
			int codigoRetorno = prepStmt.executeUpdate();

			if (codigoRetorno == 1) {
				sucessoAtualizar = true;
			}
		} catch (SQLException ex) {
			System.out.println("Erro ao executar Query de Atualização do Prontuário!Causa: \n: " + ex.getMessage());
		} finally {
			Banco.closePreparedStatement(prepStmt);
			Banco.closeConnection(conn);
		}
		return sucessoAtualizar;
	}

	public ArrayList<ProntuarioVO> listarTodos() {

		String query = "select * from prontuario";

		Connection conn = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conn, query);
		try {
			ResultSet result = prepStmt.executeQuery();

			while (result.next()) {
				ProntuarioVO prontuario = new ProntuarioVO();

				prontuario.setPronCod(result.getInt(1));
				prontuario.setMedicamento(result.getString(2));
				prontuario.setExame(result.getString(3));
				prontuario.setRegistro(result.getString(4));
				
				listaprontuarios.add(prontuario);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaprontuarios;
	}


}
