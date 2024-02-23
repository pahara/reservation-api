package com.concertticket.reservationapi.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.concertticket.reservationapi.dto.TransactionDto;
import com.concertticket.reservationapi.service.ITransactionService;

@RestController
public class TransactionController {
	private ITransactionService transactionService;

	public TransactionController(ITransactionService transactionService) {
		super();
		this.transactionService = transactionService;
	}
	
	@PostMapping("/transactions")
	public String bookTicket (
			@RequestBody TransactionDto transactionDto
	) {
		transactionService.bookTicket(transactionDto.toTransaction());
		return "created";
	}
}
