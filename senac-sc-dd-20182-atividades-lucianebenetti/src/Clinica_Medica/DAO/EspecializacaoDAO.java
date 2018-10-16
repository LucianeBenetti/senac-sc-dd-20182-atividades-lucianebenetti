package Clinica_Medica.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Clinica_Medica.Banco;
import Clinica_Medica.VO.EspecializacaoVO;

public class EspecializacaoDAO {
	
	private static ArrayList<EspecializacaoVO> listaEspecializacao = new ArrayList<EspecializacaoVO>();

	public int inserirEspecializacao(EspecializacaoVO especializacao) {

		int novoId = 0;

		String sql = "INSERT INTO especializacao (espCod, medCod, espeAno)" + " VALUES (?,?,?)";

		Connection conn = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conn, sql, Statement.RETURN_GENERATED_KEYS);

		try {
			
			prepStmt.setInt(1, especializacao.getEspCod());
			prepStmt.setInt(2, especializacao.getMedCod());
			prepStmt.setString(3, especializacao.getEspeAno());
				
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

	public String consultaPorAno(String espeAno) {
		
		EspecializacaoVO especializacao = new EspecializacaoVO();

		String query = "SELECT *from especializacao " + " where espeAno = ?";

		Connection conn = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conn, query);
		try {
			prepStmt.setString(1, espeAno);
			ResultSet result = prepStmt.executeQuery();

			while (result.next()) {
				
				especializacao.setEspeCod(result.getInt(1));
				especializacao.setEspCod(result.getInt(2));
				especializacao.setMedCod(result.getInt(3));
				especializacao.setEspeAno(result.getString(4));
				
				
			}
		} catch (SQLException ex) {
			System.out.println("Erro ao executar Query de Consultar do Especializacão! Causa: \n: " + ex.getMessage());
		} finally {
			Banco.closeStatement(prepStmt);
			Banco.closeConnection(conn);
		}
		return especializacao.toString();
	}

	public boolean delete(int espeCod) {
		boolean sucessoDelete = false;

		String query = "DELETE from especializacao where espeCod = ? ";

		Connection conn = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conn, query);

		try {
			prepStmt.setInt(1, espeCod);
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

	
	public boolean atualizar(EspecializacaoVO especializacaoAlterado, String espeCod) {
		boolean sucessoAtualizar = false;
		EspecializacaoVO especializacao = new EspecializacaoVO();							 
		String query = "UPDATE especializacao SET espCod=?, medCod=?, espeAno=?"
				+ " where espeCod = ?";

		Connection conn = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conn, query);

		try {

			prepStmt.setInt(1, especializacao.getEspCod());
			prepStmt.setInt(2, especializacao.getMedCod());
			prepStmt.setString(3, especializacao.getEspeAno());
			prepStmt.setString(4, especializacao.getEspeAno());

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

				especializacao.setEspeCod(result.getInt(1));
				especializacao.setEspCod(result.getInt(2));
				especializacao.setMedCod(result.getInt(3));
				especializacao.setEspeAno(result.getString(4));
				

				listaEspecializacao.add(especializacao);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaEspecializacao.toString();
	}


	
	

}
