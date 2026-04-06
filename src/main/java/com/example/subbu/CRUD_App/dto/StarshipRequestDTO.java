package com.example.subbu.CRUD_App.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Empty Request DTO since all data is now auto-generated upon triggering the POST request.
 */
@Data
@NoArgsConstructor
public class StarshipRequestDTO {
    // Left empty intentionally.
    // The user simply triggers POST /api/starships
    // and the server auto-generates all 100+ fields based on random but logically tied faction data.
}
