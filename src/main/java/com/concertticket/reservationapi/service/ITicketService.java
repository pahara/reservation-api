package com.concertticket.reservationapi.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.concertticket.reservationapi.entity.ITicket;

@Service
public interface ITicketService {
	Page<ITicket> getTicket(final Pageable pageable, Integer concertId);
}
