package br.sc.senac.dd.aula05.exercicio2.ModelVO;

public class FuncionarioVO {

	private int idFuncionario;
	private String nome;
	private String cpf;
	private String telefone;
	private String email;
	
	public FuncionarioVO(int idFuncionario, String nome, String cpf, String telefone, String email) {
		super();
		this.idFuncionario = idFuncionario;
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.email = email;
	}
		
	public FuncionarioVO() {
			super();
		}

	public int getIdFuncionario() {
		return idFuncionario;
	}

	public void setIdFuncionario(int idFuncionario) {
		this.idFuncionario = idFuncionario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "\n\nIdFuncionario: " + idFuncionario + ",\n Nome: " + nome + ",\n CPF: " + cpf + ",\n Telefone: "
				+ telefone + ",\n e-mail: " + email;
	}
	
}
