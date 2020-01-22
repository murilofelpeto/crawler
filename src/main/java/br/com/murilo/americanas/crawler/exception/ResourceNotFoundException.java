package br.com.murilo.americanas.crawler.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -530258933617955287L;

	public ResourceNotFoundException(String message) {
		super(message);
	}
}
