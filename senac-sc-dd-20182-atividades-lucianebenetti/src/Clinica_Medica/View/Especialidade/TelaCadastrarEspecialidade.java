package Clinica_Medica.View.Especialidade;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;
import javax.swing.JSeparator;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCadastrarEspecialidade extends JPanel {
	
	private JTable table;
	private JTextField txtBuscarNome;
	private JTextField txtNome;
	private JTextField txtInstituicao;
	private String [] nomesColunas = new String []
			{"ID", "Nome", "Instituição"};

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
						
		
		table = new JTable();
		table.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		table.setFont(new Font("Tahoma", Font.PLAIN, 20));
		table.setBackground(Color.WHITE);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				nomesColunas,
			},
				nomesColunas
			
		));
		table.setBounds(10, 135, 401, -61);
		add(table);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 172, 430, 2);
		add(separator);
		
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
		btnSair.setBounds(320, 291, 120, 31);
		add(btnSair);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnCadastrar.setBounds(144, 291, 136, 31);
		add(btnCadastrar);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnBuscar.setBounds(351, 19, 89, 31);
		add(btnBuscar);
		
		txtBuscarNome = new JTextField();
		txtBuscarNome.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtBuscarNome.setBounds(66, 23, 275, 24);
		add(txtBuscarNome);
		txtBuscarNome.setColumns(10);
		
		txtNome = new JTextField();
		txtNome.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtNome.setColumns(10);
		txtNome.setBounds(101, 197, 339, 24);
		add(txtNome);
		
		txtInstituicao = new JTextField();
		txtInstituicao.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtInstituicao.setColumns(10);
		txtInstituicao.setBounds(101, 239, 339, 24);
		add(txtInstituicao);

	}
}
