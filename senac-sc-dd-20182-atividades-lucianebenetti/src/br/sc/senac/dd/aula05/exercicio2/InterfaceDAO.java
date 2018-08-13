package br.sc.senac.dd.aula05.exercicio2;

public interface InterfaceDAO  <T>{
	
	public int insert (T objeto);
	public int delete ();
	public int atualizar (T objeto);
	public void consultar ();
		
	

}
