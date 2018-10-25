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
				
			if (dao.listarEspecializacoes(especializacao.getMedicoVO().getCodigoMedico(), especializacao.getEspecialidadeVO().getCodigoEspecialidade()) != null) {
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

	

	
}
