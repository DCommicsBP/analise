package br.com.daione.pavan.capeonato.handebol.business;

import br.com.daione.pavan.capeonato.handebol.infraestructure.entities.Game;
import br.com.daione.pavan.capeonato.handebol.infraestructure.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class GameService {
	@Autowired
	private GameRepository gameRepository;

	public Flux<Game> findAll() {
		return this.gameRepository.findAll();
	}

	public Mono<Game> findGame(String id) {
		return this.gameRepository.findById(id);
	}

	public Mono<Game> delete(String id) {
		return this.findGame(id).doOnNext(x -> this.gameRepository.delete(x));
	}

}
