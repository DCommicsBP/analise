package br.com.daione.pavan.capeonato.handebol.infraestructure.utils;

import org.jboss.logging.Logger;
import org.springframework.stereotype.Component;

import br.com.daione.pavan.capeonato.handebol.api.require.GameRequire;
import br.com.daione.pavan.capeonato.handebol.api.response.GameResponse;
import br.com.daione.pavan.capeonato.handebol.infraestructure.entities.Game;

@Component
public abstract class UtilGame {

	private static Logger LOG = Logger.getLogger(UtilGame.class);

	public Game builderGame(GameRequire gameRequire) {
		Game game = new Game();

		game.setDate(gameRequire.getDate());
		game.setHouse(gameRequire.getCommander());
		game.setVisitant(gameRequire.getVisitant());
		return game;
	}

	public static void validateResponse(Game game) {
		LOG.info("validação: ");
		if (game.getDate() == null) {
			UtilError.badRequest("Não é possível salvar um jogo sem a data de ocorrência. ");
		}

		if (game.getHouse() == null) {
			UtilError.badRequest("Não é possível salvar a nova partida sem um time mandante. ");
		}

		if (game.getVisitant() == null) {
			UtilError.badRequest("Não é possível salvar uma nova partida sem time visitante. ");
		}
	}

	public static  GameResponse gameResponseBuilder(Game game1) {
		validateResponse(game1);
		return new GameResponse()
				.setDate(game1.getDate()).setHouse(game1.getHouse())
				.setVisitant(game1.getVisitant());
	}
}
