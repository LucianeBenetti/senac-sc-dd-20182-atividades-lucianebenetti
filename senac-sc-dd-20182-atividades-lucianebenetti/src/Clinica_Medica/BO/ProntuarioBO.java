package Clinica_Medica.BO;

import java.io.DataOutput;
import java.util.ArrayList;
import java.util.List;

import Clinica_Medica.DAO.ProntuarioDAO;
import Clinica_Medica.VO.ProntuarioVO;


public class ProntuarioBO {
	
	ProntuarioDAO dao = new ProntuarioDAO();
	
	public List<ProntuarioVO> listarProntuarios() {

          ArrayList<ProntuarioVO> prontuarios = dao.listarTodos(); 
		 return prontuarios;
	}

}

