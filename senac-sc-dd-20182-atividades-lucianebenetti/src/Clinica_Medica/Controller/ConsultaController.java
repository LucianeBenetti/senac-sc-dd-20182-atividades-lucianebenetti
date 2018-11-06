package Clinica_Medica.Controller;

import java.util.ArrayList;
import java.util.List;

import Clinica_Medica.BO.ConsultaBO;
import Clinica_Medica.VO.ConsultaVO;

public class ConsultaController {
	
	ConsultaBO bo = new ConsultaBO();

	public String salvar(ConsultaVO consulta) {
		String validacao = validarConsulta(consulta);

		if (validacao == "") {

			if (bo.inserir(consulta)) {
				validacao = "Consulta salva com sucesso!";
			} else {
				validacao = "Erro ao salvar consulta!";
			}
		}
		return validacao;
	}

	private String validarConsulta(ConsultaVO consulta) {

		String validacao = "";
		if (consulta.getDataConsulta() == null) {
			validacao = "Data est� nula!";
		} else {
			if (consulta.getDataConsulta().equals("") || consulta.getHorarioConsulta().equals("")) {
				validacao += " - Data  e Horario s�o obrigat�rios. \n";
			}

		}
		return validacao;
	}

	public List<ConsultaVO> listarTodasConsultas() {

		return bo.listarTodasConsultas();
	}

}
