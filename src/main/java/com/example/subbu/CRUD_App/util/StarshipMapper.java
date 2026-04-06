package com.example.subbu.CRUD_App.util;

import com.example.subbu.CRUD_App.dto.StarshipRequestDTO;
import com.example.subbu.CRUD_App.dto.StarshipResponseDTO;
import com.example.subbu.CRUD_App.model.Starship;

public class StarshipMapper {

    public static Starship toEntity(StarshipRequestDTO dto) {
        if (dto == null) return null;
        return Starship.builder().build();
    }

    public static StarshipResponseDTO toDTO(Starship entity) {
        if (entity == null) return null;
        return StarshipResponseDTO.builder()
                .id(entity.getId())
                .registryNumber(entity.getRegistryNumber())
                .name(entity.getName())
                .shipClass(entity.getShipClass())
                .faction(entity.getFaction())
                .homePort(entity.getHomePort())
                .commissionDate(entity.getCommissionDate())
                .status(entity.getStatus())
                .totalMass(entity.getTotalMass())
                .lengthMeters(entity.getLengthMeters())
                .widthMeters(entity.getWidthMeters())
                .heightMeters(entity.getHeightMeters())
                .isAtmosphereCapable(entity.getIsAtmosphereCapable())
                .isFTLCapable(entity.getIsFTLCapable())
                .crewDetails(entity.getCrewDetails())
                .engineSpecs(entity.getEngineSpecs())
                .navigationSystem(entity.getNavigationSystem())
                .weaponry(entity.getWeaponry())
                .lifeSupport(entity.getLifeSupport())
                .communication(entity.getCommunication())
                .cargo(entity.getCargo())
                .maintenance(entity.getMaintenance())
                .shields(entity.getShields())
                .reactor(entity.getReactor())
                .build();
    }
}
