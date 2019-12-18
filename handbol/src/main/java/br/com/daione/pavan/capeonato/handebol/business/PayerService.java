package br.com.daione.pavan.capeonato.handebol.business;

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
public class PayerService {
	Logger logger = LoggerFactory.getLogger(PayerService.class);
	@Autowired
	PlayerRepository playerRepository;

	public Mono<Player> create(Player player) {
		UtilPlayer.validate(player);
		return playerRepository.save(player);
	}

	public Flux<Player> listAll() {
		return this.playerRepository.findAll()
				.doOnNext(player -> logger.info("SALVOU AS INFORMACOES ===> " + "\n Name: " + player.getName()
						+ "\n Hight: " + player.getHight() + "\n Genre: " + player.getGenre() + "\n Date: "
						+ player.getDateOfBirth() + "\n Id: " + player.getId()));
	}

	public Mono<Player> update(String id, Player updatingPlayer) {

		return this.playerRepository.findById(id).map(player -> {
			Player newPlayer = UtilPlayer.update(player, updatingPlayer);
			return newPlayer;
		}).doOnNext(player -> this.playerRepository.save(player))
				.doOnNext(player -> logger.info("SALVOU AS INFORMACOES ===> " + "\n Name: " + player.getName()
						+ "\n Hight: " + player.getHight() + "\n Genre: " + player.getGenre() + "\n Date: "
						+ player.getDateOfBirth() + "\n Id: " + player.getId()));
	}

	public Mono<Player> find(String id) {
		return this.playerRepository.findById(id)
				.doOnNext(player -> logger.info("SALVOU AS INFORMACOES ===> " + "\n Name: " + player.getName()
						+ "\n Hight: " + player.getHight() + "\n Genre: " + player.getGenre() + "\n Date: "
						+ player.getDateOfBirth() + "\n Id: " + player.getId()));
	}

	public Mono<Player> delete(String id) {
		return this.find(id).doOnNext(x -> this.playerRepository.delete(x));
	}

}
