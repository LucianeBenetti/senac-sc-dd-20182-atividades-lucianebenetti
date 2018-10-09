package projetoFinalLucianeMarco.Clinica_Medica.VO;

public class EspecializacaoVO {
	
		private int espeCod;
	    private int espCod;
	    private int medCod;
	    private String espeAno;

	    public EspecializacaoVO(int espeCod, int espCod, int medCod, String espeAno) {
			super();
			this.espeCod = espeCod;
			this.espCod = espCod;
			this.medCod = medCod;
			this.espeAno = espeAno;
		}

		public EspecializacaoVO() {
			super();
			// TODO Auto-generated constructor stub
		}

		public int getEspeCod() {
			return espeCod;
		}

		public void setEspeCod(int espeCod) {
			this.espeCod = espeCod;
		}

		public int getEspCod() {
			return espCod;
		}

		public void setEspCod(int espCod) {
			this.espCod = espCod;
		}

		public int getMedCod() {
			return medCod;
		}

		public void setMedCod(int medCod) {
			this.medCod = medCod;
		}

		public String getEspeAno() {
			return espeAno;
		}

		public void setEspeAno(String espeAno) {
			this.espeAno = espeAno;
		}

 
}
