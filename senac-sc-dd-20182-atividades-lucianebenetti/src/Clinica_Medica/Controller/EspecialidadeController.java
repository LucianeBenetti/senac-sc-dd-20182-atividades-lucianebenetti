package Clinica_Medica.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import Clinica_Medica.BO.EspecialidadeBO;
import Clinica_Medica.VO.EspecialidadeVO;
import Clinica_Medica.VO.EspecializacaoVO;

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
			} else {
				if (bo.consultarEspecialidadeVONome(especialidade.getNomeEspecialidade(),
						especialidade.getInstituicao()) != null) {
					validacao = "Especialidade já cadastrada! Tente novamente.";
				}
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

	public List<EspecialidadeVO> listarTodasEspecialidades() {

		return bo.listarTodasEspecialidades();
	}

	public ArrayList<EspecialidadeVO> consultarEspecialidade() {

		return bo.buscarEspecilidades();
	}

	public List<EspecialidadeVO> exibirEspecialidadePorNome(EspecialidadeVO especialidade) {
		// TODO Auto-generated method stub
		return bo.exibirEspecialidadePorNome(especialidade);
	}

	public EspecialidadeVO consultarEspecialidadeVONome(String nomeEspecialidade, String instituicao) {
		// TODO Auto-generated method stub
		return bo.consultarEspecialidadeVONome(nomeEspecialidade, instituicao);

	}

}
