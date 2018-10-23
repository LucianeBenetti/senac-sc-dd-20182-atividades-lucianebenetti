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
		
		if (dao.consultarEspecialidadeVONome(especialidade.getNomeEspecialidade(), especialidade.getInstituicao() ) != null) {
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


	public boolean atualizarEspecialidade(EspecialidadeVO especialidade, int espCod) {
		
		return dao.atualizarEspecialidadeVO(especialidade, especialidade.getCodigoEspecialidade());
	}


	
}
