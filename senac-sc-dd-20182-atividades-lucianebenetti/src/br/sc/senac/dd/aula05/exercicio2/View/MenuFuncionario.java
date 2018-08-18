package br.sc.senac.dd.aula05.exercicio2.View;

import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import br.sc.senac.dd.aula05.exercicio2.ModelDAO.FuncionarioDAO;
import br.sc.senac.dd.aula05.exercicio2.ModelVO.FuncionarioVO;

public class MenuFuncionario{

	public void apresentaMenuFuncionario() {

		int opcao = -1;

		while (opcao !=6) {
			try {
				String valorDigitado = JOptionPane.showInputDialog(criarMenuFuncionario());
				if(valorDigitado !=null) {
					opcao = Integer.parseInt(valorDigitado);
				}else {
					break;
				}

			}catch(NumberFormatException ex){
				JOptionPane.showMessageDialog(null, "O número digitado deve ser um inteiro entre 1 e 5;");
			}
			switch(opcao) {
			case 1:
				this.cadastrarFuncionario();
				break;

			case 2:
				try {
					this.excluirFuncionario();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				break;

			case 3:
				this.atualizarFuncionario();
				break;

			case 4:
				try {
					this.consultarFuncionarioPorCPF();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;

			case 5:
				this.consultarTodosFuncionarios();
				break;

			case 6: 
				int resposta = JOptionPane.showConfirmDialog(null, "Tem certeza?");
				if(resposta == 0) {
					JOptionPane.showMessageDialog(null, "Você foi desconectado do Menu Funcionário!");
					break;
				}

			default: 
				JOptionPane.showMessageDialog(null, "Opção Inválida");
			}
		}
	}

	private String criarMenuFuncionario() {
		String mensagem = "Menu Funcionário";
		mensagem += "\n Opções:";
		mensagem += "\n 1 - Cadastrar Funcionário.";
		mensagem += "\n 2 - Excluir Funcionário.";
		mensagem += "\n 3 - Alterar Cadastro de Funcionário.";
		mensagem += "\n 4 - Exibir Funcionário por CPF.";
		mensagem += "\n 5 - Exibir Todos os Funcionários.";
		mensagem += "\n 6 - Sair.";
		mensagem +="\n Digite a Opção: ";

		return mensagem;
	}	

	private void cadastrarFuncionario() {
		
		FuncionarioVO funcionarioVO = new FuncionarioVO();
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		
		funcionarioVO.setCpf(JOptionPane.showInputDialog(null,"Digite o CPF."));
		if (funcionarioDAO.existeRegistroPorCpf(funcionarioVO.getCpf())){
			JOptionPane.showMessageDialog(null, "Funcionario já cadastrado! Tente novamente.");
		}else{
		funcionarioVO.setNome(JOptionPane.showInputDialog(null, "Digite o nome do funcionário."));
		funcionarioVO.setCpf(JOptionPane.showInputDialog(null,"Digite o CPF."));
		funcionarioVO.setTelefone(JOptionPane.showInputDialog(null,"Digite o telefone."));
		funcionarioVO.setEmail(JOptionPane.showInputDialog(null,"Digite o e-mail."));

		funcionarioDAO.inserir(funcionarioVO);
		JOptionPane.showMessageDialog(null, "Funcionário cadastrado com sucesso!");
		}
	}

	private void excluirFuncionario() throws SQLException {
		FuncionarioVO funcionarioVO = new FuncionarioVO();
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		
		funcionarioVO.setIdFuncionario(Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o ID do funcionário para excluir.")));
		if(funcionarioDAO.existeRegistroPorIdFuncionario(funcionarioVO.getIdFuncionario())) {
			funcionarioDAO.excluir(funcionarioVO.getIdFuncionario());
			JOptionPane.showMessageDialog(null, "Funcionário excluído com sucesso!");
		
		}else {
			JOptionPane.showMessageDialog(null, "ID não existe. Não foi possível excluir o Funcionário.");
		}
	}
	
	private void atualizarFuncionario() {
		FuncionarioVO funcionarioVO = new FuncionarioVO();
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		
		funcionarioVO.setIdFuncionario(Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o ID do funcionário para atualizar.")));
		if(funcionarioDAO.existeRegistroPorIdFuncionario(funcionarioVO.getIdFuncionario())) {
			
				funcionarioVO.setNome(JOptionPane.showInputDialog(null, "Digite o nome do funcionário."));
				funcionarioVO.setCpf(JOptionPane.showInputDialog(null,"Digite o CPF do funcionário."));
				funcionarioVO.setTelefone(JOptionPane.showInputDialog(null,"Digite o telefone."));
				funcionarioVO.setEmail(JOptionPane.showInputDialog(null,"Digite o e-mail."));

					try {
						funcionarioDAO.atualizar(funcionarioVO, funcionarioVO.getIdFuncionario());
					JOptionPane.showMessageDialog(null, "Funcionário atualizado com sucesso!");	
					} catch (SQLException e) {
					
						e.printStackTrace();
					}
			}else {
				JOptionPane.showMessageDialog(null, "Funcionário não existe para ser atualizado!");	
			}
	}
				

	private void consultarTodosFuncionarios() {
		FuncionarioDAO consultarProduto = new FuncionarioDAO();
		try {
			List<FuncionarioVO> funcionarios = consultarProduto.listarTodos();

			JOptionPane.showMessageDialog(null, funcionarios.toString());
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void consultarFuncionarioPorCPF() throws SQLException {
		FuncionarioVO funcionarioVO = new FuncionarioVO();
		funcionarioVO.setCpf(JOptionPane.showInputDialog(null, "Digite o CPF do funcionário para consultar."));

		FuncionarioDAO consultarFuncionario = new FuncionarioDAO();
		consultarFuncionario.consultarPorCpf(funcionarioVO.getCpf());
	}



}
