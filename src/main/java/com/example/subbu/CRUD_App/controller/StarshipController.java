package com.example.subbu.CRUD_App.controller;

import com.example.subbu.CRUD_App.dto.StarshipRequestDTO;
import com.example.subbu.CRUD_App.dto.StarshipResponseDTO;
import com.example.subbu.CRUD_App.service.StarshipService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/starships")
@RequiredArgsConstructor
public class StarshipController {

    private final StarshipService starshipService;

    // The user triggers this API with an empty body {}
    @PostMapping
    public ResponseEntity<StarshipResponseDTO> createStarship() {
        log.info("Received request to automatically generate and create a new starship.");
        StarshipResponseDTO createdStarship = starshipService.createStarship(new StarshipRequestDTO());
        log.info("Finished processing create request. Status: 201 CREATED");
        return new ResponseEntity<>(createdStarship, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StarshipResponseDTO> getStarshipById(@PathVariable String id) {
        log.info("Received request to get starship with ID: {}", id);
        StarshipResponseDTO starship = starshipService.getStarshipById(id);
        log.info("Finished processing get by id request. Status: 200 OK");
        return ResponseEntity.ok(starship);
    }

    @GetMapping
    public ResponseEntity<Page<StarshipResponseDTO>> getAllStarships(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy) {
        log.info("Received request to get all starships. Page: {}, Size: {}, SortBy: {}", page, size, sortBy);

        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        Page<StarshipResponseDTO> starshipsPage = starshipService.getAllStarships(pageable);
        
        log.info("Finished processing get all request. Status: 200 OK");
        return ResponseEntity.ok(starshipsPage);
    }

    // Since it's fully auto-generated, updates are not strictly logical for this context unless partially changed.
    @PutMapping("/{id}")
    public ResponseEntity<StarshipResponseDTO> updateStarship(@PathVariable String id) {
        log.info("Received request to update starship with ID: {}", id);
        StarshipResponseDTO updatedStarship = starshipService.updateStarship(id, new StarshipRequestDTO());
        log.info("Finished processing update request. Status: 200 OK");
        return ResponseEntity.ok(updatedStarship);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStarship(@PathVariable String id) {
        log.info("Received request to delete starship with ID: {}", id);
        starshipService.deleteStarship(id);
        log.info("Finished processing delete request. Status: 204 NO CONTENT");
        return ResponseEntity.noContent().build();
    }
}
