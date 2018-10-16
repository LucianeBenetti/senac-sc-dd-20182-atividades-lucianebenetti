package Clinica_Medica.View.Consulta;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.Font;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;

public class TelaCadastrarConsulta extends JPanel {
	private JComboBox cbConvenio;
	private JComboBox cbNomeMedico;
	private JComboBox cbEspecialidade;
	private JTextField txtBuscarNomePaciente;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_2;
	private JTextField textField_4;

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
		lblEspecialidade.setBounds(26, 241, 128, 31);
		add(lblEspecialidade);
		
		JLabel lblNomeMdico = new JLabel("Nome M\u00E9dico");
		lblNomeMdico.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNomeMdico.setBounds(26, 315, 130, 23);
		add(lblNomeMdico);
		
		JLabel lblIdEspecializacao = new JLabel("ID Especializacao");
		lblIdEspecializacao.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblIdEspecializacao.setBounds(509, 315, 152, 23);
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
		
		textField = new JTextField();
		textField.setBounds(671, 127, 52, 31);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(671, 190, 48, 27);
		add(textField_1);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnCadastrar.setBounds(441, 448, 115, 35);
		add(btnCadastrar);
		
		textField_3 = new JTextField();
		textField_3.setBounds(165, 124, 379, 26);
		add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblDataNascimento = new JLabel("Data Nascimento");
		lblDataNascimento.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDataNascimento.setBounds(26, 53, 162, 25);
		add(lblDataNascimento);
		
		
		String[] tipos = {"----------- Selecione -----------", "Particular", "Convênio"};
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(675, 316, 48, 27);
		add(textField_2);
		
		String[] convenios = {"----------- Selecione -----------"};
		cbConvenio = new JComboBox(convenios);
		cbConvenio.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cbConvenio.setBounds(164, 185, 274, 30);
		add(cbConvenio);
		
		String[] especialidades = {"----------- Selecione -----------"};
		cbEspecialidade = new JComboBox(especialidades);
		cbEspecialidade.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cbEspecialidade.setBounds(164, 241, 274, 30);
		add(cbEspecialidade);
		
		String[] medicos = {"----------- Selecione -----------"};
		cbNomeMedico = new JComboBox(medicos);
		cbNomeMedico.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cbNomeMedico.setBounds(165, 308, 273, 31);
		add(cbNomeMedico);
		
		JDateChooser dateChooserData = new JDateChooser();
		dateChooserData.setBounds(188, 360, 87, 31);
		add(dateChooserData);
		
		JDateChooser dateChooserHora = new JDateChooser();
		dateChooserHora.setBounds(509, 360, 87, 31);
		add(dateChooserHora);
		
		JDateChooser dateChooserNascimento = new JDateChooser();
		dateChooserNascimento.setBounds(199, 53, 121, 25);
		add(dateChooserNascimento);
		
		JLabel lblIdProntuario = new JLabel("ID Prontuario");
		lblIdProntuario.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblIdProntuario.setBounds(357, 53, 130, 22);
		add(lblIdProntuario);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_4.setBounds(509, 53, 86, 25);
		add(textField_4);
		textField_4.setColumns(10);

	}
}
