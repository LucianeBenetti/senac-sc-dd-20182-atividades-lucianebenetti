package Clinica_Medica.Controller;

import java.util.ArrayList;

import Clinica_Medica.BO.EspecializacaoBO;
import Clinica_Medica.VO.EspecialidadeVO;
import Clinica_Medica.VO.EspecializacaoVO;

public class EspecializacaoController {
	
	EspecializacaoBO bo = new EspecializacaoBO();

	public String salvar(EspecializacaoVO especializacao) {

		String validacao = validarEspecializacao(especializacao);
		
		if(validacao == "") {
				
			if(bo.inserir(especializacao)) {
				validacao ="Especialização salva com sucesso!";
			}else {
				validacao ="Erro ao salvar especialização!";
			}
		}
			return validacao;
	}

	private String validarEspecializacao(EspecializacaoVO especializacao) {
				
		String validacao = "";
		if(especializacao.getAnoEspecializacao() == null) {
			validacao = "O ano está nulo!";
					
		}
		return validacao;
	}

	public ArrayList<EspecialidadeVO> ConsultarEspecialidade(String nomeEspecializacao, int codigoEspecializacao,
			String nomeMedico) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
