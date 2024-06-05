package com.ticketone.ticketone.services;

import com.ticketone.ticketone.dtos.TicketDTO;
import com.ticketone.ticketone.entities.AttractionEntity;
import com.ticketone.ticketone.entities.TicketEntity;
import com.ticketone.ticketone.entities.UserEntity;
import com.ticketone.ticketone.mappers.TicketMapper;
import com.ticketone.ticketone.models.TicketPutRequest;
import com.ticketone.ticketone.models.TicketPostRequest;
import com.ticketone.ticketone.repositories.AttractionRepository;
import com.ticketone.ticketone.repositories.TicketRepository;
import com.ticketone.ticketone.repositories.UserRepository;
import com.ticketone.ticketone.utils.UtilsTicketone;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    TicketRepository ticketRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    AttractionRepository attractionRepository;

    @Override
    public TicketDTO createTicket(TicketPostRequest ticketPostRequest) {
        UUID idUser = ticketPostRequest.getIdUser();
        UUID idAttraction = ticketPostRequest.getIdAttraction();
        TicketEntity ticketEntity = new TicketEntity();

        if (idUser == null) {
            log.error("ERROR: Cannot create new Ticket with null idUser");
            throw new IllegalArgumentException("idUser must not be null");
        } else if (idAttraction == null) {
            log.error("ERROR: Cannot create new Ticket with null idAttraction");
            throw new IllegalArgumentException("idAttraction must not be null");
        } else if (ticketPostRequest.getCallDate().isBefore(LocalDateTime.now())) {
            log.error("ERROR: Cannot create new Ticket with old CallDate");
            throw new IllegalArgumentException("CallDate must be after now time");
        }
        else {
            AttractionEntity attraction = attractionRepository.findById(idAttraction).orElseThrow(() -> new EntityNotFoundException("ERROR: Attraction not found with idAttraction: " + ticketPostRequest.getIdAttraction()));
            UserEntity user = userRepository.findById(idUser).orElseThrow(() -> new EntityNotFoundException("ERROR: User not found with idUser: " + ticketPostRequest.getIdUser()));

            if (attraction.getSoldTicketsNumber() >= attraction.getMaxTicketsNumber()) {
                throw new IllegalArgumentException("ERROR: Maximum number of tickets for this attraction has been reached.");
            }

            LocalDateTime emissionDate = LocalDateTime.now();
            String strIdAttraction = attraction.getIdAttraction().toString();

            attraction.setSoldTicketsNumber(attraction.getSoldTicketsNumber() + 1);
            attraction.setTotalSoldTicketsNumber(attraction.getTotalSoldTicketsNumber() + 1);
            attractionRepository.save(attraction);

            ticketEntity.setUser(user);
            ticketEntity.setAttraction(attraction);
            ticketEntity.setNumber(strIdAttraction.substring(0, 3) + "-" + attraction.getTotalSoldTicketsNumber());
            ticketEntity.setEmissionDate(emissionDate);
            ticketEntity.setCallDate(ticketPostRequest.getCallDate());
            ticketEntity.setExpirationDate(ticketPostRequest.getCallDate().plusDays(attraction.getValidityTicket()));
            ticketRepository.save(ticketEntity);
            log.info("Creating new Ticket with idTicket: " + ticketEntity.getIdTicket());
        }
        return TicketMapper.INSTANCE.toDTO(ticketEntity);
    }


    @Override
    public TicketDTO getTicketById(UUID idTicket) {
        TicketEntity ticketEntity = ticketRepository.findById(idTicket).orElseThrow(() -> new EntityNotFoundException("ERROR: Ticket not found with idTicket: " + idTicket));

        log.info("Made a GET BY ID request for idTicket: {}", idTicket);

        return TicketMapper.INSTANCE.toDTO(ticketEntity);
    }


    @Override
    public List<TicketDTO> getAllTickets(int page, int size) {
        Pageable pageRequest = UtilsTicketone.createPageRequestUsing(page, size);
        Page<TicketEntity> allTickets = ticketRepository.findAll(pageRequest);

        log.info("Made a GET ALL request");

        return TicketMapper.INSTANCE.mapToDTOs(allTickets.toList());
    }

    @Override
    public long getCountAllTickets() {
        return userRepository.count();
    }

    @Override
    public TicketDTO updateTicket(UUID idTicket, TicketPutRequest ticketPutRequest) {
        TicketEntity ticketEntity = ticketRepository.findById(idTicket).orElseThrow(() -> new EntityNotFoundException("ERROR: Ticket not found with idTicket: " + idTicket));
        UserEntity userEntity = userRepository.findById(ticketPutRequest.getIdUser()).orElseThrow(() -> new EntityNotFoundException("ERROR: User not found with idUser: " + idTicket));

        ticketEntity.setUser(userEntity);

        TicketEntity updatedTicketEntity = ticketRepository.save(ticketEntity);

        log.info("Made a PUT request for updating an existing Ticket with idTicket: {}", idTicket);

        return TicketMapper.INSTANCE.toDTO(updatedTicketEntity);
    }

    @Override
    public void deleteTicket(UUID idTicket) {
        TicketEntity ticketEntity = ticketRepository.findById(idTicket).orElseThrow(() -> new EntityNotFoundException("ERROR: Ticket not found with idTicket: " + idTicket));

        ticketRepository.deleteById(idTicket);

        UUID idAttraction = ticketEntity.getAttraction().getIdAttraction();

        AttractionEntity attractionEntity = attractionRepository.findById(idAttraction).orElse(null);
        if (attractionEntity != null) {
            attractionEntity.setSoldTicketsNumber(attractionEntity.getSoldTicketsNumber() - 1);
            attractionRepository.save(attractionEntity);
        } else {
            log.error("ERROR: Attraction not found with idAttraction: " + idAttraction);
        }

        log.info("Made a DELETE request for an existing Ticket with idTicket: {}", idTicket);
    }

}
