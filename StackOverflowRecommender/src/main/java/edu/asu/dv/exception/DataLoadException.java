package edu.asu.dv.exception;

public class DataLoadException extends Exception {

	private static final long serialVersionUID = -88812980406495480L;

	public DataLoadException() {
		super();
	}

	public DataLoadException(String message, Throwable cause) {
		super(message, cause);
	}

	public DataLoadException(String message) {
		super(message);
	}

	public DataLoadException(Throwable cause) {
		super(cause);
	}

}
