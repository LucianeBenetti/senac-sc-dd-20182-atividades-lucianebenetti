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
import java.util.List;

import javax.swing.JLabel;

public class TelaListarTodasEspecialidades extends JPanel {
	private JTable tbEspecialidades;

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
				List<EspecialidadeVO> especialidades = controlador.listarTodasEspecialidades();
				atualizarTabelaEspecialidades(especialidades);

			}
		});
		btnListarTodasEspecialidades.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnListarTodasEspecialidades.setBounds(627, 104, 276, 31);
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
		btnSair.setBounds(1077, 492, 89, 31);
		add(btnSair);
		
		JLabel lblEspecialidades = new JLabel("Especialidades");
		lblEspecialidades.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEspecialidades.setBounds(362, 145, 142, 23);
		add(lblEspecialidades);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(372, 169, 799, 296);
		add(scrollPane);
		
		tbEspecialidades = new JTable();
		scrollPane.setViewportView(tbEspecialidades);
		tbEspecialidades.setModel(new DefaultTableModel(
			new Object[][] {
				{"ID", "Nome", "Instituicao"},
			},
			new String[] {
				"ID", "Nome", "Instituicao"
			}
		));
		tbEspecialidades.setFont(new Font("Tahoma", Font.PLAIN, 16));

	}
	
	private void atualizarTabelaEspecialidades(List<EspecialidadeVO> especialidades) {
		tbEspecialidades.setModel(new DefaultTableModel(new Object[][] { { "ID", "Nome", "Instituição" }, },
				new String[] { "ID", "Nome", "Instituição" }));

		DefaultTableModel modelo = (DefaultTableModel) tbEspecialidades.getModel();

		for (EspecialidadeVO especialidade : especialidades) {
			// Crio uma nova linha na tabela
			// Preencher a linha com os atributos do produto
			// na ORDEM do cabeçalho da tabela
			Object[] novaLinha = new Object[] { especialidade.getCodigoEspecialidade(),
					especialidade.getNomeEspecialidade(), especialidade.getInstituicao(),

			};
			modelo.addRow(novaLinha);
		}
	}

}
