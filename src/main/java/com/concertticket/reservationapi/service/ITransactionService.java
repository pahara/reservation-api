package com.concertticket.reservationapi.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.concertticket.reservationapi.entity.Transaction;

@Service
public interface ITransactionService {
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	void bookTicket(Transaction transaction);
}
