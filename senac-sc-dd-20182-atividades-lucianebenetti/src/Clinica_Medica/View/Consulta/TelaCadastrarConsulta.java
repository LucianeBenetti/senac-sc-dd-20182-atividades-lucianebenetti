package Clinica_Medica.View.Consulta;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.Font;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;

import Clinica_Medica.Controller.ConvenioController;
import Clinica_Medica.Controller.EspecialidadeController;
import Clinica_Medica.Controller.EspecializacaoController;
import Clinica_Medica.Controller.MedicoController;
import Clinica_Medica.VO.ConvenioVO;
import Clinica_Medica.VO.EspecialidadeVO;
import Clinica_Medica.VO.EspecializacaoVO;
import Clinica_Medica.VO.MedicoVO;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class TelaCadastrarConsulta extends JPanel {
	private JComboBox cbConvenio;
	private JComboBox cbNomeMedico;
	private JComboBox cbEspecialidade;
	private JTextField txtBuscarNomePaciente;
	private JTextField txtIdPaciente;
	private JTextField txtIdConvenio;
	private JTextField txtNomePaciente;
	private JTextField txtIdEspecializacao;
	private JTextField txtIdProntuario;
	private JDateChooser dateChooserDataConsulta;
	private JDateChooser dateChooserHoraConsulta;
	private JDateChooser dateChooserNascimento;

	/**
	 * Create the panel.
	 */
	public TelaCadastrarConsulta() {
		setBackground(new Color(230, 230, 250));
		setLayout(null);
		
		JLabel lblBuscarNomePaciente = new JLabel("Nome Paciente");
		lblBuscarNomePaciente.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBuscarNomePaciente.setBounds(26, 19, 142, 23);
		add(lblBuscarNomePaciente);
		
		txtBuscarNomePaciente = new JTextField();
		txtBuscarNomePaciente.setBounds(199, 15, 399, 27);
		add(txtBuscarNomePaciente);
		txtBuscarNomePaciente.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnBuscar.setBounds(634, 15, 89, 31);
		add(btnBuscar);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(26, 107, 697, 9);
		add(separator);
		
		JLabel lblNome = new JLabel("Nome Paciente");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNome.setBounds(26, 127, 142, 23);
		add(lblNome);
		
		JLabel lblIdPaciente = new JLabel("ID Paciente");
		lblIdPaciente.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblIdPaciente.setBounds(560, 127, 101, 23);
		add(lblIdPaciente);
		
		JLabel lblConvenio = new JLabel("Convenio");
		lblConvenio.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblConvenio.setBounds(26, 189, 107, 23);
		add(lblConvenio);
		
		JLabel lblIdConvenio = new JLabel("ID Convenio");
		lblIdConvenio.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblIdConvenio.setBounds(554, 189, 107, 23);
		add(lblIdConvenio);
		
		JLabel lblEspecialidade = new JLabel("Especialidade");
		lblEspecialidade.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEspecialidade.setBounds(26, 293, 128, 31);
		add(lblEspecialidade);
		
		JLabel lblNomeMdico = new JLabel("Nome M\u00E9dico");
		lblNomeMdico.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNomeMdico.setBounds(25, 245, 130, 23);
		add(lblNomeMdico);
		
		JLabel lblIdEspecializacao = new JLabel("ID Especializacao");
		lblIdEspecializacao.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblIdEspecializacao.setBounds(509, 245, 152, 23);
		add(lblIdEspecializacao);
		
		JLabel lblData = new JLabel("Data da Consulta");
		lblData.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblData.setBounds(26, 360, 152, 31);
		add(lblData);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int opcao;
                Object[] BtSair={"Sim","Não"};
                 
                opcao = JOptionPane.showOptionDialog(null,"Deseja sair desta operação?", 
                        "Fechar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                        null, BtSair, BtSair[0]);
                        if(opcao == JOptionPane.YES_OPTION) {
                        	 setVisible(false);
                        }
			}
		});
		btnSair.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSair.setBounds(616, 448, 107, 35);
		add(btnSair);
		
		JLabel lblDataRealizao = new JLabel("Hora da Consulta");
		lblDataRealizao.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDataRealizao.setBounds(338, 364, 162, 23);
		add(lblDataRealizao);
		
		txtIdPaciente = new JTextField();
		txtIdPaciente.setBounds(671, 127, 52, 31);
		add(txtIdPaciente);
		txtIdPaciente.setColumns(10);
		
		txtIdConvenio = new JTextField();
		txtIdConvenio.setColumns(10);
		txtIdConvenio.setBounds(671, 190, 48, 27);
		add(txtIdConvenio);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnCadastrar.setBounds(315, 448, 115, 35);
		add(btnCadastrar);
		
		txtNomePaciente = new JTextField();
		txtNomePaciente.setBounds(165, 124, 379, 26);
		add(txtNomePaciente);
		txtNomePaciente.setColumns(10);
		
		JLabel lblDataNascimento = new JLabel("Data Nascimento");
		lblDataNascimento.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDataNascimento.setBounds(26, 53, 162, 25);
		add(lblDataNascimento);
		
		
		String[] tipos = {"----------- Selecione -----------", "Particular", "Convênio"};
		
		txtIdEspecializacao = new JTextField();
		txtIdEspecializacao.setColumns(10);
		txtIdEspecializacao.setBounds(671, 246, 48, 27);
		add(txtIdEspecializacao);
		
		String[] convenios = {"----------- Selecione -----------"};
		cbConvenio = new JComboBox(convenios);
		cbConvenio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				preencherConvenio();
			}
		});
		cbConvenio.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cbConvenio.setBounds(164, 185, 274, 30);
		add(cbConvenio);
		
		String[] esp = {"----------- Selecione -----------"};
		cbEspecialidade = new JComboBox(esp);
		cbEspecialidade.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cbEspecialidade.setBounds(164, 293, 274, 30);
		add(cbEspecialidade);
		
		String[] med = {"----------- Selecione -----------"};
		cbNomeMedico = new JComboBox(med);
		cbNomeMedico.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				preencherMedico();
			}
		});
		cbNomeMedico.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cbNomeMedico.setBounds(165, 237, 273, 31);
		add(cbNomeMedico);
		
		dateChooserDataConsulta = new JDateChooser();
		dateChooserDataConsulta.setBounds(188, 360, 87, 31);
		add(dateChooserDataConsulta);
		
		dateChooserHoraConsulta = new JDateChooser();
		dateChooserHoraConsulta.setBounds(509, 360, 87, 31);
		add(dateChooserHoraConsulta);
		
		dateChooserNascimento = new JDateChooser();
		dateChooserNascimento.setBounds(199, 53, 121, 25);
		add(dateChooserNascimento);
		
		JLabel lblIdProntuario = new JLabel("ID Prontuario");
		lblIdProntuario.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblIdProntuario.setBounds(357, 53, 130, 22);
		add(lblIdProntuario);
		
		txtIdProntuario = new JTextField();
		txtIdProntuario.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtIdProntuario.setBounds(509, 53, 86, 25);
		add(txtIdProntuario);
		txtIdProntuario.setColumns(10);
		
		JButton btnLimparTela = new JButton("Limpar Tela");
		btnLimparTela.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				limparTela();
			}
		});
		btnLimparTela.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnLimparTela.setBounds(26, 448, 142, 35);
		add(btnLimparTela);

	}

	protected void preencherMedico() {
		String espNome = null;
		String medNome = null;
		int espeCod = 0;
		MedicoController controlador = new MedicoController();
		EspecialidadeController controladorEspecialidade = new EspecialidadeController();
	    ArrayList<MedicoVO> listaMedico = new ArrayList<MedicoVO>();
	    ArrayList<EspecialidadeVO> listaEspecialidade = new ArrayList<EspecialidadeVO>(); 
	    
	    	listaMedico = controlador.ConsultarMedico();
	    	listaEspecialidade = controladorEspecialidade.ConsultarEspecialidade(espNome, espeCod, medNome);
	    	DefaultComboBoxModel medicos = new DefaultComboBoxModel(listaMedico.toArray());
	    	DefaultComboBoxModel especialidades = new DefaultComboBoxModel(listaEspecialidade.toArray());
	    	cbNomeMedico.setModel(medicos);
	       	cbEspecialidade.setModel(especialidades);
	       	
		
	}

	protected void preencherConvenio() {
		ConvenioController controlador = new ConvenioController();
	    ConvenioVO convenio = new ConvenioVO();
	    ArrayList<ConvenioVO> listaConvenio = new ArrayList<ConvenioVO>();
	    
	    	listaConvenio = controlador.ConsultarConvenio();
	    	DefaultComboBoxModel defaultComboBox = new DefaultComboBoxModel(listaConvenio.toArray());
	    	cbConvenio.setModel(defaultComboBox);
		
	}

	protected void limparTela() {
		txtBuscarNomePaciente.setText("");
		txtIdConvenio.setText("");
		txtIdEspecializacao.setText("");
		txtIdPaciente.setText("");
		txtIdProntuario.setText("");
		txtNomePaciente.setText("");
		cbConvenio.setSelectedIndex(0);
		cbEspecialidade.setSelectedIndex(0);
		cbNomeMedico.setSelectedIndex(0);
		dateChooserDataConsulta.setDate(null);
		dateChooserHoraConsulta.setDate(null);
		dateChooserNascimento.setDate(null);
	
		
	}
}
