package Clinica_Medica.VO;

public class EspecialidadeVO {

	private int codigoEspecialidade;
	private String nomeEspecialidade;
	private String Instituicao;
	
	
	public EspecialidadeVO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public EspecialidadeVO(int codigoEspecialidade, String nomeEspecialidade, String instituicao) {
		super();
		this.codigoEspecialidade = codigoEspecialidade;
		this.nomeEspecialidade = nomeEspecialidade;
		Instituicao = instituicao;
	}


	public int getCodigoEspecialidade() {
		return codigoEspecialidade;
	}


	public void setCodigoEspecialidade(int codigoEspecialidade) {
		this.codigoEspecialidade = codigoEspecialidade;
	}


	public String getNomeEspecialidade() {
		return nomeEspecialidade;
	}


	public void setNomeEspecialidade(String nomeEspecialidade) {
		this.nomeEspecialidade = nomeEspecialidade;
	}


	public String getInstituicao() {
		return Instituicao;
	}


	public void setInstituicao(String instituicao) {
		Instituicao = instituicao;
	}


	@Override
	public String toString() {
		return nomeEspecialidade;
	}
	
	
}
