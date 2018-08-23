package br.sc.senac.dd.aula05.exercicio2;

import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

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
				JOptionPane.showMessageDialog(null, "O n�mero digitado deve ser um inteiro entre 1 e 5;");
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
					JOptionPane.showMessageDialog(null, "Voc� foi desconectado do Menu Funcion�rio!");
					break;
				}

			default: 
				JOptionPane.showMessageDialog(null, "Op��o Inv�lida");
			}
		}
	}

	private String criarMenuFuncionario() {
		String mensagem = "Menu Funcion�rio";
		mensagem += "\n Op��es:";
		mensagem += "\n 1 - Cadastrar Funcion�rio.";
		mensagem += "\n 2 - Excluir Funcion�rio.";
		mensagem += "\n 3 - Alterar Cadastro de Funcion�rio.";
		mensagem += "\n 4 - Exibir Funcion�rio por CPF.";
		mensagem += "\n 5 - Exibir Todos os Funcion�rios.";
		mensagem += "\n 6 - Sair.";
		mensagem +="\n Digite a Op��o: ";

		return mensagem;
	}	

	private void cadastrarFuncionario() {
		
		FuncionarioVO funcionarioVO = new FuncionarioVO();
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		
		funcionarioVO.setCpf(JOptionPane.showInputDialog(null,"Digite o CPF."));
		if (funcionarioDAO.existeRegistroPorCpf(funcionarioVO.getCpf())){
			JOptionPane.showMessageDialog(null, "Funcionario j� cadastrado! Tente novamente.");
		}else{
		funcionarioVO.setNome(JOptionPane.showInputDialog(null, "Digite o nome do funcion�rio."));
		funcionarioVO.setCpf(JOptionPane.showInputDialog(null,"Digite o CPF."));
		funcionarioVO.setTelefone(JOptionPane.showInputDialog(null,"Digite o telefone."));
		funcionarioVO.setEmail(JOptionPane.showInputDialog(null,"Digite o e-mail."));
		
		int idGerado = funcionarioDAO.inserir(funcionarioVO);
			if(idGerado > 0) {
				JOptionPane.showMessageDialog(null, "Funcion�rio cadastrado com sucesso!");
			}else {
				JOptionPane.showMessageDialog(null,"Tente novamente!");
			}
		}
	}
		

	private void excluirFuncionario() throws SQLException {
		FuncionarioVO funcionarioVO = new FuncionarioVO();
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		
		funcionarioVO.setIdFuncionario(Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o ID do funcion�rio para excluir.")));
		if(funcionarioDAO.existeRegistroPorIdFuncionario(funcionarioVO.getIdFuncionario())) {
			funcionarioDAO.excluir(funcionarioVO.getIdFuncionario());
			JOptionPane.showMessageDialog(null, "Funcion�rio exclu�do com sucesso!");
		
		}else {
			JOptionPane.showMessageDialog(null, "ID n�o existe. N�o foi poss�vel excluir o Funcion�rio.");
		}
	}
	
	private void atualizarFuncionario() {
		FuncionarioVO funcionarioVO = new FuncionarioVO();
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		
		funcionarioVO.setIdFuncionario(Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o ID do funcion�rio para atualizar.")));
		if(funcionarioDAO.existeRegistroPorIdFuncionario(funcionarioVO.getIdFuncionario())) {
			
				funcionarioVO.setNome(JOptionPane.showInputDialog(null, "Digite o nome do funcion�rio."));
				funcionarioVO.setCpf(JOptionPane.showInputDialog(null,"Digite o CPF do funcion�rio."));
				funcionarioVO.setTelefone(JOptionPane.showInputDialog(null,"Digite o telefone."));
				funcionarioVO.setEmail(JOptionPane.showInputDialog(null,"Digite o e-mail."));

				try {
					if(funcionarioDAO.atualizar(funcionarioVO, funcionarioVO.getIdFuncionario()));
						JOptionPane.showMessageDialog(null, "Funcion�rio atualizado com sucesso!");
				} catch (SQLException e) {
					e.printStackTrace();
				}							
					}else {
						JOptionPane.showMessageDialog(null, "Funcion�rio n�o existe para ser atualizado!");	
			}
	}
				

	private void consultarTodosFuncionarios() {
		FuncionarioDAO consultarProduto = new FuncionarioDAO();
		try {
			List<FuncionarioVO> funcionarios = consultarProduto.listarTodos();
			JOptionPane.showMessageDialog(null, funcionarios.toString());
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void consultarFuncionarioPorCPF() throws SQLException {
		FuncionarioDAO consultarFuncionario = new FuncionarioDAO();
		
		String cpf = (JOptionPane.showInputDialog(null, "Digite o CPF do funcion�rio para consultar."));
		FuncionarioVO funcionarioConsultado = consultarFuncionario.consultarPorCpf(cpf);
		
			if(funcionarioConsultado != null) {
				JOptionPane.showMessageDialog(null, funcionarioConsultado);
			}else {
				JOptionPane.showMessageDialog(null,"Tente novamente!");
			}
	}
}
