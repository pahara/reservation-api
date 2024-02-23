package com.concertticket.reservationapi.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.concertticket.reservationapi.entity.ITicket;
import com.concertticket.reservationapi.service.ITicketService;

@RestController
public class TicketController {
	private ITicketService ticketService;

	public TicketController(ITicketService ticketService) {
		super();
		this.ticketService = ticketService;
	}
	
	@GetMapping("/tickets")
	public Page<ITicket> listTicket (
			@RequestParam final Integer concertId,
			@RequestParam(defaultValue = "0") final Integer page,
			@RequestParam(defaultValue = "5") final Integer size
	) {
		Page<ITicket> tickets = ticketService.getTicket(PageRequest.of(page, size), concertId);
		return tickets;
	}
}
