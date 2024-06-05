package com.ticketone.ticketone.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class AttractionDTO {
    private UUID idAttraction;
    private String name;
    private String description;
    private int validityTicket;
    private int soldTicketsNumber;
    private int maxTicketsNumber;
}
