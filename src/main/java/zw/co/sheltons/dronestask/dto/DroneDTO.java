package zw.co.sheltons.dronestask.dto;


import lombok.*;
import zw.co.sheltons.dronestask.model.Drone;
import zw.co.sheltons.dronestask.model.Model;
import zw.co.sheltons.dronestask.model.State;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DroneDTO {
    private String serialNumber;
    private Model model;
    private int batteryLevel;
    private State state;

    public static DroneDTO fromDTO(Drone drone){
        DroneDTO droneDTO = new DroneDTO();
        droneDTO.setSerialNumber(drone.getSerialNumber());
        droneDTO.setState(drone.getState());
        droneDTO.setBatteryLevel(drone.getBatteryLevel());
        droneDTO.setModel(drone.getModel());
        return droneDTO;
    }
}
