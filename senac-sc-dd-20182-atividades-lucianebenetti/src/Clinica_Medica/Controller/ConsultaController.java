package Clinica_Medica.Controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.JOptionPane;

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
			validacao = "Data está nula!";
		} else {
			if (consulta.getDataConsulta().equals("") || consulta.getHorarioConsulta().equals("")) {
				validacao += " - Data  e Horario são obrigatórios. \n";
			} else {
				// java.sql.Date
				Calendar c = Calendar.getInstance();
				c.setTime(consulta.getDataConsulta());
				Date dataSQL = new Date(c.getTimeInMillis());
				java.util.Date hoje = Calendar.getInstance().getTime();
				if (dataSQL.before(hoje)) {
					validacao = "Data não pode ser inferior ou igual a data atual.";
				}
			}
		}
		return validacao;
	}

	public List<ConsultaVO> listarTodasConsultas() {

		return bo.listarTodasConsultas();
	}

	public void excluirConsulta(ConsultaVO consultaExcluida) {
		bo.excluirConsulta(consultaExcluida);

	}

	public String atualizarConsulta(ConsultaVO consulta, int codigoConsulta) {
		String validacao = validarConsulta(consulta);
		if (validacao == "") {

			if (bo.atualizarConsulta(consulta, codigoConsulta)) {
				validacao = "Consulta salvo com sucesso!";
			} else {
				validacao = "Erro ao salvar consulta!";
			}
		}
		return validacao;
	}

}
