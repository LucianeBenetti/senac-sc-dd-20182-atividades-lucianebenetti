package Clinica_Medica.BO;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import Clinica_Medica.DAO.ConvenioDAO;
import Clinica_Medica.VO.ConvenioVO;

public class ConvenioBO {
	ConvenioDAO dao = new ConvenioDAO();

	public boolean inserir(ConvenioVO convenio) {

			int idGerado = dao.inserirConvenio(convenio);
			return idGerado > 0;

	}

	public ConvenioVO buscarConvenioPorCNPJ(String convCnpj) {
		ConvenioVO convenioBuscado = dao.consultarConvenioPorCnpj(convCnpj);
		return convenioBuscado;
	}

	public ArrayList<ConvenioVO> buscarConvenio() {
		ArrayList<ConvenioVO> convenioBuscado = dao.listarTodos();
		return convenioBuscado;
	}

	public boolean atualizarConvenio(ConvenioVO convenio, String conCnpj) {
		return dao.atualizar(convenio, conCnpj);
		
	}

	public boolean excluirConvenio(ConvenioVO convenio) {
		boolean sucesso = dao.delete(convenio.getCnpjConvenio());
		return sucesso;
	}

	public List<ConvenioVO> listarTodosConvenios() {
		ArrayList<ConvenioVO> convenios = dao.listarTodos();
		return convenios;
	}

	public void gerarPlanilha(List<ConvenioVO> convenios, String caminhoEscolhido) {
		GeradorPlanilha gerador = new GeradorPlanilha();
		gerador.gerarPlanilhaConvenios(convenios, caminhoEscolhido);
		
	}

}
