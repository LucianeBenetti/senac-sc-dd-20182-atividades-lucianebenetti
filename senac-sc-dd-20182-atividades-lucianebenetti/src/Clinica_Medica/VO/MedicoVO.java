package Clinica_Medica.VO;

public class MedicoVO {

		private int medCod;
	    private String medNome;
	    private String crm;
	    private String celMen;
	    private String cel;
	    private String email;
	    private String cpf;
	    private String cnpj;
		
	    public MedicoVO(int medCod, String medNome, String crm, String celMen, String cel, String email, String cpf,
				String cnpj) {
			super();
			this.medCod = medCod;
			this.medNome = medNome;
			this.crm = crm;
			this.celMen = celMen;
			this.cel = cel;
			this.email = email;
			this.cpf = cpf;
			this.cnpj = cnpj;
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

		@Override
		public String toString() {
			return  medNome;
		}
	    
		
	    
	    
}
