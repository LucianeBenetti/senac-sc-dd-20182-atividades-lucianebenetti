package Clinica_Medica.View.Consulta;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JSeparator;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;

public class TelaListarTodasConsultas extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public TelaListarTodasConsultas() {
		setBackground(new Color(173, 216, 230));
		setLayout(null);
		
		JButton btnListarTodasConsultas = new JButton("Listar Todas Consultas");
		btnListarTodasConsultas.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnListarTodasConsultas.setBounds(252, 31, 238, 31);
		add(btnListarTodasConsultas);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 92, 718, 8);
		add(separator);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
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
		btnSair.setBounds(702, 437, 92, 31);
		add(btnSair);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 153, 768, 161);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"ID", "Nome Paciente", "Convenio", "Nome Medico", "Especialidade", "Data Consulta"},
			},
			new String[] {
				"ID", "Nome Paciente", "Convenio", "Nome Medico", "Especialidade", "Data Consulta"
			}
		));
		table.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblConsultas = new JLabel("Consultas");
		lblConsultas.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblConsultas.setBounds(26, 133, 113, 22);
		add(lblConsultas);

	}
}
