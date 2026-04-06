package com.example.subbu.CRUD_App.repository;

import com.example.subbu.CRUD_App.model.Starship;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StarshipRepository extends MongoRepository<Starship, String> {
    Optional<Starship> findByRegistryNumber(String registryNumber);
}
