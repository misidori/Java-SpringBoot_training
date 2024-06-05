package com.ticketone.ticketone.services;

import com.ticketone.ticketone.dtos.UserDTO;
import com.ticketone.ticketone.entities.UserEntity;
import com.ticketone.ticketone.mappers.UserMapper;
import com.ticketone.ticketone.models.UserRequest;
import com.ticketone.ticketone.repositories.UserRepository;
import com.ticketone.ticketone.utils.UtilsTicketone;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public Optional<UserDTO> createUser(UserRequest userRequest) {
        UserEntity userEntity = new UserEntity();

        if (userRequest.getName() == null || userRequest.getEmail() == null) {
            log.error("Cannot create new User with null parameters");
            throw new IllegalArgumentException("User must not have null fields");
        } else {
            userEntity.setName(userRequest.getName());
            userEntity.setEmail(userRequest.getEmail());

            userRepository.save(userEntity);

            log.info("Made a POST request for creating a new User with idUser: {}", userEntity.getIdUser());
        }

        return Optional.of(UserMapper.INSTANCE.toDTO(userEntity));
    }

    @Override
    public UserDTO getUserById(UUID idUser) {
        UserEntity userEntity = userRepository.findById(idUser).orElseThrow(() -> new EntityNotFoundException("ERROR: User not found with idUser: " + idUser));

        log.info("Made a GET BY ID request for idUser: {}", userEntity.getIdUser());

        return UserMapper.INSTANCE.toDTO(userEntity);
    }

    @Override
    public UserDTO getUserByName(String name) {
        UserEntity userEntity = userRepository.findByName(name).orElseThrow(() -> new EntityNotFoundException("ERROR: User not found with name: " + name));

        log.info("Made a GET BY NAME request for name: {}", userEntity.getName());

        return UserMapper.INSTANCE.toDTO(userEntity);
    }

    @Override
    public UserDTO updateUser(UUID idUser, UserRequest userRequest) {
        UserEntity userEntity = userRepository.findById(idUser).orElseThrow(() -> new EntityNotFoundException("ERROR: User not found with idUser: " + idUser));

        userEntity.setName(userRequest.getName());
        userEntity.setEmail(userRequest.getEmail());

        UserEntity updatedUserEntity = userRepository.save(userEntity);

        log.info("Made a PUT request for updating an existing User with idUser: {}", userEntity.getIdUser());

        return UserMapper.INSTANCE.toDTO(updatedUserEntity);
    }

    @Override
    public List<UserDTO> getAllUsers(int page, int size) {
        Pageable pageRequest = UtilsTicketone.createPageRequestUsing(page, size);
        Page<UserEntity> allUsers = userRepository.findAll(pageRequest);

        log.info("Made a GET ALL request");

        return UserMapper.INSTANCE.mapToDTOs(allUsers.toList());
    }

    @Override
    public long getCountAllUsers() {
        return userRepository.count();
    }

    public void deleteUser(UUID idUser) {
        userRepository.findById(idUser).orElseThrow(() -> new EntityNotFoundException("ERROR: User not found with idUser: " + idUser));

        userRepository.deleteById(idUser);

        log.info("Made a DELETE request for an existing User with idUser: {}", idUser);
    }
}
