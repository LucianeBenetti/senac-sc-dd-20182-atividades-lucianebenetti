package Clinica_Medica.View.Medico;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Clinica_Medica.Controller.MedicoController;
import Clinica_Medica.VO.MedicoVO;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class TelaListarTodosMedicos extends JPanel {
	private JTable tbMedicos;

	/**
	 * Create the panel.
	 */
	public TelaListarTodosMedicos() {
		setBackground(new Color(173, 216, 230));
		setLayout(null);
		
		JButton btnListarTodosOs = new JButton("Listar Todos os Medicos");
		btnListarTodosOs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MedicoController controlador = new MedicoController();
				ArrayList<MedicoVO> medicos = (ArrayList<MedicoVO>) controlador.listarTodosMedicos();

				DefaultTableModel tabela = (DefaultTableModel) tbMedicos.getModel();
				for (MedicoVO medico : medicos) {
					tabela.addRow(new Object[] { medico.getNomeMedico(), medico.getCrm(),
							medico.getCpfMedico(), medico.getCnpjMedico(), medico.getCelularMedico(), medico.getCelMensagemMedico(), medico.getEmailMedico()

					});
				}
			}
		});
		btnListarTodosOs.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnListarTodosOs.setBounds(226, 31, 280, 40);
		add(btnListarTodosOs);
		
		tbMedicos = new JTable();
		tbMedicos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tbMedicos.setModel(new DefaultTableModel(
			new Object[][] {
				{"Nome", "CRM", "CPF", "CNPJ", "Celular", "Whats App", "e-mail"},
			},
			new String[] {
				"Nome", "CRM", "CPF", "CNPJ", "Celular", "Whats App", "e-mail"
			}
		));
		tbMedicos.setBounds(10, 110, 811, 303);
		add(tbMedicos);
		
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
		btnSair.setBounds(714, 447, 96, 31);
		add(btnSair);

	}

}
