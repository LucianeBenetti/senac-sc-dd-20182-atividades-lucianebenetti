package Clinica_Medica.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Clinica_Medica.VO.MedicoVO;

public class MedicoDAO {

	private static ArrayList<MedicoVO> listaMedicos = new ArrayList<MedicoVO>();
	MedicoVO med = new MedicoVO();

	public int inserir(MedicoVO medicoVO) {
		int novoId = -1;

		String query = "INSERT INTO medico (nomeMedico, crm, celMensagemMedico, celularMedico, emailMedico, cpfMedico, cnpjMedico)"
				+ " VALUES (?, ?, ?, ?, ?, ?, ?)";

		Connection conn = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conn, query, Statement.RETURN_GENERATED_KEYS);

		try {
			prepStmt.setString(1, medicoVO.getNomeMedico());
			prepStmt.setString(2, medicoVO.getCrm());
			prepStmt.setString(3, medicoVO.getWhatsAppMedico());
			prepStmt.setString(4, medicoVO.getCelularMedico());
			prepStmt.setString(5, medicoVO.getEmailMedico());
			prepStmt.setString(6, medicoVO.getCpfMedico());
			prepStmt.setString(7, medicoVO.getCnpjMedico());
			

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

	public boolean delete(String cpfMedico) {
		boolean sucessoDelete = false;

		String query = "DELETE from medico where cpfMedico = ? ";

		Connection conn = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conn, query);

		try {
			prepStmt.setString(1, cpfMedico);
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

	public MedicoVO consultarMedicoVOPorCpf(String cpfMedico) {
		
		String query = "SELECT *from medico " + " where cpfMedico = ?";

		Connection conn = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conn, query);
		MedicoVO medico = null;
		ArrayList<MedicoVO> medicos = new ArrayList<MedicoVO>();

		try {
			prepStmt.setString(1, cpfMedico);
			ResultSet result = prepStmt.executeQuery();

			while (result.next()) {
				medico = new MedicoVO();

				medico.setCodigoMedico(result.getInt(1));
				medico.setNomeMedico(result.getString(2));
				medico.setCrm(result.getString(3));
				medico.setWhatsAppMedico(result.getString(4));
				medico.setCelularMedico(result.getString(5));
				medico.setEmailMedico(result.getString(6));
				medico.setCpfMedico(result.getString(7));
				medico.setCnpjMedico(result.getString(8));
				
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

		String query = "UPDATE medico SET nomeMedico=?, crm=?, celularMedico=?, celMensagemMedico=?, emailMedico=?, cpfMedico=?, cnpjMedico=?"
				+ " where cpfMedico = ?";

		Connection conn = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conn, query);

		try {
			prepStmt.setString(1, medicoVOAlterado.getNomeMedico());
			prepStmt.setString(2, medicoVOAlterado.getCrm());
			prepStmt.setString(3, medicoVOAlterado.getWhatsAppMedico());
			prepStmt.setString(4, medicoVOAlterado.getCelularMedico());
			prepStmt.setString(5, medicoVOAlterado.getEmailMedico());
			prepStmt.setString(6, medicoVOAlterado.getCpfMedico());
			prepStmt.setString(7, medicoVOAlterado.getCnpjMedico());
			prepStmt.setString(8, medicoVOAlterado.getCpfMedico());
			
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
		
		ArrayList<MedicoVO> listaMedicos = new ArrayList<MedicoVO>();
		String query = "select * from medico";

		Connection conn = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conn, query);
		try {
			ResultSet result = prepStmt.executeQuery();

			while (result.next()) {
				MedicoVO medico = new MedicoVO();

				medico.setCodigoMedico(result.getInt(1));
				medico.setNomeMedico(result.getString(2));
				medico.setCrm(result.getString(3));
				medico.setWhatsAppMedico(result.getString(4));
				medico.setCelularMedico(result.getString(5));
				medico.setEmailMedico(result.getString(6));
				medico.setCpfMedico(result.getString(7));
				medico.setCnpjMedico(result.getString(8));
				
				listaMedicos.add(medico);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaMedicos;
	}

	public ArrayList<MedicoVO> exibirMedicoPorNome(String nomeMedico) {
		
		String query = "SELECT *from medico " + " where nomeMedico = ?";

		Connection conn = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conn, query);
		MedicoVO medico = null;
		ArrayList<MedicoVO> medicos = new ArrayList<MedicoVO>();

		try {
			prepStmt.setString(1, '%' +  nomeMedico + '%');
			ResultSet result = prepStmt.executeQuery();

			while (result.next()) {
				medico = new MedicoVO();

				medico.setCodigoMedico(result.getInt(1));
				medico.setNomeMedico(result.getString(2));
				medico.setCrm(result.getString(3));
				medico.setWhatsAppMedico(result.getString(4));
				medico.setCelularMedico(result.getString(5));
				medico.setEmailMedico(result.getString(6));
				medico.setCpfMedico(result.getString(7));
				medico.setCnpjMedico(result.getString(8));
				
				medicos.add(medico);
				
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			Banco.closeStatement(prepStmt);
			Banco.closeConnection(conn);
		}
		return medicos;
	}

	public MedicoVO consultarPorId(int id) {
		String query = "SELECT *from medico " + " where codigoMedico = ?";

		Connection conn = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conn, query);
		MedicoVO medico = null;
		ArrayList<MedicoVO> medicos = new ArrayList<MedicoVO>();

		try {
			prepStmt.setInt(1, id);
			ResultSet result = prepStmt.executeQuery();

			while (result.next()) {
				medico = new MedicoVO();

				medico.setCodigoMedico(result.getInt(1));
				medico.setNomeMedico(result.getString(2));
				medico.setCrm(result.getString(3));
				medico.setWhatsAppMedico(result.getString(4));
				medico.setCelularMedico(result.getString(5));
				medico.setEmailMedico(result.getString(6));
				medico.setCpfMedico(result.getString(7));
				medico.setCnpjMedico(result.getString(8));
				
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
	}



