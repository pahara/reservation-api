package com.concertticket.reservationapi.exceptions;


import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
public class RestExceptionHandler {
	@ExceptionHandler(value = InvalidRequestException.class)
	public ResponseEntity<APIError> handleException(InvalidRequestException e) {
		APIError error = new APIError(400, e.getMessage(), new Date());
		return new ResponseEntity<APIError>(error, HttpStatus.BAD_REQUEST);
	}
}
