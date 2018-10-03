package br.sc.senac.dd.aula06.exercicio04.View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JTextArea;
import javax.swing.JEditorPane;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URISyntaxException;
import java.awt.Color;

public class Ajuda extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ajuda frame = new Ajuda();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Ajuda() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Ajuda.class.getResource("/icones/icons8-ajuda-48.png")));
		setTitle("Ajuda");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 753, 584);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JEditorPane dtrpnParaCadastrarCliente = new JEditorPane();
		dtrpnParaCadastrarCliente.setBackground(new Color(176, 224, 230));
		dtrpnParaCadastrarCliente.setFont(new Font("Tahoma", Font.PLAIN, 20));
		dtrpnParaCadastrarCliente.setText("Dicas:\r\n\r\n- Gest\u00E3o e controle de Funcion\u00E1rios - utilizar o Menu Funcion\u00E1rio para:\r\n\t- Cadastrar.\r\n\t- Excluir.\r\n\t- Alterar.\r\n\t- Buscar informa\u00E7\u00F5es.\r\n\r\n- Gest\u00E3o e controle de Produtos - utilizar o Menu Produtos para:\r\n\t- Cadastrar.\r\n\t- Excluir.\r\n\t- Buscar informa\u00E7\u00F5es.\r\n");
		dtrpnParaCadastrarCliente.setBounds(15, 32, 701, 320);
		contentPane.add(dtrpnParaCadastrarCliente);
		
		JLabel lblParaMaisInformaes = new JLabel("Para mais informa\u00E7\u00F5es clique no link abaixo:");
		lblParaMaisInformaes.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblParaMaisInformaes.setBounds(142, 393, 412, 20);
		contentPane.add(lblParaMaisInformaes);
		
		JButton btnAjudaOnLine = new JButton("Google on Line");
		btnAjudaOnLine.setBackground(new Color(255, 99, 71));
		btnAjudaOnLine.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				try {
					java.awt.Desktop.getDesktop().browse(new java.net.URI("http://www.google.com.br"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (URISyntaxException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		btnAjudaOnLine.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAjudaOnLine.setBounds(250, 448, 196, 47);
		contentPane.add(btnAjudaOnLine);
	}
}
