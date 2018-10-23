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
		
		tbConvenio = new JTable();
		tbConvenio.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tbConvenio.setModel(new DefaultTableModel(
			new Object[][] {
				{"ID", "Nome", "CNPJ", "Valor"},
			},
			new String[] {
				"ID", "Nome", "CNPJ", "Valor"
			}
		));
		tbConvenio.setBounds(22, 90, 681, 181);
		add(tbConvenio);
		
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
		btnSair.setBounds(621, 329, 94, 31);
		add(btnSair);
		
		JLabel lblConvenios = new JLabel("Convenios");
		lblConvenios.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblConvenios.setBounds(22, 66, 102, 22);
		add(lblConvenios);

	}
}
