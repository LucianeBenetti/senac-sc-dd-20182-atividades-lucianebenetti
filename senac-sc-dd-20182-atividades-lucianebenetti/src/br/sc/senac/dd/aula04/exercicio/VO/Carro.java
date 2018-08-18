package br.sc.senac.dd.aula04.exercicio.VO;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Carro extends Automovel{
	
	private String categoria; //passeio, SUV, transporte.

	public Carro(String fabricante, String modelo, int ano, String chassi, int numRodas, String categoria) {
		super(fabricante, modelo, ano, chassi, Automovel.NUMERO_RODAS_CARRO);
		this.categoria = categoria;
	}
	
	public Carro() {
		super();
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "Fabricante= " + this.getFabricante() + "\nModelo= " + this.getModelo() + "\nAno" + this.getAno() + "\nCategoria=" + categoria +  "]";
	}
	
	

}
