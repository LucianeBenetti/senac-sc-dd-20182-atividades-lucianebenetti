package Clinica_Medica.Controller;

import java.util.ArrayList;
import java.util.List;

import Clinica_Medica.BO.ProntuarioBO;
import Clinica_Medica.VO.ProntuarioVO;

public class ProntuarioController {
	
	ProntuarioBO bo = new ProntuarioBO();

	public List<ProntuarioVO> listarTodosProntuarios() {
		
		return bo.listarProntuarios();
	}

}
