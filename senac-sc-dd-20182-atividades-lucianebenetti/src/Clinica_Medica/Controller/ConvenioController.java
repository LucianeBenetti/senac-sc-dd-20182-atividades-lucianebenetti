package Clinica_Medica.Controller;

import java.util.ArrayList;
import java.util.List;

import Clinica_Medica.BO.ConvenioBO;
import Clinica_Medica.VO.ConvenioVO;

public class ConvenioController {

	ConvenioBO bo = new ConvenioBO();
	public static final String TIPO_RELATORIO_XLS = "xls";
	public static final String TIPO_RELATORIO_PDF = "pdf";

	public String salvar(ConvenioVO convenio) {

		String validacao = validarConvenio(convenio);

		if (validacao == "") {

			if (bo.inserir(convenio)) {
				validacao = "Convênio salvo com sucesso!";
			} else {
				validacao = "Erro ao salvar convenio!";
			}
		}
		return validacao;
	}

	private String validarConvenio(ConvenioVO convenio) {

		String validacao = "";
		if (convenio.getCnpjConvenio() == null) {
			validacao = "CNPJ está nulo!";
		} else {
			if (convenio.getNomeConvenio().trim().equals("") || convenio.getCnpjConvenio().trim().equals("")) {
				validacao += " - Nome e CNPJ são obrigatórios. \n";
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
				validacao = "Convênio salvo com sucesso!";
			} else {
				validacao = "Erro ao salvar convenio!";
			}
		}
		return validacao;

	}

	public void excluirConvenio(ConvenioVO convenio) {

		bo.excluirConvenio(convenio);
	
	}

	public List<ConvenioVO> listarTodosConvenios() {

		return bo.listarTodosConvenios();
	}

	public void gerarRelatorio(List<ConvenioVO> convenios, String caminhoEscolhido,
			String tipoRelatorio) {
		if(tipoRelatorio.equals(TIPO_RELATORIO_XLS)){
			bo.gerarPlanilha(convenios, caminhoEscolhido);
		}else{
			bo.gerarPDF(convenios, caminhoEscolhido);
		}
		
	}

}
