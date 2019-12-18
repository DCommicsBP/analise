package br.com.daione.pavan.capeonato.handebol.infraestructure.utils;

import br.com.daione.pavan.capeonato.handebol.infraestructure.entities.Player;
import io.netty.util.internal.StringUtil;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public abstract class UtilPlayer {

	public static void validate(Player player) {
		if (player.getDateOfBirth() == null) {
			UtilError.badRequest("Não pode inserir um novo jogador sem uma data. ");
		}

		if (player.getGenre() == null) {
			UtilError.badRequest("Não pode inserir um jogador sem um gênero.");
		}

		if (player.getHight() <= 0.0) {
			UtilError.badRequest("Não pode inserir jogador sem altura");
		}

		if (StringUtil.isNullOrEmpty(player.getName())) {
			UtilError.badRequest("Não pode inserir um jogador sem nome");
		}
	}

	public static Player update(Player player, Player updatingPlayer) {
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
