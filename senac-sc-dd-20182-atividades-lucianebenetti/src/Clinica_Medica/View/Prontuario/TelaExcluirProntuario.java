package Clinica_Medica.View.Prontuario;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JSeparator;
import com.toedter.calendar.JDateChooser;

import Clinica_Medica.Controller.ConvenioController;
import Clinica_Medica.Controller.ProntuarioController;
import Clinica_Medica.VO.ConvenioVO;
import Clinica_Medica.VO.EspecialidadeVO;
import Clinica_Medica.VO.ProntuarioVO;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Panel;
import java.awt.SystemColor;

public class TelaExcluirProntuario extends JPanel {
	private JTextField txtNome;
	private JTextField txtIdProntuario;
	private static final String MASCARA_CPF = "###.###.###-##";
	private JTable tbProntuarios;
	private ProntuarioVO prontuario = new ProntuarioVO();

	/**
	 * Create the panel.
	 */
	public TelaExcluirProntuario() {
		setBackground(new Color(173, 216, 230));
		setLayout(null);

		JButton btnLimparTela = new JButton("Limpar Tela");
		btnLimparTela.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				limparTela();
			}
		});

		btnLimparTela.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnLimparTela.setBounds(410, 495, 132, 31);
		add(btnLimparTela);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ProntuarioController controlador = new ProntuarioController();
				ProntuarioVO prontuarioExcluido = construirProntuario();
				controlador.excluirProntuario(prontuarioExcluido);
				JOptionPane.showMessageDialog(null, "Prontuário excluído!");
			
				limparTela();
			}
		});
		btnExcluir.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnExcluir.setBounds(880, 495, 97, 31);
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
		btnSair.setBounds(1290, 495, 97, 30);
		add(btnSair);

		JLabel lblNomePaciente = new JLabel("Nome Paciente");
		lblNomePaciente.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNomePaciente.setBounds(410, 435, 120, 25);
		add(lblNomePaciente);

		txtNome = new JTextField();
		txtNome.setEditable(false);
		txtNome.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtNome.setBounds(550, 434, 395, 25);
		add(txtNome);
		txtNome.setColumns(10);

		JLabel lblIdProntuario = new JLabel("ID Prontuario");
		lblIdProntuario.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblIdProntuario.setBounds(410, 383, 125, 25);
		add(lblIdProntuario);

		txtIdProntuario = new JTextField();
		txtIdProntuario.setEditable(false);
		txtIdProntuario.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtIdProntuario.setBounds(550, 382, 86, 25);
		add(txtIdProntuario);
		txtIdProntuario.setColumns(10);

		JSeparator separator = new JSeparator();
		separator.setBounds(418, 335, 969, 9);
		add(separator);

		JButton btnBuscarProntuarios = new JButton("Buscar Prontuarios");
		btnBuscarProntuarios.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				ProntuarioController controladorProntuarios = new ProntuarioController();
				List<ProntuarioVO> prontuarios =  controladorProntuarios.listarTodosProntuarios();
				atualizarTabelaProntuarios(prontuarios);

				
			}
		});
		btnBuscarProntuarios.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnBuscarProntuarios.setBounds(802, 72, 211, 43);
		add(btnBuscarProntuarios);
		
		Panel panel = new Panel();
		panel.setBackground(SystemColor.menu);
		panel.setBounds(361, 39, 4, 485);
		add(panel);
				
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(410, 116, 975, 187);
				add(scrollPane);
		
				tbProntuarios = new JTable();
				scrollPane.setViewportView(tbProntuarios);
				tbProntuarios.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {

						int selecionado = tbProntuarios.getSelectedRow();

						txtIdProntuario.setText(tbProntuarios.getValueAt(selecionado, 0) + "");
						txtNome.setText((String) tbProntuarios.getValueAt(selecionado, 1));

					}
				});
				tbProntuarios.setModel(
						new DefaultTableModel(new Object[][] { { "ID", "Paciente", "Medicamentos", "Exames", "Registro" }, },
								new String[] { "ID", "Paciente", "Medicamentos", "Exames", "Registro" }));
				tbProntuarios.setFont(new Font("Tahoma", Font.PLAIN, 16));

	}



	protected void limparTela() {

		txtIdProntuario.setText("");
		txtNome.setText("");
		
	
		limparTabela() ;

	}

	protected ProntuarioVO construirProntuario() {

		prontuario.setCodigoProntuario(Integer.parseInt(txtIdProntuario.getText()));

		return prontuario;

	}
	private void limparTabela() {
		int linhas = 0;
		int colunas = 0;
		String zer = null;

		for (linhas = 0; linhas <= tbProntuarios.getRowCount() - 1; linhas++) {
			for (colunas = 0; colunas <= tbProntuarios.getColumnCount() - 1; colunas++) {
				tbProntuarios.setValueAt(zer, linhas, colunas);
			}
		}
	
	}
	
	private void atualizarTabelaProntuarios(List<ProntuarioVO> prontuarios) {
		tbProntuarios.setModel(new DefaultTableModel(new Object[][] { { "ID Prontuario", "Paciente", "Medicamentos", "Exames", "Registro" }, },
				new String[] { "ID Prontuario", "Paciente", "Medicamentos", "Exames", "Registro"}));

		DefaultTableModel modelo = (DefaultTableModel) tbProntuarios.getModel();

		for (ProntuarioVO prontuario : prontuarios) {
			// Crio uma nova linha na tabela
			// Preencher a linha com os atributos do produto
			// na ORDEM do cabeçalho da tabela
			Object[] novaLinha = new Object[] { prontuario.getCodigoProntuario(), 
					prontuario.getConsulta().getPacienteVO().getNomePaciente(),
					prontuario.getMedicamento(), prontuario.getExame(), prontuario.getRegistro()
			};
			modelo.addRow(novaLinha);
		}
	}

}
