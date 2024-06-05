package com.ticketone.ticketone.controllers;

import com.ticketone.ticketone.dtos.UserDTO;
import com.ticketone.ticketone.models.SearchContainer;
import com.ticketone.ticketone.models.Sort;
import com.ticketone.ticketone.models.UserRequest;
import com.ticketone.ticketone.repositories.UserRepository;
import com.ticketone.ticketone.services.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserServiceImpl userServiceImpl;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/add")
    public Optional<UserDTO> createUser(@RequestBody UserRequest userRequest) {
        log.info("Made a POST request in " + getClass().getName());

        return userServiceImpl.createUser(userRequest);
    }

    @GetMapping("/id/{idUser}")
    public UserDTO getUserById(@PathVariable UUID idUser) {
        log.info("Made a GET BY ID request in " + getClass().getName() + " for idUser: " + idUser);

        return userServiceImpl.getUserById(idUser);
    }

    @GetMapping("/name/{name}")
    public UserDTO getUserByName(@PathVariable String name) {
        log.info("Made a GET BY NAME request in " + getClass().getName() + " for name: " + name);

        return userServiceImpl.getUserByName(name);
    }

    @GetMapping("/list")
    public ResponseEntity<SearchContainer<UserDTO>> getAllGroups(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        log.info("Made a GET ALL request for list of elements. Page n. {}, {} elements per page in UserController", page, size);
        List<UserDTO> userPage = userServiceImpl.getAllUsers(page, size);
        long count = userServiceImpl.getCountAllUsers();
        HttpHeaders headers = new HttpHeaders();

        Sort sort = new Sort();
        sort.setField("type");
        sort.setOrder("desc");
        SearchContainer<UserDTO> list = new SearchContainer<>(count, page, size, sort, userPage);

        return ResponseEntity.ok()
                .headers(headers)
                .body(list);
    }

    @PutMapping("/edit/{idUser}")
    public UserDTO updateUser(@PathVariable UUID idUser, @RequestBody UserRequest userRequest) {
        log.info("Made a PUT request in UserController for idUser: " + idUser);

        return userServiceImpl.updateUser(idUser, userRequest);
    }

    @DeleteMapping("/delete/{idUser}")
    public void deleteUser(@PathVariable UUID idUser) {
        log.info("Made a DELETE request in " + getClass().getName() + " for idUser: " + idUser);

        userServiceImpl.deleteUser(idUser);
    }
}
