package br.sc.senac.dd.aula06.exercicio01;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class PrimeiraTela {

	private JFrame frmTelaDoExerccio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrimeiraTela window = new PrimeiraTela();
					window.frmTelaDoExerccio.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PrimeiraTela() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTelaDoExerccio = new JFrame();
		frmTelaDoExerccio.getContentPane().setBackground(new Color(255, 222, 173));
		frmTelaDoExerccio.setBackground(new Color(0, 0, 128));
		frmTelaDoExerccio.setTitle("Primeira tela em Swing - Eclipse");
		frmTelaDoExerccio.setBounds(100, 100, 513, 311);
		frmTelaDoExerccio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTelaDoExerccio.getContentPane().setLayout(null);
		
		JLabel lblTelaLuciane = new JLabel("Primeira Tela da Luciane");
		lblTelaLuciane.setForeground(new Color(165, 42, 42));
		lblTelaLuciane.setBounds(132, 50, 192, 51);
		lblTelaLuciane.setHorizontalAlignment(SwingConstants.CENTER);
		lblTelaLuciane.setBackground(new Color(135, 206, 235));
		lblTelaLuciane.setFont(new Font("Tahoma", Font.PLAIN, 18));
		frmTelaDoExerccio.getContentPane().add(lblTelaLuciane);
		
		JButton btnVisualizar = new JButton("Clique para visualizar");
		btnVisualizar.setBounds(132, 145, 206, 43);
		btnVisualizar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnVisualizar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnVisualizar.setForeground(new Color(25, 25, 112));
		btnVisualizar.setBackground(new Color(127, 255, 212));
		frmTelaDoExerccio.getContentPane().add(btnVisualizar);
		
		JLabel lblTeste = new JLabel("Exerc\u00EDcio 1 -  aula n\u00FAmero 06");
		lblTeste.setBounds(0, 0, 491, 20);
		lblTeste.setHorizontalAlignment(SwingConstants.CENTER);
		lblTeste.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTeste.setBackground(new Color(0, 204, 0));
		frmTelaDoExerccio.getContentPane().add(lblTeste);
	}

}
