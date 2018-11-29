package Clinica_Medica.View.Convenio;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Clinica_Medica.BO.ConvenioBO;
import Clinica_Medica.Controller.ConvenioController;
import Clinica_Medica.VO.ConvenioVO;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;

public class TelaListarTodosConvenios extends JPanel {
	private JTable tbConvenio;
	private List<ConvenioVO> conveniosConsultados;
	private JButton btnGerarPlaniha;

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
				List<ConvenioVO> convenios = null;
				convenios= controlador.listarTodosConvenios();
				atualizarTabelaConvenios(convenios);
				
				btnGerarPlaniha.setEnabled(true);

			}
		});
		btnListarTodosConvenios.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnListarTodosConvenios.setBounds(617, 60, 226, 31);
		add(btnListarTodosConvenios);
		
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
		btnSair.setBounds(1035, 417, 94, 31);
		add(btnSair);
		
		JLabel lblConvenios = new JLabel("Convenios");
		lblConvenios.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblConvenios.setBounds(289, 87, 102, 22);
		add(lblConvenios);
		
		btnGerarPlaniha = new JButton("Gerar Planiha");
		btnGerarPlaniha.setEnabled(false);
		btnGerarPlaniha.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnGerarPlaniha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				JFileChooser jfc = new JFileChooser();
				jfc.setDialogTitle("Salvar relatório como...");
				
				int resultado = jfc.showSaveDialog(null);
				if(resultado == JFileChooser.APPROVE_OPTION){
					String caminhoEscolhido = jfc.getSelectedFile().getAbsolutePath();
					
					ConvenioController produtoController = new ConvenioController();
					produtoController.gerarRelatorio(conveniosConsultados, caminhoEscolhido, ConvenioController.TIPO_RELATORIO_XLS);
				}
			}
		});
		
		btnGerarPlaniha.setBounds(772, 418, 144, 29);
		add(btnGerarPlaniha);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(289, 118, 838, 263);
		add(scrollPane);
		
		tbConvenio = new JTable();
		scrollPane.setViewportView(tbConvenio);
		tbConvenio.setEnabled(false);
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
	
	protected void atualizarTabelaConvenios(List<ConvenioVO> convenios) {
		//atualiza o atributo produtosConsultados
		conveniosConsultados = convenios;
		
		//Limpa a tabela
		tbConvenio.setModel(new DefaultTableModel(
				new String[][] {
					{"ID", "Nome", "CNPJ", "Valor"},
				},
				new String[] {
						"ID", "Nome", "CNPJ", "Valor"
				}));
		
		DefaultTableModel modelo = (DefaultTableModel) tbConvenio.getModel();
		
		for(ConvenioVO convenio: convenios) {
			//Crio uma nova linha na tabela
			//Preencher a linha com os atributos do produto
			//na ORDEM do cabeçalho da tabela
			Object[] novaLinha = new Object[] {
					convenio.getCodigoConvenio(),
					convenio.getNomeConvenio(),
					convenio.getCnpjConvenio(),
					convenio.getValor()
			};
			modelo.addRow(novaLinha);
		}

	}
}
