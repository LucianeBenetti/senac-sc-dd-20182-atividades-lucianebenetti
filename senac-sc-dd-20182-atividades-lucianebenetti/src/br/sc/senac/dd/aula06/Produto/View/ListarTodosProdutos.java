package br.sc.senac.dd.aula06.Produto.View;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import br.sc.senac.dd.aula06.Produto.Controller.ProdutoController;
import br.sc.senac.dd.aula06.Produto.Model.ProdutoVO;

import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.ListSelectionModel;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ListarTodosProdutos extends JPanel  {

	private JTable tblProdutos;
	private ProdutoVO produto = new ProdutoVO();
	private String [] nomesColunas = new String []
			{"Nome", "Secao", "Valor"};
	private JComboBox cbConsultaPorSecao;

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
		
		setBounds(100, 100, 705, 733);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);

		tblProdutos = new JTable();
		tblProdutos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tblProdutos.setModel(new DefaultTableModel(
				new Object[][] {
					nomesColunas,
				},
				nomesColunas
				
			));
		tblProdutos.setBounds(41, 406, 598, 183);
		this.add(tblProdutos);

		JButton btnConsultarTodos = new JButton("Consultar Todos Produtos");
		btnConsultarTodos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		btnConsultarTodos.setBounds(177, 16, 303, 56);
		this.add(btnConsultarTodos);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(20, 56, 404, -1);
		this.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(20, 105, 598, 14);
		this.add(separator_1);
		
		JLabel lblFiltrosDeConsulta = new JLabel("Filtro de consulta:");
		lblFiltrosDeConsulta.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblFiltrosDeConsulta.setBounds(205, 105, 219, 29);
		this.add(lblFiltrosDeConsulta);
		
		String[] secoes = {"---Selecione---", "Açougue", "Bebidas", "Higiene", "Hortifruti", "Alimentos", "Produtos de Limpeza"};
		cbConsultaPorSecao = new JComboBox(secoes);
		cbConsultaPorSecao.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cbConsultaPorSecao.setBounds(195, 210, 242, 41);
		this.add(cbConsultaPorSecao);
	
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}
		});
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCancelar.setBounds(514, 605, 154, 56);
		this.add(btnCancelar);
		
		JButton btnConsultarItem = new JButton("Consultar Item");
		btnConsultarItem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ProdutoController controlador = new ProdutoController();
				List<ProdutoVO> produtos = null;
				
						
				if(cbConsultaPorSecao.getSelectedIndex() > -1) {
					if(cbConsultaPorSecao.getSelectedItem() != null) {
					produtos = controlador.listarProdutosPorSecao((String) cbConsultaPorSecao.getSelectedItem());
					}
				}else {
					produtos = controlador.listarTodosProdutos();
				}
				
				atualizarTabelaProdutos(produtos);
			}
		});
			
		btnConsultarItem.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnConsultarItem.setBounds(480, 202, 175, 56);
		this.add(btnConsultarItem);
		
		JLabel lblSecaoDoProduto = new JLabel("Se\u00E7\u00E3o do Produto");
		lblSecaoDoProduto.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSecaoDoProduto.setBounds(30, 222, 166, 29);
		this.add(lblSecaoDoProduto);
		
		
			
		btnConsultarTodos.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				
				ProdutoController controlador = new ProdutoController();
				ArrayList<ProdutoVO> produtosVO = (ArrayList<ProdutoVO>) controlador.listarTodosProdutos();
				
				DefaultTableModel tabela = (DefaultTableModel) tblProdutos.getModel();
				for(ProdutoVO produtoVO: produtosVO) {
					tabela.addRow(new Object[]{
							produtoVO.getNome(),
							produtoVO.getSecao(),
							produtoVO.getValor()
						
					});
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
