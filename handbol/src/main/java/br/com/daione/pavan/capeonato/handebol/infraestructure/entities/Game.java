package br.com.daione.pavan.capeonato.handebol.infraestructure.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Document
public class Game {
	@Id
	private String id;
	private Instant date;
	private Team house;
	private Team visitant;

	public String getId() {
		return id;
	}

	public Game setId(String id) {
		this.id = id;
		return this;
	}

	public Instant getDate() {
		return date;
	}

	public Game setDate(Instant date) {
		this.date = date;
		return this;
	}

	public Team getHouse() {
		return house;
	}

	public Game setHouse(Team house) {
		this.house = house;
		return this;
	}

	public Team getVisitant() {
		return visitant;
	}

	public Game setVisitant(Team visitant) {
		this.visitant = visitant;
		return this;
	}
}
