package com.ticketone.ticketone.models;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
public class TicketPostRequest {
    private UUID idUser;
    private UUID idAttraction;
    private LocalDateTime callDate;
}
