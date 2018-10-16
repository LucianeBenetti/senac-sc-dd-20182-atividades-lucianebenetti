package Clinica_Medica.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;

import Clinica_Medica.Banco;
import Clinica_Medica.VO.ConsultaVO;


public class ConsultaDAO {
	
	private static ArrayList<ConsultaVO> listaConsultas = new ArrayList<ConsultaVO>();

	public int inserirConsulta(ConsultaVO consulta) {

		int novoId = 0;

		String sql = "INSERT INTO consulta (espeCod, pacCod, convCod, pronCod, conData, conHorario)" + " VALUES (?,?,?,?,?,?)";

		Connection conn = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conn, sql, Statement.RETURN_GENERATED_KEYS);

		try {
			
			prepStmt.setInt(1, consulta.getEspeCod());
			prepStmt.setInt(2, consulta.getPacCod());
			prepStmt.setInt(3, consulta.getConvCod());
			prepStmt.setInt(4, consulta.getPronCod());
			prepStmt.setDate(5, (Date) consulta.getConData());
			prepStmt.setTime(6, (Time) consulta.getConHorario());
		
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

		String query = "SELECT *from consulta " + " where pacNome like ?";//refazer o select

		Connection conn = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conn, query);
		try {
			prepStmt.setString(1, paciente);
			ResultSet result = prepStmt.executeQuery();

			while (result.next()) {
				
				consulta.setConCod(result.getInt(1));
				consulta.setEspeCod(result.getInt(2));
				consulta.setPacCod(result.getInt(3));
				consulta.setPronCod(result.getInt(4));
				consulta.setConvCod(result.getInt(5));
				consulta.setConData(result.getDate(6));
				consulta.setConHorario(result.getTime(7));
				
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			Banco.closeStatement(prepStmt);
			Banco.closeConnection(conn);
		}
		return consulta.toString();
	}

	public boolean delete(int conCod) {
		boolean sucessoDelete = false;

		String query = "DELETE from consulta where conCod = ? ";

		Connection conn = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conn, query);

		try {
			prepStmt.setInt(1, conCod);
			int codigoRetorno = prepStmt.executeUpdate();
			if (codigoRetorno == 1) {
				sucessoDelete = true;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar Query de Exclusão do Consulta! Causa: \n: " + e.getMessage());
		} finally {
			Banco.closePreparedStatement(prepStmt);
			Banco.closeConnection(conn);
		}
		return sucessoDelete;
	}

	
	public boolean atualizar(ConsultaVO consultaAlterado, String conCod) {
		boolean sucessoAtualizar = false;
		ConsultaVO consulta = new ConsultaVO();						 
		String query = "UPDATE consulta SET espeCod=?, pacCod=?, convCod=?, pronCod=?, conData=?, conHorario=?"
				+ " where conCod =?";

		Connection conn = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conn, query);

		try {

			prepStmt.setInt(1, consulta.getEspeCod());
			prepStmt.setInt(2, consulta.getPacCod());
			prepStmt.setInt(3, consulta.getConvCod());
			prepStmt.setInt(4, consulta.getPronCod());
			prepStmt.setDate(5, (Date) consulta.getConData());
			prepStmt.setTime(6, (Time) consulta.getConHorario());
			prepStmt.setInt(7, consulta.getConCod());

			int codigoRetorno = prepStmt.executeUpdate();

			if (codigoRetorno == 1) {
				sucessoAtualizar = true;
			}
		} catch (SQLException ex) {
			System.out.println("Erro ao executar Query de Atualização do Consulta!Causa: \n: " + ex.getMessage());
		} finally {
			Banco.closePreparedStatement(prepStmt);
			Banco.closeConnection(conn);
		}
		return sucessoAtualizar;
	}
	
	public String listarTodos() {

		String query = "select * from consulta";

		Connection conn = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conn, query);
		try {
			ResultSet result = prepStmt.executeQuery();

			while (result.next()) {
				ConsultaVO consulta = new ConsultaVO();

				consulta.setConCod(result.getInt(1));
				consulta.setEspeCod(result.getInt(2));
				consulta.setPacCod(result.getInt(3));
				consulta.setPronCod(result.getInt(4));
				consulta.setConvCod(result.getInt(5));
				consulta.setConData(result.getDate(6));
				consulta.setConHorario(result.getTime(7));
				
				listaConsultas.add(consulta);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaConsultas.toString();
	}


}
