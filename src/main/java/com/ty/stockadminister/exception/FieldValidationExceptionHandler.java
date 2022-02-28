package com.ty.stockadminister.exception;

import java.util.LinkedHashMap;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ty.stockadminister.util.Messages;
import com.ty.stockadminister.util.ResponseStructure;

@ControllerAdvice
public class FieldValidationExceptionHandler extends ResponseEntityExceptionHandler implements Messages {

	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<Object> handleNUllPointer(NullPointerException np) {

		ResponseStructure<Map<String, String>> responseStructure = new ResponseStructure<Map<String, String>>();
		responseStructure.setStatus(HttpStatus.BAD_REQUEST.value());
		responseStructure.setMessage(INVALID_USER);

		return new ResponseEntity<Object>(responseStructure, HttpStatus.BAD_REQUEST);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		Map<String, String> info = new LinkedHashMap<String, String>();
		List<ObjectError> errors = ex.getAllErrors();
		for (ObjectError error : errors) {
			String fieldName = ((FieldError) error).getField();
			String message = error.getDefaultMessage();
			info.put(fieldName, message);
		}

		ResponseStructure<Map<String, String>> responseStructure = new ResponseStructure<Map<String, String>>();
		responseStructure.setStatus(HttpStatus.BAD_REQUEST.value());
		responseStructure.setMessage(VALIDATION_ERROR);
		responseStructure.setData(info);

		return new ResponseEntity<Object>(responseStructure, HttpStatus.BAD_REQUEST);
	}
}
