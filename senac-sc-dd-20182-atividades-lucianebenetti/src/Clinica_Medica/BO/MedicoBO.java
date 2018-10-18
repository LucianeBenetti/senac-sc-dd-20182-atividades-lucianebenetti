package Clinica_Medica.BO;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import Clinica_Medica.DAO.MedicoDAO;
import Clinica_Medica.VO.MedicoVO;


public class MedicoBO {
	
	MedicoDAO dao = new MedicoDAO();

	public boolean inserir(MedicoVO medico) {

		if (dao.consultarMedicoVOPorCpf(medico.getCpf()) != null) {
			JOptionPane.showMessageDialog(null, "Médico já cadastrado! Tente novamente.");
		} else {

			int idGerado = dao.inserir(medico);
			return idGerado > 0;
		}
		return false;
	}

	public MedicoVO buscarMedicoPorCPF(String cpf) {
		
		MedicoVO medicoBuscado = dao.consultarMedicoVOPorCpf(cpf);
		return medicoBuscado;
	}

	public ArrayList<MedicoVO> buscarMedico() {
		ArrayList<MedicoVO> medicoBuscado = dao.listarTodos();
		return medicoBuscado;
	}

	

}
