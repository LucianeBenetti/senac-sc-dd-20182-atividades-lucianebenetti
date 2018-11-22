package Clinica_Medica.Controller;

import java.util.ArrayList;
import java.util.List;

import Clinica_Medica.BO.ProntuarioBO;
import Clinica_Medica.VO.ConsultaVO;
import Clinica_Medica.VO.ConvenioVO;
import Clinica_Medica.VO.ProntuarioVO;

public class ProntuarioController {
	
	ProntuarioBO bo = new ProntuarioBO();

	public List<ProntuarioVO> listarTodosProntuarios() {
		
		return bo.listarProntuarios();
	}

	public String salvar(ProntuarioVO prontuario) {
		
		String validacao = validarProntuario(prontuario);

		if (validacao == "") {

			if (bo.inserir(prontuario)) {
				validacao = "Prontuario salvo com sucesso!";
			} else {
				validacao = "Erro ao salvar prontuario!";
			}
		}
		return validacao;
	}

	private String validarProntuario(ProntuarioVO prontuario) {

		String validacao = "";
		if (prontuario.getMedicamento()== null) {
			validacao = "A área de medicamentos está nula!";
		} else {
			if (prontuario.getMedicamento().trim().equals("") || prontuario.getRegistro().trim().equals("")) {
				validacao += " - Medicamentos e Registro são obrigatórios. \n";
			}

		}
		return validacao;
	}

	public void excluirProntuario(ProntuarioVO prontuarioExcluido) {
		bo.excluirProntuario(prontuarioExcluido);
		
	}

	public String atualizarProntuario(ProntuarioVO prontuario, int codigoProntuario) {

		String validacao = validarProntuario(prontuario);
		if (validacao == "") {

			if (bo.atualizar(prontuario, codigoProntuario)) {
				validacao = "Prontuario alterado com sucesso!";
			} else {
				validacao = "Erro ao alterar prontuario!";
			}
		}
		return validacao;

	}

	public List<ProntuarioVO> listarProntuariosDoPaciente(ConsultaVO consultaSelecionada) {
		
		List<ProntuarioVO> prontuarios = new ArrayList<>();
		if(consultaSelecionada != null && consultaSelecionada.getPacienteVO() != null) {
			prontuarios = bo.listarProntuariosDoPaciente(consultaSelecionada.getPacienteVO().getCodigoPaciente());
		}
		
		return prontuarios;
	}

}
