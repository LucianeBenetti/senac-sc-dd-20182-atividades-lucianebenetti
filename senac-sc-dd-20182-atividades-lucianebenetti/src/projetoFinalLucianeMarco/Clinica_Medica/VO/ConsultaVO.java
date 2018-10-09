package projetoFinalLucianeMarco.Clinica_Medica.VO;

import java.sql.Date;

public class ConsultaVO {
	
	private int conCod;
	private int pacCod;
	private int espeCod;
	private int espCod;
	private int medCod;
	private Date conHorario;
	private String conUnidade;
	private String conFuncionario;
	
	public ConsultaVO(int conCod, int pacCod, int espeCod, int espCod, int medCod, Date conHorario, String conUnidade,
			String conFuncionario) {
		super();
		this.conCod = conCod;
		this.pacCod = pacCod;
		this.espeCod = espeCod;
		this.espCod = espCod;
		this.medCod = medCod;
		this.conHorario = conHorario;
		this.conUnidade = conUnidade;
		this.conFuncionario = conFuncionario;
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

	public int getPacCod() {
		return pacCod;
	}

	public void setPacCod(int pacCod) {
		this.pacCod = pacCod;
	}

	public int getEspeCod() {
		return espeCod;
	}

	public void setEspeCod(int espeCod) {
		this.espeCod = espeCod;
	}

	public int getEspCod() {
		return espCod;
	}

	public void setEspCod(int espCod) {
		this.espCod = espCod;
	}

	public int getMedCod() {
		return medCod;
	}

	public void setMedCod(int medCod) {
		this.medCod = medCod;
	}

	public Date getConHorario() {
		return conHorario;
	}

	public void setConHorario(Date conHorario) {
		this.conHorario = conHorario;
	}

	public String getConUnidade() {
		return conUnidade;
	}

	public void setConUnidade(String conUnidade) {
		this.conUnidade = conUnidade;
	}

	public String getConFuncionario() {
		return conFuncionario;
	}

	public void setConFuncionario(String conFuncionario) {
		this.conFuncionario = conFuncionario;
	}
	
	

}
