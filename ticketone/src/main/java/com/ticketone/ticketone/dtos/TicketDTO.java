package com.ticketone.ticketone.dtos;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
public class TicketDTO {
    private UUID idTicket;
    private UserDTO user;
    private AttractionDTO attraction;
    private String number;
    private LocalDate emissionDate;
    private LocalDate expirationDate;
    private LocalDate callDate;
}
