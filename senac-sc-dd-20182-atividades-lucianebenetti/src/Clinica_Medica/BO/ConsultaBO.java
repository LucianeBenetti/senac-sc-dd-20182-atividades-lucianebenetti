package Clinica_Medica.BO;

import java.util.ArrayList;
import java.util.List;

import Clinica_Medica.DAO.ConsultaDAO;
import Clinica_Medica.VO.ConsultaVO;


public class ConsultaBO {
	
	ConsultaDAO dao = new ConsultaDAO();

	public boolean inserir(ConsultaVO consulta) {
		
		int idGerado = dao.inserirConsulta(consulta);
		
		return idGerado > 0;
	}

	public List<ConsultaVO> listarTodasConsultas() {
		ArrayList<ConsultaVO> consultas = dao.listarTodos();
		return consultas;
	}

	public boolean excluirConsulta(ConsultaVO consultaExcluida) {
		boolean sucesso = dao.delete(consultaExcluida.getCodigoConsulta());
		return sucesso;
		
	}

	public boolean atualizarConsulta(ConsultaVO consulta, int codigoConsulta) {
		
		return dao.atualizar(consulta, codigoConsulta);
	}

}
