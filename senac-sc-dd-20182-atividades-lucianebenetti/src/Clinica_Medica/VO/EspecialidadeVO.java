package Clinica_Medica.VO;

public class EspecialidadeVO {

	private int espCod;
	private String espNome;
	private String espInstituicao;
	
	public EspecialidadeVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EspecialidadeVO(int espCod, String espNome, String espInstituicao) {
		super();
		this.espCod = espCod;
		this.espNome = espNome;
		this.espInstituicao = espInstituicao;
	}

	public int getEspCod() {
		return espCod;
	}

	public void setEspCod(int espCod) {
		this.espCod = espCod;
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
		return espNome;
	}
	
	
}
