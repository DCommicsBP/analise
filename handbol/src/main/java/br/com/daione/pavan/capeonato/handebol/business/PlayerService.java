package br.com.daione.pavan.capeonato.handebol.business;

import br.com.daione.pavan.capeonato.handebol.api.require.PlayerRequire;
import br.com.daione.pavan.capeonato.handebol.api.response.PlayerResponse;
import br.com.daione.pavan.capeonato.handebol.infraestructure.entities.Player;
import br.com.daione.pavan.capeonato.handebol.infraestructure.repository.PlayerRepository;
import br.com.daione.pavan.capeonato.handebol.infraestructure.utils.UtilPlayer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PlayerService {
	Logger logger = LoggerFactory.getLogger(PlayerService.class);

	@Autowired
	private PlayerRepository playerRepository;

	@Autowired
	private UtilPlayer utilPlayer;

	public Mono<PlayerResponse> create(PlayerRequire playerRequire) {
		Player player = this.utilPlayer.playerBuilder(playerRequire);
		return this.playerRepository.save(player).map(player1 -> {
			return this.utilPlayer.playerResponseBuilder(player1);
		});
	}

	public Flux<PlayerResponse> listAll() {

		return this.playerRepository.findAll().map(player -> {
			return this.utilPlayer.playerResponseBuilder(player);
		});
	}

	public Mono<PlayerResponse> update(String id, Player updatingPlayer) {

		return this.playerRepository.findById(id).map(player -> {
			Player newPlayer = this.utilPlayer.update(player, updatingPlayer);
			return newPlayer;
		}).doOnNext(player -> this.playerRepository.save(player))
				.doOnNext(player -> logger.info("SALVOU AS INFORMACOES ===> " + "\n Name: " + player.getName()
						+ "\n Hight: " + player.getHight() + "\n Genre: " + player.getGenre() + "\n Date: "
						+ player.getDateOfBirth() + "\n Id: " + player.getId()))
				.map(player -> this.utilPlayer.playerResponseBuilder(player));
	}

	public Mono<PlayerResponse> find(String id) {
		return this.playerRepository.findById(id)
				.doOnNext(player -> logger.info("SALVOU AS INFORMACOES ===> " + "\n Name: " + player.getName()
						+ "\n Hight: " + player.getHight() + "\n Genre: " + player.getGenre() + "\n Date: "
						+ player.getDateOfBirth() + "\n Id: " + player.getId()))
				.map(player -> this.utilPlayer.playerResponseBuilder(player));
	}

	public Mono<Player> delete(String id) {
		return this.playerRepository.findById(id).doOnNext(x -> this.playerRepository.delete(x));
	}

}
