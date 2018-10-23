package Clinica_Medica.VO;

public class ConvenioVO {

	private int codigoConvenio;
	private String nomeConvenio;
	private String cnpjConvenio;
	private double valor;

	public ConvenioVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ConvenioVO(int codigoConvenio, String nomeConvenio, String cnpjConvenio, double valor) {
		super();
		this.codigoConvenio = codigoConvenio;
		this.nomeConvenio = nomeConvenio;
		this.cnpjConvenio = cnpjConvenio;
		this.valor = valor;
	}

	public int getCodigoConvenio() {
		return codigoConvenio;
	}

	public void setCodigoConvenio(int codigoConvenio) {
		this.codigoConvenio = codigoConvenio;
	}

	public String getNomeConvenio() {
		return nomeConvenio;
	}

	public void setNomeConvenio(String nomeConvenio) {
		this.nomeConvenio = nomeConvenio;
	}

	public String getCnpjConvenio() {
		return cnpjConvenio;
	}

	public void setCnpjConvenio(String cnpjConvenio) {
		this.cnpjConvenio = cnpjConvenio;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return nomeConvenio;
	}
}
