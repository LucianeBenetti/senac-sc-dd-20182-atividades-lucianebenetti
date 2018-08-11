package br.sc.senac.dd.aula04.exercicio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Menu {
	public List<Caminhao>caminhoes = new ArrayList<Caminhao>();
	public List<Carro>carros = new ArrayList<Carro>();
	public List<Moto>motos = new ArrayList<Moto>();

 Scanner teclado = new Scanner(System.in);
    private static final int CADASTRAR_MOTO = 1;
	private static final int CADASTRAR_CAMINHAO = 2;
	private static final int CADASTRAR_CARRO = 3;
	private static final int EXIBIR_CAMINHAO_CARRO = 4;
	private static final int EXIBIR_MOTO = 5;
	private static final int SAIR = 6;
	
	public void apresentarMenu() {
		
		int opcao = -1;
		
		while (opcao != SAIR){
			try {
				opcao = Integer.parseInt(JOptionPane.showInputDialog(criarOpcoesMenu()));
			}catch(NumberFormatException ex) {
				JOptionPane.showMessageDialog(null, "Valor informado deve ser um número inteiro entre 1 e 6");
			} 
				
			switch(opcao){
			case CADASTRAR_MOTO: {
				this.cadastrarMoto();
				break;
			}
			case CADASTRAR_CAMINHAO: {
				this.cadastrarCaminhao();
				break;
			}
			case CADASTRAR_CARRO: {
				this.cadastrarCarro();
				break;
			}
			case EXIBIR_CAMINHAO_CARRO: {
				this.exibirCaminhaoCarro();
				break; 
			}
			case EXIBIR_MOTO: {
				this.exibirMoto();
				break;
			}
			case SAIR: {
				int resposta = JOptionPane.showConfirmDialog(null, "Tem certeza?");
				if(resposta == 0) {
					JOptionPane.showMessageDialog(null, "Você foi desconectado do sistema!");
				}
				break;
			}
			default: {
				JOptionPane.showMessageDialog(null, "Opção Inválida");
				break;
				}
			}
			
		}
	}

	public String criarOpcoesMenu() {
		String mensagem = "Sistema Gerenciador de Automóveis";
		mensagem += "\n Opções:";
		mensagem += "\n 1 - Cadastrar Moto.";
		mensagem += "\n 2 - Cadastrar Caminhão.";
		mensagem += "\n 3 - Cadastrar Carro.";
		mensagem += "\n 4 - Exibir Caminhão e Carro.";
		mensagem += "\n 5 - Exibir Moto.";
		mensagem += "\n 6 - Sair";
		mensagem +="\n Digite a Opção: ";
		
		return mensagem;
	}
	
	private void cadastrarCarro() {
		
		int n = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidades de carros a serem cadastrados."));
				
		for(int i = 0; i< n;i++) {
		Carro carro = new Carro();
		
		carro.setFabricante(JOptionPane.showInputDialog(null, "Digite o fabricante:"));
		carro.setModelo(JOptionPane.showInputDialog(null,"Digite o modelo:"));
		carro.setAno(Integer.parseInt(JOptionPane.showInputDialog(null,"Digite o ano:")));
		carro.setChassi(JOptionPane.showInputDialog(null,"Digite o chassi:"));
		carro.setNumRodas(Integer.parseInt(JOptionPane.showInputDialog(null,"Digite o número de rodas:")));
		carro.setCategoria(JOptionPane.showInputDialog(null,"Digite a categoria:"));
		
		carros.add(carro);
		}
		this.apresentarMenu();
}
	private void cadastrarMoto() {		
		
		int n = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidades de motos a serem cadastradas."));
				
		for(int i = 0; i< n;i++) {
		Moto moto = new Moto();
		
		moto.setFabricante(JOptionPane.showInputDialog(null, "Digite o fabricante:"));
		moto.setModelo(JOptionPane.showInputDialog(null,"Digite o modelo:"));
		moto.setAno(Integer.parseInt(JOptionPane.showInputDialog(null,"Digite o ano:")));
		moto.setChassi(JOptionPane.showInputDialog(null,"Digite o chassi:"));
		moto.setNumRodas(Integer.parseInt(JOptionPane.showInputDialog(null,"Digite o número de rodas:")));
		moto.setCilindradas(Integer.parseInt(JOptionPane.showInputDialog(null,"Digite as cilindradas:")));
		
		motos.add(moto);
		}
		
		this.apresentarMenu();
			
	}
	private void cadastrarCaminhao() {
		
		int n = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidades de caminhões a serem cadastrados."));
				
		for(int i = 0; i< n;i++) {
		Caminhao caminhao = new Caminhao();
		
		caminhao.setFabricante(JOptionPane.showInputDialog(null, "Digite o fabricante:"));
		caminhao.setModelo(JOptionPane.showInputDialog(null,"Digite o modelo:"));
		caminhao.setAno(Integer.parseInt(JOptionPane.showInputDialog(null,"Digite o ano:")));
		caminhao.setChassi(JOptionPane.showInputDialog(null,"Digite o chassi:"));
		caminhao.setNumRodas(Integer.parseInt(JOptionPane.showInputDialog(null,"Digite o número de rodas:")));
		caminhao.setEixos(Integer.parseInt(JOptionPane.showInputDialog(null,"Digite a quantidade de eixos:")));
		caminhao.setCarroceria(JOptionPane.showInputDialog(null, "Este caminhão tem carroceria?"));
		
		caminhoes.add(caminhao);
		}
		
		this.apresentarMenu();
		
	}
	
	private void exibirCaminhaoCarro() {
		
		carros.toString();
		caminhoes.toString();
		JOptionPane.showMessageDialog(null, "Lista dos carros e caminhões cadastrados");
		JOptionPane.showMessageDialog(null, carros);
		JOptionPane.showMessageDialog(null,caminhoes);
			
		this.apresentarMenu();
		
	}
	private void exibirMoto() {
		motos.toString();
		JOptionPane.showMessageDialog(null, "Lista das motos cadastradas");
		JOptionPane.showMessageDialog(null, motos);
		
		this.apresentarMenu();
		
	}
	
}