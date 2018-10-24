package Clinica_Medica.Controller;

import java.util.ArrayList;
import java.util.List;

import Clinica_Medica.BO.EspecialidadeBO;
import Clinica_Medica.VO.EspecialidadeVO;

public class EspecialidadeController {

	EspecialidadeBO bo = new EspecialidadeBO();

	public String salvar(EspecialidadeVO especialidade) {

		String validacao = validarEspecialidade(especialidade);

		if (validacao == "") {

			if (bo.inserir(especialidade)) {
				validacao = "Especialidade salva com sucesso!";
			} else {
				validacao = "Erro ao salvar especialidade!";
			}
		}
		return validacao;
	}

	private String validarEspecialidade(EspecialidadeVO especialidade) {

		String validacao = "";
		if (especialidade.getNomeEspecialidade() == null) {
			validacao = "Nome está nulo!";
		} else {
			if (especialidade.getNomeEspecialidade().trim().equals("")
					|| especialidade.getInstituicao().trim().equals("")) {
				validacao += "- Nome e Instituição são obrigatórios. \n";
			}

		}
		return validacao;
	}

	public List<EspecialidadeVO> exibirEspecialidadePorNome(String nome) {

		return bo.exibirEspecialidadePorNome(nome);
	}

	public EspecialidadeVO atualizar(EspecialidadeVO especialidade, int codigo) {

		EspecialidadeVO especialidadeBuscada = bo.atualizar(especialidade, codigo);

		return especialidadeBuscada;

	}

	public void excluirEspecialidadeVO(EspecialidadeVO especialidadeExcluida) {

		bo.excluirEspecialidade(especialidadeExcluida);

	}

	public List<EspecialidadeVO> listarTodosConvenios() {

		return bo.listarTodasEspecialidades();
	}

}
