package br.com.daione.pavan.capeonato.handebol.viewController;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.reactive.function.client.WebClient;

import br.com.daione.pavan.capeonato.handebol.api.require.PlayerRequire;
import br.com.daione.pavan.capeonato.handebol.api.response.PlayerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
@RequestMapping("/players-views")
public class PlayersViewController {
	private String URL = "http://localhost:8080/api";

	@GetMapping("/list")
	public String listAll(Model model) {

		Flux<PlayerResponse> players = WebClient.create().get().uri(URL + "/players/").retrieve()
				.bodyToFlux(PlayerResponse.class);

		model.addAttribute("players", players);
		return "players/playersMain";
	}

	@GetMapping("/player-detail/{id}")
	public String findOne(Model model, @PathVariable String id) {

		Mono<PlayerResponse> player = WebClient.create().get().uri(URL + "/players/" + id).retrieve()
				.bodyToMono(PlayerResponse.class);
		player.subscribe(player1 -> {
			System.out.println("PLAYER====> " + player1.getName());
		});

		model.addAttribute("player", player);
		return "players/playerDetail";
	}

	@PostMapping("/sendPlayer")
	public String sendPlayer(Model model, @RequestBody PlayerResponse playerResponse) {
		PlayerRequire require = new PlayerRequire().playerResposneToRequire(playerResponse);

		Mono<PlayerResponse> player = this.playerResponse(require);
		player.subscribe();

		model.addAttribute("player", player);
		return "players/playersMain";
	}
	
	private Instant parseDate(String date) {
		return LocalDateTime.parse(                   // Parse as an indeterminate `LocalDate`, devoid of time zone or offset-from-UTC. NOT a moment, NOT a point on the timeline.
			    date ,        // This input uses a poor choice of format. Whenever possible, use standard ISO 8601 formats when exchanging date-time values as text. Conveniently, the java.time classes use the standard formats by default when parsing/generating strings.
			    DateTimeFormatter.ofPattern( "hh:mm a, EEE M/d/uuuu" , Locale.US )  // Use single-character `M` & `d` when the number lacks a leading padded zero for single-digit values.
			)                                      // Returns a `LocalDateTime` object.
			.atZone(                               // Apply a zone to that unzoned `LocalDateTime`, giving it meaning, determining a point on the timeline.
			    ZoneId.of( "America/Toronto" )     // Always specify a proper time zone with `Contintent/Region` format, never a 3-4 letter pseudo-zone such as `PST`, `CST`, or `IST`. 
			)                                      // Returns a `ZonedDateTime`. `toString` → 2018-05-12T16:30-04:00[America/Toronto].
			.toInstant();  
		
	}

	private Mono<PlayerResponse> playerResponse(PlayerRequire playerResponse) {
		if (playerResponse.getId() != null && playerResponse.getId() != "") {
			return WebClient.create().patch().uri(URL + "/players/" + playerResponse.getId(), playerResponse).retrieve()
					.bodyToMono(PlayerResponse.class);
		} else {
			return WebClient.create().post().uri(URL + "/players/", playerResponse).retrieve()
					.bodyToMono(PlayerResponse.class);
		}

	}

}
