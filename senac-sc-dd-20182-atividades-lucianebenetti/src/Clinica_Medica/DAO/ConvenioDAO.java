package Clinica_Medica.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Clinica_Medica.VO.ConvenioVO;

public class ConvenioDAO {
	private static ArrayList<ConvenioVO> listaConvenios = new ArrayList<ConvenioVO>();

	public int inserirConvenio(ConvenioVO convenio) {

		int novoId = 0;

		String sql = "INSERT INTO convenio (convNome, convCnpj, valor)" + " VALUES (?,?,?)";

		Connection conn = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conn, sql, Statement.RETURN_GENERATED_KEYS);

		try {
					
			prepStmt.setString(1, convenio.getConvNome());
			prepStmt.setString(2, convenio.getConvCnpj());
			prepStmt.setDouble(3, convenio.getValor());
		
			prepStmt.executeUpdate();

			ResultSet generatedKeys = prepStmt.getGeneratedKeys();

			if (generatedKeys.next()) {
				novoId = generatedKeys.getInt(1);
				
			}

		} catch (SQLException e) {
			System.out.println("Erro ao executar o Cadastro do Convenio! Causa: \n: " + e.getMessage());

		} finally {
			Banco.closePreparedStatement(prepStmt);
			Banco.closeConnection(conn);
		}
		return novoId;

	}

	public ConvenioVO consultarConvenioPorCnpj(String convCnpj) {
		
		ConvenioVO convenio = null;

		String query = "SELECT *from convenio " + " where convCnpj = ?";

		Connection conn = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conn, query);
		try {
			prepStmt.setString(1, convCnpj);
			ResultSet result = prepStmt.executeQuery();

			while (result.next()) {
				convenio = new ConvenioVO();
				convenio.setConvCod(result.getInt(1));
				convenio.setConvNome(result.getString(2));
				convenio.setConvCnpj(result.getString(3));
				convenio.setValor(result.getDouble(4));
			
								
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			Banco.closeStatement(prepStmt);
			Banco.closeConnection(conn);
		}
		return convenio;
	}

	public boolean delete(String convCnpj) {
		boolean sucessoDelete = false;

		String query = "DELETE from convenio where convCnpj = ? ";

		Connection conn = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conn, query);

		try {
			prepStmt.setString(1, convCnpj);
			int codigoRetorno = prepStmt.executeUpdate();
			if (codigoRetorno == 1) {
				sucessoDelete = true;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar Query de Exclusão do Convenio! Causa: \n: " + e.getMessage());
		} finally {
			Banco.closePreparedStatement(prepStmt);
			Banco.closeConnection(conn);
		}
		return sucessoDelete;
	}

	
	public boolean atualizar(ConvenioVO convenio, String convCnpj) {
		boolean sucessoAtualizar = false;
						 
		String query = "UPDATE convenio SET convNome=?, convCnpj=?, valor=? " + " where convCnpj = ?";

		Connection conn = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conn, query);

		try {

			prepStmt.setString(1, convenio.getConvNome());
			prepStmt.setString(2, convenio.getConvCnpj());
			prepStmt.setDouble(3, convenio.getValor());
			prepStmt.setString(4, convenio.getConvCnpj());
			
			int codigoRetorno = prepStmt.executeUpdate();

			if (codigoRetorno == 1) {
				sucessoAtualizar = true;
			}
		} catch (SQLException ex) {
			System.out.println("Erro ao executar Query de Atualização do Convenio!Causa: \n: " + ex.getMessage());
		} finally {
			Banco.closePreparedStatement(prepStmt);
			Banco.closeConnection(conn);
		}
		return sucessoAtualizar;
	}
	
	public ArrayList<ConvenioVO> listarTodos() {

		String query = "select * from convenio";

		Connection conn = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conn, query);
		try {
			ResultSet result = prepStmt.executeQuery();

			while (result.next()) {
				ConvenioVO convenio = new ConvenioVO();

				convenio.setConvCod(result.getInt(1));
				convenio.setConvNome(result.getString(2));
				convenio.setConvCnpj(result.getString(3));
				convenio.setValor(result.getDouble(4));

				listaConvenios.add(convenio);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaConvenios;
	}

	
	
}
