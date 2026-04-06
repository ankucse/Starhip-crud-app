package com.example.subbu.CRUD_App.model.subcollections;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NavigationSystem {
    private String primaryNavComputer;
    private String backupNavComputer;
    private String astrometricsSensorType;
    private Boolean autopilotEnabled;
    private String autopilotVersion;
    private Double courseCorrectionSpeed;
    private Boolean hazardAvoidanceSystem;
    private String starTrackerModel;
    private Double mappingRange;
    private Boolean subspaceBeaconActive;
}
