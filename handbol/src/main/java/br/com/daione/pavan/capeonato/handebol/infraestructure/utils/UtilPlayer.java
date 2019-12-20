package br.com.daione.pavan.capeonato.handebol.infraestructure.utils;

import br.com.daione.pavan.capeonato.handebol.infraestructure.entities.Player;
import io.netty.util.internal.StringUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public  class UtilPlayer {
	@Autowired
	private UtilError utilError; 

	public void validate(Player player) {
		if (player.getDateOfBirth() == null) {
			this.utilError.badRequest("Não pode inserir um novo jogador sem uma data. ");
		}

		if (player.getGenre() == null) {
			utilError.badRequest("Não pode inserir um jogador sem um gênero.");
		}

		if (player.getHight() <= 0.0) {
			this.utilError.badRequest("Não pode inserir jogador sem altura");
		}

		if (StringUtil.isNullOrEmpty(player.getName())) {
			this.utilError.badRequest("Não pode inserir um jogador sem nome");
		}
	}

	public Player update(Player player, Player updatingPlayer) {
		player.setCapitain(updatingPlayer.isCapitain());
		player.setDateOfBirth(
				updatingPlayer.getDateOfBirth() == null ? player.getDateOfBirth() : updatingPlayer.getDateOfBirth());
		player.setGenre(StringUtils.isEmpty(updatingPlayer.getGenre().toString()) ? player.getGenre()
				: updatingPlayer.getGenre());
		player.setHight(
				StringUtils.isEmpty(updatingPlayer.getHight() + "") ? player.getHight() : updatingPlayer.getHight());
		player.setName(StringUtils.isEmpty(updatingPlayer.getName()) ? player.getName() : updatingPlayer.getName());
		return player;
	}
}
