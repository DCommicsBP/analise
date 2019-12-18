package br.com.daione.pavan.capeonato.handebol.business;

import br.com.daione.pavan.capeonato.handebol.api.require.TeamRequire;
import br.com.daione.pavan.capeonato.handebol.infraestructure.entities.Team;
import br.com.daione.pavan.capeonato.handebol.infraestructure.repository.TeamRepository;
import br.com.daione.pavan.capeonato.handebol.infraestructure.utils.UtilTeam;
import br.com.daione.pavan.capeonato.handebol.response.TeamResponse;
import br.com.daione.pavan.capeonato.handebol.infraestructure.utils.UtilError;

import org.hibernate.validator.internal.util.logging.LoggerFactory;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TeamService {
	@Autowired
	private TeamRepository teamRepository;

	@Autowired
	private UtilError utilError;

	@Autowired
	private UtilTeam utilTeam;

	private static final Logger LOG = Logger.getLogger(TeamService.class);

	public Mono<TeamResponse> createTeam(TeamRequire team) {
		return Mono.just(team).map(team1 -> {
			return this.utilTeam.validateNewTeam(team1);

		}).flatMap(team1 -> this.teamRepository.save(team1)).map(team1 -> {
			LOG.info("DADOS SALVOS COM SUCESSO");
			return this.utilTeam.responseBuilder(team1);
		});
	}

	public Flux<TeamResponse> listAll() {
		return this.teamRepository.findAll().map(team -> this.utilTeam.responseBuilder(team)).doOnNext(team -> {
			LOG.info("DADOS ENCONTRDOS COM SUCESSO");
		});

	}

	public Mono<TeamResponse> findTeam(String id) {
		return this.teamRepository.findById(id).map(team -> {
			return this.utilTeam.responseBuilder(team);
		}).doOnError(x -> this.utilError.badRequest("Não foi possível encontrar o time solicitado."));
	}

	public Mono<TeamResponse> update(TeamRequire teamRequire, String id) {
		Team newTeam = this.utilTeam.teamBuilder(teamRequire);

		return this.teamRepository.findById(id).map(oldTeam -> {
			Team newTeamReturn = new Team();
			Mono.just(this.utilTeam.updateUtil(oldTeam, newTeam)).map(returnTeam -> {
				newTeamReturn.setStadium(returnTeam.getStadium());
				newTeamReturn.setName(returnTeam.getName());
				newTeamReturn.setId(returnTeam.getId());
				newTeamReturn.setPlayers(returnTeam.getPlayers());
				return newTeamReturn;
			});
			return newTeamReturn;
		}).flatMap(team1 -> this.teamRepository.save(team1)).map(team1 -> {
			return this.utilTeam.responseBuilder(team1);
		});

	}
}
