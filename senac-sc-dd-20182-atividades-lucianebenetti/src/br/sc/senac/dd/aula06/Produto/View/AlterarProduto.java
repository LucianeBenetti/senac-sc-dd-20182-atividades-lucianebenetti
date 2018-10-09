package br.sc.senac.dd.aula06.Produto.View;

import java.awt.BorderLayout;
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
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import java.awt.Font;
import java.text.ParseException;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;

public class AlterarProduto extends JPanel {

	private JLabel lblNome;
	private JTextField textNome;
	private JLabel lblID;
	private JTextField textId;
	private JLabel lblSecao;
	private JLabel lblValor;
	private JTextField textValor;
	private JLabel lblBuscaID;
	private JTextField textBuscaID;
	private JButton btnBuscar;
	private JButton btnAtualizar;
	private JButton btnCancelar;
	private JComboBox cbSecao;
	private ProdutoVO produtoDaTela = new ProdutoVO();
	private ProdutoVO produtoConsultado = new ProdutoVO();
	private ProdutoBO bo = new ProdutoBO();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlterarProduto frame = new AlterarProduto();
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
	public AlterarProduto(){
		setBounds(100, 100, 560, 459);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);
		
		lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNome.setBounds(10, 87, 76, 38);
		this.add(lblNome);
		
		textNome = new JTextField();
		textNome.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textNome.setBounds(169, 92, 324, 29);
		this.add(textNome);
		textNome.setColumns(10);
		
		lblID = new JLabel("ID");
		lblID.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblID.setBounds(10, 141, 76, 38);
		this.add(lblID);
		
		textId = new JTextField();
		textId.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textId.setColumns(10);
		textId.setBounds(169, 146, 324, 29);
		this.add(textId);
		
		lblSecao = new JLabel("Se\u00E7\u00E3o");
		lblSecao.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSecao.setBounds(10, 195, 95, 38);
		this.add(lblSecao);
		
		lblValor = new JLabel("Valor");
		lblValor.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblValor.setBounds(10, 249, 76, 38);
		this.add(lblValor);
		
		textValor = new JTextField();
		textValor.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textValor.setColumns(10);
		textValor.setBounds(169, 254, 324, 29);
		this.add(textValor);
		
		lblBuscaID = new JLabel("ID do Produto");
		lblBuscaID.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblBuscaID.setBounds(10, 11, 124, 38);
		this.add(lblBuscaID);
		
		textBuscaID = new JTextField();
		textBuscaID.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textBuscaID.setColumns(10);
		textBuscaID.setBounds(169, 20, 189, 29);
		this.add(textBuscaID);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				produtoConsultado = bo.buscarProdutoPorId(textBuscaID.getText());
				
				if(produtoConsultado != null) {
					textNome.setText(produtoConsultado.getNome());
					textId.setText(produtoConsultado.getIdProduto()+"");
					cbSecao.setSelectedItem(produtoConsultado.getSecao());
					textValor.setText(produtoConsultado.getValor()+"");
					
								
					}else {
						JOptionPane.showMessageDialog(null, "Produto não encontrado.");
					}
				}
		});
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnBuscar.setBounds(381, 11, 112, 38);
		this.add(btnBuscar);
		
		btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ProdutoController controlador = new ProdutoController();
				construirProduto();
				controlador.atualizar(produtoDaTela);
		}

		});
		
		btnAtualizar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAtualizar.setBounds(63, 341, 138, 38);
		this.add(btnAtualizar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				 System.exit(0);
		}

		});
		
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCancelar.setBounds(341, 341, 152, 38);
		this.add(btnCancelar);
		
		String[] secoes = {"---Selecione---", "Açougue", "Bebidas", "Higiene", "Hortifruti", "Alimentos", "Produtos de Limpeza"};
		cbSecao = new JComboBox(secoes);
		cbSecao.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cbSecao.setBounds(169, 199, 324, 31);
		this.add(cbSecao);
	}
	

	protected void limparTela() {
		produtoDaTela = new ProdutoVO();
		produtoConsultado = new ProdutoVO();

		textBuscaID.setText("");
		textNome.setText("");
		textId.setText("");
		cbSecao.setSelectedIndex(0);
		textValor.setText("");
			
	}

	public void construirProduto() {
		produtoDaTela.setNome(textNome.getText());
		produtoDaTela.setIdProduto(Integer.parseInt(textId.getText()));
		produtoDaTela.setSecao((String) cbSecao.getSelectedItem());
		produtoDaTela.setValor(Double.parseDouble(textValor.getText()));
		
	}
}
