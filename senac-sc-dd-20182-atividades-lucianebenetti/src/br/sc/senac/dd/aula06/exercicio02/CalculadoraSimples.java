package br.sc.senac.dd.aula06.exercicio02;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class CalculadoraSimples extends JFrame implements ActionListener {
	
	private JPanel contentPane;
	private JTextField textNumero1;
	private JTextField textNumero2;
	private JTextField txtResultado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculadoraSimples frame = new CalculadoraSimples();
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
	int subtracao;
	private JButton btnDivisao;
	private JButton btnMultiplicacao;
	public CalculadoraSimples() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 395, 368);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(70, 130, 180));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblN1 = new JLabel("N\u00BA 1");
		lblN1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblN1.setBounds(15, 82, 54, 44);
		contentPane.add(lblN1);
		
		JLabel lblN2 = new JLabel("N\u00BA 2");
		lblN2.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblN2.setBounds(195, 94, 49, 20);
		contentPane.add(lblN2);
		
		txtResultado = new JTextField();
		txtResultado.setHorizontalAlignment(SwingConstants.CENTER);
		txtResultado.setFont(new Font("Tahoma", Font.PLAIN, 22));
		txtResultado.setBounds(15, 16, 337, 44);
		contentPane.add(txtResultado);
		txtResultado.setColumns(10);
		
		textNumero1 = new JTextField();
		textNumero1.setHorizontalAlignment(SwingConstants.CENTER);
		textNumero1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		textNumero1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				double num1 = e.getKeyCode();
				
			}
		});
		textNumero1.setBounds(74, 82, 87, 41);
		contentPane.add(textNumero1);
		textNumero1.setColumns(10);
		
		textNumero2 = new JTextField();
		textNumero2.setHorizontalAlignment(SwingConstants.CENTER);
		textNumero2.setFont(new Font("Tahoma", Font.PLAIN, 24));
		textNumero2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				double num2 = e.getKeyCode();
				
			}
		});
		textNumero2.setBounds(256, 82, 96, 44);
		contentPane.add(textNumero2);
		textNumero2.setColumns(10);
		
		JButton btnSoma = new JButton("+");
		btnSoma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double soma;
				double valor1 = Double.parseDouble(textNumero1.getText());
				double valor2 = Double.parseDouble(textNumero2.getText());
				soma = valor1 + valor2;
				txtResultado.setText(soma + "");
				
			}
		});
		btnSoma.setBackground(new Color(238, 232, 170));
		btnSoma.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSoma.setBounds(81, 147, 80, 60);
		contentPane.add(btnSoma);
		
		JButton btnSubtacao = new JButton("-");
		btnSubtacao.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			double subtracao;
			double valor1 = Double.parseDouble(textNumero1.getText());
			double valor2 = Double.parseDouble(textNumero2.getText());
			
			subtracao = valor1 - valor2;
			txtResultado.setText(subtracao + "");
		}
	});
			
		btnSubtacao.setBackground(new Color(238, 232, 170));
		btnSubtacao.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSubtacao.setBounds(195, 149, 80, 55);
		contentPane.add(btnSubtacao);
		
		btnMultiplicacao = new JButton("*");
		btnMultiplicacao.addActionListener(this);
		btnMultiplicacao.setBackground(new Color(238, 232, 170));
		btnMultiplicacao.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnMultiplicacao.setBounds(81, 225, 80, 55);
		contentPane.add(btnMultiplicacao);
		
		btnDivisao = new JButton("/");
		btnDivisao.addActionListener(this);
		btnDivisao.setBackground(new Color(238, 232, 170));
		btnDivisao.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnDivisao.setBounds(195, 225, 80, 55);
		contentPane.add(btnDivisao);
	
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnMultiplicacao) {
			do_btnMultiplicacao_actionPerformed(e);
			double multiplicacao;
			double valor1 = Double.parseDouble(textNumero1.getText());
			double valor2 = Double.parseDouble(textNumero2.getText());
			
			multiplicacao = valor1 * valor2;
			txtResultado.setText(multiplicacao + "");
			
		}
		if (e.getSource() == btnDivisao) {
			do_btnDivisao_actionPerformed(e);
			double divisao;
			double valor1 = Double.parseDouble(textNumero1.getText());
			double valor2 = Double.parseDouble(textNumero2.getText());
			
			divisao = valor1 / valor2;
			txtResultado.setText(divisao + "");
		}
	}
	protected void do_btnDivisao_actionPerformed(ActionEvent e) {
	}
	protected void do_btnMultiplicacao_actionPerformed(ActionEvent e) {
	}
}
