package Clinica_Medica.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Clinica_Medica.VO.PacienteVO;
import Clinica_Medica.Banco;

public class PacienteDAO {
	private static ArrayList<PacienteVO> listapacientes = new ArrayList<PacienteVO>();

	public int inserirPaciente(PacienteVO paciente) {

		int novoId = 0;

		String sql = "INSERT INTO paciente (pacNome, celMen, foneRes, foneCom, email, cpf, cnpj, logradouro, numLog, complemento, bairro, cidade, uf, cep)" + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

		Connection conn = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conn, sql, Statement.RETURN_GENERATED_KEYS);

		try {
			prepStmt.setString(1, paciente.getPacNome());
			prepStmt.setString(2, paciente.getCelMen());
			prepStmt.setString(3, paciente.getFoneRes());
			prepStmt.setString(4, paciente.getFoneCom());
			prepStmt.setString(5, paciente.getEmail());
			prepStmt.setString(6, paciente.getCpf());
			prepStmt.setString(7, paciente.getCnpj());
			prepStmt.setString(8, paciente.getLogradouro());
			prepStmt.setString(9, paciente.getNumLog());
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

	public String consultarPcaientePorCpf(String cpf) {
		
		PacienteVO paciente = new PacienteVO();

		String query = "SELECT *from paciente " + " where cpf = ?";

		Connection conn = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conn, query);
		try {
			prepStmt.setString(1, cpf);
			ResultSet result = prepStmt.executeQuery();

			while (result.next()) {
				
				paciente.setPacCod(result.getInt(1));
				paciente.setPacNome(result.getString(2));
				paciente.setCelMen(result.getString(3));
				paciente.setFoneRes(result.getString(4));
				paciente.setFoneCom(result.getString(5));
				paciente.setEmail(result.getString(6));
				paciente.setCpf(result.getString(7));
				paciente.setCnpj(result.getString(8));
				paciente.setLogradouro(result.getString(9));
				paciente.setNumLog(result.getString(10));
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
		return paciente.toString();
	}

	public boolean delete(String cpf) {
		boolean sucessoDelete = false;

		String query = "DELETE from paciente where cpf = ? ";

		Connection conn = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conn, query);

		try {
			prepStmt.setString(1, cpf);
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
										 
		String query = "UPDATE paciente SET pacNome=?, celMen=?, foneRes=?, foneCom=?, email=?, cpf=?, cnpj=?, logradouro=?, numLog=?, complemento=?, bairro=?, cidade=?, uf=?, cep=?"
				+ " where cpf = ?";

		Connection conn = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conn, query);

		try {
			prepStmt.setString(1, pacienteAlterado.getPacNome());
			prepStmt.setString(2, pacienteAlterado.getCelMen());
			prepStmt.setString(3, pacienteAlterado.getFoneRes());
			prepStmt.setString(4, pacienteAlterado.getFoneCom());
			prepStmt.setString(5, pacienteAlterado.getEmail());
			prepStmt.setString(6, pacienteAlterado.getCpf());
			prepStmt.setString(7, pacienteAlterado.getCnpj());
			prepStmt.setString(8, pacienteAlterado.getLogradouro());
			prepStmt.setString(9, pacienteAlterado.getNumLog());
			prepStmt.setString(10, pacienteAlterado.getComplemento());
			prepStmt.setString(11, pacienteAlterado.getBairro());
			prepStmt.setString(12, pacienteAlterado.getCidade());
			prepStmt.setString(13, pacienteAlterado.getUf());
			prepStmt.setString(14, pacienteAlterado.getCep());
			prepStmt.setString(16, pacienteAlterado.getCpf());

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
	
	public String listarTodos() {

		String query = "select * from paciente";

		Connection conn = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conn, query);
		try {
			ResultSet result = prepStmt.executeQuery();

			while (result.next()) {
				PacienteVO paciente = new PacienteVO();

				paciente.setPacCod(result.getInt(1));
				paciente.setPacNome(result.getString(2));
				paciente.setCelMen(result.getString(3));
				paciente.setFoneRes(result.getString(4));
				paciente.setFoneCom(result.getString(5));
				paciente.setEmail(result.getString(6));
				paciente.setCpf(result.getString(7));
				paciente.setCnpj(result.getString(8));
				paciente.setLogradouro(result.getString(9));
				paciente.setNumLog(result.getString(10));
				paciente.setComplemento(result.getString(11));
				paciente.setBairro(result.getString(12));
				paciente.setCidade(result.getString(13));
				paciente.setUf(result.getString(14));
				paciente.setCep(result.getString(15));
				

				listapacientes.add(paciente);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listapacientes.toString();
	}

}
