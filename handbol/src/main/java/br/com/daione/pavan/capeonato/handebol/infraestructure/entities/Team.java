package br.com.daione.pavan.capeonato.handebol.infraestructure.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import reactor.core.publisher.Flux;

import java.util.List;

@Document
public class Team {
	@Id
	private String id;
	private String name;
	private Flux<Player> players;
	private Stadium stadium;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Flux<Player> getPlayers() {
		return players;
	}

	public void setPlayers(Flux<Player> players) {
		this.players = players;
	}

	public Stadium getStadium() {
		return stadium;
	}

	public void setStadium(Stadium stadium) {
		this.stadium = stadium;
	}
}
