package Clinica_Medica.View.Especializacao;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextField;

import Clinica_Medica.Controller.ConvenioController;
import Clinica_Medica.Controller.EspecialidadeController;
import Clinica_Medica.Controller.EspecializacaoController;
import Clinica_Medica.Controller.MedicoController;
import Clinica_Medica.Controller.PacienteController;
import Clinica_Medica.VO.EspecialidadeVO;
import Clinica_Medica.VO.EspecializacaoVO;
import Clinica_Medica.VO.MedicoVO;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;

public class TelaCadastrarEspecializacao extends JPanel {

	private JTextField txtIdMedico;
	private JTextField txtNomeMedico;
	private JTextField txtIdEspecialidade;
	private JTextField txtNomeEspecialidade;
	private JTextField txtAno;
	private EspecializacaoVO especializacao = new EspecializacaoVO();
	private MedicoVO medico = new MedicoVO();
	private EspecialidadeVO especialidade = new EspecialidadeVO();
	private JComboBox cbMedico;
	private JComboBox cbEspecialidade;

	/**
	 * Create the panel.
	 */
	public TelaCadastrarEspecializacao() {
		setBackground(new Color(173, 216, 230));
		setLayout(null);

		JLabel lblMedico = new JLabel("M\u00E9dico");
		lblMedico.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMedico.setBounds(21, 170, 91, 31);
		add(lblMedico);

		JLabel lblEspecialidade = new JLabel("Especialidade");
		lblEspecialidade.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEspecialidade.setBounds(21, 236, 142, 26);
		add(lblEspecialidade);

		JLabel lblAno = new JLabel("Ano");
		lblAno.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAno.setBounds(21, 291, 46, 31);
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
		btnSair.setBounds(566, 347, 107, 31);
		add(btnSair);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EspecializacaoController controlador = new EspecializacaoController();
				EspecializacaoVO especializacao = construirEspecializacao();

				String mensagem = controlador.salvar(especializacao);
				JOptionPane.showMessageDialog(null, mensagem);
				limparTela();

			}
		});
		btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnCadastrar.setBounds(297, 347, 114, 31);
		add(btnCadastrar);

		txtIdMedico = new JTextField();
		txtIdMedico.setEditable(false);
		txtIdMedico.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtIdMedico.setBounds(161, 175, 62, 31);
		add(txtIdMedico);
		txtIdMedico.setColumns(10);

		txtNomeMedico = new JTextField();
		txtNomeMedico.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtNomeMedico.setBounds(233, 175, 440, 31);
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
		cbMedico.setBounds(161, 17, 366, 34);
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
		cbEspecialidade.setBounds(161, 64, 366, 34);
		add(cbEspecialidade);

		txtIdEspecialidade = new JTextField();
		txtIdEspecialidade.setEditable(false);
		txtIdEspecialidade.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtIdEspecialidade.setBounds(161, 234, 62, 31);
		add(txtIdEspecialidade);
		txtIdEspecialidade.setColumns(10);

		txtNomeEspecialidade = new JTextField();
		txtNomeEspecialidade.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtNomeEspecialidade.setBounds(233, 234, 440, 31);
		add(txtNomeEspecialidade);
		txtNomeEspecialidade.setColumns(10);

		txtAno = new JTextField();
		txtAno.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtAno.setBounds(77, 289, 101, 34);
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
		btnLimparTela.setBounds(21, 347, 142, 31);
		add(btnLimparTela);

		JLabel lblBuscarMedico = new JLabel("Medico");
		lblBuscarMedico.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBuscarMedico.setBounds(21, 21, 91, 26);
		add(lblBuscarMedico);

		JLabel lblBuscarEspecialidade = new JLabel("Especialidade");
		lblBuscarEspecialidade.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBuscarEspecialidade.setBounds(21, 68, 118, 26);
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
				List<EspecialidadeVO> especialidades = null;
				List<MedicoVO> medicos = null;
				especialidades = controlador.exibirEspecialidadePorNome(especialidadeBuscada);
				medicos = controllerMedico.exibirMedicoPorNome(medicoBuscado);
				
			
				if (especialidades != null && medicos != null) {

					txtNomeEspecialidade.setText(especialidadeBuscada.getNomeEspecialidade());
					txtIdEspecialidade.setText(especialidadeBuscada.getCodigoEspecialidade() + "");
					txtNomeMedico.setText(medicoBuscado.getNomeMedico());
					txtIdMedico.setText(medicoBuscado.getCodigoMedico() + "");

				} else {
					JOptionPane.showMessageDialog(null, "Escolha o médico e a especialidade! Tente novamente!");
				}
			}
		});
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnBuscar.setBounds(582, 35, 91, 31);
		add(btnBuscar);

		JSeparator separator = new JSeparator();
		separator.setBounds(21, 124, 653, 14);
		add(separator);

	}

	protected EspecializacaoVO construirEspecializacao() {

		medico = (MedicoVO) cbMedico.getSelectedItem();
		especialidade = (EspecialidadeVO) cbEspecialidade.getSelectedItem();

		especializacao.setMedicoVO(medico);
		especializacao.setEspecialidadeVO(especialidade);
		especializacao.setAnoEspecializacao(txtAno.getText());

		return especializacao;
	}

	protected void limparTela() {
		txtAno.setText("");
		txtIdEspecialidade.setText("");
		txtIdMedico.setText("");
		txtNomeEspecialidade.setText("");
		txtNomeMedico.setText("");
		cbEspecialidade.setSelectedIndex(0);
		cbMedico.setSelectedIndex(0);

	}

	protected void preencherMedico() {

		MedicoController controlador = new MedicoController();
		ArrayList<MedicoVO> listaMedico = new ArrayList<MedicoVO>();

		listaMedico = controlador.consultarMedico();
		DefaultComboBoxModel medicos = new DefaultComboBoxModel(listaMedico.toArray());
		cbMedico.setModel(medicos);

	}

	protected void preencherEspecialidade() {

		EspecialidadeController controlador = new EspecialidadeController();
		ArrayList<EspecialidadeVO> listaEspecialidade = new ArrayList<EspecialidadeVO>();

		listaEspecialidade = controlador.consultarEspecialidade();
		DefaultComboBoxModel especialidades = new DefaultComboBoxModel(listaEspecialidade.toArray());
		cbEspecialidade.setModel(especialidades);

	}
}
