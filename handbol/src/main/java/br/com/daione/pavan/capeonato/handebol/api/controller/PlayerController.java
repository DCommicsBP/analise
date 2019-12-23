package br.com.daione.pavan.capeonato.handebol.api.controller;

import br.com.daione.pavan.capeonato.handebol.api.require.PlayerRequire;
import br.com.daione.pavan.capeonato.handebol.api.response.PlayerResponse;
import br.com.daione.pavan.capeonato.handebol.business.PlayerService;
import br.com.daione.pavan.capeonato.handebol.infraestructure.entities.Player;
import br.com.daione.pavan.capeonato.handebol.infraestructure.utils.UtilError;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/players")
public class PlayerController {
	private static Logger LOG = Logger.getLogger(PlayerController.class);

	@Autowired
	private PlayerService playerService;

	@Autowired
	private UtilError utilError;

	@PostMapping("/")
	public Mono<PlayerResponse> create(@RequestBody PlayerRequire player) {
		return this.playerService.create(player).doOnError(error -> {
			LOG.error("Não foi possível salvar o novo jogador.");
			this.utilError.internalServerError("Não foi possível salvar o jogador corretamente. ");
		});
	}

	@GetMapping("/")
	public Flux<PlayerResponse> players() {
		return this.playerService.listAll().doOnError(error -> {
			this.utilError.internalServerError("Não foi possível listar os registros. ");
		});

	}

	@GetMapping("/{id}")
	public Mono<PlayerResponse> findPlayer(@PathVariable String id) {
		return this.playerService.find(id)
				.doOnError(x -> this.utilError.internalServerError("Não é possível encontrar o registro. "));
	}

	@PatchMapping("/{id}")
	public Mono<PlayerResponse> update(@PathVariable String id, @RequestBody Player newPlayer) {
		return this.playerService.update(id, newPlayer)
				.doOnError(x -> this.utilError.internalServerError("Não foi possível fazer o update do registro. "));
	}

	@DeleteMapping("/{id}")
	public Mono<Player> delete(@PathVariable String id) {
		return this.playerService.delete(id).doOnError(
				x -> this.utilError.internalServerError("Não foi possível encontrar o dados para excluí-lo"));
	}

}
