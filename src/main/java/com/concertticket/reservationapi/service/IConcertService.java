package com.concertticket.reservationapi.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.concertticket.reservationapi.entity.Concert;

@Service
public interface IConcertService {
	Page<Concert> getConcert(final Pageable pageable);
}
