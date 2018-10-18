package Clinica_Medica.Controller;

import java.util.ArrayList;

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
				validacao ="Erro ao salvar m�dico!";
			}
		}
			return validacao;
	}

	private String validarMedico(MedicoVO medico) {
				
		String validacao = "";
		if(medico.getCpf() == null) {
			validacao = "CPF est� nulo!";
		}else {	
			if(medico.getMedNome().trim().equals("") || medico.getCrm().trim().equals("") ) {
				validacao += "- Nome e CRM s�o obrigat�rios. \n";
			}
			
		}
		return validacao;
	}

	public ArrayList<MedicoVO> ConsultarMedico() {
		
		return bo.buscarMedico();
	}

}
