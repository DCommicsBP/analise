package br.com.daione.pavan.capeonato.handebol.infraestructure.entities.copy;

import br.com.daione.pavan.capeonato.handebol.api.enums.Genre;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Document
public class Player {
	@Id
	private String id;
	private String name;
	private Instant dateOfBirth;
	private Genre genre;
	private double hight;
	private boolean isCapitain;

	public Player() {
	}

	public Player(String name, Instant dateOfBirth, Genre genre, double hight, boolean isCapitain) {
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.genre = genre;
		this.hight = hight;
		this.isCapitain = isCapitain;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Instant getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Instant dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public double getHight() {
		return hight;
	}

	public void setHight(double hight) {
		this.hight = hight;
	}

	public boolean isCapitain() {
		return isCapitain;
	}

	public void setCapitain(boolean capitain) {
		isCapitain = capitain;
	}
}
