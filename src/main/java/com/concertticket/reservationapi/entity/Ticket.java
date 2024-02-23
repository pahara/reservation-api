package com.concertticket.reservationapi.entity;

import java.time.OffsetDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tickets")
public class Ticket {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "seat")
	private String seat;
	
	@Column(name = "price")
	private Double price;
	
	@Column(name = "purchased_at", columnDefinition = "timestamp with time zone")
	private OffsetDateTime purchasedAt;

	@ManyToOne()
	@JoinColumn(name = "concert_id", updatable=false, referencedColumnName = "id", foreignKey = @ForeignKey(name = "ticket_concert_fk"))
	private Concert concert;
	
	@ManyToMany(mappedBy = "tickets")
	private List<Transaction> transactions;
	
	public Ticket() {
		
	}

	public Ticket(String seat, Double price, OffsetDateTime purchasedAt, Concert concert) {
		super();
		this.seat = seat;
		this.price = price;
		this.purchasedAt = purchasedAt;
		this.concert = concert;
	}

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

	public OffsetDateTime getPurchasedAt() {
		return purchasedAt;
	}

	public void setPurchasedAt(OffsetDateTime purchasedAt) {
		this.purchasedAt = purchasedAt;
	}

	public Concert getConcert() {
		return concert;
	}

	public void setConcert(Concert concert) {
		this.concert = concert;
	}
	
	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}	
}
