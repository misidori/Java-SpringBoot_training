package com.ticketone.ticketone.services;

import com.ticketone.ticketone.dtos.AttractionDTO;
import com.ticketone.ticketone.models.AttractionRequest;

import java.util.List;
import java.util.UUID;

public interface AttractionService {
    AttractionDTO createAttraction(AttractionRequest attractionRequest);
    AttractionDTO getAttractionById(UUID idAttraction);
    AttractionDTO getAttractionByName(String name);
    long getCountAllAttractions();
    public List<AttractionDTO> getAllAttractions(int page, int size);
    AttractionDTO updateAttraction(UUID idAttraction, AttractionRequest attractionRequest);
    void deleteAttraction(UUID idAttraction);
}
