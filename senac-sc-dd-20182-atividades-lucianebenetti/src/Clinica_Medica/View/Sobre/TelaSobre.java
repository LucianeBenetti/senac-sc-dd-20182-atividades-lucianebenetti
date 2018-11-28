package Clinica_Medica.View.Sobre;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class TelaSobre extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaSobre frame = new TelaSobre();
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
	public TelaSobre() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaSobre.class.getResource("/icones/icons8-card\u00E1pio.png")));
		setTitle("Sobre");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 666, 359);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(173, 216, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLucianeBenetti = new JLabel("Luciane Benetti e Marco Ant\u00F4nio Cardoso Sena");
		lblLucianeBenetti.setBackground(new Color(211, 211, 211));
		lblLucianeBenetti.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblLucianeBenetti.setBounds(51, 51, 420, 20);
		contentPane.add(lblLucianeBenetti);
		
		JLabel lblTecnlogoEmAnlise = new JLabel("Tecn\u00F3logo em An\u00E1lise e Desenvolvimeto de Sistemas");
		lblTecnlogoEmAnlise.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTecnlogoEmAnlise.setBounds(51, 123, 514, 20);
		contentPane.add(lblTecnlogoEmAnlise);
		
		JLabel lblOutubro = new JLabel("Novembro/2018");
		lblOutubro.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblOutubro.setBounds(423, 221, 158, 34);
		contentPane.add(lblOutubro);
		
		JLabel lblSenac = new JLabel("SENAC");
		lblSenac.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSenac.setBounds(52, 154, 69, 20);
		contentPane.add(lblSenac);
		
		JLabel lblFlorianpolisSc = new JLabel("Florian\u00F3polis - SC");
		lblFlorianpolisSc.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblFlorianpolisSc.setBounds(51, 185, 253, 20);
		contentPane.add(lblFlorianpolisSc);
		
		JLabel lblAnalistasDesenvolvedores = new JLabel("Analistas Desenvolvedores:");
		lblAnalistasDesenvolvedores.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAnalistasDesenvolvedores.setBounds(51, 11, 299, 29);
		contentPane.add(lblAnalistasDesenvolvedores);
	}
}
