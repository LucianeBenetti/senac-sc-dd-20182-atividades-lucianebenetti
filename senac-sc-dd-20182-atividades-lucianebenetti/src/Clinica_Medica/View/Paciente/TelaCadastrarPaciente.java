package Clinica_Medica.View.Paciente;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.text.ParseException;
import java.util.List;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.text.MaskFormatter;
import Clinica_Medica.BO.PacienteBO;
import Clinica_Medica.Controller.PacienteController;
import Clinica_Medica.VO.PacienteVO;
import Clinica_Medica.View.TelaPrincipal;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Panel;
import java.awt.SystemColor;

public class TelaCadastrarPaciente extends JPanel {
	
	private JComboBox cbEstado;
	private JTextField txtCpfBusca;
	private JTextField txtNome;
	private JTextField txtCpf;
	private JTextField txtCnpj;
	private JTextField txtCelular;
	private JTextField txtFoneRes;
	private JTextField txtFoneCom;
	private JTextField txtEmail;
	private JTextField txtLogradouro;
	private JTextField txtNumLog;
	private JTextField txtComplemento;
	private JTextField txtBairro;
	private JTextField txtCidade;
	private JTextField txtCep;
	private static final String MASCARA_CELULAR = "(##) ##### ####";
	private static final String MASCARA_CPF = "###.###.###-##";
	private static final String MASCARA_TELEFONE_FIXO = "(##) #### ####";
	private static final String MASCARA_CEP= "#####-###";
	private static final String MASCARA_CNPJ = "##.###.###/####-##";
	private PacienteVO paciente = new PacienteVO();
	private PacienteVO pacienteBuscado = new PacienteVO();
	private PacienteBO bo = new PacienteBO();
	
	/**
	 * Create the panel.
	 */
	public TelaCadastrarPaciente() {
		setBackground(new Color(173, 216, 230));
		
		setLayout(null);
		
		JLabel lblCPFBuscar = new JLabel("CPF");
		lblCPFBuscar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCPFBuscar.setBounds(374, 38, 46, 22);
		add(lblCPFBuscar);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNome.setBounds(374, 113, 46, 22);
		add(lblNome);
		
		JLabel lblFoneRes = new JLabel("Fone Residencial");
		lblFoneRes.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblFoneRes.setBounds(374, 243, 141, 22);
		add(lblFoneRes);
		
		JLabel lblFoneCom = new JLabel("Fone Comercial");
		lblFoneCom.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblFoneCom.setBounds(729, 243, 130, 22);
		add(lblFoneCom);
		
		JLabel lblCelular = new JLabel("Celular");
		lblCelular.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCelular.setBounds(374, 198, 68, 22);
		add(lblCelular);
		
		JLabel lblEmail = new JLabel("e-Mail");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEmail.setBounds(374, 291, 61, 22);
		add(lblEmail);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCpf.setBounds(374, 152, 46, 25);
		add(lblCpf);
		
		JLabel lblCnpj = new JLabel("CNPJ");
		lblCnpj.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCnpj.setBounds(702, 153, 46, 22);
		add(lblCnpj);
		
		JLabel lblLogradouro = new JLabel("Endere\u00E7o");
		lblLogradouro.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblLogradouro.setBounds(374, 334, 77, 22);
		add(lblLogradouro);
		
		JLabel lblNumLog = new JLabel("N\u00FAmero");
		lblNumLog.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNumLog.setBounds(374, 379, 68, 22);
		add(lblNumLog);
		
		JLabel lblComplemento = new JLabel("Complemento");
		lblComplemento.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblComplemento.setBounds(603, 379, 116, 22);
		add(lblComplemento);
		
		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBairro.setBounds(374, 422, 61, 22);
		add(lblBairro);
		
		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCidade.setBounds(702, 422, 68, 22);
		add(lblCidade);
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEstado.setBounds(374, 467, 68, 22);
		add(lblEstado);
		
		JLabel lblCep = new JLabel("CEP");
		lblCep.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCep.setBounds(837, 467, 46, 22);
		add(lblCep);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(374, 86, 689, 2);
		add(separator);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				PacienteController controlador = new PacienteController();
				PacienteVO paciente = construirPaciente();
				
				String mensagem = controlador.salvar(paciente);
				JOptionPane.showMessageDialog(null, mensagem);
				limparTela();
			
			}
		});
		btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnCadastrar.setBounds(753, 520, 130, 37);
		add(btnCadastrar);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				PacienteController controlador = new PacienteController();
				pacienteBuscado = controlador.buscarPacientePorCpf(txtCpfBusca.getText());
				
				if (pacienteBuscado != null) {
					pacienteBuscado = buscarPaciente();
				} else {
					JOptionPane.showMessageDialog(null, "Paciente não encontrado.");
					txtCpf.setText(txtCpfBusca.getText());
				}
				
			}
		});
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnBuscar.setBounds(966, 31, 89, 37);
		add(btnBuscar);
		
		try {
			txtCpfBusca = new JFormattedTextField(new MaskFormatter(MASCARA_CPF));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		txtCpfBusca.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtCpfBusca.setBounds(430, 36, 247, 25);
		add(txtCpfBusca);
		txtCpfBusca.setColumns(10);
		
		txtNome = new JTextField();
		txtNome.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtNome.setColumns(10);
		txtNome.setBounds(430, 111, 633, 25);
		add(txtNome);
		
		try {
			txtCpf = new JFormattedTextField(new MaskFormatter(MASCARA_CPF));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		txtCpf.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtCpf.setColumns(10);
		txtCpf.setBounds(430, 151, 247, 25);
		add(txtCpf);
		
		try {
			txtCnpj = new JFormattedTextField(new MaskFormatter(MASCARA_CNPJ));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		txtCnpj.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtCnpj.setColumns(10);
		txtCnpj.setBounds(758, 151, 305, 25);
		add(txtCnpj);
		
		try {
			txtCelular = new JFormattedTextField(new MaskFormatter(MASCARA_CELULAR));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		txtCelular.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtCelular.setColumns(10);
		txtCelular.setBounds(454, 196, 247, 25);
		add(txtCelular);
		
		try {
			txtFoneRes = new JFormattedTextField(new MaskFormatter(MASCARA_TELEFONE_FIXO));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		txtFoneRes.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtFoneRes.setColumns(10);
		txtFoneRes.setBounds(525, 241, 189, 25);
		add(txtFoneRes);
		
		try {
			txtFoneCom = new JFormattedTextField(new MaskFormatter(MASCARA_TELEFONE_FIXO));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		txtFoneCom.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtFoneCom.setColumns(10);
		txtFoneCom.setBounds(869, 241, 194, 25);
		add(txtFoneCom);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtEmail.setColumns(10);
		txtEmail.setBounds(454, 289, 609, 25);
		add(txtEmail);
		
		txtLogradouro = new JTextField();
		txtLogradouro.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtLogradouro.setColumns(10);
		txtLogradouro.setBounds(454, 332, 609, 25);
		add(txtLogradouro);
		
		txtNumLog = new JTextField();
		txtNumLog.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtNumLog.setColumns(10);
		txtNumLog.setBounds(452, 377, 139, 25);
		add(txtNumLog);
		
		txtComplemento = new JTextField();
		txtComplemento.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtComplemento.setColumns(10);
		txtComplemento.setBounds(729, 377, 334, 25);
		add(txtComplemento);
		
		txtBairro = new JTextField();
		txtBairro.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtBairro.setColumns(10);
		txtBairro.setBounds(454, 420, 223, 25);
		add(txtBairro);
		
		txtCidade = new JTextField();
		txtCidade.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtCidade.setColumns(10);
		txtCidade.setBounds(787, 420, 276, 25);
		add(txtCidade);
		
		try {
			txtCep = new JFormattedTextField(new MaskFormatter(MASCARA_CEP));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		txtCep.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtCep.setColumns(10);
		txtCep.setBounds(893, 465, 170, 25);
		add(txtCep);
		
		String[] estados = {"------------- Selecione -------------", "Acre", "Alagoas", "Amapá", "Amazonas", "Bahia", "Ceará", "Distrito Federal", "Espirito Santo", "Goiás", "Maranhão", "Mato Grosso", "Mato Grosso do Sul", "Minas Gerais", "Pará", "Paraná", "Pernambuco","Piauí", "Rio de Janeiro", "Rio Grande do Norte", "Rio Grande do Sul", "Rondônia", "Roraima", "Santa Catarina", "São Paulo", "Sergipe", "Tocantins"};
		cbEstado = new JComboBox(estados);
		cbEstado.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cbEstado.setBounds(453, 467, 349, 24);
		add(cbEstado);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setFont(new Font("Tahoma", Font.PLAIN, 18));
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
		btnSair.setBounds(945, 520, 118, 37);
		add(btnSair);
		
		JButton btnLimparTela = new JButton("Limpar Tela");
		btnLimparTela.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				limparTela();
			}
		});
		btnLimparTela.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnLimparTela.setBounds(374, 520, 137, 37);
		add(btnLimparTela);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				String cpf = null;
				PacienteController dao = new PacienteController();
				PacienteVO paciente = construirPaciente();
				String mensagem = dao.atualizarPaciente(paciente, cpf);
				JOptionPane.showMessageDialog(null, mensagem);
				limparTela();
			}
		});
		btnAlterar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAlterar.setBounds(566, 520, 124, 37);
		add(btnAlterar);
		
		Panel panel = new Panel();
		panel.setBackground(SystemColor.menu);
		panel.setBounds(342, 30, 4, 527);
		add(panel);

	}

	protected PacienteVO buscarPaciente() {
		txtBairro.setText(pacienteBuscado.getBairro());
		txtCelular.setText(pacienteBuscado.getWhatsAppPaciente());
		txtCep.setText(pacienteBuscado.getCep());
		txtCidade.setText(pacienteBuscado.getCidade());
		txtCnpj.setText(pacienteBuscado.getCnpjPaciente());
		txtComplemento.setText(pacienteBuscado.getComplemento());
		txtCpf.setText(pacienteBuscado.getCpfPaciente());
		txtEmail.setText(pacienteBuscado.getEmailPaciente());
		txtFoneCom.setText(pacienteBuscado.getFoneComercial());
		txtFoneRes.setText(pacienteBuscado.getFoneResidencial());
		txtLogradouro.setText(pacienteBuscado.getLogradouro());
		txtNome.setText(pacienteBuscado.getNomePaciente());
		txtNumLog.setText(pacienteBuscado.getNumeroLogradouro());
		cbEstado.setSelectedItem(pacienteBuscado.getUf());
		
		return pacienteBuscado;
	}

	protected PacienteVO construirPaciente() {
		
		paciente.setBairro(txtBairro.getText());
		paciente.setWhatsAppPaciente(txtCelular.getText());
		paciente.setCep(txtCep.getText());
		paciente.setCidade(txtCidade.getText());
		paciente.setCnpjPaciente(txtCnpj.getText());
		paciente.setComplemento(txtComplemento.getText());
		paciente.setCpfPaciente(txtCpf.getText());
		paciente.setEmailPaciente(txtEmail.getText());
		paciente.setFoneComercial(txtFoneCom.getText());
		paciente.setFoneResidencial(txtFoneRes.getText());
		paciente.setLogradouro(txtLogradouro.getText());
		paciente.setNomePaciente(txtNome.getText());
		paciente.setNumeroLogradouro(txtNumLog.getText());
		paciente.setUf((String) cbEstado.getSelectedItem());
			
		return paciente;
	}

	protected void limparTela() {
		txtCelular.setText("");
		txtBairro.setText("");
		txtCep.setText("");
		txtCidade.setText("");
		txtCnpj.setText("");
		txtComplemento.setText("");
		txtCpf.setText("");
		txtCpfBusca.setText("");
		txtEmail.setText("");
		txtFoneCom.setText("");
		txtFoneRes.setText("");
		txtLogradouro.setText("");
		txtNome.setText("");
		txtNumLog.setText("");
		cbEstado.setSelectedIndex(0);
		
	}
}
