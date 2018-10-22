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

public class TelaListarTodosProntuarios extends JPanel {
	private JTable tbProntuarios;

	/**
	 * Create the panel.
	 */
	public TelaListarTodosProntuarios() {
		setLayout(null);

		JButton btnListarTodosProntuarios = new JButton("Listar Todos Prontuarios");
		btnListarTodosProntuarios.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				ProntuarioController controlador = new ProntuarioController();
				ArrayList<ProntuarioVO> prontuarios = (ArrayList<ProntuarioVO>) controlador.listarTodosProntuarios();

				DefaultTableModel tabela = (DefaultTableModel) tbProntuarios.getModel();
				for (ProntuarioVO prontuario : prontuarios) {
					tabela.addRow(new Object[] { prontuario.getPronCod(), prontuario.getMedicamento(),
							prontuario.getExame(), prontuario.getRegistro()

					});
				}

			}
		});
		btnListarTodosProntuarios.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnListarTodosProntuarios.setBounds(147, 26, 273, 44);
		add(btnListarTodosProntuarios);

		JLabel lblProntuarios = new JLabel("Prontuarios");
		lblProntuarios.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblProntuarios.setBounds(21, 106, 138, 22);
		add(lblProntuarios);

		tbProntuarios = new JTable();
		tbProntuarios.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tbProntuarios.setModel(new DefaultTableModel(new Object[][] { { "ID", "Medicamento", "Exames", "Registro" }, },
				new String[] { "ID", "Medicamento", "Exames", "Registro" }));
		tbProntuarios.setBounds(21, 157, 565, 224);
		add(tbProntuarios);

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
		btnSair.setBounds(471, 419, 115, 31);
		add(btnSair);

	}

}
