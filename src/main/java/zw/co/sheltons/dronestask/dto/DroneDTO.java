package zw.co.sheltons.dronestask.dto;


import lombok.*;
import zw.co.sheltons.dronestask.model.Drone;
import zw.co.sheltons.dronestask.model.enums.Model;
import zw.co.sheltons.dronestask.model.enums.State;

@Getter
@Setter
public class DroneDTO {
    private Long id;
    private String serialNumber;
    private Model model;
    private int batteryLevel;
    private State state;

    public static DroneDTO fromDTO(Drone drone){
        DroneDTO droneDTO = new DroneDTO();
        droneDTO.setId(drone.getId());
        droneDTO.setSerialNumber(drone.getSerialNumber());
        droneDTO.setState(drone.getState());
        droneDTO.setBatteryLevel(drone.getBatteryLevel());
        droneDTO.setModel(drone.getModel());
        return droneDTO;
    }
}
