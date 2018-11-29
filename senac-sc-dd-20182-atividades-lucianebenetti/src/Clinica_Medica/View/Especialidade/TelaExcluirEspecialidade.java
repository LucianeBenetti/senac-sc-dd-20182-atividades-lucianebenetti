package Clinica_Medica.View.Especialidade;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JSeparator;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import Clinica_Medica.Controller.EspecialidadeController;
import Clinica_Medica.VO.EspecialidadeVO;
import java.awt.Panel;
import java.awt.SystemColor;

public class TelaExcluirEspecialidade extends JPanel {
	private JTextField txtBuscarNome;
	private JTable tbEspecialidade;
	private JTextField txtId;
	private JTextField txtNome;
	private JTextField txtInstituicao;
	private String[] nomesColunas = new String[] { "ID", "Nome", "Instituição" };
	private EspecialidadeVO especialidade = new EspecialidadeVO();
	

	/**
	 * Create the panel.
	 */
	public TelaExcluirEspecialidade() {
		setBackground(new Color(173, 216, 230));
		setLayout(null);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				EspecialidadeController controlador = new EspecialidadeController();
				List<EspecialidadeVO> especialidades = null;

				if (txtBuscarNome.getText() != null) {
					especialidades = controlador.exibirEspecialidadePorNome(txtBuscarNome.getText());
					atualizarTabelaEspecialidades(especialidades);
				} else {
					JOptionPane.showMessageDialog(null, "Especialidade não encontrada!!");
				}

			}
		});
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnBuscar.setBounds(1010, 18, 89, 31);
		add(btnBuscar);

		JButton btnNewButton_1 = new JButton("Limpar Tela");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				limparTela();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_1.setBounds(375, 563, 144, 31);
		add(btnNewButton_1);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				EspecialidadeController controlador = new EspecialidadeController();
				EspecialidadeVO especialidadeExcluida = construirEspecialidade();
				controlador.excluirEspecialidadeVO(especialidadeExcluida);
				JOptionPane.showMessageDialog(null, "Especialidade excluída!");
				limparTela();
			}
		});
		btnExcluir.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnExcluir.setBounds(715, 563, 100, 31);
		add(btnExcluir);

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
		btnSair.setBounds(1023, 563, 89, 31);
		add(btnSair);

		JSeparator separator = new JSeparator();
		separator.setBounds(362, 73, 750, 11);
		add(separator);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNome.setBounds(362, 19, 77, 28);
		add(lblNome);

		txtBuscarNome = new JTextField();
		txtBuscarNome.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtBuscarNome.setBounds(428, 18, 452, 31);
		add(txtBuscarNome);
		txtBuscarNome.setColumns(10);

		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(375, 335, 55, 31);
		add(lblNewLabel);

		JLabel lblNome_1 = new JLabel("Nome");
		lblNome_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNome_1.setBounds(375, 400, 58, 32);
		add(lblNome_1);

		JLabel lblInstituicao = new JLabel("Instituicao");
		lblInstituicao.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblInstituicao.setBounds(375, 480, 89, 23);
		add(lblInstituicao);

		txtId = new JTextField();
		txtId.setEditable(false);
		txtId.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtId.setBounds(486, 336, 89, 28);
		add(txtId);
		txtId.setColumns(10);

		txtNome = new JTextField();
		txtNome.setEditable(false);
		txtNome.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtNome.setBounds(481, 402, 498, 29);
		add(txtNome);
		txtNome.setColumns(10);

		txtInstituicao = new JTextField();
		txtInstituicao.setEditable(false);
		txtInstituicao.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtInstituicao.setBounds(481, 476, 498, 31);
		add(txtInstituicao);
		txtInstituicao.setColumns(10);
		
		Panel panel = new Panel();
		panel.setBackground(SystemColor.menu);
		panel.setBounds(299, 18, 4, 576);
		add(panel);
				
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(362, 84, 748, 212);
				add(scrollPane);
		
				tbEspecialidade = new JTable();
				scrollPane.setViewportView(tbEspecialidade);
				tbEspecialidade.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {

						int selecionado = tbEspecialidade.getSelectedRow();

						txtId.setText(tbEspecialidade.getValueAt(selecionado, 0) + "");
						txtNome.setText((String) tbEspecialidade.getValueAt(selecionado, 1));
						txtInstituicao.setText((String) tbEspecialidade.getValueAt(selecionado, 2));
					}
				});
				tbEspecialidade.setModel(new DefaultTableModel(new Object[][] { { "ID", "Nome", "Instituicao" }, },
						new String[] { "ID", "Nome", "Instituicao" }));
				tbEspecialidade.setFont(new Font("Tahoma", Font.PLAIN, 18));

	}

	protected EspecialidadeVO construirEspecialidade() {

		especialidade.setCodigoEspecialidade(Integer.parseInt(txtId.getText()));
		especialidade.setNomeEspecialidade(txtNome.getText());
		especialidade.setInstituicao(txtInstituicao.getText());

		return especialidade;
	}

	protected void limparTela() {
		txtBuscarNome.setText("");
		txtNome.setText("");
		txtInstituicao.setText("");
		txtId.setText("");

		limparTabela();

	}

	private void limparTabela() {
		int linhas = 0;
		int colunas = 0;
		String zer = null;

		for (linhas = 0; linhas <= tbEspecialidade.getRowCount() - 1; linhas++) {
			for (colunas = 0; colunas <= tbEspecialidade.getColumnCount() - 1; colunas++) {
				tbEspecialidade.setValueAt(zer, linhas, colunas);
			}
		}
	}

	private void atualizarTabelaEspecialidades(List<EspecialidadeVO> especialidades) {
		tbEspecialidade.setModel(new DefaultTableModel(new Object[][] { { "ID", "Nome", "Instituição" }, },
				new String[] { "ID", "Nome", "Instituição" }));

		DefaultTableModel modelo = (DefaultTableModel) tbEspecialidade.getModel();

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
