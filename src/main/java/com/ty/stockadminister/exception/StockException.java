package com.ty.stockadminister.exception;

public class StockException extends RuntimeException {

	String message;

	public String getMessage() {
		return message;
	}

	public StockException(String message) {
		super();
		this.message = message;
	}

	public StockException() {
		super();
	}

}
