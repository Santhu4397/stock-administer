package com.ty.stockadminister.exception;

public class UnexpectedTypeException extends RuntimeException {
	String message;

	public String getMessage() {
		return message;
	}
	

	public UnexpectedTypeException(String message) {
		super();
		this.message = message;
	}


	public UnexpectedTypeException() {
		super();
	}


	
	

}
