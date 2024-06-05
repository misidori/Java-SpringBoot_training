package com.ticketone.ticketone.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
@Table(name = "attractions", schema = "ticketone")
@Getter
@Setter
public class AttractionEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id_attraction", nullable = false )
    private UUID idAttraction;

    @NotNull
    @Column(name = "name")
    @Size(max = 250)
    private String name;

    @Column(name = "description")
    @Size(max = 250)
    private String description;

    @NotNull
    @Column(name = "validity_ticket")
    private int validityTicket;

    @NotNull
    @Column(name = "max_tickets_number")
    private int maxTicketsNumber;

    @NotNull
    @Column(name = "sold_tickets_number")
    private int soldTicketsNumber;

    @NotNull
    @Column(name = "total_sold_tickets_number")
    private int totalSoldTicketsNumber;

    @OneToMany(mappedBy = "attraction")
    private List<TicketEntity> ticket;
}