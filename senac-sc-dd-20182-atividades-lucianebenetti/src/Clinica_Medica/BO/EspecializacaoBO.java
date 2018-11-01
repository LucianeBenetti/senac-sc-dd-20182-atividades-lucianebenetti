package Clinica_Medica.BO;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import Clinica_Medica.DAO.EspecializacaoDAO;
import Clinica_Medica.VO.EspecialidadeVO;
import Clinica_Medica.VO.EspecializacaoVO;
import Clinica_Medica.VO.MedicoVO;

public class EspecializacaoBO {
	
	EspecializacaoDAO dao = new EspecializacaoDAO();
	
	public boolean inserir(EspecializacaoVO especializacao) {
			
			if (dao.existeEspecializacao(especializacao)) {
				JOptionPane.showMessageDialog(null, "Especialização já cadastrada! Tente novamente.");
			} else {

				int idGerado = dao.inserirEspecializacao(especializacao);
				return idGerado > 0;
			}
			return false;
		}
	

	public boolean excluirEspecializacao(EspecializacaoVO especializacao) {
		boolean sucesso = dao.delete(especializacao.getCodigoEspecializacao());
		return sucesso;
	}

		
	public EspecializacaoVO atualizar(EspecializacaoVO especializacao, int codigoEspecializacao) {
		EspecializacaoVO especializacaoBuscada = dao.atualizarEspecializacao(especializacao, especializacao.getCodigoEspecializacao());

		return especializacaoBuscada;

	}

	public ArrayList<EspecializacaoVO> listarTodasEspecializacoes() {
		
		ArrayList<EspecializacaoVO> especialiacoes = dao.listarTodasEspecializacoes();
		return especialiacoes;
	}

	public ArrayList<EspecializacaoVO> listarTodasEspecializacoesPorMedicoEspecialidade(EspecialidadeVO especialidade, MedicoVO medico) {
		return dao.listarEspecializacoesDoMedicoPorEspecialidade(especialidade.getCodigoEspecialidade(), medico.getCodigoMedico());
	}

	public List<EspecializacaoVO> existeEspecializacaoPorNome(String nomeMedico, String nomeEspecialidade) {
		ArrayList<EspecializacaoVO> especializacoes = dao.existeEspecializacaoPorNome(nomeMedico, nomeEspecialidade);
		return especializacoes;
	}

}
