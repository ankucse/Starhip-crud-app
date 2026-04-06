package com.example.subbu.CRUD_App.model.subcollections;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EngineSpecs {
    private String primaryPropulsionType;
    private Double maxWarpSpeed;
    private Double cruisingSpeed;
    private Integer totalThrust;
    private String fuelType;
    private Double fuelCapacity;
    private Double currentFuelLevel;
    private Integer engineCount;
    private String coolingSystemType;
    private Double coolingEfficiency;
    private String emergencyThrusterType;
    private Boolean hyperspaceCapable;
}
