package br.sc.senac.dd.aula06.exercicio04.View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.Font;

public class ListarTodos extends JFrame {

	private JPanel contentPane;
	private JTable tbFuncionario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListarTodos frame = new ListarTodos();
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
	public ListarTodos() {
		setTitle("Listar Todos Funcion\u00E1rios");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 703, 481);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFuncionario = new JLabel("Funcion\u00E1rios");
		lblFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblFuncionario.setBounds(44, 82, 156, 49);
		contentPane.add(lblFuncionario);
		
		JButton btnListarTodos = new JButton("ListarTodos");
		btnListarTodos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnListarTodos.setBounds(479, 29, 141, 49);
		contentPane.add(btnListarTodos);
		
		tbFuncionario = new JTable();
		tbFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tbFuncionario.setBounds(44, 136, 592, 256);
		contentPane.add(tbFuncionario);
	}
}
