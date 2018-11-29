package Clinica_Medica.View.Prontuario;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import Clinica_Medica.BO.ProntuarioBO;
import Clinica_Medica.Controller.ConsultaController;
import Clinica_Medica.Controller.PacienteController;
import Clinica_Medica.Controller.ProntuarioController;
import Clinica_Medica.VO.ConsultaVO;
import Clinica_Medica.VO.EspecialidadeVO;
import Clinica_Medica.VO.PacienteVO;
import Clinica_Medica.VO.ProntuarioVO;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.text.MaskFormatter;
import javax.swing.JTextArea;
import javax.swing.DropMode;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Panel;
import java.awt.SystemColor;

public class TelaCadastrarProntuario extends JPanel {

	private static final String MASCARA_CPF = "###.###.###-##";
	private JTextField txtNomePaciente;
	private JTextArea txtAreaRegistro;
	private JTextArea txtAreaMedicamentos;
	private JTextArea txtAreaExames;
	private ProntuarioVO prontuario = new ProntuarioVO();
	private ConsultaVO consulta = new ConsultaVO();
	private PacienteVO pacienteBuscado = new PacienteVO();
	private JTextField txtDataConsulta;
	private JTextField txtHorarioConsulta;
	private JTable tbConsultas;
	private JTextField txtIdConsulta;
	private JTable tbProntuarios;
	private JTextField txtIdProntuario;
	protected List<ConsultaVO> consultas;
	protected ConsultaVO consultaSelecionada;
	private JButton btnBuscarProntuarios;

	/**
	 * Create the panel.
	 */
	public TelaCadastrarProntuario() {
		setBackground(new Color(173, 216, 230));
		setLayout(null);

		JLabel lblDataConsulta = new JLabel("Data Consulta");
		lblDataConsulta.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDataConsulta.setBounds(21, 72, 126, 22);
		add(lblDataConsulta);

		JButton btnBuscar = new JButton("Buscar Consultas");
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				ConsultaController controladorConsultas = new ConsultaController();
				consultas = controladorConsultas.listarTodasConsultas();

				atualizarTabelaConsultas(consultas);
				btnBuscarProntuarios.setEnabled(true);

			}
		});
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnBuscar.setBounds(1120, 39, 219, 39);
		add(btnBuscar);

		JSeparator separator = new JSeparator();
		separator.setBounds(21, 164, 696, 8);
		add(separator);

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
		btnSair.setBounds(1535, 482, 114, 39);
		add(btnSair);

		JLabel lblMedicamentos = new JLabel("Medicamentos");
		lblMedicamentos.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMedicamentos.setBounds(21, 207, 126, 22);
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
		lblNomePaciente.setBounds(21, 24, 126, 22);
		add(lblNomePaciente);

		txtNomePaciente = new JTextField();
		txtNomePaciente.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtNomePaciente.setColumns(10);
		txtNomePaciente.setBounds(157, 19, 552, 32);
		add(txtNomePaciente);

		JButton btnLimparTela = new JButton("Limpar Tela");
		btnLimparTela.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				limparTela();

			}
		});
		btnLimparTela.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnLimparTela.setBounds(19, 482, 140, 39);
		add(btnLimparTela);

		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				int codigoProntuario = 0;
				prontuario.setCodigoProntuario(Integer.parseInt(txtIdProntuario.getText()));

				ProntuarioController controlador = new ProntuarioController();
				ProntuarioVO prontuario = construirProntuario();
				String mensagem = controlador.atualizarProntuario(prontuario, prontuario.getCodigoProntuario());
				JOptionPane.showMessageDialog(null, mensagem);
				limparTela();
				limparTabelaConsultas();
				limparTabelaProntuarios();

			}
		});
		btnAlterar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAlterar.setBounds(286, 482, 140, 39);
		add(btnAlterar);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(157, 256, 2, 2);
		add(scrollPane_1);

		JLabel lblHoraConsulta = new JLabel("Horario Consulta");
		lblHoraConsulta.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblHoraConsulta.setBounds(416, 67, 150, 32);
		add(lblHoraConsulta);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				ProntuarioController controlador = new ProntuarioController();
				ProntuarioVO prontuario = construirProntuario();

				String mensagem = controlador.salvar(prontuario);
				JOptionPane.showMessageDialog(null, mensagem);
				limparTela();
				limparTabelaConsultas();
				limparTabelaProntuarios();
			}
		});
		btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnCadastrar.setBounds(566, 482, 150, 39);
		add(btnCadastrar);

		txtDataConsulta = new JTextField();
		txtDataConsulta.setEditable(false);
		txtDataConsulta.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtDataConsulta.setBounds(157, 67, 150, 32);
		add(txtDataConsulta);
		txtDataConsulta.setColumns(10);

		txtHorarioConsulta = new JTextField();
		txtHorarioConsulta.setEditable(false);
		txtHorarioConsulta.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtHorarioConsulta.setBounds(576, 62, 135, 32);
		add(txtHorarioConsulta);
		txtHorarioConsulta.setColumns(10);
		txtIdConsulta = new JTextField();
		txtIdConsulta.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtIdConsulta.setEditable(false);
		txtIdConsulta.setBounds(157, 121, 86, 32);
		add(txtIdConsulta);
		txtIdConsulta.setColumns(10);

		JLabel lblIdConsulta = new JLabel("ID Consulta");
		lblIdConsulta.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblIdConsulta.setBounds(21, 122, 126, 22);
		add(lblIdConsulta);

		JLabel lblIdProntuario = new JLabel("ID Prontuario");
		lblIdProntuario.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblIdProntuario.setBounds(273, 124, 114, 24);
		add(lblIdProntuario);

		txtIdProntuario = new JTextField();
		txtIdProntuario.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtIdProntuario.setEditable(false);
		txtIdProntuario.setBounds(392, 116, 86, 32);
		add(txtIdProntuario);
		txtIdProntuario.setColumns(10);

		JLabel lblConsultas = new JLabel("Consultas");
		lblConsultas.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblConsultas.setBounds(793, 79, 107, 14);
		add(lblConsultas);

		JLabel lblPeriodicos = new JLabel("Prontuarios");
		lblPeriodicos.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPeriodicos.setBounds(793, 312, 94, 14);
		add(lblPeriodicos);

		Panel panel = new Panel();
		panel.setBackground(SystemColor.menu);
		panel.setBounds(755, 19, 4, 498);
		add(panel);

		btnBuscarProntuarios = new JButton("Buscar Prontuarios");
		btnBuscarProntuarios.setEnabled(false);
		btnBuscarProntuarios.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ProntuarioController controladorProntuarios = new ProntuarioController();
				List<ProntuarioVO> prontuarios = controladorProntuarios.listarProntuariosDoPaciente(consultaSelecionada);

				if (prontuarios.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Paciente sem prontuário cadastrado!");
				} else {
					atualizarTabelaProntuarios(prontuarios);
				}
			}
		});
		btnBuscarProntuarios.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnBuscarProntuarios.setBounds(1120, 278, 219, 39);

		add(btnBuscarProntuarios);
				
				JScrollPane scrollPane_3 = new JScrollPane();
				scrollPane_3.setBounds(157, 185, 558, 44);
				add(scrollPane_3);
		
				txtAreaMedicamentos = new JTextArea();
				scrollPane_3.setViewportView(txtAreaMedicamentos);
				txtAreaMedicamentos.setFont(new Font("Dialog", Font.PLAIN, 16));
						
						JScrollPane scrollPane_2 = new JScrollPane();
						scrollPane_2.setBounds(157, 256, 558, 52);
						add(scrollPane_2);
				
						txtAreaExames = new JTextArea();
						scrollPane_2.setViewportView(txtAreaExames);
						txtAreaExames.setFont(new Font("Dialog", Font.PLAIN, 16));
								
								JScrollPane scrollPane = new JScrollPane();
								scrollPane.setBounds(157, 322, 558, 124);
								add(scrollPane);
						
								txtAreaRegistro = new JTextArea();
								scrollPane.setViewportView(txtAreaRegistro);
								txtAreaRegistro.setFont(new Font("Dialog", Font.PLAIN, 16));
										
										JScrollPane scrollPane_4 = new JScrollPane();
										scrollPane_4.setBounds(793, 106, 854, 138);
										add(scrollPane_4);
								
										tbConsultas = new JTable();
										scrollPane_4.setViewportView(tbConsultas);
										tbConsultas.addMouseListener(new MouseAdapter() {
											@Override
											public void mouseClicked(MouseEvent e) {

												int linhaSelecionada = tbConsultas.getSelectedRow();
												consultaSelecionada = consultas.get(linhaSelecionada - 1);

												txtIdConsulta.setText(tbConsultas.getValueAt(linhaSelecionada, 0) + "");
												txtNomePaciente.setText((String) tbConsultas.getValueAt(linhaSelecionada, 1));

												Date dataConsulta = (Date) tbConsultas.getValueAt(linhaSelecionada, 2);
												SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
												String dataConsultaFormatada = sdf.format(dataConsulta);
												txtDataConsulta.setText(dataConsultaFormatada);
												txtHorarioConsulta.setText((String) tbConsultas.getValueAt(linhaSelecionada, 3));

											}
										});
										tbConsultas.setFont(new Font("Tahoma", Font.PLAIN, 16));
										tbConsultas.setModel(new DefaultTableModel(
												new Object[][] { { "ID Consulta", "Paciente", "Data Consulta", "Horario Consulta" }, },
												new String[] { "ID Consulta", "Paciente", "Data Consulta", "Horario Consulta" }));
												
												JScrollPane scrollPane_5 = new JScrollPane();
												scrollPane_5.setBounds(795, 327, 854, 144);
												add(scrollPane_5);
										
												tbProntuarios = new JTable();
												scrollPane_5.setViewportView(tbProntuarios);
												tbProntuarios.addMouseListener(new MouseAdapter() {
													@Override
													public void mouseClicked(MouseEvent arg0) {

														int selecionado = tbProntuarios.getSelectedRow();

														txtIdProntuario.setText(tbProntuarios.getValueAt(selecionado, 0) + "");
														txtAreaMedicamentos.setText((String) tbProntuarios.getValueAt(selecionado, 3));
														txtAreaExames.setText((String) tbProntuarios.getValueAt(selecionado, 4));
														txtAreaRegistro.setText((String) tbProntuarios.getValueAt(selecionado, 5));

													}
												});
												tbProntuarios.setFont(new Font("Tahoma", Font.PLAIN, 16));
												tbProntuarios.setModel(new DefaultTableModel(
														new Object[][] { { "ID Prontuario", "Paciente", "Medicamentos", "Exames", "Registro" }, },
														new String[] { "ID Prontuario", "Paciente", "Medicamentos", "Exames", "Registro" }));

		String[] horarios = { "--- Selecione ---", "08:00", "08:30", "09:00", "09:30", "10:00", "10:30", "11:00",
				"11:30", "12:00", "12:30", "13:00", "13:30", "14:00", "14:30", "15:00", "15:30", "16:00", "16:30",
				"17:00", "17:30", "18:00" };

	}

	protected ProntuarioVO construirProntuario() {

		consulta.setCodigoConsulta(Integer.parseInt(txtIdConsulta.getText()));
		prontuario.setConsulta(consulta);
		prontuario.setMedicamento(txtAreaMedicamentos.getText());
		prontuario.setExame(txtAreaExames.getText());
		prontuario.setRegistro(txtAreaRegistro.getText());

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");

		Date dataConsulta;
		try {
			dataConsulta = sdf.parse(txtDataConsulta.getText());

			prontuario.getConsulta().setDataConsulta(dataConsulta);

			prontuario.getConsulta().setHorarioConsulta(txtHorarioConsulta.getText());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return prontuario;

	}

	protected void limparTela() {

		txtAreaMedicamentos.setText("");
		txtNomePaciente.setText("");
		txtAreaExames.setText("");
		txtAreaRegistro.setText("");
		txtDataConsulta.setText("");
		txtHorarioConsulta.setText("");
		txtIdConsulta.setText("");
		txtIdProntuario.setText("");
		txtNomePaciente.setText("");
	}

	protected PacienteVO buscarPaciente() {

		txtNomePaciente.setText(pacienteBuscado.getNomePaciente());

		return pacienteBuscado;
	}

	private void limparTabelaConsultas() {
		int linhas = 0;
		int colunas = 0;
		String zer = null;

		for (linhas = 0; linhas <= tbConsultas.getRowCount() - 1; linhas++) {
			for (colunas = 0; colunas <= tbConsultas.getColumnCount() - 1; colunas++) {
				tbConsultas.setValueAt(zer, linhas, colunas);
			}
		}
	}

	private void limparTabelaProntuarios() {
		int linhas = 0;
		int colunas = 0;
		String zer = null;

		for (linhas = 0; linhas <= tbProntuarios.getRowCount() - 1; linhas++) {
			for (colunas = 0; colunas <= tbProntuarios.getColumnCount() - 1; colunas++) {
				tbProntuarios.setValueAt(zer, linhas, colunas);
			}
		}
	}

	private void atualizarTabelaConsultas(List<ConsultaVO> consultas) {
		tbConsultas.setModel(new DefaultTableModel(
				new Object[][] { { "ID Consulta", "Paciente", "Data Consulta", "Horario Consulta" }, },
				new String[] { "ID Consulta", "Paciente", "Data Consulta", "Horario Consulta" }));

		DefaultTableModel modelo = (DefaultTableModel) tbConsultas.getModel();

		for (ConsultaVO consulta : consultas) {
			// Crio uma nova linha na tabela
			// Preencher a linha com os atributos do produto
			// na ORDEM do cabeçalho da tabela
			Object[] novaLinha = new Object[] { consulta.getCodigoConsulta(),
					consulta.getPacienteVO().getNomePaciente(), consulta.getDataConsulta(),
					consulta.getHorarioConsulta(), consulta.getPacienteVO().getCodigoPaciente(),

			};
			modelo.addRow(novaLinha);
		}
	}

	private void atualizarTabelaProntuarios(List<ProntuarioVO> prontuarios) {
		tbProntuarios.setModel(new DefaultTableModel(
				new Object[][] { { "ID Prontuario", "Medico", "Paciente", "Medicamentos", "Exames", "Registro" }, },
				new String[] { "ID Prontuario", "Medico", "Paciente", "Medicamentos", "Exames", "Registro" }));

		DefaultTableModel modelo = (DefaultTableModel) tbProntuarios.getModel();

		for (ProntuarioVO prontuario : prontuarios) {
			// Crio uma nova linha na tabela
			// Preencher a linha com os atributos do produto
			// na ORDEM do cabeçalho da tabela
			Object[] novaLinha = new Object[] { prontuario.getCodigoProntuario(),
					prontuario.getConsulta().getEspecializacaoVO().getMedicoVO().getNomeMedico(),
					prontuario.getConsulta().getPacienteVO().getNomePaciente(), prontuario.getMedicamento(),
					prontuario.getExame(), prontuario.getRegistro() };
			modelo.addRow(novaLinha);
		}
	}
}
