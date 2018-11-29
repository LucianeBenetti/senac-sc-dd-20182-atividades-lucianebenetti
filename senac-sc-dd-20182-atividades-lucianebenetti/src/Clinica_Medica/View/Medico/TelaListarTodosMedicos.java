package Clinica_Medica.View.Medico;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Clinica_Medica.Controller.MedicoController;
import Clinica_Medica.VO.EspecialidadeVO;
import Clinica_Medica.VO.MedicoVO;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JLabel;

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
				List<MedicoVO> medicos = controlador.listarTodosMedicos();
				atualizarTabelaMedicos(medicos);
			}
		});
		btnListarTodosOs.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnListarTodosOs.setBounds(668, 81, 280, 40);
		add(btnListarTodosOs);
		
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
		btnSair.setBounds(1338, 455, 96, 31);
		add(btnSair);
		
		JLabel lblMedicos = new JLabel("Medicos");
		lblMedicos.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMedicos.setBounds(177, 125, 120, 22);
		add(lblMedicos);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(177, 160, 1255, 266);
		add(scrollPane);
		
		tbMedicos = new JTable();
		scrollPane.setViewportView(tbMedicos);
		tbMedicos.setEnabled(false);
		tbMedicos.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tbMedicos.setModel(new DefaultTableModel(
			new Object[][] {
				{"Nome", "CRM", "CPF", "CNPJ", "Celular", "Whats App", "e-mail"},
			},
			new String[] {
				"Nome", "CRM", "CPF", "CNPJ", "Celular", "Whats App", "e-mail"
			}
		));

	}
	
	private void atualizarTabelaMedicos(List<MedicoVO> medicos) {
		tbMedicos.setModel(new DefaultTableModel(new Object[][] { { "Nome", "CRM", "CPF", "CNPJ", "Celular", "Whats App", "e-mail" }, },
				new String[] { "Nome", "CRM", "CPF", "CNPJ", "Celular", "Whats App", "e-mail" }));

		DefaultTableModel modelo = (DefaultTableModel) tbMedicos.getModel();

		for (MedicoVO medico: medicos) {
			// Crio uma nova linha na tabela
			// Preencher a linha com os atributos do produto
			// na ORDEM do cabeçalho da tabela
			Object[] novaLinha = new Object[] {  medico.getNomeMedico(), medico.getCrm(),
					medico.getCpfMedico(), medico.getCnpjMedico(), medico.getCelularMedico(), 
					medico.getWhatsAppMedico(), medico.getEmailMedico(),


			};
			modelo.addRow(novaLinha);
		}
	}

}
