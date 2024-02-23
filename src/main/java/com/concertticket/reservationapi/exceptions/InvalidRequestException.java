package com.concertticket.reservationapi.exceptions;

@SuppressWarnings("serial")
public class InvalidRequestException extends RuntimeException {
	public InvalidRequestException(String msg) {
		super(msg);
	}
}
