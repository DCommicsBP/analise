package br.com.daione.pavan.capeonato.handebol.infraestructure.repository;

import br.com.daione.pavan.capeonato.handebol.infraestructure.entities.Game;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface GameRepository extends ReactiveMongoRepository<Game, String> {

}
