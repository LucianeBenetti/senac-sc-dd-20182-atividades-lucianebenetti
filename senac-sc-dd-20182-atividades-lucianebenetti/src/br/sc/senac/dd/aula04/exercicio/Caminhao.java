package br.sc.senac.dd.aula04.exercicio;

public class Caminhao extends Automovel{
	
	private static final double CAPACIDADE_DEZ_TONELADAS = 0;
	private int eixos;
	private Carroceria carroceria;
	
	public Caminhao(String fabricante, String modelo, int ano, String chassi, int eixos,
			Carroceria carroceria) {
		super(fabricante, modelo, ano, chassi);
		this.eixos = eixos;
		this.carroceria = carroceria;
		
		if(this.getCarroceria().getCapacidade() > CAPACIDADE_DEZ_TONELADAS) {
			this.eixos = 4;
			
		}else {
			this.eixos = 3;
		}
	}

	public Caminhao() {
		super();
	}

	public int getEixos() {
		return eixos;
	}

	public void setEixos(int eixos) {
		this.eixos = eixos;
	}

	public Carroceria getCarroceria() {
		return carroceria;
	}

	public void setCarroceria(Carroceria carroceria) {
		this.carroceria = carroceria;
	}

	public void cadastrarCaminhao() {
	
		
	}

	public void setCarroceria(String showInputDialog) {
		// TODO Auto-generated method stub
		
	}
	
	
}
