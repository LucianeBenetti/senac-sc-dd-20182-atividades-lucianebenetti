package Clinica_Medica.Controller;

import java.util.ArrayList;

import Clinica_Medica.BO.ConvenioBO;
import Clinica_Medica.VO.ConvenioVO;


public class ConvenioController {
	
	ConvenioBO bo = new ConvenioBO();

	public String salvar(ConvenioVO convenio) {
		
		String validacao = validarConvenio(convenio);
		
		if(validacao == "") {
				
			if(bo.inserir(convenio)) {
				validacao ="Convênio salvo com sucesso!";
			}else {
				validacao ="Erro ao salvar convenio!";
			}
		}
			return validacao;
	}

	private String validarConvenio(ConvenioVO convenio) {
				
		String validacao = "";
		if(convenio.getConvCnpj() == null) {
			validacao = "CNPJ está nulo!";
		}else {	
			if(convenio.getConvNome().trim().equals("") || convenio.getConvCnpj().trim().equals("") ) {
				validacao += " - Nome e CNPJ são obrigatórios. \n";
			}
			
		}
		return validacao;
	}

	public ArrayList<ConvenioVO> ConsultarConvenio() {
		return bo.buscarConvenio();
	}

	
}
