package com.ticketone.ticketone.services;

import com.ticketone.ticketone.dtos.TicketDTO;
import com.ticketone.ticketone.models.TicketPutRequest;
import com.ticketone.ticketone.models.TicketPostRequest;

import java.util.List;
import java.util.UUID;

public interface TicketService {
    TicketDTO createTicket(TicketPostRequest ticketPostRequest);
    TicketDTO getTicketById(UUID idTicket);
    long getCountAllTickets();
    public List<TicketDTO> getAllTickets(int page, int size);
    TicketDTO updateTicket(UUID idTicket, TicketPutRequest ticketPutRequest);
    void deleteTicket(UUID idTicket);
}
