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
		btnBuscar.setBounds(538, 11, 89, 31);
		add(btnBuscar);

		JButton btnNewButton_1 = new JButton("Limpar Tela");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_1.setBounds(20, 408, 144, 31);
		add(btnNewButton_1);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				EspecialidadeController dao = new EspecialidadeController();
				EspecialidadeVO especialidadeExcluida = construirEspecialidade();
				dao.excluirEspecialidadeVO(especialidadeExcluida);
				JOptionPane.showMessageDialog(null, "Especialidade excluída!");
				limparTela();
			}
		});
		btnExcluir.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnExcluir.setBounds(283, 408, 100, 31);
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
		btnSair.setBounds(538, 408, 89, 31);
		add(btnSair);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 73, 616, 11);
		add(separator);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNome.setBounds(10, 19, 77, 28);
		add(lblNome);

		txtBuscarNome = new JTextField();
		txtBuscarNome.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtBuscarNome.setBounds(76, 11, 316, 31);
		add(txtBuscarNome);
		txtBuscarNome.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 95, 616, 154);
		add(scrollPane);

		tbEspecialidade = new JTable();
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
		scrollPane.setViewportView(tbEspecialidade);

		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(20, 270, 55, 31);
		add(lblNewLabel);

		JLabel lblNome_1 = new JLabel("Nome");
		lblNome_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNome_1.setBounds(17, 312, 58, 32);
		add(lblNome_1);

		JLabel lblInstituicao = new JLabel("Instituicao");
		lblInstituicao.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblInstituicao.setBounds(20, 363, 89, 23);
		add(lblInstituicao);

		txtId = new JTextField();
		txtId.setEditable(false);
		txtId.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtId.setBounds(129, 270, 89, 28);
		add(txtId);
		txtId.setColumns(10);

		txtNome = new JTextField();
		txtNome.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtNome.setBounds(129, 312, 480, 29);
		add(txtNome);
		txtNome.setColumns(10);

		txtInstituicao = new JTextField();
		txtInstituicao.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtInstituicao.setBounds(129, 356, 480, 31);
		add(txtInstituicao);
		txtInstituicao.setColumns(10);

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
