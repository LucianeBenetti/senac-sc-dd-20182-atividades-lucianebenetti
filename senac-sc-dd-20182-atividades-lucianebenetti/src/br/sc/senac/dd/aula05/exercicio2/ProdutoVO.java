package br.sc.senac.dd.aula05.exercicio2;

public class ProdutoVO {
	int idProduto;
	String nome;
	String secao;
	float valor;
	
	public ProdutoVO(int idProduto, String nome, String secao, float valor) {
		super();
		this.idProduto = idProduto;
		this.nome = nome;
		this.secao = secao;
		this.valor = valor;
	}

	public ProdutoVO() {
		super();
	}

	public int getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSecao() {
		return secao;
	}

	public void setSecao(String secao) {
		this.secao = secao;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

}
