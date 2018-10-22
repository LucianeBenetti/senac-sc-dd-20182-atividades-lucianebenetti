package Clinica_Medica.VO;

import java.util.ArrayList;

public class ProntuarioVO {
	
	private int pronCod;
	private String medicamento;
	private String exame;
	private String registro;
	
	public ProntuarioVO(int pronCod, String medicamento, String exame, String registro) {
		super();
		this.pronCod = pronCod;
		this.medicamento = medicamento;
		this.exame = exame;
		this.registro = registro;
	}

	public ProntuarioVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getPronCod() {
		return pronCod;
	}

	public void setPronCod(int pronCod) {
		this.pronCod = pronCod;
	}

	public String getMedicamento() {
		return medicamento;
	}

	public void setMedicamento(String medicamento) {
		this.medicamento = medicamento;
	}

	public String getExame() {
		return exame;
	}

	public void setExame(String exame) {
		this.exame = exame;
	}

	public String getRegistro() {
		return registro;
	}

	public void setRegistro(String registro) {
		this.registro = registro;
	}
	
	
}
