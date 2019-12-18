package br.com.daione.pavan.capeonato.handebol.api.require;

import br.com.daione.pavan.capeonato.handebol.infraestructure.entities.Player;
import br.com.daione.pavan.capeonato.handebol.infraestructure.entities.Stadium;
import reactor.core.publisher.Flux;

public class TeamRequire {
	

	    private String name;
	    private Flux<Player> players;
	    private Stadium stadium;
	    
		public String getName() {
			return name;
		}
		public TeamRequire setName(String name) {
			this.name = name;
			return this; 
		}
		public Flux<Player> getPlayers() {
			return players;
		}
		public TeamRequire setPlayers(Flux<Player> players) {
			this.players = players;
			return this; 
		}
		public Stadium getStadium() {
			return stadium;
		}
		public TeamRequire setStadium(Stadium stadium) {
			this.stadium = stadium;
			return this; 
		} 
}
