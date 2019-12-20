package br.com.daione.pavan.capeonato.handebol.infraestructure.repository;

import br.com.daione.pavan.capeonato.handebol.infraestructure.entities.Player;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;


public interface PlayerRepository extends ReactiveMongoRepository<Player, String> {
}
