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

	public void setId(String id) {
		this.id = id;
		
	}

	public Instant getDate() {
		return date;
	}

	public void setDate(Instant date) {
		this.date = date;
	
	}

	public Team getHouse() {
		return house;
	}

	public void setHouse(Team house) {
		this.house = house;
	
	}

	public Team getVisitant() {
		return visitant;
	}

	public void setVisitant(Team visitant) {
		this.visitant = visitant;
	
	}
}
