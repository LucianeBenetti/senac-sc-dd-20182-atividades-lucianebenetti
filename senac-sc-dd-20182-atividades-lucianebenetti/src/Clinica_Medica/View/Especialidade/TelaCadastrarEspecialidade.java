package Clinica_Medica.View.Especialidade;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;
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

public class TelaCadastrarEspecialidade extends JPanel {

	private JTable tbEspecialidade;
	private JTextField txtBuscarNome;
	private JTextField txtNome;
	private JTextField txtInstituicao;
	private String[] nomesColunas = new String[] { "ID", "Nome", "Instituição" };
	private EspecialidadeVO especialidade = new EspecialidadeVO();

	/**
	 * Create the panel.
	 */
	public TelaCadastrarEspecialidade() {
		setBackground(new Color(230, 230, 250));
		setLayout(null);

		JLabel lblBuscarNome = new JLabel("Nome");
		lblBuscarNome.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBuscarNome.setBounds(10, 23, 66, 22);
		add(lblBuscarNome);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNome.setBounds(10, 198, 66, 22);
		add(lblNome);

		JLabel lblInstituicao = new JLabel("Instituicao");
		lblInstituicao.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblInstituicao.setBounds(10, 241, 92, 22);
		add(lblInstituicao);

		tbEspecialidade = new JTable();
		tbEspecialidade.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tbEspecialidade.setModel(new DefaultTableModel(new Object[][] { { "ID", "Nome", "Instituição" }, },
				new String[] { "ID", "Nome", "Instituição" }));
		tbEspecialidade.setBounds(10, 56, 492, 131);
		add(tbEspecialidade);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 172, 492, 2);
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
		btnSair.setBounds(382, 291, 120, 31);
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
		btnCadastrar.setBounds(213, 291, 136, 31);
		add(btnCadastrar);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				EspecialidadeController controlador = new EspecialidadeController();
				List<EspecialidadeVO> especialidades = null;

				if (txtBuscarNome.getText() != null) {
					especialidades = controlador.exibirEspecialidadePorNome(txtBuscarNome.getText());
				}
				atualizarTabelaEspecialidades(especialidades);
			}
		});
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnBuscar.setBounds(413, 19, 89, 31);
		add(btnBuscar);

		txtBuscarNome = new JTextField();
		txtBuscarNome.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtBuscarNome.setBounds(66, 23, 337, 24);
		add(txtBuscarNome);
		txtBuscarNome.setColumns(10);

		txtNome = new JTextField();
		txtNome.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtNome.setColumns(10);
		txtNome.setBounds(101, 197, 401, 24);
		add(txtNome);

		txtInstituicao = new JTextField();
		txtInstituicao.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtInstituicao.setColumns(10);
		txtInstituicao.setBounds(101, 239, 401, 24);
		add(txtInstituicao);

		JButton btnLimparTela = new JButton("Limpar Tela");
		btnLimparTela.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				limparTela();
			}
		});
		btnLimparTela.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnLimparTela.setBounds(13, 290, 144, 32);
		add(btnLimparTela);

	}

	protected EspecialidadeVO construirEspecialidade() {

		especialidade.setEspNome(txtNome.getText());
		especialidade.setEspInstituicao(txtInstituicao.getText());

		return especialidade;
	}

	protected void limparTela() {
		txtBuscarNome.setText("");
		txtNome.setText("");
		txtInstituicao.setText("");
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
		tbEspecialidade.setModel(new DefaultTableModel(new Object[][] {}, nomesColunas));

		DefaultTableModel modelo = (DefaultTableModel) tbEspecialidade.getModel();

		for (EspecialidadeVO especialidade : especialidades) {
			// Crio uma nova linha na tabela
			// Preencher a linha com os atributos do produto
			// na ORDEM do cabeçalho da tabela
			Object[] novaLinha = new Object[] { especialidade.getEspCod(), especialidade.getEspNome(),
					especialidade.getEspInstituicao(),

			};
			modelo.addRow(novaLinha);
		}
	}
}
