package br.sc.senac.dd.aula05.exercicio2;

import javax.swing.JOptionPane;

public class MenuFuncionario{
	
	FuncionarioVO funcionarioVO = new FuncionarioVO();

	public void apresentaMenuFuncionario() {
	
		int opcao = -1;
		
		while (opcao !=5) {
			try {
				opcao = Integer.parseInt(JOptionPane.showInputDialog(criarMenuFuncionario()));
			}catch(NumberFormatException ex){
				JOptionPane.showMessageDialog(null, "O número digitado deve ser um inteiro entre 1 e 5;");
			}
			switch(opcao) {
			case 1:{
				this.cadastrarFuncionario();
				break;
			}
			case 2:{
				this.excluirFuncionario();
				break;
			}
			case 3:{
				this.atualizarFuncionario();
				break;
			}
			case 4:{
				this.consultarFuncionario();
				break;
			}
			case 5: {
				int resposta = JOptionPane.showConfirmDialog(null, "Tem certeza?");
				if(resposta == 0) {
					JOptionPane.showMessageDialog(null, "Você foi desconectado do sistema!");
				}
				break;
			}
			default: {
				JOptionPane.showMessageDialog(null, "Opção Inválida");
				}
			}
		}
	}
	
		private String criarMenuFuncionario() {
			String mensagem = "Menu Funcionário";
			mensagem += "\n Opções:";
			mensagem += "\n 1 - Cadastrar Funcionário.";
			mensagem += "\n 2 - Excluir Funcionário.";
			mensagem += "\n 3 - Alterar Cadastro de Funcionário.";
			mensagem += "\n 4 - Exibir Cadastro de Funcionário.";
			mensagem += "\n 5 - Sair.";
			mensagem +="\n Digite a Opção: ";
			
			return mensagem;
		}	
	

	private void consultarFuncionario() {
       
		funcionarioVO.setIdFuncionario(Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o ID do funcionário para consultar.")));
		
		FuncionarioDAO consultarFuncionario = new FuncionarioDAO();
		consultarFuncionario.consultar();
	}

	private void atualizarFuncionario() {
		
		funcionarioVO.setIdFuncionario(Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o ID do funcionário para atualizar.")));
		funcionarioVO.setNome(JOptionPane.showInputDialog(null, "Digite o nome do funcionário."));
		funcionarioVO.setCpf(JOptionPane.showInputDialog(null,"Digite o CPF do funcionário."));
		funcionarioVO.setTelefone(JOptionPane.showInputDialog(null,"Digite o telefone."));
		funcionarioVO.setEmail(JOptionPane.showInputDialog(null,"Digite o e-mail."));
	 
		FuncionarioDAO atualizarFuncionario = new FuncionarioDAO();
		atualizarFuncionario.atualizar(funcionarioVO);
	}

	private void excluirFuncionario() {
	
		funcionarioVO.setIdFuncionario(Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o ID do funcionário para excluir.")));
		
		FuncionarioDAO excluirFuncionario = new FuncionarioDAO();
		excluirFuncionario.delete();
	}

	private void cadastrarFuncionario() {
		
		funcionarioVO.setNome(JOptionPane.showInputDialog(null, "Digite o nome do funcionário."));
		funcionarioVO.setCpf(JOptionPane.showInputDialog(null,"Digite o CPF."));
		funcionarioVO.setTelefone(JOptionPane.showInputDialog(null,"Digite o telefone."));
		funcionarioVO.setEmail(JOptionPane.showInputDialog(null,"Digite o e-mail."));
		
		FuncionarioDAO inserirFuncionario = new FuncionarioDAO();
		inserirFuncionario.insert(funcionarioVO);
	}


}
