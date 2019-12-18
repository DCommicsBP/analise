package br.com.daione.pavan.capeonato.handebol.infraestructure.utils;

import br.com.daione.pavan.capeonato.handebol.api.require.TeamRequire;
import br.com.daione.pavan.capeonato.handebol.api.response.TeamResponse;
import br.com.daione.pavan.capeonato.handebol.infraestructure.entities.Player;
import br.com.daione.pavan.capeonato.handebol.infraestructure.entities.Team;
import reactor.core.publisher.Flux;

import org.jboss.logging.Logger;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.List;

@Component
public abstract class UtilTeam {
	private static Logger LOG = Logger.getLogger(UtilTeam.class);

	public static Team updateUtil(Team oldTeamm, Team newTeam) {

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

	public static List<Player> removePlayer(List<Player> players, Player player) {
		players.remove(player);
		return players;
	}

	public static Team validateNewTeam(TeamRequire newTeam) {

		newTeam.getPlayers().count().subscribe(counter -> {
			LOG.infof("O valor do counter é {}", counter);
			if (counter > 14) {
				UtilError.badRequest("Um time não pode ter mais de 14 integrantes.");
			}

			if (counter < 14) {
				UtilError.badRequest("Um time não pode ter menos que 14 integrantes.");
			}
		});

		if (StringUtils.isEmpty(newTeam.getName())) {
			UtilError.badRequest("Você não pode inserir um time sem nome");
		}

		if (StringUtils.isEmpty(newTeam.getStadium())) {
			UtilError.badRequest("Você não pode inserir um novo time sem um estádio. ");
		}

		Team team = teamBuilder(newTeam);
		return team;
	}

	public static TeamResponse responseBuilder(Team team) {
		return new TeamResponse().setNameTeaam(team.getName()).setPlayers(team.getPlayers())
				.setStadium(team.getStadium());

	}

	public static Team teamBuilder(TeamRequire newTeam) {

		Team team = new Team();

		team.setName(newTeam.getName());
		team.setPlayers(newTeam.getPlayers());
		team.setStadium(newTeam.getStadium());

		return team;
	}
}
