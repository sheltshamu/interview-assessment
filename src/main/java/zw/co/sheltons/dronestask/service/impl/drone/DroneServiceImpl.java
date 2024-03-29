package zw.co.sheltons.dronestask.service.impl.drone;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import zw.co.sheltons.dronestask.dto.BatteryLevelDTO;
import zw.co.sheltons.dronestask.exceptions.BadRequestException;
import zw.co.sheltons.dronestask.exceptions.DuplicateItemException;
import zw.co.sheltons.dronestask.exceptions.ItemNotFoundException;
import zw.co.sheltons.dronestask.model.Drone;
import zw.co.sheltons.dronestask.model.Medication;
import zw.co.sheltons.dronestask.model.enums.State;
import zw.co.sheltons.dronestask.repository.DroneRepository;
import zw.co.sheltons.dronestask.repository.MedicationRepository;
import zw.co.sheltons.dronestask.request.DroneRequest;
import zw.co.sheltons.dronestask.request.MedicationRequest;
import zw.co.sheltons.dronestask.service.DroneService;
import zw.co.sheltons.dronestask.service.ImageService;
import zw.co.sheltons.dronestask.service.impl.image.ImageResponse;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class DroneServiceImpl implements DroneService {
    private final DroneRepository droneRepository;
    private final MedicationRepository medicationRepository;
    private final ImageService imageService;
    private final static int BATTERY_LOW_LEVEL = 25;

    public DroneServiceImpl(DroneRepository droneRepository, MedicationRepository medicationRepository, ImageService imageService) {
        this.droneRepository = droneRepository;
        this.medicationRepository = medicationRepository;
        this.imageService = imageService;
    }

    @Override
    public DroneResponse register(DroneRequest droneRequest) {
        LocalDateTime currentDateTime = LocalDateTime.now();
        String serialNumber = droneRequest.getSerialNumber();
        if (droneRepository.existsBySerialNumber(serialNumber)) {
            throw new DuplicateItemException("Drone with serial number {0} already exists", droneRequest.getSerialNumber());
        }
        Drone drone = new Drone();
        drone.setModel(droneRequest.getModel());
        drone.setBatteryLevel(droneRequest.getBatteryLevel());
        drone.setState(droneRequest.getState());
        drone.setSerialNumber(droneRequest.getSerialNumber());
        drone.setWeightLimit(droneRequest.getWeightLimit());
        drone.setDateCreated(currentDateTime);
        drone.setDateModified(currentDateTime);
        droneRepository.save(drone);
        return new DroneResponse(drone);
    }

    @Override
    public List<DroneResponse> findAvailableDrones() {
        return droneRepository.findDronesByState(State.IDLE)
                .stream().map(DroneResponse::new)
                .collect(Collectors.toList());
    }

    @Override
    public BatteryLevelDTO checkBatteryLevel(Long droneId) {
        Drone drone = findById(droneId);
        return new BatteryLevelDTO(drone.getBatteryLevel(), drone.getSerialNumber());
    }

    @Transactional
    @Override
    public DroneResponse loadDrone(MedicationRequest medicationRequest) {
        log.info("DroneServiceImpl::loadDrone started executing load drone");
        LocalDateTime currentDateTime = LocalDateTime.now();
        ImageResponse imageResponse = imageService.uploadImage(medicationRequest.getImage());
        Drone drone = findById(medicationRequest.getDroneId());
        validateDroneCondition(drone, medicationRequest.getWeight());
        Medication medication = new Medication();
        medication.setDrone(drone);
        medication.setName(medicationRequest.getName());
        medication.setCode(medicationRequest.getCode().toUpperCase());
        medication.setWeight(medicationRequest.getWeight());
        medication.setImage(imageResponse.image());
        medication.setDateCreated(currentDateTime);
        medication.setDateModified(LocalDateTime.now());
        medicationRepository.save(medication);
        drone.setCurrentWeight(drone.getCurrentWeight() + medicationRequest.getWeight());
        stateChanges(drone);
        log.info("DroneServiceImpl::loadDrone finished executing load drone");
        return new DroneResponse(drone);
    }

    private Drone findById(Long droneId) {
        return droneRepository.findById(droneId)
                .orElseThrow(() -> new ItemNotFoundException("Drone with id {0} not found", droneId));

    }

    private void stateChanges(Drone drone) {
        if (drone.getWeightLimit() == drone.getCurrentWeight()) {
            drone.setState(State.LOADED);
            droneRepository.save(drone);
        }
        if (drone.getWeightLimit() > drone.getCurrentWeight() && drone.getCurrentWeight() > 1) {
            drone.setState(State.LOADING);
            droneRepository.save(drone);
        }
    }

    private void validateDroneCondition(Drone drone, int weight) {
        log.info("DroneServiceImpl::validateDroneCondition started validating drone conditions");
        if (drone.getBatteryLevel() < BATTERY_LOW_LEVEL) {
            throw new BadRequestException("Drone battery level must not be less than {0}%", BATTERY_LOW_LEVEL);
        }
        if (!(drone.getState().equals(State.IDLE) || drone.getState().equals(State.LOADING))) {
            throw new BadRequestException("Drone must be 'IDLE' or 'LOADING' state ");
        }
        if (drone.getCurrentWeight() >= drone.getWeightLimit() &&
                weight >= drone.getCurrentWeight()) {
            throw new BadRequestException("Medication weight must not exceed drone weight limit {0}",
                    drone.getWeightLimit());
        }
        log.info("DroneServiceImpl::validateDroneCondition finished validating drone conditions");
    }

}
