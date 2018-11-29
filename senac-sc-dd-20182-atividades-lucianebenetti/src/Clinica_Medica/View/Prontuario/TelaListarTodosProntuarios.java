package Clinica_Medica.View.Prontuario;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Clinica_Medica.Controller.ProntuarioController;
import Clinica_Medica.VO.ProntuarioVO;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.awt.Color;
import javax.swing.JScrollPane;

public class TelaListarTodosProntuarios extends JPanel {
	private JTable tbProntuarios;

	/**
	 * Create the panel.
	 */
	public TelaListarTodosProntuarios() {
		setBackground(new Color(173, 216, 230));
		setLayout(null);

		JButton btnListarTodosProntuarios = new JButton("Listar Todos Prontuarios");
		btnListarTodosProntuarios.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				ProntuarioController controladorProntuarios = new ProntuarioController();
				List<ProntuarioVO> prontuarios = controladorProntuarios.listarTodosProntuarios();
				atualizarTabelaProntuarios(prontuarios);

			}
		});
		btnListarTodosProntuarios.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnListarTodosProntuarios.setBounds(718, 99, 273, 44);
		add(btnListarTodosProntuarios);

		JLabel lblProntuarios = new JLabel("Prontuarios");
		lblProntuarios.setBackground(new Color(173, 216, 230));
		lblProntuarios.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblProntuarios.setBounds(281, 127, 150, 31);
		add(lblProntuarios);

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
		btnSair.setBounds(1392, 437, 115, 31);
		add(btnSair);
				
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(281, 154, 1223, 256);
				add(scrollPane);
		
				tbProntuarios = new JTable();
				scrollPane.setViewportView(tbProntuarios);
				tbProntuarios.setEnabled(false);
				tbProntuarios.setFont(new Font("Tahoma", Font.PLAIN, 16));
				tbProntuarios.setModel(
						new DefaultTableModel(new Object[][] { { "ID", " Paciente", "Medicamento", "Exames", "Registro" }, },
								new String[] { "ID", "Paciente", "Medicamento", "Exames", "Registro" }));

	}

	private void atualizarTabelaProntuarios(List<ProntuarioVO> prontuarios) {
		tbProntuarios.setModel(new DefaultTableModel(
				new Object[][] { { "ID Prontuario", "Paciente", "Medicamentos", "Exames", "Registro" }, },
				new String[] { "ID Prontuario", "Paciente", "Medicamentos", "Exames", "Registro" }));

		DefaultTableModel modelo = (DefaultTableModel) tbProntuarios.getModel();

		for (ProntuarioVO prontuario : prontuarios) {
			// Crio uma nova linha na tabela
			// Preencher a linha com os atributos do produto
			// na ORDEM do cabeçalho da tabela
			Object[] novaLinha = new Object[] { prontuario.getCodigoProntuario(),
					prontuario.getConsulta().getPacienteVO().getNomePaciente(), prontuario.getMedicamento(),
					prontuario.getExame(), prontuario.getRegistro() };
			modelo.addRow(novaLinha);
		}
	}
}
