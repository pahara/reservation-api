package com.concertticket.reservationapi.dto;

import com.concertticket.reservationapi.entity.Customer;

public class CustomerDto {
	private Long id;
	private String customerName;
	private String email;
		
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public Customer toCustomer() {
		Customer cst = new Customer();
		cst.setId(id);
		cst.setCustomerName(customerName);
		cst.setEmail(email);
		return cst;
	}
}
