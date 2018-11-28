package Clinica_Medica.View.Medico;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import java.awt.Font;
import java.text.ParseException;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;
import Clinica_Medica.BO.MedicoBO;
import Clinica_Medica.Controller.MedicoController;
import Clinica_Medica.VO.MedicoVO;
import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Panel;
import javax.swing.UIManager;

public class TelaCadastrarMedico extends JPanel {
	private JTextField txtNome;
	private JTextField txtCrm;
	private JTextField txtCPF;
	private JTextField txtCnpj;
	private JFormattedTextField txtCel;
	private JTextField txtCelMen;
	private JTextField txtEmail;
	private JTextField txtBuscarCpf;
	private static final String MASCARA_CELULAR = "(##) ##### ####";
	private static final String MASCARA_CPF = "###.###.###-##";
	private static final String MASCARA_CNPJ = "##.###.###/####-##";
	private MedicoVO medicoBuscado = new MedicoVO();
	private MedicoBO bo = new MedicoBO();
	private MedicoVO medico = new MedicoVO();

	/**
	 * Create the panel.
	 * 
	 * @throws ParseException
	 */
	public TelaCadastrarMedico() {
		setBackground(new Color(173, 216, 230));
		setLayout(null);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				MedicoController controlador = new MedicoController();
				MedicoVO medico = construirMedico();

				String mensagem = controlador.salvar(medico);
				JOptionPane.showMessageDialog(null, mensagem);
				limparTela();
				
			}
		});
		btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnCadastrar.setBounds(783, 495, 119, 37);
		add(btnCadastrar);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNome.setBounds(383, 115, 46, 23);
		add(lblNome);

		JLabel lblCrm = new JLabel("CRM");
		lblCrm.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCrm.setBounds(383, 163, 46, 23);
		add(lblCrm);

		JLabel lblNewLabel = new JLabel("Celular Mensagem");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(383, 368, 150, 27);
		add(lblNewLabel);

		JLabel lblCelular = new JLabel("Celular Principal");
		lblCelular.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCelular.setBounds(383, 317, 138, 26);
		add(lblCelular);

		JLabel lblEmail = new JLabel("e-Mail");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEmail.setBounds(383, 421, 68, 23);
		add(lblEmail);

		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCpf.setBounds(383, 212, 46, 23);
		add(lblCpf);

		JLabel lblCnpj = new JLabel("CNPJ");
		lblCnpj.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCnpj.setBounds(383, 267, 46, 23);
		add(lblCnpj);

		txtNome = new JTextField();
		txtNome.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtNome.setBounds(439, 109, 636, 29);
		add(txtNome);
		txtNome.setColumns(10);

		txtCrm = new JTextField();
		txtCrm.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtCrm.setBounds(439, 160, 169, 27);
		add(txtCrm);
		txtCrm.setColumns(10);

		try {
			txtCPF = new JFormattedTextField(new MaskFormatter(MASCARA_CPF));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		txtCPF.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtCPF.setBounds(439, 209, 277, 27);
		add(txtCPF);
		txtCPF.setColumns(10);

		try {
			txtCnpj = new JFormattedTextField(new MaskFormatter(MASCARA_CNPJ));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		txtCnpj.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtCnpj.setBounds(439, 264, 277, 27);
		add(txtCnpj);
		txtCnpj.setColumns(10);

		try {
			txtCel = new JFormattedTextField(new MaskFormatter(MASCARA_CELULAR));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		txtCel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtCel.setBounds(531, 316, 323, 28);
		add(txtCel);
		txtCel.setColumns(10);

		try {
			txtCelMen = new JFormattedTextField(new MaskFormatter(MASCARA_CELULAR));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		txtCelMen.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtCelMen.setBounds(531, 367, 323, 28);
		add(txtCelMen);
		txtCelMen.setColumns(10);

		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtEmail.setBounds(461, 418, 614, 29);
		add(txtEmail);
		txtEmail.setColumns(10);

		JLabel lblBuscarCpf = new JLabel("CPF");
		lblBuscarCpf.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBuscarCpf.setBounds(383, 53, 46, 14);
		add(lblBuscarCpf);

		try {
			txtBuscarCpf = new JFormattedTextField(new MaskFormatter(MASCARA_CPF));
			txtBuscarCpf.setFont(new Font("Tahoma", Font.PLAIN, 18));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		txtBuscarCpf.setBounds(439, 46, 337, 27);
		add(txtBuscarCpf);
		txtBuscarCpf.setColumns(10);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				MedicoController controlador = new MedicoController();
				medicoBuscado = controlador.buscarMedicoPorCPF(txtBuscarCpf.getText());

				if (medicoBuscado != null) {
					medicoBuscado = buscarMedico();

				} else {
					JOptionPane.showMessageDialog(null, "Médico não encontrado.");
					txtCPF.setText(txtBuscarCpf.getText());
				}
			}
		});
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnBuscar.setBounds(817, 43, 105, 30);
		add(btnBuscar);

		JSeparator separator = new JSeparator();
		separator.setBounds(383, 96, 530, 2);
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
		btnSair.setBounds(977, 495, 98, 37);
		add(btnSair);

		JButton btnLimparTela = new JButton("Limpar Tela");
		btnLimparTela.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				limparTela();
			}
		});
		btnLimparTela.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnLimparTela.setBounds(376, 495, 138, 37);
		add(btnLimparTela);

		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				String cpf = null;
				MedicoController controlador = new MedicoController();
				MedicoVO medico = construirMedico();
				String mensagem = controlador.atualizarMedico(medico, cpf);
				JOptionPane.showMessageDialog(null, mensagem);
				limparTela();
			}
		});
		btnAlterar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAlterar.setBounds(566, 495, 143, 37);
		add(btnAlterar);

		Panel panel = new Panel();
		panel.setBackground(UIManager.getColor("Button.background"));
		panel.setBounds(350, 38, 4, 494);
		add(panel);

	}

	protected MedicoVO buscarMedico() {
		txtNome.setText(medicoBuscado.getNomeMedico());
		txtCrm.setText(medicoBuscado.getCrm());
		txtCPF.setText(medicoBuscado.getCpfMedico());
		txtCnpj.setText(medicoBuscado.getCnpjMedico());
		txtCel.setText(medicoBuscado.getCelularMedico());
		txtCelMen.setText(medicoBuscado.getWhatsAppMedico());
		txtEmail.setText(medicoBuscado.getEmailMedico());

		return medicoBuscado;
	}

	protected void limparTela() {
		txtNome.setText("");
		txtCrm.setText("");
		txtCPF.setText("");
		txtCnpj.setText("");
		txtCel.setText("");
		txtCelMen.setText("");
		txtEmail.setText("");
		txtBuscarCpf.setText("");

	}

	protected MedicoVO construirMedico() {

		medico.setNomeMedico(txtNome.getText());
		medico.setCrm(txtCrm.getText());
		medico.setCpfMedico(txtCPF.getText());
		medico.setCnpjMedico(txtCnpj.getText());
		medico.setCelularMedico(txtCel.getText());
		medico.setWhatsAppMedico(txtCelMen.getText());
		medico.setEmailMedico(txtEmail.getText());

		return medico;
	}
}
