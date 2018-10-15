package Clinica_Medica.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Clinica_Medica.Banco;
import Clinica_Medica.VO.ConsultaVO;

public class ConsultaDAO {
	
	private static ArrayList<ConsultaVO> listaConsultas = new ArrayList<ConsultaVO>();

	public int inserirConsulta(ConsultaVO consulta) {

		int novoId = 0;

		String sql = "INSERT INTO consulta (pacCod, espeCod, pacCod, convCod, conTipo, dataMarcacao, dataRealizacao)" + " VALUES (?,?,?,?,?,?,?)";

		Connection conn = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conn, sql, Statement.RETURN_GENERATED_KEYS);

		try {
			
			prepStmt.setInt(1, consulta.getPacCod());
			prepStmt.setInt(2, consulta.getEspeCod());
			prepStmt.setInt(3, consulta.getPacCod());
			prepStmt.setInt(4, consulta.getConvCod());
			prepStmt.setString(5, consulta.getConTipo());
			prepStmt.setDate(6, (Date) consulta.getDataMarcacao());
			prepStmt.setDate(7, (Date) consulta.getDataRealizacao());
		
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

	public String consultarPorUnidaed(String conUnidade) {
		
		ConsultaVO consulta = new ConsultaVO();

		String query = "SELECT *from consulta " + " where conUnidade like ?";

		Connection conn = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conn, query);
		try {
			prepStmt.setString(1, conUnidade);
			ResultSet result = prepStmt.executeQuery();

			while (result.next()) {
				
				consulta.setConCod(result.getInt(1));
				consulta.setPacCod(result.getInt(2));
				consulta.setEspeCod(result.getInt(3));
				consulta.setPacCod(result.getInt(4));
				consulta.setConvCod(result.getInt(5));
				consulta.setConTipo(result.getString(6));
				consulta.setDataMarcacao(result.getDate(7));
				consulta.setDataRealizacao(result.getDate(8));
				
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

	
	public boolean atualizar(ConsultaVO consultaAlterado, String conUnidade) {
		boolean sucessoAtualizar = false;
		ConsultaVO consulta = new ConsultaVO();							 
		String query = "UPDATE consulta SET pacCod=?, espeCod=?, espCod=?, foneCom=?, medCod=?, conHorario=?, conUnidade=?, conFuncionario=?"
				+ " where conUnicade like ?";

		Connection conn = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conn, query);

		try {

			prepStmt.setInt(1, consulta.getPacCod());
			prepStmt.setInt(2, consulta.getEspeCod());
			prepStmt.setInt(3, consulta.getPacCod());
			prepStmt.setInt(4, consulta.getConvCod());
			prepStmt.setString(5, consulta.getConTipo());
			prepStmt.setDate(6, (Date) consulta.getDataMarcacao());
			prepStmt.setDate(7, (Date) consulta.getDataRealizacao());
		

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
				consulta.setPacCod(result.getInt(2));
				consulta.setEspeCod(result.getInt(3));
				consulta.setPacCod(result.getInt(4));
				consulta.setConvCod(result.getInt(5));
				consulta.setConTipo(result.getString(6));
				consulta.setDataMarcacao(result.getDate(7));
				consulta.setDataRealizacao(result.getDate(8));
				

				listaConsultas.add(consulta);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaConsultas.toString();
	}


}
