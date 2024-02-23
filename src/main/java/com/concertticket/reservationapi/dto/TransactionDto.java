package com.concertticket.reservationapi.dto;

import java.util.LinkedList;
import java.util.List;

import com.concertticket.reservationapi.entity.Ticket;
import com.concertticket.reservationapi.entity.Transaction;

public class TransactionDto {
	private CustomerDto customer;
	
	public CustomerDto getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerDto customer) {
		this.customer = customer;
	}

	private List<TicketDto> tickets;

	public List<TicketDto> getTickets() {
		return tickets;
	}

	public void setTickets(List<TicketDto> tickets) {
		this.tickets = tickets;
	}

	
	public Transaction toTransaction() {
		Transaction trx = new Transaction();
		trx.setCustomer(customer.toCustomer());
		
		List<Ticket> ticketList = new LinkedList<Ticket>();
		tickets.forEach(t -> {
			ticketList.add(t.toTicket());
		});
		trx.setTickets(ticketList);
		return trx;
	}
}
