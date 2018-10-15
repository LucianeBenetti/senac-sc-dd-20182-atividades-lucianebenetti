package Clinica_Medica.VO;

public class PacienteVO {

	 private int pacCod;
	 private String pacNome;
	 private String celMen;
	 private String foneRes;
	 private String foneCom; 
	 private String email;
	 private String cpf;
	 private String cnpj;
	 private String logradouro;
	 private String numLog;
	 private String complemento;
	 private String bairro;
	 private String cidade;
	 private String uf;
	 private String cep;
	
	 public PacienteVO(int pacCod, String pacNome, String celMen, String foneRes, String foneCom, String email,
			String cpf, String cnpj, String logradouro, String numLog, String complemento, String bairro, String cidade,
			String uf, String cep) {
		super();
		this.pacCod = pacCod;
		this.pacNome = pacNome;
		this.celMen = celMen;
		this.foneRes = foneRes;
		this.foneCom = foneCom;
		this.email = email;
		this.cpf = cpf;
		this.cnpj = cnpj;
		this.logradouro = logradouro;
		this.numLog = numLog;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.uf = uf;
		this.cep = cep;
	}

	public PacienteVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getPacCod() {
		return pacCod;
	}

	public void setPacCod(int pacCod) {
		this.pacCod = pacCod;
	}

	public String getPacNome() {
		return pacNome;
	}

	public void setPacNome(String pacNome) {
		this.pacNome = pacNome;
	}

	public String getCelMen() {
		return celMen;
	}

	public void setCelMen(String celMen) {
		this.celMen = celMen;
	}

	public String getFoneRes() {
		return foneRes;
	}

	public void setFoneRes(String foneRes) {
		this.foneRes = foneRes;
	}

	public String getFoneCom() {
		return foneCom;
	}

	public void setFoneCom(String foneCom) {
		this.foneCom = foneCom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumLog() {
		return numLog;
	}

	public void setNumLog(String numLog) {
		this.numLog = numLog;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}
	
	 
	
	 
}
