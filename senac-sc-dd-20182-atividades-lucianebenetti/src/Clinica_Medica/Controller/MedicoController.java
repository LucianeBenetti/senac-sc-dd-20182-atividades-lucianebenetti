package Clinica_Medica.Controller;

import java.util.ArrayList;
import java.util.List;

import Clinica_Medica.BO.MedicoBO;
import Clinica_Medica.VO.MedicoVO;

public class MedicoController {
	
	MedicoBO bo = new MedicoBO();

	public String salvar(MedicoVO medico) {
		
		String validacao = validarMedico(medico);
		
		if(validacao == "") {
				
			if(bo.inserir(medico)) {
				validacao ="Medico salvo com sucesso!";
			}else {
				validacao ="Erro ao salvar médico!";
			}
		}
			return validacao;
	}

	private String validarMedico(MedicoVO medico) {
				
		String validacao = "";
		if(medico.getCpf() == null) {
			validacao = "CPF está nulo!";
		}else {	
			if(medico.getMedNome().trim().equals("") || medico.getCrm().trim().equals("") ) {
				validacao += "- Nome e CRM são obrigatórios. \n";
			}
			
		}
		return validacao;
	}

	public ArrayList<MedicoVO> ConsultarMedico() {
		
		return bo.buscarMedico();
	}

	public MedicoVO buscarMedicoPorCPF(String cpf) {

		return bo.buscarMedicoPorCPF(cpf);
	}

	public String atualizarMedico(MedicoVO medico, String cpf) {
		
		String validacao = validarMedico(medico);
		
		if(validacao == "") {
				
			if(bo.atualizarMedico(medico, cpf)) {
				validacao ="Medico alterado com sucesso!";
			}else {
				validacao ="Erro ao alterar médico!";
			}
		}
			return validacao;
	}

	public void excluirMedico(MedicoVO medicoExcluido) {
		
		bo.excluirMedico(medicoExcluido);
		
	}

	public List<MedicoVO> listarTodosMedicos() {
		// TODO Auto-generated method stub
		return bo.listarTodosMedicos();
	}

}
