package zw.co.sheltons.dronestask.service.impl;

import org.springframework.stereotype.Service;
import zw.co.sheltons.dronestask.exceptions.DroneNotFoundException;
import zw.co.sheltons.dronestask.exceptions.DuplicateItemException;
import zw.co.sheltons.dronestask.model.Drone;
import zw.co.sheltons.dronestask.repository.DroneRepository;
import zw.co.sheltons.dronestask.request.DroneRequest;
import zw.co.sheltons.dronestask.service.DroneService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DroneServiceImpl implements DroneService {
    private final DroneRepository droneRepository;

    public DroneServiceImpl(DroneRepository droneRepository) {
        this.droneRepository = droneRepository;
    }

    @Override
    public DroneResponse register(DroneRequest droneRequest) {
        LocalDateTime currentDateTime = LocalDateTime.now();
        String serialNumber = droneRequest.getSerialNumber();
        if (droneRepository.existsBySerialNumber(serialNumber)){
            throw new DuplicateItemException("Drone with serial number {0} already exists", droneRequest.getSerialNumber());
        }
        Drone drone = new Drone();
        drone.setModel(droneRequest.getModel());
        drone.setBatteryLevel(droneRequest.getBatterLevel());
        drone.setState(droneRequest.getState());
        drone.setSerialNumber(droneRequest.getSerialNumber());
        drone.setDateCreated(currentDateTime);
        drone.setDateModified(currentDateTime);
        droneRepository.save(drone);
        return new DroneResponse(drone);
    }

    @Override
    public List<DroneResponse> findAvailableDrones() {
      return droneRepository.findDronesByState_Idle()
              .stream().map(DroneResponse::new)
              .collect(Collectors.toList());
    }

    @Override
    public BatteryLevelResponse checkBatterLevel(Long droneId) {
        Drone drone = droneRepository.findById(droneId)
                .orElseThrow(()-> new DroneNotFoundException("Drone with id {0} not found",droneId));
        return new BatteryLevelResponse(drone.getBatteryLevel());
    }


}
