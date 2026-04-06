package com.example.subbu.CRUD_App.dto;

import com.example.subbu.CRUD_App.model.subcollections.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StarshipResponseDTO {

    private String id;
    private String registryNumber;
    private String name;
    private String shipClass;
    private String faction;
    private String homePort;
    private String commissionDate;
    private String status;
    private Double totalMass;
    private Double lengthMeters;
    private Double widthMeters;
    private Double heightMeters;
    private Boolean isAtmosphereCapable;
    private Boolean isFTLCapable;

    private CrewDetails crewDetails;
    private EngineSpecs engineSpecs;
    private NavigationSystem navigationSystem;
    private Weaponry weaponry;
    private LifeSupport lifeSupport;
    private Communication communication;
    private Cargo cargo;
    private Maintenance maintenance;
    private Shields shields;
    private Reactor reactor;
}
