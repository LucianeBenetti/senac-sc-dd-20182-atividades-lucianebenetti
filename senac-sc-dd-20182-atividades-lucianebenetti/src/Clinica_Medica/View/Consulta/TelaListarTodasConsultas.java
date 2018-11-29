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
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Clinica_Medica.Controller.ConsultaController;
import Clinica_Medica.VO.ConsultaVO;
import Clinica_Medica.VO.ConvenioVO;

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
				ConsultaController consultaController = new ConsultaController();
				List<ConsultaVO> consultas = consultaController.listarTodasConsultas();
				atualizarTabelaConsultas(consultas);
				
			}
		});
		btnListarTodasConsultas.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnListarTodasConsultas.setBounds(658, 41, 238, 31);
		add(btnListarTodasConsultas);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(275, 94, 1012, 10);
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
		btnSair.setBounds(1210, 528, 92, 31);
		add(btnSair);
		
		JLabel lblConsultas = new JLabel("Consultas");
		lblConsultas.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblConsultas.setBounds(275, 133, 113, 22);
		add(lblConsultas);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(275, 181, 1025, 243);
		add(scrollPane);
		
		tbConsultas = new JTable();
		scrollPane.setViewportView(tbConsultas);
		tbConsultas.setEnabled(false);
		tbConsultas.setModel(new DefaultTableModel(
			new Object[][] {
				{"ID", "Nome Paciente", "Convenio", "Data Consulta", "Horario"},
			},
			new String[] {
				"ID", "Nome Paciente", "Convenio", "Data Consulta", "Horario"
			}
		));
		tbConsultas.setFont(new Font("Tahoma", Font.PLAIN, 18));

	}
	
	private void atualizarTabelaConsultas(List<ConsultaVO> consultas) {
		tbConsultas.setModel(new DefaultTableModel(new Object[][] { { "ID", "Nome Paciente", "Convenio", "Data Consulta", "Horario"}, },
				new String[] {"ID", "Nome Paciente", "Convenio", "Data Consulta", "Horario"}));

		DefaultTableModel modelo = (DefaultTableModel) tbConsultas.getModel();

		for (ConsultaVO consulta : consultas) {
			// Crio uma nova linha na tabela
			// Preencher a linha com os atributos do produto
			// na ORDEM do cabeçalho da tabela
			Object[] novaLinha = new Object[] { consulta.getCodigoConsulta(), consulta.getPacienteVO().getNomePaciente(), 
					consulta.getConvenioVO().getNomeConvenio(), consulta.getDataConsulta(), consulta.getHorarioConsulta(),

			};
			modelo.addRow(novaLinha);
		}
	}
}
