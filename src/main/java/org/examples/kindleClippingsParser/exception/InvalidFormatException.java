package org.examples.kindleClippingsParser.exception;

public class InvalidFormatException extends RuntimeException {
	private static final long serialVersionUID = 8229194061285903104L;

	public InvalidFormatException() {
		super();
	}

	public InvalidFormatException(final String message, final Throwable cause) {
		super(message, cause);
	}

	public InvalidFormatException(final String message) {
		super(message);
	}

	public InvalidFormatException(final Throwable cause) {
		super(cause);
	}

}
