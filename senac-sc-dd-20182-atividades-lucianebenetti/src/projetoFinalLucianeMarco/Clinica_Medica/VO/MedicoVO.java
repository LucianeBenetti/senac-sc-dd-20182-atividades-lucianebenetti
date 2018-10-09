package projetoFinalLucianeMarco.Clinica_Medica.VO;

public class MedicoVO {

		private int medCod;
	    private String medNome;
	    private String crm;
	    private String celMen;
	    private String cel;
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
		
	    public MedicoVO(int medCod, String medNome, String crm, String celMen, String cel, String email, String cpf,
				String cnpj, String logradouro, String numLog, String complemento, String bairro, String cidade,
				String uf, String cep) {
			super();
			this.medCod = medCod;
			this.medNome = medNome;
			this.crm = crm;
			this.celMen = celMen;
			this.cel = cel;
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

		public MedicoVO() {
			super();
			// TODO Auto-generated constructor stub
		}

		public int getMedCod() {
			return medCod;
		}

		public void setMedCod(int medCod) {
			this.medCod = medCod;
		}

		public String getMedNome() {
			return medNome;
		}

		public void setMedNome(String medNome) {
			this.medNome = medNome;
		}

		public String getCrm() {
			return crm;
		}

		public void setCrm(String crm) {
			this.crm = crm;
		}

		public String getCelMen() {
			return celMen;
		}

		public void setCelMen(String celMen) {
			this.celMen = celMen;
		}

		public String getCel() {
			return cel;
		}

		public void setCel(String cel) {
			this.cel = cel;
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

		@Override
		public String toString() {
			return "Medico_VO [medCod=" + medCod + ", medNome=" + medNome + ", crm=" + crm + ", celMen=" + celMen
					+ ", cel=" + cel + ", email=" + email + ", cpf=" + cpf + ", cnpj=" + cnpj + ", logradouro="
					+ logradouro + ", numLog=" + numLog + ", complemento=" + complemento + ", bairro=" + bairro
					+ ", cidade=" + cidade + ", uf=" + uf + ", cep=" + cep + "]";
		}
	    
	    
	    
}
