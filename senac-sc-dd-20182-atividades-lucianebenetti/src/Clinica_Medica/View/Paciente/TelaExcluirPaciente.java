package Clinica_Medica.View.Paciente;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

import java.awt.Font;
import java.text.ParseException;

import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaExcluirPaciente extends JPanel {
	private JTextField txtBuscaCPF;
	private JTextField txtNome;
	private JTextField txtCelular;
	private JTextField txtEmail;
	private static final String MASCARA_CELULAR = "(##) ##### ####";
	private static final String MASCARA_CPF = "###.###.###-##";
	private static final String MASCARA_CNPJ = "##.###.###/####-##";
	/**
	 * Create the panel.
	 */
	public TelaExcluirPaciente() {
		setLayout(null);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnBuscar.setBounds(525, 25, 93, 31);
		add(btnBuscar);
		
		JButton btnLimparTela = new JButton("Limpar Tela");
		btnLimparTela.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				limparTela();
			}
		});
		btnLimparTela.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnLimparTela.setBounds(33, 342, 125, 31);
		add(btnLimparTela);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnExcluir.setBounds(272, 342, 103, 31);
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
		btnSair.setBounds(512, 342, 103, 31);
		add(btnSair);
		
		try {
			txtBuscaCPF = new JFormattedTextField(new MaskFormatter(MASCARA_CPF));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		txtBuscaCPF.setBounds(192, 25, 304, 28);
		add(txtBuscaCPF);
		txtBuscaCPF.setColumns(10);
		
		JLabel lblBuscaCpfPaciente = new JLabel("CPF Paciente");
		lblBuscaCpfPaciente.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBuscaCpfPaciente.setBounds(33, 25, 125, 25);
		add(lblBuscaCpfPaciente);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 97, 620, 11);
		add(separator);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNome.setBounds(33, 131, 78, 25);
		add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtNome.setBounds(129, 129, 433, 28);
		add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblCelular = new JLabel("Celular");
		lblCelular.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCelular.setBounds(31, 194, 93, 25);
		add(lblCelular);
		
		try {
			txtCelular = new JFormattedTextField(new MaskFormatter(MASCARA_CELULAR));
			txtCelular.setFont(new Font("Tahoma", Font.PLAIN, 18));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		txtCelular.setBounds(129, 194, 431, 28);
		add(txtCelular);
		txtCelular.setColumns(10);
		
		JLabel lblEmail = new JLabel("e-mail");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEmail.setBounds(33, 253, 78, 25);
		add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtEmail.setBounds(129, 253, 433, 25);
		add(txtEmail);
		txtEmail.setColumns(10);

	}

	protected void limparTela() {
		txtBuscaCPF.setText("");
		txtCelular.setText("");
		txtEmail.setText("");
		txtNome.setText("");
		
	}

}
