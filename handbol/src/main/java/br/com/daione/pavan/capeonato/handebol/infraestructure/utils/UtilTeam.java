package br.com.daione.pavan.capeonato.handebol.infraestructure.utils;

import br.com.daione.pavan.capeonato.handebol.api.require.TeamRequire;
import br.com.daione.pavan.capeonato.handebol.infraestructure.entities.Player;
import br.com.daione.pavan.capeonato.handebol.infraestructure.entities.Team;
import br.com.daione.pavan.capeonato.handebol.response.TeamResponse;
import reactor.core.publisher.Flux;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.List;

@Component
public class UtilTeam {
	private static Logger LOG = Logger.getLogger(UtilTeam.class);

	@Autowired
	private UtilError utilError;

	public Team updateUtil(Team oldTeamm, Team newTeam) {
		oldTeamm.setName(StringUtils.isEmpty(newTeam.getName()) ? oldTeamm.getName() : newTeam.getName());
		oldTeamm.setStadium(newTeam.getStadium() == null ? oldTeamm.getStadium() : newTeam.getStadium());

		newTeam.getPlayers().map(newPlayer -> {
			oldTeamm.getPlayers().map(oldPlayer -> {
				if (!oldPlayer.equals(newPlayer)) {
					Flux.concat(oldTeamm.getPlayers(), Flux.just(newPlayer));
				}

				return oldPlayer;
			});

			return null;
		});

		return oldTeamm;
	}

	public List<Player> removePlayer(List<Player> players, Player player) {
		players.remove(player);
		return players;
	}

	public Team validateNewTeam(TeamRequire newTeam) {

		newTeam.getPlayers().count().subscribe(counter -> {
			LOG.infof("O valor do counter é {}", counter);
			if (counter > 14) {
				this.utilError.badRequest("Um time não pode ter mais de 14 integrantes.");
			}

			if (counter < 14) {
				this.utilError.badRequest("Um time não pode ter menos que 14 integrantes.");
			}
		});

		if (StringUtils.isEmpty(newTeam.getName())) {
			this.utilError.badRequest("Você não pode inserir um time sem nome");
		}

		if (StringUtils.isEmpty(newTeam.getStadium())) {
			this.utilError.badRequest("Você não pode inserir um novo time sem um estádio. ");
		}

		Team team = this.teamBuilder(newTeam);
		return team;
	}

	public TeamResponse responseBuilder(Team team) {
		return new TeamResponse().setNameTeaam(team.getName()).setPlayers(team.getPlayers())
				.setStadium(team.getStadium());

	}

	public Team teamBuilder(TeamRequire newTeam) {

		Team team = new Team();

		team.setName(newTeam.getName());
		team.setPlayers(newTeam.getPlayers());
		team.setStadium(newTeam.getStadium());

		return team;
	}
}
