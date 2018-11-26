package Clinica_Medica.View;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Clinica_Medica.View.Consulta.TelaCadastrarConsulta;
import Clinica_Medica.View.Consulta.TelaExcluirConsulta;
import Clinica_Medica.View.Consulta.TelaListarTodasConsultas;
import Clinica_Medica.View.Convenio.TelaCadastrarConvenio;
import Clinica_Medica.View.Convenio.TelaExcluirConvenio;
import Clinica_Medica.View.Convenio.TelaListarTodosConvenios;
import Clinica_Medica.View.Especialidade.TelaCadastrarEspecialidade;
import Clinica_Medica.View.Especialidade.TelaExcluirEspecialidade;
import Clinica_Medica.View.Especialidade.TelaListarTodasEspecialidades;
import Clinica_Medica.View.Especializacao.TelaCadastrarEspecializacaoTabela;
import Clinica_Medica.View.Especializacao.TelaExcluirEspecializacao;
import Clinica_Medica.View.Especializacao.TelaListarTodasEspecializacoes;
import Clinica_Medica.View.Medico.TelaCadastrarMedico;
import Clinica_Medica.View.Medico.TelaExcluirMedico;
import Clinica_Medica.View.Medico.TelaListarTodosMedicos;
import Clinica_Medica.View.Paciente.TelaCadastrarPaciente;
import Clinica_Medica.View.Paciente.TelaExcluirPaciente;
import Clinica_Medica.View.Paciente.TelaListarTodosPacientes;
import Clinica_Medica.View.Prontuario.TelaCadastrarProntuario;
import Clinica_Medica.View.Prontuario.TelaExcluirProntuario;
import Clinica_Medica.View.Prontuario.TelaListarTodosProntuarios;
import Clinica_Medica.View.Sobre.TelaAjuda;
import Clinica_Medica.View.Sobre.TelaSobre;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class TelaPrincipal extends JFrame {

	private JPanel contentPane;
	TelaCadastrarMedico cadastrarMedico = null;
	TelaCadastrarPaciente cadastrarPaciente = null;
	TelaCadastrarConvenio cadastrarConvenio = null;
	TelaCadastrarEspecialidade cadastrarEspecialidade = null;
	TelaCadastrarEspecializacaoTabela cadastrarEspecializacao = null;
	TelaCadastrarConsulta cadastrarConsulta = null;
	TelaCadastrarProntuario cadastrarProntuario = null;
	TelaExcluirConsulta excluirConsulta = null;
	TelaExcluirMedico cexcluirMedico = null;
	TelaExcluirPaciente excluirPaciente = null;
	TelaExcluirConvenio excluirConvenio = null;
	TelaExcluirEspecialidade excluirEspecialidade = null;
	TelaExcluirEspecializacao excluirEspecializacao = null;
	TelaExcluirProntuario excluirProntuario = null;
	TelaListarTodasConsultas listarConsultas = null;
	TelaListarTodosMedicos listarMedicos = null;
	TelaListarTodosPacientes listarPacientes = null;
	TelaListarTodosConvenios listarConvenios = null;
	TelaListarTodasEspecialidades listarEspecialidades = null;
	TelaListarTodasEspecializacoes listarEspecializacoes = null;
	TelaListarTodosProntuarios listarProntuarios = null;
	TelaAjuda ajuda = null;
	TelaSobre telaSobre = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
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
	public TelaPrincipal() {
		setFont(new Font("Tahoma", Font.PLAIN, 20));
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaPrincipal.class.getResource("/icones/icons8-caduceus-30.png")));
		setTitle("Cl\u00EDnica M\u00E9dica AVICENA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 832, 367);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnConsulta = new JMenu("Consulta");
		mnConsulta.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		mnConsulta.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/icones/icons8-stethoscope-50.png")));
		menuBar.add(mnConsulta);
		
		JMenuItem mntmCadastrarconsulta = new JMenuItem("Cadastrar Consulta");
		mntmCadastrarconsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				contentPane = new TelaCadastrarConsulta();
				setContentPane (contentPane);
				revalidate();
				
			}
		});
		mntmCadastrarconsulta.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		mntmCadastrarconsulta.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/icones/icons8-salvar-64.png")));
		mnConsulta.add(mntmCadastrarconsulta);
		
		JMenuItem mntmExcluirConsulta = new JMenuItem("Alterar/Excluir Consulta");
		mntmExcluirConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				contentPane = new TelaExcluirConsulta();
				setContentPane (contentPane);
				revalidate();
			}
		});
		mntmExcluirConsulta.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/icones/icons8-cancel-48.png")));
		mntmExcluirConsulta.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		mnConsulta.add(mntmExcluirConsulta);
		
		JMenuItem mntmListarTodos = new JMenuItem("Listar Todos");
		mntmListarTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				contentPane = new TelaListarTodasConsultas();
				setContentPane (contentPane);
				revalidate();
			}
		});
		mntmListarTodos.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/icones/icons8-list-48.png")));
		mntmListarTodos.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		mnConsulta.add(mntmListarTodos);
		
		JMenu mnPaciente = new JMenu("Paciente");
		mnPaciente.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/icones/icons8-verifique-macho.png")));
		mnPaciente.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuBar.add(mnPaciente);
		
		JMenuItem mntmCadastrar = new JMenuItem("Cadastrar/Alterar Paciente");
		mntmCadastrar.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/icones/icons8-salvar-64.png")));
		mntmCadastrar.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		mntmCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				contentPane = new TelaCadastrarPaciente();
				setContentPane (contentPane);
				revalidate();
			
			}
		});
		mnPaciente.add(mntmCadastrar);
		
		JMenuItem mntmExcluirPaciente = new JMenuItem("Excluir Paciente");
		mntmExcluirPaciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane = new TelaExcluirPaciente();
				setContentPane (contentPane);
				revalidate();
			}
		});
		mntmExcluirPaciente.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/icones/icons8-cancel-48.png")));
		mntmExcluirPaciente.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		mnPaciente.add(mntmExcluirPaciente);
		
		JMenuItem mntmListarTodos_1 = new JMenuItem("Listar Todos");
		mntmListarTodos_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				contentPane = new TelaListarTodosPacientes();
				setContentPane (contentPane);
				revalidate();
			}
		});
		mntmListarTodos_1.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/icones/icons8-list-48.png")));
		mntmListarTodos_1.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		mnPaciente.add(mntmListarTodos_1);
		
		JMenu mnProntuario = new JMenu("Prontuario");
		mnProntuario.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/icones/icons8-checklist-48.png")));
		mnProntuario.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuBar.add(mnProntuario);
		
		JMenuItem mntmCadastrarProntuario = new JMenuItem("Cadastrar/Alterar Prontuario");
		mntmCadastrarProntuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				contentPane = new TelaCadastrarProntuario();
				setContentPane (contentPane);
				revalidate();
				
			}
		});
		mntmCadastrarProntuario.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/icones/icons8-salvar-64.png")));
		mntmCadastrarProntuario.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		mnProntuario.add(mntmCadastrarProntuario);
		
		JMenuItem mntmExcluirProntuario = new JMenuItem("Excluir Prontuario");
		mntmExcluirProntuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				contentPane = new TelaExcluirProntuario();
				setContentPane (contentPane);
				revalidate();
			}
		});
		mntmExcluirProntuario.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/icones/icons8-cancel-48.png")));
		mntmExcluirProntuario.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		mnProntuario.add(mntmExcluirProntuario);
		
		JMenuItem mntmListarProntuario = new JMenuItem("Listar Prontuario");
		mntmListarProntuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				contentPane = new TelaListarTodosProntuarios();
				setContentPane (contentPane);
				revalidate();
				
			}
		});
		mntmListarProntuario.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/icones/icons8-list-48.png")));
		mntmListarProntuario.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		mnProntuario.add(mntmListarProntuario);
		
		JMenu mnConvenio = new JMenu("Convenio");
		mnConvenio.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/icones/icons8-clinic-48.png")));
		mnConvenio.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuBar.add(mnConvenio);
		
		JMenuItem mntmCadastrarConvenio = new JMenuItem("Cadastrar/Alterar Convenio");
		mntmCadastrarConvenio.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/icones/icons8-salvar-64.png")));
		mntmCadastrarConvenio.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		mntmCadastrarConvenio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				contentPane = new TelaCadastrarConvenio();
				setContentPane (contentPane);
				revalidate();
			}
		});
		mnConvenio.add(mntmCadastrarConvenio);
		
		JMenuItem mntmExcluirConvenio = new JMenuItem("Excluir Convenio");
		mntmExcluirConvenio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				contentPane = new TelaExcluirConvenio();
				setContentPane (contentPane);
				revalidate();
			}
		});
		mntmExcluirConvenio.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/icones/icons8-cancel-48.png")));
		mntmExcluirConvenio.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		mnConvenio.add(mntmExcluirConvenio);
		
		JMenuItem mntmListarTodos_2 = new JMenuItem("Listar Todos");
		mntmListarTodos_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				contentPane = new TelaListarTodosConvenios();
				setContentPane (contentPane);
				revalidate();
			}
		});
		mntmListarTodos_2.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/icones/icons8-list-48.png")));
		mntmListarTodos_2.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		mnConvenio.add(mntmListarTodos_2);
		
		JMenu mnMdico = new JMenu("M\u00E9dico");
		mnMdico.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/icones/icons8-chief-of-medicine-skin-type-1-64.png")));
		mnMdico.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuBar.add(mnMdico);
		
		JMenuItem mntmCadastrarMedico = new JMenuItem("Cadastrar/Alterar Medico");
		mntmCadastrarMedico.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/icones/icons8-salvar-64.png")));
		mntmCadastrarMedico.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		mntmCadastrarMedico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				contentPane = new TelaCadastrarMedico();
				setContentPane (contentPane);
				revalidate();
				
			}
		});
		mnMdico.add(mntmCadastrarMedico);
		
		JMenuItem mntmExcluirMedico = new JMenuItem("Excluir Medico");
		mntmExcluirMedico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				contentPane = new TelaExcluirMedico();
				setContentPane (contentPane);
				revalidate();
			}
		});
		mntmExcluirMedico.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/icones/icons8-cancel-48.png")));
		mntmExcluirMedico.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		mnMdico.add(mntmExcluirMedico);
		
		JMenuItem mntmListarTodos_3 = new JMenuItem("Listar Todos");
		mntmListarTodos_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				contentPane = new TelaListarTodosMedicos();
				setContentPane (contentPane);
				revalidate();
			}
		});
		mntmListarTodos_3.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/icones/icons8-list-48.png")));
		mntmListarTodos_3.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		mnMdico.add(mntmListarTodos_3);
		
		JMenu mnEspecialidade = new JMenu("Especialidade");
		mnEspecialidade.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/icones/icons8-mortarboard-64.png")));
		mnEspecialidade.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuBar.add(mnEspecialidade);
		
		JMenuItem mntmCadastrarEspecialidade = new JMenuItem("Cadastrar/Alterar Especialidade");
		mntmCadastrarEspecialidade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				contentPane = new TelaCadastrarEspecialidade();
				setContentPane (contentPane);
				revalidate();
				
			}
		});
		mntmCadastrarEspecialidade.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/icones/icons8-salvar-64.png")));
		mntmCadastrarEspecialidade.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		mnEspecialidade.add(mntmCadastrarEspecialidade);
		
		JMenuItem mntmExcluirEspecialidade = new JMenuItem("Excluir Especialidade");
		mntmExcluirEspecialidade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				contentPane = new TelaExcluirEspecialidade();
				setContentPane (contentPane);
				revalidate();
			}
		});
		mntmExcluirEspecialidade.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/icones/icons8-cancel-48.png")));
		mntmExcluirEspecialidade.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		mnEspecialidade.add(mntmExcluirEspecialidade);
		
		JMenuItem mntmListarEspecialidade = new JMenuItem("Listar Especialidade");
		mntmListarEspecialidade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				contentPane = new TelaListarTodasEspecialidades();
				setContentPane (contentPane);
				revalidate();
			}
		});
		mntmListarEspecialidade.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/icones/icons8-list-48.png")));
		mntmListarEspecialidade.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		mnEspecialidade.add(mntmListarEspecialidade);
		
		JMenu mnEspecializacao = new JMenu("Especializacao");
		mnEspecializacao.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/icones/icons8-medical-bag-64.png")));
		mnEspecializacao.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuBar.add(mnEspecializacao);
		
		JMenuItem mntmCadastrarEspecializacao = new JMenuItem("Cadastrar/Alterar Especializacao");
		mntmCadastrarEspecializacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				contentPane = new TelaCadastrarEspecializacaoTabela();
				setContentPane (contentPane);
				revalidate();
				
			}
			
		});
		mntmCadastrarEspecializacao.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/icones/icons8-salvar-64.png")));
		mntmCadastrarEspecializacao.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		mnEspecializacao.add(mntmCadastrarEspecializacao);
		
		JMenuItem mntmExcluirEspecializacao = new JMenuItem("Excluir Especializacao");
		mntmExcluirEspecializacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				contentPane = new TelaExcluirEspecializacao();
				setContentPane (contentPane);
				revalidate();
				
			}
		});
		mntmExcluirEspecializacao.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/icones/icons8-cancel-48.png")));
		mntmExcluirEspecializacao.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		mnEspecializacao.add(mntmExcluirEspecializacao);
		
		JMenuItem mntmListasTodas = new JMenuItem("Listas Todas");
		mntmListasTodas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				contentPane = new TelaListarTodasEspecializacoes();
				setContentPane (contentPane);
				revalidate();
			}
		});
		mntmListasTodas.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/icones/icons8-list-48.png")));
		mntmListasTodas.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		mnEspecializacao.add(mntmListasTodas);
		
		JMenu mnSobre = new JMenu("Sobre");
		mnSobre.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/icones/icons8-search-50.png")));
		mnSobre.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuBar.add(mnSobre);
		
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
		mntmManual.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/icones/icons8-confian\u00E7a.png")));
		mntmManual.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		mnSobre.add(mntmManual);
		
		JMenuItem mntmAjuda = new JMenuItem("Ajuda");
		mntmAjuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (ajuda == null) {
					ajuda = new TelaAjuda();
					ajuda.setVisible(true);
				}
			}
		});
		mntmAjuda.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/icones/icons8-suporte-on-line-filled.png")));
		mntmAjuda.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		mnSobre.add(mntmAjuda);
		
		JMenuItem mntmAutores = new JMenuItem("Autores");
		mntmAutores.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
					
					if(telaSobre == null) {
					telaSobre = new TelaSobre();
					telaSobre.setVisible(true);
					}
			}
		});
		mntmAutores.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/icones/icons8-fila.png")));
		mntmAutores.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		mnSobre.add(mntmAutores);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
