package zw.co.sheltons.dronestask.service;

import zw.co.sheltons.dronestask.request.DroneRequest;
import zw.co.sheltons.dronestask.service.impl.drone.BatteryLevelResponse;
import zw.co.sheltons.dronestask.service.impl.drone.DroneResponse;
import zw.co.sheltons.dronestask.service.impl.medication.MedicationRequest;

import java.util.List;

public interface DroneService {
    DroneResponse register(DroneRequest droneRequest);
    List<DroneResponse> findAvailableDrones();
    BatteryLevelResponse checkBatteryLevel(Long droneId);
    DroneResponse loadDrone(MedicationRequest medicationRequest);
}
