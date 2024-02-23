package com.concertticket.reservationapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.concertticket.reservationapi.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long>{
	
}
