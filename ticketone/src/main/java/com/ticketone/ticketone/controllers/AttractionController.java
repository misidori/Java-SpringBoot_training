package com.ticketone.ticketone.controllers;

import com.ticketone.ticketone.dtos.AttractionDTO;
import com.ticketone.ticketone.models.AttractionRequest;
import com.ticketone.ticketone.models.SearchContainer;
import com.ticketone.ticketone.models.Sort;
import com.ticketone.ticketone.repositories.AttractionRepository;
import com.ticketone.ticketone.services.AttractionServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/attraction")
public class AttractionController {
    @Autowired
    private AttractionServiceImpl attractionServiceImpl;
    @Autowired
    private AttractionRepository attractionRepository;

    @PostMapping("/add")
    public AttractionDTO createAttraction(@RequestBody AttractionRequest attractionRequest) {
        log.info("Made a POST request in AttractionController");

        return attractionServiceImpl.createAttraction(attractionRequest);
    }

    @GetMapping("/id/{idAttraction}")
    public AttractionDTO getAttractionById(@PathVariable UUID idAttraction) {
        log.info("Made a GET BY ID request in " + getClass().getName() + " for idAttraction: " + idAttraction);

        return attractionServiceImpl.getAttractionById(idAttraction);
    }

    @GetMapping("/name/{name}")
    public AttractionDTO getAttractionByName(@PathVariable String name) {
        log.info("Made a GET BY NAME request in " + getClass().getName() + " for name: " + name);

        return attractionServiceImpl.getAttractionByName(name);
    }

    @GetMapping("/list")
    public ResponseEntity<SearchContainer<AttractionDTO>> getAllAttractions(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        log.info("Made a GET ALL request for list of elements. Page n. {}, {} elements per page in AttractionController", page, size);
        List<AttractionDTO> attractionPage = attractionServiceImpl.getAllAttractions(page, size);
        long count = attractionServiceImpl.getCountAllAttractions();
        HttpHeaders headers = new HttpHeaders();

        Sort sort = new Sort();
        sort.setField("type");
        sort.setOrder("desc");
        SearchContainer<AttractionDTO> list = new SearchContainer<>(count, page, size, sort, attractionPage);

        return ResponseEntity.ok()
                .headers(headers)
                .body(list);
    }

    @PutMapping("/edit/{idAttraction}")
    public AttractionDTO updateAttraction(@PathVariable UUID idAttraction, @RequestBody AttractionRequest attractionRequest) {
        log.info("Made a PUT request in AttractionController for idAttraction: " + idAttraction);

        return attractionServiceImpl.updateAttraction(idAttraction, attractionRequest);
    }

    @DeleteMapping("/delete/{idAttraction}")
    public void deleteUser(@PathVariable UUID idAttraction) {
        log.info("Made a DELETE request in " + getClass().getName() + " for idAttraction: " + idAttraction);

        attractionServiceImpl.deleteAttraction(idAttraction);
    }

}
