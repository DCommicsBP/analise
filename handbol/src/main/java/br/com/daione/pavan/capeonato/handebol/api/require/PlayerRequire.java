package br.com.daione.pavan.capeonato.handebol.api.require;

import java.time.Instant;

import br.com.daione.pavan.capeonato.handebol.api.enums.Genre;
import br.com.daione.pavan.capeonato.handebol.api.response.PlayerResponse;

public class PlayerRequire {
	
	 	private String name;
	    private Instant dateOfBirth;
	    private Genre genre;
	    private double hight;
	    private boolean isCapitain;
	    private String id; 
	    
	    
	    
		public String getName() {
			return name;
		}
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
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
	    
		public PlayerRequire playerResposneToRequire(PlayerResponse response) {
			
			this.setCapitain(response.isCapitain());
			this.setDateOfBirth(Instant.parse(response.getDateOfBirth()));
			this.setGenre(response.getGenre());
			this.setHight(response.getHight());
			this.setId(response.getId());
			
			return this; 
		}
	    

}
