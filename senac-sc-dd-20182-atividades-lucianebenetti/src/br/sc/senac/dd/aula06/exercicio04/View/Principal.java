package br.sc.senac.dd.aula06.exercicio04.View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.sc.senac.dd.aula06.Produto.View.AlterarProduto;
import br.sc.senac.dd.aula06.Produto.View.CadastroProduto;
import br.sc.senac.dd.aula06.Produto.View.DeletarProduto;
import br.sc.senac.dd.aula06.Produto.View.ListarTodosProdutos;

import java.awt.Toolkit;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Principal extends JFrame {

	private JPanel contentPane;
	CadastroProduto cadastroProduto = null;
	DeletarProduto deletarProduto = null;
	AlterarProduto alterarProduto = null;
	ListarTodosProdutos listarTodosProdutos = null;
	CadastroFuncionario cadastroFuncionario = null;
	DeletarFuncionario deletarFuncionario = null;
	ListarTodos listarTodosFuncionarios = null;
	AlterarFuncionario alterarFuncionario = null;
	TelaSobre s = null;
	Ajuda ajuda = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
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
	public Principal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/icones/icons8-usu\u00E1rio.png")));
		setTitle("Controle de Funcion\u00E1rios e Produtos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1009, 726);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnFuncionario = new JMenu("Funcionario");
		mnFuncionario.setFont(new Font("Segoe UI", Font.PLAIN, 22));
		mnFuncionario.setIcon(new ImageIcon(Principal.class.getResource("/icones/icons8-gest\u00E3o-de-cliente.png")));
		menuBar.add(mnFuncionario);

		JMenuItem mntmCadastrar = new JMenuItem("Cadastrar");
		mntmCadastrar.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		mntmCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				contentPane = new CadastroFuncionario();
				setContentPane(contentPane);
				revalidate();
			
			}
		});
		mntmCadastrar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F3, 0));
		mntmCadastrar.setIcon(new ImageIcon(Principal.class.getResource("/icones/icons8-adicionar-usu\u00E1rio-masculino.png")));
		mnFuncionario.add(mntmCadastrar);

		JMenuItem mntmExcluir = new JMenuItem("Excluir");
		mntmExcluir.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		mntmExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				contentPane = new DeletarFuncionario();
				setContentPane(contentPane);
				revalidate();
			}
		});
		mntmExcluir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, 0));
		mntmExcluir.setIcon(new ImageIcon(Principal.class.getResource("/icones/icons8-seguran\u00E7a-verificada.png")));
		mnFuncionario.add(mntmExcluir);

		JMenuItem mntmAlterar = new JMenuItem("Alterar");
		mntmAlterar.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		mntmAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				contentPane = new AlterarFuncionario();
				setContentPane(contentPane);
				revalidate();
				
			}
		});
		mntmAlterar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F5, 0));
		mntmAlterar.setIcon(new ImageIcon(Principal.class.getResource("/icones/icons8-documento-regular.png")));
		mnFuncionario.add(mntmAlterar);

		JMenuItem mntmBuscar = new JMenuItem("Buscar");
		mntmBuscar.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		mntmBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
					contentPane = new ListarTodos();
					setContentPane(contentPane);
					revalidate();
								
			}
		});
		mntmBuscar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F6, 0));
		mntmBuscar.setIcon(new ImageIcon(Principal.class.getResource("/icones/icons8-fila.png")));
		mnFuncionario.add(mntmBuscar);

		JMenu mnProduto = new JMenu("Produto");
		mnProduto.setFont(new Font("Segoe UI", Font.PLAIN, 22));
		mnProduto.setIcon(new ImageIcon(Principal.class.getResource("/icones/icons8-comprar.png")));
		menuBar.add(mnProduto);

		JMenuItem mntmCadastrarProduto = new JMenuItem("Cadastrar");
		mntmCadastrarProduto.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		mntmCadastrarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				contentPane = new CadastroProduto();
				setContentPane(contentPane);
				revalidate();
								
			}
		});
		mntmCadastrarProduto.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F7, 0));
		mntmCadastrarProduto.setIcon(new ImageIcon(Principal.class.getResource("/icones/icons8-adicionar-ao-banco-de-dados.png")));
		mnProduto.add(mntmCadastrarProduto);

		JMenuItem mntmListarTodos = new JMenuItem("Listar Todos");
		mntmListarTodos.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		mntmListarTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				contentPane = new ListarTodosProdutos();
				setContentPane(contentPane);
				revalidate();
							
			}
		});
		
		JMenuItem mntmDeletar = new JMenuItem("Excluir");
		mntmDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				contentPane = new DeletarProduto();
				setContentPane(contentPane);
				revalidate();
				
			}
		});
		mntmDeletar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F8, 0));
		mntmDeletar.setIcon(new ImageIcon(Principal.class.getResource("/icones/icons8-seguran\u00E7a-verificada.png")));
		mntmDeletar.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		mnProduto.add(mntmDeletar);
		
		JMenuItem mntmAlterarProduto = new JMenuItem("Alterar");
		mntmAlterarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				contentPane = new AlterarProduto();
				setContentPane(contentPane);
				revalidate();
				
				
			}
		});
		mntmAlterarProduto.setIcon(new ImageIcon(Principal.class.getResource("/icones/icons8-documento-regular.png")));
		mntmAlterarProduto.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F9, 0));
		mntmAlterarProduto.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		mnProduto.add(mntmAlterarProduto);
		mntmListarTodos.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F10, 0));
		mntmListarTodos.setIcon(new ImageIcon(Principal.class.getResource("/icones/icons8-lista-com-marcadores.png")));
		mnProduto.add(mntmListarTodos);

		JMenu mnNewMenu = new JMenu("Sobre");
		mnNewMenu.setFont(new Font("Segoe UI", Font.PLAIN, 22));
		mnNewMenu.setIcon(new ImageIcon(Principal.class.getResource("/icones/icons8-cart\u00E3o-de-cr\u00E9dito-sem-contato.png")));
		menuBar.add(mnNewMenu);

		JMenuItem mntmManual = new JMenuItem("Manual");
		mntmManual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				java.awt.Desktop desktop = java.awt.Desktop.getDesktop();
				try {
					desktop.open(new File ("C:\\Manual-de-utilização-do-WordPress.pdf"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		mntmManual.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		mntmManual.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F11, 0));
		mntmManual.setIcon(new ImageIcon(Principal.class.getResource("/icones/icons8-gerente-de-informa\u00E7\u00F5es-do-cliente.png")));
		mnNewMenu.add(mntmManual);

		JMenuItem mntmAjuda = new JMenuItem("Ajuda");
		mntmAjuda.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		mntmAjuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (ajuda == null) {
					ajuda = new Ajuda();
					ajuda.setVisible(true);
				}
			}
		});
		mntmAjuda.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F12, 0));
		mntmAjuda.setIcon(new ImageIcon(Principal.class.getResource("/icones/icons8-suporte-on-line-filled.png")));
		mnNewMenu.add(mntmAjuda);

		JMenuItem mntmAutores = new JMenuItem("Autores");
		mntmAutores.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		mntmAutores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(s == null) {
				s = new TelaSobre();
				s.setVisible(true);
				}
			}
		});
		mntmAutores.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F13, 0));
		mntmAutores.setIcon(new ImageIcon(Principal.class.getResource("/icones/icons8-\u0441harlie-\u0441haplin.png")));
		mnNewMenu.add(mntmAutores);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 987, 618);
		contentPane.add(panel);
	}
}
