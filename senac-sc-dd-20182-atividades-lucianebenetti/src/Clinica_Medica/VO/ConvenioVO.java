package Clinica_Medica.VO;

public class ConvenioVO {
	
	private int convCod;
	private String convNome;
	private String convCnpj;
	private double valor;
	
	public ConvenioVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ConvenioVO(int convCod, String convNome, String convCnpj, double valor) {
		super();
		this.convCod = convCod;
		this.convNome = convNome;
		this.convCnpj = convCnpj;
		this.valor = valor;
	}

	public int getConvCod() {
		return convCod;
	}

	public void setConvCod(int convCod) {
		this.convCod = convCod;
	}

	public String getConvNome() {
		return convNome;
	}

	public void setConvNome(String convNome) {
		this.convNome = convNome;
	}

	public String getConvCnpj() {
		return convCnpj;
	}

	public void setConvCnpj(String convCnpj) {
		this.convCnpj = convCnpj;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	
	
}
