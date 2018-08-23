package br.sc.senac.dd.aula06;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;

public class PrimeiraTela {

	private JFrame frmTelaDoExerccio;
	private JTextField txtNumeros;
	private JTextField txtLetras;
	private JTextField textDigitar;

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
		frmTelaDoExerccio.setBounds(100, 100, 560, 455);
		frmTelaDoExerccio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTelaDoExerccio.getContentPane().setLayout(null);
		
		JLabel lblTelaLuciane = new JLabel("Primeira Tela da Luciane");
		lblTelaLuciane.setForeground(new Color(165, 42, 42));
		lblTelaLuciane.setBounds(130, 36, 192, 51);
		lblTelaLuciane.setHorizontalAlignment(SwingConstants.CENTER);
		lblTelaLuciane.setBackground(new Color(135, 206, 235));
		lblTelaLuciane.setFont(new Font("Tahoma", Font.PLAIN, 18));
		frmTelaDoExerccio.getContentPane().add(lblTelaLuciane);
		
		JButton btnVisualizar = new JButton("Clique para visualizar");
		btnVisualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnVisualizar.setBackground(Color.BLUE);
			}
		});
					
				
		btnVisualizar.setBounds(130, 145, 206, 43);
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
		
		JButton btnSair = new JButton("Mouse");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSair.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "evento Release");
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				btnSair.setBackground(Color.CYAN);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				btnSair.setBackground(Color.RED);
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				btnSair.setForeground(Color.YELLOW);
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				btnSair.setForeground(Color.GRAY);
				
			}
		}); 
			
		btnSair.setBounds(361, 210, 115, 29);
		frmTelaDoExerccio.getContentPane().add(btnSair);
		
		txtNumeros = new JTextField();
		txtNumeros.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int codigoAsciiTeclaDigitada = e.getKeyCode();
				if(codigoAsciiTeclaDigitada < KeyEvent.VK_0 || codigoAsciiTeclaDigitada> KeyEvent.VK_9) {
					JOptionPane.showMessageDialog(null, "Digite um numero entre 0 e 9");
				}
			}
		});
		txtNumeros.setBounds(25, 103, 146, 26);
		frmTelaDoExerccio.getContentPane().add(txtNumeros);
		txtNumeros.setColumns(10);
		
		txtLetras = new JTextField();
		txtLetras.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int codigoAsciiTeclaDigitada = e.getKeyCode();
				if(codigoAsciiTeclaDigitada < KeyEvent.VK_A || codigoAsciiTeclaDigitada> KeyEvent.VK_Z) {
					JOptionPane.showMessageDialog(null, "Digite uma letra");
				}
			}
		});
		txtLetras.setBounds(288, 103, 146, 26);
		frmTelaDoExerccio.getContentPane().add(txtLetras);
		txtLetras.setColumns(10);
		
		textDigitar = new JTextField();
		textDigitar.setBounds(25, 204, 146, 26);
		frmTelaDoExerccio.getContentPane().add(textDigitar);
		textDigitar.setColumns(10);
		
		JLabel lblNumeros = new JLabel("Numeros");
		lblNumeros.setBounds(34, 80, 69, 20);
		frmTelaDoExerccio.getContentPane().add(lblNumeros);
		
		JLabel lblLetras = new JLabel("Letras");
		lblLetras.setBounds(337, 80, 69, 20);
		frmTelaDoExerccio.getContentPane().add(lblLetras);
		
		JLabel Resultado = new JLabel("");
		Resultado.setBounds(34, 307, 99, 29);
		frmTelaDoExerccio.getContentPane().add(Resultado);
		
		JButton btnMostrar = new JButton("Mostrar");
		btnMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnMostrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int numeroDigitado = Integer.parseInt(textDigitar.getText());
			}	
		});
		btnMostrar.setBounds(35, 246, 115, 29);
		frmTelaDoExerccio.getContentPane().add(btnMostrar);
		
		
	}
}
