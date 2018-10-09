package br.sc.senac.dd.aula06.exercicio04.View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import br.sc.senac.dd.aula06.Produto.Model.ProdutoVO;
import br.sc.senac.dd.aula06.exercicio04.Controller.FuncionarioController;
import br.sc.senac.dd.aula06.exercicio04.Model.FuncionarioVO;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JTable;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.event.MouseListener;

public class ListarTodos extends JPanel {

	private JTable tbFuncionario;
	private String [] nomesColunas = new String []
			{"Nome", "CPF", "Celular", "Telefone", "e-mail"};
	private JTextField textCPF;
	private static final String MASCARA_CPF = "###.###.###-##";
	private JButton btnBuscar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListarTodos frame = new ListarTodos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws ParseException 
	 */
	public ListarTodos(){
		setBounds(100, 100, 700, 602);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);
		
		JLabel lblFuncionario = new JLabel("Funcion\u00E1rios");
		lblFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblFuncionario.setBounds(59, 252, 156, 49);
		this.add(lblFuncionario);
		
		try {
		textCPF = new JFormattedTextField(new MaskFormatter (MASCARA_CPF));
		textCPF.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textCPF.setBounds(125, 138, 306, 46);
		this.add(textCPF);
		textCPF.setColumns(10);
		}catch(ParseException pEx) {
			//TODO tratar			
		}
		
		tbFuncionario = new JTable();
		tbFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tbFuncionario.setModel(new DefaultTableModel(
				new Object[][] {
					nomesColunas,
				},
				nomesColunas
				
			));
		tbFuncionario.setBounds(35, 301, 639, 148);
		this.add(tbFuncionario);
		
		JButton btnListarTodos = new JButton("Listar Todos Funcionarios");
		btnListarTodos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				FuncionarioController controlador = new FuncionarioController();
				ArrayList<FuncionarioVO> funcionariosVO = (ArrayList<FuncionarioVO>) controlador.listarTodosFuncionarios();
				
				DefaultTableModel tabela = (DefaultTableModel) tbFuncionario.getModel();
				for(FuncionarioVO funcionarioVO: funcionariosVO) {
					tabela.addRow(new Object[]{
							funcionarioVO.getNome(),
							funcionarioVO.getCpf(),
							funcionarioVO.getCelular(),
							funcionarioVO.getTelefone(),
							funcionarioVO.getEmail()
						
					});
				}
			}
		});
				
							
		btnListarTodos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnListarTodos.setBounds(183, 26, 328, 49);
		this.add(btnListarTodos);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCancelar.setBounds(510, 481, 141, 49);
		this.add(btnCancelar);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCpf.setBounds(46, 138, 81, 42);
		this.add(lblCpf);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				FuncionarioController controlador = new FuncionarioController();
				List<FuncionarioVO> funcionarios = null;
				
				if(textCPF.getText() != null) {
					funcionarios = controlador.exibirFuncionarioPorCPF(textCPF.getText());
				}
				atualizarTabelaFuncionarios(funcionarios);
			}

			private void atualizarTabelaFuncionarios(List<FuncionarioVO> funcionarios) {
				tbFuncionario.setModel(new DefaultTableModel(
						new Object[][] {},
						nomesColunas));
				
				DefaultTableModel modelo = (DefaultTableModel) tbFuncionario.getModel();
				
				for(FuncionarioVO funcionario: funcionarios) {
					//Crio uma nova linha na tabela
					//Preencher a linha com os atributos do produto
					//na ORDEM do cabeçalho da tabela
					Object[] novaLinha = new Object[] {
							funcionario.getNome(),
							funcionario.getCpf(),
							funcionario.getCelular(),
							funcionario.getTelefone(),
							funcionario.getEmail()
							
					};
					modelo.addRow(novaLinha);
				}
			}
				
				
			
		
	});
		
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnBuscar.setBounds(470, 135, 141, 49);
		this.add(btnBuscar);
		
		
		
		
	}
	

}
