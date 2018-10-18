package Clinica_Medica.Controller;


import Clinica_Medica.BO.PacienteBO;
import Clinica_Medica.VO.PacienteVO;

public class PacienteController {
	
	PacienteBO bo = new PacienteBO();

	public String salvar(PacienteVO paciente) {
		
		String validacao = validarPaciente(paciente);
		
		if(validacao == "") {
				
			if(bo.inserir(paciente)) {
				validacao ="Paciente salvo com sucesso!";
			}else {
				validacao ="Erro ao salvar Paciente!";
			}
		}
			return validacao;
	}

	private String validarPaciente(PacienteVO paciente) {
				
		String validacao = "";
		if(paciente.getPacNome() == null) {
			validacao = "Nome está nulo!";
		}else {	
			if(paciente.getPacNome().trim().equals("") || paciente.getCpf().trim().equals("")) {
				validacao += "- Nome e CPF são obrigatórios. \n";
			}
			
		}
		return validacao;
	}


}
