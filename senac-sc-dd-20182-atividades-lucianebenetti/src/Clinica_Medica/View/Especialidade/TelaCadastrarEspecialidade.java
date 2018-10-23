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
		lblBuscarNome.setBounds(10, 23, 66, 22);
		add(lblBuscarNome);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNome.setBounds(10, 259, 66, 22);
		add(lblNome);

		JLabel lblInstituicao = new JLabel("Instituicao");
		lblInstituicao.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblInstituicao.setBounds(10, 323, 92, 22);
		add(lblInstituicao);

		tbEspecialidade = new JTable();
		tbEspecialidade.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int selecionado = tbEspecialidade.getSelectedRow();   
				
				txtId.setText(tbEspecialidade.getValueAt(selecionado,0) + " ");
				txtNome.setText((String) tbEspecialidade.getValueAt(selecionado,1));
				txtInstituicao.setText((String) tbEspecialidade.getValueAt(selecionado,2));
							
			}
		});
		tbEspecialidade.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tbEspecialidade.setModel(new DefaultTableModel(new Object[][] { { "ID", "Nome", "Instituição" }, },
				new String[] { "ID", "Nome", "Instituição" }));
		tbEspecialidade.setBounds(10, 56, 588, 131);
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
		btnSair.setBounds(475, 390, 120, 31);
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
		btnCadastrar.setBounds(325, 390, 129, 31);
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
				}else {
					JOptionPane.showMessageDialog(null, "Especialidade não encontrada!!");
				}
				
			}
		});
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnBuscar.setBounds(509, 19, 89, 31);
		add(btnBuscar);

		txtBuscarNome = new JTextField();
		txtBuscarNome.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtBuscarNome.setBounds(66, 11, 391, 36);
		add(txtBuscarNome);
		txtBuscarNome.setColumns(10);

		txtNome = new JTextField();
		txtNome.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtNome.setColumns(10);
		txtNome.setBounds(112, 258, 486, 33);
		add(txtNome);

		txtInstituicao = new JTextField();
		txtInstituicao.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtInstituicao.setColumns(10);
		txtInstituicao.setBounds(112, 319, 486, 31);
		add(txtInstituicao);

		JButton btnLimparTela = new JButton("Limpar Tela");
		btnLimparTela.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				limparTela();
			}
		});
		btnLimparTela.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnLimparTela.setBounds(10, 389, 144, 32);
		add(btnLimparTela);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				int espCod = 0;				
				EspecialidadeController controlador = new EspecialidadeController();
				EspecialidadeVO especialidade = construirEspecialidade();

				String mensagem = controlador.atualizar(especialidade, espCod);
				JOptionPane.showMessageDialog(null, mensagem);
				limparTela();
				
			}
		});
		btnAlterar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAlterar.setBounds(174, 390, 129, 31);
		add(btnAlterar);
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblId.setBounds(10, 217, 66, 31);
		add(lblId);
		
		txtId = new JTextField();
		txtId.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtId.setBounds(112, 217, 86, 30);
		add(txtId);
		txtId.setColumns(10);

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
			Object[] novaLinha = new Object[] { especialidade.getCodigoEspecialidade(), especialidade.getNomeEspecialidade(),
					especialidade.getInstituicao(),

			};
			modelo.addRow(novaLinha);
		}
	}
}
