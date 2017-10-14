package com.search.engine1.exception;

public class MovieNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 2311959898303649493L;
	
	public MovieNotFoundException() {
        super();
    }

    public MovieNotFoundException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public MovieNotFoundException(final String message) {
        super(message);
    }

    public MovieNotFoundException(final Throwable cause) {
        super(cause);
    }

}
