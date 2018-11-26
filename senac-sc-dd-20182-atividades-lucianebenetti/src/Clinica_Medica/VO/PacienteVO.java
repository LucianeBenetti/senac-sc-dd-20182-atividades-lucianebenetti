package Clinica_Medica.VO;

public class PacienteVO {

	 private int codigoPaciente;
	 private String nomePaciente;
	 private String whatsAppPaciente;
	 private String foneResidencial;
	 private String foneComercial; 
	 private String emailPaciente;
	 private String cpfPaciente;
	 private String cnpjPaciente;
	 private String logradouro;
	 private String numeroLogradouro;
	 private String complemento;
	 private String bairro;
	 private String cidade;
	 private String uf;
	 private String cep;
	
	 public PacienteVO(int codigoPaciente, String nomePaciente, String whatsAppPaciente, String foneResidencial,
			String foneComercial, String emailPaciente, String cpfPaciente, String cnpjPaciente, String logradouro,
			String numeroLogradouro, String complemento, String bairro, String cidade, String uf, String cep) {
		super();
		this.codigoPaciente = codigoPaciente;
		this.nomePaciente = nomePaciente;
		this.whatsAppPaciente = whatsAppPaciente;
		this.foneResidencial = foneResidencial;
		this.foneComercial = foneComercial;
		this.emailPaciente = emailPaciente;
		this.cpfPaciente = cpfPaciente;
		this.cnpjPaciente = cnpjPaciente;
		this.logradouro = logradouro;
		this.numeroLogradouro = numeroLogradouro;
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

	public int getCodigoPaciente() {
		return codigoPaciente;
	}

	public void setCodigoPaciente(int codigoPaciente) {
		this.codigoPaciente = codigoPaciente;
	}

	public String getNomePaciente() {
		return nomePaciente;
	}

	public void setNomePaciente(String nomePaciente) {
		this.nomePaciente = nomePaciente;
	}

	public String getWhatsAppPaciente() {
		return whatsAppPaciente;
	}

	public void setWhatsAppPaciente(String whatsAppPaciente) {
		this.whatsAppPaciente = whatsAppPaciente;
	}

	public String getFoneResidencial() {
		return foneResidencial;
	}

	public void setFoneResidencial(String foneResidencial) {
		this.foneResidencial = foneResidencial;
	}

	public String getFoneComercial() {
		return foneComercial;
	}

	public void setFoneComercial(String foneComercial) {
		this.foneComercial = foneComercial;
	}

	public String getEmailPaciente() {
		return emailPaciente;
	}

	public void setEmailPaciente(String emailPaciente) {
		this.emailPaciente = emailPaciente;
	}

	public String getCpfPaciente() {
		return cpfPaciente;
	}

	public void setCpfPaciente(String cpfPaciente) {
		this.cpfPaciente = cpfPaciente;
	}

	public String getCnpjPaciente() {
		return cnpjPaciente;
	}

	public void setCnpjPaciente(String cnpjPaciente) {
		this.cnpjPaciente = cnpjPaciente;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumeroLogradouro() {
		return numeroLogradouro;
	}

	public void setNumeroLogradouro(String numeroLogradouro) {
		this.numeroLogradouro = numeroLogradouro;
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
