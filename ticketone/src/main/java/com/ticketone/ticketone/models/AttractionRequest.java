package com.ticketone.ticketone.models;

import lombok.Getter;

@Getter
public class AttractionRequest {
    private String name;
    private String description;
    private Integer validityTicket;
    private Integer maxTicketsNumber;
}
