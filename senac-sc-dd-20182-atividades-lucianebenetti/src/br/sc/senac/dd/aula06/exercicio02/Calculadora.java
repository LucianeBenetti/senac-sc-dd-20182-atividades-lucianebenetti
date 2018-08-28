package br.sc.senac.dd.aula06.exercicio02;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

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
	private JButton btnEnter;
	private JTextField txtVisor;
	private double leitura;
	private double memoria;
	private char operacao;
	private JButton btnC;
	private JButton btnPonto;

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
		leitura = 0;
		memoria = 0;
		
		setTitle("Calculadora");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 374, 429);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(32, 178, 170));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(48, 35, 258, 40);
		contentPane.add(panel);
		
		btnCE = new JButton("CE");
		btnCE.addActionListener(this);
		btnCE.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCE.setBounds(48, 97, 57, 40);
		contentPane.add(btnCE);
		
		btnNum7 = new JButton("7");
		btnNum7.addActionListener(this);
		btnNum7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNum7.setBounds(48, 148, 57, 40);
		contentPane.add(btnNum7);
		
		btnNum4 = new JButton("4");
		btnNum4.addActionListener(this);
		btnNum4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNum4.setBounds(48, 199, 57, 43);
		contentPane.add(btnNum4);
		
		btnNum1 = new JButton("1");
		btnNum1.addActionListener(this);
		btnNum1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNum1.setBounds(48, 253, 57, 40);
		contentPane.add(btnNum1);
		
		btnDivisao = new JButton("/");
		btnDivisao.addActionListener(this);
		btnDivisao.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnDivisao.setBounds(182, 97, 57, 40);
		contentPane.add(btnDivisao);
		
		btnMultiplicacao = new JButton("*");
		btnMultiplicacao.addActionListener(this);
		btnMultiplicacao.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnMultiplicacao.setBounds(249, 97, 57, 40);
		contentPane.add(btnMultiplicacao);
		
		btnSubtracao = new JButton("-");
		btnSubtracao.addActionListener(this);
		btnSubtracao.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSubtracao.setBounds(249, 148, 57, 40);
		contentPane.add(btnSubtracao);
		
		btnNum8 = new JButton("8");
		btnNum8.addActionListener(this);
		btnNum8.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNum8.setBounds(115, 148, 57, 40);
		contentPane.add(btnNum8);
		
		btnNum9 = new JButton("9");
		btnNum9.addActionListener(this);
		btnNum9.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNum9.setBounds(182, 148, 57, 40);
		contentPane.add(btnNum9);
		
		btnSoma = new JButton("+");
		btnSoma.addActionListener(this);
		btnSoma.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSoma.setBounds(249, 200, 57, 40);
		contentPane.add(btnSoma);
		
		btnNum5 = new JButton("5");
		btnNum5.addActionListener(this);
		btnNum5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNum5.setBounds(115, 200, 57, 40);
		contentPane.add(btnNum5);
		
		btnNum0 = new JButton("0");
		btnNum0.addActionListener(this);
		btnNum0.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNum0.setBounds(48, 304, 124, 37);
		contentPane.add(btnNum0);
		
		btnNum2 = new JButton("2");
		btnNum2.addActionListener(this);
		btnNum2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNum2.setBounds(115, 253, 57, 40);
		contentPane.add(btnNum2);
		
		btnNum6 = new JButton("6");
		btnNum6.addActionListener(this);
		btnNum6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNum6.setBounds(182, 200, 57, 40);
		contentPane.add(btnNum6);
		
		btnNum3 = new JButton("3");
		btnNum3.addActionListener(this);
		btnNum3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNum3.setBounds(182, 253, 57, 40);
		contentPane.add(btnNum3);
		
		btnEnter = new JButton("Enter");
		btnEnter.addActionListener(this);
		btnEnter.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnEnter.setBounds(249, 253, 57, 88);
		contentPane.add(btnEnter);
		
		btnC = new JButton("C");
		btnC.addActionListener(this);
		btnC.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnC.setBounds(110, 97, 63, 40);
		contentPane.add(btnC);
		
		txtVisor = new JTextField();
		txtVisor.setEditable(false);
		txtVisor.setHorizontalAlignment(SwingConstants.CENTER);
		txtVisor.setBounds(48, 35, 258, 43);
		contentPane.add(txtVisor);
		txtVisor.setFont(new Font("Tahoma", Font.PLAIN, 24));
		txtVisor.setColumns(10);
		
		btnPonto = new JButton(".");
		btnPonto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnPonto.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnPonto.setBounds(182, 304, 57, 40);
		contentPane.add(btnPonto);
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == btnC) {
			do_btnC_actionPerformed(e);
			leitura = 0;
			memoria = 0;
			txtVisor.setText("");
		}
		if (e.getSource() == btnCE) {
			do_btnCE_actionPerformed(e);
			leitura = 0;
			txtVisor.setText("");
		}
		if (e.getSource() == btnDivisao) {
			do_btnDivisao_actionPerformed(e);
			operacao = '/';
			if (memoria > 0){
				memoria /= leitura;
				}else{
				memoria = leitura;
				}
				leitura = 0;
				txtVisor.setText("");
		}
		if (e.getSource() == btnMultiplicacao) {
			do_btnMultiplicacao_actionPerformed(e);
			operacao = '*';
			if (memoria > 0){
				memoria *= leitura;
				}else{
				memoria = leitura;
				}
				leitura = 0;
				txtVisor.setText("");
		}
		if (e.getSource() == btnSubtracao) {
			do_btnSubtracao_actionPerformed(e);
			operacao = '-';
			if (memoria > 0){
				memoria -= leitura;
				}else{
				memoria = leitura;
				}
				leitura = 0;
				txtVisor.setText("");
				}
		if (e.getSource() == btnSoma) {
			do_btnSoma_actionPerformed(e);
			operacao = '+';
			if (memoria > 0){
				memoria += leitura;
				}else{
				memoria = leitura;
				}
				leitura = 0;
				txtVisor.setText("");
				}
		
		if (e.getSource() == btnEnter) {
			do_btnEnter_actionPerformed(e);
			switch(operacao) {
			case '+':
				memoria += leitura;
				break;
			case'-':
				memoria -= leitura;
				break;
			case'*':
				memoria *= leitura;
				break;	
			case'/':
				memoria /= leitura;
				break;	
		}
		leitura = 0;
		txtVisor.setText("" + memoria);
		}
		
		if (e.getSource() == btnNum0) {
			do_btnNum0_actionPerformed(e);
			leitura *=10;
			leitura += 0;
			txtVisor.setText(txtVisor.getText() + "0");
		}
		if (e.getSource() == btnNum9) {
			do_btnNum9_actionPerformed(e);
			leitura *=10;
			leitura += 9;
			txtVisor.setText(txtVisor.getText() + "9");
		}
		if (e.getSource() == btnNum8) {
			do_btnNum8_actionPerformed(e);
			leitura *=10;
			leitura += 8;
			txtVisor.setText(txtVisor.getText() + "8");
		}
		if (e.getSource() == btnNum7) {
			do_btnNum7_actionPerformed(e);
			leitura *=10;
			leitura += 7;
			txtVisor.setText(txtVisor.getText() + "7");
		}
		if (e.getSource() == btnNum6) {
			do_btnNum6_actionPerformed(e);
			leitura *=10;
			leitura += 6;
			txtVisor.setText(txtVisor.getText() + "6");
		}
		if (e.getSource() == btnNum5) {
			do_btnNum5_actionPerformed(e);
			leitura *=10;
			leitura += 5;
			txtVisor.setText(txtVisor.getText() + "5");
		}
		if (e.getSource() == btnNum4) {
			do_btnNum4_actionPerformed(e);
			leitura *=10;
			leitura += 4;
			txtVisor.setText(txtVisor.getText() + "4");
		}
		if (e.getSource() == btnNum3) {
			do_btnNum3_actionPerformed(e);
			leitura *=10;
			leitura += 3;
			txtVisor.setText(txtVisor.getText() + "3");
		}
		if (e.getSource() == btnNum2) {
			do_btnNum2_actionPerformed(e);
			leitura *=10;
			leitura += 2;
			txtVisor.setText(txtVisor.getText() + "2");
		}
		if (e.getSource() == btnNum1) {
			do_btnNum1_actionPerformed(e);
			leitura *=10;
			leitura += 1;
			txtVisor.setText(txtVisor.getText() + "1");
		}
			
	}
	protected void do_btnNum1_actionPerformed(ActionEvent e) {
	}
	protected void do_btnNum2_actionPerformed(ActionEvent e) {
	}
	protected void do_btnSoma_actionPerformed(ActionEvent e) {
	}
	protected void do_btnEnter_actionPerformed(ActionEvent e) {
	}
	protected void do_btnNum3_actionPerformed(ActionEvent e) {
	}
	protected void do_btnNum4_actionPerformed(ActionEvent e) {
	}
	protected void do_btnNum5_actionPerformed(ActionEvent e) {
	}
	protected void do_btnNum6_actionPerformed(ActionEvent e) {
	}
	protected void do_btnNum7_actionPerformed(ActionEvent e) {
	}
	protected void do_btnNum8_actionPerformed(ActionEvent e) {
	}
	protected void do_btnNum9_actionPerformed(ActionEvent e) {
	}
	protected void do_btnNum0_actionPerformed(ActionEvent e) {
	}
	protected void do_btnSubtracao_actionPerformed(ActionEvent e) {
	}
	protected void do_btnMultiplicacao_actionPerformed(ActionEvent e) {
	}
	protected void do_btnDivisao_actionPerformed(ActionEvent e) {
	}
	protected void do_btnCE_actionPerformed(ActionEvent e) {
	}
	protected void do_btnC_actionPerformed(ActionEvent e) {
	}
	protected void do_btnPonto_actionPerformed(ActionEvent e) {
	}
}
