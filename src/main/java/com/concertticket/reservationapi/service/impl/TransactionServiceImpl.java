package com.concertticket.reservationapi.service.impl;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.concertticket.reservationapi.entity.Ticket;
import com.concertticket.reservationapi.entity.Transaction;
import com.concertticket.reservationapi.exceptions.InvalidRequestException;
import com.concertticket.reservationapi.repository.TicketRepository;
import com.concertticket.reservationapi.repository.TransactionRepository;
import com.concertticket.reservationapi.service.ITransactionService;

@Service
public class TransactionServiceImpl implements ITransactionService {
	@Autowired
	private TransactionRepository transactionRepository;
	@Autowired
	private TicketRepository ticketRepository;
	
	@Override
	public void bookTicket(Transaction transaction) {
		transaction.setTransactionDate(OffsetDateTime.now(ZoneOffset.UTC));
		// Calculate total price
		List<Ticket> tickets = transaction.getTickets();
		for (int i = 0; i < tickets.size(); i++) {
			// Validate ticket availability
			Optional<Ticket> findTicket = ticketRepository.getAvailableTicketById(tickets.get(i).getId());
			if (findTicket.isEmpty()) {
                throw new InvalidRequestException(String.format("Ticket for seat %s already booked. Please choose other tickets", tickets.get(i).getSeat()));
			}
			Double totalPrice = transaction.getTotalPrice() + tickets.get(i).getPrice();
			transaction.setTotalPrice(totalPrice);
			// Set ticket purchased date and time
			tickets.get(i).setPurchasedAt(transaction.getTransactionDate());
		}
		transactionRepository.save(transaction);
		ticketRepository.saveAll(transaction.getTickets());
	}
}
