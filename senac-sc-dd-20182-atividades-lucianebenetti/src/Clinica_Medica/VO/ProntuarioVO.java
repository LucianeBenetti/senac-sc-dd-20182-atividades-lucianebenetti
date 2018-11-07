package Clinica_Medica.VO;

import java.util.ArrayList;

public class ProntuarioVO {

	private int codigoProntuario;
	private int codigoConsulta;
	private String medicamento;
	private String exame;
	private String registro;
	private ArrayList<ConsultaVO> consulta;
	
	public ProntuarioVO(int codigoProntuario, int codigoConsulta, String medicamento, String exame, String registro,
			ArrayList<ConsultaVO> consulta) {
		super();
		this.codigoProntuario = codigoProntuario;
		this.codigoConsulta = codigoConsulta;
		this.medicamento = medicamento;
		this.exame = exame;
		this.registro = registro;
		this.consulta = consulta;
	}

	public ProntuarioVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getCodigoProntuario() {
		return codigoProntuario;
	}

	public void setCodigoProntuario(int codigoProntuario) {
		this.codigoProntuario = codigoProntuario;
	}

	public int getCodigoConsulta() {
		return codigoConsulta;
	}

	public void setCodigoConsulta(int codigoConsulta) {
		this.codigoConsulta = codigoConsulta;
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

	public ArrayList<ConsultaVO> getConsulta() {
		return consulta;
	}

	public void setConsulta(ArrayList<ConsultaVO> consulta) {
		this.consulta = consulta;
	}
	
	
	
}
