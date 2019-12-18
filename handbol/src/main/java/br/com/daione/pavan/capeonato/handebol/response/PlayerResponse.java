package br.com.daione.pavan.capeonato.handebol.response;

import java.time.Instant;

import br.com.daione.pavan.capeonato.handebol.api.enums.Genre;

public class PlayerResponse {
	private String name;
	private Instant dateOfBirth;
	private Genre genre;
	private double hight;
	private boolean isCapitain;

	public String getName() {
		return name;
	}

	public PlayerResponse setName(String name) {
		this.name = name;
		return this;
	}

	public Instant getDateOfBirth() {
		return dateOfBirth;
	}

	public PlayerResponse setDateOfBirth(Instant dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
		return this;
	}

	public Genre getGenre() {
		return genre;
	}

	public PlayerResponse setGenre(Genre genre) {
		this.genre = genre;
		return this;
	}

	public double getHight() {
		return hight;
	}

	public PlayerResponse setHight(double hight) {
		this.hight = hight;
		return this;
	}

	public boolean isCapitain() {
		return isCapitain;
	}

	public PlayerResponse setCapitain(boolean isCapitain) {
		this.isCapitain = isCapitain;
		return this;
	}
}
