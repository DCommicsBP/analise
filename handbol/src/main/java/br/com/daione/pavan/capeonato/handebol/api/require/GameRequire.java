package br.com.daione.pavan.capeonato.handebol.api.require;

import java.time.Instant;

import br.com.daione.pavan.capeonato.handebol.infraestructure.entities.Team;

public class GameRequire {
	private Team visitant;
	private Team commander;
	private Instant date;

	public Team getVisitant() {
		return visitant;
	}

	public void setVisitant(Team visitant) {
		this.visitant = visitant;
	}

	public Team getCommander() {
		return commander;
	}

	public void setCommander(Team commander) {
		this.commander = commander;
	}

	public Instant getDate() {
		return date;
	}

	public void setDate(Instant date) {
		this.date = date;
	}

}
