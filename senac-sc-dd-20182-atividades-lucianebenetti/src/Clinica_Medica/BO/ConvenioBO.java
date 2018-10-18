package Clinica_Medica.BO;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import Clinica_Medica.DAO.ConvenioDAO;
import Clinica_Medica.VO.ConvenioVO;

public class ConvenioBO {
	ConvenioDAO dao = new ConvenioDAO();

	public boolean inserir(ConvenioVO convenio) {

		if (dao.consultarConvenioPorCnpj(convenio.getConvCnpj()) != null) {
			JOptionPane.showMessageDialog(null, "Convênio já cadastrado! Tente novamente.");
		} else {

			int idGerado = dao.inserirConvenio(convenio);
			return idGerado > 0;
		}
		return false;
	}

	public ConvenioVO buscarConvenioPorCNPJ(String convCnpj) {
		ConvenioVO convenioBuscado = dao.consultarConvenioPorCnpj(convCnpj);
		return convenioBuscado;
	}

	public ArrayList<ConvenioVO> buscarConvenio() {
		ArrayList<ConvenioVO> convenioBuscado = dao.listarTodos();
		return convenioBuscado;
	}
}
