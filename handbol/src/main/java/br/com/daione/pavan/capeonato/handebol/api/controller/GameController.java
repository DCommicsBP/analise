package br.com.daione.pavan.capeonato.handebol.api.controller;

import br.com.daione.pavan.capeonato.handebol.api.require.GameRequire;
import br.com.daione.pavan.capeonato.handebol.api.response.GameResponse;
import br.com.daione.pavan.capeonato.handebol.business.GameService;
import br.com.daione.pavan.capeonato.handebol.infraestructure.utils.UtilError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController("/games")
public class GameController {

	@Autowired
	private GameService gameService;

	@GetMapping
	public Flux<GameResponse> listAll() {
		return this.gameService.findAll()
				.doOnError(x -> UtilError.internalServerError("Não existe registro gravado em banco. "));
	}

	@GetMapping("/{id}")
	public Mono<GameResponse> findGame(@PathVariable String id) {
		return this.gameService.findGame(id)
				.doOnError(x -> UtilError.internalServerError("Não é possível encontrar o registro solicitado. "));
	}

	@PostMapping
	public Mono<GameResponse> createGame(@RequestBody GameRequire game) {
		return this.gameService.createGame(game)
				.doOnError(game1->{
					UtilError.internalServerError("Não foi possível criar um novo jogo, tente novamente mais tarde. ");
				});
	}
	
	@DeleteMapping("{id}")
	public Mono<GameResponse> deleteGame(String id){
		return this.gameService.delete(id)
				.doOnError(error->{
					UtilError.internalServerError("Não foi possível deletar o objeto selecionado."); 
				});
	}

	@PatchMapping("/{id}")
	public Mono<GameResponse> updateGame(@PathVariable String id, GameRequire newGame) {
		return this.gameService.update(id, newGame)
				.doOnError(error->{
					error.printStackTrace();
					UtilError.internalServerError("Não foi possível atualizar o registro. Tente novamente mais tarde.");
				});
	}
}
