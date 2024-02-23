package com.concertticket.reservationapi.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.concertticket.reservationapi.entity.ITicket;
import com.concertticket.reservationapi.entity.Ticket;

import jakarta.persistence.LockModeType;

public interface TicketRepository extends PagingAndSortingRepository<Ticket, Long>, JpaRepository<Ticket, Long>{
	@Query(value = "SELECT t from Ticket t where t.concert.id = :concertId and purchasedAt is null")
	Page<ITicket> getTicketByConcertId(Pageable pageable, @Param("concertId") Integer concertId);

    @Lock(LockModeType.PESSIMISTIC_WRITE)
	@Query(value = "SELECT t from Ticket t where id = :ticketId and purchasedAt is null")
	Optional<Ticket> getAvailableTicketById(@Param("ticketId") Long ticketId);
}
