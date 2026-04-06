package com.example.subbu.CRUD_App.model;

import com.example.subbu.CRUD_App.model.subcollections.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * MongoDB Main Document for Starship.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "starships")
public class Starship {

    @Id
    private String id;

    @Indexed(unique = true)
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
