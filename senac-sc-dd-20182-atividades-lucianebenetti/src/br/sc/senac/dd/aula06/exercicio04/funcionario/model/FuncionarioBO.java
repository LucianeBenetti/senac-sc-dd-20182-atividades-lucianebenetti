package br.sc.senac.dd.aula06.exercicio04.funcionario.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;


public class FuncionarioBO {
	
FuncionarioDAO dao = new FuncionarioDAO();
	
	public boolean inserir(FuncionarioVO funcionario) {
		
		FuncionarioDAO dao = new FuncionarioDAO();
		if (dao.consultarPorCpf(funcionario.getCpf()) != null){
			JOptionPane.showMessageDialog(null, "Funcionario já cadastrado! Tente novamente.");
		}else {
		
		int idGerado = dao.inserirFuncionario(funcionario);
		return idGerado >0;
		}
		return false;
	}
	
	
	public boolean atualizar(FuncionarioVO funcionario, String cpf) {
		boolean sucesso = dao.atualizar(funcionario, cpf);
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


	public List<FuncionarioVO> listarFuncionarios() {
		ArrayList<FuncionarioVO> funcionarios = dao.listarTodos();
		return funcionarios;
	}


	public List<FuncionarioVO> exibirFuncionarioPorCPF(String cpf) {
		ArrayList<FuncionarioVO> funcionarios = dao.exibirPorCpf(cpf);
		return funcionarios;
	}

	
}
