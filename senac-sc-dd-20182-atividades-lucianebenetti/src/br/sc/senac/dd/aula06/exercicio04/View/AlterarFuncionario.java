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

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

import java.awt.Font;
import java.text.ParseException;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class AlterarFuncionario extends JFrame implements MouseListener {

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
	private FuncionarioVO funcionarioVO = new FuncionarioVO();
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
	public AlterarFuncionario() throws ParseException {
		setTitle("Atualizatr Funcion\u00E1rio");
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
		
		textCpf = new JFormattedTextField(new MaskFormatter ("###.###.###-##"));
		textCpf.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textCpf.setColumns(10);
		textCpf.setBounds(130, 122, 363, 29);
		contentPane.add(textCpf);
		
		lblTelefone = new JLabel("Telefone");
		lblTelefone.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTelefone.setBounds(10, 169, 95, 38);
		contentPane.add(lblTelefone);
		
		textTelefone = new JFormattedTextField(new MaskFormatter ("(##) #####-####"));
		textTelefone.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textTelefone.setColumns(10);
		textTelefone.setBounds(130, 174, 363, 29);
		contentPane.add(textTelefone);
		
		lblCelular = new JLabel("Celular");
		lblCelular.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCelular.setBounds(10, 229, 76, 38);
		contentPane.add(lblCelular);
		
		textCelular = new JFormattedTextField(new MaskFormatter ("(##) #####-####"));
		textCelular.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textCelular.setColumns(10);
		textCelular.setBounds(130, 234, 363, 29);
		contentPane.add(textCelular);
		
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
		
		textBuscaCpf = new JFormattedTextField(new MaskFormatter ("###.###.###-##"));
		textBuscaCpf.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textBuscaCpf.setColumns(10);
		textBuscaCpf.setBounds(130, 20, 228, 29);
		contentPane.add(textBuscaCpf);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addMouseListener(this);
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnBuscar.setBounds(381, 11, 112, 38);
		contentPane.add(btnBuscar);
		
		btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addMouseListener(this);
		btnAtualizar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAtualizar.setBounds(63, 341, 138, 38);
		contentPane.add(btnAtualizar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addMouseListener(this);
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCancelar.setBounds(341, 341, 152, 38);
		contentPane.add(btnCancelar);
	}
	
	public void mouseClicked(MouseEvent arg0) {
			if (arg0.getSource() == btnCancelar) {
				do_btnCancelar_mouseClicked(arg0);
				System.exit(0);
			}
			
			if (arg0.getSource() == btnBuscar) {
				do_btnBuscar_mouseClicked(arg0);
			
			funcionarioVO = bo.buscarFuncionarioPorCPF(textBuscaCpf.getText());
			
			if(funcionarioVO != null) {
					textNome.setText(funcionarioVO.getNome());
					textCpf.setText(funcionarioVO.getCpf());
					textTelefone.setText(funcionarioVO.getTelefone());
					textCelular.setText(funcionarioVO.getCelular());
					textEmail.setText(funcionarioVO.getEmail());
					
				}else {
					JOptionPane.showMessageDialog(null, "Funcionário não encontrado.");
				}
			}
			
			if (arg0.getSource() == btnAtualizar) {
				do_btnAtualizar_mouseClicked(arg0);
				
				FuncionarioController controlador = new FuncionarioController();
				FuncionarioVO funcionarioVO = constriurFuncionario();
				controlador.atualizar(funcionarioVO);
				
				limparTela();			
				
			}
		}

	protected void limparTela() {
		funcionarioVO = new FuncionarioVO();
		textBuscaCpf.setText("");
		textNome.setText("");
		textCpf.setText("");
		textTelefone.setText("");
		textCelular.setText("");
		textEmail.setText("");
		
	}

	public FuncionarioVO constriurFuncionario() {
		funcionarioVO.setNome(textNome.getText());
		funcionarioVO.setCpf(textCpf.getText());
		funcionarioVO.setTelefone(textTelefone.getText());
		funcionarioVO.setCelular(textCelular.getText());
		funcionarioVO.setEmail(textEmail.getText());
		
		return funcionarioVO;
	}

	public void mouseEntered(MouseEvent arg0) {
	}
	public void mouseExited(MouseEvent arg0) {
	}
	public void mousePressed(MouseEvent arg0) {
	}
	public void mouseReleased(MouseEvent arg0) {
	}
	protected void do_btnBuscar_mouseClicked(MouseEvent arg0) {
	}
	protected void do_btnAtualizar_mouseClicked(MouseEvent arg0) {
	}
	protected void do_btnCancelar_mouseClicked(MouseEvent arg0) {
	}
}
