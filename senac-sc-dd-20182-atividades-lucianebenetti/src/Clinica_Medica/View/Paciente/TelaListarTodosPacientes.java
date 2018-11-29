package Clinica_Medica.View.Paciente;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Clinica_Medica.Controller.PacienteController;
import Clinica_Medica.VO.MedicoVO;
import Clinica_Medica.VO.PacienteVO;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JLabel;

public class TelaListarTodosPacientes extends JPanel {
	private JTable tbPacientes;

	/**
	 * Create the panel.
	 */
	public TelaListarTodosPacientes() {
		setBackground(new Color(173, 216, 230));
		setLayout(null);
		
		JButton btnListarTodosPacientes = new JButton("Listar Todos Pacientes");
		btnListarTodosPacientes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				PacienteController controlador = new PacienteController();
				List<PacienteVO> pacientes = controlador.listarTodosPacientes();
				atualizarTabelaPacientes(pacientes);
			}
		});
		btnListarTodosPacientes.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnListarTodosPacientes.setBounds(521, 67, 324, 36);
		add(btnListarTodosPacientes);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
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
		btnSair.setBounds(1150, 439, 90, 36);
		add(btnSair);
		
		JLabel lblPacientes = new JLabel("Pacientes");
		lblPacientes.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPacientes.setBounds(179, 110, 124, 22);
		add(lblPacientes);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(179, 130, 1063, 285);
		add(scrollPane);
		
		tbPacientes = new JTable();
		scrollPane.setViewportView(tbPacientes);
		tbPacientes.setEnabled(false);
		tbPacientes.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tbPacientes.setModel(new DefaultTableModel(
			new Object[][] {
				{"Nome", "CPF", "CNPJ", "Celular", "Fone Residencial", "Fone Comercial", "e-mail"},
			},
			new String[] {
				"Nome", "CPF", "CNPJ", "Celular", "Fone Residencial", "Fone Comercial", "e-mail"
			}
		));

	}

	private void atualizarTabelaPacientes(List<PacienteVO> pacientes) {
		tbPacientes.setModel(new DefaultTableModel(new Object[][] { {"Nome", "CPF", "CNPJ", "Celular", "Fone Residencial", "Fone Comercial", "e-mail"}, },
				new String[] { "Nome", "CPF", "CNPJ", "Celular", "Fone Residencial", "Fone Comercial", "e-mail" }));

		DefaultTableModel modelo = (DefaultTableModel) tbPacientes.getModel();

		for (PacienteVO paciente: pacientes) {
			// Crio uma nova linha na tabela
			// Preencher a linha com os atributos do produto
			// na ORDEM do cabeçalho da tabela
			Object[] novaLinha = new Object[] { paciente.getNomePaciente(), paciente.getCpfPaciente(),
					paciente.getCnpjPaciente(), paciente.getWhatsAppPaciente(), paciente.getFoneResidencial(), 
					paciente.getFoneComercial(), paciente.getEmailPaciente(),


			};
			modelo.addRow(novaLinha);
		}
	}
}
