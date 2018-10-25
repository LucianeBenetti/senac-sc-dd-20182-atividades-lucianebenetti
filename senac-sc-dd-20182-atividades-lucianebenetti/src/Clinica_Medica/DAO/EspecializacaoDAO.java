package Clinica_Medica.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Clinica_Medica.VO.ConvenioVO;
import Clinica_Medica.VO.EspecialidadeVO;
import Clinica_Medica.VO.EspecializacaoVO;
import Clinica_Medica.VO.MedicoVO;

public class EspecializacaoDAO {

	private static ArrayList<EspecializacaoVO> listaEspecializacao = new ArrayList<EspecializacaoVO>();

	public int inserirEspecializacao(EspecializacaoVO especializacao) {

		int novoId = 0;

		String sql = "INSERT INTO especializacao (codigoEspecialidade, codigoMedico, anoEspecializacao)"
				+ " VALUES (?,?,?)";

		Connection conn = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conn, sql, Statement.RETURN_GENERATED_KEYS);

		try {

			prepStmt.setInt(1, especializacao.getEspecialidadeVO().getCodigoEspecialidade());
			prepStmt.setInt(2, especializacao.getMedicoVO().getCodigoMedico());
			prepStmt.setString(3, especializacao.getAnoEspecializacao());

			prepStmt.executeUpdate();

			ResultSet generatedKeys = prepStmt.getGeneratedKeys();

			if (generatedKeys.next()) {
				novoId = generatedKeys.getInt(1);

			}

		} catch (SQLException e) {
			System.out.println("Erro ao executar o Cadastro do Especializacão! Causa: \n: " + e.getMessage());

		} finally {
			Banco.closePreparedStatement(prepStmt);
			Banco.closeConnection(conn);
		}
		return novoId;

	}

	public EspecializacaoVO consultaPorID(int id) {

		EspecializacaoVO especializacao = null;

		String query = "SELECT *from especializacao " + " where codigoEspecializacao = ?";

		Connection conn = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conn, query);
		try {
			prepStmt.setInt(1, id);
			ResultSet result = prepStmt.executeQuery();

			while (result.next()) {
				especializacao = new EspecializacaoVO();
				especializacao.setCodigoEspecializacao(result.getInt(1));
				especializacao.getEspecialidadeVO().setCodigoEspecialidade(result.getInt(2));
				especializacao.getMedicoVO().setCodigoMedico(result.getInt(3));
				especializacao.setAnoEspecializacao(result.getString(4));

			}
		} catch (SQLException ex) {
			System.out.println("Erro ao executar Query de Consultar do Especializacão! Causa: \n: " + ex.getMessage());
		} finally {
			Banco.closeStatement(prepStmt);
			Banco.closeConnection(conn);
		}
		return especializacao;
	}

	public boolean delete(int codigoEspecializacao) {
		boolean sucessoDelete = false;

		String query = "DELETE from especializacao where codigoEspecializacao = ? ";

		Connection conn = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conn, query);

		try {
			prepStmt.setInt(1, codigoEspecializacao);
			int codigoRetorno = prepStmt.executeUpdate();
			if (codigoRetorno == 1) {
				sucessoDelete = true;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar Query de Exclusão do Especializacão! Causa: \n: " + e.getMessage());
		} finally {
			Banco.closePreparedStatement(prepStmt);
			Banco.closeConnection(conn);
		}
		return sucessoDelete;
	}

	public boolean atualizar(EspecializacaoVO especializacaoAlterado, String codigoEspecializacao) {
		boolean sucessoAtualizar = false;
		EspecializacaoVO especializacao = new EspecializacaoVO();
		String query = "UPDATE especializacao SET codigoEspecialidade=?, codigoMedico=?, anoEspecializacao=?"
				+ " where codigoEspecializacao = ?";

		Connection conn = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conn, query);

		try {

			prepStmt.setInt(1, especializacao.getEspecialidadeVO().getCodigoEspecialidade());
			prepStmt.setInt(2, especializacao.getMedicoVO().getCodigoMedico());
			prepStmt.setString(3, especializacao.getAnoEspecializacao());
			prepStmt.setInt(4, especializacao.getCodigoEspecializacao());

			int codigoRetorno = prepStmt.executeUpdate();

			if (codigoRetorno == 1) {
				sucessoAtualizar = true;
			}
		} catch (SQLException ex) {
			System.out.println("Erro ao executar Query de Atualização do Especializacão!Causa: \n: " + ex.getMessage());
		} finally {
			Banco.closePreparedStatement(prepStmt);
			Banco.closeConnection(conn);
		}
		return sucessoAtualizar;
	}

	public String listarTodos() {

		String query = "select * from especializacao";

		Connection conn = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conn, query);
		try {
			ResultSet result = prepStmt.executeQuery();

			while (result.next()) {
				EspecializacaoVO especializacao = new EspecializacaoVO();

				especializacao.setCodigoEspecializacao(result.getInt(1));
				especializacao.getEspecialidadeVO().setCodigoEspecialidade(result.getInt(2));
				especializacao.getMedicoVO().setCodigoMedico(result.getInt(3));
				especializacao.setAnoEspecializacao(result.getString(4));

				listaEspecializacao.add(especializacao);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaEspecializacao.toString();
	}

	public ArrayList<EspecializacaoVO> listarEspecializacoes(int codigoMedico, int  codigoEspecialidade) {
		
		String query = "SELECT * from especializacao";

		Connection conn = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conn, query);
		try {
			ResultSet result = prepStmt.executeQuery();

			while (result.next()) {
				EspecializacaoVO especializacao = new EspecializacaoVO();
				especializacao.setCodigoEspecializacao(result.getInt(1));
				especializacao.getEspecialidadeVO().setCodigoEspecialidade(result.getInt(2));
				especializacao.getMedicoVO().setCodigoMedico(result.getInt(3));
				especializacao.setAnoEspecializacao(result.getString(4));

				listaEspecializacao.add(especializacao);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaEspecializacao;
	}
	

	public ArrayList<EspecializacaoVO> buscarEspecializacoes(String ano) {
		
	String query = "SELECT especialidade.nomeEspecialidade, medico.nomeMedico, especializacao.anoEspecializacao from especializacao inner join especialidade on "
				+ " especializacao.codigoEspecialidade = especialidade.codigoEspecialidade inner join medico on especializacao.codigoMedico = medico.codigoMedico "
			+"where ano = ?";

		ArrayList<EspecializacaoVO> especializacoes = new ArrayList<EspecializacaoVO>();
		EspecializacaoVO especializacao = null;
		Connection conn = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conn, query);
		try {
			prepStmt.setString(1, ano);
			
			ResultSet result = prepStmt.executeQuery();

			while (result.next()) {
				especializacao = new EspecializacaoVO();
				especializacao.setCodigoEspecializacao(result.getInt(1));
				especializacao.getMedicoVO().setNomeMedico(result.getString(2));
				especializacao.getEspecialidadeVO().setNomeEspecialidade(result.getString(3));
				especializacao.setAnoEspecializacao(result.getString(4));

				especializacoes.add(especializacao);
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			Banco.closeStatement(prepStmt);
			Banco.closeConnection(conn);
		}
		return especializacoes;
	}


}
