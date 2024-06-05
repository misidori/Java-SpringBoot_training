package com.ticketone.ticketone.mappers;

import com.ticketone.ticketone.dtos.UserDTO;
import com.ticketone.ticketone.entities.UserEntity;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Named("toEntity")
    UserEntity toEntity(UserDTO dto);

    @Named("toDTO")
    UserDTO toDTO(UserEntity entity);

    @IterableMapping(qualifiedByName = "toDTO")
    List<UserDTO> mapToDTOs(List<UserEntity> entities);

    @IterableMapping(qualifiedByName = "toEntity")
    List<UserEntity> mapToEntities(List<UserDTO> dtos);
}
