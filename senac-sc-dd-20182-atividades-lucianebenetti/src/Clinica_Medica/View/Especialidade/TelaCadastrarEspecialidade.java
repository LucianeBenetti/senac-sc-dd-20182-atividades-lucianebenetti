package Clinica_Medica.View.Especialidade;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;

import Clinica_Medica.BO.EspecialidadeBO;
import Clinica_Medica.Controller.EspecialidadeController;
import Clinica_Medica.VO.EspecialidadeVO;
import javax.swing.JSeparator;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JScrollPane;
import java.awt.Panel;
import java.awt.SystemColor;

public class TelaCadastrarEspecialidade extends JPanel {

	private JTable tbEspecialidade;
	private JTextField txtBuscarNome;
	private JTextField txtNome;
	private JTextField txtInstituicao;
	private String[] nomesColunas = new String[] { "ID", "Nome", "Instituição" };
	private EspecialidadeVO especialidade = new EspecialidadeVO();
	private EspecialidadeVO especialidadeConsultada = new EspecialidadeVO();
	private JTextField txtId;

	/**
	 * Create the panel.
	 */
	public TelaCadastrarEspecialidade() {
		setBackground(new Color(173, 216, 230));
		setLayout(null);

		JLabel lblBuscarNome = new JLabel("Nome");
		lblBuscarNome.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBuscarNome.setBounds(375, 23, 66, 22);
		add(lblBuscarNome);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNome.setBounds(386, 402, 66, 22);
		add(lblNome);

		JLabel lblInstituicao = new JLabel("Instituicao");
		lblInstituicao.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblInstituicao.setBounds(386, 445, 92, 22);
		add(lblInstituicao);

		JSeparator separator = new JSeparator();
		separator.setBounds(375, 61, 599, 12);
		add(separator);

		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		btnSair.setBounds(854, 523, 120, 31);
		add(btnSair);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				EspecialidadeController controlador = new EspecialidadeController();
				EspecialidadeVO especialidade = construirEspecialidade();

				String mensagem = controlador.salvar(especialidade);
				JOptionPane.showMessageDialog(null, mensagem);
				limparTela();
			}
		});
		btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnCadastrar.setBounds(704, 523, 129, 31);
		add(btnCadastrar);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				EspecialidadeController controlador = new EspecialidadeController();
				List<EspecialidadeVO> especialidades = null;

				if (txtBuscarNome.getText() != null) {
					especialidades = controlador.exibirEspecialidadePorNome(txtBuscarNome.getText());
					atualizarTabelaEspecialidades(especialidades);
				}
				if (especialidades.size() == 0) {
					JOptionPane.showMessageDialog(null, "Especialidade não encontrada!!");

				}

			}
		});
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnBuscar.setBounds(880, 19, 89, 31);
		add(btnBuscar);

		txtBuscarNome = new JTextField();
		txtBuscarNome.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtBuscarNome.setBounds(431, 11, 391, 36);
		add(txtBuscarNome);
		txtBuscarNome.setColumns(10);

		txtNome = new JTextField();
		txtNome.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtNome.setColumns(10);
		txtNome.setBounds(488, 397, 486, 33);
		add(txtNome);

		txtInstituicao = new JTextField();
		txtInstituicao.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtInstituicao.setColumns(10);
		txtInstituicao.setBounds(488, 441, 486, 31);
		add(txtInstituicao);

		JButton btnLimparTela = new JButton("Limpar Tela");
		btnLimparTela.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				limparTela();
			}
		});
		btnLimparTela.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnLimparTela.setBounds(389, 522, 144, 32);
		add(btnLimparTela);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 174, 569, -92);
		add(scrollPane);

		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAlterar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				int codigo = Integer.parseInt(txtId.getText());
				EspecialidadeController controlador = new EspecialidadeController();
				EspecialidadeVO especialidade = construirEspecialidade();

				String codigoEsp = txtId.getText();
				if (codigoEsp.trim() != "") {
					especialidade.setCodigoEspecialidade(Integer.parseInt(codigoEsp));
				}

				controlador.atualizar(especialidade, codigo);
				if (controlador != null) {
					JOptionPane.showMessageDialog(null, "Especialidade alterada com sucesso!");
					limparTela();
				} else {
					JOptionPane.showMessageDialog(null, "Não foi possível alterar Especialidade!");
				}

			}
		});
		btnAlterar.setBounds(568, 523, 110, 31);
		add(btnAlterar);

		txtId = new JTextField();
		txtId.setEditable(false);
		txtId.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtId.setBounds(488, 353, 86, 33);
		add(txtId);
		txtId.setColumns(10);

		JLabel lblid = new JLabel("ID");
		lblid.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblid.setBounds(386, 360, 59, 31);
		add(lblid);

		Panel panel = new Panel();
		panel.setBackground(SystemColor.menu);
		panel.setBounds(315, 11, 4, 543);
		add(panel);
				
				JScrollPane scrollPane_1 = new JScrollPane();
				scrollPane_1.setBounds(375, 66, 597, 250);
				add(scrollPane_1);
		
				tbEspecialidade = new JTable();
				scrollPane_1.setViewportView(tbEspecialidade);
				tbEspecialidade.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						int selecionado = tbEspecialidade.getSelectedRow();

						txtId.setText(tbEspecialidade.getValueAt(selecionado, 0) + "");
						txtNome.setText((String) tbEspecialidade.getValueAt(selecionado, 1));
						txtInstituicao.setText((String) tbEspecialidade.getValueAt(selecionado, 2));

					}
				});
				tbEspecialidade.setFont(new Font("Tahoma", Font.PLAIN, 18));
				tbEspecialidade.setModel(new DefaultTableModel(new Object[][] { { "ID", "Nome", "Instituição" }, },
						new String[] { "ID", "Nome", "Instituição" }));

	}

	protected EspecialidadeVO construirEspecialidade() {

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
