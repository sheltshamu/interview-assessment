package zw.co.sheltons.dronestask.service;

import org.springframework.web.multipart.MultipartFile;
import zw.co.sheltons.dronestask.request.DroneRequest;
import zw.co.sheltons.dronestask.dto.BatteryLevelDTO;
import zw.co.sheltons.dronestask.service.impl.drone.DroneResponse;
import zw.co.sheltons.dronestask.request.MedicationRequest;

import java.util.List;

public interface DroneService {
    DroneResponse register(DroneRequest droneRequest);
    List<DroneResponse> findAvailableDrones();
    BatteryLevelDTO checkBatteryLevel(Long droneId);
    DroneResponse loadDrone(MedicationRequest medicationRequest,MultipartFile multipartFile);
}
