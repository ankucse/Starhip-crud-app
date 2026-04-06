package com.example.subbu.CRUD_App.util;

import com.example.subbu.CRUD_App.model.Starship;
import com.example.subbu.CRUD_App.model.subcollections.*;

import java.time.LocalDate;
import java.util.Random;

public class StarshipGenerator {

    private static final Random random = new Random();

    private static final String[] FACTIONS = {"US", "JPN", "IND", "GER", "UK", "FRA"};

    // Dynamically generated arrays of 1000 names per faction
    private static final String[] US_NAMES = generateNames("USS", 1000);
    private static final String[] JPN_NAMES = generateNames("IJN", 1000);
    private static final String[] IND_NAMES = generateNames("INS", 1000);
    private static final String[] GER_NAMES = generateNames("KMS", 1000);
    private static final String[] UK_NAMES = generateNames("HMS", 1000);
    private static final String[] FRA_NAMES = generateNames("FS", 1000);

    // Dynamically generated arrays of 1000 ports per faction
    private static final String[] US_PORTS = generatePorts("US Spaceport", 1000);
    private static final String[] JPN_PORTS = generatePorts("JPN Launch Facility", 1000);
    private static final String[] IND_PORTS = generatePorts("IND Space Centre", 1000);
    private static final String[] GER_PORTS = generatePorts("GER Aerospace Port", 1000);
    private static final String[] UK_PORTS = generatePorts("UK Space Command", 1000);
    private static final String[] FRA_PORTS = generatePorts("FRA Guiana Base", 1000);

    // Dynamically generated arrays of 1000 people per faction
    private static final String[] US_PEOPLE = generatePeople("US Commander", 1000);
    private static final String[] JPN_PEOPLE = generatePeople("JPN Taishō", 1000);
    private static final String[] IND_PEOPLE = generatePeople("IND Senāpati", 1000);
    private static final String[] GER_PEOPLE = generatePeople("GER Kommandant", 1000);
    private static final String[] UK_PEOPLE = generatePeople("UK Admiral", 1000);
    private static final String[] FRA_PEOPLE = generatePeople("FRA Amiral", 1000);

    // Arrays of 1000 random options for ALL other string fields
    private static final String[] SHIP_CLASSES = generateOptions(new String[]{"Explorer", "Cruiser", "Dreadnought", "Frigate", "Science Vessel"}, 1000);
    private static final String[] STATUSES = generateOptions(new String[]{"Active", "Under Maintenance", "Decommissioned", "On Mission", "Refitting"}, 1000);
    private static final String[] PROPULSION_TYPES = generateOptions(new String[]{"Matter-Antimatter", "Fusion", "Ion", "Plasma"}, 1000);
    private static final String[] FUEL_TYPES = generateOptions(new String[]{"Deuterium", "Antimatter", "Tritium", "Helium-3"}, 1000);
    private static final String[] COOLING_SYSTEMS = generateOptions(new String[]{"Liquid Helium", "Liquid Nitrogen", "Magnetic Containment"}, 1000);
    private static final String[] EMERGENCY_THRUSTERS = generateOptions(new String[]{"Chemical Solid", "Cold Gas", "Ion Micro-Thruster"}, 1000);
    
    private static final String[] NAV_COMPUTERS = generateOptions(new String[]{"Nav-Core", "Astro-Brain", "Quantum-Nav"}, 1000);
    private static final String[] BACKUP_NAV_COMPUTERS = generateOptions(new String[]{"Manual Isolinear", "Optical Backup", "Gyroscopic"}, 1000);
    private static final String[] ASTROMETRICS_SENSORS = generateOptions(new String[]{"Class-A Sensor Array", "Deep Space Scanner", "Tachyon Scanner"}, 1000);
    private static final String[] AUTOPILOT_VERSIONS = generateOptions(new String[]{"AutoPilot v1", "AutoPilot v2", "AI-Steer"}, 1000);
    private static final String[] STAR_TRACKERS = generateOptions(new String[]{"StarTracker Mk I", "StarTracker Mk II", "Celestial Mapper"}, 1000);
    
    private static final String[] WEAPON_TYPES = generateOptions(new String[]{"Phaser", "Disruptor", "Plasma Cannon", "Laser"}, 1000);
    private static final String[] POINT_DEFENSES = generateOptions(new String[]{"Auto-Turret", "Flak Cannon", "Mini-Laser"}, 1000);
    
    private static final String[] AIR_FILTRATIONS = generateOptions(new String[]{"Bio-Filter", "Carbon Scrubber", "Molecular Filter"}, 1000);
    
    private static final String[] TRANSCEIVER_MODELS = generateOptions(new String[]{"SubCom", "Quantum-Radio", "Hyper-Wave"}, 1000);
    private static final String[] ENCRYPTION_STANDARDS = generateOptions(new String[]{"Quantum AES", "Hyper-Cypher", "Sigma-Crypt"}, 1000);
    private static final String[] INTERCOM_SYSTEMS = generateOptions(new String[]{"Ship-wide Comms", "Neural-Link", "Holo-Comm"}, 1000);
    private static final String[] BEACON_FREQUENCIES = generateOptions(new String[]{"Emergency Freq", "Subspace Band", "Distress Channel"}, 1000);
    
    private static final String[] LOADING_MECHS = generateOptions(new String[]{"Anti-grav lifts", "Magnetic Cranes", "Robotic Arms"}, 1000);
    
    private static final String[] DIAGNOSTIC_SYSTEMS = generateOptions(new String[]{"DiagOS", "SysCheck", "Auto-Mech"}, 1000);
    
    private static final String[] SHIELD_GENERATORS = generateOptions(new String[]{"Deflector Grid", "Energy Matrix", "Plasma Shield"}, 1000);
    private static final String[] SHIELD_HARMONICS = generateOptions(new String[]{"Multiphasic", "Monophasic", "Harmonic Resonance"}, 1000);
    
    private static final String[] CORE_TYPES = generateOptions(new String[]{"M/A Reaction", "Tokamak Fusion", "Singularity"}, 1000);
    private static final String[] RADIATION_SHIELDS = generateOptions(new String[]{"Lead-Polymer", "Neutronium Alloy", "Duranium"}, 1000);

    /** Helper to generate 1000 variations from a base set of strings */
    private static String[] generateOptions(String[] bases, int count) {
        String[] options = new String[count];
        for (int i = 0; i < count; i++) {
            options[i] = bases[random.nextInt(bases.length)] + " Model-" + i;
        }
        return options;
    }

    /** Helper to generate 1000 unique names */
    private static String[] generateNames(String prefix, int count) {
        String[] names = new String[count];
        for (int i = 0; i < count; i++) {
            names[i] = prefix + " " + generateRandomWord(5 + random.nextInt(6)) + "-" + i;
        }
        return names;
    }

    /** Helper to generate 1000 unique ports */
    private static String[] generatePorts(String prefix, int count) {
        String[] ports = new String[count];
        for (int i = 0; i < count; i++) {
            ports[i] = prefix + " Alpha-" + i;
        }
        return ports;
    }

    /** Helper to generate 1000 unique people */
    private static String[] generatePeople(String rank, int count) {
        String[] people = new String[count];
        for (int i = 0; i < count; i++) {
            people[i] = rank + " " + generateRandomWord(4 + random.nextInt(5)) + " " + generateRandomWord(5 + random.nextInt(7));
        }
        return people;
    }

    /** Generates a pronounceable random word for procedural names */
    private static String generateRandomWord(int length) {
        char[] vowels = {'a', 'e', 'i', 'o', 'u'};
        char[] consonants = {'b', 'c', 'd', 'f', 'g', 'h', 'k', 'l', 'm', 'n', 'p', 'r', 's', 't', 'v', 'w', 'x', 'y', 'z'};
        StringBuilder sb = new StringBuilder();
        boolean isVowel = random.nextBoolean();
        for (int i = 0; i < length; i++) {
            if (isVowel) {
                sb.append(vowels[random.nextInt(vowels.length)]);
            } else {
                sb.append(consonants[random.nextInt(consonants.length)]);
            }
            isVowel = !isVowel;
        }
        return sb.substring(0, 1).toUpperCase() + sb.substring(1);
    }

    public static String generateRegistryNumber(String faction) {
        int randomNumber = 1000 + random.nextInt(9000);
        return faction + "-" + randomNumber;
    }

    public static Starship generateRandomStarship() {
        String faction = FACTIONS[random.nextInt(FACTIONS.length)];

        String name = getRandomString(getNamesForFaction(faction));
        String homePort = getRandomString(getPortsForFaction(faction));
        
        String captain = getRandomString(getPeopleForFaction(faction));
        String firstOfficer = getRandomString(getPeopleForFaction(faction));
        String chiefEngineer = getRandomString(getPeopleForFaction(faction));
        String chiefMedical = getRandomString(getPeopleForFaction(faction));

        return Starship.builder()
                .faction(faction)
                .name(name)
                .shipClass(getRandomString(SHIP_CLASSES))
                .homePort(homePort)
                .commissionDate(LocalDate.now().minusYears(random.nextInt(50)).toString())
                .status(getRandomString(STATUSES))
                .totalMass(50000.0 + random.nextDouble() * 200000.0)
                .lengthMeters(100.0 + random.nextDouble() * 400.0)
                .widthMeters(50.0 + random.nextDouble() * 150.0)
                .heightMeters(20.0 + random.nextDouble() * 80.0)
                .isAtmosphereCapable(random.nextBoolean())
                .isFTLCapable(random.nextBoolean())
                .crewDetails(generateCrewDetails(captain, firstOfficer, chiefEngineer, chiefMedical))
                .engineSpecs(generateEngineSpecs())
                .navigationSystem(generateNavigationSystem())
                .weaponry(generateWeaponry())
                .lifeSupport(generateLifeSupport())
                .communication(generateCommunication())
                .cargo(generateCargo())
                .maintenance(generateMaintenance())
                .shields(generateShields())
                .reactor(generateReactor())
                .build();
    }

    private static CrewDetails generateCrewDetails(String cap, String fo, String ce, String cmo) {
        int maxCap = 100 + random.nextInt(900);
        return CrewDetails.builder()
                .maxCapacity(maxCap)
                .currentCrew(maxCap - random.nextInt(50))
                .officersCount(20 + random.nextInt(30))
                .enlistedCount(maxCap - 100)
                .medicalStaff(5 + random.nextInt(15))
                .securityPersonnel(10 + random.nextInt(40))
                .engineeringTeam(30 + random.nextInt(50))
                .scienceOfficers(15 + random.nextInt(35))
                .captainName(cap)
                .firstOfficerName(fo)
                .chiefEngineerName(ce)
                .chiefMedicalOfficerName(cmo)
                .build();
    }

    private static EngineSpecs generateEngineSpecs() {
        return EngineSpecs.builder()
                .primaryPropulsionType(getRandomString(PROPULSION_TYPES))
                .maxWarpSpeed(5.0 + random.nextDouble() * 4.9)
                .cruisingSpeed(3.0 + random.nextDouble() * 4.0)
                .totalThrust(100000 + random.nextInt(400000))
                .fuelType(getRandomString(FUEL_TYPES))
                .fuelCapacity(10000.0 + random.nextDouble() * 40000.0)
                .currentFuelLevel(5000.0 + random.nextDouble() * 30000.0)
                .engineCount(2 + random.nextInt(4))
                .coolingSystemType(getRandomString(COOLING_SYSTEMS))
                .coolingEfficiency(0.8 + random.nextDouble() * 0.19)
                .emergencyThrusterType(getRandomString(EMERGENCY_THRUSTERS))
                .hyperspaceCapable(random.nextBoolean())
                .build();
    }

    private static NavigationSystem generateNavigationSystem() {
        return NavigationSystem.builder()
                .primaryNavComputer(getRandomString(NAV_COMPUTERS))
                .backupNavComputer(getRandomString(BACKUP_NAV_COMPUTERS))
                .astrometricsSensorType(getRandomString(ASTROMETRICS_SENSORS))
                .autopilotEnabled(random.nextBoolean())
                .autopilotVersion(getRandomString(AUTOPILOT_VERSIONS))
                .courseCorrectionSpeed(1.0 + random.nextDouble() * 2.0)
                .hazardAvoidanceSystem(random.nextBoolean())
                .starTrackerModel(getRandomString(STAR_TRACKERS))
                .mappingRange(10.0 + random.nextDouble() * 90.0)
                .subspaceBeaconActive(random.nextBoolean())
                .build();
    }

    private static Weaponry generateWeaponry() {
        return Weaponry.builder()
                .primaryPhaserBanks(2 + random.nextInt(6))
                .secondaryPhaserBanks(1 + random.nextInt(4))
                .torpedoTubes(1 + random.nextInt(3))
                .torpedoInventory(50 + random.nextInt(150))
                .primaryWeaponType(getRandomString(WEAPON_TYPES))
                .targetingAccuracy(0.85 + random.nextDouble() * 0.14)
                .maxWeaponRange(100000.0 + random.nextDouble() * 200000.0)
                .autoTargetingEnabled(random.nextBoolean())
                .pointDefenseSystem(getRandomString(POINT_DEFENSES))
                .weaponCoolingRate(30.0 + random.nextDouble() * 40.0)
                .build();
    }

    private static LifeSupport generateLifeSupport() {
        return LifeSupport.builder()
                .oxygenLevel(20.0 + random.nextDouble() * 2.0)
                .carbonDioxideLevel(0.01 + random.nextDouble() * 0.05)
                .temperatureCelsius(20.0 + random.nextDouble() * 4.0)
                .humidityPercentage(40.0 + random.nextDouble() * 20.0)
                .airFiltrationType(getRandomString(AIR_FILTRATIONS))
                .co2ScrubberCount(5 + random.nextInt(10))
                .waterRecyclingEfficiency(0.90 + random.nextDouble() * 0.09)
                .potableWaterStorage(5000.0 + random.nextDouble() * 10000.0)
                .currentPotableWater(2000.0 + random.nextDouble() * 8000.0)
                .emergencyOxygenDeployed(false)
                .build();
    }

    private static Communication generateCommunication() {
        return Communication.builder()
                .subspaceTransceiverModel(getRandomString(TRANSCEIVER_MODELS))
                .maxCommRange(10.0 + random.nextDouble() * 90.0)
                .encryptionEnabled(true)
                .encryptionStandard(getRandomString(ENCRYPTION_STANDARDS))
                .antennaCount(2 + random.nextInt(4))
                .internalIntercomSystem(getRandomString(INTERCOM_SYSTEMS))
                .distressBeaconActive(false)
                .distressBeaconFrequency(getRandomString(BEACON_FREQUENCIES))
                .signalStrength(50.0 + random.nextDouble() * 50.0)
                .universalTranslatorActive(random.nextBoolean())
                .build();
    }

    private static Cargo generateCargo() {
        return Cargo.builder()
                .maxCargoCapacity(2000.0 + random.nextDouble() * 8000.0)
                .currentCargoWeight(500.0 + random.nextDouble() * 3000.0)
                .cargoBayCount(2 + random.nextInt(5))
                .hazardContainmentAvailable(random.nextBoolean())
                .refrigerationCapacity(200.0 + random.nextDouble() * 800.0)
                .currentRefrigeratedCargo(50.0 + random.nextDouble() * 300.0)
                .loadingMechType(getRandomString(LOADING_MECHS))
                .transporterPadCount(2 + random.nextInt(4))
                .transporterRange(20000.0 + random.nextDouble() * 30000.0)
                .smugglingCompartmentsPresent(random.nextBoolean()) // A fun metric
                .build();
    }

    private static Maintenance generateMaintenance() {
        return Maintenance.builder()
                .lastOverhaulDate(LocalDate.now().minusDays(random.nextInt(1000)).toString())
                .nextScheduledMaintenance(LocalDate.now().plusDays(random.nextInt(365)).toString())
                .hullIntegrity(70.0 + random.nextDouble() * 30.0)
                .repairDroneCount(5 + random.nextInt(15))
                .selfRepairCapable(random.nextBoolean())
                .selfRepairRate(1.0 + random.nextDouble() * 5.0)
                .diagnosticSystemVersion(getRandomString(DIAGNOSTIC_SYSTEMS))
                .criticalAlertsCount(random.nextInt(3))
                .warningAlertsCount(random.nextInt(10))
                .quarantined(false)
                .build();
    }

    private static Shields generateShields() {
        return Shields.builder()
                .shieldGeneratorType(getRandomString(SHIELD_GENERATORS))
                .maxShieldCapacity(50000.0 + random.nextDouble() * 100000.0)
                .forwardShieldStrength(50.0 + random.nextDouble() * 50.0)
                .aftShieldStrength(50.0 + random.nextDouble() * 50.0)
                .portShieldStrength(50.0 + random.nextDouble() * 50.0)
                .starboardShieldStrength(50.0 + random.nextDouble() * 50.0)
                .shieldRegenRate(5.0 + random.nextDouble() * 10.0)
                .shieldHarmonicsFrequency(getRandomString(SHIELD_HARMONICS))
                .cloakingDevicePresent(random.nextBoolean())
                .cloakingDeviceActive(false)
                .build();
    }

    private static Reactor generateReactor() {
        return Reactor.builder()
                .coreType(getRandomString(CORE_TYPES))
                .coreTemperature(3000.0 + random.nextDouble() * 4000.0)
                .maxSafeTemperature(8000.0 + random.nextDouble() * 2000.0)
                .currentOutput(400.0 + random.nextDouble() * 400.0)
                .maxOutput(1000.0 + random.nextDouble() * 500.0)
                .plasmaFlowRate(200.0 + random.nextDouble() * 200.0)
                .antimatterContainmentStability(95.0 + random.nextDouble() * 4.9)
                .matterAntimatterRatio(1.0)
                .emergencyEjectSystemArmed(true)
                .radiationShieldingMaterial(getRandomString(RADIATION_SHIELDS))
                .build();
    }

    private static String[] getNamesForFaction(String faction) {
        switch (faction) {
            case "US": return US_NAMES;
            case "JPN": return JPN_NAMES;
            case "IND": return IND_NAMES;
            case "GER": return GER_NAMES;
            case "UK": return UK_NAMES;
            case "FRA": return FRA_NAMES;
            default: return US_NAMES;
        }
    }

    private static String[] getPortsForFaction(String faction) {
        switch (faction) {
            case "US": return US_PORTS;
            case "JPN": return JPN_PORTS;
            case "IND": return IND_PORTS;
            case "GER": return GER_PORTS;
            case "UK": return UK_PORTS;
            case "FRA": return FRA_PORTS;
            default: return US_PORTS;
        }
    }

    private static String[] getPeopleForFaction(String faction) {
        switch (faction) {
            case "US": return US_PEOPLE;
            case "JPN": return JPN_PEOPLE;
            case "IND": return IND_PEOPLE;
            case "GER": return GER_PEOPLE;
            case "UK": return UK_PEOPLE;
            case "FRA": return FRA_PEOPLE;
            default: return US_PEOPLE;
        }
    }

    private static String getRandomString(String[] array) {
        return array[random.nextInt(array.length)];
    }
}
