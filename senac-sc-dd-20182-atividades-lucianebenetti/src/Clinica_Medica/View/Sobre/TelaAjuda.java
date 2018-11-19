package Clinica_Medica.View.Sobre;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JEditorPane;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URISyntaxException;

public class TelaAjuda extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAjuda frame = new TelaAjuda();
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
	public TelaAjuda() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 672, 447);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JEditorPane dtrpnDicasGesto = new JEditorPane();
		dtrpnDicasGesto.setBackground(new Color(173, 216, 230));
		dtrpnDicasGesto.setFont(new Font("Tahoma", Font.PLAIN, 18));
		dtrpnDicasGesto.setText("Dicas:\r\n\r\n- Gest\u00E3o e controle da Cl\u00EDnica M\u00E9dica - utilizar o Menus para:\r\n\t- Cadastrar.\r\n\t- Excluir.\r\n\t- Alterar.\r\n\t- Buscar informa\u00E7\u00F5es.");
		dtrpnDicasGesto.setBounds(23, 55, 608, 197);
		contentPane.add(dtrpnDicasGesto);
		
		JLabel label = new JLabel("Para mais informa\u00E7\u00F5es clique no link abaixo:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label.setBounds(115, 261, 412, 20);
		contentPane.add(label);
		
		JButton button = new JButton("Google on Line");
		button.addMouseListener(new MouseAdapter() {
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
		button.setFont(new Font("Tahoma", Font.PLAIN, 20));
		button.setBackground(new Color(255, 99, 71));
		button.setBounds(222, 329, 196, 47);
		contentPane.add(button);
	}
}
