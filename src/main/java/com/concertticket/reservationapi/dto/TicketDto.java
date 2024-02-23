package com.concertticket.reservationapi.dto;

import com.concertticket.reservationapi.entity.Ticket;

public class TicketDto {
	private Long id;
	private String seat;
	private Double price;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSeat() {
		return seat;
	}

	public void setSeat(String seat) {
		this.seat = seat;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Ticket toTicket() {
		Ticket tic = new Ticket();
		tic.setId(id);
		tic.setSeat(seat);
		tic.setPrice(price);
		return tic;
	}
}
