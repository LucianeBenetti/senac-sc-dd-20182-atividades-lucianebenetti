package projetoFinalLucianeMarco.Clinica_Medica.VO;

public class EspecialidadeVO {

	private int especialidadeCod;
	private String espNome;
	private String espInstituicao;
	
	public EspecialidadeVO(int especialidadeCod, String espNome, String espInstituicao) {
		super();
		this.especialidadeCod = especialidadeCod;
		this.espNome = espNome;
		this.espInstituicao = espInstituicao;
	}
	
	public EspecialidadeVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public int getEspecialidadeCod() {
		return especialidadeCod;
	}

	public void setEspecialidadeCod(int especialidadeCod) {
		this.especialidadeCod = especialidadeCod;
	}

	public String getEspNome() {
		return espNome;
	}

	public void setEspNome(String espNome) {
		this.espNome = espNome;
	}

	public String getEspInstituicao() {
		return espInstituicao;
	}

	public void setEspInstituicao(String espInstituicao) {
		this.espInstituicao = espInstituicao;
	}

	@Override
	public String toString() {
		return "Especialidade_VO [especialidadeCod=" + especialidadeCod + ", espNome=" + espNome + ", espInstituicao="
				+ espInstituicao + "]";
	}

	

}
