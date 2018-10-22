package Clinica_Medica.BO;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.mysql.fabric.xmlrpc.base.Data;

import Clinica_Medica.DAO.PacienteDAO;
import Clinica_Medica.VO.MedicoVO;
import Clinica_Medica.VO.PacienteVO;

public class PacienteBO {
	
	PacienteDAO dao = new PacienteDAO();
	

	public boolean inserir(PacienteVO paciente) {
		if (dao.consultarPacientePorCpf(paciente.getCpf()) != null) {
			JOptionPane.showMessageDialog(null, "Paciente já cadastrado! Tente novamente.");
			
		} else {

			int idGerado = dao.inserirPaciente(paciente);
			return idGerado > 0;
		}
		return false;
	}

	public PacienteVO buscarPacientePorCpf(String cpf) {
		PacienteVO pacienteBuscado = dao.consultarPacientePorCpf(cpf);
		return pacienteBuscado;
	}

	public boolean atualizarPaciente(PacienteVO paciente, String cpf) {
		
		return dao.atualizar(paciente, cpf);
	}

	public boolean excluirPaciente(PacienteVO paciente) {
		boolean sucesso = dao.delete(paciente.getCpf());
		return sucesso;
		
	}

	public List<PacienteVO> listarTodosPacientes() {

		ArrayList<PacienteVO> pacientes = dao.listarTodos();
		return pacientes;
	}
}
