package Clinica_Medica.VO;

import java.sql.Time;
import java.util.Date;

public class ConsultaVO {
		
	private int codigoConsulta;
	private EspecializacaoVO especializacaoVO;
	private PacienteVO pacienteVO;
	private ConvenioVO convenioVO;
	private ProntuarioVO prontuarioVO;
	private Date dataConsulta;
	private Time horarioConsulta;

	public ConsultaVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ConsultaVO(int codigoConsulta, EspecializacaoVO especializacaoVO, PacienteVO pacienteVO,
			ConvenioVO convenioVO, ProntuarioVO prontuarioVO, Date dataConsulta, Time horarioConsulta) {
		super();
		this.codigoConsulta = codigoConsulta;
		this.especializacaoVO = especializacaoVO;
		this.pacienteVO = pacienteVO;
		this.convenioVO = convenioVO;
		this.prontuarioVO = prontuarioVO;
		this.dataConsulta = dataConsulta;
		this.horarioConsulta = horarioConsulta;
	}
	public int getCodigoConsulta() {
		return codigoConsulta;
	}
	public void setCodigoConsulta(int codigoConsulta) {
		this.codigoConsulta = codigoConsulta;
	}
	public EspecializacaoVO getEspecializacaoVO() {
		return especializacaoVO;
	}
	public void setEspecializacaoVO(EspecializacaoVO especializacaoVO) {
		this.especializacaoVO = especializacaoVO;
	}
	public PacienteVO getPacienteVO() {
		return pacienteVO;
	}
	public void setPacienteVO(PacienteVO pacienteVO) {
		this.pacienteVO = pacienteVO;
	}
	public ConvenioVO getConvenioVO() {
		return convenioVO;
	}
	public void setConvenioVO(ConvenioVO convenioVO) {
		this.convenioVO = convenioVO;
	}
	public ProntuarioVO getProntuarioVO() {
		return prontuarioVO;
	}
	public void setProntuarioVO(ProntuarioVO prontuarioVO) {
		this.prontuarioVO = prontuarioVO;
	}
	public Date getDataConsulta() {
		return dataConsulta;
	}
	public void setDataConsulta(Date dataConsulta) {
		this.dataConsulta = dataConsulta;
	}
	public Time getHorarioConsulta() {
		return horarioConsulta;
	}
	public void setHorarioConsulta(Time horarioConsulta) {
		this.horarioConsulta = horarioConsulta;
	}
	
	
	
}
