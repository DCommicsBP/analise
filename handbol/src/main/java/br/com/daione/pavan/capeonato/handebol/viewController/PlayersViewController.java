package br.com.daione.pavan.capeonato.handebol.viewController;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.daione.pavan.capeonato.handebol.infraestructure.entities.Player;
import reactor.core.publisher.Flux;

@Controller
@RequestMapping("/payers-views")
public class PlayersViewController {

	@GetMapping("/list")
	public String listAll(Model model){
			
		Flux<Player> players = WebClient.create()
	      .get()
	      .uri("http://localhost:8080/api/players/")
	      .retrieve()
	      .bodyToFlux(Player.class);

		model.addAttribute("title","Um Título"); 
		model.addAttribute("players", players);
		
		return "index"; 
	}

}
