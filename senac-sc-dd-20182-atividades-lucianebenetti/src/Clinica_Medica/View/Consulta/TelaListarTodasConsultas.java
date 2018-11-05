package Clinica_Medica.View.Consulta;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JSeparator;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Clinica_Medica.Controller.ConsultaController;
import Clinica_Medica.VO.ConsultaVO;

import javax.swing.JLabel;

public class TelaListarTodasConsultas extends JPanel {
	private JTable tbConsultas;

	/**
	 * Create the panel.
	 */
	public TelaListarTodasConsultas() {
		setBackground(new Color(173, 216, 230));
		setLayout(null);
		
		JButton btnListarTodasConsultas = new JButton("Listar Todas Consultas");
		btnListarTodasConsultas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ConsultaController controlador = new ConsultaController();
				ArrayList<ConsultaVO> consultas = (ArrayList<ConsultaVO>) controlador.listarTodasConsultas();

				DefaultTableModel tabela = (DefaultTableModel) tbConsultas.getModel();
				for (ConsultaVO consulta : consultas) {
					tabela.addRow(new Object[] { consulta.getCodigoConsulta(), consulta.getPacienteVO().getNomePaciente(),
							consulta.getConvenioVO().getNomeConvenio(), consulta.getDataConsulta(), consulta.getHorarioConsulta()

					});
				}
			}
		});
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
		
		tbConsultas = new JTable();
		scrollPane.setViewportView(tbConsultas);
		tbConsultas.setModel(new DefaultTableModel(
			new Object[][] {
				{"ID", "Nome Paciente", "Convenio", "Data Consulta", "Horario"},
			},
			new String[] {
				"ID", "Nome Paciente", "Convenio", "Data Consulta", "Horario"
			}
		));
		tbConsultas.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblConsultas = new JLabel("Consultas");
		lblConsultas.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblConsultas.setBounds(26, 133, 113, 22);
		add(lblConsultas);

	}
}
