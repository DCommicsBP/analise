package br.com.daione.pavan.capeonato.handebol.infraestructure.entities.copy;

public class Address {
	private String sreet;
	private int number;
	private String cep;

	public String getSreet() {
		return sreet;
	}

	public void setSreet(String sreet) {
		this.sreet = sreet;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}
}
