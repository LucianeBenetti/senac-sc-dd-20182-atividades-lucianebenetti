package br.sc.senac.dd.aula06.Produto;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;
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

public class CadastroProduto implements KeyListener, MouseListener, ActionListener {

	private JFrame frmCadastroProdutoNovo;
	private JTextField textNome;
	private ProdutoBO bo = new ProdutoBO();
	private ProdutoVO produtoVO = new ProdutoVO();
	private JButton btnCancelar;
	private JButton btnSalvar;
	private JComboBox cbSecao;
	private JFormattedTextField textValor;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroProduto window = new CadastroProduto();
					window.frmCadastroProdutoNovo.setVisible(true);
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
		frmCadastroProdutoNovo = new JFrame();
		frmCadastroProdutoNovo.setTitle("Novo Produto");
		frmCadastroProdutoNovo.setBounds(100, 100, 724, 491);
		frmCadastroProdutoNovo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCadastroProdutoNovo.getContentPane().setLayout(null);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCancelar.setBounds(358, 336, 309, 59);
		frmCadastroProdutoNovo.getContentPane().add(btnCancelar);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNome.setBounds(41, 31, 87, 40);
		frmCadastroProdutoNovo.getContentPane().add(lblNome);
		
		JLabel lblSecao = new JLabel("Se\u00E7\u00E3o");
		lblSecao.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSecao.setBounds(41, 124, 112, 40);
		frmCadastroProdutoNovo.getContentPane().add(lblSecao);
		
		String [] secoes = {"------Selecione------", "Açougue", "Bebidas", "Higiene", "Hortifruti", "Alimentos", "Produtos de Limpeza"};
		cbSecao = new JComboBox(secoes);
		cbSecao.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cbSecao.setBounds(173, 126, 446, 40);
		frmCadastroProdutoNovo.getContentPane().add(cbSecao);
		
		textNome = new JTextField();
		textNome.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textNome.setBounds(173, 31, 446, 40);
		frmCadastroProdutoNovo.getContentPane().add(textNome);
		textNome.setColumns(10);
		
		JLabel lblValor = new JLabel("Valor");
		lblValor.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblValor.setBounds(41, 221, 112, 41);
		frmCadastroProdutoNovo.getContentPane().add(lblValor);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.addMouseListener(new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
			if (e.getSource() == btnSalvar) {
				do_btnSalvar_mouseClicked(e);
				ProdutoController controlador = new ProdutoController();
				ProdutoVO produtoVO = contruirProduto();
				
				String mensagem = controlador.salvar(produtoVO);
				JOptionPane.showMessageDialog(null,  mensagem);
				limparTela();
				}
			}
		});
		btnSalvar.addMouseListener(this);
		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSalvar.setBounds(41, 336, 271, 59);
		frmCadastroProdutoNovo.getContentPane().add(btnSalvar);
		
		//textValor = new JFormattedTextField();
		textValor.addKeyListener(this);
		//textValor = new JFormattedTextField(new MaskFormatter("(#####,##"));
		textValor.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textValor.setBounds(173, 221, 446, 34);
		frmCadastroProdutoNovo.getContentPane().add(textValor);
	}
		
		
	public MaskFormatter Mascara(String Mascara){
        MaskFormatter F_Mascara = new MaskFormatter();
        try{
            F_Mascara.setMask(Mascara); //Atribui a mascara
            F_Mascara.setPlaceholderCharacter(' '); //Caracter para preencimento 
        }
        catch (Exception excecao) {
        excecao.printStackTrace();
        } 
        return F_Mascara;
 }
	
	
	protected void limparTela() {
		produtoVO = new ProdutoVO();
		textNome.setText(" ");
		cbSecao.setSelectedIndex(0);
		textValor.setText(" ");
	}

	public ProdutoVO contruirProduto() {
		produtoVO.setNome(textNome.getText());
		
		String valor = textValor.getText();
		
		if(valor.trim() !="") {
		produtoVO.setValor(Double.parseDouble(valor));
		}
		return produtoVO;
	}

	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}
	protected static void do_btnSalvar_mouseClicked(MouseEvent e) {
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		if (e.getSource() == textValor) {
			do_textValor_keyTyped(e);
			e.getKeyCode();
		}
		// TODO Auto-generated method stub
		
	}
	protected static void do_textValor_keyTyped(KeyEvent arg0) {
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancelar) {
			do_btnCancelar_actionPerformed(e);
			System.exit(0);
		}
	}
	protected static void do_btnCancelar_actionPerformed(ActionEvent arg0) {
	}
}
