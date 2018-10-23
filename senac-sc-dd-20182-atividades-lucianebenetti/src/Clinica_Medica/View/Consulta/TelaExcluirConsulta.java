package Clinica_Medica.View.Consulta;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import javax.swing.JSeparator;
import java.awt.Color;

public class TelaExcluirConsulta extends JPanel {

	/**
	 * Create the panel.
	 */
	public TelaExcluirConsulta() {
		setBackground(new Color(173, 216, 230));
		setLayout(null);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
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
		btnSair.setBounds(436, 267, 89, 31);
		add(btnSair);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnBuscar.setBounds(436, 11, 89, 31);
		add(btnBuscar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnExcluir.setBounds(230, 267, 100, 31);
		add(btnExcluir);
		
		JButton btnLimparTela = new JButton("Limpar Tela");
		btnLimparTela.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnLimparTela.setBounds(10, 267, 134, 31);
		add(btnLimparTela);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 53, 515, 16);
		add(separator);

	}

}
