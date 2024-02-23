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
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "transactions")
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "transaction_date", nullable = false)
	private OffsetDateTime transactionDate;
	
	@Column(name = "total_price", nullable = false)
	private Double totalPrice;
	
	@ManyToOne
	@JoinColumn(name = "customer_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "transaction_customer_fk"))
	private Customer customer;
	
	@ManyToMany
	@JoinTable(
			name = "transaction_tickets",
			joinColumns = {
					@JoinColumn(name = "transaction_id")
			},
			inverseJoinColumns = {
					@JoinColumn(name = "ticket_id")
			}
		)
	private List<Ticket> tickets;
	
	public Transaction() {
		
	}

	public Transaction(OffsetDateTime transactionDate, Double totalPrice, Customer customer, List<Ticket> tickets) {
		super(); 
		this.transactionDate = transactionDate;
		this.totalPrice = totalPrice;
		this.customer = customer;
		this.tickets = tickets;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public OffsetDateTime getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(OffsetDateTime transactionDate) {
		this.transactionDate = transactionDate;
	}

	public Double getTotalPrice() {
		if (totalPrice == null) {
			totalPrice = (double) 0;
		}
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}
}
