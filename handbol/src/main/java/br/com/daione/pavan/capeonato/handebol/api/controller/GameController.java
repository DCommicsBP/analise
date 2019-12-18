package br.com.daione.pavan.capeonato.handebol.api.controller;

import br.com.daione.pavan.capeonato.handebol.business.GameService;
import br.com.daione.pavan.capeonato.handebol.infraestructure.entities.Game;
import br.com.daione.pavan.capeonato.handebol.infraestructure.utils.UtilError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController("/games")
public class GameController {
	@Autowired
	private GameService gameService;

	@Autowired
	private UtilError utilError;

	@GetMapping
	public Flux<Game> listAll() {
		return this.gameService.findAll()
				.doOnError(x -> this.utilError.badRequest("Não existe registro gravado em banco. "));
	}

	@GetMapping("/{id}")
	public Mono<Game> findGame(@PathVariable String id) {
		return this.gameService.findGame(id)
				.doOnError(x -> this.utilError.badRequest("Não é possível encontrar o registro solicitado. "));
	}

	@PostMapping
	public Mono<Game> createGame(@RequestBody Game game) {
		return this.gameService.findGame("");
	}

	@PatchMapping("{id}")
	public Mono<Game> updateGame(@PathVariable String id, Game newGame) {
		return null;
	}
}
