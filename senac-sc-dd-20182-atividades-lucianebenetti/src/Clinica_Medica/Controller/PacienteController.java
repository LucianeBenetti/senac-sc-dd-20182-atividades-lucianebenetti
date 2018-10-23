package Clinica_Medica.Controller;


import java.util.ArrayList;
import java.util.List;

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
		if(paciente.getNomePaciente() == null) {
			validacao = "Nome est� nulo!";
		}else {	
			if(paciente.getNomePaciente().trim().equals("") || paciente.getCpfPaciente().trim().equals("")) {
				validacao += "- Nome e CPF s�o obrigat�rios. \n";
			}
			
		}
		return validacao;
	}

	public PacienteVO buscarPacientePorCpf(String cpf) {
		
		return bo.buscarPacientePorCpf(cpf);
	}

	public void excluir(PacienteVO paciente) {
		
		bo.excluirPaciente(paciente);
	}

	public String atualizarPaciente(PacienteVO paciente, String cpf) {
		
		String validacao = validarPaciente(paciente);
		
		if(validacao == "") {
				
			if(bo.atualizarPaciente(paciente, cpf)) {
				validacao ="Paciente atualizado com sucesso!";
			}else {
				validacao ="Erro ao atualizar Paciente!";
			}
		}
			return validacao;
	}

	public List<PacienteVO> listarTodosPacientes() {

		return bo.listarTodosPacientes();
	}


}
