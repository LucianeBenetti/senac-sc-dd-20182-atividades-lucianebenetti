package br.sc.senac.dd.aula06.exercicio04.Produto.View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.BorderLayout;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import br.sc.senac.dd.aula06.exercicio04.Produto.Controller.ProdutoController;
import br.sc.senac.dd.aula06.exercicio04.Produto.Model.ProdutoBO;
import br.sc.senac.dd.aula06.exercicio04.Produto.Model.ProdutoVO;

import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;

public class CadastroProduto {

	private ProdutoBO bo = new ProdutoBO();
	private ProdutoVO produto = new ProdutoVO();
	private JFrame frmNovoProduto;
	private JTextField txtNome;
	private JComboBox cbSecao;
	private JTextField txtId;
	private JTextField txtValor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroProduto window = new CadastroProduto();
					window.frmNovoProduto.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CadastroProduto() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmNovoProduto = new JFrame();
		frmNovoProduto.setTitle("Novo produto");
		frmNovoProduto.setBounds(100, 100, 547, 429);
		frmNovoProduto.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmNovoProduto.getContentPane().setLayout(null);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNome.setBounds(10, 117, 81, 34);
		frmNovoProduto.getContentPane().add(lblNome);

		JLabel lblSecao = new JLabel("Secao:");
		lblSecao.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSecao.setBounds(10, 167, 81, 28);
		frmNovoProduto.getContentPane().add(lblSecao);

		JLabel lblValor = new JLabel("Valor:");
		lblValor.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblValor.setBounds(10, 211, 81, 34);
		frmNovoProduto.getContentPane().add(lblValor);

		txtNome = new JTextField();
		txtNome.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtNome.setBounds(174, 117, 316, 31);
		frmNovoProduto.getContentPane().add(txtNome);
		txtNome.setColumns(10);

		String[] secoes = {"---Selecione---", "Açougue", "Bebidas", "Higiene", "Hortifruti", "Alimentos", "Produtos de Limpeza"};
		cbSecao = new JComboBox(secoes);
		cbSecao.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cbSecao.setBounds(174, 164, 316, 31);
		frmNovoProduto.getContentPane().add(cbSecao);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSalvar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ProdutoController controlador = new ProdutoController();
				ProdutoVO produto = construirProduto();

				String mensagem = controlador.salvar(produto);
				JOptionPane.showMessageDialog(null, mensagem);
				limparTela();
			}

		});
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnSalvar.setBounds(53, 292, 115, 51);
		frmNovoProduto.getContentPane().add(btnSalvar);
		
		JLabel lblId = new JLabel("Digite o ID para Buscar");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblId.setBounds(10, 11, 188, 45);
		frmNovoProduto.getContentPane().add(lblId);
		
		txtId = new JTextField();
		txtId.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtId.setBounds(250, 13, 120, 43);
		frmNovoProduto.getContentPane().add(txtId);
		txtId.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				produto = bo.buscarProdutoPorId(txtId.getText());
				
				if(produto != null) {
					//Preencher os campos da tela
					txtNome.setText(produto.getNome());
					cbSecao.setSelectedItem(produto.getSecao());
					
					String valorFormatado = produto.getValor() + ""; 
					txtValor.setText(valorFormatado);
					
				}else {
					JOptionPane.showMessageDialog(null, "Produto não encontrado");
				}
			}
		});
		btnBuscar.setBounds(385, 16, 105, 45);
		frmNovoProduto.getContentPane().add(btnBuscar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}
		});
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCancelar.setBounds(330, 292, 115, 51);
		frmNovoProduto.getContentPane().add(btnCancelar);
		
		txtValor = new JTextField();
		txtValor.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				double num1 = e.getKeyCode();
			}
		});
		txtValor.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtValor.setColumns(10);
		txtValor.setBounds(174, 213, 316, 31);
		frmNovoProduto.getContentPane().add(txtValor);
	}

	protected void limparTela() {
		produto = new ProdutoVO();
		txtNome.setText("");
		cbSecao.setSelectedIndex(0);
		txtValor.setText("");
		
	}

	public ProdutoVO construirProduto() {
		produto.setNome(txtNome.getText());
		produto.setSecao((String) cbSecao.getSelectedItem());
		
		String valor = txtValor.getText();
		
		if(valor.trim() !="") {
		produto.setValor(Double.parseDouble(valor));
		}
		return produto;
	
	}
}