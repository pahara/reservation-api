package com.concertticket.reservationapi.entity;

import java.time.OffsetDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "customers", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "customer_name",
                "email"
        })
})
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "customer_name", nullable = false)
	private String customerName;
	
	@Column(name = "email", nullable = false)
	private String email;
	
	@Column(name = "created_at", nullable = false, updatable = false, columnDefinition = "timestamp with time zone default now()")
	private OffsetDateTime createdAt;
	
	@Column(name = "updated_at", columnDefinition = "timestamp with time zone")
	private OffsetDateTime updatedAt;
	
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private List<Transaction> transactions;
	
	public Customer() {
		
	}
	
	public Customer(String customerName, String email, OffsetDateTime createdAt, OffsetDateTime updatedAt, List<Transaction> transactions) {
		super();
		this.customerName = customerName;
		this.email = email;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.transactions = transactions;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public OffsetDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(OffsetDateTime createdAt) {
		this.createdAt = createdAt;
	}
	public OffsetDateTime getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(OffsetDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
