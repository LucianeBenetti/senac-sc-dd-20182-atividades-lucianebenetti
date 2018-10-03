package br.sc.senac.dd.aula06.exercicio04.View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

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

public class AlterarFuncionario extends JInternalFrame {

	private static final String MASCARA_TELEFONE_FIXO = "(##) ####-####";
	private static final String MASCARA_TELEFONE_CELULAR ="(##) #####-####";
	private static final String MASCARA_CPF = "###.###.###-##";
	private JPanel contentPane;
	private JLabel lblNome;
	private JTextField textNome;
	private JLabel lblCpf;
	private JTextField textCpf;
	private JLabel lblTelefone;
	private JTextField textTelefone;
	private JLabel lblCelular;
	private JTextField textCelular;
	private JLabel lblEmail;
	private JTextField textEmail;
	private JLabel lblBuscaCpf;
	private JTextField textBuscaCpf;
	private JButton btnBuscar;
	private JButton btnAtualizar;
	private JButton btnCancelar;
	private FuncionarioVO funcionarioDaTela = new FuncionarioVO();
	private FuncionarioVO funcionarioConsultado = new FuncionarioVO();
	private FuncionarioBO bo = new FuncionarioBO();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlterarFuncionario frame = new AlterarFuncionario();
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
	public AlterarFuncionario(){
		setClosable(true);
		setTitle("Atualizar Funcion\u00E1rio");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 560, 459);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNome.setBounds(10, 68, 76, 38);
		contentPane.add(lblNome);
		
		textNome = new JTextField();
		textNome.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textNome.setBounds(130, 73, 363, 29);
		contentPane.add(textNome);
		textNome.setColumns(10);
		
		lblCpf = new JLabel("CPF");
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCpf.setBounds(10, 117, 76, 38);
		contentPane.add(lblCpf);
		
		try {
		textCpf = new JFormattedTextField(new MaskFormatter (MASCARA_CPF));
		textCpf.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textCpf.setColumns(10);
		textCpf.setBounds(130, 122, 363, 29);
		contentPane.add(textCpf);
		}catch(ParseException pEx) {
			//TODO tratar			
		}
		
		lblTelefone = new JLabel("Telefone");
		lblTelefone.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTelefone.setBounds(10, 169, 95, 38);
		contentPane.add(lblTelefone);
		
		try {
		textTelefone = new JFormattedTextField(new MaskFormatter (MASCARA_TELEFONE_FIXO));
		textTelefone.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textTelefone.setColumns(10);
		textTelefone.setBounds(130, 174, 363, 29);
		contentPane.add(textTelefone);
		}catch(ParseException pEx) {
			//TODO tratar			
		}
		
		lblCelular = new JLabel("Celular");
		lblCelular.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCelular.setBounds(10, 229, 76, 38);
		contentPane.add(lblCelular);
		
		try {
		textCelular = new JFormattedTextField(new MaskFormatter (MASCARA_TELEFONE_CELULAR));
		textCelular.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textCelular.setColumns(10);
		textCelular.setBounds(130, 234, 363, 29);
		contentPane.add(textCelular);
		}catch(ParseException pEx) {
			//TODO tratar			
		}
		
		lblEmail = new JLabel("E-mail");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEmail.setBounds(10, 292, 76, 38);
		contentPane.add(lblEmail);
		
		textEmail = new JTextField();
		textEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textEmail.setColumns(10);
		textEmail.setBounds(130, 297, 363, 29);
		contentPane.add(textEmail);
		
		lblBuscaCpf = new JLabel("CPF");
		lblBuscaCpf.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblBuscaCpf.setBounds(10, 11, 76, 38);
		contentPane.add(lblBuscaCpf);
		
		try {
		textBuscaCpf = new JFormattedTextField(new MaskFormatter (MASCARA_CPF));
		textBuscaCpf.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textBuscaCpf.setColumns(10);
		textBuscaCpf.setBounds(130, 20, 228, 29);
		contentPane.add(textBuscaCpf);
		}catch(ParseException pEx) {
			//TODO tratar			
		}
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				funcionarioConsultado = bo.buscarFuncionarioPorCPF(textBuscaCpf.getText());
				
				if(funcionarioConsultado != null) {
					textNome.setText(funcionarioConsultado.getNome());
					textCpf.setText(funcionarioConsultado.getCpf());
					textTelefone.setText(funcionarioConsultado.getTelefone());
					textCelular.setText(funcionarioConsultado.getCelular());
					textEmail.setText(funcionarioConsultado.getEmail());
								
					}else {
						JOptionPane.showMessageDialog(null, "Funcionário não encontrado.");
					}
				}
		});
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnBuscar.setBounds(381, 11, 112, 38);
		contentPane.add(btnBuscar);
		
		btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				FuncionarioController controlador = new FuncionarioController();
				construirFuncionario();
				controlador.atualizar(funcionarioDaTela, funcionarioConsultado.getCpf());
		}

		});
		
		btnAtualizar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAtualizar.setBounds(63, 341, 138, 38);
		contentPane.add(btnAtualizar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				 System.exit(0);
		}

		});
		
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCancelar.setBounds(341, 341, 152, 38);
		contentPane.add(btnCancelar);
	}
	

	protected void limparTela() {
		funcionarioDaTela = new FuncionarioVO();
		funcionarioConsultado = new FuncionarioVO();

		textBuscaCpf.setText("");
		textNome.setText("");
		textCpf.setText("");
		textTelefone.setText("");
		textCelular.setText("");
		textEmail.setText("");
		
	}

	public void construirFuncionario() {
		funcionarioDaTela.setNome(textNome.getText());
		funcionarioDaTela.setCpf(textCpf.getText());
		funcionarioDaTela.setTelefone(textTelefone.getText());
		funcionarioDaTela.setCelular(textCelular.getText());
		funcionarioDaTela.setEmail(textEmail.getText());
	}

	
}
