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
import java.util.Date;
import java.util.List;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TelaCadastrarConsulta extends JPanel {
	
	private static final String MASCARA_CPF = "###.###.###-##";
	private JComboBox cbHorarioConsulta;
	private JTextField txtBuscarCPF;
	private JTextField txtIdPaciente;
	private JTextField txtIdConvenio;
	private JTextField txtNomePaciente;
	private JDateChooser dateChooserDataConsulta;
	private ConsultaVO consulta = new ConsultaVO();
	private ConvenioVO convenio = new ConvenioVO();
	private MedicoVO medico = new MedicoVO();
	private PacienteVO paciente = new PacienteVO();
	private EspecialidadeVO especialidade = new EspecialidadeVO();
	private EspecializacaoVO especializacao = new EspecializacaoVO();
	private PacienteVO pacienteBuscado = new PacienteVO();
	private JTextField txtIdEspecializacao;
	private JTable tbMedicoEspecialidade;
	private JTextField txtNomeMedico;
	private JTextField txtEspecialidade;
	private JTextField txtConvenio;
	private JTable tbConvenios;

	/**
	 * Create the panel.
	 */
	public TelaCadastrarConsulta() {
		setBackground(new Color(173, 216, 230));
		setLayout(null);

		JLabel lblBuscarCPFPaciente = new JLabel("CPF Paciente");
		lblBuscarCPFPaciente.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBuscarCPFPaciente.setBounds(26, 45, 142, 23);
		add(lblBuscarCPFPaciente);

		try {
			txtBuscarCPF = new JFormattedTextField(new MaskFormatter(MASCARA_CPF));
			txtBuscarCPF.setFont(new Font("Tahoma", Font.PLAIN, 18));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		txtBuscarCPF.setBounds(173, 42, 399, 27);
		add(txtBuscarCPF);
		txtBuscarCPF.setColumns(10);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				ConsultaController controlerConsulta = new ConsultaController();
				PacienteController dao = new PacienteController();
				pacienteBuscado = dao.buscarPacientePorCpf(txtBuscarCPF.getText());

				if (pacienteBuscado != null) {
					pacienteBuscado = buscarPaciente();
					controlerConsulta.listarTodasConsultas();
					ConsultaVO consulta = buscarConsulta();
					
					
				} else {
					JOptionPane.showMessageDialog(null, "Paciente n�o encontrado.");
				}
			}
		});
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnBuscar.setBounds(619, 41, 89, 31);
		add(btnBuscar);

		JSeparator separator = new JSeparator();
		separator.setBounds(26, 98, 697, 9);
		add(separator);

		JLabel lblNome = new JLabel("Nome Paciente");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNome.setBounds(26, 133, 142, 23);
		add(lblNome);

		JLabel lblConvenio = new JLabel("Convenio");
		lblConvenio.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblConvenio.setBounds(26, 189, 107, 23);
		add(lblConvenio);

		JLabel lblEspecialidade = new JLabel("Especialidade");
		lblEspecialidade.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEspecialidade.setBounds(26, 308, 128, 31);
		add(lblEspecialidade);

		JLabel lblNomeMdico = new JLabel("Nome M\u00E9dico");
		lblNomeMdico.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNomeMdico.setBounds(26, 254, 130, 23);
		add(lblNomeMdico);

		JLabel lblData = new JLabel("Data da Consulta");
		lblData.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblData.setBounds(26, 377, 152, 31);
		add(lblData);

		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int opcao;
				Object[] BtSair = { "Sim", "N�o" };

				opcao = JOptionPane.showOptionDialog(null, "Deseja sair desta opera��o?", "Fechar",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, BtSair, BtSair[0]);
				if (opcao == JOptionPane.YES_OPTION) {
					setVisible(false);
				}
			}
		});
		btnSair.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSair.setBounds(1208, 569, 107, 35);
		add(btnSair);

		JLabel lblDataRealizao = new JLabel("Hora da Consulta");
		lblDataRealizao.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDataRealizao.setBounds(26, 464, 162, 23);
		add(lblDataRealizao);

		txtIdPaciente = new JTextField();
		txtIdPaciente.setEditable(false);
		txtIdPaciente.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtIdPaciente.setBounds(554, 129, 52, 27);
		add(txtIdPaciente);
		txtIdPaciente.setColumns(10);

		txtIdConvenio = new JTextField();
		txtIdConvenio.setEditable(false);
		txtIdConvenio.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtIdConvenio.setColumns(10);
		txtIdConvenio.setBounds(483, 186, 52, 27);
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
		btnCadastrar.setBounds(608, 569, 115, 35);
		add(btnCadastrar);

		txtNomePaciente = new JTextField();
		txtNomePaciente.setEditable(false);
		txtNomePaciente.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtNomePaciente.setBounds(165, 130, 379, 26);
		add(txtNomePaciente);
		txtNomePaciente.setColumns(10);

		String[] convenios = { "----------- Selecione -----------" };

		String[] esp = { "----------- Selecione -----------" };

		String[] med = { "----------- Selecione -----------" };

		dateChooserDataConsulta = new JDateChooser(new Date(), "dd/MM/YYYY");
		dateChooserDataConsulta.setFont(new Font("Tahoma", Font.PLAIN, 18));
		dateChooserDataConsulta.setBounds(192, 377, 181, 31);
		add(dateChooserDataConsulta);

		JButton btnLimparTela = new JButton("Limpar Tela");
		btnLimparTela.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				limparTela();
			}
		});
		btnLimparTela.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnLimparTela.setBounds(26, 569, 142, 35);
		add(btnLimparTela);

		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int codigoConsulta = 0;
				ConsultaController dao = new ConsultaController();
				ConsultaVO consulta = construirConsulta();
				String mensagem = dao.atualizarConsulta(consulta, codigoConsulta);
				JOptionPane.showMessageDialog(null, mensagem);
				limparTela();	
			}
		});
		btnAlterar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAlterar.setBounds(316, 569, 130, 35);
		add(btnAlterar);

		String[] horarios = { "--- Selecione ---", "08:00:00", "08:30:00", "09:00:00", "09:30:00", "10:00:00",
				"10:30:00", "11:00:00", "11:30:00", "12:00:00", "12:30:00", "13:00:00", "13:30:00", "14:00:00",
				"14:30:00", "15:00:00", "15:30:00", "16:00:00", "16:30:00", "17:00:00", "17:30:00", "18:00:00" };

		cbHorarioConsulta = new JComboBox(horarios);
		cbHorarioConsulta.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cbHorarioConsulta.setBounds(193, 461, 180, 29);
		add(cbHorarioConsulta);

		txtIdEspecializacao = new JTextField();
		txtIdEspecializacao.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtIdEspecializacao.setEditable(false);
		txtIdEspecializacao.setBounds(484, 282, 51, 30);
		add(txtIdEspecializacao);
		txtIdEspecializacao.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(791, 337, 524, 195);
		add(scrollPane);
		
		tbMedicoEspecialidade = new JTable();
		tbMedicoEspecialidade.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int selecionado = tbMedicoEspecialidade.getSelectedRow();
				
				txtIdEspecializacao.setText(tbMedicoEspecialidade.getValueAt(selecionado, 0) + "");
				txtNomeMedico.setText((String) tbMedicoEspecialidade.getValueAt(selecionado, 1));
				txtEspecialidade.setText((String) tbMedicoEspecialidade.getValueAt(selecionado, 2));
								
			}
		});
		tbMedicoEspecialidade.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tbMedicoEspecialidade.setModel(new DefaultTableModel(
			new Object[][] {
				{"ID", "Nome Medico", "Especialidade"},
			},
			new String[] {
				"ID", "Nome Medico", "Especialidade"
			}
		));
		scrollPane.setViewportView(tbMedicoEspecialidade);
		
		JButton btnNewButton = new JButton("Buscar Medico e Especialidade");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				EspecializacaoController controlador = new EspecializacaoController();
				ArrayList<EspecializacaoVO> especializacoes = (ArrayList<EspecializacaoVO>) controlador.listarTodasEspecializacoes();

				DefaultTableModel tabela = (DefaultTableModel) tbMedicoEspecialidade.getModel();
				for (EspecializacaoVO especializacao : especializacoes) {
					tabela.addRow(new Object[] { especializacao.getCodigoEspecializacao(), especializacao.getMedicoVO().getNomeMedico(), especializacao.getEspecialidadeVO().getNomeEspecialidade(),
							especializacao.getAnoEspecializacao(), especializacao.getEspecialidadeVO().getInstituicao()
				
					});
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(918, 305, 299, 31);
		add(btnNewButton);
		
		txtNomeMedico = new JTextField();
		txtNomeMedico.setEditable(false);
		txtNomeMedico.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtNomeMedico.setBounds(166, 250, 307, 31);
		add(txtNomeMedico);
		txtNomeMedico.setColumns(10);
		
		txtEspecialidade = new JTextField();
		txtEspecialidade.setEditable(false);
		txtEspecialidade.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtEspecialidade.setBounds(165, 308, 308, 31);
		add(txtEspecialidade);
		txtEspecialidade.setColumns(10);
		
		txtConvenio = new JTextField();
		txtConvenio.setEditable(false);
		txtConvenio.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtConvenio.setBounds(166, 186, 307, 28);
		add(txtConvenio);
		txtConvenio.setColumns(10);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(791, 69, 524, 183);
		add(scrollPane_1);
		
		tbConvenios = new JTable();
		tbConvenios.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int selecionado = tbConvenios.getSelectedRow();
				
				txtIdConvenio.setText(tbConvenios.getValueAt(selecionado, 0) + "");
				txtConvenio.setText((String) tbConvenios.getValueAt(selecionado, 1));
				
			}
		});
		tbConvenios.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tbConvenios.setModel(new DefaultTableModel(
			new Object[][] {
				{"ID", "Nome Convenio", "Valor"},
			},
			new String[] {
				"ID", "Nome Convenio", "Valor"
			}
		));
		scrollPane_1.setViewportView(tbConvenios);
		
		JButton btnBuscarConveio = new JButton("Buscar Convenios");
		btnBuscarConveio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				ConvenioController controlador = new ConvenioController();
				ArrayList<ConvenioVO> convenios = (ArrayList<ConvenioVO>) controlador.listarTodosConvenios();

				DefaultTableModel tabela = (DefaultTableModel) tbConvenios.getModel();
				for (ConvenioVO convenio : convenios) {
					tabela.addRow(new Object[] { convenio.getCodigoConvenio(), convenio.getNomeConvenio(),
							convenio.getCnpjConvenio(), convenio.getValor()
				
					});
				}
			}
		});
		btnBuscarConveio.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnBuscarConveio.setBounds(952, 37, 201, 31);
		add(btnBuscarConveio);

	}

	protected ConsultaVO buscarConsulta() {
		
		
		txtNomeMedico.setText(consulta.getEspecializacaoVO().getMedicoVO().getNomeMedico());
		
		return consulta;
	}

	protected PacienteVO buscarPaciente() {

		txtNomePaciente.setText(pacienteBuscado.getNomePaciente());
		txtIdPaciente.setText(pacienteBuscado.getCodigoPaciente() + "");

		return pacienteBuscado;
	}

	protected void limparTela() {
		
		limparTabelaConvenios();
		limparTabelaMedicoEspecialidade();
		
		txtBuscarCPF.setText("");
		txtIdConvenio.setText("");
		txtIdPaciente.setText("");
		txtNomePaciente.setText("");
		txtNomeMedico.setText("");
		txtEspecialidade.setText("");
		txtConvenio.setText("");
		cbHorarioConsulta.setSelectedIndex(0);
		dateChooserDataConsulta.setDate(null);
	}
		
	protected ConsultaVO construirConsulta() {
		
		especializacao.setCodigoEspecializacao(Integer.parseInt(txtIdEspecializacao.getText()));
		convenio.setCodigoConvenio(Integer.parseInt(txtIdConvenio.getText()));
		paciente.setCodigoPaciente(Integer.parseInt(txtIdPaciente.getText()));

		consulta.setEspecializacaoVO(especializacao);
		consulta.setConvenioVO(convenio);
		consulta.setPacienteVO(paciente);
		consulta.setDataConsulta(dateChooserDataConsulta.getDate());
		consulta.setHorarioConsulta((String) cbHorarioConsulta.getSelectedItem());
		
		return consulta;
	}
	
	private void limparTabelaConvenios() {
		int linhas = 0;
		int colunas = 0;
		String zer = null;

		for (linhas = 0; linhas <= tbConvenios.getRowCount() - 1; linhas++) {
			for (colunas = 0; colunas <= tbConvenios.getColumnCount() - 1; colunas++) {
				tbConvenios.setValueAt(zer, linhas, colunas);
			}
		}
	}

	private void limparTabelaMedicoEspecialidade() {
		int linhas = 0;
		int colunas = 0;
		String zer = null;

		for (linhas = 0; linhas <= tbMedicoEspecialidade.getRowCount() - 1; linhas++) {
			for (colunas = 0; colunas <= tbConvenios.getColumnCount() - 1; colunas++) {
				tbMedicoEspecialidade.setValueAt(zer, linhas, colunas);
			}
		}
	}
}
