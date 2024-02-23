package com.concertticket.reservationapi.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.concertticket.reservationapi.entity.Concert;
import com.concertticket.reservationapi.repository.ConcertRepository;
import com.concertticket.reservationapi.service.IConcertService;

@Service
public class ConcertServiceImpl implements IConcertService {
	private ConcertRepository concertRepository;

	public ConcertServiceImpl(ConcertRepository concertRepository) {
		super();
		this.concertRepository = concertRepository;
	}

	@Override
	public Page<Concert> getConcert(Pageable pageable) {
		return concertRepository.getAvailableConcert(pageable);
	}
	
}
