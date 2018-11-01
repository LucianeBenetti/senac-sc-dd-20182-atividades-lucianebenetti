package Clinica_Medica.View.Prontuario;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import Clinica_Medica.Controller.PacienteController;
import Clinica_Medica.VO.PacienteVO;
import Clinica_Medica.VO.ProntuarioVO;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.text.MaskFormatter;
import javax.swing.JTextArea;
import javax.swing.DropMode;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaCadastrarProntuario extends JPanel {
	
	private static final String MASCARA_CPF = "###.###.###-##";
	private JTextField txtBuscarCPF;
	private JTextField txtNomePaciente;
	private JTextArea txtAreaRegistro;
	private JDateChooser dateChooserDataConsulta;
	private JTextArea txtAreaMedicamentos;
	private JTextArea txtAreaExames;
	private ProntuarioVO prontuario = new ProntuarioVO();
	private PacienteVO pacienteBuscado = new PacienteVO();

	/**
	 * Create the panel.
	 */
	public TelaCadastrarProntuario() {
		setBackground(new Color(173, 216, 230));
		setLayout(null);

		JLabel lblBuscarNomePaciente = new JLabel("CPF Paciente");
		lblBuscarNomePaciente.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBuscarNomePaciente.setBounds(21, 24, 126, 22);
		add(lblBuscarNomePaciente);

		JLabel lblDataConsulta = new JLabel("Data Consulta");
		lblDataConsulta.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDataConsulta.setBounds(21, 57, 126, 22);
		add(lblDataConsulta);

		try {
			txtBuscarCPF = new JFormattedTextField(new MaskFormatter(MASCARA_CPF));
			txtBuscarCPF.setFont(new Font("Tahoma", Font.PLAIN, 18));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		txtBuscarCPF.setBounds(157, 16, 377, 32);
		add(txtBuscarCPF);
		txtBuscarCPF.setColumns(10);

		dateChooserDataConsulta = new JDateChooser();
		dateChooserDataConsulta.setBounds(157, 57, 87, 32);
		add(dateChooserDataConsulta);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				PacienteController dao = new PacienteController();
				pacienteBuscado = dao.buscarPacientePorCpf(txtBuscarCPF.getText());
				
				if (pacienteBuscado != null) {
					pacienteBuscado = buscarPaciente();
				} else {
					JOptionPane.showMessageDialog(null, "Paciente não encontrado.");
				}
			}
		});
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnBuscar.setBounds(603, 16, 89, 39);
		add(btnBuscar);

		JSeparator separator = new JSeparator();
		separator.setBounds(21, 121, 696, 8);
		add(separator);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnCadastrar.setBounds(398, 463, 150, 39);
		add(btnCadastrar);

		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int opcao;
				Object[] BtSair = { "Sim", "Não" };

				opcao = JOptionPane.showOptionDialog(null, "Deseja sair desta operação?", "Fechar",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, BtSair, BtSair[0]);
				if (opcao == JOptionPane.YES_OPTION) {
					setVisible(false);
				}
			}
		});
		btnSair.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSair.setBounds(603, 463, 114, 39);
		add(btnSair);

		JLabel lblMedicamentos = new JLabel("Medicamentos");
		lblMedicamentos.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMedicamentos.setBounds(21, 218, 126, 22);
		add(lblMedicamentos);

		JLabel lblExames = new JLabel("Exames");
		lblExames.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblExames.setBounds(21, 286, 94, 22);
		add(lblExames);

		JLabel lblRegistro = new JLabel("Registro");
		lblRegistro.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblRegistro.setBounds(21, 349, 94, 22);
		add(lblRegistro);

		JLabel lblNomePaciente = new JLabel("Nome Paciente");
		lblNomePaciente.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNomePaciente.setBounds(21, 159, 126, 22);
		add(lblNomePaciente);

		txtNomePaciente = new JTextField();
		txtNomePaciente.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtNomePaciente.setColumns(10);
		txtNomePaciente.setBounds(157, 151, 377, 32);
		add(txtNomePaciente);

		JButton btnLimparTela = new JButton("Limpar Tela");
		btnLimparTela.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				limparTela();

			}
		});
		btnLimparTela.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnLimparTela.setBounds(10, 463, 140, 39);
		add(btnLimparTela);

		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAlterar.setBounds(199, 463, 140, 39);
		add(btnAlterar);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(157, 321, 560, 126);
		add(scrollPane);

		txtAreaRegistro = new JTextArea();
		scrollPane.setViewportView(txtAreaRegistro);
		txtAreaRegistro.setFont(new Font("Dialog", Font.PLAIN, 16));

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(157, 256, 2, 2);
		add(scrollPane_1);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(157, 256, 560, 54);
		add(scrollPane_2);

		txtAreaExames = new JTextArea();
		txtAreaExames.setFont(new Font("Dialog", Font.PLAIN, 16));
		scrollPane_2.setViewportView(txtAreaExames);

		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(157, 194, 560, 46);
		add(scrollPane_3);

		txtAreaMedicamentos = new JTextArea();
		scrollPane_3.setViewportView(txtAreaMedicamentos);
		txtAreaMedicamentos.setFont(new Font("Dialog", Font.PLAIN, 16));
		
		JLabel lblHoraConsulta = new JLabel("Hora Consulta");
		lblHoraConsulta.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblHoraConsulta.setBounds(278, 59, 126, 32);
		add(lblHoraConsulta);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(437, 57, 87, 32);
		add(dateChooser);

	}

	protected void limparTela() {
		txtAreaMedicamentos.setText("");
		txtBuscarCPF.setText("");
		txtNomePaciente.setText("");
		txtAreaExames.setText("");
		txtAreaRegistro.setText("");
		dateChooserDataConsulta.setDate(null);
	}
	protected PacienteVO buscarPaciente() {
	
		txtNomePaciente.setText(pacienteBuscado.getNomePaciente());
				
		return pacienteBuscado;
	}
}
