package Clinica_Medica.View.Consulta;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;
import Clinica_Medica.Controller.ConsultaController;
import Clinica_Medica.Controller.ConvenioController;
import Clinica_Medica.Controller.EspecialidadeController;
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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Time;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class TelaCadastrarConsulta extends JPanel {
	private JComboBox cbConvenio;
	private JComboBox cbNomeMedico;
	private JComboBox cbEspecialidade;
	private JComboBox cbHorarioConsulta;
	private JTextField txtBuscarCPF;
	private JTextField txtIdPaciente;
	private JTextField txtIdConvenio;
	private JTextField txtNomePaciente;
	private JTextField txtIdMedico;
	private JDateChooser dateChooserDataConsulta;
	private ConsultaVO consulta = new ConsultaVO();
	private ConvenioVO convenio = new ConvenioVO();
	private MedicoVO medico = new MedicoVO();
	private EspecialidadeVO especialidade = new EspecialidadeVO();
	private ProntuarioVO prontuario = new ProntuarioVO();
	private static final String MASCARA_CPF = "###.###.###-##";
	PacienteVO pacienteBuscado = new PacienteVO();
	private JTextField txtIdProntuario;
	private JTextField txtIdEspecialidade;
	private JTextField txtIdEspecializacao;

	/**
	 * Create the panel.
	 */
	public TelaCadastrarConsulta() {
		setBackground(new Color(173, 216, 230));
		setLayout(null);

		JLabel lblBuscarCPFPaciente = new JLabel("CPF Paciente");
		lblBuscarCPFPaciente.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBuscarCPFPaciente.setBounds(26, 19, 142, 23);
		add(lblBuscarCPFPaciente);

		try {
			txtBuscarCPF = new JFormattedTextField(new MaskFormatter(MASCARA_CPF));
			txtBuscarCPF.setFont(new Font("Tahoma", Font.PLAIN, 18));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		txtBuscarCPF.setBounds(199, 15, 399, 27);
		add(txtBuscarCPF);
		txtBuscarCPF.setColumns(10);

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
		btnBuscar.setBounds(634, 15, 89, 31);
		add(btnBuscar);

		JSeparator separator = new JSeparator();
		separator.setBounds(26, 128, 697, 9);
		add(separator);

		JLabel lblNome = new JLabel("Nome Paciente");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNome.setBounds(27, 166, 142, 23);
		add(lblNome);

		JLabel lblIdPaciente = new JLabel("ID Paciente");
		lblIdPaciente.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblIdPaciente.setBounds(555, 166, 101, 23);
		add(lblIdPaciente);

		JLabel lblConvenio = new JLabel("Convenio");
		lblConvenio.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblConvenio.setBounds(27, 228, 107, 23);
		add(lblConvenio);

		JLabel lblIdConvenio = new JLabel("ID Convenio");
		lblIdConvenio.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblIdConvenio.setBounds(504, 228, 107, 23);
		add(lblIdConvenio);

		JLabel lblEspecialidade = new JLabel("Especialidade");
		lblEspecialidade.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEspecialidade.setBounds(27, 332, 128, 31);
		add(lblEspecialidade);

		JLabel lblNomeMdico = new JLabel("Nome M\u00E9dico");
		lblNomeMdico.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNomeMdico.setBounds(26, 284, 130, 23);
		add(lblNomeMdico);

		JLabel lblIdMedico = new JLabel("ID Medico");
		lblIdMedico.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblIdMedico.setBounds(504, 284, 95, 23);
		add(lblIdMedico);

		JLabel lblData = new JLabel("Data da Consulta");
		lblData.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblData.setBounds(26, 393, 152, 31);
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
		btnSair.setBounds(616, 486, 107, 35);
		add(btnSair);

		JLabel lblDataRealizao = new JLabel("Hora da Consulta");
		lblDataRealizao.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDataRealizao.setBounds(26, 449, 162, 23);
		add(lblDataRealizao);

		txtIdPaciente = new JTextField();
		txtIdPaciente.setEditable(false);
		txtIdPaciente.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtIdPaciente.setBounds(672, 166, 52, 31);
		add(txtIdPaciente);
		txtIdPaciente.setColumns(10);

		txtIdConvenio = new JTextField();
		txtIdConvenio.setEditable(false);
		txtIdConvenio.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtIdConvenio.setColumns(10);
		txtIdConvenio.setBounds(672, 229, 52, 27);
		add(txtIdConvenio);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				ConsultaController controlador = new ConsultaController();
				ConsultaVO consulta = construirConsulta();

				String mensagem = controlador.salvar(consulta);
				JOptionPane.showMessageDialog(null, mensagem);
				limparTela();
			}
		});
		btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnCadastrar.setBounds(429, 486, 115, 35);
		add(btnCadastrar);

		txtNomePaciente = new JTextField();
		txtNomePaciente.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtNomePaciente.setBounds(166, 163, 379, 26);
		add(txtNomePaciente);
		txtNomePaciente.setColumns(10);

		txtIdMedico = new JTextField();
		txtIdMedico.setEditable(false);
		txtIdMedico.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtIdMedico.setColumns(10);
		txtIdMedico.setBounds(672, 285, 52, 27);
		add(txtIdMedico);

		String[] convenios = { "----------- Selecione -----------" };
		cbConvenio = new JComboBox(convenios);
		cbConvenio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				preencherConvenio();
			}
		});
		cbConvenio.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cbConvenio.setBounds(165, 224, 274, 30);
		add(cbConvenio);

		String[] esp = { "----------- Selecione -----------" };
		cbEspecialidade = new JComboBox(esp);
		cbEspecialidade.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				preencherEspecialidade();
			}
		});
		cbEspecialidade.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cbEspecialidade.setBounds(165, 332, 274, 30);
		add(cbEspecialidade);

		String[] med = { "----------- Selecione -----------" };
		cbNomeMedico = new JComboBox(med);
		cbNomeMedico.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				preencherMedico();
			}
		});
		cbNomeMedico.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cbNomeMedico.setBounds(166, 276, 273, 31);
		add(cbNomeMedico);

		dateChooserDataConsulta = new JDateChooser();
		dateChooserDataConsulta.setBounds(178, 393, 181, 31);
		add(dateChooserDataConsulta);

		JButton btnLimparTela = new JButton("Limpar Tela");
		btnLimparTela.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				limparTela();
			}
		});
		btnLimparTela.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnLimparTela.setBounds(26, 486, 142, 35);
		add(btnLimparTela);

		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAlterar.setBounds(219, 486, 130, 35);
		add(btnAlterar);

		String[] horarios = { "--- Selecione ---", "08:00:00", "08:30:00", "09:00:00", "09:30:00", "10:00:00",
				"10:30:00", "11:00:00", "11:30:00", "12:00:00", "12:30:00", "13:00:00", "13:30:00", "14:00:00",
				"14:30:00", "15:00:00", "15:30:00", "16:00", "16:30:00", "17:00:00", "17:30:00", "18:00:00" };

		cbHorarioConsulta = new JComboBox(horarios);
		cbHorarioConsulta.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cbHorarioConsulta.setBounds(179, 446, 168, 29);
		add(cbHorarioConsulta);

		JLabel lblIdProntuario = new JLabel("ID Prontuario");
		lblIdProntuario.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblIdProntuario.setBounds(26, 76, 135, 23);
		add(lblIdProntuario);

		txtIdProntuario = new JTextField();
		txtIdProntuario.setEditable(false);
		txtIdProntuario.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtIdProntuario.setBounds(197, 69, 95, 31);
		add(txtIdProntuario);
		txtIdProntuario.setColumns(10);

		JLabel lblIdEspecialidade = new JLabel("ID Especialidade");
		lblIdEspecialidade.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblIdEspecialidade.setBounds(504, 336, 152, 27);
		add(lblIdEspecialidade);

		txtIdEspecialidade = new JTextField();
		txtIdEspecialidade.setEditable(false);
		txtIdEspecialidade.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtIdEspecialidade.setBounds(671, 332, 52, 28);
		add(txtIdEspecialidade);
		txtIdEspecialidade.setColumns(10);

		JLabel lblIdEspecializacao = new JLabel("ID Especializacao");
		lblIdEspecializacao.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblIdEspecializacao.setBounds(504, 374, 142, 30);
		add(lblIdEspecializacao);

		txtIdEspecializacao = new JTextField();
		txtIdEspecializacao.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtIdEspecializacao.setEditable(false);
		txtIdEspecializacao.setBounds(672, 374, 51, 30);
		add(txtIdEspecializacao);
		txtIdEspecializacao.setColumns(10);

	}

	protected PacienteVO buscarPaciente() {

		txtNomePaciente.setText(pacienteBuscado.getNomePaciente());
		txtIdPaciente.setText(pacienteBuscado.getCodigoPaciente() + "");

		return pacienteBuscado;
	}

	protected void preencherMedico() {

		MedicoController controlador = new MedicoController();
		ArrayList<MedicoVO> listaMedicos = new ArrayList<MedicoVO>();

		listaMedicos = controlador.consultarMedico();
		DefaultComboBoxModel medicos = new DefaultComboBoxModel(listaMedicos.toArray());
		cbNomeMedico.setModel(medicos);

		for (int i = 0; i < listaMedicos.size(); i++) {

			txtIdMedico.setText(listaMedicos.get(i).getCodigoMedico() + "");
		}
		consulta.getPacienteVO().setCodigoPaciente(Integer.parseInt(txtIdPaciente.getText()));
	}

	protected void preencherEspecialidade() {

		EspecialidadeController controlador = new EspecialidadeController();
		ArrayList<EspecialidadeVO> listaEspecialidades = new ArrayList<EspecialidadeVO>();

		listaEspecialidades = controlador.consultarEspecialidade();
		DefaultComboBoxModel especialidades = new DefaultComboBoxModel(listaEspecialidades.toArray());
		cbEspecialidade.setModel(especialidades);

		for (int i = 0; i < listaEspecialidades.size(); i++) {

			txtIdEspecialidade.setText(listaEspecialidades.get(i).getCodigoEspecialidade() + "");
		}

	}

	protected void preencherConvenio() {
		ConvenioController controlador = new ConvenioController();
		ArrayList<ConvenioVO> listaConvenios = new ArrayList<ConvenioVO>();

		listaConvenios = controlador.ConsultarConvenio();
		DefaultComboBoxModel defaultComboBox = new DefaultComboBoxModel(listaConvenios.toArray());
		cbConvenio.setModel(defaultComboBox);

		for (int i = 0; i < listaConvenios.size(); i++) {

			txtIdConvenio.setText(listaConvenios.get(i).getCodigoConvenio() + "");
		}
		consulta.getConvenioVO().setCodigoConvenio(Integer.parseInt(txtIdConvenio.getText()));

	}

	protected void limparTela() {
		txtBuscarCPF.setText("");
		txtIdConvenio.setText("");
		txtIdMedico.setText("");
		txtIdPaciente.setText("");
		txtNomePaciente.setText("");
		txtIdProntuario.setText("");
		cbConvenio.setSelectedIndex(0);
		cbEspecialidade.setSelectedIndex(0);
		cbHorarioConsulta.setSelectedIndex(0);
		cbNomeMedico.setSelectedIndex(0);
		dateChooserDataConsulta.setDate(null);
	}

	protected void preencherEspecializacao() {
		
		EspecializacaoController especializacaoController = new EspecializacaoController();
		ArrayList<EspecializacaoVO> especializacoes = new ArrayList<EspecializacaoVO>();
		
		if(txtIdMedico != null  && txtIdEspecializacao != null) {
			especializacoes = especializacaoController.listarEspecializacoesPorMedicoEspecialidade(medico, especialidade);
			
			for (int i = 0; i < especializacoes.size(); i++) {
				
			txtIdEspecializacao.setText(especializacoes.get(i).getCodigoEspecializacao()+"");
			}
	}
		
}	
	protected void preencherProntuario() {
		
		ProntuarioController prontuarioController = new ProntuarioController();
		ArrayList<ProntuarioVO> prontuarios = new ArrayList<ProntuarioVO>();
		
		if (dateChooserDataConsulta != null && cbHorarioConsulta != null) {
			prontuarioController.listarTodosProntuarios();
		
			for (int i = 0; i < prontuarios.size(); i++) {
					
			txtIdProntuario.setText(prontuarios.get(i).getCodigoProntuario()+"");
			}
		}else {
			txtIdProntuario = null;
		}
	}
	
	protected ConsultaVO construirConsulta() {
		preencherEspecializacao();
		preencherProntuario();
		
		consulta.getProntuarioVO().setCodigoProntuario(Integer.parseInt(txtIdProntuario.getText()));
		consulta.getEspecializacaoVO().setCodigoEspecializacao(Integer.parseInt(txtIdEspecializacao.getText()));	
		consulta.setDataConsulta(dateChooserDataConsulta.getDate());
		consulta.setHorarioConsulta((String) cbHorarioConsulta.getSelectedItem());
		
		return consulta;
	}
}
