package br.sc.senac.dd.aula06.exercicio04.View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import br.sc.senac.dd.aula06.exercicio04.Controller.ProdutoController;
import br.sc.senac.dd.aula06.exercicio04.Model.ProdutoVO;

import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastroProdutoView {

	private JFrame frmCadastroDeNovo;
	private JTextField textNome;
	private JTextField textValor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroProdutoView window = new CadastroProdutoView();
					window.frmCadastroDeNovo.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CadastroProdutoView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCadastroDeNovo = new JFrame();
		frmCadastroDeNovo.setTitle("Novo Produto");
		frmCadastroDeNovo.setBounds(100, 100, 724, 491);
		frmCadastroDeNovo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCadastroDeNovo.getContentPane().setLayout(null);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNome.setBounds(41, 31, 87, 40);
		frmCadastroDeNovo.getContentPane().add(lblNome);
		
		JLabel lblSecao = new JLabel("Se\u00E7\u00E3o");
		lblSecao.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSecao.setBounds(41, 124, 112, 40);
		frmCadastroDeNovo.getContentPane().add(lblSecao);
		
		String [] secoes = {"------Selecione------", "Açougue", "Bebidas", "Higiene", "Hortifruti", "Alimentos", "Produtos de Limpeza"};
		JComboBox comboBox = new JComboBox(secoes);
		comboBox.setBounds(173, 126, 446, 40);
		frmCadastroDeNovo.getContentPane().add(comboBox);
		
		textNome = new JTextField();
		textNome.setBounds(173, 31, 446, 40);
		frmCadastroDeNovo.getContentPane().add(textNome);
		textNome.setColumns(10);
		
		textValor = new JTextField();
		textValor.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				//Digitar somente números
				int numeroDigitado = evt.getKeyChar();
				String texto = textValor.getText();
				try {
					int numero = Integer.parseInt(numeroDigitado + "");
					texto += numeroDigitado;
				}catch (NumberFormatException e) {
					if(numeroDigitado == ',') {
						if(texto.contains(",")) {
							texto +=",";
						}
					}
				}
				textValor.setText(texto);
					
			}
		});
		textValor.setBounds(173, 221, 446, 40);
		frmCadastroDeNovo.getContentPane().add(textValor);
		textValor.setColumns(10);
		
		JLabel lblValor = new JLabel("Valor");
		lblValor.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblValor.setBounds(41, 221, 112, 41);
		frmCadastroDeNovo.getContentPane().add(lblValor);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSalvar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ProdutoController controlador = new ProdutoController();
				ProdutoVO produto = new ProdutoVO();
				produto.setNome(textNome.getText());
				produto.setValor(Double.parseDouble((textValor.getText())));
				
				
			}
		});
		btnSalvar.setBounds(31, 336, 622, 59);
		frmCadastroDeNovo.getContentPane().add(btnSalvar);
	}
}
