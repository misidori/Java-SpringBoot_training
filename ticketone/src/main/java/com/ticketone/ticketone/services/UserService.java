package com.ticketone.ticketone.services;

import com.ticketone.ticketone.dtos.UserDTO;
import com.ticketone.ticketone.models.UserRequest;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserService {
    Optional<UserDTO> createUser(UserRequest userRequest);
    UserDTO getUserById(UUID idUser);
    UserDTO getUserByName(String name);
    long getCountAllUsers();
    public List<UserDTO> getAllUsers(int page, int size);
    UserDTO updateUser(UUID idUser, UserRequest userRequest);
    void deleteUser(UUID idUser);
}
