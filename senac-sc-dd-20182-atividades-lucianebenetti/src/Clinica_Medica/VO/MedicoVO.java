package Clinica_Medica.VO;

public class MedicoVO {

		private int codigoMedico;
	    private String nomeMedico;
	    private String crm;
	    private String whatsAppMedico;
	    private String celularMedico;
	    private String emailMedico;
	    private String cpfMedico;
	    private String cnpjMedico;
		
	
		public MedicoVO(int codigoMedico, String nomeMedico, String crm, String whatsAppMedico, String celularMedico,
				String emailMedico, String cpfMedico, String cnpjMedico) {
			super();
			this.codigoMedico = codigoMedico;
			this.nomeMedico = nomeMedico;
			this.crm = crm;
			this.whatsAppMedico = whatsAppMedico;
			this.celularMedico = celularMedico;
			this.emailMedico = emailMedico;
			this.cpfMedico = cpfMedico;
			this.cnpjMedico = cnpjMedico;
		}


		public MedicoVO() {
			super();
			// TODO Auto-generated constructor stub
		}


		public int getCodigoMedico() {
			return codigoMedico;
		}


		public void setCodigoMedico(int codigoMedico) {
			this.codigoMedico = codigoMedico;
		}


		public String getNomeMedico() {
			return nomeMedico;
		}


		public void setNomeMedico(String nomeMedico) {
			this.nomeMedico = nomeMedico;
		}


		public String getCrm() {
			return crm;
		}


		public void setCrm(String crm) {
			this.crm = crm;
		}


		public String getWhatsAppMedico() {
			return whatsAppMedico;
		}


		public void setWhatsAppMedico(String whatsAppMedico) {
			this.whatsAppMedico = whatsAppMedico;
		}


		public String getCelularMedico() {
			return celularMedico;
		}


		public void setCelularMedico(String celularMedico) {
			this.celularMedico = celularMedico;
		}


		public String getEmailMedico() {
			return emailMedico;
		}


		public void setEmailMedico(String emailMedico) {
			this.emailMedico = emailMedico;
		}


		public String getCpfMedico() {
			return cpfMedico;
		}


		public void setCpfMedico(String cpfMedico) {
			this.cpfMedico = cpfMedico;
		}


		public String getCnpjMedico() {
			return cnpjMedico;
		}


		public void setCnpjMedico(String cnpjMedico) {
			this.cnpjMedico = cnpjMedico;
		}


		@Override
		public String toString() {
			return  nomeMedico;
		}
	    
		
	    
	    
}
