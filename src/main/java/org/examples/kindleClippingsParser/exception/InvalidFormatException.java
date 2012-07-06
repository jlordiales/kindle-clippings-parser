package org.examples.kindleClippingsParser.exception;

public class InvalidFormatException extends RuntimeException {
	private static final long serialVersionUID = 8229194061285903104L;

	public InvalidFormatException() {
		super();
	}

	public InvalidFormatException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidFormatException(String message) {
		super(message);
	}

	public InvalidFormatException(Throwable cause) {
		super(cause);
	}

}
