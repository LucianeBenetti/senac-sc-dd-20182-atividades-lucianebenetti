package Clinica_Medica.BO;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import Clinica_Medica.DAO.EspecialidadeDAO;
import Clinica_Medica.VO.EspecialidadeVO;
import Clinica_Medica.VO.EspecializacaoVO;

public class EspecialidadeBO {

	EspecialidadeDAO dao = new EspecialidadeDAO();

	public boolean inserir(EspecialidadeVO especialidade) {

			int idGerado = dao.inserirEspecialidadeVO(especialidade);
			return idGerado > 0;
		
	}

	public List<EspecialidadeVO> exibirEspecialidadePorNome(String espNome) {
		ArrayList<EspecialidadeVO> especialidades = dao.consultarEspecialidadeNome(espNome);
		return especialidades;
	}

	public EspecialidadeVO atualizar(EspecialidadeVO especialidade, int codigo) {
		EspecialidadeVO especialidadeBuscada = dao.atualizarEspecialidade(especialidade, codigo);

		return especialidadeBuscada;
	}

	public boolean excluirEspecialidade(EspecialidadeVO especialidadeExcluida) {

		boolean sucesso = dao.deleteEspecialidadeVO(especialidadeExcluida.getCodigoEspecialidade());
		return sucesso;
	}

	public List<EspecialidadeVO> listarTodasEspecialidades() {

		ArrayList<EspecialidadeVO> especialidades = dao.listarTodasEspecialidades();
		return especialidades;
	}

	public ArrayList<EspecialidadeVO> buscarEspecilidades() {
		ArrayList<EspecialidadeVO> especialidadeBuscada = dao.listarTodasEspecialidades();
		return especialidadeBuscada;
	}

	public List<EspecialidadeVO> exibirEspecialidadePorNome(EspecialidadeVO especialidade) {
		ArrayList<EspecialidadeVO> especialidades = dao.consultarEspecialidadeNome(especialidade.getNomeEspecialidade());
		
		return especialidades;
	}

	public EspecialidadeVO consultarEspecialidadeVONome(String nomeEspecialidade, String instituicao) {
		
		return dao.consultarEspecialidadeVONome(nomeEspecialidade, instituicao);
	}

	
}
