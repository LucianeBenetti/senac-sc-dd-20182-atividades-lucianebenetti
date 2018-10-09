package br.sc.senac.dd.aula06.Produto.View;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.sc.senac.dd.aula06.Produto.Controller.ProdutoController;
import br.sc.senac.dd.aula06.Produto.Model.ProdutoBO;
import br.sc.senac.dd.aula06.Produto.Model.ProdutoVO;

public class CadastroProduto extends JPanel {

	private ProdutoBO bo = new ProdutoBO();
	private ProdutoVO produto = new ProdutoVO();
	private JTextField txtNome;
	private JComboBox cbSecao;
	private JTextField txtValor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroProduto window = new CadastroProduto();
					window.setVisible(true);
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
		

		setBounds(100, 100, 547, 389);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);
		
		setBounds(100, 100, 547, 429);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNome.setBounds(10, 56, 81, 34);
		this.add(lblNome);

		JLabel lblSecao = new JLabel("Secao:");
		lblSecao.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSecao.setBounds(10, 137, 81, 28);
		this.add(lblSecao);

		JLabel lblValor = new JLabel("Valor:");
		lblValor.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblValor.setBounds(10, 211, 81, 34);
		this.add(lblValor);

		txtNome = new JTextField();
		txtNome.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtNome.setBounds(174, 58, 316, 31);
		this.add(txtNome);
		txtNome.setColumns(10);

		String[] secoes = {"---Selecione---", "Açougue", "Bebidas", "Higiene", "Hortifruti", "Alimentos", "Produtos de Limpeza"};
		cbSecao = new JComboBox(secoes);
		cbSecao.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cbSecao.setBounds(174, 147, 316, 31);
		this.add(cbSecao);

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
		this.add(btnSalvar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			
			}
		});
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCancelar.setBounds(330, 292, 115, 51);
		this.add(btnCancelar);
		
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
		this.add(txtValor);
		
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