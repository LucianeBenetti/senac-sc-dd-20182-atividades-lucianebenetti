package Clinica_Medica.View.Prontuario;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.DropMode;
import java.awt.Color;

public class TelaCadastrarProntuario extends JPanel {
	private JTextField txtBuscarNome;
	private JTextField txtNomePaciente;
	private JTextArea txtAreaRegistro;
	private JDateChooser dateChooserDataConsulta;
	private JTextArea txtAreaMedicamentos;
	private JTextArea txtAreaExames;
	

	/**
	 * Create the panel.
	 */
	public TelaCadastrarProntuario() {
		setBackground(new Color(230, 230, 250));
		setLayout(null);
		
		JLabel lblBuscarNomePaciente = new JLabel("Nome Paciente");
		lblBuscarNomePaciente.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBuscarNomePaciente.setBounds(21, 24, 126, 22);
		add(lblBuscarNomePaciente);
		
		JLabel lblDataConsulta = new JLabel("Data Consulta");
		lblDataConsulta.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDataConsulta.setBounds(21, 57, 126, 22);
		add(lblDataConsulta);
		
		txtBuscarNome = new JTextField();
		txtBuscarNome.setBounds(157, 16, 377, 32);
		add(txtBuscarNome);
		txtBuscarNome.setColumns(10);
		
		dateChooserDataConsulta = new JDateChooser();
		dateChooserDataConsulta.setBounds(157, 57, 87, 32);
		add(dateChooserDataConsulta);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnBuscar.setBounds(603, 16, 89, 39);
		add(btnBuscar);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(21, 133, 696, 8);
		add(separator);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnCadastrar.setBounds(325, 452, 150, 39);
		add(btnCadastrar);
		
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
		btnSair.setBounds(603, 452, 114, 39);
		add(btnSair);
		
		JLabel lblMedicamentos = new JLabel("Medicamentos");
		lblMedicamentos.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMedicamentos.setBounds(21, 218, 126, 22);
		add(lblMedicamentos);
		
		txtAreaMedicamentos = new JTextArea();
		txtAreaMedicamentos.setFont(new Font("Monospaced", Font.PLAIN, 15));
		txtAreaMedicamentos.setBounds(155, 194, 562, 46);
		add(txtAreaMedicamentos);
		
		JLabel lblExames = new JLabel("Exames");
		lblExames.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblExames.setBounds(21, 286, 94, 22);
		add(lblExames);
		
		txtAreaExames = new JTextArea();
		txtAreaExames.setFont(new Font("Monospaced", Font.PLAIN, 15));
		txtAreaExames.setBounds(157, 262, 560, 46);
		add(txtAreaExames);
			
		JLabel lblRegistro = new JLabel("Registro");
		lblRegistro.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblRegistro.setBounds(21, 349, 94, 22);
		add(lblRegistro);
		
		txtAreaRegistro = new JTextArea();
		txtAreaRegistro.setFont(new Font("Monospaced", Font.PLAIN, 15));
	
		txtAreaRegistro.setBounds(157, 319, 560, 122);
		add(txtAreaRegistro);
		
		JLabel lblNomePaciente = new JLabel("Nome Paciente");
		lblNomePaciente.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNomePaciente.setBounds(21, 159, 126, 22);
		add(lblNomePaciente);
		
		txtNomePaciente = new JTextField();
		txtNomePaciente.setColumns(10);
		txtNomePaciente.setBounds(157, 151, 377, 32);
		add(txtNomePaciente);
		
		JButton btnLimparTela = new JButton("Limpar Tela");
		btnLimparTela.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtAreaMedicamentos.setText("");
				txtBuscarNome.setText("");
				txtNomePaciente.setText("");
				txtAreaExames.setText("");
				txtAreaRegistro.setText("");
				dateChooserDataConsulta.setDate(null);
				
			}
		});
		btnLimparTela.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnLimparTela.setBounds(61, 452, 140, 39);
		add(btnLimparTela);

	}
}
