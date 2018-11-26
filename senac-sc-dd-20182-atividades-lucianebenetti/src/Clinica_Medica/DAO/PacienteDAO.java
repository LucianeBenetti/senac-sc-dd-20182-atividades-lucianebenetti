package Clinica_Medica.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Clinica_Medica.VO.PacienteVO;

public class PacienteDAO {
	private static ArrayList<PacienteVO> listaPacientes = new ArrayList<PacienteVO>();

	public int inserirPaciente(PacienteVO paciente) {

		int novoId = 0;

		String sql = "INSERT INTO paciente (nomePaciente, celMensagemPaciente, foneResidencial, foneComercial, emailPaciente, cpfPaciente, cnpjPaciente, logradouro, numeroLogradouro, complemento, bairro, cidade, uf, cep)" + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

		Connection conn = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conn, sql, Statement.RETURN_GENERATED_KEYS);

		try {
			prepStmt.setString(1, paciente.getNomePaciente());
			prepStmt.setString(2, paciente.getWhatsAppPaciente());
			prepStmt.setString(3, paciente.getFoneResidencial());
			prepStmt.setString(4, paciente.getFoneComercial());
			prepStmt.setString(5, paciente.getEmailPaciente());
			prepStmt.setString(6, paciente.getCpfPaciente());
			prepStmt.setString(7, paciente.getCnpjPaciente());
			prepStmt.setString(8, paciente.getLogradouro());
			prepStmt.setString(9, paciente.getNumeroLogradouro());
			prepStmt.setString(10, paciente.getComplemento());
			prepStmt.setString(11, paciente.getBairro());
			prepStmt.setString(12, paciente.getCidade());
			prepStmt.setString(13, paciente.getUf());
			prepStmt.setString(14, paciente.getCep());
			
		
			prepStmt.executeUpdate();

			ResultSet generatedKeys = prepStmt.getGeneratedKeys();

			if (generatedKeys.next()) {
				novoId = generatedKeys.getInt(1);
				
			}

		} catch (SQLException e) {
			System.out.println("Erro ao executar o Cadastro do paciente! Causa: \n: " + e.getMessage());

		} finally {
			Banco.closePreparedStatement(prepStmt);
			Banco.closeConnection(conn);
		}
		return novoId;

	}

	public PacienteVO consultarPacientePorCpf(String cpfPaciente) {
		
		String query = "SELECT *from paciente " + " where cpfPaciente = ?";

		Connection conn = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conn, query);
		PacienteVO paciente = null;
		try {
			prepStmt.setString(1, cpfPaciente);
			ResultSet result = prepStmt.executeQuery();

			while (result.next()) {
				paciente = new PacienteVO();
				paciente.setCodigoPaciente(result.getInt(1));
				paciente.setNomePaciente(result.getString(2));
				paciente.setWhatsAppPaciente(result.getString(3));
				paciente.setFoneResidencial(result.getString(4));
				paciente.setFoneComercial(result.getString(5));
				paciente.setEmailPaciente(result.getString(6));
				paciente.setCpfPaciente(result.getString(7));
				paciente.setCnpjPaciente(result.getString(8));
				paciente.setLogradouro(result.getString(9));
				paciente.setNumeroLogradouro(result.getString(10));
				paciente.setComplemento(result.getString(11));
				paciente.setBairro(result.getString(12));
				paciente.setCidade(result.getString(13));
				paciente.setUf(result.getString(14));
				paciente.setCep(result.getString(15));
				

			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			Banco.closeStatement(prepStmt);
			Banco.closeConnection(conn);
		}
		return paciente;
	}

	public boolean delete(String cpfPaciente) {
		boolean sucessoDelete = false;

		String query = "DELETE from paciente where cpfPaciente = ? ";

		Connection conn = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conn, query);

		try {
			prepStmt.setString(1, cpfPaciente);
			int codigoRetorno = prepStmt.executeUpdate();
			if (codigoRetorno == 1) {
				sucessoDelete = true;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar Query de Exclusão do Paciente! Causa: \n: " + e.getMessage());
		} finally {
			Banco.closePreparedStatement(prepStmt);
			Banco.closeConnection(conn);
		}
		return sucessoDelete;
	}

	
	public boolean atualizar(PacienteVO pacienteAlterado, String cpfAnterior) {
		boolean sucessoAtualizar = false;
										 
		String query = "UPDATE paciente SET nomePaciente=?, celMensagemPaciente=?, foneResidencial=?, foneComercial=?, emailPaciente=?, cpfPaciente=?, cnpjPaciente=?, logradouro=?, numeroLogradouro=?, complemento=?, bairro=?, cidade=?, uf=?, cep=? "
				+ " where cpfPaciente = ?";

		Connection conn = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conn, query);

		try {
			prepStmt.setString(1, pacienteAlterado.getNomePaciente());
			prepStmt.setString(2, pacienteAlterado.getWhatsAppPaciente());
			prepStmt.setString(3, pacienteAlterado.getFoneResidencial());
			prepStmt.setString(4, pacienteAlterado.getFoneComercial());
			prepStmt.setString(5, pacienteAlterado.getEmailPaciente());
			prepStmt.setString(6, pacienteAlterado.getCpfPaciente());
			prepStmt.setString(7, pacienteAlterado.getCnpjPaciente());
			prepStmt.setString(8, pacienteAlterado.getLogradouro());
			prepStmt.setString(9, pacienteAlterado.getNumeroLogradouro());
			prepStmt.setString(10, pacienteAlterado.getComplemento());
			prepStmt.setString(11, pacienteAlterado.getBairro());
			prepStmt.setString(12, pacienteAlterado.getCidade());
			prepStmt.setString(13, pacienteAlterado.getUf());
			prepStmt.setString(14, pacienteAlterado.getCep());
			prepStmt.setString(15, pacienteAlterado.getCpfPaciente());

			int codigoRetorno = prepStmt.executeUpdate();

			if (codigoRetorno == 1) {
				sucessoAtualizar = true;
			}
		} catch (SQLException ex) {
			System.out.println("Erro ao executar Query de Atualização do Paciente!Causa: \n: " + ex.getMessage());
		} finally {
			Banco.closePreparedStatement(prepStmt);
			Banco.closeConnection(conn);
		}
		return sucessoAtualizar;
	}
	
	public ArrayList<PacienteVO> listarTodos() {

		ArrayList<PacienteVO> listaPacientes = new ArrayList<PacienteVO>();
		String query = "select * from paciente";

		Connection conn = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conn, query);
		try {
			ResultSet result = prepStmt.executeQuery();

			while (result.next()) {
				PacienteVO paciente = new PacienteVO();

				paciente.setCodigoPaciente(result.getInt(1));
				paciente.setNomePaciente(result.getString(2));
				paciente.setWhatsAppPaciente(result.getString(3));
				paciente.setFoneResidencial(result.getString(4));
				paciente.setFoneComercial(result.getString(5));
				paciente.setEmailPaciente(result.getString(6));
				paciente.setCpfPaciente(result.getString(7));
				paciente.setCnpjPaciente(result.getString(8));
				
					listaPacientes.add(paciente);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaPacientes;
	}

	public PacienteVO consultarPorId(int id) {
		String query = "SELECT *from paciente " + " where codigoPaciente = ?";

		Connection conn = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conn, query);
		PacienteVO paciente = null;
		try {
			prepStmt.setInt(1, id);
			ResultSet result = prepStmt.executeQuery();

			while (result.next()) {
			
				paciente = new PacienteVO();
				paciente.setCodigoPaciente(result.getInt(1));
				paciente.setNomePaciente(result.getString(2));
				paciente.setWhatsAppPaciente(result.getString(3));
				paciente.setFoneResidencial(result.getString(4));
				paciente.setFoneComercial(result.getString(5));
				paciente.setEmailPaciente(result.getString(6));
				paciente.setCpfPaciente(result.getString(7));
				paciente.setCnpjPaciente(result.getString(8));
				paciente.setLogradouro(result.getString(9));
				paciente.setNumeroLogradouro(result.getString(10));
				paciente.setComplemento(result.getString(11));
				paciente.setBairro(result.getString(12));
				paciente.setCidade(result.getString(13));
				paciente.setUf(result.getString(14));
				paciente.setCep(result.getString(15));
				

			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			Banco.closeStatement(prepStmt);
			Banco.closeConnection(conn);
		}
		return paciente;
	}
}
