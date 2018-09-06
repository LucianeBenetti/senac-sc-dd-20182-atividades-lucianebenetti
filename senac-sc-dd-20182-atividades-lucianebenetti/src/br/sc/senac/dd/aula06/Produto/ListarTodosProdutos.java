package br.sc.senac.dd.aula06.Produto;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.ListSelectionModel;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ListarTodosProdutos extends JFrame {

	private JPanel contentPane;
	private JTable tblProdutos;
	private String[] nomesColunas = new String[] {"Nome", 
			"Secao", "Valor"};
	private ProdutoVO produto = new ProdutoVO();
	private JTextField textFiltroNome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListarTodosProdutos frame = new ListarTodosProdutos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ListarTodosProdutos() {
		setTitle("Consulta de Produtos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 676, 508);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		tblProdutos = new JTable();
		tblProdutos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tblProdutos.setModel(new DefaultTableModel(
				new Object[][] {
				},
				nomesColunas
			));
		tblProdutos.setBounds(20, 194, 598, 152);
		contentPane.add(tblProdutos);

		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		btnConsultar.setBounds(229, 117, 154, 56);
		contentPane.add(btnConsultar);
		
		JLabel lblFiltroNome = new JLabel("Produto");
		lblFiltroNome.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblFiltroNome.setBounds(20, 56, 110, 29);
		contentPane.add(lblFiltroNome);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(20, 56, 404, -1);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(20, 105, 598, 14);
		contentPane.add(separator_1);
		
		JLabel lblFiltrosDeConsulta = new JLabel("Filtros de consulta:");
		lblFiltrosDeConsulta.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblFiltrosDeConsulta.setBounds(154, 11, 347, 29);
		contentPane.add(lblFiltrosDeConsulta);
		
		textFiltroNome = new JTextField();
		textFiltroNome.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textFiltroNome.setBounds(145, 50, 318, 41);
		contentPane.add(textFiltroNome);
		textFiltroNome.setColumns(10);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}
		});
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCancelar.setBounds(229, 380, 154, 56);
		contentPane.add(btnCancelar);
		
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				ProdutoController controlador = new ProdutoController();
				
				boolean temNomePreenchido = false;
							
				if(textFiltroNome.getText().trim() !="") {
					temNomePreenchido = true;
					
					if(textFiltroNome.getText().equals(produto.getNome())) {
						String nome = produto.getNome();
						textFiltroNome.setText(nome);
					}
				}
				
				//TODO Fazer para os demais filtros da tela
				
				if(temNomePreenchido) {
					//TODO chamar a consulta COM filtro
					//List<ProdutoVO> produtos = controlador.listarPorNome(nome);
				}else {
					List<ProdutoVO> produtos = controlador.listarTodosProdutos();
					//Atualizar a tabela
					atualizarTabelaProdutos(produtos);
				}

			}
		});
	}

	protected void atualizarTabelaProdutos(List<ProdutoVO> produtos) {
		//Limpa a tabela
		tblProdutos.setModel(new DefaultTableModel(
				new Object[][] {},
				nomesColunas));
		
		DefaultTableModel modelo = (DefaultTableModel) tblProdutos.getModel();
		
		for(ProdutoVO produto: produtos) {
			//Crio uma nova linha na tabela
			//Preencher a linha com os atributos do produto
			//na ORDEM do cabeçalho da tabela
			Object[] novaLinha = new Object[] {
					produto.getNome(),
					produto.getSecao(),
					produto.getValor(),
					
			};
			modelo.addRow(novaLinha);
		}

	}
}