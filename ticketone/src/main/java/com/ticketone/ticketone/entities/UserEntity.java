package com.ticketone.ticketone.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "users", schema = "ticketone")
@Getter
@Setter
public class UserEntity {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id_user", nullable = false )
    private UUID idUser;

    @NotNull
    @Column(name = "name")
    @Size(max = 250)
    private String name;

    @NotNull
    @Column(name = "email")
    @Size(max = 250)
    private String email;

    @OneToMany(mappedBy = "user")
    private List<TicketEntity> ticket;
}