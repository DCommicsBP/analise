package br.com.daione.pavan.capeonato.handebol.infraestructure.utils;

import br.com.daione.pavan.capeonato.handebol.infraestructure.errors.BadRequest;
import br.com.daione.pavan.capeonato.handebol.infraestructure.errors.InternalServerError;
import br.com.daione.pavan.capeonato.handebol.infraestructure.errors.NotFound;
import org.springframework.stereotype.Component;

@Component
public abstract class UtilError {
	public static Object badRequest(String message) {
		throw new BadRequest(message);
	}

	public static void notFound(String message) {
		throw new NotFound(message);
	}

	public static void internalServerError(String message) {
		throw new InternalServerError(message);
	}

}
