package Clinica_Medica.BO;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import Clinica_Medica.DAO.MedicoDAO;
import Clinica_Medica.VO.MedicoVO;


public class MedicoBO {
	
	MedicoDAO dao = new MedicoDAO();

	public boolean inserir(MedicoVO medico) {


			int idGerado = dao.inserir(medico);
			return idGerado > 0;
		
	}

	public MedicoVO buscarMedicoPorCPF(String cpf) {
		
		MedicoVO medicoBuscado = dao.consultarMedicoVOPorCpf(cpf);
		return medicoBuscado;
	}

	public ArrayList<MedicoVO> buscarMedico() {
		ArrayList<MedicoVO> medicoBuscado = dao.listarTodos();
		return medicoBuscado;
	}

	public boolean atualizarMedico(MedicoVO medico, String cpf) {
		
		return dao.atualizar(medico, cpf);
	}

	public boolean excluirMedico(MedicoVO medicoExcluido) {
		boolean sucesso = dao.delete(medicoExcluido.getCpfMedico());
		return sucesso;
	}

	public List<MedicoVO> listarTodosMedicos() {
		ArrayList<MedicoVO> medicos = dao.listarTodos();
		return medicos;
	}

	public List<MedicoVO> exibirMedicoPorNome(MedicoVO medico) {
		
		ArrayList<MedicoVO> medicos = dao.exibirMedicoPorNome(medico.getNomeMedico());
		return medicos;
	}

	public MedicoVO consultarMedicoVOPorCpf(String cpfMedico) {
		
		return dao.consultarMedicoVOPorCpf(cpfMedico);
	}

}
