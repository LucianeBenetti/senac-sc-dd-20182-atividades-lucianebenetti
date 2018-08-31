package br.sc.senac.dd.aula06.exercicio04.Controller;

import javax.swing.JOptionPane;

import br.sc.senac.dd.aula06.exercicio04.Model.FuncionarioBO;
import br.sc.senac.dd.aula06.exercicio04.Model.FuncionarioVO;

public class FuncionarioController {
	
	private FuncionarioBO bo = new FuncionarioBO();

	public String salvar(FuncionarioVO funcionario) {
		String validacao = validarFuncionario(funcionario);
		
		if(validacao == "") {
				
			//inserir
			if(bo.inserir(funcionario)) {
				validacao ="Funcionario salvo com sucesso!";
			}else {
				validacao ="Erro ao salvar funcionario!";
			}
		}
			return validacao;
	}

	private String validarFuncionario(FuncionarioVO funcionario) {
				
		String validacao = "";
		if(funcionario.getCpf() == null) {
			validacao = "Funcionario está nulo!";
		}else {	
			if(funcionario.getNome().trim().equals("") || funcionario.getCpf().trim().equals("") ) {
				validacao += "- Nome e CPF são obriatórios. \n";
			}
			
		}
		return validacao;
	}
	
	public String atualizar(FuncionarioVO funcionario) {
					
			bo.atualizar(funcionario);
			JOptionPane.showMessageDialog(null,"Funcionario atualizado com sucesso!");
			
		return null;
	}

	public String deletar(FuncionarioVO funcionarioVO) {
		
		bo.excluir(funcionarioVO);
		JOptionPane.showMessageDialog(null,  "Funcionario excluido com sucesso!");
		
		return null;
	}
	

}
