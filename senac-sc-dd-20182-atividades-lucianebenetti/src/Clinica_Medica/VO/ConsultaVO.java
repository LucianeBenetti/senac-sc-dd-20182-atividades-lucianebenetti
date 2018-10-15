package Clinica_Medica.VO;

import java.util.Date;

public class ConsultaVO {
	
	
	private int conCod;
	private int espeCod;
	private int pacCod;
	private int convCod;
	private String conTipo;
	private Date dataMarcacao;
	private Date dataRealizacao;
	
	public ConsultaVO(int conCod, int espeCod, int pacCod, int convCod, String conTipo, Date dataMarcacao,
			Date dataRealizacao) {
		super();
		this.conCod = conCod;
		this.espeCod = espeCod;
		this.pacCod = pacCod;
		this.convCod = convCod;
		this.conTipo = conTipo;
		this.dataMarcacao = dataMarcacao;
		this.dataRealizacao = dataRealizacao;
	}

	public ConsultaVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getConCod() {
		return conCod;
	}

	public void setConCod(int conCod) {
		this.conCod = conCod;
	}

	public int getEspeCod() {
		return espeCod;
	}

	public void setEspeCod(int espeCod) {
		this.espeCod = espeCod;
	}

	public int getPacCod() {
		return pacCod;
	}

	public void setPacCod(int pacCod) {
		this.pacCod = pacCod;
	}

	public int getConvCod() {
		return convCod;
	}

	public void setConvCod(int convCod) {
		this.convCod = convCod;
	}

	public String getConTipo() {
		return conTipo;
	}

	public void setConTipo(String conTipo) {
		this.conTipo = conTipo;
	}

	public Date getDataMarcacao() {
		return dataMarcacao;
	}

	public void setDataMarcacao(Date dataMarcacao) {
		this.dataMarcacao = dataMarcacao;
	}

	public Date getDataRealizacao() {
		return dataRealizacao;
	}

	public void setDataRealizacao(Date dataRealizacao) {
		this.dataRealizacao = dataRealizacao;
	}
	
	
	
}
