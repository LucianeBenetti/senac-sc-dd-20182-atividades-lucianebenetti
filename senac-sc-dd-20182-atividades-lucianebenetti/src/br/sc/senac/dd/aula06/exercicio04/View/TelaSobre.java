package br.sc.senac.dd.aula06.exercicio04.View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;

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
		setBounds(100, 100, 656, 304);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLucianeBenetti = new JLabel("Luciane Benetti");
		lblLucianeBenetti.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLucianeBenetti.setBounds(51, 37, 199, 20);
		contentPane.add(lblLucianeBenetti);
		
		JLabel lblTecnlogoEmAnlise = new JLabel("Tecn\u00F3logo em An\u00E1lise e Desenvolvimeto de Sistemas");
		lblTecnlogoEmAnlise.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTecnlogoEmAnlise.setBounds(51, 73, 514, 20);
		contentPane.add(lblTecnlogoEmAnlise);
		
		JLabel label = new JLabel("02/10/2018");
		label.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label.setBounds(477, 221, 104, 20);
		contentPane.add(label);
		
		JLabel lblSenac = new JLabel("SENAC");
		lblSenac.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSenac.setBounds(51, 109, 69, 20);
		contentPane.add(lblSenac);
		
		JLabel lblFlorianpolisSc = new JLabel("Florian\u00F3polis - SC");
		lblFlorianpolisSc.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblFlorianpolisSc.setBounds(51, 145, 253, 20);
		contentPane.add(lblFlorianpolisSc);
	}
}
