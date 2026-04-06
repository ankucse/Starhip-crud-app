package com.example.subbu.CRUD_App.model.subcollections;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Reactor {
    private String coreType;
    private Double coreTemperature;
    private Double maxSafeTemperature;
    private Double currentOutput;
    private Double maxOutput;
    private Double plasmaFlowRate;
    private Double antimatterContainmentStability;
    private Double matterAntimatterRatio;
    private Boolean emergencyEjectSystemArmed;
    private String radiationShieldingMaterial;
}
