package com.epam.authorization.service.exception;

public class WrongDataException extends ServiceException {
	private static final long serialVersionUID = 1L;

	public WrongDataException() {
		super();
	}

	public WrongDataException(String message) {
		super(message);
	}

	public WrongDataException(String message, Exception e) {
		super(message, e);
	}

	public WrongDataException(Exception e) {
		super(e);
	}

}
