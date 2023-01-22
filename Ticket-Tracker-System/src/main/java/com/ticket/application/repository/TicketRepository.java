package com.ticket.application.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ticket.application.model.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {

	@Query("SELECT t FROM Ticket  t WHERE t.title LIKE %?1%" + " OR t.description LiKE %?1% ")
	public List<Ticket> search(String keyword);

}
