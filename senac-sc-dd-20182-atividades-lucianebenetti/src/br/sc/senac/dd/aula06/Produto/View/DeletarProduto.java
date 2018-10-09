package br.sc.senac.dd.aula06.Produto.View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import br.sc.senac.dd.aula06.Produto.Controller.ProdutoController;
import br.sc.senac.dd.aula06.Produto.Model.ProdutoBO;
import br.sc.senac.dd.aula06.Produto.Model.ProdutoVO;
import br.sc.senac.dd.aula06.exercicio04.Controller.FuncionarioController;
import br.sc.senac.dd.aula06.exercicio04.Model.FuncionarioBO;
import br.sc.senac.dd.aula06.exercicio04.Model.FuncionarioVO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import java.awt.Font;
import java.text.ParseException;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DeletarProduto extends JPanel  {

	private JLabel lblIDProduto;
	private JLabel lblSecao;
	private JLabel lblNome;
	private JButton btnExcluir;
	private JButton btnCancelar;
	private JButton btnBuscar;
	private JTextField textBuscaID;
	private JTextField textNome;
	private JTextField textSecao;
	private ProdutoVO produtoVO = new ProdutoVO();
	private ProdutoBO bo = new ProdutoBO();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeletarProduto frame = new DeletarProduto();
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
	public DeletarProduto() {
		
		setBounds(100, 100, 592, 352);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);
		
		lblIDProduto = new JLabel("ID do Produto");
		lblIDProduto.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblIDProduto.setBounds(10, 11, 145, 49);
		this.add(lblIDProduto);
		
		lblSecao = new JLabel("Se\u00E7\u00E3o");
		lblSecao.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSecao.setBounds(10, 142, 99, 49);
		this.add(lblSecao);
		
		lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNome.setBounds(10, 71, 99, 49);
		this.add(lblNome);
		
		btnExcluir = new JButton("Excluir");
		btnExcluir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ProdutoController controlador = new ProdutoController();
				controlador.deletar(produtoVO);
				limparTela();
			}

		});
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
				
		btnExcluir.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnExcluir.setBounds(82, 217, 108, 45);
		this.add(btnExcluir);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				 System.exit(0);
		}

		});
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCancelar.setBounds(338, 217, 131, 45);
		this.add(btnCancelar);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setEnabled(false);
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				produtoVO = bo.buscarProdutoPorId(textBuscaID.getText());
				
				if(produtoVO != null) {
					btnBuscar.setEnabled(true);
						textNome.setText(produtoVO.getNome());
						textSecao.setText(produtoVO.getSecao());
								
					}else {
						JOptionPane.showMessageDialog(null, "Produto não encontrado.");
					}
				}
			@Override
			public void mousePressed(MouseEvent arg0) {
				btnBuscar.setForeground(Color.BLUE);;
			}
			
			
		});
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
			
		
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnBuscar.setBounds(439, 13, 99, 45);
		this.add(btnBuscar);
		
		textBuscaID = new JTextField();
		textBuscaID.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textBuscaID.setBounds(158, 17, 271, 37);
		this.add(textBuscaID);
		textBuscaID.setColumns(10);
		
		textNome = new JTextField();
		textNome.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textNome.setBounds(158, 79, 271, 37);
		this.add(textNome);
		textNome.setColumns(10);
		
		textSecao = new JTextField();
		textSecao.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textSecao.setBounds(158, 142, 271, 34);
		this.add(textSecao);
		textSecao.setColumns(10);
	}
		
		private void limparTela() {
			produtoVO = new ProdutoVO();
			textBuscaID.setText("");
			textNome.setText("");
			textSecao.setText("");
		}

}
