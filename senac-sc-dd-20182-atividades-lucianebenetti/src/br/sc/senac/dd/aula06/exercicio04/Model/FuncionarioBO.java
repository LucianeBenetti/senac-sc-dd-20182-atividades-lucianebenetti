package br.sc.senac.dd.aula06.exercicio04.Model;

public class FuncionarioBO {
	
FuncionarioDAO dao = new FuncionarioDAO();
	
	public boolean inserir(FuncionarioVO funcionarioVO) {
		int idGerado = dao.inserirFuncionario(funcionarioVO);
		return idGerado >0;
	}

	public boolean atualizar(FuncionarioVO funcionarioVO) {
		boolean sucesso = dao.atualizar(funcionarioVO);
		return sucesso;
	}
	
	public FuncionarioVO buscarFuncionarioPorCPF(String cpf) {
	FuncionarioVO funcionarioBuscado = dao.consultarPorCpf(cpf);
	return funcionarioBuscado;
	}

	public boolean excluir(FuncionarioVO funcionarioVO) {
		boolean sucesso = dao.delete(funcionarioVO.getCpf());
		return sucesso;
	}

}
