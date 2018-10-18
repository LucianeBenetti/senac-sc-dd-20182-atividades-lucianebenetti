package Clinica_Medica.View.Medico;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JSeparator;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;

public class TelaExcluirMedico extends JPanel {
	private JTextField txtBuscarCpf;
	private JTextField txtNome;
	private JTextField txtCrm;
	private JTextField txtCnpj;
	private JTextField txtCelular;
	private static final String MASCARA_CELULAR = "(##) ##### ####";
	private static final String MASCARA_CPF = "###.###.###-##";
	private static final String MASCARA_CNPJ = "##.###.###/####-##";
	/**
	 * Create the panel.
	 */
	public TelaExcluirMedico() {
		setLayout(null);
		
		JLabel lblBuscarCpf = new JLabel("CPF");
		lblBuscarCpf.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBuscarCpf.setBounds(10, 29, 54, 28);
		add(lblBuscarCpf);
		
		try {
			txtBuscarCpf = new JFormattedTextField(new MaskFormatter(MASCARA_CPF));
		} catch (ParseException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		txtBuscarCpf.setBounds(95, 29, 299, 28);
		add(txtBuscarCpf);
		txtBuscarCpf.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnBuscar.setBounds(458, 29, 89, 28);
		add(btnBuscar);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 104, 537, 8);
		add(separator);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNome.setBounds(10, 149, 62, 23);
		add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtNome.setBounds(95, 146, 452, 26);
		add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblCnpj = new JLabel("CNPJ");
		lblCnpj.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCnpj.setBounds(10, 258, 54, 28);
		add(lblCnpj);
		
		txtCrm = new JTextField();
		txtCrm.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtCrm.setBounds(95, 201, 452, 26);
		add(txtCrm);
		txtCrm.setColumns(10);
		
		JLabel lblCrm = new JLabel("CRM");
		lblCrm.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCrm.setBounds(10, 204, 54, 23);
		add(lblCrm);
		
		JLabel lblCelular = new JLabel("Celular");
		lblCelular.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCelular.setBounds(10, 309, 76, 24);
		add(lblCelular);
		
		try {
			txtCnpj = new JFormattedTextField(new MaskFormatter(MASCARA_CNPJ));
		} catch (ParseException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		txtCnpj.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtCnpj.setBounds(95, 258, 317, 28);
		add(txtCnpj);
		txtCnpj.setColumns(10);
		
		try {
			txtCelular = new JFormattedTextField(new MaskFormatter(MASCARA_CELULAR));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		txtCelular.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtCelular.setBounds(95, 307, 214, 28);
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
		btnLimparTela.setBounds(29, 384, 125, 28);
		add(btnLimparTela);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnExcluir.setBounds(252, 384, 100, 28);
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
		btnSair.setBounds(447, 384, 102, 28);
		add(btnSair);

	}

	protected void limparTela() {
		txtBuscarCpf.setText("");
		txtCelular.setText("");
		txtCnpj.setText("");
		txtCrm.setText("");
		txtNome.setText("");
	}

}
