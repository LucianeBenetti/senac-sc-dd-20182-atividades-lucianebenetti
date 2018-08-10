package br.sc.senac.dd.aula04.exercicio;

import java.util.ArrayList;

public class Automovel {
	
	private String fabricante;
	private String modelo;
	private int ano;
	private String chassi;
	private int numRodas;
	
	public Automovel(String fabricante, String modelo, int ano, String chassi, int numRodas) {
		super();
		this.fabricante = fabricante;
		this.modelo = modelo;
		this.ano = ano;
		this.chassi = chassi;
		this.numRodas = numRodas;
	}

	public Automovel() {
		super();
	}


	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getChassi() {
		return chassi;
	}

	public void setChassi(String chassi) {
		this.chassi = chassi;
	}

	public int getNumRodas() {
		return numRodas;
	}

	public void setNumRodas(int numRodas) {
		this.numRodas = numRodas;
	}

	public void ligar() {
		
	}
	
	public void acelerar() {
		
	}
	
	public void desligar() {
		
	}

	@Override
	public String toString() {
		return "Fabricante= " + fabricante + "\nModelo=" + modelo + "\nAno=" + ano + "\nChassi=" + chassi
				+ "\nNumRodas=" + numRodas + "]";
	}
	

}
