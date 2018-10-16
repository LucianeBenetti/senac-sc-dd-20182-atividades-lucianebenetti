package Clinica_Medica.VO;

import java.sql.Time;
import java.util.Date;

public class ConsultaVO {
		
	private int conCod;
	private int espeCod;
	private int pacCod;
	private int convCod;
	private int pronCod;
	private Date conData;
	private Time conHorario;
	
	public ConsultaVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ConsultaVO(int conCod, int espeCod, int pacCod, int convCod, int pronCod, Date conData, Time conHorario) {
		super();
		this.conCod = conCod;
		this.espeCod = espeCod;
		this.pacCod = pacCod;
		this.convCod = convCod;
		this.pronCod = pronCod;
		this.conData = conData;
		this.conHorario = conHorario;
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

	public int getPronCod() {
		return pronCod;
	}

	public void setPronCod(int pronCod) {
		this.pronCod = pronCod;
	}

	public Date getConData() {
		return conData;
	}

	public void setConData(Date conData) {
		this.conData = conData;
	}

	public Time getConHorario() {
		return conHorario;
	}

	public void setConHorario(Time conHorario) {
		this.conHorario = conHorario;
	}
	
	
}
