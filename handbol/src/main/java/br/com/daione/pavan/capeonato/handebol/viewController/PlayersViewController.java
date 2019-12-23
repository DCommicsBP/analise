package br.com.daione.pavan.capeonato.handebol.viewController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.reactive.function.client.WebClient;

import br.com.daione.pavan.capeonato.handebol.api.response.PlayerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
@RequestMapping("/players-views")
public class PlayersViewController {
	


	@GetMapping("/list")
	public String listAll(Model model){
			
		Flux<PlayerResponse> players = WebClient.create()
	      .get()
	      .uri("http://localhost:8080/api/players/")
	      .retrieve()
	      .bodyToFlux(PlayerResponse.class);
		 
		model.addAttribute("players", players);
		return "players/playersMain"; 
	}
	
	@GetMapping("/player-detail")
	public String findOne(Model model, String id) {
		
		Mono<PlayerResponse> player = WebClient.create()
				.get()
				.uri("/players/{id}", id)
				.retrieve()
				.bodyToMono(PlayerResponse.class); 
		
		model.addAttribute("player", player);
		return "playerDetail";
	}
	
	
	
	
}
