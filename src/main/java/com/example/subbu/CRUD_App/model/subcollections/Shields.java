package com.example.subbu.CRUD_App.model.subcollections;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Shields {
    private String shieldGeneratorType;
    private Double maxShieldCapacity;
    private Double forwardShieldStrength;
    private Double aftShieldStrength;
    private Double portShieldStrength;
    private Double starboardShieldStrength;
    private Double shieldRegenRate;
    private String shieldHarmonicsFrequency;
    private Boolean cloakingDevicePresent;
    private Boolean cloakingDeviceActive;
}
