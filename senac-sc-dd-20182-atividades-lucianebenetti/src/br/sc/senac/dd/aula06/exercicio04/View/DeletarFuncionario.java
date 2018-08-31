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
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import java.awt.Font;
import java.text.ParseException;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class DeletarFuncionario extends JFrame implements MouseListener {

	private JPanel contentPane;
	private JLabel lblBuscaCpf;
	private JLabel lblCpf_1;
	private JLabel lblNome;
	private JButton btnExcluir;
	private JButton btnCancelar;
	private JButton btnBuscar;
	private JTextField textBuscaCpf;
	private JTextField textNome;
	private JTextField textCpf;
	private FuncionarioVO funcionarioVO = new FuncionarioVO();
	private FuncionarioBO bo = new FuncionarioBO();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeletarFuncionario frame = new DeletarFuncionario();
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
	public DeletarFuncionario() throws ParseException {
		setTitle("Excluir Funcionario");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 592, 352);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblBuscaCpf = new JLabel("CPF");
		lblBuscaCpf.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblBuscaCpf.setBounds(10, 11, 99, 49);
		contentPane.add(lblBuscaCpf);
		
		lblCpf_1 = new JLabel("CPF");
		lblCpf_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCpf_1.setBounds(10, 142, 99, 49);
		contentPane.add(lblCpf_1);
		
		lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNome.setBounds(10, 71, 99, 49);
		contentPane.add(lblNome);
		
		btnExcluir = new JButton("Excluir");
		btnExcluir.addMouseListener(this);
		btnExcluir.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnExcluir.setBounds(82, 217, 108, 45);
		contentPane.add(btnExcluir);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addMouseListener(this);
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCancelar.setBounds(338, 217, 131, 45);
		contentPane.add(btnCancelar);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addMouseListener(this);
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnBuscar.setBounds(439, 13, 99, 45);
		contentPane.add(btnBuscar);
		
		textBuscaCpf = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		textBuscaCpf.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textBuscaCpf.setBounds(148, 17, 281, 37);
		contentPane.add(textBuscaCpf);
		textBuscaCpf.setColumns(10);
		
		textNome = new JTextField();
		textNome.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textNome.setBounds(148, 79, 281, 37);
		contentPane.add(textNome);
		textNome.setColumns(10);
		
		textCpf = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		textCpf.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textCpf.setBounds(148, 142, 281, 34);
		contentPane.add(textCpf);
		textCpf.setColumns(10);
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
							
				}else {
					JOptionPane.showMessageDialog(null, "Funcionário não encontrado.");
				}
			}
		
			if (arg0.getSource() == btnExcluir) {
				do_btnExcluir_mouseClicked(arg0);

				FuncionarioController controlador = new FuncionarioController();
				controlador.deletar(funcionarioVO);
				limparTela();
				}
			}
	
		private void limparTela() {
			funcionarioVO = new FuncionarioVO();
			textBuscaCpf.setText("");
			textNome.setText("");
			textCpf.setText("");
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
	protected void do_btnCancelar_mouseClicked(MouseEvent arg0) {
	}
	protected void do_btnExcluir_mouseClicked(MouseEvent arg0) {
	}
}
