package br.com.daione.pavan.capeonato.handebol.infraestructure.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFound extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public NotFound(String error) {
		super(error);
	}
}
