package Clinica_Medica.View.Especializacao;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import Clinica_Medica.Controller.EspecializacaoController;
import Clinica_Medica.VO.EspecialidadeVO;
import Clinica_Medica.VO.EspecializacaoVO;
import Clinica_Medica.VO.MedicoVO;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaCadastrarEspecializacao extends JPanel {
	private JTextField txtIdMedico;
	private JTextField txtNomeMedico;
	private JTextField txtIdEspecialidade;
	private JTextField txtNomeEspecialidade;
	private JTextField txtAno;
	private EspecializacaoVO especializacao = new EspecializacaoVO();
	private MedicoVO medico = new MedicoVO();
	private EspecialidadeVO especialidade = new EspecialidadeVO();

	/**
	 * Create the panel.
	 */
	public TelaCadastrarEspecializacao() {
		setBackground(new Color(230, 230, 250));
		setLayout(null);
		
		JLabel lblIdMedico = new JLabel("ID M\u00E9dico");
		lblIdMedico.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblIdMedico.setBounds(25, 39, 91, 31);
		add(lblIdMedico);
		
		JLabel lblIdEspecialidade = new JLabel("ID Especialidade");
		lblIdEspecialidade.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblIdEspecialidade.setBounds(25, 105, 142, 26);
		add(lblIdEspecialidade);
		
		JLabel lblAno = new JLabel("Ano");
		lblAno.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAno.setBounds(25, 160, 46, 31);
		add(lblAno);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int opcao;
                Object[] BtSair={"Sim","Não"};
                 
                opcao = JOptionPane.showOptionDialog(null,"Deseja sair desta operação?", 
                        "Fechar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                        null, BtSair, BtSair[0]);
                        if(opcao == JOptionPane.YES_OPTION) {
                        	 setVisible(false);
                        }
			}
		});
		btnSair.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSair.setBounds(446, 242, 107, 31);
		add(btnSair);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EspecializacaoController controlador = new EspecializacaoController();
				EspecializacaoVO especializacao = construirEspecializacao();

				String mensagem = controlador.salvar(especializacao);
//				if(especializacao.getEspCod()!= 0) {
//					txtNomeEspecialidade.setText(especialidade.getEspNome());
//				}
//				 if(medico.getMedCod()!=0) {
//					 txtNomeMedico.setText(medico.getMedNome());
//				 }
//				
				
				JOptionPane.showMessageDialog(null, mensagem);
				limparTela();
				
			}
		});
		btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnCadastrar.setBounds(322, 242, 114, 31);
		add(btnCadastrar);
		
		txtIdMedico = new JTextField();
		txtIdMedico.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtIdMedico.setBounds(165, 44, 62, 31);
		add(txtIdMedico);
		txtIdMedico.setColumns(10);
		
		txtNomeMedico = new JTextField();
		txtNomeMedico.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtNomeMedico.setBounds(237, 44, 316, 31);
		add(txtNomeMedico);
		txtNomeMedico.setColumns(10);
		
		txtIdEspecialidade = new JTextField();
		txtIdEspecialidade.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtIdEspecialidade.setBounds(165, 103, 62, 31);
		add(txtIdEspecialidade);
		txtIdEspecialidade.setColumns(10);
		
		txtNomeEspecialidade = new JTextField();
		txtNomeEspecialidade.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtNomeEspecialidade.setBounds(237, 103, 316, 31);
		add(txtNomeEspecialidade);
		txtNomeEspecialidade.setColumns(10);
		
		txtAno = new JTextField();
		txtAno.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtAno.setBounds(81, 158, 86, 34);
		add(txtAno);
		txtAno.setColumns(10);
		
		JButton btnLimparTela = new JButton("Limpar Tela");
		btnLimparTela.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				limparTela();
			}
		});
		btnLimparTela.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnLimparTela.setBounds(25, 242, 142, 31);
		add(btnLimparTela);
		
		JButton btnAltetrar = new JButton("Alterar");
		btnAltetrar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAltetrar.setBounds(186, 242, 126, 31);
		add(btnAltetrar);

	}

	protected EspecializacaoVO construirEspecializacao() {
		especializacao.setEspCod(Integer.parseInt(txtIdEspecialidade.getText()));
		especializacao.setMedCod(Integer.parseInt(txtIdMedico.getText()));
		especializacao.setEspeAno(txtAno.getText());
		
		return especializacao;
	}

	protected void limparTela() {
	txtAno.setText("");
	txtIdEspecialidade.setText("");
	txtIdMedico.setText("");
	txtNomeEspecialidade.setText("");
	txtNomeMedico.setText("");
		
	}
}
