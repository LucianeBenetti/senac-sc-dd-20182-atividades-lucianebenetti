package Clinica_Medica.BO;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import Clinica_Medica.DAO.EspecialidadeDAO;
import Clinica_Medica.VO.EspecialidadeVO;
import Clinica_Medica.VO.MedicoVO;


public class EspecialidadeBO {
	
	EspecialidadeDAO dao = new EspecialidadeDAO();

	public boolean inserir(EspecialidadeVO especialidade) {
		
		if (dao.consultarEspecialidadeVONome(especialidade.getEspNome(), especialidade.getEspInstituicao() ) != null) {
			JOptionPane.showMessageDialog(null, "Especialidade já cadastrada! Tente novamente.");
			
		} else {

			int idGerado = dao.inserirEspecialidadeVO(especialidade);
			return idGerado > 0;
		}
		return false;
	}

	
	public List<EspecialidadeVO> exibirEspecialidadePorNome(String espNome) {
		ArrayList<EspecialidadeVO> especialidades = dao.consultarEspecialidadeNome(espNome);
		return especialidades;
	}


	public ArrayList<EspecialidadeVO> consultarEspecialidade(String espNome, int espeCod, String medNome) {
		ArrayList<EspecialidadeVO> especialidadeBuscada = dao.listarEspecialidades(espNome, espeCod, medNome);
		return especialidadeBuscada;
	}

}
