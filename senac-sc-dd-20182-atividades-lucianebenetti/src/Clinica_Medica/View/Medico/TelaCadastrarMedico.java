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
import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCadastrarMedico extends JPanel {
	private JTextField txtNome;
	private JTextField txrCrm;
	private JTextField txtCPF;
	private JTextField txtCnpj;
	private JFormattedTextField txtCel;
	private JTextField txtCelMen;
	private JTextField txtEmail;
	private JTextField txtBuscarCpf;
	private static final String MASCARA_CELULAR = "(##) ##### ####";
	private static final String MASCARA_CPF = "###.###.###-##";

	/**
	 * Create the panel.
	 * @throws ParseException 
	 */
	public TelaCadastrarMedico() {
		setBackground(new Color(230, 230, 250));
		setLayout(null);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnCadastrar.setBounds(224, 452, 119, 27);
		add(btnCadastrar);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNome.setBounds(10, 109, 46, 23);
		add(lblNome);
		
		JLabel lblCrm = new JLabel("CRM");
		lblCrm.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCrm.setBounds(10, 157, 46, 23);
		add(lblCrm);
		
		JLabel lblNewLabel = new JLabel("Celular Mensagem");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(10, 362, 150, 27);
		add(lblNewLabel);
		
		JLabel lblCelular = new JLabel("Celular Principal");
		lblCelular.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCelular.setBounds(10, 311, 138, 26);
		add(lblCelular);
		
		JLabel lblEmail = new JLabel("e-Mail");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEmail.setBounds(10, 415, 68, 23);
		add(lblEmail);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCpf.setBounds(10, 206, 46, 23);
		add(lblCpf);
		
		JLabel lblCnpj = new JLabel("CNPJ");
		lblCnpj.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCnpj.setBounds(10, 261, 46, 23);
		add(lblCnpj);
		
		txtNome = new JTextField();
		txtNome.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtNome.setBounds(66, 103, 415, 29);
		add(txtNome);
		txtNome.setColumns(10);
		
		txrCrm = new JTextField();
		txrCrm.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txrCrm.setBounds(66, 154, 415, 27);
		add(txrCrm);
		txrCrm.setColumns(10);
		
		try {
			txtCPF = new JFormattedTextField(new MaskFormatter(MASCARA_CPF));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		txtCPF.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtCPF.setBounds(66, 203, 415, 27);
		add(txtCPF);
		txtCPF.setColumns(10);
		
		txtCnpj = new JTextField();
		txtCnpj.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtCnpj.setBounds(66, 258, 415, 27);
		add(txtCnpj);
		txtCnpj.setColumns(10);
		
		try {
			txtCel = new JFormattedTextField(new MaskFormatter(MASCARA_CELULAR));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		txtCel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtCel.setBounds(158, 310, 323, 28);
		add(txtCel);
		txtCel.setColumns(10);
		
		try {
			txtCelMen = new JFormattedTextField(new MaskFormatter(MASCARA_CELULAR));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		txtCelMen.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtCelMen.setBounds(158, 361, 323, 28);
		add(txtCelMen);
		txtCelMen.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtEmail.setBounds(88, 412, 393, 29);
		add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblBuscarCpf = new JLabel("CPF");
		lblBuscarCpf.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBuscarCpf.setBounds(10, 33, 46, 14);
		add(lblBuscarCpf);
		
		try {
			txtBuscarCpf = new JFormattedTextField(new MaskFormatter(MASCARA_CPF));
			txtBuscarCpf.setFont(new Font("Tahoma", Font.PLAIN, 18));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		txtBuscarCpf.setBounds(66, 30, 277, 27);
		add(txtBuscarCpf);
		txtBuscarCpf.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnBuscar.setBounds(376, 27, 105, 27);
		add(btnBuscar);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 84, 471, 2);
		add(separator);
		
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
		btnSair.setBounds(392, 451, 89, 28);
		add(btnSair);

	}
}
