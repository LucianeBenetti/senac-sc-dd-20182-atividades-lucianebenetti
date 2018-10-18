package Clinica_Medica.View.Convenio;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaExcluirConvenio extends JPanel {

	private static final String MASCARA_CNPJ = "##.###.###/####-##";
	private JTextField txtCnpj;
	private JTextField txtNome;
	private JTextField txtValor;
	/**
	 * Create the panel.
	 */
	public TelaExcluirConvenio() {
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
		
		txtCnpj = new JTextField();
		txtCnpj.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtCnpj.setBounds(90, 25, 197, 30);
		add(txtCnpj);
		txtCnpj.setColumns(10);
		
		txtNome = new JTextField();
		txtNome.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtNome.setBounds(107, 112, 321, 30);
		add(txtNome);
		txtNome.setColumns(10);
		
		txtValor = new JTextField();
		txtValor.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtValor.setBounds(107, 176, 125, 30);
		add(txtValor);
		txtValor.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnBuscar.setBounds(341, 24, 99, 31);
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
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_2.setBounds(188, 258, 99, 31);
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
		btnSair.setBounds(351, 258, 89, 31);
		add(btnSair);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 72, 430, 14);
		add(separator);
		

	}
	protected void limparTela() {
		txtCnpj.setText("");
		txtNome.setText("");
		txtValor.setText("");
		
	}

}
