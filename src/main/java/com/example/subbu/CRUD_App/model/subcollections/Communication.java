package com.example.subbu.CRUD_App.model.subcollections;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Communication {
    private String subspaceTransceiverModel;
    private Double maxCommRange;
    private Boolean encryptionEnabled;
    private String encryptionStandard;
    private Integer antennaCount;
    private String internalIntercomSystem;
    private Boolean distressBeaconActive;
    private String distressBeaconFrequency;
    private Double signalStrength;
    private Boolean universalTranslatorActive;
}
