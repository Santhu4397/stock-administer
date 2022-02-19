package com.ty.stockadminister.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ty.stockadminister.util.ResponseStructure;

@ControllerAdvice
public class StockExceptionHandler extends StockException {

	@ExceptionHandler(StockException.class)
	public ResponseEntity<ResponseStructure<String>> handleUserNotFoundException(StockException stockException) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setMessage(stockException.getMessage());
		structure.setData("Custom Exception");
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}
}
