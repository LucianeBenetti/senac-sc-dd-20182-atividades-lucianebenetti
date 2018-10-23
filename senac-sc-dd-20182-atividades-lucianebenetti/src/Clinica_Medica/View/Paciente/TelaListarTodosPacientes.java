package Clinica_Medica.View.Paciente;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Clinica_Medica.Controller.PacienteController;
import Clinica_Medica.VO.PacienteVO;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.Color;

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
				ArrayList<PacienteVO> pacientes = (ArrayList<PacienteVO>) controlador.listarTodosPacientes();

				DefaultTableModel tabela = (DefaultTableModel) tbPacientes.getModel();
				for (PacienteVO paciente : pacientes) {
					tabela.addRow(new Object[] { paciente.getNomePaciente(), paciente.getCpfPaciente(),
							paciente.getCnpjPaciente(), paciente.getCelMensagemPaciente(), paciente.getFoneResidencial(), paciente.getFoneComercial(), paciente.getEmailPaciente()

					});
				}
			}
		});
		btnListarTodosPacientes.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnListarTodosPacientes.setBounds(341, 34, 324, 36);
		add(btnListarTodosPacientes);
		
		tbPacientes = new JTable();
		tbPacientes.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tbPacientes.setModel(new DefaultTableModel(
			new Object[][] {
				{"Nome", "CPF", "CNPJ", "Celular", "Fone Residencial", "Fone Comercial", "e-mail"},
			},
			new String[] {
				"Nome", "CPF", "CNPJ", "Celular", "Fone Residencial", "Fone Comercial", "e-mail"
			}
		));
		tbPacientes.setBounds(10, 109, 857, 264);
		add(tbPacientes);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int opcao;
					Object[] BtSair = { "Sim", "N�o" };

					opcao = JOptionPane.showOptionDialog(null, "Deseja sair desta opera��o?", "Fechar",
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, BtSair, BtSair[0]);
					if (opcao == JOptionPane.YES_OPTION) {
						setVisible(false);
					}
			}
		});
		btnSair.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSair.setBounds(777, 410, 90, 36);
		add(btnSair);

	}

}