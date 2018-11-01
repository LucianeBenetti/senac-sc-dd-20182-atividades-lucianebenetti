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
				ArrayList<EspecializacaoVO> especializacoes = (ArrayList<EspecializacaoVO>) controlador.listarTodasEspecializacoes();

				DefaultTableModel tabela = (DefaultTableModel) tbEspecializacoes.getModel();
				for (EspecializacaoVO especializacao : especializacoes) {
					tabela.addRow(new Object[] { especializacao.getCodigoEspecializacao(), especializacao.getMedicoVO().getNomeMedico(), especializacao.getEspecialidadeVO().getNomeEspecialidade(),
							especializacao.getAnoEspecializacao()
				
					});
				}
			}
		});
		btnListarTodasEspecializacoes.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnListarTodasEspecializacoes.setBounds(188, 24, 281, 31);
		add(btnListarTodasEspecializacoes);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 86, 568, 9);
		add(separator);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				int opcao;
                Object[] BtSair={"Sim","Não"};
                 
                opcao = JOptionPane.showOptionDialog(null,"Deseja sair desta operação?", 
                        "Fechar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                        null, BtSair, BtSair[0]);
                        if(opcao == JOptionPane.YES_OPTION) {
                        	 setVisible(false);
                        }
			}
		});
		btnSair.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSair.setBounds(510, 383, 95, 31);
		add(btnSair);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 154, 568, 160);
		add(scrollPane);
		
		tbEspecializacoes = new JTable();
		tbEspecializacoes.setModel(new DefaultTableModel(
			new Object[][] {
				{"ID", "Medico", "Especialidade", "Ano"},
			},
			new String[] {
				"ID", "Medico", "Especialidade", "Ano"
			}
		));
		tbEspecializacoes.setFont(new Font("Tahoma", Font.PLAIN, 18));
		scrollPane.setViewportView(tbEspecializacoes);
		
		JLabel lblEspecializacoes = new JLabel("Especializacoes");
		lblEspecializacoes.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEspecializacoes.setBounds(23, 130, 132, 22);
		add(lblEspecializacoes);

	}
}
