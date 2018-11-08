package Clinica_Medica.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;

import Clinica_Medica.VO.ConsultaVO;
import Clinica_Medica.VO.ConvenioVO;
import Clinica_Medica.VO.EspecializacaoVO;
import Clinica_Medica.VO.MedicoVO;
import Clinica_Medica.VO.PacienteVO;

public class ConsultaDAO {

	private static ArrayList<ConsultaVO> listaConsultas = new ArrayList<ConsultaVO>();
	private EspecializacaoDAO especializacaoDAO = new EspecializacaoDAO();
	private ConvenioDAO convenioDAO = new ConvenioDAO();
	private PacienteDAO pacienteDAO = new PacienteDAO();

	public int inserirConsulta(ConsultaVO consulta) {

		int novoId = 0;

		String sql = "INSERT INTO consulta (codigoEspecializacao, codigoPaciente, codigoConvenio, dataConsulta, horarioConsulta)"
				+ " VALUES (?,?,?,?,?)";

		Connection conn = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conn, sql, Statement.RETURN_GENERATED_KEYS);

		try {

			Calendar c = Calendar.getInstance();
			c.setTime(consulta.getDataConsulta());
			//java.sql.Date			
			Date dataSQL = new Date(c.getTimeInMillis());
			
			prepStmt.setInt(1, consulta.getEspecializacaoVO().getCodigoEspecializacao());
			prepStmt.setInt(2, consulta.getPacienteVO().getCodigoPaciente());
			prepStmt.setInt(3, consulta.getConvenioVO().getCodigoConvenio());
			prepStmt.setDate(4, dataSQL);
			prepStmt.setString(5, consulta.getHorarioConsulta());

			prepStmt.executeUpdate();

			ResultSet generatedKeys = prepStmt.getGeneratedKeys();

			if (generatedKeys.next()) {
				novoId = generatedKeys.getInt(1);

			}

		} catch (SQLException e) {
			System.out.println("Erro ao executar o Cadastro do Consulta! Causa: \n: " + e.getMessage());

		} finally {
			Banco.closePreparedStatement(prepStmt);
			Banco.closeConnection(conn);
		}
		return novoId;

	}

	public String consultarPorPaciente(String paciente) {

		ConsultaVO consulta = new ConsultaVO();

		String query = "SELECT * from consulta " + " where nomePaciente like ?";

		Connection conn = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conn, query);
		try {
			prepStmt.setString(1, paciente);
			ResultSet result = prepStmt.executeQuery();

			while (result.next()) {
				
				consulta.setCodigoConsulta(result.getInt(1));
				EspecializacaoVO especializacaoVO = especializacaoDAO.consultarPorId(result.getInt(2));
				consulta.setEspecializacaoVO(especializacaoVO);
				PacienteVO pacienteVO = pacienteDAO.consultarPorId(result.getInt(3));
				consulta.setPacienteVO(pacienteVO);
				ConvenioVO convenioVO = convenioDAO.consultarPorId(result.getInt(4));
				consulta.setConvenioVO(convenioVO);
				consulta.setDataConsulta(result.getDate(5));
				consulta.setHorarioConsulta(result.getString(6));
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			Banco.closeStatement(prepStmt);
			Banco.closeConnection(conn);
		}
		return consulta.toString();
	}

	public boolean delete(int codigoConsulta) {
		boolean sucessoDelete = false;

		String query = "DELETE from consulta where codigoConsulta = ? ";

		Connection conn = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conn, query);

		try {
			prepStmt.setInt(1, codigoConsulta);
			int codigoRetorno = prepStmt.executeUpdate();
			if (codigoRetorno == 1) {
				sucessoDelete = true;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar Query de Exclus�o do Consulta! Causa: \n: " + e.getMessage());
		} finally {
			Banco.closePreparedStatement(prepStmt);
			Banco.closeConnection(conn);
		}
		return sucessoDelete;
	}

	public boolean atualizar(ConsultaVO consulta, int codigoConsulta) {
		boolean sucessoAtualizar = false;
	
		String query = "UPDATE consulta SET codigoEspecializacao=?, codigoPaciente=?, codigoConvenio=?, dataConsulta=?, horarioConsulta=?"
				+ " where codigoConsulta = ? ";

		Connection conn = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conn, query);

		try {

			Calendar c = Calendar.getInstance();
			c.setTime(consulta.getDataConsulta());
			//java.sql.Date			
			Date dataSQL = new Date(c.getTimeInMillis());
			
			prepStmt.setInt(1, consulta.getEspecializacaoVO().getCodigoEspecializacao());
			prepStmt.setInt(2, consulta.getPacienteVO().getCodigoPaciente());
			prepStmt.setInt(3, consulta.getConvenioVO().getCodigoConvenio());
			prepStmt.setDate(4, dataSQL);
			prepStmt.setString(5, consulta.getHorarioConsulta());
			prepStmt.setInt(6, consulta.getCodigoConsulta());
			
			int codigoRetorno = prepStmt.executeUpdate();

			if (codigoRetorno == 1) {
				sucessoAtualizar = true;
			}
		} catch (SQLException ex) {
			System.out.println("Erro ao executar Query de Atualiza��o do Consulta!Causa: \n: " + ex.getMessage());
		} finally {
			Banco.closePreparedStatement(prepStmt);
			Banco.closeConnection(conn);
		}
		return sucessoAtualizar;
	}

	public ArrayList<ConsultaVO> listarTodos() {

		
		String query = "select * from consulta";

		Connection conn = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conn, query);
		try {
			ResultSet result = prepStmt.executeQuery();

			while (result.next()) {
				ConsultaVO consulta = new ConsultaVO();
			
				
				consulta.setCodigoConsulta(result.getInt(1));
				EspecializacaoVO especializacaoVO = especializacaoDAO.consultarPorId(result.getInt(2));
				consulta.setEspecializacaoVO(especializacaoVO);
				PacienteVO pacienteVO = pacienteDAO.consultarPorId(result.getInt(3));
				consulta.setPacienteVO(pacienteVO);
				ConvenioVO convenioVO = convenioDAO.consultarPorId(result.getInt(4));
				consulta.setConvenioVO(convenioVO);
				consulta.setDataConsulta(result.getDate(5));
				consulta.setHorarioConsulta(result.getString(6));

				listaConsultas.add(consulta);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaConsultas;
	}

	public ConsultaVO consultarPorId(int id) {
		ConsultaVO consulta = new ConsultaVO();

		String query = "SELECT * from consulta " + " where codigoConsulta like ?";

		Connection conn = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conn, query);
		try {
			prepStmt.setInt(1, id);
			ResultSet result = prepStmt.executeQuery();

			while (result.next()) {
				
				consulta.setCodigoConsulta(result.getInt(1));
				EspecializacaoVO especializacaoVO = especializacaoDAO.consultarPorId(result.getInt(2));
				consulta.setEspecializacaoVO(especializacaoVO);
				PacienteVO pacienteVO = pacienteDAO.consultarPorId(result.getInt(3));
				consulta.setPacienteVO(pacienteVO);
				ConvenioVO convenioVO = convenioDAO.consultarPorId(result.getInt(4));
				consulta.setConvenioVO(convenioVO);
				consulta.setDataConsulta(result.getDate(5));
				consulta.setHorarioConsulta(result.getString(6));
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			Banco.closeStatement(prepStmt);
			Banco.closeConnection(conn);
		}
		return consulta;
	}

}
