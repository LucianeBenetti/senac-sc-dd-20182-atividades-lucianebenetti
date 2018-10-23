package Clinica_Medica.BO;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import Clinica_Medica.DAO.EspecializacaoDAO;
import Clinica_Medica.VO.EspecialidadeVO;
import Clinica_Medica.VO.EspecializacaoVO;

public class EspecializacaoBO {
	
	EspecializacaoDAO dao = new EspecializacaoDAO();
	
	public boolean inserir(EspecializacaoVO especializacao) {
				
			if (dao.consultaPorID(especializacao.getCodigoEspecializacao()) != null) {
				JOptionPane.showMessageDialog(null, "Especialização já cadastrada! Tente novamente.");
				
			} else {

				int idGerado = dao.inserirEspecializacao(especializacao);
				return idGerado > 0;
			}
			return false;
		}

	
}
