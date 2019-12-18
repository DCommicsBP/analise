package br.com.daione.pavan.capeonato.handebol.api.controller;

import br.com.daione.pavan.capeonato.handebol.api.require.TeamRequire;
import br.com.daione.pavan.capeonato.handebol.business.TeamService;
import br.com.daione.pavan.capeonato.handebol.infraestructure.entities.Team;
import br.com.daione.pavan.capeonato.handebol.infraestructure.utils.UtilError;
import br.com.daione.pavan.capeonato.handebol.response.TeamResponse;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/teams")
public class TeamController {

	private static Logger LOG = Logger.getLogger(Team.class);
	@Autowired
	private TeamService teamService;

	@Autowired
	private UtilError utilError;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Mono<TeamResponse> createTeam(@RequestBody TeamRequire team) {

		return this.teamService.createTeam(team).doOnError(team1 -> {
			this.utilError.internalServerError("Não foi possível salvar o registro. Tente novamente mais tarde. ");
		});
	}

	@GetMapping("/{id}")
	public Mono<TeamResponse> findTeam(@PathVariable String id) {
		return this.teamService.findTeam(id);
	}

	@GetMapping
	public Flux<TeamResponse> findAll() {
		return this.teamService.listAll().doOnError(error -> {
			LOG.error("Não foi possível listar todos os times cadastrados. " + error.getStackTrace());
			this.utilError.internalServerError("Não foi possível listar todos os times cadastrados. ");
		});
	}

	@PatchMapping("/{id}")
	public Mono<TeamResponse> updateTeam(@PathVariable String id, @RequestBody TeamRequire newTeam) {
		return this.teamService.update(newTeam, id).map(team -> {
			return team;
		}).doOnError(error -> {
			this.utilError.internalServerError("Não foi possível atualizar o registro. ");
		});
	}
}
