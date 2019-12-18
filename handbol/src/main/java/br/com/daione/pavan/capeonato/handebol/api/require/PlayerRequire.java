package br.com.daione.pavan.capeonato.handebol.api.require;

import java.time.Instant;

import br.com.daione.pavan.capeonato.handebol.api.enums.Genre;

public class PlayerRequire {
	
	 	private String name;
	    private Instant dateOfBirth;
	    private Genre genre;
	    private double hight;
	    private boolean isCapitain;
	    
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
		public void setCapitain(boolean isCapitain) {
			this.isCapitain = isCapitain;
		}
	    
	    

}
