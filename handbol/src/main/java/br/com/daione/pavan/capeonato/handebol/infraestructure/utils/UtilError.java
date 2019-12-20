package br.com.daione.pavan.capeonato.handebol.infraestructure.utils;

import br.com.daione.pavan.capeonato.handebol.infraestructure.errors.BadRequest;
import br.com.daione.pavan.capeonato.handebol.infraestructure.errors.InternalServerError;
import br.com.daione.pavan.capeonato.handebol.infraestructure.errors.NotFound;
import org.springframework.stereotype.Component;

@Component
public class UtilError {
	public Object badRequest(String message) {
		throw new BadRequest(message);
	}

	public void notFound(String message) {
		throw new NotFound(message);
	}

	public void internalServerError(String message) {
		throw new InternalServerError(message);
	}

}
