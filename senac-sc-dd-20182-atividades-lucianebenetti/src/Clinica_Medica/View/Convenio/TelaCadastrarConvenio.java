package Clinica_Medica.View.Convenio;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Clinica_Medica.BO.ConvenioBO;
import Clinica_Medica.Controller.ConvenioController;
import Clinica_Medica.VO.ConvenioVO;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaCadastrarConvenio extends JPanel {
	
	private JTextField txtBuscarCnpj;
	private JTextField txtNome;
	private JTextField txtCnpj;
	private ConvenioVO convenio = new ConvenioVO();
	private JTextField txtValor;
	private ConvenioVO convenioConsultado = new ConvenioVO();
	private ConvenioBO bo = new ConvenioBO();

	/**
	 * Create the panel.
	 */
	public TelaCadastrarConvenio() {
		setBackground(new Color(230, 230, 250));
		setLayout(null);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNome.setBounds(10, 86, 46, 23);
		add(lblNome);
		
		JLabel lblCnpj = new JLabel("CNPJ");
		lblCnpj.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCnpj.setBounds(10, 140, 46, 23);
		add(lblCnpj);
		
		JLabel lblBuscarCnpj = new JLabel("CNPJ");
		lblBuscarCnpj.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBuscarCnpj.setBounds(10, 19, 46, 23);
		add(lblBuscarCnpj);
		
		txtBuscarCnpj = new JTextField();
		txtBuscarCnpj.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtBuscarCnpj.setBounds(66, 11, 264, 33);
		add(txtBuscarCnpj);
		txtBuscarCnpj.setColumns(10);
		
		txtNome = new JTextField();
		txtNome.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtNome.setBounds(66, 86, 374, 26);
		add(txtNome);
		txtNome.setColumns(10);
		
		txtCnpj = new JTextField();
		txtCnpj.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtCnpj.setBounds(66, 140, 374, 26);
		add(txtCnpj);
		txtCnpj.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				convenioConsultado = bo.buscarConvenioPorCNPJ(txtBuscarCnpj.getText());
				
				if(convenioConsultado != null) {
					txtNome.setText(convenioConsultado.getConvNome());
					txtCnpj.setText(convenioConsultado.getConvCnpj());
					txtValor.setText(convenioConsultado.getValor()+ "");
					
								
					}else {
						JOptionPane.showMessageDialog(null, "Funcionário não encontrado.");
					}
			}
		});
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnBuscar.setBounds(351, 11, 89, 36);
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
		btnCadastrar.setBounds(156, 242, 124, 36);
		add(btnCadastrar);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
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
		btnSair.setBounds(351, 242, 89, 36);
		add(btnSair);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 53, 430, 8);
		add(separator);
		
		JLabel lblValor = new JLabel("Valor");
		lblValor.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblValor.setBounds(10, 191, 46, 23);
		add(lblValor);
		
		txtValor = new JTextField();
		txtValor.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtValor.setColumns(10);
		txtValor.setBounds(66, 191, 374, 26);
		add(txtValor);

	}

	protected void limparTela() {
		convenio = new ConvenioVO();
		txtNome.setText("");
		txtCnpj.setText("");
		txtValor.setText("");
		
	}

	protected ConvenioVO construirConvenio() {
		convenio.setConvNome(txtNome.getText());
		convenio.setConvCnpj(txtCnpj.getText());
		
		String valor = txtValor.getText();
		
		if(valor.trim() !="") {
		convenio.setValor(Double.parseDouble(valor));
		}

		return convenio;
	}

}
