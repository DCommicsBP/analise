package br.com.daione.pavan.capeonato.handebol.infraestructure.repository;

import br.com.daione.pavan.capeonato.handebol.infraestructure.entities.Team;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface TeamRepository extends ReactiveMongoRepository<Team, String> {

}
