package br.com.daione.pavan.capeonato.handebol.api.response;

import java.time.Instant;

import br.com.daione.pavan.capeonato.handebol.infraestructure.entities.Team;

public class GameResponse {

	private Instant date;
	private Team house;
	private Team visitant;

	public Instant getDate() {
		return date;
	}

	public GameResponse setDate(Instant date) {
		this.date = date;
		return this; 
	}

	public Team getHouse() {
		return house;
	}

	public GameResponse setHouse(Team team) {
		this.house = team;
		return this; 
	}

	public Team getVisitant() {
		return visitant;
	}

	public GameResponse setVisitant(Team visitant) {
		this.visitant = visitant;
		return this; 
	}

}
