package com.ticketone.ticketone.scheduled;

import com.ticketone.ticketone.entities.TicketEntity;
import com.ticketone.ticketone.repositories.TicketRepository;
import com.ticketone.ticketone.services.TicketServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Slf4j
@Component
public class Watcher {

    @Autowired
    TicketRepository ticketRepository;

    @Autowired
    TicketServiceImpl ticketServiceImpl;

    @Scheduled(cron = "0 0 0 * * *")
    public void checkValidityTicket() {
        List<TicketEntity> allTickets = ticketRepository.findAll();

        for (TicketEntity ticketEntity : allTickets) {
            Optional<TicketEntity> optionalTicket = ticketRepository.findById(ticketEntity.getIdTicket());
            if (optionalTicket.isPresent()) {
                TicketEntity ticket = optionalTicket.get();
                if (ticket.getExpirationDate().isBefore(optionalTicket.get().getCallDate()) || ticket.getExpirationDate().isEqual(optionalTicket.get().getCallDate())) {
                    ticketServiceImpl.deleteTicket(ticket.getIdTicket());
                    log.warn("The Ticket with idTicket " + ticket.getIdTicket() + " expired and it's going to be deleted");
                }
            }
        }
    }
}
