package com.ticketone.ticketone.repositories;

import com.ticketone.ticketone.entities.AttractionEntity;
import com.ticketone.ticketone.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface AttractionRepository extends JpaRepository<AttractionEntity, UUID> {
    Optional<AttractionEntity> findByName(String name);
}