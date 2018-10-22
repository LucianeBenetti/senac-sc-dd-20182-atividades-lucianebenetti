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
		setLayout(null);
		
		JLabel lblBuscarCpf = new JLabel("CPF");
		lblBuscarCpf.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBuscarCpf.setBounds(10, 29, 54, 28);
		add(lblBuscarCpf);
		
		try {
			txtBuscarCpf = new JFormattedTextField(new MaskFormatter(MASCARA_CPF));
			txtBuscarCpf.setFont(new Font("Tahoma", Font.PLAIN, 18));
		} catch (ParseException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		txtBuscarCpf.setBounds(95, 29, 299, 28);
		add(txtBuscarCpf);
		txtBuscarCpf.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				MedicoController dao = new MedicoController();
				medicoBuscado = dao.buscarMedicoPorCPF(txtBuscarCpf.getText());
				
				if(medicoBuscado != null) {
					medicoBuscado = buscarMedico();
								
					}else {
						JOptionPane.showMessageDialog(null, "Médico não encontrado.");
					}
			}
		});
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnBuscar.setBounds(430, 29, 89, 28);
		add(btnBuscar);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 104, 537, 8);
		add(separator);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNome.setBounds(10, 123, 62, 23);
		add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtNome.setBounds(95, 123, 549, 26);
		add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblCnpj = new JLabel("CNPJ");
		lblCnpj.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCnpj.setBounds(10, 258, 54, 28);
		add(lblCnpj);
		
		txtCrm = new JTextField();
		txtCrm.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtCrm.setBounds(95, 171, 195, 26);
		add(txtCrm);
		txtCrm.setColumns(10);
		
		JLabel lblCrm = new JLabel("CRM");
		lblCrm.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCrm.setBounds(10, 173, 54, 23);
		add(lblCrm);
		
		JLabel lblCelular = new JLabel(" Celular Principal");
		lblCelular.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCelular.setBounds(10, 309, 136, 24);
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
		txtCelular.setBounds(180, 307, 232, 28);
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
		btnLimparTela.setBounds(21, 458, 125, 31);
		add(btnLimparTela);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				MedicoController dao = new MedicoController();
				MedicoVO medicoExcluido = construirMedico();
				dao.excluirMedico(medicoExcluido);
				JOptionPane.showMessageDialog(null, "Medico excluído!");
				limparTela();
			}
		});
		btnExcluir.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnExcluir.setBounds(283, 458, 100, 31);
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
		btnSair.setBounds(542, 458, 102, 31);
		add(btnSair);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCpf.setBounds(10, 219, 54, 23);
		add(lblCpf);
		
		try {
			txtCpf = new JFormattedTextField(new MaskFormatter(MASCARA_CPF));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		txtCpf.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtCpf.setBounds(94, 215, 318, 28);
		add(txtCpf);
		txtCpf.setColumns(10);
		
		JLabel lblCelularMensagem = new JLabel("Celular Mensagem");
		lblCelularMensagem.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCelularMensagem.setBounds(18, 358, 158, 28);
		add(lblCelularMensagem);
		
		try {
			txtCelMen = new JFormattedTextField(new MaskFormatter(MASCARA_CELULAR));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		txtCelMen.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtCelMen.setBounds(180, 358, 232, 27);
		add(txtCelMen);
		txtCelMen.setColumns(10);
		
		JLabel lblEmail = new JLabel("e-mail");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEmail.setBounds(18, 397, 62, 26);
		add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtEmail.setBounds(118, 397, 526, 26);
		add(txtEmail);
		txtEmail.setColumns(10);

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
		
	medico.setMedNome(txtNome.getText());
	medico.setCrm(txtCrm.getText());
	medico.setCpf(txtCpf.getText());
	medico.setCnpj(txtCnpj.getText());
	medico.setCel(txtCelular.getText());
	medico.setCelMen(txtCelMen.getText());
	medico.setEmail(txtEmail.getText());
		
		return medico;
	}

protected MedicoVO buscarMedico() {
	txtNome.setText(medicoBuscado.getMedNome());
	txtCrm.setText(medicoBuscado.getCrm());
	txtCpf.setText(medicoBuscado.getCpf());
	txtCnpj.setText(medicoBuscado.getCnpj());
	txtCelular.setText(medicoBuscado.getCel());
	txtCelMen.setText(medicoBuscado.getCelMen());
	txtEmail.setText(medicoBuscado.getEmail());

	return medicoBuscado;
}

}
