package br.sc.senac.dd.aula04.exercicio;

public class Moto extends Automovel{
	
	private int cilindradas;

	public Moto(String fabricante, String modelo, int ano, String chassi, int numRodas, int cilindradas) {
		super(fabricante, modelo, ano, chassi, Automovel.NUMERO_RODAS_MOTO_PADRAO);
		this.cilindradas = cilindradas;
	}

	public Moto() {
		super();
	}

	public int getCilindradas() {
		return cilindradas;
	}

	public void setCilindradas(int cilindradas) {
		this.cilindradas = cilindradas;
	}
	
	
	
}
