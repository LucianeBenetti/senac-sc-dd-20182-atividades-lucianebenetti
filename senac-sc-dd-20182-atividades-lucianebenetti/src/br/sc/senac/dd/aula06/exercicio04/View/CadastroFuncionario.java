package br.sc.senac.dd.aula06.exercicio04.View;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import br.sc.senac.dd.aula06.exercicio04.Controller.FuncionarioController;
import br.sc.senac.dd.aula06.exercicio04.Model.FuncionarioBO;
import br.sc.senac.dd.aula06.exercicio04.Model.FuncionarioVO;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import java.awt.Font;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class CadastroFuncionario extends JFrame {

	private static final String MASCARA_TELEFONE_FIXO = "(##) ####-####";
	private static final String MASCARA_TELEFONE_CELULAR ="(##) #####-####";
	private static final String MASCARA_CPF = "###.###.###-##";
	private JPanel contentPane;
	private JLabel lblNome;
	private JLabel lblCpf;
	private JLabel lblTelefone;
	private JButton btnSalvar;
	private JButton btnCancelar;
	private JTextField textNome;
	private JTextField textCpf;
	private JLabel lblEmail;
	private JTextField textTelefone;
	private JTextField textEmail;
	private FuncionarioBO bo = new FuncionarioBO();
	private FuncionarioVO funcionario = new FuncionarioVO();
	private JLabel lblCelular;
	private JFormattedTextField textCelular;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroFuncionario frame = new CadastroFuncionario();
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
	public CadastroFuncionario() throws ParseException {
		setTitle("Cadastrar Funcion\u00E1rio");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 569, 501);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNome.setBounds(15, 18, 85, 35);
		contentPane.add(lblNome);
		
		lblCpf = new JLabel("CPF");
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCpf.setBounds(15, 73, 85, 35);
		contentPane.add(lblCpf);
		
		lblTelefone = new JLabel("Telefone");
		lblTelefone.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTelefone.setBounds(15, 132, 159, 35);
		contentPane.add(lblTelefone);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				FuncionarioController controlador = new FuncionarioController();
				FuncionarioVO funcionario = contruirFuncionario();
				
				String mensagem = controlador.salvar(funcionario);
				JOptionPane.showMessageDialog(null,  mensagem);
				limparTela();
			}

		});
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSalvar.setBounds(40, 386, 148, 41);
		contentPane.add(btnSalvar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				 System.exit(0);
		}

		});
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCancelar.setBounds(324, 386, 130, 41);
		contentPane.add(btnCancelar);
		
		textNome = new JTextField();
		textNome.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textNome.setBounds(187, 18, 321, 35);
		contentPane.add(textNome);
		textNome.setColumns(10);
		
		textCpf = new JFormattedTextField(new MaskFormatter (MASCARA_CPF));
		textCpf.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textCpf.setBounds(187, 73, 321, 35);
		contentPane.add(textCpf);
		
		lblEmail = new JLabel("E-mail");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEmail.setBounds(15, 293, 159, 35);
		contentPane.add(lblEmail);
		
		textTelefone = new JFormattedTextField(new MaskFormatter (MASCARA_TELEFONE_FIXO));
		textTelefone.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textTelefone.setBounds(187, 132, 321, 35);
		contentPane.add(textTelefone);
		
		textEmail = new JTextField();
		textEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textEmail.setColumns(10);
		textEmail.setBounds(187, 293, 321, 35);
		contentPane.add(textEmail);
		
		lblCelular = new JLabel("Celular");
		lblCelular.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCelular.setBounds(15, 207, 159, 35);
		contentPane.add(lblCelular);
		
		textCelular = new JFormattedTextField(new MaskFormatter (MASCARA_TELEFONE_CELULAR));
		textCelular.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textCelular.setBounds(187, 207, 321, 35);
		contentPane.add(textCelular);
	}
				
	protected void limparTela() {
		funcionario = new FuncionarioVO();
		textNome.setText("");
		textCpf.setText("");
		textTelefone.setText("");
		textCelular.setText("");
		textEmail.setText("");
	}

	private FuncionarioVO contruirFuncionario() {
		funcionario.setNome(textNome.getText());
		funcionario.setCpf(textCpf.getText());
		funcionario.setTelefone(textTelefone.getText());
		funcionario.setCelular(textCelular.getText());
		funcionario.setEmail(textEmail.getText());
			
		return funcionario;
	}

	
}
