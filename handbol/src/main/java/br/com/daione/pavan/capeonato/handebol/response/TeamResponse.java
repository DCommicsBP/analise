package br.com.daione.pavan.capeonato.handebol.response;

import br.com.daione.pavan.capeonato.handebol.infraestructure.entities.Player;
import br.com.daione.pavan.capeonato.handebol.infraestructure.entities.Stadium;
import reactor.core.publisher.Flux;

public class TeamResponse {

	private String nameTeaam;
	private Flux<Player> players;
	private Stadium stadium;

	public String getNameTeaam() {
		return nameTeaam;
	}

	public TeamResponse setNameTeaam(String nameTeaam) {
		this.nameTeaam = nameTeaam;
		return this;
	}

	public Flux<Player> getPlayers() {
		return players;
	}

	public TeamResponse setPlayers(Flux<Player> players) {
		this.players = players;
		return this;
	}

	public Stadium getStadium() {
		return stadium;
	}

	public TeamResponse setStadium(Stadium stadium) {
		this.stadium = stadium;
		return this;
	}
}
