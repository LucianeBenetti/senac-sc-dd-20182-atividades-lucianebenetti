package Clinica_Medica.Controller;

import java.util.ArrayList;
import java.util.List;

import Clinica_Medica.BO.EspecializacaoBO;
import Clinica_Medica.VO.EspecialidadeVO;
import Clinica_Medica.VO.EspecializacaoVO;
import Clinica_Medica.VO.MedicoVO;

public class EspecializacaoController {

	EspecializacaoBO bo = new EspecializacaoBO();

	public String salvar(EspecializacaoVO especializacao) {

		String validacao = validarEspecializacao(especializacao);

		if (validacao == "") {

			if (bo.inserir(especializacao)) {
				validacao = "Especialização salva com sucesso!";
			} else {
				validacao = "Erro ao salvar especialização!";
			}
		}
		return validacao;
	}

	private String validarEspecializacao(EspecializacaoVO especializacao) {

		EspecialidadeVO especialidade = new EspecialidadeVO();
		MedicoVO medico = new MedicoVO();

		String validacao = "";
		if (especializacao.getAnoEspecializacao() == null) {
			validacao = "O ano está nulo!";
		} else {
			if (especializacao.getAnoEspecializacao().trim().equals("")) {
				validacao += "- O preenchimento de todos os campos é obrigatório. Por gentileza, informar os dados corretos! \n";
			}

		}
		return validacao;
	}

	public ArrayList<EspecialidadeVO> consultarEspecialidade(String nomeEspecializacao, String nomeMedico) {

		return null;
	}

	public void excluirEspecializacao(EspecializacaoVO especializacaoExcluida) {
	
		bo.excluirEspecializacao(especializacaoExcluida);

	}

	public EspecializacaoVO atualizar(EspecializacaoVO especializacao, int codigoEspecializacao) {
		EspecializacaoVO especializacaoBuscada = bo.atualizar(especializacao, codigoEspecializacao);

		return especializacaoBuscada;

	}

	public ArrayList<EspecializacaoVO> listarEspecializacoesPorMedicoEspecialidade(EspecialidadeVO especialidade,
			MedicoVO medico) {
		return bo.listarTodasEspecializacoesPorMedicoEspecialidade(especialidade, medico);
	}

	
	public ArrayList<EspecializacaoVO> listarTodasEspecializacoes() {

		return bo.listarTodasEspecializacoes();
	}

	public List<EspecializacaoVO> existeCadastro(String nomeMedico, String nomeEspecialidade) {
		 return bo.existeEspecializacaoPorNome(nomeMedico, nomeEspecialidade);
		
	}

	

}
