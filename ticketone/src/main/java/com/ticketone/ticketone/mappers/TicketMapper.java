package com.ticketone.ticketone.mappers;

import com.ticketone.ticketone.dtos.TicketDTO;
import com.ticketone.ticketone.entities.TicketEntity;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TicketMapper {
    TicketMapper INSTANCE = Mappers.getMapper(TicketMapper.class);

    @Named("toEntity")
    TicketEntity toEntity(TicketDTO dto);

    @Named("toDTO")
    TicketDTO toDTO(TicketEntity entity);

    @IterableMapping(qualifiedByName = "toDTO")
    List<TicketDTO> mapToDTOs(List<TicketEntity> entities);

    @IterableMapping(qualifiedByName = "toEntity")
    List<TicketEntity> mapToEntities(List<TicketDTO> dtos);
}
