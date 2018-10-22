package Clinica_Medica.Controller;

import java.util.ArrayList;

import Clinica_Medica.BO.ConvenioBO;
import Clinica_Medica.VO.ConvenioVO;

public class ConvenioController {

	ConvenioBO bo = new ConvenioBO();

	public String salvar(ConvenioVO convenio) {

		String validacao = validarConvenio(convenio);

		if (validacao == "") {

			if (bo.inserir(convenio)) {
				validacao = "Conv�nio salvo com sucesso!";
			} else {
				validacao = "Erro ao salvar convenio!";
			}
		}
		return validacao;
	}

	private String validarConvenio(ConvenioVO convenio) {

		String validacao = "";
		if (convenio.getConvCnpj() == null) {
			validacao = "CNPJ est� nulo!";
		} else {
			if (convenio.getConvNome().trim().equals("") || convenio.getConvCnpj().trim().equals("")) {
				validacao += " - Nome e CNPJ s�o obrigat�rios. \n";
			}

		}
		return validacao;
	}

	public ArrayList<ConvenioVO> ConsultarConvenio() {
		return bo.buscarConvenio();
	}

	public ConvenioVO buscarConvenioPorCNPJ(String convCnpj) {

		return bo.buscarConvenioPorCNPJ(convCnpj);
	}

	public String atualizarConvenio(ConvenioVO convenio, String conCnpj) {

		String validacao = validarConvenio(convenio);
		if (validacao == "") {

			if (bo.atualizarConvenio(convenio, conCnpj)) {
				validacao = "Conv�nio salvo com sucesso!";
			} else {
				validacao = "Erro ao salvar convenio!";
			}
		}
		return validacao;

	}

	public void excluirConvenio(ConvenioVO convenio) {

		bo.excluirConvenio(convenio);
	
	}

}
