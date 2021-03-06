package br.com.daione.pavan.capeonato.handebol.api.response;



import br.com.daione.pavan.capeonato.handebol.api.enums.Genre;

public class PlayerResponse {
	private String name;
	private String dateOfBirth;
	private Genre genre;
	private double hight;
	private boolean isCapitain;
	private String id; 
	

	public String getId() {
		return id;
	}

	public PlayerResponse setId(String id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public PlayerResponse setName(String name) {
		this.name = name;
		return this;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public PlayerResponse setDateOfBirth(String dateOfBirth) {
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
