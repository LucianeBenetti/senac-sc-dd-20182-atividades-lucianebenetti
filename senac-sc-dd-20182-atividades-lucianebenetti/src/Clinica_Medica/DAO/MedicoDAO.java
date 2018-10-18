package Clinica_Medica.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Clinica_Medica.VO.MedicoVO;

public class MedicoDAO {

	private static ArrayList<MedicoVO> listamedicos = new ArrayList<MedicoVO>();
	MedicoVO med = new MedicoVO();

	public int inserir(MedicoVO medicoVO) {
		int novoId = -1;

		String query = "INSERT INTO medico (medNome, crm, celMen, cel, email, cpf, cnpj)"
				+ " VALUES (?, ?, ?, ?, ?, ?, ?)";

		Connection conn = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conn, query, Statement.RETURN_GENERATED_KEYS);

		try {
			prepStmt.setString(1, medicoVO.getMedNome());
			prepStmt.setString(2, medicoVO.getCrm());
			prepStmt.setString(3, medicoVO.getCelMen());
			prepStmt.setString(4, medicoVO.getCel());
			prepStmt.setString(5, medicoVO.getEmail());
			prepStmt.setString(6, medicoVO.getCpf());
			prepStmt.setString(7, medicoVO.getCnpj());
			

			prepStmt.executeUpdate();

			ResultSet generatedKeys = prepStmt.getGeneratedKeys();
			if (generatedKeys.next()) {
				novoId = generatedKeys.getInt(1);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar Query de Cadastro de Médico! Causa: \n: " + e.getMessage());
		} finally {
			Banco.closePreparedStatement(prepStmt);
			Banco.closeConnection(conn);
		}
		return novoId;
	}

	public boolean delete(String cpf) {
		boolean sucessoDelete = false;

		String query = "DELETE from medico where cpf = ? ";

		Connection conn = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conn, query);

		try {
			prepStmt.setString(1, cpf);
			int codigoRetorno = prepStmt.executeUpdate();
			if (codigoRetorno == 1) {
				sucessoDelete = true;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar Query de Exclusão do Médico! Causa: \n: " + e.getMessage());
		} finally {
			Banco.closePreparedStatement(prepStmt);
			Banco.closeConnection(conn);
		}
		return sucessoDelete;
	}

	public MedicoVO consultarMedicoVOPorCpf(String cpf) {
		
		String query = "SELECT *from medico " + " where cpf = ?";

		Connection conn = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conn, query);
		MedicoVO medico = null;
		ArrayList<MedicoVO> medicos = new ArrayList<MedicoVO>();

		try {
			prepStmt.setString(1, cpf);
			ResultSet result = prepStmt.executeQuery();

			while (result.next()) {
				medico = new MedicoVO();

				medico.setMedCod(result.getInt(1));
				medico.setMedNome(result.getString(2));
				medico.setCrm(result.getString(3));
				medico.setCelMen(result.getString(4));
				medico.setCel(result.getString(5));
				medico.setEmail(result.getString(6));
				medico.setCpf(result.getString(7));
				medico.setCnpj(result.getString(8));
				
				medicos.add(medico);
				
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			Banco.closeStatement(prepStmt);
			Banco.closeConnection(conn);
		}
		return medico;
	}

	public boolean atualizar(MedicoVO medicoVOAlterado, String cpfAnterior) {
		boolean sucessoAtualizar = false;

		String query = "UPDATE medico SET medNome=?, crm=?, cel=?, celMen=?, email=?, cpf=?, cnpj=?"
				+ " where cpf = ?";

		Connection conn = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conn, query);

		try {
			prepStmt.setString(1, medicoVOAlterado.getMedNome());
			prepStmt.setString(2, medicoVOAlterado.getCrm());
			prepStmt.setString(3, medicoVOAlterado.getCel());
			prepStmt.setString(4, medicoVOAlterado.getCelMen());
			prepStmt.setString(5, medicoVOAlterado.getEmail());
			prepStmt.setString(6, medicoVOAlterado.getCpf());
			prepStmt.setString(7, medicoVOAlterado.getCnpj());
			
			int codigoRetorno = prepStmt.executeUpdate();

			if (codigoRetorno == 1) {
				sucessoAtualizar = true;
			}
		} catch (SQLException ex) {
			System.out.println("Erro ao executar Query de Atualização do Médico!Causa: \n: " + ex.getMessage());
		} finally {
			Banco.closePreparedStatement(prepStmt);
			Banco.closeConnection(conn);
		}
		return sucessoAtualizar;
	}

	public ArrayList<MedicoVO> listarTodos() {

		String query = "select * from medico";

		Connection conn = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conn, query);
		try {
			ResultSet result = prepStmt.executeQuery();

			while (result.next()) {
				MedicoVO medico = new MedicoVO();

				medico.setMedCod(result.getInt(1));
				medico.setMedNome(result.getString(2));
				medico.setCrm(result.getString(3));
				medico.setCel(result.getString(4));
				medico.setCelMen(result.getString(5));
				medico.setEmail(result.getString(6));
				medico.setCpf(result.getString(7));
				medico.setCnpj(result.getString(8));
				
				listamedicos.add(medico);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listamedicos;
	}

}
