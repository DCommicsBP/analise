package br.com.daione.pavan.capeonato.handebol.response;

import org.springframework.http.HttpStatus;

public class ModelResponse {

	private Object object;
	private HttpStatus statusCode;

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

	public HttpStatus getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(HttpStatus statusCode) {
		this.statusCode = statusCode;
	}

}
