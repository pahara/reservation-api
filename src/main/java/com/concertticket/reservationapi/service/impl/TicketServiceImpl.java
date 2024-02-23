package com.concertticket.reservationapi.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.concertticket.reservationapi.entity.ITicket;
import com.concertticket.reservationapi.repository.TicketRepository;
import com.concertticket.reservationapi.service.ITicketService;

@Service
public class TicketServiceImpl implements ITicketService{
	private TicketRepository ticketRepository;

	public TicketServiceImpl(TicketRepository ticketRepository) {
		super();
		this.ticketRepository = ticketRepository;
	}

	@Override
	public Page<ITicket> getTicket(Pageable pageable, Integer concertId) {
		return ticketRepository.getTicketByConcertId(pageable, concertId);
	}
}
