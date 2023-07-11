package zw.co.sheltons.dronestask.service;

import zw.co.sheltons.dronestask.request.DroneRequest;
import zw.co.sheltons.dronestask.service.impl.BatteryLevelResponse;
import zw.co.sheltons.dronestask.service.impl.DroneResponse;

import java.util.List;

public interface DroneService {
    DroneResponse register(DroneRequest droneRequest);
    List<DroneResponse> findAvailableDrones();
    BatteryLevelResponse checkBatterLevel(Long droneId);
}
