package com.concertticket.reservationapi.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.concertticket.reservationapi.entity.Concert;
import com.concertticket.reservationapi.service.IConcertService;


@RestController
public class ConcertController {
	private IConcertService concertService;

	public ConcertController(IConcertService concertService) {
		super();
		this.concertService = concertService;
	}

	@GetMapping("/concerts")
	public Page<Concert> listConcert(
			@RequestParam(defaultValue = "0") final Integer page,
			@RequestParam(defaultValue = "5") final Integer size
	) {
		Page<Concert> concerts = concertService.getConcert(PageRequest.of(page, size));
		return concerts;
	}
}
