package com.ticketone.ticketone.services;

import com.ticketone.ticketone.dtos.AttractionDTO;
import com.ticketone.ticketone.entities.AttractionEntity;
import com.ticketone.ticketone.mappers.AttractionMapper;
import com.ticketone.ticketone.models.AttractionRequest;
import com.ticketone.ticketone.repositories.AttractionRepository;
import com.ticketone.ticketone.utils.UtilsTicketone;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Slf4j
@Service
public class AttractionServiceImpl implements AttractionService {
    @Autowired
    AttractionRepository attractionRepository;

    @Override
    public AttractionDTO createAttraction(AttractionRequest attractionRequest) {
        if (attractionRequest.getName() == null) {
            log.error("Cannot create new Attraction with null name");
            throw new IllegalArgumentException("name must not be null");
        } else if (attractionRequest.getValidityTicket() == null) {
            log.error("Cannot create new Attraction with null validityTicket");
            throw new IllegalArgumentException("validityTicket must not be null");
        } else if (attractionRequest.getMaxTicketsNumber() == null) {
            log.error("Cannot create new Attraction with null maxTicketsNumber");
            throw new IllegalArgumentException("maxTicketsNumber must not be null");
        }
        else {
            AttractionEntity attractionEntity = new AttractionEntity();

            attractionEntity.setName(attractionRequest.getName());
            attractionEntity.setDescription(attractionRequest.getDescription());
            attractionEntity.setValidityTicket(attractionRequest.getValidityTicket());
            attractionEntity.setSoldTicketsNumber(0);
            attractionEntity.setTotalSoldTicketsNumber(0);
            attractionEntity.setMaxTicketsNumber(attractionRequest.getMaxTicketsNumber());

            attractionRepository.save(attractionEntity);

            log.info("Made a POST request for creating a new Attraction with idAttraction: {}", attractionEntity.getIdAttraction());

            return AttractionMapper.INSTANCE.toDTO(attractionEntity);
        }
    }

    @Override
    public AttractionDTO getAttractionById(UUID idAttraction) {
        AttractionEntity attractionEntity = attractionRepository.findById(idAttraction).orElseThrow(() -> new EntityNotFoundException("ERROR: Attraction not found with idAttraction: " + idAttraction));

        log.info("Made a GET BY ID request for idAttraction: {}", attractionEntity.getIdAttraction());

        return AttractionMapper.INSTANCE.toDTO(attractionEntity);
    }

    @Override
    public AttractionDTO getAttractionByName(String name) {
        AttractionEntity attractionEntity = attractionRepository.findByName(name).orElseThrow(() -> new EntityNotFoundException("ERROR: Attraction not found with name: " + name));

        log.info("Made a GET BY NAME request for name: {}", attractionEntity.getName());

        return AttractionMapper.INSTANCE.toDTO(attractionEntity);
    }


    @Override
    public List<AttractionDTO> getAllAttractions(int page, int size) {
        Pageable pageRequest = UtilsTicketone.createPageRequestUsing(page, size);
        Page<AttractionEntity> allAttractions = attractionRepository.findAll(pageRequest);

        log.info("Made a GET ALL request");

        return AttractionMapper.INSTANCE.mapToDTOs(allAttractions.toList());
    }

    @Override
    public long getCountAllAttractions() {
        return attractionRepository.count();
    }

    @Override
    public AttractionDTO updateAttraction(UUID idAttraction, AttractionRequest attractionRequest) {
        if (attractionRequest.getName() == null) {
            log.error("Cannot update new Attraction with null name");
            throw new IllegalArgumentException("name must not be null");
        } else if (attractionRequest.getValidityTicket() == null) {
            log.error("Cannot update new Attraction with null validityTicket");
            throw new IllegalArgumentException("validityTicket must not be null");
        } else if (attractionRequest.getMaxTicketsNumber() == null) {
            log.error("Cannot update new Attraction with null maxTicketsNumber");
            throw new IllegalArgumentException("maxTicketsNumber must not be null");
        }
        else {

            AttractionEntity attractionEntity = attractionRepository.findById(idAttraction).orElseThrow(() -> new EntityNotFoundException("ERROR: User not found with idUser: " + idAttraction));

            attractionEntity.setName(attractionRequest.getName());
            attractionEntity.setDescription(attractionRequest.getDescription());
            attractionEntity.setValidityTicket(attractionRequest.getValidityTicket());
            attractionEntity.setMaxTicketsNumber(attractionRequest.getMaxTicketsNumber());

            attractionRepository.save(attractionEntity);

            log.info("Made a PUT request for updating an existing Attraction with idAttraction: {}", attractionEntity.getIdAttraction());

            return AttractionMapper.INSTANCE.toDTO(attractionEntity);
        }
    }

    @Override
    public void deleteAttraction(UUID idAttraction) {
        attractionRepository.findById(idAttraction).orElseThrow(() -> new EntityNotFoundException("ERROR: Attraction not found with idAttraction: " + idAttraction));

        attractionRepository.deleteById(idAttraction);

        log.info("Made a DELETE request for removing the existing Attraction with idAttraction: {}", idAttraction);
    }
}
