package Clinica_Medica.View.Consulta;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.Caret;
import javax.swing.text.MaskFormatter;

import com.toedter.calendar.JDateChooser;

import Clinica_Medica.Controller.ConsultaController;
import Clinica_Medica.Controller.ConvenioController;
import Clinica_Medica.Controller.EspecializacaoController;
import Clinica_Medica.Controller.MedicoController;
import Clinica_Medica.Controller.PacienteController;
import Clinica_Medica.Controller.ProntuarioController;
import Clinica_Medica.VO.ConsultaVO;
import Clinica_Medica.VO.ConvenioVO;
import Clinica_Medica.VO.EspecialidadeVO;
import Clinica_Medica.VO.EspecializacaoVO;
import Clinica_Medica.VO.MedicoVO;
import Clinica_Medica.VO.PacienteVO;
import Clinica_Medica.VO.ProntuarioVO;

import java.awt.Color;

public class TelaExcluirConsulta extends JPanel {

	private static final String MASCARA_CPF = "###.###.###-##";
	private JTextField txtIdPaciente;
	private JTextField txtIdConvenio;
	private JTextField txtNomePaciente;
	private ConsultaVO consulta = new ConsultaVO();
	private ConvenioVO convenio = new ConvenioVO();
	private MedicoVO medico = new MedicoVO();
	private PacienteVO paciente = new PacienteVO();
	private EspecialidadeVO especialidade = new EspecialidadeVO();
	private EspecializacaoVO especializacao = new EspecializacaoVO();
	private PacienteVO pacienteBuscado = new PacienteVO();
	private JTextField txtIdEspecializacao;
	private JTextField txtNomeMedico;
	private JTextField txtEspecialidade;
	private JTextField txtConvenio;
	private JTable tbConsultas;
	private JTextField txtHorario;
	private JTextField txtData;
	private JTextField txtIdConsulta;

	/**
	 * Create the panel.
	 */
	public TelaExcluirConsulta() {
		setBackground(new Color(173, 216, 230));
		setLayout(null);

		JLabel lblNome = new JLabel("Nome Paciente");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNome.setBounds(27, 71, 142, 23);
		add(lblNome);

		JLabel lblConvenio = new JLabel("Convenio");
		lblConvenio.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblConvenio.setBounds(27, 117, 107, 23);
		add(lblConvenio);

		JLabel lblEspecialidade = new JLabel("Especialidade");
		lblEspecialidade.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEspecialidade.setBounds(27, 221, 128, 31);
		add(lblEspecialidade);

		JLabel lblNomeMdico = new JLabel("Nome M\u00E9dico");
		lblNomeMdico.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNomeMdico.setBounds(26, 173, 130, 23);
		add(lblNomeMdico);

		JLabel lblData = new JLabel("Data da Consulta");
		lblData.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblData.setBounds(28, 286, 152, 31);
		add(lblData);

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
		btnSair.setBounds(1230, 435, 107, 35);
		add(btnSair);

		JLabel lblDataRealizao = new JLabel("Hora da Consulta");
		lblDataRealizao.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDataRealizao.setBounds(28, 342, 162, 23);
		add(lblDataRealizao);

		txtIdPaciente = new JTextField();
		txtIdPaciente.setEditable(false);
		txtIdPaciente.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtIdPaciente.setBounds(555, 68, 52, 27);
		add(txtIdPaciente);
		txtIdPaciente.setColumns(10);

		txtIdConvenio = new JTextField();
		txtIdConvenio.setEditable(false);
		txtIdConvenio.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtIdConvenio.setColumns(10);
		txtIdConvenio.setBounds(483, 114, 52, 27);
		add(txtIdConvenio);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				ConsultaController controlador = new ConsultaController();
				ConsultaVO consultaExcluida = construirConsulta();
				controlador.excluirConsulta(consultaExcluida);
				JOptionPane.showMessageDialog(null, "Consulta excluída!");

				limparTela();
			}
		});
		btnExcluir.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnExcluir.setBounds(358, 435, 115, 35);
		add(btnExcluir);

		txtNomePaciente = new JTextField();
		txtNomePaciente.setEditable(false);
		txtNomePaciente.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtNomePaciente.setBounds(166, 69, 379, 31);
		add(txtNomePaciente);
		txtNomePaciente.setColumns(10);

		String[] convenios = { "----------- Selecione -----------" };

		String[] esp = { "----------- Selecione -----------" };

		String[] med = { "----------- Selecione -----------" };

		JButton btnLimparTela = new JButton("Limpar Tela");
		btnLimparTela.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				limparTela();
			}
		});
		btnLimparTela.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnLimparTela.setBounds(27, 435, 142, 35);
		add(btnLimparTela);

		String[] horarios = { "--- Selecione ---", "08:00:00", "08:30:00", "09:00:00", "09:30:00", "10:00:00",
				"10:30:00", "11:00:00", "11:30:00", "12:00:00", "12:30:00", "13:00:00", "13:30:00", "14:00:00",
				"14:30:00", "15:00:00", "15:30:00", "16:00", "16:30:00", "17:00:00", "17:30:00", "18:00:00" };

		txtIdEspecializacao = new JTextField();
		txtIdEspecializacao.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtIdEspecializacao.setEditable(false);
		txtIdEspecializacao.setBounds(484, 196, 51, 30);
		add(txtIdEspecializacao);
		txtIdEspecializacao.setColumns(10);

		txtNomeMedico = new JTextField();
		txtNomeMedico.setEditable(false);
		txtNomeMedico.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtNomeMedico.setBounds(166, 170, 307, 31);
		add(txtNomeMedico);
		txtNomeMedico.setColumns(10);

		txtEspecialidade = new JTextField();
		txtEspecialidade.setEditable(false);
		txtEspecialidade.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtEspecialidade.setBounds(165, 221, 308, 31);
		add(txtEspecialidade);
		txtEspecialidade.setColumns(10);

		txtConvenio = new JTextField();
		txtConvenio.setEditable(false);
		txtConvenio.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtConvenio.setBounds(166, 117, 307, 28);
		add(txtConvenio);
		txtConvenio.setColumns(10);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(740, 117, 597, 214);
		add(scrollPane_1);

		tbConsultas = new JTable();
		tbConsultas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				int selecionado = tbConsultas.getSelectedRow();

				txtIdConsulta.setText(tbConsultas.getValueAt(selecionado, 0) + "");
				txtNomePaciente.setText((String) tbConsultas.getValueAt(selecionado, 1));
				txtConvenio.setText((String) tbConsultas.getValueAt(selecionado, 2));
				txtNomeMedico.setText((String) tbConsultas.getValueAt(selecionado, 3));
				txtEspecialidade.setText((String) tbConsultas.getValueAt(selecionado, 4));
				
				Date dataConsulta = (Date) tbConsultas.getValueAt(selecionado, 5);
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
				
				String dataConsultaFormatada = sdf.format(dataConsulta);
				
				txtData.setText(dataConsultaFormatada);
				txtHorario.setText((String) tbConsultas.getValueAt(selecionado, 6));

					}
		});
		tbConsultas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tbConsultas.setModel(new DefaultTableModel(
				new Object[][] { { "ID", "Paciente", "Convenio", "Medico", "Especialidade", "Data", "Horario" }, },
				new String[] { "ID", "Paciente", "Convenio", "Medico", "Especialidade", "Data", "Horario" }));
		scrollPane_1.setViewportView(tbConsultas);

		JButton btnBuscarConsultas = new JButton("Buscar Consultas");
		btnBuscarConsultas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				ConsultaController controlador = new ConsultaController();
				ArrayList<ConsultaVO> consultas = (ArrayList<ConsultaVO>) controlador.listarTodasConsultas();

				DefaultTableModel tabela = (DefaultTableModel) tbConsultas.getModel();
				for (ConsultaVO consulta : consultas) {
					tabela.addRow(new Object[] { consulta.getCodigoConsulta(),
							consulta.getPacienteVO().getNomePaciente(), consulta.getConvenioVO().getNomeConvenio(),
							consulta.getEspecializacaoVO().getMedicoVO().getNomeMedico(),
							consulta.getEspecializacaoVO().getEspecialidadeVO().getNomeEspecialidade(),
							consulta.getDataConsulta(), consulta.getHorarioConsulta() });
				}
			}
		});
		btnBuscarConsultas.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnBuscarConsultas.setBounds(926, 67, 201, 31);
		add(btnBuscarConsultas);

		txtHorario = new JTextField();
		txtHorario.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtHorario.setEditable(false);
		txtHorario.setBounds(190, 331, 179, 35);
		add(txtHorario);
		txtHorario.setColumns(10);

		txtData = new JTextField();
		txtData.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtData.setEditable(false);
		txtData.setBounds(190, 286, 179, 34);
		add(txtData);
		txtData.setColumns(10);

		JLabel lblIdConsulta = new JLabel("ID Consulta");
		lblIdConsulta.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblIdConsulta.setBounds(27, 34, 128, 20);
		add(lblIdConsulta);

		txtIdConsulta = new JTextField();
		txtIdConsulta.setEditable(false);
		txtIdConsulta.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtIdConsulta.setBounds(163, 29, 86, 31);
		add(txtIdConsulta);
		txtIdConsulta.setColumns(10);

	}

	protected PacienteVO buscarPaciente() {

		txtNomePaciente.setText(pacienteBuscado.getNomePaciente());
		txtIdPaciente.setText(pacienteBuscado.getCodigoPaciente() + "");

		return pacienteBuscado;
	}

	protected void limparTela() {

		txtIdConvenio.setText("");
		txtIdPaciente.setText("");
		txtNomePaciente.setText("");
		txtNomeMedico.setText("");
		txtEspecialidade.setText("");
		txtConvenio.setText("");
		txtData.setText("");
		txtHorario.setText("");

		limparTabelaConsultas();
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

	protected ConsultaVO construirConsulta() {

		consulta.setCodigoConsulta(Integer.parseInt(txtIdConsulta.getText()));

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
		
		Date dataConsulta;
		try {
			dataConsulta = sdf.parse(txtData.getText());
			consulta.setDataConsulta(dataConsulta);
			consulta.setHorarioConsulta(txtHorario.getText());
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return consulta;
	}
}