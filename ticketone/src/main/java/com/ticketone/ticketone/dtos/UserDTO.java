package com.ticketone.ticketone.dtos;


import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class UserDTO {
    private UUID idUser;
    private String name;
    private String email;
}
