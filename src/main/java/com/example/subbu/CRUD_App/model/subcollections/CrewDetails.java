package com.example.subbu.CRUD_App.model.subcollections;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CrewDetails {
    private Integer maxCapacity;
    private Integer currentCrew;
    private Integer officersCount;
    private Integer enlistedCount;
    private Integer medicalStaff;
    private Integer securityPersonnel;
    private Integer engineeringTeam;
    private Integer scienceOfficers;
    private String captainName;
    private String firstOfficerName;
    private String chiefEngineerName;
    private String chiefMedicalOfficerName;
}
