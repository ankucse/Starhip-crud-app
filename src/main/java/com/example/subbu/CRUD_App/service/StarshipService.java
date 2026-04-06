package com.example.subbu.CRUD_App.service;

import com.example.subbu.CRUD_App.dto.StarshipRequestDTO;
import com.example.subbu.CRUD_App.dto.StarshipResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StarshipService {
    StarshipResponseDTO createStarship(StarshipRequestDTO requestDTO);
    StarshipResponseDTO getStarshipById(String id);
    Page<StarshipResponseDTO> getAllStarships(Pageable pageable);
    StarshipResponseDTO updateStarship(String id, StarshipRequestDTO requestDTO);
    void deleteStarship(String id);
}
