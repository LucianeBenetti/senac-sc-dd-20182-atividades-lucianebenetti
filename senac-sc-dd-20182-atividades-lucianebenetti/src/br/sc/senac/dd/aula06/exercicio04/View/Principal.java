package br.sc.senac.dd.aula06.exercicio04.View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.sc.senac.dd.aula06.Produto.View.CadastroProduto;
import br.sc.senac.dd.aula06.Produto.View.ListarTodosProdutos;

import java.awt.Toolkit;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal extends JFrame {

	private JPanel contentPane;
	private JDesktopPane desktopPane;
	CadastroProduto cadastroProduto = null;
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1009, 726);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnFuncionario = new JMenu("Funcionario");
		mnFuncionario.setIcon(new ImageIcon(Principal.class.getResource("/icones/icons8-gest\u00E3o-de-cliente.png")));
		menuBar.add(mnFuncionario);

		JMenuItem mntmCadastrar = new JMenuItem("Cadastrar");
		mntmCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			if(cadastroFuncionario ==null) {
				cadastroFuncionario = new CadastroFuncionario();
				desktopPane.add(cadastroFuncionario);
				cadastroFuncionario.show();
			}
			}
		});
		mntmCadastrar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F3, 0));
		mntmCadastrar.setIcon(new ImageIcon(Principal.class.getResource("/icones/icons8-adicionar-usu\u00E1rio-masculino.png")));
		mnFuncionario.add(mntmCadastrar);

		JMenuItem mntmExcluir = new JMenuItem("Excluir");
		mntmExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
			if(deletarFuncionario == null) {
				deletarFuncionario = new DeletarFuncionario();
				desktopPane.add(deletarFuncionario);
				deletarFuncionario.show();
			}
			}
		});
		mntmExcluir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, 0));
		mntmExcluir.setIcon(new ImageIcon(Principal.class.getResource("/icones/icons8-seguran\u00E7a-verificada.png")));
		mnFuncionario.add(mntmExcluir);

		JMenuItem mntmAlterar = new JMenuItem("Alterar");
		mntmAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(alterarFuncionario == null) {
				alterarFuncionario = new AlterarFuncionario();
				desktopPane.add(alterarFuncionario);
				alterarFuncionario.show();
				}
			}
		});
		mntmAlterar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F5, 0));
		mntmAlterar.setIcon(new ImageIcon(Principal.class.getResource("/icones/icons8-documento-regular.png")));
		mnFuncionario.add(mntmAlterar);

		JMenuItem mntmBuscar = new JMenuItem("Buscar");
		mntmBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(listarTodosFuncionarios == null) {
				listarTodosFuncionarios = new ListarTodos();
				desktopPane.add(listarTodosFuncionarios);
				listarTodosFuncionarios.show();
				}
			}
		});
		mntmBuscar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F6, 0));
		mntmBuscar.setIcon(new ImageIcon(Principal.class.getResource("/icones/icons8-fila.png")));
		mnFuncionario.add(mntmBuscar);

		JMenu mnProduto = new JMenu("Produto");
		mnProduto.setIcon(new ImageIcon(Principal.class.getResource("/icones/icons8-comprar.png")));
		menuBar.add(mnProduto);

		JMenuItem mntmCadastrarProduto = new JMenuItem("Cadastrar");
		mntmCadastrarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(cadastroProduto == null) {
				cadastroProduto = new CadastroProduto();
				desktopPane.add(cadastroProduto);
				cadastroProduto.show();
				}
				
			}
		});
		mntmCadastrarProduto.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F7, 0));
		mntmCadastrarProduto.setIcon(new ImageIcon(Principal.class.getResource("/icones/icons8-adicionar-ao-banco-de-dados.png")));
		mnProduto.add(mntmCadastrarProduto);

		JMenuItem mntmListarTodos = new JMenuItem("Listar Todos");
		mntmListarTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(listarTodosProdutos == null) {
				listarTodosProdutos = new ListarTodosProdutos();
				desktopPane.add(listarTodosProdutos);
				listarTodosProdutos.show();
				}
				
			}
		});
		mntmListarTodos.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F8, 0));
		mntmListarTodos.setIcon(new ImageIcon(Principal.class.getResource("/icones/icons8-documento-regular.png")));
		mnProduto.add(mntmListarTodos);

		JMenu mnNewMenu = new JMenu("Sobre");
		mnNewMenu.setIcon(new ImageIcon(Principal.class.getResource("/icones/icons8-cart\u00E3o-de-cr\u00E9dito-sem-contato.png")));
		menuBar.add(mnNewMenu);

		JMenuItem mntmManual = new JMenuItem("Manual");
		mntmManual.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F10, 0));
		mntmManual.setIcon(new ImageIcon(Principal.class.getResource("/icones/icons8-gerente-de-informa\u00E7\u00F5es-do-cliente.png")));
		mnNewMenu.add(mntmManual);

		JMenuItem mntmAjuda = new JMenuItem("Ajuda");
		mntmAjuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (ajuda == null) {
					ajuda = new Ajuda();
					ajuda.setVisible(true);
				}
			}
		});
		mntmAjuda.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F11, 0));
		mntmAjuda.setIcon(new ImageIcon(Principal.class.getResource("/icones/icons8-suporte-on-line-filled.png")));
		mnNewMenu.add(mntmAjuda);

		JMenuItem mntmAutores = new JMenuItem("Autores");
		mntmAutores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(s == null) {
				s = new TelaSobre();
				s.setVisible(true);
				}
			}
		});
		mntmAutores.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F12, 0));
		mntmAutores.setIcon(new ImageIcon(Principal.class.getResource("/icones/icons8-\u0441harlie-\u0441haplin.png")));
		mnNewMenu.add(mntmAutores);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		desktopPane = new JDesktopPane();
		desktopPane.setBounds(10, 10, 1850, 900);
		contentPane.add(desktopPane);
	}
}
