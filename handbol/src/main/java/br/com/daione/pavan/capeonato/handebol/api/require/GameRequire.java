package br.com.daione.pavan.capeonato.handebol.api.require;

import java.time.Instant;

public class GameRequire {
	private int idVisitant; 
	private int idCommander; 
	private Instant date;
	
	public int getIdVisitant() {
		return idVisitant;
	}
	public void setIdVisitant(int idVisitant) {
		this.idVisitant = idVisitant;
	}
	public int getIdCommander() {
		return idCommander;
	}
	public void setIdCommander(int idCommander) {
		this.idCommander = idCommander;
	}
	public Instant getDate() {
		return date;
	}
	public void setDate(Instant date) {
		this.date = date;
	}
	
	

}
