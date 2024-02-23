package com.concertticket.reservationapi.entity;

import java.time.OffsetDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "concerts", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "concert_name"
        })
})
public class Concert {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "concert_name", nullable = false)
	private String concertName;
	
	@Column(name = "concert_date", nullable = false, columnDefinition = "timestamp with time zone")
	private OffsetDateTime concertDate;
	
	@Column(name = "location", nullable = false)
	private String location;
	
	@OneToMany(mappedBy = "concert", cascade = CascadeType.ALL)
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@Transient
	private List<Ticket> tickets;
	
	public Concert() {
		
	}

	public Concert(String concertName, OffsetDateTime concertDate, String location, List<Ticket> tickets) {
		super();
		this.concertName = concertName;
		this.concertDate = concertDate;
		this.location = location;
		this.tickets = tickets;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public OffsetDateTime getConcertDate() {
		return concertDate;
	}

	public void setConcertDate(OffsetDateTime concertDate) {
		this.concertDate = concertDate;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public List<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}

	public String getConcertName() {
		return concertName;
	}

	public void setConcertName(String concertName) {
		this.concertName = concertName;
	}
}
