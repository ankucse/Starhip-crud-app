package com.example.subbu.CRUD_App.model.subcollections;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LifeSupport {
    private Double oxygenLevel;
    private Double carbonDioxideLevel;
    private Double temperatureCelsius;
    private Double humidityPercentage;
    private String airFiltrationType;
    private Integer co2ScrubberCount;
    private Double waterRecyclingEfficiency;
    private Double potableWaterStorage;
    private Double currentPotableWater;
    private Boolean emergencyOxygenDeployed;
}
