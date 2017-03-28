package com.epam.authorization.service.exception;

public class GettingDataException extends ServiceException {
	private static final long serialVersionUID = 1L;

	public GettingDataException() {
		super();
	}

	public GettingDataException(String message) {
		super(message);
	}

	public GettingDataException(String message, Exception e) {
		super(message, e);
	}

	public GettingDataException(Exception e) {
		super(e);
	}

}
