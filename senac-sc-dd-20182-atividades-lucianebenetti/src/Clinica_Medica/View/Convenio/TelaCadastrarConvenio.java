
package Clinica_Medica.View.Convenio;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import Clinica_Medica.BO.ConvenioBO;
import Clinica_Medica.Controller.ConvenioController;
import Clinica_Medica.DAO.ConvenioDAO;
import Clinica_Medica.VO.ConvenioVO;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;

import java.awt.Font;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.awt.Panel;
import java.awt.SystemColor;

public class TelaCadastrarConvenio extends JPanel {

	private JTextField txtBuscarCnpj;
	private JTextField txtNome;
	private JTextField txtCnpj;
	private ConvenioVO convenio = new ConvenioVO();
	private JTextField txtValor;
	private ConvenioVO convenioConsultado = new ConvenioVO();
	private static final String MASCARA_CNPJ = "##.###.###/####-##";

	/**
	 * Create the panel.
	 */
	public TelaCadastrarConvenio() {
		setBackground(new Color(173, 216, 230));
		setLayout(null);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNome.setBounds(258, 121, 46, 23);
		add(lblNome);

		JLabel lblCnpj = new JLabel("CNPJ");
		lblCnpj.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCnpj.setBounds(258, 203, 46, 23);
		add(lblCnpj);

		JLabel lblBuscarCnpj = new JLabel("CNPJ");
		lblBuscarCnpj.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBuscarCnpj.setBounds(258, 44, 46, 23);
		add(lblBuscarCnpj);

		try {
			txtBuscarCnpj = new JFormattedTextField(new MaskFormatter(MASCARA_CNPJ));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		txtBuscarCnpj.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtBuscarCnpj.setBounds(344, 39, 351, 33);
		add(txtBuscarCnpj);
		txtBuscarCnpj.setColumns(10);

		txtNome = new JTextField();
		txtNome.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtNome.setBounds(344, 112, 517, 41);
		add(txtNome);
		txtNome.setColumns(10);

		try {
			txtCnpj = new JFormattedTextField(new MaskFormatter(MASCARA_CNPJ));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		txtCnpj.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtCnpj.setBounds(344, 194, 517, 41);
		add(txtCnpj);
		txtCnpj.setColumns(10);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ConvenioController controller = new ConvenioController();
				convenioConsultado = controller.buscarConvenioPorCNPJ(txtBuscarCnpj.getText());

				if (convenioConsultado != null) {

					convenioConsultado = consutarConvenio();

				} else {
					JOptionPane.showMessageDialog(null, "Convênio não encontrado.");
					txtCnpj.setText(txtBuscarCnpj.getText());
				}
			}
		});
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnBuscar.setBounds(799, 37, 89, 36);
		add(btnBuscar);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				ConvenioController controlador = new ConvenioController();
				ConvenioVO convenio = construirConvenio();
				String mensagem = controlador.salvar(convenio);
				JOptionPane.showMessageDialog(null, mensagem);
				limparTela();
			}
		});
		btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnCadastrar.setBounds(610, 481, 124, 36);
		add(btnCadastrar);

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
		btnSair.setBounds(780, 481, 108, 36);
		add(btnSair);

		JLabel lblValor = new JLabel("Valor");
		lblValor.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblValor.setBounds(258, 275, 46, 23);
		add(lblValor);

		txtValor = new JTextField();
		txtValor.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtValor.setColumns(10);
		txtValor.setBounds(344, 266, 517, 41);
		add(txtValor);

		JButton btnLimparTela = new JButton("Limpar Tela");
		btnLimparTela.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				limparTela();
			}
		});
		btnLimparTela.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnLimparTela.setBounds(251, 481, 140, 36);
		add(btnLimparTela);

		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				String conCnpj = null;
				ConvenioController controlador = new ConvenioController();
				ConvenioVO convenio = construirConvenio();
				String mensagem = controlador.atualizarConvenio(convenio, conCnpj);
				JOptionPane.showMessageDialog(null, mensagem);
				limparTela();
			}
		});
		btnAtualizar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAtualizar.setBounds(437, 481, 119, 36);
		add(btnAtualizar);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(257, 94, 631, 2);
		add(separator_1);

		Panel panel = new Panel();
		panel.setBackground(SystemColor.menu);
		panel.setBounds(214, 44, 4, 475);
		add(panel);

	}

	protected ConvenioVO consutarConvenio() {
		txtNome.setText(convenioConsultado.getNomeConvenio());
		txtCnpj.setText(convenioConsultado.getCnpjConvenio());
		txtValor.setText(convenioConsultado.getValor() + "");

		return convenioConsultado;
	}

	protected void limparTela() {
		convenio = new ConvenioVO();
		txtNome.setText("");
		txtCnpj.setText("");
		txtValor.setText("");
		txtBuscarCnpj.setText("");

	}

	protected ConvenioVO construirConvenio() {
		convenio.setNomeConvenio(txtNome.getText());
		convenio.setCnpjConvenio(txtCnpj.getText());

		String valor = txtValor.getText();

		if (valor.trim() != "") {
			convenio.setValor(Double.parseDouble(valor));
		}

		return convenio;
	}
}
