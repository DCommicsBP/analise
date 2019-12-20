package br.com.daione.pavan.capeonato.handebol.infraestructure.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class BadRequest extends RuntimeException {
		public BadRequest(String error) {
		super(error);
	}

}
