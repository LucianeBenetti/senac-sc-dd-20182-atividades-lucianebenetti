package Clinica_Medica.View.Medico;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;
import Clinica_Medica.Controller.MedicoController;
import Clinica_Medica.VO.MedicoVO;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JSeparator;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.awt.Color;
import java.awt.Panel;
import java.awt.SystemColor;

public class TelaExcluirMedico extends JPanel {
	private JTextField txtBuscarCpf;
	private JTextField txtNome;
	private JTextField txtCrm;
	private JTextField txtCnpj;
	private JTextField txtCelular;
	private static final String MASCARA_CELULAR = "(##) ##### ####";
	private static final String MASCARA_CPF = "###.###.###-##";
	private static final String MASCARA_CNPJ = "##.###.###/####-##";
	private MedicoVO medicoBuscado = new MedicoVO();
	private MedicoVO medico = new MedicoVO();
	private JTextField txtCpf;
	private JTextField txtCelMen;
	private JTextField txtEmail;

	/**
	 * 
	 * Create the panel.
	 */
	public TelaExcluirMedico() {
		setBackground(new Color(173, 216, 230));
		setLayout(null);
		
		JLabel lblBuscarCpf = new JLabel("CPF");
		lblBuscarCpf.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBuscarCpf.setBounds(391, 29, 54, 28);
		add(lblBuscarCpf);
		
		try {
			txtBuscarCpf = new JFormattedTextField(new MaskFormatter(MASCARA_CPF));
			txtBuscarCpf.setFont(new Font("Tahoma", Font.PLAIN, 18));
		} catch (ParseException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		txtBuscarCpf.setBounds(476, 29, 299, 28);
		add(txtBuscarCpf);
		txtBuscarCpf.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				MedicoController controlador = new MedicoController();
				medicoBuscado = controlador.buscarMedicoPorCPF(txtBuscarCpf.getText());
				
				if(medicoBuscado != null) {
					medicoBuscado = buscarMedico();
								
					}else {
						JOptionPane.showMessageDialog(null, "Médico não encontrado.");
					}
			}
		});
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnBuscar.setBounds(811, 29, 89, 28);
		add(btnBuscar);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(391, 104, 537, 8);
		add(separator);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNome.setBounds(391, 126, 62, 23);
		add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setEditable(false);
		txtNome.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtNome.setBounds(476, 126, 549, 26);
		add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblCnpj = new JLabel("CNPJ");
		lblCnpj.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCnpj.setBounds(391, 261, 54, 28);
		add(lblCnpj);
		
		txtCrm = new JTextField();
		txtCrm.setEditable(false);
		txtCrm.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtCrm.setBounds(476, 174, 195, 26);
		add(txtCrm);
		txtCrm.setColumns(10);
		
		JLabel lblCrm = new JLabel("CRM");
		lblCrm.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCrm.setBounds(391, 176, 54, 23);
		add(lblCrm);
		
		JLabel lblCelular = new JLabel(" Celular Principal");
		lblCelular.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCelular.setBounds(385, 311, 136, 24);
		add(lblCelular);
		
		try {
			txtCnpj = new JFormattedTextField(new MaskFormatter(MASCARA_CNPJ));
			txtCnpj.setEditable(false);
		} catch (ParseException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		txtCnpj.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtCnpj.setBounds(476, 261, 317, 28);
		add(txtCnpj);
		txtCnpj.setColumns(10);
		
		try {
			txtCelular = new JFormattedTextField(new MaskFormatter(MASCARA_CELULAR));
			txtCelular.setEditable(false);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		txtCelular.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtCelular.setBounds(561, 310, 232, 28);
		add(txtCelular);
		txtCelular.setColumns(10);
		
		JButton btnLimparTela = new JButton("Limpar Tela");
		btnLimparTela.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				limparTela();
			}
		});
		btnLimparTela.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnLimparTela.setBounds(381, 473, 168, 31);
		add(btnLimparTela);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				MedicoController controlador = new MedicoController();
				MedicoVO medicoExcluido = construirMedico();
				controlador.excluirMedico(medicoExcluido);
				JOptionPane.showMessageDialog(null, "Medico excluído!");
				limparTela();
			}
		});
		btnExcluir.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnExcluir.setBounds(675, 473, 100, 31);
		add(btnExcluir);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
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
		btnSair.setBounds(902, 473, 102, 31);
		add(btnSair);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCpf.setBounds(391, 222, 54, 23);
		add(lblCpf);
		
		try {
			txtCpf = new JFormattedTextField(new MaskFormatter(MASCARA_CPF));
			txtCpf.setEditable(false);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		txtCpf.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtCpf.setBounds(475, 218, 318, 28);
		add(txtCpf);
		txtCpf.setColumns(10);
		
		JLabel lblCelularMensagem = new JLabel("Celular Mensagem");
		lblCelularMensagem.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCelularMensagem.setBounds(391, 361, 158, 28);
		add(lblCelularMensagem);
		
		try {
			txtCelMen = new JFormattedTextField(new MaskFormatter(MASCARA_CELULAR));
			txtCelMen.setEditable(false);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		txtCelMen.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtCelMen.setBounds(561, 361, 232, 27);
		add(txtCelMen);
		txtCelMen.setColumns(10);
		
		JLabel lblEmail = new JLabel("e-mail");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEmail.setBounds(391, 400, 62, 26);
		add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setEditable(false);
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtEmail.setBounds(499, 400, 526, 26);
		add(txtEmail);
		txtEmail.setColumns(10);
		
		Panel panel = new Panel();
		panel.setBackground(SystemColor.menu);
		panel.setBounds(354, 29, 3, 474);
		add(panel);

	}

	protected void limparTela() {
		txtBuscarCpf.setText("");
		txtCelular.setText("");
		txtCelMen.setText("");
		txtCpf.setText("");
		txtCnpj.setText("");
		txtCrm.setText("");
		txtNome.setText("");
		txtEmail.setText("");
	}
	
protected MedicoVO construirMedico() {
		
	medico.setNomeMedico(txtNome.getText());
	medico.setCrm(txtCrm.getText());
	medico.setCpfMedico(txtCpf.getText());
	medico.setCnpjMedico(txtCnpj.getText());
	medico.setCelularMedico(txtCelular.getText());
	medico.setWhatsAppMedico(txtCelMen.getText());
	medico.setEmailMedico(txtEmail.getText());
		
		return medico;
	}

protected MedicoVO buscarMedico() {
	txtNome.setText(medicoBuscado.getNomeMedico());
	txtCrm.setText(medicoBuscado.getCrm());
	txtCpf.setText(medicoBuscado.getCpfMedico());
	txtCnpj.setText(medicoBuscado.getCnpjMedico());
	txtCelular.setText(medicoBuscado.getCelularMedico());
	txtCelMen.setText(medicoBuscado.getWhatsAppMedico());
	txtEmail.setText(medicoBuscado.getEmailMedico());

	return medicoBuscado;
}

}
