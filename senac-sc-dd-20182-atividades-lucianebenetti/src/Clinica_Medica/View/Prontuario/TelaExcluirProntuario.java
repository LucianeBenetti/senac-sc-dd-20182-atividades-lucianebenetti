package Clinica_Medica.View.Prontuario;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.text.ParseException;

import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JSeparator;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class TelaExcluirProntuario extends JPanel {
	private JTextField txtBuscarCpf;
	private JTextField txtNome;
	private JTextField txtIdProntuario;
	private static final String MASCARA_CPF = "###.###.###-##";
	private JDateChooser dateChooserDataConsulta;

	/**
	 * Create the panel.
	 */
	public TelaExcluirProntuario() {
		setBackground(new Color(173, 216, 230));
		setLayout(null);
		
		JLabel lblCpfPaciente = new JLabel("CPF Paciente");
		lblCpfPaciente.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCpfPaciente.setBounds(21, 11, 125, 25);
		add(lblCpfPaciente);
		
		try {
			txtBuscarCpf = new JFormattedTextField(new MaskFormatter(MASCARA_CPF));
			txtBuscarCpf.setFont(new Font("Tahoma", Font.PLAIN, 18));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		txtBuscarCpf.setBounds(169, 14, 254, 25);
		add(txtBuscarCpf);
		txtBuscarCpf.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnBuscar.setBounds(457, 8, 89, 31);
		add(btnBuscar);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(21, 103, 525, 2);
		add(separator);
		
		JButton btnLimparTela = new JButton("Limpar Tela");
		btnLimparTela.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				limparTela();
			}
		});
	
		btnLimparTela.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnLimparTela.setBounds(21, 296, 132, 31);
		add(btnLimparTela);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnExcluir.setBounds(234, 296, 97, 31);
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
		btnSair.setBounds(443, 296, 97, 30);
		add(btnSair);
		
		JLabel lblNomePaciente = new JLabel("Nome Paciente");
		lblNomePaciente.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNomePaciente.setBounds(21, 133, 120, 25);
		add(lblNomePaciente);
		
		txtNome = new JTextField();
		txtNome.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtNome.setBounds(151, 133, 395, 25);
		add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblIdProntuario = new JLabel("ID Prontuario");
		lblIdProntuario.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblIdProntuario.setBounds(21, 198, 125, 25);
		add(lblIdProntuario);
		
		txtIdProntuario = new JTextField();
		txtIdProntuario.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtIdProntuario.setBounds(151, 197, 86, 25);
		add(txtIdProntuario);
		txtIdProntuario.setColumns(10);
		
		dateChooserDataConsulta = new JDateChooser();
		dateChooserDataConsulta.setBounds(171, 60, 87, 25);
		add(dateChooserDataConsulta);
		
		JLabel lblDataConsulta = new JLabel("Data Consulta");
		lblDataConsulta.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDataConsulta.setBounds(21, 60, 125, 25);
		add(lblDataConsulta);

	}

	protected void limparTela() {
		txtBuscarCpf.setText("");
		txtIdProntuario.setText("");
		txtNome.setText("");
		dateChooserDataConsulta.setDate(null);
		
		
	}
}
