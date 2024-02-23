package com.concertticket.reservationapi.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.concertticket.reservationapi.entity.Concert;

public interface ConcertRepository extends PagingAndSortingRepository<Concert, Long>{
	@Query(value = "SELECT c from Concert c where c.concertDate >= CURRENT_TIMESTAMP")
	Page<Concert> getAvailableConcert(Pageable pageable);
}
