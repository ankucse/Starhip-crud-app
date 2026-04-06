package com.example.subbu.CRUD_App.model.subcollections;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Weaponry {
    private Integer primaryPhaserBanks;
    private Integer secondaryPhaserBanks;
    private Integer torpedoTubes;
    private Integer torpedoInventory;
    private String primaryWeaponType;
    private Double targetingAccuracy;
    private Double maxWeaponRange;
    private Boolean autoTargetingEnabled;
    private String pointDefenseSystem;
    private Double weaponCoolingRate;
}
