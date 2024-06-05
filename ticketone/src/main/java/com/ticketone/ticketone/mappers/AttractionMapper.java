package com.ticketone.ticketone.mappers;

import com.ticketone.ticketone.dtos.AttractionDTO;
import com.ticketone.ticketone.entities.AttractionEntity;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AttractionMapper {
    AttractionMapper INSTANCE = Mappers.getMapper(AttractionMapper.class);

    @Named("toEntity")
    AttractionEntity toEntity(AttractionDTO dto);

    @Named("toDTO")
    AttractionDTO toDTO(AttractionEntity entity);

    @IterableMapping(qualifiedByName = "toDTO")
    List<AttractionDTO> mapToDTOs(List<AttractionEntity> entities);

    @IterableMapping(qualifiedByName = "toEntity")
    List<AttractionEntity> mapToEntities(List<AttractionDTO> dtos);
}
