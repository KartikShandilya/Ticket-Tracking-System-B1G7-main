package com.ticket.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.ticket.application.model.Ticket;
import com.ticket.application.service.TicketService;

@Controller
public class TicketController {

	@Autowired
	TicketService ticketService;

	@GetMapping("/")
	public String home(Model model, @Param("keyword") String keyword) {

		List<Ticket> list = ticketService.getAllTickets(keyword);
		model.addAttribute("Tickets", list);

		model.addAttribute("keyword", keyword);

		return "index";
	}

	@GetMapping("/add")
	public String addTicket(Model model) {
		model.addAttribute("Ticket", new Ticket());

		return "create";
	}

	@PostMapping("/addTicket")
	public String createTicket(Ticket ticket) {
		ticketService.addTicket(ticket);
		return "redirect:/";
	}

	@GetMapping("/edit/{id}")
	public String ticketUpdatePage(Model model, @PathVariable("id") int id) {
		model.addAttribute("ticket", ticketService.findTicketById(id));
		return "edit";

	}

	@PostMapping("/editTicket")
	public String updateTicket(Ticket ticket) {
		ticketService.updateTicket(ticket);
		return "redirect:/";
	}

	@GetMapping("/delete/{id}")
	public String deleteTicket(@PathVariable(value = "id") int id) {
		this.ticketService.deleteTicketById(id);
		return "redirect:/";

	}

	@GetMapping("/view/{id}")
	public String ticketViewPage(Model model, @PathVariable("id") int id) {
		model.addAttribute("ticket", ticketService.findTicketById(id));
		return "view";
	}

}
