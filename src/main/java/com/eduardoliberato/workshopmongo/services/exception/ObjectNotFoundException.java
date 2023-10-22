package com.eduardoliberato.workshopmongo.services.exception;

public class ObjectNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	//remember RuntimeException is a standard exception that the compiler to not require any treatment
	
	public ObjectNotFoundException(String msg) {
		super(msg);
	}
}
