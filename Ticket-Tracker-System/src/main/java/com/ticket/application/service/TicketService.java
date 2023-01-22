package com.ticket.application.service;

import java.util.List;

import com.ticket.application.model.Ticket;

public interface TicketService {

	List<Ticket> getAllTickets(String keyword);

	Ticket getTicketById(int id);

	Ticket findTicketById(int id);

	Ticket addTicket(Ticket ticket);

	Ticket updateTicket(Ticket ticket);

	void deleteTicketById(int id);

}