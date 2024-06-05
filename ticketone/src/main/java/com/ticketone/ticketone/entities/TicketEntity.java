package com.ticketone.ticketone.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "tickets", schema = "ticketone")
@Getter
@Setter
public class TicketEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id_ticket", nullable = false )
    private UUID idTicket;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_user")
    private UserEntity user;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_attraction")
    private AttractionEntity attraction;

    @NotNull
    @Column(name = "number")
    private String number;

    @NotNull
    @Column(name = "emission_date")
    private LocalDateTime emissionDate;

    @NotNull
    @Column(name = "expiration_date")
    private LocalDateTime expirationDate;

    @NotNull
    @Column(name = "call_date")
    private LocalDateTime callDate;
}