package com.ticket.application.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticket.application.model.Ticket;
import com.ticket.application.repository.TicketRepository;
import com.ticket.application.service.TicketService;

@Service
public class TicketServiceImpl implements TicketService {

	@Autowired
	TicketRepository ticketRepository;

	@Override
	public List<Ticket> getAllTickets(String keyword) {
		if (keyword != null) {
			return ticketRepository.search(keyword);
		}
		return (List<Ticket>) ticketRepository.findAll();
	}

	@Override
	public Ticket findTicketById(int id) {
		Optional<Ticket> result = ticketRepository.findById(id);
		if (result.isPresent()) {
			return result.get();
		}
		return new Ticket();
	}

	@Override
	public Ticket getTicketById(int id) {
		// code to fetch the ticket from database
		return new Ticket();
	}

	@Override
	public Ticket addTicket(Ticket ticket) {
		return ticketRepository.save(ticket);
	}

	@Override
	public Ticket updateTicket(Ticket ticket) {
		Optional<Ticket> result = ticketRepository.findById(ticket.getId());
		Ticket existing = result.get();
		existing.setId(ticket.getId());
		existing.setTitle(ticket.getTitle());
		existing.setDescription(ticket.getDescription());
		existing.setContent(ticket.getContent());
		existing.setDateCreated(ticket.getDateCreated());
		return ticketRepository.save(existing);
	}

	@Override
	public void deleteTicketById(int id) {
		this.ticketRepository.deleteById(id);
	}

}
