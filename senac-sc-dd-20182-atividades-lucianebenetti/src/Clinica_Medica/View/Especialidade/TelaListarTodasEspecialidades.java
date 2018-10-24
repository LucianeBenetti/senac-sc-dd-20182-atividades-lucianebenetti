package Clinica_Medica.View.Especialidade;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Clinica_Medica.Controller.EspecialidadeController;
import Clinica_Medica.VO.EspecialidadeVO;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JLabel;

public class TelaListarTodasEspecialidades extends JPanel {
	private JTable tbEspecializacoes;

	/**
	 * Create the panel.
	 */
	public TelaListarTodasEspecialidades() {
		setBackground(new Color(173, 216, 230));
		setLayout(null);
		
		JButton btnListarTodasEspecialidades = new JButton("Listar Todas Especialidades");
		btnListarTodasEspecialidades.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				EspecialidadeController controlador = new EspecialidadeController();
				ArrayList<EspecialidadeVO> especialidades = (ArrayList<EspecialidadeVO>) controlador.listarTodosConvenios();

				DefaultTableModel tabela = (DefaultTableModel) tbEspecializacoes.getModel();
				for (EspecialidadeVO especialidade : especialidades) {
					tabela.addRow(new Object[] { especialidade.getCodigoEspecialidade(), especialidade.getNomeEspecialidade(),
							especialidade.getInstituicao()
				
					});
				}
			}
		});
		btnListarTodasEspecialidades.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnListarTodasEspecialidades.setBounds(185, 35, 276, 31);
		add(btnListarTodasEspecialidades);
		
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
		btnSair.setBounds(549, 288, 89, 31);
		add(btnSair);
		
		JLabel lblEspecialidades = new JLabel("Especialidades");
		lblEspecialidades.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEspecialidades.setBounds(36, 84, 142, 23);
		add(lblEspecialidades);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(36, 106, 599, 154);
		add(scrollPane);
		
		tbEspecializacoes = new JTable();
		scrollPane.setViewportView(tbEspecializacoes);
		tbEspecializacoes.setModel(new DefaultTableModel(
			new Object[][] {
				{"ID", "Nome", "Instituicao"},
			},
			new String[] {
				"ID", "Nome", "Instituicao"
			}
		));
		tbEspecializacoes.setFont(new Font("Tahoma", Font.PLAIN, 18));

	}

}
