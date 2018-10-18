package Clinica_Medica.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Clinica_Medica.VO.EspecialidadeVO;
import Clinica_Medica.VO.EspecializacaoVO;
import Clinica_Medica.VO.MedicoVO;


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

	public EspecialidadeVO consultarEspecialidadeVONome(String espNome, String espInstituicao) {

		String query = "SELECT *from especialidade " + " where espNome like ? and espInstituicao like ?";

		Connection conn = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conn, query);
		EspecialidadeVO especialidade = null;
		try {
			prepStmt.setString(1, '%' + espNome + '%');
			prepStmt.setString(2, '%' + espInstituicao + '%');
			ResultSet result = prepStmt.executeQuery();

			while (result.next()) {
				
				especialidade = new EspecialidadeVO();
				especialidade.setEspCod(result.getInt(1));
				especialidade.setEspNome(result.getString(2));
				especialidade.setEspInstituicao(result.getString(3));

			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			Banco.closeStatement(prepStmt);
			Banco.closeConnection(conn);
		}
		return especialidade;
	}

	public boolean atualizarEspecialidadeVO(EspecialidadeVO especialidade, int espCod) {
		boolean sucessoAtualizar = false;

		String query = "UPDATE especialidade SET espNome=?, espInstituicao=? " + " where espCod = ?";

		Connection conn = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conn, query);

		try {
			prepStmt.setString(1, especialidade.getEspNome());
			prepStmt.setString(2, especialidade.getEspInstituicao());
			prepStmt.setInt(3, especialidade.getEspCod());

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
				especialidade.setEspCod(result.getInt(1));
				especialidade.setEspNome(result.getString(2));
				especialidade.setEspInstituicao(result.getString(3));

				listaEspecialiades.add(especialidade);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaEspecialiades.toString();
	}

	public ArrayList<EspecialidadeVO> consultarEspecialidadeNome(String espNome) {

		String query = "SELECT *from especialidade " + " where espNome like ? ";

		Connection conn = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conn, query);
		EspecialidadeVO especialidade = null;
		ArrayList<EspecialidadeVO> especialidades = new ArrayList<EspecialidadeVO>();
		try {
			prepStmt.setString(1, '%' + espNome+ '%');
			
			ResultSet result = prepStmt.executeQuery();

			while (result.next()) {
				
				especialidade = new EspecialidadeVO();
				especialidade.setEspCod(result.getInt(1));
				especialidade.setEspNome(result.getString(2));
				especialidade.setEspInstituicao(result.getString(3));
				
				especialidades.add(especialidade);

			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			Banco.closeStatement(prepStmt);
			Banco.closeConnection(conn);
		}
		return especialidades;
	}

	public ArrayList<EspecialidadeVO> listarEspecialidades(String espNome, int espeCod, String medNome) {
			
		String query = "SELECT especialidade.espNome, medico.medNome, especializacao.espeCod from especializacao inner join especialidade on "
				+ " especializacao.espCod = especialidade.espCod inner join medico on especializacao.medCod = medico.medCod " + " where espNome like ? and espeCod = ? and medNome like ?";

		Connection conn = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conn, query);
		EspecialidadeVO especialidade = null;
		EspecializacaoVO especializacao = null;
		MedicoVO medico = null;
		ArrayList<EspecialidadeVO> especialidades = new ArrayList<EspecialidadeVO>();
		ArrayList<EspecializacaoVO> especializacoes = new ArrayList<EspecializacaoVO>();
		ArrayList<MedicoVO> medicos = new ArrayList<MedicoVO>();
		try {
			prepStmt.setString(1, '%' + espNome+ '%');
			prepStmt.setInt(2, espeCod);
			prepStmt.setString(3, '%' + medNome+ '%');
			
			ResultSet result = prepStmt.executeQuery();

			while (result.next()) {
				
				especialidade = new EspecialidadeVO();
				especializacao = new EspecializacaoVO();
				especialidade.setEspNome(result.getString(2));
				especializacao.setEspeCod(result.getInt(1));
				medico.setMedNome(result.getString(2));
				
				especialidades.add(especialidade);
				especializacoes.add(especializacao);
				medicos.add(medico);
				
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			Banco.closeStatement(prepStmt);
			Banco.closeConnection(conn);
		}
		return especialidades;
	}
}
