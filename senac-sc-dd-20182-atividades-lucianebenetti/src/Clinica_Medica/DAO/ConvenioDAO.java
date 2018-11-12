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
	

	public int inserirConvenio(ConvenioVO convenio) {

		int novoId = 0;

		String sql = "INSERT INTO convenio (nomeConvenio, cnpjConvenio, valorConvenio)" + " VALUES (?,?,?)";

		Connection conn = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conn, sql, Statement.RETURN_GENERATED_KEYS);

		try {

			prepStmt.setString(1, convenio.getNomeConvenio());
			prepStmt.setString(2, convenio.getCnpjConvenio());
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

	public ConvenioVO consultarConvenioPorCnpj(String cnpjConvenio) {

		ConvenioVO convenio = null;

		String query = "SELECT *from convenio " + " where cnpjConvenio = ?";

		Connection conn = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conn, query);
		try {
			prepStmt.setString(1, cnpjConvenio);
			ResultSet result = prepStmt.executeQuery();

			while (result.next()) {
				convenio = new ConvenioVO();
				convenio.setCodigoConvenio(result.getInt(1));
				convenio.setNomeConvenio(result.getString(2));
				convenio.setCnpjConvenio(result.getString(3));
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

	public boolean delete(String cnpjConvenio) {
		boolean sucessoDelete = false;

		String query = "DELETE from convenio where cnpjConvenio = ? ";

		Connection conn = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conn, query);

		try {
			prepStmt.setString(1, cnpjConvenio);
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

	public boolean atualizar(ConvenioVO convenio, String cnpjConvenio) {
		boolean sucessoAtualizar = false;

		String query = "UPDATE convenio SET nomeConvenio=?, cnpjConvenio=?, valorConvenio=? " + " where cnpjConvenio = ?";

		Connection conn = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conn, query);

		try {

			prepStmt.setString(1, convenio.getNomeConvenio());
			prepStmt.setString(2, convenio.getCnpjConvenio());
			prepStmt.setDouble(3, convenio.getValor());
			prepStmt.setString(4, convenio.getCnpjConvenio());

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

		ArrayList<ConvenioVO> listaConvenios = new ArrayList<ConvenioVO>();
		
		String query = "select * from convenio";

		Connection conn = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conn, query);
		try {
			ResultSet result = prepStmt.executeQuery();

			while (result.next()) {
				ConvenioVO convenio = new ConvenioVO();

				convenio.setCodigoConvenio(result.getInt(1));
				convenio.setNomeConvenio(result.getString(2));
				convenio.setCnpjConvenio(result.getString(3));
				convenio.setValor(result.getDouble(4));

				listaConvenios.add(convenio);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaConvenios;
	}

	public ConvenioVO consultarPorId(int id) {
		ConvenioVO convenio = null;

		String query = "SELECT *from convenio " + " where codigoConvenio = ?";

		Connection conn = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conn, query);
		try {
			prepStmt.setInt(1, id);
			ResultSet result = prepStmt.executeQuery();

			while (result.next()) {
				convenio = new ConvenioVO();
				convenio.setCodigoConvenio(result.getInt(1));
				convenio.setNomeConvenio(result.getString(2));
				convenio.setCnpjConvenio(result.getString(3));
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

}
