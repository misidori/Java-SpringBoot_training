package com.ticketone.ticketone.controllers;

import com.ticketone.ticketone.dtos.TicketDTO;
import com.ticketone.ticketone.models.SearchContainer;
import com.ticketone.ticketone.models.Sort;
import com.ticketone.ticketone.models.TicketPutRequest;
import com.ticketone.ticketone.models.TicketPostRequest;
import com.ticketone.ticketone.repositories.TicketRepository;
import com.ticketone.ticketone.services.TicketServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/ticket")
public class TicketController {
    @Autowired
    private TicketServiceImpl ticketServiceImpl;

    @Autowired
    private TicketRepository ticketRepository;

    @PostMapping("/add")
    public TicketDTO createTicket(@RequestBody TicketPostRequest ticketPostRequest) {

        log.info("Made a POST request in TicketController");

        return ticketServiceImpl.createTicket(ticketPostRequest);
    }

    @PutMapping("/edit/{idTicket}")
    public TicketDTO updateTicket(@PathVariable UUID idTicket, @RequestBody TicketPutRequest ticketPutRequest) {
        log.info("Made a PUT request in TicketController");

        return ticketServiceImpl.updateTicket(idTicket, ticketPutRequest);
    }

    @GetMapping("/id/{idTicket}")
    public TicketDTO getTicketById(@PathVariable UUID idTicket) {
        log.info("Made a GET BY ID request in " + getClass().getName() + " for idTicket: " + idTicket);

        return ticketServiceImpl.getTicketById(idTicket);
    }

    @GetMapping("/list")
    public ResponseEntity<SearchContainer<TicketDTO>> getAllGroups(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        log.info("Made a GET ALL request for list of elements. Page n. {}, {} elements per page in TicketController", page, size);
        List<TicketDTO> ticketPage = ticketServiceImpl.getAllTickets(page, size);
        long count = ticketServiceImpl.getCountAllTickets();
        HttpHeaders headers = new HttpHeaders();

        Sort sort = new Sort();
        sort.setField("type");
        sort.setOrder("desc");
        SearchContainer<TicketDTO> list = new SearchContainer<>(count, page, size, sort, ticketPage);

        return ResponseEntity.ok()
                .headers(headers)
                .body(list);
    }

    @DeleteMapping("/delete/{idTicket}")
    public void deleteTicket(@PathVariable UUID idTicket) {
        log.info("Made a DELETE request in " + getClass().getName() + " for idTicket: " + idTicket);

        ticketServiceImpl.deleteTicket(idTicket);
    }
}
