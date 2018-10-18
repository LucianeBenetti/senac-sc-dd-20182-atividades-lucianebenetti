package Clinica_Medica.Controller;

import java.util.ArrayList;
import java.util.List;

import Clinica_Medica.BO.EspecialidadeBO;
import Clinica_Medica.VO.EspecialidadeVO;


public class EspecialidadeController {
	
	EspecialidadeBO bo = new EspecialidadeBO();

	public String salvar(EspecialidadeVO especialidade) {

		String validacao = validarEspecialidade(especialidade);
		
		if(validacao == "") {
				
			if(bo.inserir(especialidade)) {
				validacao ="Especialidade salva com sucesso!";
			}else {
				validacao ="Erro ao salvar especialidade!";
			}
		}
			return validacao;
	}

	private String validarEspecialidade(EspecialidadeVO especialidade) {
				
		String validacao = "";
		if(especialidade.getEspNome() == null) {
			validacao = "Nome está nulo!";
		}else {	
			if(especialidade.getEspNome().trim().equals("") || especialidade.getEspInstituicao().trim().equals("") ) {
				validacao += "- Nome e Instituição são obrigatórios. \n";
			}
			
		}
		return validacao;
	}

	
	public List<EspecialidadeVO> exibirEspecialidadePorNome(String nome) {
		
		return bo.exibirEspecialidadePorNome(nome);
	}

	public ArrayList<EspecialidadeVO> ConsultarEspecialidade(String espNome, int espeCod, String medNome) {
		
		return bo.consultarEspecialidade(espNome, espeCod, medNome);
	}

}
