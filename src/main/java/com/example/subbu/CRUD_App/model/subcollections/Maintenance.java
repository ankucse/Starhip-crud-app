package com.example.subbu.CRUD_App.model.subcollections;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Maintenance {
    private String lastOverhaulDate;
    private String nextScheduledMaintenance;
    private Double hullIntegrity;
    private Integer repairDroneCount;
    private Boolean selfRepairCapable;
    private Double selfRepairRate;
    private String diagnosticSystemVersion;
    private Integer criticalAlertsCount;
    private Integer warningAlertsCount;
    private Boolean quarantined;
}
