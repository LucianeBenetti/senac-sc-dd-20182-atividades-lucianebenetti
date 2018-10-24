package Clinica_Medica.View.Convenio;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Clinica_Medica.Controller.ConvenioController;
import Clinica_Medica.VO.ConvenioVO;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

public class TelaListarTodosConvenios extends JPanel {
	private JTable tbConvenio;

	/**
	 * Create the panel.
	 */
	public TelaListarTodosConvenios() {
		setBackground(new Color(173, 216, 230));
		setLayout(null);
		
		JButton btnListarTodosConvenios = new JButton("Listar Todos Convenios");
		btnListarTodosConvenios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				ConvenioController controlador = new ConvenioController();
				ArrayList<ConvenioVO> convenios = (ArrayList<ConvenioVO>) controlador.listarTodosConvenios();

				DefaultTableModel tabela = (DefaultTableModel) tbConvenio.getModel();
				for (ConvenioVO convenio : convenios) {
					tabela.addRow(new Object[] { convenio.getCodigoConvenio(), convenio.getNomeConvenio(),
							convenio.getCnpjConvenio(), convenio.getValor()
				
					});
				}
			}
		});
		btnListarTodosConvenios.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnListarTodosConvenios.setBounds(258, 24, 226, 31);
		add(btnListarTodosConvenios);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
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
		btnSair.setBounds(621, 329, 94, 31);
		add(btnSair);
		
		JLabel lblConvenios = new JLabel("Convenios");
		lblConvenios.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblConvenios.setBounds(22, 66, 102, 22);
		add(lblConvenios);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(32, 99, 681, 157);
		add(scrollPane);
		
		tbConvenio = new JTable();
		scrollPane.setViewportView(tbConvenio);
		tbConvenio.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tbConvenio.setModel(new DefaultTableModel(
			new Object[][] {
				{"ID", "Nome", "CNPJ", "Valor"},
			},
			new String[] {
				"ID", "Nome", "CNPJ", "Valor"
			}
		));

	}
}
