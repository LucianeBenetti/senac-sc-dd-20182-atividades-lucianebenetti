package projetoFinalLucianeMarco.Clinica_Medica.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import projetoFinalLucianeMarco.Clinica_Medica.Banco;
import projetoFinalLucianeMarco.Clinica_Medica.VO.MedicoVO;

public class MedicoDAO {

	private static ArrayList<MedicoVO> listamedicos = new ArrayList<MedicoVO>();
	MedicoVO med = new MedicoVO();

	public int inserir(MedicoVO medicoVO) {
		int novoId = -1;

		String query = "INSERT INTO medico (medNome, crm, cel, celMen, email, cpf, cnpj, logradouro, numLog, complemento, bairro, cidade, uf, cep)"
				+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		Connection conn = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conn, query, Statement.RETURN_GENERATED_KEYS);

		try {
			prepStmt.setString(1, med.getMedNome());
			prepStmt.setString(2, med.getCrm());
			prepStmt.setString(3, med.getCel());
			prepStmt.setString(4, med.getCelMen());
			prepStmt.setString(5, med.getEmail());
			prepStmt.setString(6, med.getCpf());
			prepStmt.setString(7, med.getCnpj());
			prepStmt.setString(8, med.getLogradouro());
			prepStmt.setString(9, med.getNumLog());
			prepStmt.setString(10, med.getComplemento());
			prepStmt.setString(11, med.getBairro());
			prepStmt.setString(12, med.getCidade());
			prepStmt.setString(13, med.getUf());
			prepStmt.setString(14, med.getCep());

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

	public String consultarMedicoVOPorCRM(String crm) {

		String query = "SELECT *from medico " + " where crm = ?";

		Connection conn = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conn, query);
		try {
			prepStmt.setString(1, crm);
			ResultSet result = prepStmt.executeQuery();

			while (result.next()) {

				med.setMedCod(result.getInt(1));
				med.setMedNome(result.getString(2));
				med.setCrm(result.getString(3));
				med.setCel(result.getString(4));
				med.setCelMen(result.getString(5));
				med.setEmail(result.getString(6));
				med.setCpf(result.getString(7));
				med.setCnpj(result.getString(8));
				med.setLogradouro(result.getString(9));
				med.setNumLog(result.getString(10));
				med.setComplemento(result.getString(11));
				med.setBairro(result.getString(12));
				med.setCidade(result.getString(13));
				med.setUf(result.getString(14));
				med.setCep(result.getString(15));

			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			Banco.closeStatement(prepStmt);
			Banco.closeConnection(conn);
		}
		return med.toString();
	}

	public boolean atualizar(MedicoVO medicoVOAlterado, String cpfAnterior) {
		boolean sucessoAtualizar = false;

		String query = "UPDATE medico SET medNome=?, crm=?, cel=?, celMen=?, email=?, cpf=?, cnpj=?, logradouro=?, numLog=?, complemento=?, bairro=?, cidade=?, uf=?, cep=?"
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
			prepStmt.setString(8, medicoVOAlterado.getLogradouro());
			prepStmt.setString(9, medicoVOAlterado.getNumLog());
			prepStmt.setString(10, medicoVOAlterado.getComplemento());
			prepStmt.setString(11, medicoVOAlterado.getBairro());
			prepStmt.setString(12, medicoVOAlterado.getCidade());
			prepStmt.setString(13, medicoVOAlterado.getUf());
			prepStmt.setString(14, medicoVOAlterado.getCep());
			prepStmt.setString(15, medicoVOAlterado.getCpf());

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

	public String listarTodos() {

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
				medico.setLogradouro(result.getString(9));
				medico.setNumLog(result.getString(10));
				medico.setComplemento(result.getString(11));
				medico.setBairro(result.getString(12));
				medico.setCidade(result.getString(13));
				medico.setUf(result.getString(14));
				medico.setCep(result.getString(15));

				listamedicos.add(medico);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listamedicos.toString();
	}

}
