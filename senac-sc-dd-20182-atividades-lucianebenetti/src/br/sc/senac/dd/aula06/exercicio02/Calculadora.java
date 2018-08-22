package br.sc.senac.dd.aula06.exercicio02;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.DropMode;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class Calculadora extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JPanel panel;
	private JButton btnCE;
	private JButton btnNum7;
	private JButton btnNum4;
	private JButton btnNum1;
	private JButton btnDivisao;
	private JButton btnMultiplicacao;
	private JButton btnSubtracao;
	private JButton btnNum8;
	private JButton btnNum9;
	private JButton btnSoma;
	private JButton btnNum5;
	private JButton btnNum0;
	private JButton btnNum2;
	private JButton btnNum6;
	private JButton btnNum3;
	private JButton btnVirgula;
	private JButton btnPonto;
	private JButton btnEnter;
	private JTextField txtVisor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculadora frame = new Calculadora();
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
	public Calculadora() {
		setTitle("Calculadora Padr\u00E3o");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 391, 401);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(32, 178, 170));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(58, 16, 258, 40);
		contentPane.add(panel);
		
		btnCE = new JButton("CE");
		btnCE.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCE.setBounds(58, 83, 57, 40);
		contentPane.add(btnCE);
		
		btnNum7 = new JButton("7");
		btnNum7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNum7.setBounds(58, 134, 57, 40);
		contentPane.add(btnNum7);
		
		btnNum4 = new JButton("4");
		btnNum4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNum4.setBounds(58, 185, 57, 43);
		contentPane.add(btnNum4);
		
		btnNum1 = new JButton("1");
		btnNum1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNum1.setBounds(58, 239, 57, 40);
		contentPane.add(btnNum1);
		
		btnDivisao = new JButton("/");
		btnDivisao.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnDivisao.setBounds(125, 83, 57, 40);
		contentPane.add(btnDivisao);
		
		btnMultiplicacao = new JButton("*");
		btnMultiplicacao.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnMultiplicacao.setBounds(192, 83, 57, 40);
		contentPane.add(btnMultiplicacao);
		
		btnSubtracao = new JButton("-");
		btnSubtracao.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSubtracao.addActionListener(this);
		btnSubtracao.setBounds(259, 83, 57, 40);
		contentPane.add(btnSubtracao);
		
		btnNum8 = new JButton("8");
		btnNum8.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNum8.setBounds(125, 134, 57, 40);
		contentPane.add(btnNum8);
		
		btnNum9 = new JButton("9");
		btnNum9.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNum9.setBounds(192, 134, 57, 40);
		contentPane.add(btnNum9);
		
		btnSoma = new JButton("+");
		btnSoma.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSoma.setBounds(259, 134, 57, 40);
		contentPane.add(btnSoma);
		
		btnNum5 = new JButton("5");
		btnNum5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNum5.setBounds(125, 186, 57, 40);
		contentPane.add(btnNum5);
		
		btnNum0 = new JButton("0");
		btnNum0.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNum0.setBounds(58, 290, 124, 34);
		contentPane.add(btnNum0);
		
		btnNum2 = new JButton("2");
		btnNum2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNum2.setBounds(125, 239, 57, 40);
		contentPane.add(btnNum2);
		
		btnNum6 = new JButton("6");
		btnNum6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNum6.setBounds(192, 186, 57, 40);
		contentPane.add(btnNum6);
		
		btnNum3 = new JButton("3");
		btnNum3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNum3.setBounds(192, 239, 57, 40);
		contentPane.add(btnNum3);
		
		btnVirgula = new JButton(",");
		btnVirgula.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnVirgula.setBounds(192, 290, 57, 34);
		contentPane.add(btnVirgula);
		
		btnPonto = new JButton(".");
		btnPonto.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnPonto.setBounds(259, 185, 57, 40);
		contentPane.add(btnPonto);
		
		btnEnter = new JButton("Enter");
		btnEnter.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnEnter.setBounds(259, 239, 57, 85);
		contentPane.add(btnEnter);
		
		txtVisor = new JTextField();
		txtVisor.setBounds(61, 16, 255, 40);
		contentPane.add(txtVisor);
		txtVisor.setColumns(10);
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnSubtracao) {
			do_btnNewButton_5_actionPerformed(arg0);
		}
	}
	protected void do_btnNewButton_5_actionPerformed(ActionEvent arg0) {
	}
}
