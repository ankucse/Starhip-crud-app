package com.example.subbu.CRUD_App.model.subcollections;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Cargo {
    private Double maxCargoCapacity;
    private Double currentCargoWeight;
    private Integer cargoBayCount;
    private Boolean hazardContainmentAvailable;
    private Double refrigerationCapacity;
    private Double currentRefrigeratedCargo;
    private String loadingMechType;
    private Integer transporterPadCount;
    private Double transporterRange;
    private Boolean smugglingCompartmentsPresent;
}
