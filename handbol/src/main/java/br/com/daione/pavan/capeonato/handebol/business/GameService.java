package br.com.daione.pavan.capeonato.handebol.business;

import br.com.daione.pavan.capeonato.handebol.api.require.GameRequire;
import br.com.daione.pavan.capeonato.handebol.api.response.GameResponse;
import br.com.daione.pavan.capeonato.handebol.infraestructure.entities.Game;
import br.com.daione.pavan.capeonato.handebol.infraestructure.repository.GameRepository;
import br.com.daione.pavan.capeonato.handebol.infraestructure.utils.UtilError;
import br.com.daione.pavan.capeonato.handebol.infraestructure.utils.UtilGame;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class GameService {

	@Autowired
	private GameRepository gameRepository;

	@Autowired
	private UtilGame util;

	public Mono<GameResponse> createGame(GameRequire game) {
		Game gameEntity = this.util.builderGame(game);
		return this.gameRepository.save(gameEntity).map(game1 -> {
			return UtilGame.gameResponseBuilder(game1);
		});

	}

	public Mono<GameResponse> update(String id, GameRequire game) {
		return this.gameRepository.findById(id).map(game1 -> {
			if (game1.getDate().isBefore(Instant.now())) {
			
				game1.setDate(game.getDate());
				game1.setHouse(game.getCommander());
				game1.setVisitant(game.getVisitant());
				
			}else {
				UtilError.badRequest("Você não pode atualizar o registro após a data da partida."); 
			}

			return game1;
		}).flatMap(game1-> this.gameRepository.save(game1))
		.map(game1->{
			return UtilGame.gameResponseBuilder(game1); 
		});

	}

	public Flux<GameResponse> findAll() {
		return this.gameRepository.findAll().map(game -> {
			return UtilGame.gameResponseBuilder(game);
		});
	}

	public Mono<GameResponse> findGame(String id) {
		return this.gameRepository.findById(id).map(game -> {
			return UtilGame.gameResponseBuilder(game);
		});
	}

	public Mono<GameResponse> delete(String id) {
		return this.gameRepository.findById(id).map(x -> {
			this.gameRepository.delete(x);
			return UtilGame.gameResponseBuilder(x);
		});
	}

}
