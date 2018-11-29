package Clinica_Medica.View.Especializacao;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Clinica_Medica.Controller.EspecializacaoController;
import Clinica_Medica.VO.EspecialidadeVO;
import Clinica_Medica.VO.EspecializacaoVO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class TelaListarTodasEspecializacoes extends JPanel {
	private JTable tbEspecializacoes;

	/**
	 * Create the panel.
	 */
	public TelaListarTodasEspecializacoes() {
		setBackground(new Color(173, 216, 230));
		setLayout(null);

		JButton btnListarTodasEspecializacoes = new JButton("Listar Todas Especializacoes");
		btnListarTodasEspecializacoes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				EspecializacaoController controlador = new EspecializacaoController();
				List<EspecializacaoVO> especializacoes = controlador.listarTodasEspecializacoes();
				atualizarTabelaEspecializacoes(especializacoes);

			}
		});
		btnListarTodasEspecializacoes.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnListarTodasEspecializacoes.setBounds(664, 45, 281, 31);
		add(btnListarTodasEspecializacoes);

		JSeparator separator = new JSeparator();
		separator.setBounds(324, 92, 980, 9);
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
		btnSair.setBounds(1197, 545, 95, 31);
		add(btnSair);

		JLabel lblEspecializacoes = new JLabel("Especializacoes");
		lblEspecializacoes.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEspecializacoes.setBounds(313, 129, 132, 22);
		add(lblEspecializacoes);
				
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(313, 162, 1000, 255);
				add(scrollPane);
		
				tbEspecializacoes = new JTable();
				scrollPane.setViewportView(tbEspecializacoes);
				tbEspecializacoes.setEnabled(false);
				tbEspecializacoes.setModel(
						new DefaultTableModel(new Object[][] { { "ID", "Medico", "Especialidade", "Ano", "Instituicao" }, },
								new String[] { "ID", "Medico", "Especialidade", "Ano", "Instituicao" }));
				tbEspecializacoes.setFont(new Font("Tahoma", Font.PLAIN, 16));

	}

	private void atualizarTabelaEspecializacoes(List<EspecializacaoVO> especializacoes) {
		tbEspecializacoes.setModel(new DefaultTableModel(
				new Object[][] { { "ID", "Nome Medico", "Especialidade", "Ano", "Instituicao" }, },
				new String[] { "ID", "Nome Medico", "Especialidade", "Ano", "Instituicao" }));

		DefaultTableModel modelo = (DefaultTableModel) tbEspecializacoes.getModel();

		for (EspecializacaoVO especializacao : especializacoes) {
			// Crio uma nova linha na tabela
			// Preencher a linha com os atributos
			// na ORDEM do cabeçalho da tabela
			Object[] novaLinha = new Object[] { especializacao.getCodigoEspecializacao(),
					especializacao.getMedicoVO().getNomeMedico(),
					especializacao.getEspecialidadeVO().getNomeEspecialidade(), especializacao.getAnoEspecializacao(),
					especializacao.getEspecialidadeVO().getInstituicao(),

			};
			modelo.addRow(novaLinha);
		}
	}
}
