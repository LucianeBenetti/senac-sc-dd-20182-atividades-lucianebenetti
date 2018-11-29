package Clinica_Medica.View.Especializacao;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Clinica_Medica.Controller.EspecialidadeController;
import Clinica_Medica.Controller.EspecializacaoController;
import Clinica_Medica.Controller.MedicoController;
import Clinica_Medica.VO.EspecialidadeVO;
import Clinica_Medica.VO.EspecializacaoVO;
import Clinica_Medica.VO.MedicoVO;

import javax.swing.JSeparator;
import javax.swing.JTable;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.awt.Color;
import java.awt.Panel;
import java.awt.SystemColor;

public class TelaExcluirEspecializacao extends JPanel {
	private JTextField txtNomeMedico;
	private JTextField txtNomeEspecialidade;
	private JTextField txtAno;
	private EspecializacaoVO especializacao = new EspecializacaoVO();
	private MedicoVO medico = new MedicoVO();
	private EspecialidadeVO especialidade = new EspecialidadeVO();
	private JComboBox cbMedico;
	private JComboBox cbEspecialidade;
	private JTextField txtIdEspecializacao;
	private JTable tbEspecializacao;

	/**
	 * Create the panel.
	 */
	public TelaExcluirEspecializacao() {
		setBackground(new Color(173, 216, 230));
		setLayout(null);

		JLabel lblMedico = new JLabel("M\u00E9dico");
		lblMedico.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMedico.setBounds(351, 404, 91, 31);
		add(lblMedico);

		JLabel lblEspecialidade = new JLabel("Especialidade");
		lblEspecialidade.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEspecialidade.setBounds(351, 455, 142, 26);
		add(lblEspecialidade);

		JLabel lblAno = new JLabel("Ano");
		lblAno.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAno.setBounds(351, 515, 46, 31);
		add(lblAno);

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
		btnSair.setBounds(1100, 578, 107, 31);
		add(btnSair);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				EspecializacaoController controlador = new EspecializacaoController();
				EspecializacaoVO especializacaoExcluida = construirEspecializacao();
				controlador.excluirEspecializacao(especializacaoExcluida);
				JOptionPane.showMessageDialog(null, "Especializacao Excluida!!");
				limparTela();
				limparTabela();

			}
		});
		btnExcluir.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnExcluir.setBounds(743, 578, 114, 31);
		add(btnExcluir);

		txtNomeMedico = new JTextField();
		txtNomeMedico.setEditable(false);
		txtNomeMedico.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtNomeMedico.setBounds(531, 402, 440, 31);
		add(txtNomeMedico);
		txtNomeMedico.setColumns(10);

		String[] med = { "----------- Selecione -----------" };
		cbMedico = new JComboBox(med);
		cbMedico.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				preencherMedico();
			}
		});
		cbMedico.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cbMedico.setBounds(491, 11, 366, 34);
		add(cbMedico);

		String[] espec = { "----------- Selecione -----------" };
		cbEspecialidade = new JComboBox(espec);
		cbEspecialidade.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				preencherEspecialidade();
			}

		});
		cbEspecialidade.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cbEspecialidade.setBounds(491, 58, 366, 34);
		add(cbEspecialidade);

		txtNomeEspecialidade = new JTextField();
		txtNomeEspecialidade.setEditable(false);
		txtNomeEspecialidade.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtNomeEspecialidade.setBounds(531, 453, 440, 31);
		add(txtNomeEspecialidade);
		txtNomeEspecialidade.setColumns(10);

		txtAno = new JTextField();
		txtAno.setEditable(false);
		txtAno.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtAno.setBounds(407, 513, 101, 34);
		add(txtAno);
		txtAno.setColumns(10);

		JButton btnLimparTela = new JButton("Limpar Tela");
		btnLimparTela.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				limparTela();
			}
		});
		btnLimparTela.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnLimparTela.setBounds(350, 578, 142, 31);
		add(btnLimparTela);

		JLabel lblBuscarMedico = new JLabel("Medico");
		lblBuscarMedico.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBuscarMedico.setBounds(351, 15, 91, 26);
		add(lblBuscarMedico);

		JLabel lblBuscarEspecialidade = new JLabel("Especialidade");
		lblBuscarEspecialidade.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBuscarEspecialidade.setBounds(351, 62, 118, 26);
		add(lblBuscarEspecialidade);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MedicoVO medicoBuscado;
				EspecialidadeVO especialidadeBuscada;

				medicoBuscado = (MedicoVO) cbMedico.getSelectedItem();
				especialidadeBuscada = (EspecialidadeVO) cbEspecialidade.getSelectedItem();

				EspecialidadeController controlador = new EspecialidadeController();
				MedicoController controllerMedico = new MedicoController();
				EspecializacaoController controllerEspecializacao = new EspecializacaoController();

				List<EspecialidadeVO> especialidades = null;
				List<MedicoVO> medicos = null;

				especialidades = controlador.exibirEspecialidadePorNome(especialidadeBuscada);
				medicos = controllerMedico.exibirMedicoPorNome(medicoBuscado);

				if (especialidades != null && medicos != null) {
					ArrayList<EspecializacaoVO> especializacoes = controllerEspecializacao
							.listarEspecializacoesPorMedicoEspecialidade(medicoBuscado, especialidadeBuscada);
					atualizarTabelaEspecializacoes(especializacoes);
				} else {
					JOptionPane.showMessageDialog(null, "Especialidade não encontrada!!");
				}
			}
		});
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnBuscar.setBounds(1116, 40, 91, 31);
		add(btnBuscar);

		JSeparator separator = new JSeparator();
		separator.setBounds(350, 116, 857, 14);
		add(separator);

		JLabel lblIdEsepcializacao = new JLabel("ID Especializacao");
		lblIdEsepcializacao.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblIdEsepcializacao.setBounds(351, 352, 157, 26);
		add(lblIdEsepcializacao);

		txtIdEspecializacao = new JTextField();
		txtIdEspecializacao.setEditable(false);
		txtIdEspecializacao.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtIdEspecializacao.setBounds(531, 348, 86, 34);
		add(txtIdEspecializacao);
		txtIdEspecializacao.setColumns(10);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(350, 321, 857, 16);
		add(separator_1);
		
		Panel panel = new Panel();
		panel.setBackground(SystemColor.menu);
		panel.setBounds(315, 20, 3, 580);
		add(panel);
				
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(351, 129, 855, 181);
				add(scrollPane);
		
				tbEspecializacao = new JTable();
				scrollPane.setViewportView(tbEspecializacao);
				tbEspecializacao.setFont(new Font("Tahoma", Font.PLAIN, 16));
				tbEspecializacao.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						int selecionado = tbEspecializacao.getSelectedRow();

						txtIdEspecializacao.setText(tbEspecializacao.getValueAt(selecionado, 0) + "");
						txtNomeMedico.setText((String) tbEspecializacao.getValueAt(selecionado, 1));
						txtNomeEspecialidade.setText((String) tbEspecializacao.getValueAt(selecionado, 2));
						txtAno.setText((String) tbEspecializacao.getValueAt(selecionado, 3));
					}
				});
				tbEspecializacao.setModel(new DefaultTableModel(
						new Object[][] { { "ID", "Nome Medico", "Especialidade", "Ano", "Instituicao" }, },
						new String[] { "ID", "Nome Medico", "Especialidade", "Ano", "Instituicao" }));

	}

	protected EspecializacaoVO construirEspecializacao() {

		medico = (MedicoVO) cbMedico.getSelectedItem();
		especialidade = (EspecialidadeVO) cbEspecialidade.getSelectedItem();

		especializacao.setMedicoVO(medico);
		especializacao.setEspecialidadeVO(especialidade);
		especializacao.setAnoEspecializacao(txtAno.getText());
		especializacao.setCodigoEspecializacao(Integer.parseInt(txtIdEspecializacao.getText()));

		return especializacao;
	}

	protected void limparTela() {
		txtAno.setText("");
		txtNomeEspecialidade.setText("");
		txtNomeMedico.setText("");
		cbEspecialidade.setSelectedItem(null);
		cbEspecialidade.setSelectedIndex(0);
		cbMedico.setSelectedItem(null);
		cbMedico.setSelectedIndex(0);
		txtIdEspecializacao.setText("");

		limparTabela();

	}

	protected void preencherMedico() {

		MedicoController controlador = new MedicoController();
		ArrayList<MedicoVO> listaMedico = new ArrayList<MedicoVO>();

		listaMedico = controlador.consultarMedico();
		DefaultComboBoxModel medicos = new DefaultComboBoxModel(listaMedico.toArray());
		cbMedico.setModel(medicos);
		cbMedico.setSelectedItem(null);
		cbMedico.setSelectedIndex(0);

	}

	protected void preencherEspecialidade() {

		EspecialidadeController controlador = new EspecialidadeController();
		ArrayList<EspecialidadeVO> listaEspecialidade = new ArrayList<EspecialidadeVO>();

		listaEspecialidade = controlador.consultarEspecialidade();
		DefaultComboBoxModel especialidades = new DefaultComboBoxModel(listaEspecialidade.toArray());
		cbEspecialidade.setModel(especialidades);
		cbEspecialidade.setSelectedItem(null);
		cbEspecialidade.setSelectedIndex(0);

	}

	private void limparTabela() {
		int linhas = 0;
		int colunas = 0;
		String zer = null;

		for (linhas = 0; linhas <= tbEspecializacao.getRowCount() - 1; linhas++) {
			for (colunas = 0; colunas <= tbEspecializacao.getColumnCount() - 1; colunas++) {
				tbEspecializacao.setValueAt(zer, linhas, colunas);
			}
		}
	}

	private void atualizarTabelaEspecializacoes(List<EspecializacaoVO> especializacoes) {
		tbEspecializacao.setModel(new DefaultTableModel(
				new Object[][] { { "ID", "Nome Medico", "Especialidade", "Ano", "Instituicao" }, },
				new String[] { "ID", "Nome Medico", "Especialidade", "Ano", "Instituicao" }));

		DefaultTableModel modelo = (DefaultTableModel) tbEspecializacao.getModel();

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
