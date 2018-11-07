package Clinica_Medica.View.Convenio;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import Clinica_Medica.Controller.ConvenioController;
import Clinica_Medica.VO.ConvenioVO;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JSeparator;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.awt.Color;

public class TelaExcluirConvenio extends JPanel {

	private static final String MASCARA_CNPJ = "##.###.###/####-##";
	private JTextField txtCnpj;
	private JTextField txtNome;
	private JTextField txtValor;
	private ConvenioVO convenio = new ConvenioVO();
	private ConvenioVO convenioConsultado = new ConvenioVO();
	/**
	 * Create the panel.
	 */
	public TelaExcluirConvenio() {
		setBackground(new Color(173, 216, 230));
		setLayout(null);
		
		JLabel lblCNPJ = new JLabel("CNPJ");
		lblCNPJ.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCNPJ.setBounds(10, 28, 46, 22);
		add(lblCNPJ);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNome.setBounds(10, 112, 58, 27);
		add(lblNome);
		
		JLabel lblValor = new JLabel("Valor");
		lblValor.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblValor.setBounds(10, 176, 58, 27);
		add(lblValor);
		
		try {
			txtCnpj = new JFormattedTextField(new MaskFormatter(MASCARA_CNPJ));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		txtCnpj.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtCnpj.setBounds(90, 25, 251, 30);
		add(txtCnpj);
		txtCnpj.setColumns(10);
		
		txtNome = new JTextField();
		txtNome.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtNome.setBounds(107, 112, 379, 30);
		add(txtNome);
		txtNome.setColumns(10);
		
		txtValor = new JTextField();
		txtValor.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtValor.setBounds(107, 176, 125, 30);
		add(txtValor);
		txtValor.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				ConvenioController controller = new ConvenioController();
				convenioConsultado = controller.buscarConvenioPorCNPJ(txtCnpj.getText());
				
				if(convenioConsultado != null) {
					
					convenioConsultado = consutarConvenio();
					
								
					}else {
						JOptionPane.showMessageDialog(null, "Convênio não encontrado.");
					}
			}
		});
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnBuscar.setBounds(387, 24, 99, 31);
		add(btnBuscar);
		
		JButton btnLimparTela = new JButton("Limpar Tela");
		btnLimparTela.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				limparTela();
			}
		});
		btnLimparTela.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnLimparTela.setBounds(10, 258, 137, 31);
		add(btnLimparTela);
		
		JButton btnNewButton_2 = new JButton("Excluir");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				ConvenioController dao = new ConvenioController();
				ConvenioVO convenioExcluido = construirConvenio();
				dao.excluirConvenio(convenioExcluido);
				JOptionPane.showMessageDialog(null, "Convênio excluído!");
				limparTela();
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_2.setBounds(230, 258, 99, 31);
		add(btnNewButton_2);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int opcao;
                Object[] BtSair={"Sim","Não"};
                 
                opcao = JOptionPane.showOptionDialog(null,"Deseja sair desta operação?", 
                        "Fechar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                        null, BtSair, BtSair[0]);
                        if(opcao == JOptionPane.YES_OPTION) {
                        	 setVisible(false);
                        }
			}
		});
		btnSair.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSair.setBounds(397, 258, 89, 31);
		add(btnSair);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 72, 476, 14);
		add(separator);
		

	}
	protected void limparTela() {
		txtCnpj.setText("");
		txtNome.setText("");
		txtValor.setText("");
		
	}
	protected ConvenioVO construirConvenio() {
		convenio.setNomeConvenio(txtNome.getText());
		convenio.setCnpjConvenio(txtCnpj.getText());
		
		String valor = txtValor.getText();
		
		if(valor.trim() !="") {
		convenio.setValor(Double.parseDouble(valor));
		}

		return convenio;
	}
	
	protected ConvenioVO consutarConvenio() {
		
		txtNome.setText(convenioConsultado.getNomeConvenio());
		txtCnpj.setText(convenioConsultado.getCnpjConvenio());
		txtValor.setText(convenioConsultado.getValor()+ "");
		
		return convenioConsultado;
	}
}
