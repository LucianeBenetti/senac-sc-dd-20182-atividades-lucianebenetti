package projetoFinalLucianeMarco.Clinica_Medica.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import projetoFinalLucianeMarco.Clinica_Medica.Banco;
import projetoFinalLucianeMarco.Clinica_Medica.VO.EspecialidadeVO;


public class EspecialidadeDAO {
	private static ArrayList<EspecialidadeVO> listaEspecialiades = new ArrayList<EspecialidadeVO>();
	EspecialidadeVO especialidade = new EspecialidadeVO();

	public int inserirEspecialidadeVO(EspecialidadeVO especialidade) {
		int novoId = -1;

		String query = "INSERT INTO especialidade (espNome, espInstituicao)" + " VALUES (?, ?)";

		Connection conn = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conn, query, Statement.RETURN_GENERATED_KEYS);

		try {
			prepStmt.setString(1, especialidade.getEspNome());
			prepStmt.setString(2, especialidade.getEspInstituicao());

			prepStmt.executeUpdate();

			ResultSet generatedKeys = prepStmt.getGeneratedKeys();
			if (generatedKeys.next()) {
				novoId = generatedKeys.getInt(1);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar Query de Cadastro de Especialidade! Causa: \n: " + e.getMessage());
		} finally {
			Banco.closePreparedStatement(prepStmt);
			Banco.closeConnection(conn);
		}
		return novoId;
	}

	public boolean deleteEspecialidadeVO(int espCod) {
		boolean sucessoDelete = false;

		String query = "DELETE from especialidade where espCod = ? ";

		Connection conn = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conn, query);

		try {
			prepStmt.setInt(1, espCod);
			int codigoRetorno = prepStmt.executeUpdate();
			if (codigoRetorno == 1) {
				sucessoDelete = true;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar Query de Exclusão do Especialidade! Causa: \n: " + e.getMessage());
		} finally {
			Banco.closePreparedStatement(prepStmt);
			Banco.closeConnection(conn);
		}
		return sucessoDelete;
	}

	public String consultarEspecialidadeVOPorID(int espCod) {

		String query = "SELECT *from especialidade " + " where espCod = ?";

		Connection conn = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conn, query);
		try {
			prepStmt.setInt(1, espCod);
			ResultSet result = prepStmt.executeQuery();

			while (result.next()) {

				especialidade.setEspecialidadeCod(result.getInt(1));
				especialidade.setEspNome(result.getString(2));
				especialidade.setEspInstituicao(result.getString(3));

			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			Banco.closeStatement(prepStmt);
			Banco.closeConnection(conn);
		}
		return especialidade.toString();
	}

	public boolean atualizarEspecialidadeVO(EspecialidadeVO especialidade, int espCod) {
		boolean sucessoAtualizar = false;

		String query = "UPDATE especialidade SET espNome=?, espInstituicao=? " + " where espCod = ?";

		Connection conn = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conn, query);

		try {
			prepStmt.setString(1, especialidade.getEspNome());
			prepStmt.setString(2, especialidade.getEspInstituicao());
			prepStmt.setInt(3, especialidade.getEspecialidadeCod());

			int codigoRetorno = prepStmt.executeUpdate();

			if (codigoRetorno == 1) {
				sucessoAtualizar = true;
			}
		} catch (SQLException ex) {
			System.out.println("Erro ao executar Query de Atualização do Especialidade! Causa: \n: " + ex.getMessage());
		} finally {
			Banco.closePreparedStatement(prepStmt);
			Banco.closeConnection(conn);
		}
		return sucessoAtualizar;
	}

	public String listarTodasEspecialidades() {

		String query = "select * from especialidade";

		Connection conn = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conn, query);
		try {
			ResultSet result = prepStmt.executeQuery();

			while (result.next()) {
				EspecialidadeVO especialidade = new EspecialidadeVO();
				especialidade.setEspecialidadeCod(result.getInt(1));
				especialidade.setEspNome(result.getString(2));
				especialidade.setEspInstituicao(result.getString(3));

				listaEspecialiades.add(especialidade);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaEspecialiades.toString();
	}

}
